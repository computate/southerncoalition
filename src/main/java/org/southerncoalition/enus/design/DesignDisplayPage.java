package org.southerncoalition.enus.design;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
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
			yearEndDate = now.isBefore(yearEndDate) ? yearEndDate.minusYears(3) : yearEndDate.minusYears(2);
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
			Boolean filteredAgencyId = false;
			for(String var : siteRequest_.getRequestVars().keySet()) {
				String val = siteRequest_.getRequestVars().get(var);
				if(!"design".equals(var) && StringUtils.isNotBlank(val)) {
					String varIndexed = ReportCard.varIndexedReportCard(var);
					if(varIndexed != null) {
						filtered = true;
						l.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(val));
						if("agencyId_indexed_string".equals(varIndexed))
							filteredAgencyId = true;
					}
				}
			}
			if(filtered)
				l.setRows(1000);
			else
				l.setRows(0);

			if(!filteredAgencyId) {

				l.addField("reportCardStartYear_stored_int");
				l.addField("reportCardEndYear_stored_int");
				l.addField("agencyCoords_stored_string");
				l.addField("imageTop_stored_int");
				l.addField("imageLeft_stored_int");
				l.addField("agencyName_stored_string");
				l.addField("reportCardYearsStr_stored_string");
				l.addField("agencyId_stored_string");
				l.addField("agencyName_stored_string");
				l.addField("pupilsTotal_stored_long");
				l.addField("pupilsBlackPercent_stored_double");
				l.addField("pupilsLatinxPercent_stored_double");
				l.addField("pupilsWhitePercent_stored_double");
				l.addField("examsCollegeReadyGrades38BlackVsWhite_stored_double");
				l.addField("examsCollegeReadyGrades38LatinxVsWhite_stored_double");
				l.addField("delinquentComplaintsAtSchoolPercent_stored_double");
				l.addField("shortTermSuspensionsBlackPercent_stored_double");
				l.addField("shortTermSuspensionsLatinxPercent_stored_double");
				l.addField("shortTermSuspensionsWhitePercent_stored_double");
				l.addField("shortTermSuspensionsBlackVsWhite_stored_double");
				l.addField("pupilsIndigenousFemale_stored_long");
				l.addField("pupilsIndigenousMale_stored_long");
				l.addField("pupilsAsianFemale_stored_long");
				l.addField("pupilsAsianMale_stored_long");
				l.addField("pupilsLatinxFemale_stored_long");
				l.addField("pupilsLatinxMale_stored_long");
				l.addField("pupilsBlackFemale_stored_long");
				l.addField("pupilsBlackMale_stored_long");
				l.addField("pupilsWhiteFemale_stored_long");
				l.addField("pupilsWhiteMale_stored_long");
				l.addField("pupilsPacificIslanderFemale_stored_long");
				l.addField("pupilsPacificIslanderMale_stored_long");
				l.addField("pupilsMultiRacialFemale_stored_long");
				l.addField("pupilsMultiRacialMale_stored_long");
				l.addField("teachersMale_stored_long");
				l.addField("teachersFemale_stored_long");
				l.addField("teachersWhiteTotal_stored_long");
				l.addField("teachersBlackTotal_stored_long");
				l.addField("teachersOtherTotal_stored_long");
				l.addField("delinquentComplaintsTotal_stored_long");
				l.addField("delinquentComplaintsAtSchool_stored_long");
				l.addField("delinquentComplaintsAsian_stored_long");
				l.addField("delinquentComplaintsBlack_stored_long");
				l.addField("delinquentComplaintsLatinx_stored_long");
				l.addField("delinquentComplaintsMultiRacial_stored_long");
				l.addField("delinquentComplaintsIndigenous_stored_long");
				l.addField("delinquentComplaintsWhite_stored_long");
				l.addField("delinquentComplaintsPacificIslander_stored_long");
				l.addField("shortTermSuspensionRate_stored_long");
				l.addField("shortTermSuspensionsTotal_stored_long");
				l.addField("longTermSuspensionsTotal_stored_long");
				l.addField("expulsionsTotal_stored_long");
				l.addField("shortTermSuspensionsAsianFemale_stored_long");
				l.addField("shortTermSuspensionsAsianMale_stored_long");
				l.addField("shortTermSuspensionsBlackFemale_stored_long");
				l.addField("shortTermSuspensionsBlackMale_stored_long");
				l.addField("shortTermSuspensionsLatinxFemale_stored_long");
				l.addField("shortTermSuspensionsLatinxMale_stored_long");
				l.addField("shortTermSuspensionsIndigenousFemale_stored_long");
				l.addField("shortTermSuspensionsIndigenousMale_stored_long");
				l.addField("shortTermSuspensionsMultiRacialFemale_stored_long");
				l.addField("shortTermSuspensionsMultiRacialMale_stored_long");
				l.addField("shortTermSuspensionsPacificIslanderFemale_stored_long");
				l.addField("shortTermSuspensionsPacificIslanderMale_stored_long");
				l.addField("shortTermSuspensionsWhiteFemale_stored_long");
				l.addField("shortTermSuspensionsWhiteMale_stored_long");
				l.addField("examsCollegeReadyGrades38OverallPercent_stored_double");
				l.addField("examsCollegeReadyGrades38IndigenousPercent_stored_double");
				l.addField("examsCollegeReadyGrades38AsianPercent_stored_double");
				l.addField("examsCollegeReadyGrades38BlackPercent_stored_double");
				l.addField("examsCollegeReadyGrades38LatinxPercent_stored_double");
				l.addField("examsCollegeReadyGrades38MultiRacialPercent_stored_double");
				l.addField("examsCollegeReadyGrades38PacificIslanderPercent_stored_double");
				l.addField("examsCollegeReadyGrades38WhitePercent_stored_double");
				l.addField("examsCollegeReadyGrades912OverallPercent_stored_double");
				l.addField("examsCollegeReadyGrades912IndigenousPercent_stored_double");
				l.addField("examsCollegeReadyGrades912AsianPercent_stored_double");
				l.addField("examsCollegeReadyGrades912BlackPercent_stored_double");
				l.addField("examsCollegeReadyGrades912LatinxPercent_stored_double");
				l.addField("examsCollegeReadyGrades912MultiRacialPercent_stored_double");
				l.addField("examsCollegeReadyGrades912PacificIslanderPercent_stored_double");
				l.addField("examsCollegeReadyGrades912WhitePercent_stored_double");
				l.addField("graduateWithin4YearsOverallPercent_stored_double");
				l.addField("graduateWithin4YearsIndigenousPercent_stored_double");
				l.addField("graduateWithin4YearsAsianPercent_stored_double");
				l.addField("graduateWithin4YearsBlackPercent_stored_double");
				l.addField("graduateWithin4YearsLatinxPercent_stored_double");
				l.addField("graduateWithin4YearsMultiRacialPercent_stored_double");
				l.addField("graduateWithin4YearsPacificIslanderPercent_stored_double");
				l.addField("graduateWithin4YearsWhitePercent_stored_double");
			}
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
