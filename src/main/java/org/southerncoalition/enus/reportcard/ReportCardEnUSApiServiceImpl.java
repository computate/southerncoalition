package org.southerncoalition.enus.reportcard;

import java.io.IOException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.southerncoalition.enus.context.SiteContextEnUS;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.statistic.SiteStatistic;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Translate: false
 **/
public class ReportCardEnUSApiServiceImpl extends ReportCardEnUSGenApiServiceImpl {

	public ReportCardEnUSApiServiceImpl(SiteContextEnUS siteContext) {
		super(siteContext);
	}

	@Override public void indexReportCard(ReportCard o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		super.indexReportCard(o, eventHandler);

//		SiteRequestEnUS siteRequest = o.getSiteRequest_();
//		SearchList<SiteStatistic> statisticList = new SearchList<>();
//		statisticList.setC(SiteStatistic.class);
//		statisticList.setQuery("*:*");
//		statisticList.addFacetField("pupilsIndianTotal_indexed_long");
//		statisticList.addFacetField("pupilsAsianTotal_indexed_long");
//		statisticList.addFacetField("pupilsHispanicTotal_indexed_long");
//		statisticList.addFacetField("pupilsBlackTotal_indexed_long");
//		statisticList.addFacetField("pupilsWhiteTotal_indexed_long");
//		statisticList.addFacetField("pupilsPacificIslanderTotal_indexed_long");
//		statisticList.addFacetField("pupilsMultiRacialTotal_indexed_long");
//		statisticList.initDeepForClass(siteRequest);
//
//		QueryResponse queryResponse = statisticList.getQueryResponse();
//
//		indexStatistic(o, queryResponse, "pupilsIndianTotal", "American Indian", "#8064a2", "Other", "#00b0f0");
//		indexStatistic(o, queryResponse, "pupilsAsianTotal", "Asian", "#2f8096", "Other", "#00b0f0");
//		indexStatistic(o, queryResponse, "pupilsHispanicTotal", "Hispanic", "#77933c", "Other", "#00b0f0");
//		indexStatistic(o, queryResponse, "pupilsBlackTotal", "Black", "#e97000", "Black", "#e97000");
//		indexStatistic(o, queryResponse, "pupilsWhiteTotal", "White", "#a84039", "White", "#a84039");
//		indexStatistic(o, queryResponse, "pupilsPacificIslanderTotal", "Pacific Islander", "#edda38", "Other", "#00b0f0");
//		indexStatistic(o, queryResponse, "pupilsMultiRacialTotal", "Multi Racial", "#254061", "Other", "#00b0f0");
	}

	public void indexStatistic(ReportCard reportCard, QueryResponse queryResponse, String var, String pupilRace, String pupilRaceColor, String pupilRaceReduced, String pupilRaceReducedColor) {
		Long numFacets = (Long)queryResponse.getFacetField(var + "_indexed_long").getValues().stream().filter(
				s -> s.getName().equals(pupilRace)).findFirst().map(s -> s.getCount()).orElse(0L);
		Long num = (Long)reportCard.obtainReportCard(var);

		if(num != null && numFacets < num) {
			SiteRequestEnUS siteRequest = reportCard.getSiteRequest_();
			SolrClient clientSolr = siteRequest.getSiteContext_().getSolrClient();
			ZoneId zoneId = ZoneId.of(siteRequest.getSiteConfig_().getSiteZone());
			ZonedDateTime dt1 = ZonedDateTime.now(zoneId);

			for(Long i = numFacets; i <= num; i++) {
				Long pk = reportCard.getPk();
				SolrInputDocument doc = new SolrInputDocument();
				doc.setField("id", "SiteStatistic-" + pk + "-" + var + "-" + i);
				doc.setField("classCanonicalName_indexed_string", "org.southerncoalition.enus.statistic.SiteStatistic");
				doc.setField("reportCardKey_indexed_long", pk);
				doc.setField("pupilRaceColor_indexed_string", pupilRaceColor);
				doc.setField("pupilRaceReduced_indexed_string", pupilRaceReduced);
				doc.setField("pupilRaceReducedColor_indexed_string", pupilRaceReducedColor);
				doc.setField("pupilRace_indexed_string", pupilRace);
				try {
					clientSolr.add(doc);
				} catch (SolrServerException | IOException ex) {
					LOGGER.error("Error creating statistics for the report card " + reportCard.getPk(), ex);
					ExceptionUtils.rethrow(ex);
				}
			}
			try {
				clientSolr.commit(false, false, true);
				ZonedDateTime dt2 = ZonedDateTime.now(zoneId);
				Duration duration = Duration.between(dt1, dt2);
				LOGGER.info(String.format("Generating statistics for report card %s in %s.%s seconds", reportCard.getPk(), duration.getSeconds(), duration.getNano()));
			} catch (SolrServerException | IOException ex) {
				LOGGER.error("Error creating statistics for the report card " + reportCard.getPk(), ex);
				ExceptionUtils.rethrow(ex);
			}
		}
		else if(numFacets > num) {
			try {
				reportCard.getSiteRequest_().getSiteContext_().getSolrClient().deleteByQuery("classCanonicalName_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic AND reportCardKey:" + reportCard.getPk() + " AND num[" + (num + 1L) + " TO *]");
			} catch (SolrServerException | IOException ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
	}
}
