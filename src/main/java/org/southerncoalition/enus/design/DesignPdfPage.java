package org.southerncoalition.enus.design;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.southerncoalition.enus.agency.SiteAgency;
import org.southerncoalition.enus.html.part.HtmlPart;
import org.southerncoalition.enus.reportcard.ReportCard;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.state.SiteState;
import org.southerncoalition.enus.wrap.Wrap;
import org.southerncoalition.enus.writer.AllWriter;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;

import io.vertx.ext.web.api.OperationRequest;

/**
 * Translate: false
 **/
public class DesignPdfPage extends DesignPdfPageGen<DesignPdfGenPage> {

	@Override protected void _pageContentType(Wrap<String> c) {
		c.o("application/pdf");
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _w1(Wrap<AllWriter> c) {
		c.o(siteRequest_.getW());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _w2(Wrap<AllWriter> c) {
		AllWriter o = AllWriter.create(siteRequest_);
		c.o(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageDesign(Wrap<PageDesign> c) {
		if(listPageDesign.size() == 1)
			c.o(listPageDesign.get(0));
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageDesignId(Wrap<String> c) {
		if(pageDesign != null)
			c.o(pageDesign.getObjectId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _reportCardStartYear(Wrap<Integer> c) {
		Integer o = null;
		for(String var : siteRequest_.getRequestVars().keySet()) {
			String val = siteRequest_.getRequestVars().get(var);
			if("reportCardStartYear".equals(var) && StringUtils.isNotBlank(val)) {
				o = Integer.parseInt(val);
			}
		}
		if(o == null) {
			LocalDate now = LocalDate.now();
			LocalDate yearEndDate = now.with(TemporalAdjusters.firstDayOfMonth()).withMonth(6).minusYears(2);
			yearEndDate = now.isBefore(yearEndDate) ? yearEndDate : yearEndDate.plusYears(1);
			o = yearEndDate.getYear();
		}
		c.o(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _reportCardEndYear(Wrap<Integer> c) {
		c.o(reportCardStartYear + 1);
	}

	protected void _reportCardSearch(SearchList<ReportCard> l) {
		if(reportCardStartYear != null) {
			OperationRequest operationRequest = siteRequest_.getOperationRequest();
			l.setStore(true);
			l.setQuery("*:*");
			l.setC(ReportCard.class);
			l.addFilterQuery("reportCardEndYear_indexed_int:" + reportCardEndYear);
	
			l.addSort("reportCardStartYear_indexed_int", ORDER.desc);
			l.addSort("stateName_indexed_string", ORDER.asc);
			l.addSort("agencyOnlyName_indexed_string", ORDER.asc);
			l.addFacetField("reportCardStartYear_indexed_int");
			l.addFilterQuery("stateKey_indexed_long:[* TO *]");
			l.addFilterQuery("agencyKey_indexed_long:[* TO *]");
	
			Boolean filtered = false;
			for(String var : siteRequest_.getRequestVars().keySet()) {
				String val = siteRequest_.getRequestVars().get(var);
				if(!"design".equals(var) && StringUtils.isNotBlank(val)) {
					String varIndexed = ReportCard.varIndexedReportCard(var);
					if(varIndexed != null) {
						filtered = true;
						l.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(val));
					}
				}
			}
			if(filtered)
				l.setRows(1000);
			else
				l.setRows(0);
		}
	}

	protected void _reportCardStartYears(List<String> l) {
		List<Integer> years = reportCardSearch.getQueryResponse().getFacetField("reportCardStartYear_indexed_int").getValues().stream().map(o -> Integer.parseInt(o.getName())).collect(Collectors.toList());
		years.remove(reportCardStartYear);
		Collections.sort(years);
		for(Integer i = 0; i < years.size(); i++) {
			Integer year = years.get(i);
			if(i == (years.size() - 1) && years.size() > 1)
				l.add(" and " + year);
			else if(i > 0)
				l.add(", " + year);
			else
				l.add(year.toString());
		}
	}

	protected void _reportCardStartYearCurrent(Wrap<String> c) {
	}

	protected void _reportCard_(Wrap<ReportCard> c) {
		if(reportCardSearch.size() == 1) {
			c.o(reportCardSearch.get(0));
		}
//		else {
//			ReportCard o = new ReportCard();
//			c.o(o);
//			o.setPk(0L);
//			o.setSiteRequest_(siteRequest_);
//		}
	}

	protected void _reportCards(Wrap<List<ReportCard>> c) {
		Integer i = 0;
		Integer size = reportCardSearch.size();
		Long stateKeyBefore = null;
		Long stateKeyCurrent = null;
		Long agencyKeyBefore = null;
		Long agencyKeyCurrent = null;
		ReportCard reportCard = null;
		List<ReportCard> reportCardReportCards = null;
		Integer reportCardNumber = null;

		reportCards = reportCardSearch.getList();
		c.o(reportCards);
		if(size > 0) {
			reportCard = reportCards.get(i);
			stateKeyCurrent = reportCard.getStateKey();
			while(i < size) {
				reportCard = reportCards.get(i);
				stateKeyCurrent = reportCard.getStateKey();
				agencyKeyCurrent = reportCard.getAgencyKey();
				if(stateKeyCurrent == null || ObjectUtils.compare(stateKeyCurrent, stateKeyBefore) != 0) {
					stateKeyBefore = reportCard.getStateKey();
					reportCardAgencies_ = reportCard.getReportCardAgencies_();
					reportCardStates_.add(reportCard);
				}
				while(i < size) {
					reportCard = reportCards.get(i);
					stateKeyCurrent = reportCard.getStateKey();
					agencyKeyCurrent = reportCard.getAgencyKey();
					if(agencyKeyBefore == null || ObjectUtils.compare(agencyKeyCurrent, agencyKeyBefore) != 0) {
						agencyKeyBefore = reportCard.getAgencyKey();
						reportCardReportCards = reportCard.getReportCardReportCards_();
						reportCardAgencies_.add(reportCard);
						reportCardNumber = 1;
					}
					reportCard.setReportCardKey(reportCard.getPk());
					reportCard.setReportCardNumber_(reportCardNumber);
					reportCardReportCards.add(reportCard);
					reportCardNumber++;
					i++;
					if((i + 1) > size)
						break;
					reportCard = reportCards.get(i);
					stateKeyCurrent = reportCard.getStateKey();
					agencyKeyCurrent = reportCard.getAgencyKey();
					if(ObjectUtils.compare(stateKeyCurrent, stateKeyBefore) != 0)
						break;
					if(ObjectUtils.compare(agencyKeyCurrent, agencyKeyBefore) != 0)
						break;
				}
				reportCard.setReportCardKey(reportCard.getPk());
				reportCard.setReportCardNumber_(reportCardNumber);
				reportCardNumber++;
			}
		}
	}

	protected void _reportCardStates_(List<ReportCard> c) {
	}

	protected void _reportCardAgencies_(Wrap<List<ReportCard>> c) {
	}

	protected void _reportCardState_(Wrap<ReportCard> c) {
	}

	protected void _reportCardAgency_(Wrap<ReportCard> c) {
	}

	protected void _reportCardReportCard_(Wrap<ReportCard> c) {
	}

	protected void _agencySearch(SearchList<SiteAgency> l) {
		l.setStore(true);
		l.setQuery("*:*");
		l.setC(SiteAgency.class);

		Long agencyKey = Optional.ofNullable(reportCardSearch.first()).map(ReportCard::getAgencyKey).orElse(null);
		if(pageDesignId != null && pageDesignId.endsWith("-reportCard-form") && agencyKey != null) {
			l.addSort("stateName_indexed_string", ORDER.asc);
			l.addSort("agencyOnlyName_indexed_string", ORDER.asc);
			l.addFilterQuery("pk_indexed_long:" + agencyKey);
			l.addFilterQuery("stateKey_indexed_long:[* TO *]");
		} else {
			for(String var : siteRequest_.getRequestVars().keySet()) {
				String val = siteRequest_.getRequestVars().get(var);
				if(!"design".equals(var)) {
					String varIndexed = SiteAgency.varIndexedSiteAgency(var);
					if(varIndexed != null)
						l.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(val));
				}
			}
		}
	}

	protected void _agency_(Wrap<SiteAgency> c) {
		if(pageDesignId != null && pageDesignId.endsWith("-reportCard-form")) {
			if(agencySearch.size() == 0) {
				throw new RuntimeException("No agency was found for the query: " + siteRequest_.getOperationRequest().getParams().getJsonObject("query").encode());
			}
			else if(agencySearch.size() == 1) {
				c.o(agencySearch.get(0));
			}
			else  {
				throw new RuntimeException("More than one agency was found for the query: " + siteRequest_.getOperationRequest().getParams().getJsonObject("query").encode());
			}
		}
	}

	protected void _agencyKey(Wrap<Long> c) {
		if(agency_ != null)
			c.o(agency_.getPk());
	}

	protected void _stateSearch(SearchList<SiteState> l) {
		l.setStore(true);
		l.setQuery("*:*");
		l.setC(SiteState.class);

		Long stateKey = Optional.ofNullable(reportCardSearch.first()).map(ReportCard::getStateKey).orElse(null);
		if(pageDesignId != null && pageDesignId.endsWith("-reportCard-form") && stateKey != null) {
			l.addFilterQuery("pk_indexed_long:" + stateKey);
		} else {
			for(String var : siteRequest_.getRequestVars().keySet()) {
				String val = siteRequest_.getRequestVars().get(var);
				if(!"design".equals(var)) {
					String varIndexed = SiteState.varIndexedSiteState(var);
					if(varIndexed != null)
						l.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(val));
				}
			}
		}
	}

	protected void _state_(Wrap<SiteState> c) {
		if(pageDesignId != null && pageDesignId.endsWith("-reportCard-form")) {
			if(stateSearch.size() == 0) {
				throw new RuntimeException("No state was found for the query: " + siteRequest_.getOperationRequest().getParams().getJsonObject("query").encode());
			}
			else if(stateSearch.size() == 1) {
				c.o(stateSearch.get(0));
			}
			else  {
				throw new RuntimeException("More than one state was found for the query: " + siteRequest_.getOperationRequest().getParams().getJsonObject("query").encode());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _emailToAddress(Wrap<String> c) {
		c.o(siteRequest_.getRequestVars().get("emailToAddress"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _emailToName(Wrap<String> c) {
		c.o(siteRequest_.getRequestVars().get("emailToName"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _emailMessage(Wrap<String> c) {
		c.o(siteRequest_.getRequestVars().get("emailMessage"));
	}

	protected void _stateKey(Wrap<Long> c) {
		if(agency_ != null)
			c.o(agency_.getStateKey());
	}

	protected void _stateName(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getStateName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _htmlPartSearch(SearchList<HtmlPart> l) {
		if(pageDesign != null) {
			l.setQuery("*:*");

			StringBuilder fq = new StringBuilder();
			fq.append("pageDesignKeys_indexed_longs:").append(pageDesign.getPk());
			for(Long k : pageDesign.getParentDesignKeys())
				fq.append(" OR pageDesignKeys_indexed_longs:").append(k);

			l.addFilterQuery(fq.toString());
			l.setC(HtmlPart.class);
			l.setStore(true);
			l.addSort("sort1_indexed_double", ORDER.asc);
			l.addSort("sort2_indexed_double", ORDER.asc);
			l.addSort("sort3_indexed_double", ORDER.asc);
			l.addSort("sort4_indexed_double", ORDER.asc);
			l.addSort("sort5_indexed_double", ORDER.asc);
			l.addSort("sort6_indexed_double", ORDER.asc);
			l.addSort("sort7_indexed_double", ORDER.asc);
			l.addSort("sort8_indexed_double", ORDER.asc);
			l.addSort("sort9_indexed_double", ORDER.asc);
			l.addSort("sort10_indexed_double", ORDER.asc);
			l.setRows(100000);
		}
	}

	protected void _htmlPartList(Wrap<List<HtmlPart>> c) {
		if(htmlPartSearch.size() > 0)
			c.o(htmlPartSearch.getList());
	}

	@Override public void htmlPageLayout() {
		siteRequest_.setW(w2);
		setW(w2);
		if(htmlPartList != null) {
			htmlPageLayout2(pageContentType, htmlPartList, null, 0, htmlPartList.size());
		}

		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
//			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			renderer.setTimeouted(true);
//			for(File fichier : FileUtils.listFiles(new File(siteConfig.docroot.chaîne() + "/ttf"), new String[] { "ttf" }, false)) {
//				FontResolver resolver = renderer.getFontResolver();
//				String chemin = fichier.getAbsolutePath();
//				renderer.getFontResolver().addFont(chemin, true);
//			}
	
			String str = w2.toString();
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			fac.setNamespaceAware(false);
			fac.setValidating(false);
			fac.setFeature("http://xml.org/sax/features/namespaces", false);
			fac.setFeature("http://xml.org/sax/features/validation", false);
			fac.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			fac.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder builder = fac.newDocumentBuilder();
			builder.setEntityResolver(FSEntityResolver.instance());
			Document doc = builder.parse(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))));

			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(doc, null);
			renderer.layout();
			renderer.createPDF(os);
			renderer.finishPDF();
			siteRequest_.getRequestHeaders()
					.add("Content-Disposition", "inline; filename=\"" + "report" + ".pdf\"")
					.add("Content-Transfer-Encoding", "binary")
					.add("Accept-Ranges", "bytes")
					;
			w1.getBuffer().appendBytes(os.toByteArray());
		} catch (IOException | ParserConfigurationException | SAXException | DocumentException e) {
			ExceptionUtils.rethrow(e);
		}
	}
}
