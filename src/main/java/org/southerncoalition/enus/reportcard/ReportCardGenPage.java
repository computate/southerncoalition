package org.southerncoalition.enus.reportcard;

import org.southerncoalition.enus.page.PageLayout;
import org.southerncoalition.enus.config.SiteConfig;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.southerncoalition.enus.context.SiteContextEnUS;
import org.southerncoalition.enus.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.core.json.JsonArray;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.apache.solr.common.util.SimpleOrderedMap;
import java.util.stream.Collectors;
import java.util.Arrays;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import org.apache.commons.collections.CollectionUtils;
import java.util.Objects;
import org.apache.solr.client.solrj.SolrQuery.SortClause;


/**
 * Translate: false
 **/
public class ReportCardGenPage extends ReportCardGenPageGen<PageLayout> {

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listReportCard(Wrap<SearchList<ReportCard>> c) {
	}

	protected void _reportCard(Wrap<ReportCard> c) {
		if(listReportCard != null && listReportCard.size() == 1)
			c.o(listReportCard.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("report cards");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		if(reportCard != null && reportCard.getCountyCompleteName() != null)
			c.o(reportCard.getCountyCompleteName());
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(reportCard != null && reportCard.getCountyCompleteName() != null)
			c.o(reportCard.getCountyCompleteName());
		else if(reportCard != null)
			c.o("report cards");
		else if(listReportCard == null || listReportCard.size() == 0)
			c.o("no report card found");
		else
			c.o("report cards");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/reportcard");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/reportcard-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("regular");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("newspaper");
	}

	@Override public void initDeepReportCardGenPage() {
		initReportCardGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsReportCardGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/ReportCardPage.js").f().g("script");
		e("script").a("src", staticBaseUrl, "/js/enUS/SiteCountyPage.js").f().g("script");
	}

	@Override public void htmlScriptReportCardGenPage() {
		l("$(document).ready(function() {");
		tl(1, "document.onkeydown = function(evt) {");
		tl(2, "evt = evt || window.event;");
		tl(2, "var isEscape = false;");
		tl(2, "if ('key' in evt) {");
		tl(3, "isEscape = (evt.key === 'Escape' || evt.key === 'Esc');");
		tl(2, "} else {");
		tl(3, "isEscape = (evt.keyCode === 27);");
		tl(2, "}");
		tl(2, "if (isEscape) {");
		tl(3, "$('.w3-modal:visible').hide();");
		tl(2, "}");
		tl(1, "};");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", Optional.ofNullable(siteRequest_.getRequestPk()).map(l -> l.toString()).orElse("null"), ";");
		tl(1, "if(pk != null) {");
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			tl(2, "suggestReportCardCountyKey([{'name':'fq','value':'reportCardKeys:' + pk}], $('#listReportCardCountyKey_Page'), pk, true); ");
		} else {
			tl(2, "suggestReportCardCountyKey([{'name':'fq','value':'reportCardKeys:' + pk}], $('#listReportCardCountyKey_Page'), pk, false); ");
		}
		tl(1, "}");
		tl(1, "websocketReportCard(websocketReportCardInner);");
		l("});");
	}

