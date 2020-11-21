package org.southerncoalition.enus.design;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.southerncoalition.enus.agency.SiteAgency;
import org.southerncoalition.enus.html.part.HtmlPart;
import org.southerncoalition.enus.reportcard.ReportCard;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.state.SiteState;
import org.southerncoalition.enus.wrap.Wrap;

import io.vertx.ext.web.api.OperationRequest;

/**
 * Translate: false
 **/
public class DesignDisplayPage extends DesignDisplayPageGen<DesignDisplayGenPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageDesign(Wrap<PageDesign> c) {
		if(listPageDesign.size() == 1) {
			PageDesign o = listPageDesign.get(0);
			setPageContentType(o.getPageContentType());
			siteRequest_.getRequestHeaders().set("Content-Type", o.getPageContentType());
			c.o(o);
		}
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
			LocalDate yearEndDate = now.with(TemporalAdjusters.firstDayOfMonth()).withMonth(6);
			yearEndDate = now.isBefore(yearEndDate) ? yearEndDate.minusYears(1) : yearEndDate.minusYears(2);
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
		l.addFilterQuery("archived_indexed_boolean:false");
		l.addFilterQuery("deleted_indexed_boolean:false");
		if(reportCardStartYear != null) {
			OperationRequest operationRequest = siteRequest_.getOperationRequest();
			l.setStore(true);
			l.setQuery("*:*");
			l.setC(ReportCard.class);
	
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

	protected void _reportCardStartYears(List<ReportCard> l) {
		List<Integer> years = reportCardSearch.getQueryResponse().getFacetField("reportCardStartYear_indexed_int").getValues().stream().filter(o -> o.getCount() > 0).map(o -> Integer.parseInt(o.getName())).collect(Collectors.toList());
		years.remove(reportCardStartYear);
		Collections.sort(years);
		for(Integer i = 0; i < years.size(); i++) {
			ReportCard reportCard = new ReportCard();
			Integer year = years.get(i);
			reportCard.setReportCardStartYear(year);
			l.add(reportCard);
			if(i == (years.size() - 1) && years.size() > 1)
				reportCard.setReportCardStartYearStr(" and " + year);
			else if(i > 0)
				reportCard.setReportCardStartYearStr(", " + year);
			else
				reportCard.setReportCardStartYearStr(year.toString());
		}
	}

	protected void _reportCardStartYearCurrent(Wrap<ReportCard> c) {
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
		if(agencyKey != null) {
			l.addSort("stateName_indexed_string", ORDER.asc);
			l.addSort("agencyOnlyName_indexed_string", ORDER.asc);
			l.addFilterQuery("pk_indexed_long:" + agencyKey);
			l.addFilterQuery("stateKey_indexed_long:[* TO *]");
			l.addFilterQuery("archived_indexed_boolean:false");
			l.addFilterQuery("deleted_indexed_boolean:false");
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
		if(agencySearch.size() == 1) {
			c.o(agencySearch.get(0));
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
		l.addFilterQuery("archived_indexed_boolean:false");
		l.addFilterQuery("deleted_indexed_boolean:false");

		for(String var : siteRequest_.getRequestVars().keySet()) {
			String val = siteRequest_.getRequestVars().get(var);
			if(!"design".equals(var)) {
				String varIndexed = SiteState.varIndexedSiteState(var);
				if(varIndexed != null)
					l.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(val));
			}
		}
	}

	protected void _state_(Wrap<SiteState> c) {
		if(stateSearch.size() == 1) {
			c.o(stateSearch.get(0));
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
	 * Ignore: true
	 */ 
	protected void _stateReportCardSearch(SearchList<ReportCard> l) {
		if(stateKey != null && stateName != null) {
			l.setQuery("*:*");
			l.addFilterQuery("stateKey_indexed_long:" + stateKey);
			l.addFilterQuery("agencyName_indexed_string:" + ClientUtils.escapeQueryChars(stateName));
			l.addFilterQuery("reportCardStartYear_indexed_int:" + reportCardStartYear);
			l.addFilterQuery("archived_indexed_boolean:false");
			l.addFilterQuery("deleted_indexed_boolean:false");
			l.setC(ReportCard.class);
			l.setStore(true);
		}
	}

	protected void _stateReportCard_(Wrap<ReportCard> c) {
		if(stateReportCardSearch.size() > 0) {
			c.o(stateReportCardSearch.get(0));
		}
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
			l.addFilterQuery("archived_indexed_boolean:false");
			l.addFilterQuery("deleted_indexed_boolean:false");
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
		if(htmlPartList != null) {
			htmlPageLayout2(pageContentType, htmlPartList, null, 0, htmlPartList.size());
		}
	}
}
