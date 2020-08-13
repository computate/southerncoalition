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

	protected void _reportCard_(Wrap<ReportCard> c) {
		if(listReportCard != null && listReportCard.size() == 1)
			c.o(listReportCard.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("report cards");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		if(reportCard_ != null && reportCard_.getCountyCompleteName() != null)
			c.o(reportCard_.getCountyCompleteName());
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(reportCard_ != null && reportCard_.getCountyCompleteName() != null)
			c.o(reportCard_.getCountyCompleteName());
		else if(reportCard_ != null)
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
			o.htmPupilsIndianMale("Page");
			o.htmPupilsIndianFemale("Page");
			o.htmPupilsIndianTotal("Page");
			o.htmPupilsIndianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("Page");
			o.htmPupilsAsianFemale("Page");
			o.htmPupilsAsianTotal("Page");
			o.htmPupilsAsianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("Page");
			o.htmPupilsHispanicFemale("Page");
			o.htmPupilsHispanicTotal("Page");
			o.htmPupilsHispanicPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("Page");
			o.htmPupilsBlackFemale("Page");
			o.htmPupilsBlackTotal("Page");
			o.htmPupilsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("Page");
			o.htmPupilsWhiteFemale("Page");
			o.htmPupilsWhiteTotal("Page");
			o.htmPupilsWhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("Page");
			o.htmPupilsPacificIslanderFemale("Page");
			o.htmPupilsPacificIslanderTotal("Page");
			o.htmPupilsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("Page");
			o.htmPupilsMultiRacialFemale("Page");
			o.htmPupilsMultiRacialTotal("Page");
			o.htmPupilsMultiRacialPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Page");
			o.htmTeachersMale("Page");
			o.htmTeachersFemale("Page");
			o.htmTeachersTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("Page");
			o.htmTeachersWhitePercent("Page");
			o.htmTeachersBlackTotal("Page");
			o.htmTeachersBlackPercent("Page");
			o.htmTeachersOtherTotal("Page");
			o.htmTeachersOtherPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Page");
			o.htmDelinquentComplaintsAtSchool("Page");
			o.htmDelinquentComplaintsAtSchoolPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("Page");
			o.htmDelinquentComplaintsAsianPercent("Page");
			o.htmDelinquentComplaintsBlack("Page");
			o.htmDelinquentComplaintsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("Page");
			o.htmDelinquentComplaintsHispanicPercent("Page");
			o.htmDelinquentComplaintsMultiRacial("Page");
			o.htmDelinquentComplaintsMultiRacialPercent("Page");
			o.htmDelinquentComplaintsIndian("Page");
			o.htmDelinquentComplaintsIndianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("Page");
			o.htmDelinquentComplaintsWhitePercent("Page");
			o.htmDelinquentComplaintsPacificIslander("Page");
			o.htmDelinquentComplaintsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("Page");
			o.htmLongTermSuspensionsTotal("Page");
			o.htmExpulsionsTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("Page");
			o.htmShortTermSuspensionsAsianMale("Page");
			o.htmShortTermSuspensionsAsianTotal("Page");
			o.htmShortTermSuspensionsAsianPercent("Page");
			o.htmShortTermSuspensionsAsianRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("Page");
			o.htmShortTermSuspensionsBlackMale("Page");
			o.htmShortTermSuspensionsBlackTotal("Page");
			o.htmShortTermSuspensionsBlackPercent("Page");
			o.htmShortTermSuspensionsBlackRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("Page");
			o.htmShortTermSuspensionsHispanicMale("Page");
			o.htmShortTermSuspensionsHispanicTotal("Page");
			o.htmShortTermSuspensionsHispanicPercent("Page");
			o.htmShortTermSuspensionsHispanicRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("Page");
			o.htmShortTermSuspensionsIndianMale("Page");
			o.htmShortTermSuspensionsIndianTotal("Page");
			o.htmShortTermSuspensionsIndianPercent("Page");
			o.htmShortTermSuspensionsIndianRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("Page");
			o.htmShortTermSuspensionsMultiRacialMale("Page");
			o.htmShortTermSuspensionsMultiRacialTotal("Page");
			o.htmShortTermSuspensionsMultiRacialPercent("Page");
			o.htmShortTermSuspensionsMultiRacialRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("Page");
			o.htmShortTermSuspensionsPacificIslanderMale("Page");
			o.htmShortTermSuspensionsPacificIslanderTotal("Page");
			o.htmShortTermSuspensionsPacificIslanderPercent("Page");
			o.htmShortTermSuspensionsPacificIslanderRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("Page");
			o.htmShortTermSuspensionsWhiteMale("Page");
			o.htmShortTermSuspensionsWhiteTotal("Page");
			o.htmShortTermSuspensionsWhitePercent("Page");
			o.htmShortTermSuspensionsWhiteRate("Page");
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
			o.htmPupilsIndianMale("POST");
			o.htmPupilsIndianFemale("POST");
			o.htmPupilsIndianTotal("POST");
			o.htmPupilsIndianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("POST");
			o.htmPupilsAsianFemale("POST");
			o.htmPupilsAsianTotal("POST");
			o.htmPupilsAsianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("POST");
			o.htmPupilsHispanicFemale("POST");
			o.htmPupilsHispanicTotal("POST");
			o.htmPupilsHispanicPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("POST");
			o.htmPupilsBlackFemale("POST");
			o.htmPupilsBlackTotal("POST");
			o.htmPupilsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("POST");
			o.htmPupilsWhiteFemale("POST");
			o.htmPupilsWhiteTotal("POST");
			o.htmPupilsWhitePercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("POST");
			o.htmPupilsPacificIslanderFemale("POST");
			o.htmPupilsPacificIslanderTotal("POST");
			o.htmPupilsPacificIslanderPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("POST");
			o.htmPupilsMultiRacialFemale("POST");
			o.htmPupilsMultiRacialTotal("POST");
			o.htmPupilsMultiRacialPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("POST");
			o.htmTeachersMale("POST");
			o.htmTeachersFemale("POST");
			o.htmTeachersTotal("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("POST");
			o.htmTeachersWhitePercent("POST");
			o.htmTeachersBlackTotal("POST");
			o.htmTeachersBlackPercent("POST");
			o.htmTeachersOtherTotal("POST");
			o.htmTeachersOtherPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("POST");
			o.htmDelinquentComplaintsAtSchool("POST");
			o.htmDelinquentComplaintsAtSchoolPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("POST");
			o.htmDelinquentComplaintsAsianPercent("POST");
			o.htmDelinquentComplaintsBlack("POST");
			o.htmDelinquentComplaintsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("POST");
			o.htmDelinquentComplaintsHispanicPercent("POST");
			o.htmDelinquentComplaintsMultiRacial("POST");
			o.htmDelinquentComplaintsMultiRacialPercent("POST");
			o.htmDelinquentComplaintsIndian("POST");
			o.htmDelinquentComplaintsIndianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("POST");
			o.htmDelinquentComplaintsWhitePercent("POST");
			o.htmDelinquentComplaintsPacificIslander("POST");
			o.htmDelinquentComplaintsPacificIslanderPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("POST");
			o.htmLongTermSuspensionsTotal("POST");
			o.htmExpulsionsTotal("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("POST");
			o.htmShortTermSuspensionsAsianMale("POST");
			o.htmShortTermSuspensionsAsianTotal("POST");
			o.htmShortTermSuspensionsAsianPercent("POST");
			o.htmShortTermSuspensionsAsianRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("POST");
			o.htmShortTermSuspensionsBlackMale("POST");
			o.htmShortTermSuspensionsBlackTotal("POST");
			o.htmShortTermSuspensionsBlackPercent("POST");
			o.htmShortTermSuspensionsBlackRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("POST");
			o.htmShortTermSuspensionsHispanicMale("POST");
			o.htmShortTermSuspensionsHispanicTotal("POST");
			o.htmShortTermSuspensionsHispanicPercent("POST");
			o.htmShortTermSuspensionsHispanicRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("POST");
			o.htmShortTermSuspensionsIndianMale("POST");
			o.htmShortTermSuspensionsIndianTotal("POST");
			o.htmShortTermSuspensionsIndianPercent("POST");
			o.htmShortTermSuspensionsIndianRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("POST");
			o.htmShortTermSuspensionsMultiRacialMale("POST");
			o.htmShortTermSuspensionsMultiRacialTotal("POST");
			o.htmShortTermSuspensionsMultiRacialPercent("POST");
			o.htmShortTermSuspensionsMultiRacialRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("POST");
			o.htmShortTermSuspensionsPacificIslanderMale("POST");
			o.htmShortTermSuspensionsPacificIslanderTotal("POST");
			o.htmShortTermSuspensionsPacificIslanderPercent("POST");
			o.htmShortTermSuspensionsPacificIslanderRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("POST");
			o.htmShortTermSuspensionsWhiteMale("POST");
			o.htmShortTermSuspensionsWhiteTotal("POST");
			o.htmShortTermSuspensionsWhitePercent("POST");
			o.htmShortTermSuspensionsWhiteRate("POST");
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
			o.htmPupilsIndianMale("PUTCopy");
			o.htmPupilsIndianFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("PUTCopy");
			o.htmPupilsAsianFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("PUTCopy");
			o.htmPupilsHispanicFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("PUTCopy");
			o.htmPupilsBlackFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("PUTCopy");
			o.htmPupilsWhiteFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("PUTCopy");
			o.htmPupilsPacificIslanderFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("PUTCopy");
			o.htmPupilsMultiRacialFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PUTCopy");
			o.htmTeachersMale("PUTCopy");
			o.htmTeachersFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("PUTCopy");
			o.htmTeachersBlackTotal("PUTCopy");
			o.htmTeachersOtherTotal("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PUTCopy");
			o.htmDelinquentComplaintsAtSchool("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("PUTCopy");
			o.htmDelinquentComplaintsBlack("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("PUTCopy");
			o.htmDelinquentComplaintsMultiRacial("PUTCopy");
			o.htmDelinquentComplaintsIndian("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("PUTCopy");
			o.htmDelinquentComplaintsPacificIslander("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("PUTCopy");
			o.htmLongTermSuspensionsTotal("PUTCopy");
			o.htmExpulsionsTotal("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("PUTCopy");
			o.htmShortTermSuspensionsAsianMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("PUTCopy");
			o.htmShortTermSuspensionsBlackMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("PUTCopy");
			o.htmShortTermSuspensionsHispanicMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("PUTCopy");
			o.htmShortTermSuspensionsIndianMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("PUTCopy");
			o.htmShortTermSuspensionsMultiRacialMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("PUTCopy");
			o.htmShortTermSuspensionsPacificIslanderMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("PUTCopy");
			o.htmShortTermSuspensionsWhiteMale("PUTCopy");
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
			o.htmPupilsIndianMale("PATCH");
			o.htmPupilsIndianFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("PATCH");
			o.htmPupilsAsianFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("PATCH");
			o.htmPupilsHispanicFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("PATCH");
			o.htmPupilsBlackFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("PATCH");
			o.htmPupilsWhiteFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("PATCH");
			o.htmPupilsPacificIslanderFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("PATCH");
			o.htmPupilsMultiRacialFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PATCH");
			o.htmTeachersMale("PATCH");
			o.htmTeachersFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("PATCH");
			o.htmTeachersBlackTotal("PATCH");
			o.htmTeachersOtherTotal("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PATCH");
			o.htmDelinquentComplaintsAtSchool("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("PATCH");
			o.htmDelinquentComplaintsBlack("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("PATCH");
			o.htmDelinquentComplaintsMultiRacial("PATCH");
			o.htmDelinquentComplaintsIndian("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("PATCH");
			o.htmDelinquentComplaintsPacificIslander("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("PATCH");
			o.htmLongTermSuspensionsTotal("PATCH");
			o.htmExpulsionsTotal("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("PATCH");
			o.htmShortTermSuspensionsAsianMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("PATCH");
			o.htmShortTermSuspensionsBlackMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("PATCH");
			o.htmShortTermSuspensionsHispanicMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("PATCH");
			o.htmShortTermSuspensionsIndianMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("PATCH");
			o.htmShortTermSuspensionsMultiRacialMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("PATCH");
			o.htmShortTermSuspensionsPacificIslanderMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("PATCH");
			o.htmShortTermSuspensionsWhiteMale("PATCH");
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
			o.htmPupilsIndianMale("Search");
			o.htmPupilsIndianFemale("Search");
			o.htmPupilsIndianTotal("Search");
			o.htmPupilsIndianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("Search");
			o.htmPupilsAsianFemale("Search");
			o.htmPupilsAsianTotal("Search");
			o.htmPupilsAsianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("Search");
			o.htmPupilsHispanicFemale("Search");
			o.htmPupilsHispanicTotal("Search");
			o.htmPupilsHispanicPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("Search");
			o.htmPupilsBlackFemale("Search");
			o.htmPupilsBlackTotal("Search");
			o.htmPupilsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("Search");
			o.htmPupilsWhiteFemale("Search");
			o.htmPupilsWhiteTotal("Search");
			o.htmPupilsWhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("Search");
			o.htmPupilsPacificIslanderFemale("Search");
			o.htmPupilsPacificIslanderTotal("Search");
			o.htmPupilsPacificIslanderPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("Search");
			o.htmPupilsMultiRacialFemale("Search");
			o.htmPupilsMultiRacialTotal("Search");
			o.htmPupilsMultiRacialPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Search");
			o.htmTeachersMale("Search");
			o.htmTeachersFemale("Search");
			o.htmTeachersTotal("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("Search");
			o.htmTeachersWhitePercent("Search");
			o.htmTeachersBlackTotal("Search");
			o.htmTeachersBlackPercent("Search");
			o.htmTeachersOtherTotal("Search");
			o.htmTeachersOtherPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Search");
			o.htmDelinquentComplaintsAtSchool("Search");
			o.htmDelinquentComplaintsAtSchoolPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("Search");
			o.htmDelinquentComplaintsAsianPercent("Search");
			o.htmDelinquentComplaintsBlack("Search");
			o.htmDelinquentComplaintsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("Search");
			o.htmDelinquentComplaintsHispanicPercent("Search");
			o.htmDelinquentComplaintsMultiRacial("Search");
			o.htmDelinquentComplaintsMultiRacialPercent("Search");
			o.htmDelinquentComplaintsIndian("Search");
			o.htmDelinquentComplaintsIndianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("Search");
			o.htmDelinquentComplaintsWhitePercent("Search");
			o.htmDelinquentComplaintsPacificIslander("Search");
			o.htmDelinquentComplaintsPacificIslanderPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("Search");
			o.htmLongTermSuspensionsTotal("Search");
			o.htmExpulsionsTotal("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("Search");
			o.htmShortTermSuspensionsAsianMale("Search");
			o.htmShortTermSuspensionsAsianTotal("Search");
			o.htmShortTermSuspensionsAsianPercent("Search");
			o.htmShortTermSuspensionsAsianRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("Search");
			o.htmShortTermSuspensionsBlackMale("Search");
			o.htmShortTermSuspensionsBlackTotal("Search");
			o.htmShortTermSuspensionsBlackPercent("Search");
			o.htmShortTermSuspensionsBlackRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("Search");
			o.htmShortTermSuspensionsHispanicMale("Search");
			o.htmShortTermSuspensionsHispanicTotal("Search");
			o.htmShortTermSuspensionsHispanicPercent("Search");
			o.htmShortTermSuspensionsHispanicRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("Search");
			o.htmShortTermSuspensionsIndianMale("Search");
			o.htmShortTermSuspensionsIndianTotal("Search");
			o.htmShortTermSuspensionsIndianPercent("Search");
			o.htmShortTermSuspensionsIndianRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("Search");
			o.htmShortTermSuspensionsMultiRacialMale("Search");
			o.htmShortTermSuspensionsMultiRacialTotal("Search");
			o.htmShortTermSuspensionsMultiRacialPercent("Search");
			o.htmShortTermSuspensionsMultiRacialRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("Search");
			o.htmShortTermSuspensionsPacificIslanderMale("Search");
			o.htmShortTermSuspensionsPacificIslanderTotal("Search");
			o.htmShortTermSuspensionsPacificIslanderPercent("Search");
			o.htmShortTermSuspensionsPacificIslanderRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("Search");
			o.htmShortTermSuspensionsWhiteMale("Search");
			o.htmShortTermSuspensionsWhiteTotal("Search");
			o.htmShortTermSuspensionsWhitePercent("Search");
			o.htmShortTermSuspensionsWhiteRate("Search");
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
								.a("onclick", "putcopyReportCard($('#putcopyReportCardForm'), ", reportCard_ == null ? "null" : reportCard_.getPk(), "); ")
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
								.a("onclick", "patchReportCard(null, $('#patchReportCardFormValues'), ", Optional.ofNullable(reportCard_).map(ReportCard::getPk).map(a -> a.toString()).orElse("null"), ", function() {}, function() {}); ")
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
