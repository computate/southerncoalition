package org.southerncoalition.enus.county;

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
public class SiteCountyGenPage extends SiteCountyGenPageGen<PageLayout> {

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listSiteCounty(Wrap<SearchList<SiteCounty>> c) {
	}

	protected void _siteCounty(Wrap<SiteCounty> c) {
		if(listSiteCounty != null && listSiteCounty.size() == 1)
			c.o(listSiteCounty.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("counties");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		if(siteCounty != null && siteCounty.getCountyCompleteName() != null)
			c.o(siteCounty.getCountyCompleteName());
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(siteCounty != null && siteCounty.getCountyCompleteName() != null)
			c.o(siteCounty.getCountyCompleteName());
		else if(siteCounty != null)
			c.o("counties");
		else if(listSiteCounty == null || listSiteCounty.size() == 0)
			c.o("no county found");
		else
			c.o("counties");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/county");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/county-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("regular");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("road");
	}

	@Override public void initDeepSiteCountyGenPage() {
		initSiteCountyGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsSiteCountyGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/SiteCountyPage.js").f().g("script");
		e("script").a("src", staticBaseUrl, "/js/enUS/SiteStatePage.js").f().g("script");
		e("script").a("src", staticBaseUrl, "/js/enUS/ReportCardPage.js").f().g("script");
	}

	@Override public void htmlScriptSiteCountyGenPage() {
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
			tl(2, "suggestSiteCountyStateKey([{'name':'fq','value':'countyKeys:' + pk}], $('#listSiteCountyStateKey_Page'), pk, true); ");
		} else {
			tl(2, "suggestSiteCountyStateKey([{'name':'fq','value':'countyKeys:' + pk}], $('#listSiteCountyStateKey_Page'), pk, false); ");
		}
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			tl(2, "suggestSiteCountyReportCardKeys([{'name':'fq','value':'countyKey:' + pk}], $('#listSiteCountyReportCardKeys_Page'), pk, true); ");
		} else {
			tl(2, "suggestSiteCountyReportCardKeys([{'name':'fq','value':'countyKey:' + pk}], $('#listSiteCountyReportCardKeys_Page'), pk, false); ");
		}
		tl(1, "}");
		tl(1, "websocketSiteCounty(websocketSiteCountyInner);");
		l("});");
	}

	public void htmlFormPageSiteCounty(SiteCounty o) {
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
			o.htmCountyName("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmStateKey("Page");
			o.htmReportCardKeys("Page");
		} g("div");
	}

	public void htmlFormPOSTSiteCounty(SiteCounty o) {
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
			o.htmCountyName("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmStateKey("POST");
			o.htmReportCardKeys("POST");
		} g("div");
	}

	public void htmlFormPUTImportSiteCounty(SiteCounty o) {
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

	public void htmlFormPUTMergeSiteCounty(SiteCounty o) {
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

	public void htmlFormPUTCopySiteCounty(SiteCounty o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PUTCopy");
			o.htmModified("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PUTCopy");
			o.htmDeleted("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyName("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmStateKey("PUTCopy");
			o.htmReportCardKeys("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmUserId("PUTCopy");
			o.htmUserKey("PUTCopy");
		} g("div");
	}

	public void htmlFormPATCHSiteCounty(SiteCounty o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCountyName("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmStateKey("PATCH");
			o.htmReportCardKeys("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmUserId("PATCH");
			o.htmUserKey("PATCH");
		} g("div");
	}

	public void htmlFormSearchSiteCounty(SiteCounty o) {
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
			o.htmCountyName("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmStateKey("Search");
			o.htmReportCardKeys("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmUserId("Search");
			o.htmUserKey("Search");
			o.htmObjectTitle("Search");
		} g("div");
	}

	@Override public void htmlBodySiteCountyGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listSiteCounty == null || listSiteCounty.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/county").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-yellow w3-hover-pale-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("counties").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no county found").g("span");
				} g("span");
			} g("h2");
		} else if(listSiteCounty != null && listSiteCounty.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			SiteCounty o = listSiteCounty.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/county").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-yellow w3-hover-pale-yellow ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			}
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			if(StringUtils.isNotEmpty(pageH2)) {
				{ e("h2").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-yellow ").f();
						e("span").a("class", " ").f().sx(pageH2).g("span");
					} g("span");
				} g("h2");
			}
			if(StringUtils.isNotEmpty(pageH3)) {
				{ e("h3").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-yellow ").f();
						e("span").a("class", " ").f().sx(pageH3).g("span");
					} g("span");
				} g("h3");
			}
		} else {

			{ e("h1").f();
				{ e("a").a("href", "/county").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-yellow w3-hover-pale-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx(pageH1).g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					JsonObject queryParams = Optional.ofNullable(operationRequest).map(OperationRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
					Long num = listSiteCounty.getQueryResponse().getResults().getNumFound();
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

					Integer rows1 = Optional.ofNullable(listSiteCounty).map(l -> l.getRows()).orElse(10);
					Integer start1 = Optional.ofNullable(listSiteCounty).map(l -> l.getStart()).orElse(1);
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;
					StringBuilder fqs = new StringBuilder();
					for(String fq : Optional.ofNullable(listSiteCounty).map(l -> l.getFilterQueries()).orElse(new String[0])) {
						if(!StringUtils.contains(fq, "(")) {
							String fq1 = StringUtils.substringBefore(fq, "_");
							String fq2 = StringUtils.substringAfter(fq, ":");
							if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
								fqs.append("&fq=").append(fq1).append(":").append(fq2);
						}
					}
					StringBuilder sorts = new StringBuilder();
					for(SortClause sort : Optional.ofNullable(listSiteCounty).map(l -> l.getSorts()).orElse(Arrays.asList())) {
						sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
					}

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/county?q=", query, fqs, sorts, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/county?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/county?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/county?q=", query, fqs, sorts, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " of ", num).g("span");
				} g("div");
				table1SiteCountyGenPage();
		}

		if(listSiteCounty != null && listSiteCounty.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			SiteCounty o = listSiteCounty.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "SiteCountyForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageSiteCounty(o);
				}

			} g("div");

		}
		htmlBodyFormsSiteCountyGenPage();
		g("div");
	}

	public void table1SiteCountyGenPage() {
		{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
			table2SiteCountyGenPage();
		} g("table");
	}

	public void table2SiteCountyGenPage() {
		thead1SiteCountyGenPage();
		tbody1SiteCountyGenPage();
		tfoot1SiteCountyGenPage();
	}

	public void thead1SiteCountyGenPage() {
		{ e("thead").a("class", "w3-pale-yellow w3-hover-pale-yellow ").f();
			thead2SiteCountyGenPage();
		} g("thead");
	}

	public void thead2SiteCountyGenPage() {
			{ e("tr").f();
			if(getColumnCreated()) {
				e("th").f().sx("created").g("th");
			}
			if(getColumnObjectTitle()) {
				e("th").f().sx("").g("th");
			}
			} g("tr");
	}

	public void tbody1SiteCountyGenPage() {
		{ e("tbody").f();
			tbody2SiteCountyGenPage();
		} g("tbody");
	}

	public void tbody2SiteCountyGenPage() {
		Map<String, Map<String, List<String>>> highlighting = listSiteCounty.getQueryResponse().getHighlighting();
		for(int i = 0; i < listSiteCounty.size(); i++) {
			SiteCounty o = listSiteCounty.getList().get(i);
			Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
			List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
			String uri = "/county/" + o.getPk();
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
							e("i").a("class", "far fa-road ").f().g("i");
							{ e("span").f();
								sx(o.strObjectTitle());
							} g("span");
						} g("a");
					} g("td");
				}
			} g("tr");
		}
	}

	public void tfoot1SiteCountyGenPage() {
		{ e("tfoot").a("class", "w3-pale-yellow w3-hover-pale-yellow ").f();
			tfoot2SiteCountyGenPage();
		} g("tfoot");
	}

	public void tfoot2SiteCountyGenPage() {
		{ e("tr").f();
			SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listSiteCounty.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(new SimpleOrderedMap());
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

	public void htmlBodyFormsSiteCountyGenPage() {
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("div").a("class", "w3-margin-top ").f();

			if(listSiteCounty != null && listSiteCounty.size() == 1) {
				{ e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
						.a("id", "refreshThisSiteCountyGenPage")
						.a("onclick", "patchSiteCountyVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisSiteCountyGenPage')); }, function() { addError($('#refreshThisSiteCountyGenPage')); }); return false; ").f();
						e("i").a("class", "fas fa-sync-alt ").f().g("i");
					sx("refresh this county");
				} g("button");
			}

			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
				.a("onclick", "$('#putimportSiteCountyModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-import ").f().g("i");
				sx("Import counties");
			} g("button");
			{ e("div").a("id", "putimportSiteCountyModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-yellow ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putimportSiteCountyModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Import counties").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							SiteCounty o = new SiteCounty();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putimportSiteCountyForm").f();
								htmlFormPUTImportSiteCounty(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-yellow ")
								.a("onclick", "putimportSiteCounty($('#putimportSiteCountyForm')); ")
								.f().sx("Import counties")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
				.a("onclick", "$('#putmergeSiteCountyModal').show(); ")
				.f();
				e("i").a("class", "fas fa-code-merge ").f().g("i");
				sx("Merge counties");
			} g("button");
			{ e("div").a("id", "putmergeSiteCountyModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-yellow ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putmergeSiteCountyModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Merge counties").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							SiteCounty o = new SiteCounty();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putmergeSiteCountyForm").f();
								htmlFormPUTMergeSiteCounty(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-yellow ")
								.a("onclick", "putmergeSiteCounty($('#putmergeSiteCountyForm')); ")
								.f().sx("Merge counties")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
				.a("onclick", "$('#putcopySiteCountyModal').show(); ")
				.f();
				e("i").a("class", "fas fa-copy ").f().g("i");
				sx("Duplicate counties");
			} g("button");
			{ e("div").a("id", "putcopySiteCountyModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-yellow ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putcopySiteCountyModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Duplicate counties").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							SiteCounty o = new SiteCounty();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putcopySiteCountyForm").f();
								htmlFormPUTCopySiteCounty(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-yellow ")
								.a("onclick", "putcopySiteCounty($('#putcopySiteCountyForm'), ", siteCounty == null ? "null" : siteCounty.getPk(), "); ")
								.f().sx("Duplicate counties")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
				.a("onclick", "$('#postSiteCountyModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-plus ").f().g("i");
				sx("Create a county");
			} g("button");
			{ e("div").a("id", "postSiteCountyModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-yellow ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postSiteCountyModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Create a county").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							SiteCounty o = new SiteCounty();
							o.setSiteRequest_(siteRequest_);

							// Form POST
							{ e("div").a("id", "postSiteCountyForm").f();
								htmlFormPOSTSiteCounty(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-yellow ")
								.a("onclick", "postSiteCounty($('#postSiteCountyForm')); ")
								.f().sx("Create a county")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
				.a("onclick", "$('#patchSiteCountyModal').show(); ")
				.f();
				e("i").a("class", "fas fa-edit ").f().g("i");
				sx("Modify counties");
			} g("button");
			{ e("div").a("id", "patchSiteCountyModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-yellow ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchSiteCountyModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Modify counties").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").f();
							SiteCounty o = new SiteCounty();
							o.setSiteRequest_(siteRequest_);

							// FormValues PATCH
							{ e("form").a("action", "").a("id", "patchSiteCountyFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
								htmlFormPATCHSiteCounty(o);
							} g("form");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-yellow ")
								.a("onclick", "patchSiteCounty(null, $('#patchSiteCountyFormValues'), ", Optional.ofNullable(siteCounty).map(SiteCounty::getPk).map(a -> a.toString()).orElse("null"), ", function() {}, function() {}); ")
								.f().sx("Modify counties")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");

			g("div");
		}
		htmlSuggestedSiteCountyGenPage(this, null, listSiteCounty);
	}

	/**
	**/
	public static void htmlSuggestedSiteCountyGenPage(PageLayout p, String id, SearchList<SiteCounty> listSiteCounty) {
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

			Integer rows1 = Optional.ofNullable(listSiteCounty).map(l -> l.getRows()).orElse(10);
			Integer start1 = Optional.ofNullable(listSiteCounty).map(l -> l.getStart()).orElse(1);
			Integer start2 = start1 - rows1;
			Integer start3 = start1 + rows1;
			Integer rows2 = rows1 / 2;
			Integer rows3 = rows1 * 2;
			start2 = start2 < 0 ? 0 : start2;
			StringBuilder fqs = new StringBuilder();
			for(String fq : Optional.ofNullable(listSiteCounty).map(l -> l.getFilterQueries()).orElse(new String[0])) {
				if(!StringUtils.contains(fq, "(")) {
					String fq1 = StringUtils.substringBefore(fq, "_");
					String fq2 = StringUtils.substringAfter(fq, ":");
					if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
						fqs.append("&fq=").append(fq1).append(":").append(fq2);
				}
			}
			StringBuilder sorts = new StringBuilder();
			for(SortClause sort : Optional.ofNullable(listSiteCounty).map(l -> l.getSorts()).orElse(Arrays.asList())) {
				sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
			}

			if(
					CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), SiteCountyGenPage.ROLES)
					|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), SiteCountyGenPage.ROLES)
					) {
					{ p.e("div").a("class", "").f();
						{ p.e("button").a("id", "refreshAllSiteCountyGenPage", id).a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ").a("onclick", "patchSiteCountyVals([], {}, function() { addGlow($('#refreshAllSiteCountyGenPage", id, "')); }, function() { addError($('#refreshAllSiteCountyGenPage", id, "')); }); ").f();
							p.e("i").a("class", "fas fa-sync-alt ").f().g("i");
							p.sx("refresh all the counties");
						} p.g("button");
					} p.g("div");
			}
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell ").f();
					{ p.e("span").f();
						p.sx("search counties: ");
					} p.g("span");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "w3-bar ").f();

				p.e("input")
					.a("type", "text")
					.a("class", "suggestSiteCounty w3-input w3-border w3-bar-item ")
					.a("name", "suggestSiteCounty")
					.a("id", "suggestSiteCounty", id)
					.a("autocomplete", "off")
					.a("oninput", "suggestSiteCountyObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() }, { 'name': 'rows', 'value': '10' }, { 'name': 'fl', 'value': 'pk,pageUrlPk,countyCompleteName' } ], $('#suggestListSiteCounty", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
					.a("onkeyup", "if (event.keyCode === 13) { event.preventDefault(); window.location.href = '/county?q=", query1, ":' + encodeURIComponent(this.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; }"); 
				if(listSiteCounty != null)
					p.a("value", query2);
				p.fg();
				{ p.e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-yellow ")
					.a("onclick", "window.location.href = '/county?q=", query1, ":' + encodeURIComponent(this.previousElementSibling.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; ") 
					.f();
					p.e("i").a("class", "fas fa-search ").f().g("i");
				} p.g("button");

			} p.g("div");
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
					{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListSiteCounty", id).f();
					} p.g("ul");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "").f();
				{ p.e("a").a("href", "/county").a("class", "").f();
					p.e("i").a("class", "far fa-road ").f().g("i");
					p.sx("see all the counties");
				} p.g("a");
			} p.g("div");
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

}