	public void htmlFormPageReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("Page");
			o.htmReportCardEndYear("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyKey("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Page");
			o.htmPupilsIndianFemale("Page");
			o.htmPupilsIndianMale("Page");
			o.htmPupilsIndianTotal("Page");
			o.htmPupilsIndianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianFemale("Page");
			o.htmPupilsAsianMale("Page");
			o.htmPupilsAsianTotal("Page");
			o.htmPupilsAsianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicFemale("Page");
			o.htmPupilsHispanicMale("Page");
			o.htmPupilsHispanicTotal("Page");
			o.htmPupilsHispanicPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackFemale("Page");
			o.htmPupilsBlackMale("Page");
			o.htmPupilsBlackTotal("Page");
			o.htmPupilsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteFemale("Page");
			o.htmPupilsWhiteMale("Page");
			o.htmPupilsWhiteTotal("Page");
			o.htmPupilsWhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderFemale("Page");
			o.htmPupilsPacificIslanderMale("Page");
			o.htmPupilsPacificIslanderTotal("Page");
			o.htmPupilsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialFemale("Page");
			o.htmPupilsMultiRacialMale("Page");
			o.htmPupilsMultiRacialTotal("Page");
			o.htmPupilsMultiRacialPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Page");
			o.htmDelinquentComplaintsAtSchool("Page");
			o.htmDelinquentComplaintsAtSchoolPercent("Page");
		} g("div");
	}

	public void htmlFormPOSTReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("POST");
			o.htmReportCardEndYear("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyKey("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("POST");
			o.htmPupilsIndianFemale("POST");
			o.htmPupilsIndianMale("POST");
			o.htmPupilsIndianTotal("POST");
			o.htmPupilsIndianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianFemale("POST");
			o.htmPupilsAsianMale("POST");
			o.htmPupilsAsianTotal("POST");
			o.htmPupilsAsianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicFemale("POST");
			o.htmPupilsHispanicMale("POST");
			o.htmPupilsHispanicTotal("POST");
			o.htmPupilsHispanicPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackFemale("POST");
			o.htmPupilsBlackMale("POST");
			o.htmPupilsBlackTotal("POST");
			o.htmPupilsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteFemale("POST");
			o.htmPupilsWhiteMale("POST");
			o.htmPupilsWhiteTotal("POST");
			o.htmPupilsWhitePercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderFemale("POST");
			o.htmPupilsPacificIslanderMale("POST");
			o.htmPupilsPacificIslanderTotal("POST");
			o.htmPupilsPacificIslanderPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialFemale("POST");
			o.htmPupilsMultiRacialMale("POST");
			o.htmPupilsMultiRacialTotal("POST");
			o.htmPupilsMultiRacialPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("POST");
			o.htmDelinquentComplaintsAtSchool("POST");
			o.htmDelinquentComplaintsAtSchoolPercent("POST");
		} g("div");
	}

	public void htmlFormPUTImportReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			e("textarea")
				.a("class", "PUTImport_list w3-input w3-border ")
				.a("style", "height: 400px; ")
				.a("placeholder", "{ \"list\": [ { \"pk\": ... , \"saves\": [ ... ] }, ... ] }")
				;
				f();
			g("textarea");
		} g("div");
	}

	public void htmlFormPUTMergeReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			e("textarea")
				.a("class", "PUTMerge_list w3-input w3-border ")
				.a("style", "height: 400px; ")
				.a("placeholder", "{ \"list\": [ { \"pk\": ... , \"saves\": [ ... ] }, ... ] }")
				;
				f();
			g("textarea");
		} g("div");
	}

	public void htmlFormPUTCopyReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PUTCopy");
			o.htmModified("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PUTCopy");
			o.htmDeleted("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyKey("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PUTCopy");
			o.htmPupilsIndianFemale("PUTCopy");
			o.htmPupilsIndianMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianFemale("PUTCopy");
			o.htmPupilsAsianMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicFemale("PUTCopy");
			o.htmPupilsHispanicMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackFemale("PUTCopy");
			o.htmPupilsBlackMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteFemale("PUTCopy");
			o.htmPupilsWhiteMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderFemale("PUTCopy");
			o.htmPupilsPacificIslanderMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialFemale("PUTCopy");
			o.htmPupilsMultiRacialMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PUTCopy");
			o.htmDelinquentComplaintsAtSchool("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmInheritPk("PUTCopy");
			o.htmUserId("PUTCopy");
			o.htmUserKey("PUTCopy");
		} g("div");
	}

	public void htmlFormPATCHReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyKey("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PATCH");
			o.htmPupilsIndianFemale("PATCH");
			o.htmPupilsIndianMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianFemale("PATCH");
			o.htmPupilsAsianMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicFemale("PATCH");
			o.htmPupilsHispanicMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackFemale("PATCH");
			o.htmPupilsBlackMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteFemale("PATCH");
			o.htmPupilsWhiteMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderFemale("PATCH");
			o.htmPupilsPacificIslanderMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialFemale("PATCH");
			o.htmPupilsMultiRacialMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PATCH");
			o.htmDelinquentComplaintsAtSchool("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmInheritPk("PATCH");
			o.htmUserId("PATCH");
			o.htmUserKey("PATCH");
		} g("div");
	}

	public void htmlFormSearchReportCard(ReportCard o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Search");
			o.htmCreated("Search");
			o.htmModified("Search");
			o.htmObjectId("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Search");
			o.htmDeleted("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("Search");
			o.htmReportCardEndYear("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyKey("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Search");
			o.htmPupilsIndianFemale("Search");
			o.htmPupilsIndianMale("Search");
			o.htmPupilsIndianTotal("Search");
			o.htmPupilsIndianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianFemale("Search");
			o.htmPupilsAsianMale("Search");
			o.htmPupilsAsianTotal("Search");
			o.htmPupilsAsianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicFemale("Search");
			o.htmPupilsHispanicMale("Search");
			o.htmPupilsHispanicTotal("Search");
			o.htmPupilsHispanicPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackFemale("Search");
			o.htmPupilsBlackMale("Search");
			o.htmPupilsBlackTotal("Search");
			o.htmPupilsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteFemale("Search");
			o.htmPupilsWhiteMale("Search");
			o.htmPupilsWhiteTotal("Search");
			o.htmPupilsWhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderFemale("Search");
			o.htmPupilsPacificIslanderMale("Search");
			o.htmPupilsPacificIslanderTotal("Search");
			o.htmPupilsPacificIslanderPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialFemale("Search");
			o.htmPupilsMultiRacialMale("Search");
			o.htmPupilsMultiRacialTotal("Search");
			o.htmPupilsMultiRacialPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Search");
			o.htmDelinquentComplaintsAtSchool("Search");
			o.htmDelinquentComplaintsAtSchoolPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmInheritPk("Search");
			o.htmUserId("Search");
			o.htmUserKey("Search");
			o.htmObjectTitle("Search");
		} g("div");
	}

	@Override public void htmlBodyReportCardGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listReportCard == null || listReportCard.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/reportcard").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("report cards").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no report card found").g("span");
				} g("span");
			} g("h2");
		} else if(listReportCard != null && listReportCard.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			ReportCard o = listReportCard.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/reportcard").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			}
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			if(StringUtils.isNotEmpty(pageH2)) {
				{ e("h2").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
						e("span").a("class", " ").f().sx(pageH2).g("span");
					} g("span");
				} g("h2");
			}
			if(StringUtils.isNotEmpty(pageH3)) {
				{ e("h3").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
						e("span").a("class", " ").f().sx(pageH3).g("span");
					} g("span");
				} g("h3");
			}
		} else {

			{ e("h1").f();
				{ e("a").a("href", "/reportcard").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx(pageH1).g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					JsonObject queryParams = Optional.ofNullable(operationRequest).map(OperationRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
					Long num = listReportCard.getQueryResponse().getResults().getNumFound();
					String q = "*:*";
					String query1 = "objectText";
					String query2 = "";
					String query = "*:*";
					for(String paramName : queryParams.fieldNames()) {
						String entityVar = null;
						String valueIndexed = null;
						Object paramObjectValues = queryParams.getValue(paramName);
						JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

						try {
							for(Object paramObject : paramObjects) {
								switch(paramName) {
									case "q":
										q = (String)paramObject;
										entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
										valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
										query1 = entityVar.equals("*") ? query1 : entityVar;
										query2 = valueIndexed;
										query = query1 + ":" + query2;
								}
							}
						} catch(Exception e) {
							ExceptionUtils.rethrow(e);
						}
					}

					Integer rows1 = Optional.ofNullable(listReportCard).map(l -> l.getRows()).orElse(10);
					Integer start1 = Optional.ofNullable(listReportCard).map(l -> l.getStart()).orElse(1);
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;
					StringBuilder fqs = new StringBuilder();
					for(String fq : Optional.ofNullable(listReportCard).map(l -> l.getFilterQueries()).orElse(new String[0])) {
						if(!StringUtils.contains(fq, "(")) {
							String fq1 = StringUtils.substringBefore(fq, "_");
							String fq2 = StringUtils.substringAfter(fq, ":");
							if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
								fqs.append("&fq=").append(fq1).append(":").append(fq2);
						}
					}
					StringBuilder sorts = new StringBuilder();
					for(SortClause sort : Optional.ofNullable(listReportCard).map(l -> l.getSorts()).orElse(Arrays.asList())) {
						sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
					}

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/reportcard?q=", query, fqs, sorts, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/reportcard?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/reportcard?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/reportcard?q=", query, fqs, sorts, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " of ", num).g("span");
				} g("div");
				table1ReportCardGenPage();
		}

		if(listReportCard != null && listReportCard.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			ReportCard o = listReportCard.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "ReportCardForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
						.a("name", "pk")
						.a("class", "valuePk")
						.a("type", "hidden")
						.a("value", o.getPk())
						.fg();
						e("input")
						.a("name", "focusId")
						.a("type", "hidden")
						.fg();
					} g("form");
					htmlFormPageReportCard(o);
				}

			} g("div");

		}
		htmlBodyFormsReportCardGenPage();
		g("div");
	}

	public void table1ReportCardGenPage() {
		{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
			table2ReportCardGenPage();
		} g("table");
	}

	public void table2ReportCardGenPage() {
		thead1ReportCardGenPage();
		tbody1ReportCardGenPage();
		tfoot1ReportCardGenPage();
	}

	public void thead1ReportCardGenPage() {
		{ e("thead").a("class", "w3-pale-green w3-hover-pale-green ").f();
			thead2ReportCardGenPage();
		} g("thead");
	}

	public void thead2ReportCardGenPage() {
			{ e("tr").f();
			if(getColumnCreated()) {
				e("th").f().sx("created").g("th");
			}
			if(getColumnObjectTitle()) {
				e("th").f().sx("").g("th");
			}
			} g("tr");
	}

	public void tbody1ReportCardGenPage() {
		{ e("tbody").f();
			tbody2ReportCardGenPage();
		} g("tbody");
	}

	public void tbody2ReportCardGenPage() {
		Map<String, Map<String, List<String>>> highlighting = listReportCard.getQueryResponse().getHighlighting();
		for(int i = 0; i < listReportCard.size(); i++) {
			ReportCard o = listReportCard.getList().get(i);
			Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
			List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
			String uri = "/reportcard/" + o.getPk();
			{ e("tr").f();
				if(getColumnCreated()) {
					{ e("td").f();
						{ e("a").a("href", uri).f();
							{ e("span").f();
								sx(o.strCreated());
							} g("span");
						} g("a");
					} g("td");
				}
				if(getColumnObjectTitle()) {
					{ e("td").f();
						{ e("a").a("href", uri).f();
							e("i").a("class", "far fa-newspaper ").f().g("i");
							{ e("span").f();
								sx(o.strObjectTitle());
							} g("span");
						} g("a");
					} g("td");
				}
			} g("tr");
		}
	}

	public void tfoot1ReportCardGenPage() {
		{ e("tfoot").a("class", "w3-pale-green w3-hover-pale-green ").f();
			tfoot2ReportCardGenPage();
		} g("tfoot");
	}

	public void tfoot2ReportCardGenPage() {
		{ e("tr").f();
			SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listReportCard.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(new SimpleOrderedMap());
			if(getColumnCreated()) {
				e("td").f();
				g("td");
			}
			if(getColumnObjectTitle()) {
				e("td").f();
				g("td");
			}
		} g("tr");
	}

	public Boolean getColumnCreated() {
		return true;
	}

	public Boolean getColumnObjectTitle() {
		return true;
	}

	public void htmlBodyFormsReportCardGenPage() {
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("div").a("class", "w3-margin-top ").f();

			if(listReportCard != null && listReportCard.size() == 1) {
				{ e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
						.a("id", "refreshThisReportCardGenPage")
						.a("onclick", "patchReportCardVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisReportCardGenPage')); }, function() { addError($('#refreshThisReportCardGenPage')); }); return false; ").f();
						e("i").a("class", "fas fa-sync-alt ").f().g("i");
					sx("refresh this report card");
				} g("button");
			}

			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putimportReportCardModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-import ").f().g("i");
				sx("Import report cards");
			} g("button");
			{ e("div").a("id", "putimportReportCardModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putimportReportCardModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Import report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							ReportCard o = new ReportCard();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putimportReportCardForm").f();
								htmlFormPUTImportReportCard(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putimportReportCard($('#putimportReportCardForm')); ")
								.f().sx("Import report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putmergeReportCardModal').show(); ")
				.f();
				e("i").a("class", "fas fa-code-merge ").f().g("i");
				sx("Merge report cards");
			} g("button");
			{ e("div").a("id", "putmergeReportCardModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putmergeReportCardModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Merge report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							ReportCard o = new ReportCard();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putmergeReportCardForm").f();
								htmlFormPUTMergeReportCard(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putmergeReportCard($('#putmergeReportCardForm')); ")
								.f().sx("Merge report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putcopyReportCardModal').show(); ")
				.f();
				e("i").a("class", "fas fa-copy ").f().g("i");
				sx("Duplicate report cards");
			} g("button");
			{ e("div").a("id", "putcopyReportCardModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putcopyReportCardModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Duplicate report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							ReportCard o = new ReportCard();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putcopyReportCardForm").f();
								htmlFormPUTCopyReportCard(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putcopyReportCard($('#putcopyReportCardForm'), ", reportCard == null ? "null" : reportCard.getPk(), "); ")
								.f().sx("Duplicate report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#postReportCardModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-plus ").f().g("i");
				sx("Create a report card");
			} g("button");
			{ e("div").a("id", "postReportCardModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postReportCardModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Create a report card").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							ReportCard o = new ReportCard();
							o.setSiteRequest_(siteRequest_);

							// Form POST
							{ e("div").a("id", "postReportCardForm").f();
								htmlFormPOSTReportCard(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "postReportCard($('#postReportCardForm')); ")
								.f().sx("Create a report card")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#patchReportCardModal').show(); ")
				.f();
				e("i").a("class", "fas fa-edit ").f().g("i");
				sx("Modify report cards");
			} g("button");
			{ e("div").a("id", "patchReportCardModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchReportCardModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Modify report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							ReportCard o = new ReportCard();
							o.setSiteRequest_(siteRequest_);

							// FormValues PATCH
							{ e("form").a("action", "").a("id", "patchReportCardFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
								htmlFormPATCHReportCard(o);
							} g("form");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "patchReportCard(null, $('#patchReportCardFormValues'), ", Optional.ofNullable(reportCard).map(ReportCard::getPk).map(a -> a.toString()).orElse("null"), ", function() {}, function() {}); ")
								.f().sx("Modify report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");

			g("div");
		}
		htmlSuggestedReportCardGenPage(this, null, listReportCard);
	}

	/**
	**/
	public static void htmlSuggestedReportCardGenPage(PageLayout p, String id, SearchList<ReportCard> listReportCard) {
		SiteRequestEnUS siteRequest_ = p.getSiteRequest_();
		try {
			OperationRequest operationRequest = siteRequest_.getOperationRequest();
			JsonObject queryParams = Optional.ofNullable(operationRequest).map(OperationRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
			String q = "*:*";
			String query1 = "objectText";
			String query2 = "";
			for(String paramName : queryParams.fieldNames()) {
				String entityVar = null;
				String valueIndexed = null;
				Object paramObjectValues = queryParams.getValue(paramName);
				JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "q":
								q = (String)paramObject;
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								query1 = entityVar.equals("*") ? query1 : entityVar;
								query2 = valueIndexed.equals("*") ? "" : valueIndexed;
						}
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			}

			Integer rows1 = Optional.ofNullable(listReportCard).map(l -> l.getRows()).orElse(10);
			Integer start1 = Optional.ofNullable(listReportCard).map(l -> l.getStart()).orElse(1);
			Integer start2 = start1 - rows1;
			Integer start3 = start1 + rows1;
			Integer rows2 = rows1 / 2;
			Integer rows3 = rows1 * 2;
			start2 = start2 < 0 ? 0 : start2;
			StringBuilder fqs = new StringBuilder();
			for(String fq : Optional.ofNullable(listReportCard).map(l -> l.getFilterQueries()).orElse(new String[0])) {
				if(!StringUtils.contains(fq, "(")) {
					String fq1 = StringUtils.substringBefore(fq, "_");
					String fq2 = StringUtils.substringAfter(fq, ":");
					if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
						fqs.append("&fq=").append(fq1).append(":").append(fq2);
				}
			}
			StringBuilder sorts = new StringBuilder();
			for(SortClause sort : Optional.ofNullable(listReportCard).map(l -> l.getSorts()).orElse(Arrays.asList())) {
				sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
			}

			if(
					CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ReportCardGenPage.ROLES)
					|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ReportCardGenPage.ROLES)
					) {
					{ p.e("div").a("class", "").f();
						{ p.e("button").a("id", "refreshAllReportCardGenPage", id).a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ").a("onclick", "patchReportCardVals([], {}, function() { addGlow($('#refreshAllReportCardGenPage", id, "')); }, function() { addError($('#refreshAllReportCardGenPage", id, "')); }); ").f();
							p.e("i").a("class", "fas fa-sync-alt ").f().g("i");
							p.sx("refresh all the report cards");
						} p.g("button");
					} p.g("div");
			}
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell ").f();
					{ p.e("span").f();
						p.sx("search report cards: ");
					} p.g("span");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "w3-bar ").f();

				p.e("input")
					.a("type", "text")
					.a("class", "suggestReportCard w3-input w3-border w3-bar-item ")
					.a("name", "suggestReportCard")
					.a("id", "suggestReportCard", id)
					.a("autocomplete", "off")
					.a("oninput", "suggestReportCardObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() }, { 'name': 'rows', 'value': '10' }, { 'name': 'fl', 'value': 'pk,pageUrlPk,countyCompleteName' } ], $('#suggestListReportCard", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
					.a("onkeyup", "if (event.keyCode === 13) { event.preventDefault(); window.location.href = '/reportcard?q=", query1, ":' + encodeURIComponent(this.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; }"); 
				if(listReportCard != null)
					p.a("value", query2);
				p.fg();
				{ p.e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
					.a("onclick", "window.location.href = '/reportcard?q=", query1, ":' + encodeURIComponent(this.previousElementSibling.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; ") 
					.f();
					p.e("i").a("class", "fas fa-search ").f().g("i");
				} p.g("button");

			} p.g("div");
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
					{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListReportCard", id).f();
					} p.g("ul");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "").f();
				{ p.e("a").a("href", "/reportcard").a("class", "").f();
					p.e("i").a("class", "far fa-newspaper ").f().g("i");
					p.sx("see all the report cards");
				} p.g("a");
			} p.g("div");
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

}
