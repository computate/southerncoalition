package org.southerncoalition.enus.reportcard;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.search.SearchList;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.southerncoalition.enus.cluster.Cluster;
import java.math.RoundingMode;
import org.southerncoalition.enus.wrap.Wrap;
import org.southerncoalition.enus.writer.AllWriter;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.southerncoalition.enus.county.SiteCounty;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.southerncoalition.enus.context.SiteContextEnUS;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ReportCardGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportCard.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String ReportCard_AName = "a report card";
	public static final String ReportCard_This = "this ";
	public static final String ReportCard_ThisName = "this report card";
	public static final String ReportCard_A = "a ";
	public static final String ReportCard_TheName = "the report card";
	public static final String ReportCard_NameSingular = "report card";
	public static final String ReportCard_NamePlural = "report cards";
	public static final String ReportCard_NameActual = "current report card";
	public static final String ReportCard_AllName = "all the report cards";
	public static final String ReportCard_SearchAllNameBy = "search report cards by ";
	public static final String ReportCard_Title = "report cards";
	public static final String ReportCard_ThePluralName = "the report cards";
	public static final String ReportCard_NoNameFound = "no report card found";
	public static final String ReportCard_NameVar = "reportCard";
	public static final String ReportCard_OfName = "of report card";
	public static final String ReportCard_ANameAdjective = "a report card";
	public static final String ReportCard_NameAdjectiveSingular = "report card";
	public static final String ReportCard_NameAdjectivePlural = "report cards";
	public static final String ReportCard_Color = "pale-green";
	public static final String ReportCard_IconGroup = "regular";
	public static final String ReportCard_IconName = "newspaper";

	///////////////////
	// reportCardKey //
	///////////////////

	/**	 The entity reportCardKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long reportCardKey;
	@JsonIgnore
	public Wrap<Long> reportCardKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("reportCardKey").o(reportCardKey);

	/**	<br/> The entity reportCardKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardKey">Find the entity reportCardKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardKey(Wrap<Long> c);

	public Long getReportCardKey() {
		return reportCardKey;
	}

	public void setReportCardKey(Long reportCardKey) {
		this.reportCardKey = reportCardKey;
		this.reportCardKeyWrap.alreadyInitialized = true;
	}
	public ReportCard setReportCardKey(String o) {
		if(NumberUtils.isParsable(o))
			this.reportCardKey = Long.parseLong(o);
		this.reportCardKeyWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard reportCardKeyInit() {
		if(!reportCardKeyWrap.alreadyInitialized) {
			_reportCardKey(reportCardKeyWrap);
			if(reportCardKey == null)
				setReportCardKey(reportCardKeyWrap.o);
		}
		reportCardKeyWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrReportCardKey() {
		return reportCardKey;
	}

	public String strReportCardKey() {
		return reportCardKey == null ? "" : reportCardKey.toString();
	}

	public String jsonReportCardKey() {
		return reportCardKey == null ? "" : reportCardKey.toString();
	}

	public String nomAffichageReportCardKey() {
		return null;
	}

	public String htmTooltipReportCardKey() {
		return null;
	}

	public String htmReportCardKey() {
		return reportCardKey == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardKey());
	}

	/////////////////////////
	// reportCardStartYear //
	/////////////////////////

	/**	 The entity reportCardStartYear
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportCardStartYear;
	@JsonIgnore
	public Wrap<Integer> reportCardStartYearWrap = new Wrap<Integer>().p(this).c(Integer.class).var("reportCardStartYear").o(reportCardStartYear);

	/**	<br/> The entity reportCardStartYear
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStartYear">Find the entity reportCardStartYear in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardStartYear(Wrap<Integer> c);

	public Integer getReportCardStartYear() {
		return reportCardStartYear;
	}

	public void setReportCardStartYear(Integer reportCardStartYear) {
		this.reportCardStartYear = reportCardStartYear;
		this.reportCardStartYearWrap.alreadyInitialized = true;
	}
	public ReportCard setReportCardStartYear(String o) {
		if(NumberUtils.isParsable(o))
			this.reportCardStartYear = Integer.parseInt(o);
		this.reportCardStartYearWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard reportCardStartYearInit() {
		if(!reportCardStartYearWrap.alreadyInitialized) {
			_reportCardStartYear(reportCardStartYearWrap);
			if(reportCardStartYear == null)
				setReportCardStartYear(reportCardStartYearWrap.o);
		}
		reportCardStartYearWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrReportCardStartYear() {
		return reportCardStartYear;
	}

	public String strReportCardStartYear() {
		return reportCardStartYear == null ? "" : reportCardStartYear.toString();
	}

	public String jsonReportCardStartYear() {
		return reportCardStartYear == null ? "" : reportCardStartYear.toString();
	}

	public String nomAffichageReportCardStartYear() {
		return "start year";
	}

	public String htmTooltipReportCardStartYear() {
		return null;
	}

	public String htmReportCardStartYear() {
		return reportCardStartYear == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardStartYear());
	}

	public void inputReportCardStartYear(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "start year")
				.a("id", classApiMethodMethod, "_reportCardStartYear");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setReportCardStartYear classReportCard inputReportCard", pk, "ReportCardStartYear w3-input w3-border ");
					a("name", "setReportCardStartYear");
				} else {
					a("class", "valueReportCardStartYear w3-input w3-border classReportCard inputReportCard", pk, "ReportCardStartYear w3-input w3-border ");
					a("name", "reportCardStartYear");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setReportCardStartYear', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_reportCardStartYear')); }, function() { addError($('#", classApiMethodMethod, "_reportCardStartYear')); }); ");
				}
				a("value", strReportCardStartYear())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ReportCardStartYear ").f().sx(htmReportCardStartYear()).g("span");
		}
	}

	public void htmReportCardStartYear(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardReportCardStartYear").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_reportCardStartYear").a("class", "").f().sx("start year").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputReportCardStartYear(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_reportCardStartYear')); $('#", classApiMethodMethod, "_reportCardStartYear').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setReportCardStartYear', null, function() { addGlow($('#", classApiMethodMethod, "_reportCardStartYear')); }, function() { addError($('#", classApiMethodMethod, "_reportCardStartYear')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////////
	// reportCardEndYear //
	///////////////////////

	/**	 The entity reportCardEndYear
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportCardEndYear;
	@JsonIgnore
	public Wrap<Integer> reportCardEndYearWrap = new Wrap<Integer>().p(this).c(Integer.class).var("reportCardEndYear").o(reportCardEndYear);

	/**	<br/> The entity reportCardEndYear
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardEndYear">Find the entity reportCardEndYear in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardEndYear(Wrap<Integer> c);

	public Integer getReportCardEndYear() {
		return reportCardEndYear;
	}

	public void setReportCardEndYear(Integer reportCardEndYear) {
		this.reportCardEndYear = reportCardEndYear;
		this.reportCardEndYearWrap.alreadyInitialized = true;
	}
	public ReportCard setReportCardEndYear(String o) {
		if(NumberUtils.isParsable(o))
			this.reportCardEndYear = Integer.parseInt(o);
		this.reportCardEndYearWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard reportCardEndYearInit() {
		if(!reportCardEndYearWrap.alreadyInitialized) {
			_reportCardEndYear(reportCardEndYearWrap);
			if(reportCardEndYear == null)
				setReportCardEndYear(reportCardEndYearWrap.o);
		}
		reportCardEndYearWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrReportCardEndYear() {
		return reportCardEndYear;
	}

	public String strReportCardEndYear() {
		return reportCardEndYear == null ? "" : reportCardEndYear.toString();
	}

	public String jsonReportCardEndYear() {
		return reportCardEndYear == null ? "" : reportCardEndYear.toString();
	}

	public String nomAffichageReportCardEndYear() {
		return "end year";
	}

	public String htmTooltipReportCardEndYear() {
		return null;
	}

	public String htmReportCardEndYear() {
		return reportCardEndYear == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardEndYear());
	}

	public void inputReportCardEndYear(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmReportCardEndYear(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("end year").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ReportCardEndYear ").f().sx(strReportCardEndYear()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////
	// countySearch //
	//////////////////

	/**	 The entity countySearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteCounty>(). 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteCounty> countySearch = new SearchList<SiteCounty>();
	@JsonIgnore
	public Wrap<SearchList<SiteCounty>> countySearchWrap = new Wrap<SearchList<SiteCounty>>().p(this).c(SearchList.class).var("countySearch").o(countySearch);

	/**	<br/> The entity countySearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteCounty>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countySearch">Find the entity countySearch in Solr</a>
	 * <br/>
	 * @param countySearch is the entity already constructed. 
	 **/
	protected abstract void _countySearch(SearchList<SiteCounty> l);

	public SearchList<SiteCounty> getCountySearch() {
		return countySearch;
	}

	public void setCountySearch(SearchList<SiteCounty> countySearch) {
		this.countySearch = countySearch;
		this.countySearchWrap.alreadyInitialized = true;
	}
	protected ReportCard countySearchInit() {
		if(!countySearchWrap.alreadyInitialized) {
			_countySearch(countySearch);
		}
		countySearch.initDeepForClass(siteRequest_);
		countySearchWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	/////////////
	// county_ //
	/////////////

	/**	 The entity county_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteCounty county_;
	@JsonIgnore
	public Wrap<SiteCounty> county_Wrap = new Wrap<SiteCounty>().p(this).c(SiteCounty.class).var("county_").o(county_);

	/**	<br/> The entity county_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:county_">Find the entity county_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _county_(Wrap<SiteCounty> c);

	public SiteCounty getCounty_() {
		return county_;
	}

	public void setCounty_(SiteCounty county_) {
		this.county_ = county_;
		this.county_Wrap.alreadyInitialized = true;
	}
	protected ReportCard county_Init() {
		if(!county_Wrap.alreadyInitialized) {
			_county_(county_Wrap);
			if(county_ == null)
				setCounty_(county_Wrap.o);
		}
		county_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	///////////////
	// countyKey //
	///////////////

	/**	 The entity countyKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long countyKey;
	@JsonIgnore
	public Wrap<Long> countyKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("countyKey").o(countyKey);

	/**	<br/> The entity countyKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyKey">Find the entity countyKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _countyKey(Wrap<Long> c);

	public Long getCountyKey() {
		return countyKey;
	}

	public void setCountyKey(Long countyKey) {
		this.countyKey = countyKey;
		this.countyKeyWrap.alreadyInitialized = true;
	}
	public ReportCard setCountyKey(String o) {
		if(NumberUtils.isParsable(o))
			this.countyKey = Long.parseLong(o);
		this.countyKeyWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard countyKeyInit() {
		if(!countyKeyWrap.alreadyInitialized) {
			_countyKey(countyKeyWrap);
			if(countyKey == null)
				setCountyKey(countyKeyWrap.o);
		}
		countyKeyWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrCountyKey() {
		return countyKey;
	}

	public String strCountyKey() {
		return countyKey == null ? "" : countyKey.toString();
	}

	public String jsonCountyKey() {
		return countyKey == null ? "" : countyKey.toString();
	}

	public String nomAffichageCountyKey() {
		return "county";
	}

	public String htmTooltipCountyKey() {
		return null;
	}

	public String htmCountyKey() {
		return countyKey == null ? "" : StringEscapeUtils.escapeHtml4(strCountyKey());
	}

	public void inputCountyKey(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
				e("input")
					.a("type", "text")
					.a("placeholder", "county")
					.a("class", "value suggestCountyKey w3-input w3-border w3-cell w3-cell-middle ")
					.a("name", "setCountyKey")
					.a("id", classApiMethodMethod, "_countyKey")
					.a("autocomplete", "off")
					.a("oninput", "suggestReportCardCountyKey($(this).val() ? searchSiteCountyFilters($(this.parentElement)) : [", pk == null ? "" : "{'name':'fq','value':'reportCardKeys:" + pk + "'}", "], $('#listReportCardCountyKey_", classApiMethodMethod, "'), ", pk, "); ")
				.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "CountyKey ").f().sx(htmCountyKey()).g("span");
		}
	}

	public void htmCountyKey(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardCountyKey").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/county?fq=reportCardKeys:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-pale-yellow w3-hover-pale-yellow ").f();
								e("i").a("class", "far fa-road ").f().g("i");
								sx("county");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate a county to this report card");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputCountyKey(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listReportCardCountyKey_", classApiMethodMethod).f();
								} g("ul");
								if(
										CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), SiteCounty.ROLES)
										|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), SiteCounty.ROLES)
										) {
									{ e("div").a("class", "w3-cell-row ").f();
										e("button")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
											.a("id", classApiMethodMethod, "_countyKey_add")
											.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postSiteCountyVals({ reportCardKeys: [ \"", pk, "\" ] }, function() {}, function() { addError($('#", classApiMethodMethod, "countyKey')); });")
											.f().sx("add a county")
										.g("button");
									} g("div");
								}
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// pupilsTotal //
	/////////////////

	/**	 The entity pupilsTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsTotal").o(pupilsTotal);

	/**	<br/> The entity pupilsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsTotal">Find the entity pupilsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsTotal(Wrap<Integer> c);

	public Integer getPupilsTotal() {
		return pupilsTotal;
	}

	public void setPupilsTotal(Integer pupilsTotal) {
		this.pupilsTotal = pupilsTotal;
		this.pupilsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsTotal = Integer.parseInt(o);
		this.pupilsTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsTotalInit() {
		if(!pupilsTotalWrap.alreadyInitialized) {
			_pupilsTotal(pupilsTotalWrap);
			if(pupilsTotal == null)
				setPupilsTotal(pupilsTotalWrap.o);
		}
		pupilsTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsTotal() {
		return pupilsTotal;
	}

	public String strPupilsTotal() {
		return pupilsTotal == null ? "" : pupilsTotal.toString();
	}

	public String jsonPupilsTotal() {
		return pupilsTotal == null ? "" : pupilsTotal.toString();
	}

	public String nomAffichagePupilsTotal() {
		return "pupils total";
	}

	public String htmTooltipPupilsTotal() {
		return null;
	}

	public String htmPupilsTotal() {
		return pupilsTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsTotal());
	}

	public void inputPupilsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "pupils total")
				.a("id", classApiMethodMethod, "_pupilsTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsTotal classReportCard inputReportCard", pk, "PupilsTotal w3-input w3-border ");
					a("name", "setPupilsTotal");
				} else {
					a("class", "valuePupilsTotal w3-input w3-border classReportCard inputReportCard", pk, "PupilsTotal w3-input w3-border ");
					a("name", "pupilsTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsTotal')); }, function() { addError($('#", classApiMethodMethod, "_pupilsTotal')); }); ");
				}
				a("value", strPupilsTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsTotal ").f().sx(htmPupilsTotal()).g("span");
		}
	}

	public void htmPupilsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsTotal").a("class", "").f().sx("pupils total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsTotal(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsTotal')); $('#", classApiMethodMethod, "_pupilsTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsTotal', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsTotal')); }, function() { addError($('#", classApiMethodMethod, "_pupilsTotal')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////
	// pupilsIndianFemale //
	////////////////////////

	/**	 The entity pupilsIndianFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsIndianFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsIndianFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsIndianFemale").o(pupilsIndianFemale);

	/**	<br/> The entity pupilsIndianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianFemale">Find the entity pupilsIndianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianFemale(Wrap<Integer> c);

	public Integer getPupilsIndianFemale() {
		return pupilsIndianFemale;
	}

	public void setPupilsIndianFemale(Integer pupilsIndianFemale) {
		this.pupilsIndianFemale = pupilsIndianFemale;
		this.pupilsIndianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianFemale = Integer.parseInt(o);
		this.pupilsIndianFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsIndianFemaleInit() {
		if(!pupilsIndianFemaleWrap.alreadyInitialized) {
			_pupilsIndianFemale(pupilsIndianFemaleWrap);
			if(pupilsIndianFemale == null)
				setPupilsIndianFemale(pupilsIndianFemaleWrap.o);
		}
		pupilsIndianFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsIndianFemale() {
		return pupilsIndianFemale;
	}

	public String strPupilsIndianFemale() {
		return pupilsIndianFemale == null ? "" : pupilsIndianFemale.toString();
	}

	public String jsonPupilsIndianFemale() {
		return pupilsIndianFemale == null ? "" : pupilsIndianFemale.toString();
	}

	public String nomAffichagePupilsIndianFemale() {
		return "Indian female";
	}

	public String htmTooltipPupilsIndianFemale() {
		return null;
	}

	public String htmPupilsIndianFemale() {
		return pupilsIndianFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsIndianFemale());
	}

	public void inputPupilsIndianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Indian female")
				.a("id", classApiMethodMethod, "_pupilsIndianFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsIndianFemale classReportCard inputReportCard", pk, "PupilsIndianFemale w3-input w3-border ");
					a("name", "setPupilsIndianFemale");
				} else {
					a("class", "valuePupilsIndianFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsIndianFemale w3-input w3-border ");
					a("name", "pupilsIndianFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsIndianFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsIndianFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsIndianFemale')); }); ");
				}
				a("value", strPupilsIndianFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsIndianFemale ").f().sx(htmPupilsIndianFemale()).g("span");
		}
	}

	public void htmPupilsIndianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsIndianFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsIndianFemale").a("class", "").f().sx("Indian female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsIndianFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsIndianFemale')); $('#", classApiMethodMethod, "_pupilsIndianFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsIndianFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsIndianFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsIndianFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////////
	// pupilsIndianMale //
	//////////////////////

	/**	 The entity pupilsIndianMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsIndianMale;
	@JsonIgnore
	public Wrap<Integer> pupilsIndianMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsIndianMale").o(pupilsIndianMale);

	/**	<br/> The entity pupilsIndianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianMale">Find the entity pupilsIndianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianMale(Wrap<Integer> c);

	public Integer getPupilsIndianMale() {
		return pupilsIndianMale;
	}

	public void setPupilsIndianMale(Integer pupilsIndianMale) {
		this.pupilsIndianMale = pupilsIndianMale;
		this.pupilsIndianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianMale = Integer.parseInt(o);
		this.pupilsIndianMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsIndianMaleInit() {
		if(!pupilsIndianMaleWrap.alreadyInitialized) {
			_pupilsIndianMale(pupilsIndianMaleWrap);
			if(pupilsIndianMale == null)
				setPupilsIndianMale(pupilsIndianMaleWrap.o);
		}
		pupilsIndianMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsIndianMale() {
		return pupilsIndianMale;
	}

	public String strPupilsIndianMale() {
		return pupilsIndianMale == null ? "" : pupilsIndianMale.toString();
	}

	public String jsonPupilsIndianMale() {
		return pupilsIndianMale == null ? "" : pupilsIndianMale.toString();
	}

	public String nomAffichagePupilsIndianMale() {
		return "Indian male";
	}

	public String htmTooltipPupilsIndianMale() {
		return null;
	}

	public String htmPupilsIndianMale() {
		return pupilsIndianMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsIndianMale());
	}

	public void inputPupilsIndianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Indian male")
				.a("id", classApiMethodMethod, "_pupilsIndianMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsIndianMale classReportCard inputReportCard", pk, "PupilsIndianMale w3-input w3-border ");
					a("name", "setPupilsIndianMale");
				} else {
					a("class", "valuePupilsIndianMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsIndianMale w3-input w3-border ");
					a("name", "pupilsIndianMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsIndianMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsIndianMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsIndianMale')); }); ");
				}
				a("value", strPupilsIndianMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsIndianMale ").f().sx(htmPupilsIndianMale()).g("span");
		}
	}

	public void htmPupilsIndianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsIndianMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsIndianMale").a("class", "").f().sx("Indian male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsIndianMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsIndianMale')); $('#", classApiMethodMethod, "_pupilsIndianMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsIndianMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsIndianMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsIndianMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////////
	// pupilsIndianTotal //
	///////////////////////

	/**	 The entity pupilsIndianTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsIndianTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsIndianTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsIndianTotal").o(pupilsIndianTotal);

	/**	<br/> The entity pupilsIndianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianTotal">Find the entity pupilsIndianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianTotal(Wrap<Integer> c);

	public Integer getPupilsIndianTotal() {
		return pupilsIndianTotal;
	}

	public void setPupilsIndianTotal(Integer pupilsIndianTotal) {
		this.pupilsIndianTotal = pupilsIndianTotal;
		this.pupilsIndianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianTotal = Integer.parseInt(o);
		this.pupilsIndianTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsIndianTotalInit() {
		if(!pupilsIndianTotalWrap.alreadyInitialized) {
			_pupilsIndianTotal(pupilsIndianTotalWrap);
			if(pupilsIndianTotal == null)
				setPupilsIndianTotal(pupilsIndianTotalWrap.o);
		}
		pupilsIndianTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsIndianTotal() {
		return pupilsIndianTotal;
	}

	public String strPupilsIndianTotal() {
		return pupilsIndianTotal == null ? "" : pupilsIndianTotal.toString();
	}

	public String jsonPupilsIndianTotal() {
		return pupilsIndianTotal == null ? "" : pupilsIndianTotal.toString();
	}

	public String nomAffichagePupilsIndianTotal() {
		return "Indians total";
	}

	public String htmTooltipPupilsIndianTotal() {
		return null;
	}

	public String htmPupilsIndianTotal() {
		return pupilsIndianTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsIndianTotal());
	}

	public void inputPupilsIndianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsIndianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Indians total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsIndianTotal ").f().sx(strPupilsIndianTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////
	// pupilsIndianPercent //
	/////////////////////////

	/**	 The entity pupilsIndianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsIndianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsIndianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsIndianPercent").o(pupilsIndianPercent);

	/**	<br/> The entity pupilsIndianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianPercent">Find the entity pupilsIndianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsIndianPercent() {
		return pupilsIndianPercent;
	}

	public void setPupilsIndianPercent(BigDecimal pupilsIndianPercent) {
		this.pupilsIndianPercent = pupilsIndianPercent;
		this.pupilsIndianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsIndianPercent(Double o) {
			this.pupilsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsIndianPercent(Integer o) {
			this.pupilsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsIndianPercentInit() {
		if(!pupilsIndianPercentWrap.alreadyInitialized) {
			_pupilsIndianPercent(pupilsIndianPercentWrap);
			if(pupilsIndianPercent == null)
				setPupilsIndianPercent(pupilsIndianPercentWrap.o);
		}
		pupilsIndianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsIndianPercent() {
		return pupilsIndianPercent == null ? null : pupilsIndianPercent.doubleValue();
	}

	public String strPupilsIndianPercent() {
		return pupilsIndianPercent == null ? "" : pupilsIndianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsIndianPercent() {
		return pupilsIndianPercent == null ? "" : pupilsIndianPercent.toString();
	}

	public String nomAffichagePupilsIndianPercent() {
		return "Indians percent";
	}

	public String htmTooltipPupilsIndianPercent() {
		return null;
	}

	public String htmPupilsIndianPercent() {
		return pupilsIndianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsIndianPercent());
	}

	public void inputPupilsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Indians percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsIndianPercent ").f().sx(strPupilsIndianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////
	// pupilsAsianFemale //
	///////////////////////

	/**	 The entity pupilsAsianFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsAsianFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsAsianFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsAsianFemale").o(pupilsAsianFemale);

	/**	<br/> The entity pupilsAsianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianFemale">Find the entity pupilsAsianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianFemale(Wrap<Integer> c);

	public Integer getPupilsAsianFemale() {
		return pupilsAsianFemale;
	}

	public void setPupilsAsianFemale(Integer pupilsAsianFemale) {
		this.pupilsAsianFemale = pupilsAsianFemale;
		this.pupilsAsianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianFemale = Integer.parseInt(o);
		this.pupilsAsianFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsAsianFemaleInit() {
		if(!pupilsAsianFemaleWrap.alreadyInitialized) {
			_pupilsAsianFemale(pupilsAsianFemaleWrap);
			if(pupilsAsianFemale == null)
				setPupilsAsianFemale(pupilsAsianFemaleWrap.o);
		}
		pupilsAsianFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsAsianFemale() {
		return pupilsAsianFemale;
	}

	public String strPupilsAsianFemale() {
		return pupilsAsianFemale == null ? "" : pupilsAsianFemale.toString();
	}

	public String jsonPupilsAsianFemale() {
		return pupilsAsianFemale == null ? "" : pupilsAsianFemale.toString();
	}

	public String nomAffichagePupilsAsianFemale() {
		return "Asian female";
	}

	public String htmTooltipPupilsAsianFemale() {
		return null;
	}

	public String htmPupilsAsianFemale() {
		return pupilsAsianFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsAsianFemale());
	}

	public void inputPupilsAsianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Asian female")
				.a("id", classApiMethodMethod, "_pupilsAsianFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsAsianFemale classReportCard inputReportCard", pk, "PupilsAsianFemale w3-input w3-border ");
					a("name", "setPupilsAsianFemale");
				} else {
					a("class", "valuePupilsAsianFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsAsianFemale w3-input w3-border ");
					a("name", "pupilsAsianFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsAsianFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsAsianFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsAsianFemale')); }); ");
				}
				a("value", strPupilsAsianFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsAsianFemale ").f().sx(htmPupilsAsianFemale()).g("span");
		}
	}

	public void htmPupilsAsianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsAsianFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsAsianFemale").a("class", "").f().sx("Asian female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsAsianFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsAsianFemale')); $('#", classApiMethodMethod, "_pupilsAsianFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsAsianFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsAsianFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsAsianFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////
	// pupilsAsianMale //
	/////////////////////

	/**	 The entity pupilsAsianMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsAsianMale;
	@JsonIgnore
	public Wrap<Integer> pupilsAsianMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsAsianMale").o(pupilsAsianMale);

	/**	<br/> The entity pupilsAsianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianMale">Find the entity pupilsAsianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianMale(Wrap<Integer> c);

	public Integer getPupilsAsianMale() {
		return pupilsAsianMale;
	}

	public void setPupilsAsianMale(Integer pupilsAsianMale) {
		this.pupilsAsianMale = pupilsAsianMale;
		this.pupilsAsianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianMale = Integer.parseInt(o);
		this.pupilsAsianMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsAsianMaleInit() {
		if(!pupilsAsianMaleWrap.alreadyInitialized) {
			_pupilsAsianMale(pupilsAsianMaleWrap);
			if(pupilsAsianMale == null)
				setPupilsAsianMale(pupilsAsianMaleWrap.o);
		}
		pupilsAsianMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsAsianMale() {
		return pupilsAsianMale;
	}

	public String strPupilsAsianMale() {
		return pupilsAsianMale == null ? "" : pupilsAsianMale.toString();
	}

	public String jsonPupilsAsianMale() {
		return pupilsAsianMale == null ? "" : pupilsAsianMale.toString();
	}

	public String nomAffichagePupilsAsianMale() {
		return "Asian male";
	}

	public String htmTooltipPupilsAsianMale() {
		return null;
	}

	public String htmPupilsAsianMale() {
		return pupilsAsianMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsAsianMale());
	}

	public void inputPupilsAsianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Asian male")
				.a("id", classApiMethodMethod, "_pupilsAsianMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsAsianMale classReportCard inputReportCard", pk, "PupilsAsianMale w3-input w3-border ");
					a("name", "setPupilsAsianMale");
				} else {
					a("class", "valuePupilsAsianMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsAsianMale w3-input w3-border ");
					a("name", "pupilsAsianMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsAsianMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsAsianMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsAsianMale')); }); ");
				}
				a("value", strPupilsAsianMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsAsianMale ").f().sx(htmPupilsAsianMale()).g("span");
		}
	}

	public void htmPupilsAsianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsAsianMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsAsianMale").a("class", "").f().sx("Asian male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsAsianMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsAsianMale')); $('#", classApiMethodMethod, "_pupilsAsianMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsAsianMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsAsianMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsAsianMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////////
	// pupilsAsianTotal //
	//////////////////////

	/**	 The entity pupilsAsianTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsAsianTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsAsianTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsAsianTotal").o(pupilsAsianTotal);

	/**	<br/> The entity pupilsAsianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianTotal">Find the entity pupilsAsianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianTotal(Wrap<Integer> c);

	public Integer getPupilsAsianTotal() {
		return pupilsAsianTotal;
	}

	public void setPupilsAsianTotal(Integer pupilsAsianTotal) {
		this.pupilsAsianTotal = pupilsAsianTotal;
		this.pupilsAsianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianTotal = Integer.parseInt(o);
		this.pupilsAsianTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsAsianTotalInit() {
		if(!pupilsAsianTotalWrap.alreadyInitialized) {
			_pupilsAsianTotal(pupilsAsianTotalWrap);
			if(pupilsAsianTotal == null)
				setPupilsAsianTotal(pupilsAsianTotalWrap.o);
		}
		pupilsAsianTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsAsianTotal() {
		return pupilsAsianTotal;
	}

	public String strPupilsAsianTotal() {
		return pupilsAsianTotal == null ? "" : pupilsAsianTotal.toString();
	}

	public String jsonPupilsAsianTotal() {
		return pupilsAsianTotal == null ? "" : pupilsAsianTotal.toString();
	}

	public String nomAffichagePupilsAsianTotal() {
		return "Asians total";
	}

	public String htmTooltipPupilsAsianTotal() {
		return null;
	}

	public String htmPupilsAsianTotal() {
		return pupilsAsianTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsAsianTotal());
	}

	public void inputPupilsAsianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsAsianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Asians total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsAsianTotal ").f().sx(strPupilsAsianTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// pupilsAsianPercent //
	////////////////////////

	/**	 The entity pupilsAsianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsAsianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsAsianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsAsianPercent").o(pupilsAsianPercent);

	/**	<br/> The entity pupilsAsianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianPercent">Find the entity pupilsAsianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsAsianPercent() {
		return pupilsAsianPercent;
	}

	public void setPupilsAsianPercent(BigDecimal pupilsAsianPercent) {
		this.pupilsAsianPercent = pupilsAsianPercent;
		this.pupilsAsianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsAsianPercent(Double o) {
			this.pupilsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsAsianPercent(Integer o) {
			this.pupilsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsAsianPercentInit() {
		if(!pupilsAsianPercentWrap.alreadyInitialized) {
			_pupilsAsianPercent(pupilsAsianPercentWrap);
			if(pupilsAsianPercent == null)
				setPupilsAsianPercent(pupilsAsianPercentWrap.o);
		}
		pupilsAsianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsAsianPercent() {
		return pupilsAsianPercent == null ? null : pupilsAsianPercent.doubleValue();
	}

	public String strPupilsAsianPercent() {
		return pupilsAsianPercent == null ? "" : pupilsAsianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsAsianPercent() {
		return pupilsAsianPercent == null ? "" : pupilsAsianPercent.toString();
	}

	public String nomAffichagePupilsAsianPercent() {
		return "Asians percent";
	}

	public String htmTooltipPupilsAsianPercent() {
		return null;
	}

	public String htmPupilsAsianPercent() {
		return pupilsAsianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsAsianPercent());
	}

	public void inputPupilsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Asians percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsAsianPercent ").f().sx(strPupilsAsianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////
	// pupilsHispanicFemale //
	//////////////////////////

	/**	 The entity pupilsHispanicFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsHispanicFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsHispanicFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsHispanicFemale").o(pupilsHispanicFemale);

	/**	<br/> The entity pupilsHispanicFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicFemale">Find the entity pupilsHispanicFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicFemale(Wrap<Integer> c);

	public Integer getPupilsHispanicFemale() {
		return pupilsHispanicFemale;
	}

	public void setPupilsHispanicFemale(Integer pupilsHispanicFemale) {
		this.pupilsHispanicFemale = pupilsHispanicFemale;
		this.pupilsHispanicFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicFemale = Integer.parseInt(o);
		this.pupilsHispanicFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsHispanicFemaleInit() {
		if(!pupilsHispanicFemaleWrap.alreadyInitialized) {
			_pupilsHispanicFemale(pupilsHispanicFemaleWrap);
			if(pupilsHispanicFemale == null)
				setPupilsHispanicFemale(pupilsHispanicFemaleWrap.o);
		}
		pupilsHispanicFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsHispanicFemale() {
		return pupilsHispanicFemale;
	}

	public String strPupilsHispanicFemale() {
		return pupilsHispanicFemale == null ? "" : pupilsHispanicFemale.toString();
	}

	public String jsonPupilsHispanicFemale() {
		return pupilsHispanicFemale == null ? "" : pupilsHispanicFemale.toString();
	}

	public String nomAffichagePupilsHispanicFemale() {
		return "Hispanic female";
	}

	public String htmTooltipPupilsHispanicFemale() {
		return null;
	}

	public String htmPupilsHispanicFemale() {
		return pupilsHispanicFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsHispanicFemale());
	}

	public void inputPupilsHispanicFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Hispanic female")
				.a("id", classApiMethodMethod, "_pupilsHispanicFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsHispanicFemale classReportCard inputReportCard", pk, "PupilsHispanicFemale w3-input w3-border ");
					a("name", "setPupilsHispanicFemale");
				} else {
					a("class", "valuePupilsHispanicFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsHispanicFemale w3-input w3-border ");
					a("name", "pupilsHispanicFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsHispanicFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsHispanicFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsHispanicFemale')); }); ");
				}
				a("value", strPupilsHispanicFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsHispanicFemale ").f().sx(htmPupilsHispanicFemale()).g("span");
		}
	}

	public void htmPupilsHispanicFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsHispanicFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsHispanicFemale").a("class", "").f().sx("Hispanic female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsHispanicFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsHispanicFemale')); $('#", classApiMethodMethod, "_pupilsHispanicFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsHispanicFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsHispanicFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsHispanicFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////
	// pupilsHispanicMale //
	////////////////////////

	/**	 The entity pupilsHispanicMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsHispanicMale;
	@JsonIgnore
	public Wrap<Integer> pupilsHispanicMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsHispanicMale").o(pupilsHispanicMale);

	/**	<br/> The entity pupilsHispanicMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicMale">Find the entity pupilsHispanicMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicMale(Wrap<Integer> c);

	public Integer getPupilsHispanicMale() {
		return pupilsHispanicMale;
	}

	public void setPupilsHispanicMale(Integer pupilsHispanicMale) {
		this.pupilsHispanicMale = pupilsHispanicMale;
		this.pupilsHispanicMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicMale = Integer.parseInt(o);
		this.pupilsHispanicMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsHispanicMaleInit() {
		if(!pupilsHispanicMaleWrap.alreadyInitialized) {
			_pupilsHispanicMale(pupilsHispanicMaleWrap);
			if(pupilsHispanicMale == null)
				setPupilsHispanicMale(pupilsHispanicMaleWrap.o);
		}
		pupilsHispanicMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsHispanicMale() {
		return pupilsHispanicMale;
	}

	public String strPupilsHispanicMale() {
		return pupilsHispanicMale == null ? "" : pupilsHispanicMale.toString();
	}

	public String jsonPupilsHispanicMale() {
		return pupilsHispanicMale == null ? "" : pupilsHispanicMale.toString();
	}

	public String nomAffichagePupilsHispanicMale() {
		return "Hispanic male";
	}

	public String htmTooltipPupilsHispanicMale() {
		return null;
	}

	public String htmPupilsHispanicMale() {
		return pupilsHispanicMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsHispanicMale());
	}

	public void inputPupilsHispanicMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Hispanic male")
				.a("id", classApiMethodMethod, "_pupilsHispanicMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsHispanicMale classReportCard inputReportCard", pk, "PupilsHispanicMale w3-input w3-border ");
					a("name", "setPupilsHispanicMale");
				} else {
					a("class", "valuePupilsHispanicMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsHispanicMale w3-input w3-border ");
					a("name", "pupilsHispanicMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsHispanicMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsHispanicMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsHispanicMale')); }); ");
				}
				a("value", strPupilsHispanicMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsHispanicMale ").f().sx(htmPupilsHispanicMale()).g("span");
		}
	}

	public void htmPupilsHispanicMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsHispanicMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsHispanicMale").a("class", "").f().sx("Hispanic male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsHispanicMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsHispanicMale')); $('#", classApiMethodMethod, "_pupilsHispanicMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsHispanicMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsHispanicMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsHispanicMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////////
	// pupilsHispanicTotal //
	/////////////////////////

	/**	 The entity pupilsHispanicTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsHispanicTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsHispanicTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsHispanicTotal").o(pupilsHispanicTotal);

	/**	<br/> The entity pupilsHispanicTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicTotal">Find the entity pupilsHispanicTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicTotal(Wrap<Integer> c);

	public Integer getPupilsHispanicTotal() {
		return pupilsHispanicTotal;
	}

	public void setPupilsHispanicTotal(Integer pupilsHispanicTotal) {
		this.pupilsHispanicTotal = pupilsHispanicTotal;
		this.pupilsHispanicTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicTotal = Integer.parseInt(o);
		this.pupilsHispanicTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsHispanicTotalInit() {
		if(!pupilsHispanicTotalWrap.alreadyInitialized) {
			_pupilsHispanicTotal(pupilsHispanicTotalWrap);
			if(pupilsHispanicTotal == null)
				setPupilsHispanicTotal(pupilsHispanicTotalWrap.o);
		}
		pupilsHispanicTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsHispanicTotal() {
		return pupilsHispanicTotal;
	}

	public String strPupilsHispanicTotal() {
		return pupilsHispanicTotal == null ? "" : pupilsHispanicTotal.toString();
	}

	public String jsonPupilsHispanicTotal() {
		return pupilsHispanicTotal == null ? "" : pupilsHispanicTotal.toString();
	}

	public String nomAffichagePupilsHispanicTotal() {
		return "Hispanics total";
	}

	public String htmTooltipPupilsHispanicTotal() {
		return null;
	}

	public String htmPupilsHispanicTotal() {
		return pupilsHispanicTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsHispanicTotal());
	}

	public void inputPupilsHispanicTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsHispanicTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Hispanics total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsHispanicTotal ").f().sx(strPupilsHispanicTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////
	// pupilsHispanicPercent //
	///////////////////////////

	/**	 The entity pupilsHispanicPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsHispanicPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsHispanicPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsHispanicPercent").o(pupilsHispanicPercent);

	/**	<br/> The entity pupilsHispanicPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicPercent">Find the entity pupilsHispanicPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsHispanicPercent() {
		return pupilsHispanicPercent;
	}

	public void setPupilsHispanicPercent(BigDecimal pupilsHispanicPercent) {
		this.pupilsHispanicPercent = pupilsHispanicPercent;
		this.pupilsHispanicPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsHispanicPercent(Double o) {
			this.pupilsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsHispanicPercent(Integer o) {
			this.pupilsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsHispanicPercentInit() {
		if(!pupilsHispanicPercentWrap.alreadyInitialized) {
			_pupilsHispanicPercent(pupilsHispanicPercentWrap);
			if(pupilsHispanicPercent == null)
				setPupilsHispanicPercent(pupilsHispanicPercentWrap.o);
		}
		pupilsHispanicPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsHispanicPercent() {
		return pupilsHispanicPercent == null ? null : pupilsHispanicPercent.doubleValue();
	}

	public String strPupilsHispanicPercent() {
		return pupilsHispanicPercent == null ? "" : pupilsHispanicPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsHispanicPercent() {
		return pupilsHispanicPercent == null ? "" : pupilsHispanicPercent.toString();
	}

	public String nomAffichagePupilsHispanicPercent() {
		return "Hispanics percent";
	}

	public String htmTooltipPupilsHispanicPercent() {
		return null;
	}

	public String htmPupilsHispanicPercent() {
		return pupilsHispanicPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsHispanicPercent());
	}

	public void inputPupilsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Hispanics percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsHispanicPercent ").f().sx(strPupilsHispanicPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////
	// pupilsBlackFemale //
	///////////////////////

	/**	 The entity pupilsBlackFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsBlackFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsBlackFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsBlackFemale").o(pupilsBlackFemale);

	/**	<br/> The entity pupilsBlackFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackFemale">Find the entity pupilsBlackFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackFemale(Wrap<Integer> c);

	public Integer getPupilsBlackFemale() {
		return pupilsBlackFemale;
	}

	public void setPupilsBlackFemale(Integer pupilsBlackFemale) {
		this.pupilsBlackFemale = pupilsBlackFemale;
		this.pupilsBlackFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackFemale = Integer.parseInt(o);
		this.pupilsBlackFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsBlackFemaleInit() {
		if(!pupilsBlackFemaleWrap.alreadyInitialized) {
			_pupilsBlackFemale(pupilsBlackFemaleWrap);
			if(pupilsBlackFemale == null)
				setPupilsBlackFemale(pupilsBlackFemaleWrap.o);
		}
		pupilsBlackFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsBlackFemale() {
		return pupilsBlackFemale;
	}

	public String strPupilsBlackFemale() {
		return pupilsBlackFemale == null ? "" : pupilsBlackFemale.toString();
	}

	public String jsonPupilsBlackFemale() {
		return pupilsBlackFemale == null ? "" : pupilsBlackFemale.toString();
	}

	public String nomAffichagePupilsBlackFemale() {
		return "Black female";
	}

	public String htmTooltipPupilsBlackFemale() {
		return null;
	}

	public String htmPupilsBlackFemale() {
		return pupilsBlackFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsBlackFemale());
	}

	public void inputPupilsBlackFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Black female")
				.a("id", classApiMethodMethod, "_pupilsBlackFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsBlackFemale classReportCard inputReportCard", pk, "PupilsBlackFemale w3-input w3-border ");
					a("name", "setPupilsBlackFemale");
				} else {
					a("class", "valuePupilsBlackFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsBlackFemale w3-input w3-border ");
					a("name", "pupilsBlackFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsBlackFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsBlackFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsBlackFemale')); }); ");
				}
				a("value", strPupilsBlackFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsBlackFemale ").f().sx(htmPupilsBlackFemale()).g("span");
		}
	}

	public void htmPupilsBlackFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsBlackFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsBlackFemale").a("class", "").f().sx("Black female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsBlackFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsBlackFemale')); $('#", classApiMethodMethod, "_pupilsBlackFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsBlackFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsBlackFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsBlackFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////
	// pupilsBlackMale //
	/////////////////////

	/**	 The entity pupilsBlackMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsBlackMale;
	@JsonIgnore
	public Wrap<Integer> pupilsBlackMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsBlackMale").o(pupilsBlackMale);

	/**	<br/> The entity pupilsBlackMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackMale">Find the entity pupilsBlackMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackMale(Wrap<Integer> c);

	public Integer getPupilsBlackMale() {
		return pupilsBlackMale;
	}

	public void setPupilsBlackMale(Integer pupilsBlackMale) {
		this.pupilsBlackMale = pupilsBlackMale;
		this.pupilsBlackMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackMale = Integer.parseInt(o);
		this.pupilsBlackMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsBlackMaleInit() {
		if(!pupilsBlackMaleWrap.alreadyInitialized) {
			_pupilsBlackMale(pupilsBlackMaleWrap);
			if(pupilsBlackMale == null)
				setPupilsBlackMale(pupilsBlackMaleWrap.o);
		}
		pupilsBlackMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsBlackMale() {
		return pupilsBlackMale;
	}

	public String strPupilsBlackMale() {
		return pupilsBlackMale == null ? "" : pupilsBlackMale.toString();
	}

	public String jsonPupilsBlackMale() {
		return pupilsBlackMale == null ? "" : pupilsBlackMale.toString();
	}

	public String nomAffichagePupilsBlackMale() {
		return "Black male";
	}

	public String htmTooltipPupilsBlackMale() {
		return null;
	}

	public String htmPupilsBlackMale() {
		return pupilsBlackMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsBlackMale());
	}

	public void inputPupilsBlackMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Black male")
				.a("id", classApiMethodMethod, "_pupilsBlackMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsBlackMale classReportCard inputReportCard", pk, "PupilsBlackMale w3-input w3-border ");
					a("name", "setPupilsBlackMale");
				} else {
					a("class", "valuePupilsBlackMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsBlackMale w3-input w3-border ");
					a("name", "pupilsBlackMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsBlackMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsBlackMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsBlackMale')); }); ");
				}
				a("value", strPupilsBlackMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsBlackMale ").f().sx(htmPupilsBlackMale()).g("span");
		}
	}

	public void htmPupilsBlackMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsBlackMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsBlackMale").a("class", "").f().sx("Black male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsBlackMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsBlackMale')); $('#", classApiMethodMethod, "_pupilsBlackMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsBlackMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsBlackMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsBlackMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////////
	// pupilsBlackTotal //
	//////////////////////

	/**	 The entity pupilsBlackTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsBlackTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsBlackTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsBlackTotal").o(pupilsBlackTotal);

	/**	<br/> The entity pupilsBlackTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackTotal">Find the entity pupilsBlackTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackTotal(Wrap<Integer> c);

	public Integer getPupilsBlackTotal() {
		return pupilsBlackTotal;
	}

	public void setPupilsBlackTotal(Integer pupilsBlackTotal) {
		this.pupilsBlackTotal = pupilsBlackTotal;
		this.pupilsBlackTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackTotal = Integer.parseInt(o);
		this.pupilsBlackTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsBlackTotalInit() {
		if(!pupilsBlackTotalWrap.alreadyInitialized) {
			_pupilsBlackTotal(pupilsBlackTotalWrap);
			if(pupilsBlackTotal == null)
				setPupilsBlackTotal(pupilsBlackTotalWrap.o);
		}
		pupilsBlackTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsBlackTotal() {
		return pupilsBlackTotal;
	}

	public String strPupilsBlackTotal() {
		return pupilsBlackTotal == null ? "" : pupilsBlackTotal.toString();
	}

	public String jsonPupilsBlackTotal() {
		return pupilsBlackTotal == null ? "" : pupilsBlackTotal.toString();
	}

	public String nomAffichagePupilsBlackTotal() {
		return "Blacks total";
	}

	public String htmTooltipPupilsBlackTotal() {
		return null;
	}

	public String htmPupilsBlackTotal() {
		return pupilsBlackTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsBlackTotal());
	}

	public void inputPupilsBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Blacks total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsBlackTotal ").f().sx(strPupilsBlackTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// pupilsBlackPercent //
	////////////////////////

	/**	 The entity pupilsBlackPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsBlackPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsBlackPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsBlackPercent").o(pupilsBlackPercent);

	/**	<br/> The entity pupilsBlackPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackPercent">Find the entity pupilsBlackPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsBlackPercent() {
		return pupilsBlackPercent;
	}

	public void setPupilsBlackPercent(BigDecimal pupilsBlackPercent) {
		this.pupilsBlackPercent = pupilsBlackPercent;
		this.pupilsBlackPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsBlackPercent(Double o) {
			this.pupilsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsBlackPercent(Integer o) {
			this.pupilsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsBlackPercentInit() {
		if(!pupilsBlackPercentWrap.alreadyInitialized) {
			_pupilsBlackPercent(pupilsBlackPercentWrap);
			if(pupilsBlackPercent == null)
				setPupilsBlackPercent(pupilsBlackPercentWrap.o);
		}
		pupilsBlackPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsBlackPercent() {
		return pupilsBlackPercent == null ? null : pupilsBlackPercent.doubleValue();
	}

	public String strPupilsBlackPercent() {
		return pupilsBlackPercent == null ? "" : pupilsBlackPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsBlackPercent() {
		return pupilsBlackPercent == null ? "" : pupilsBlackPercent.toString();
	}

	public String nomAffichagePupilsBlackPercent() {
		return "Blacks percent";
	}

	public String htmTooltipPupilsBlackPercent() {
		return null;
	}

	public String htmPupilsBlackPercent() {
		return pupilsBlackPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsBlackPercent());
	}

	public void inputPupilsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Blacks percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsBlackPercent ").f().sx(strPupilsBlackPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////
	// pupilsWhiteFemale //
	///////////////////////

	/**	 The entity pupilsWhiteFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsWhiteFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsWhiteFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsWhiteFemale").o(pupilsWhiteFemale);

	/**	<br/> The entity pupilsWhiteFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteFemale">Find the entity pupilsWhiteFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteFemale(Wrap<Integer> c);

	public Integer getPupilsWhiteFemale() {
		return pupilsWhiteFemale;
	}

	public void setPupilsWhiteFemale(Integer pupilsWhiteFemale) {
		this.pupilsWhiteFemale = pupilsWhiteFemale;
		this.pupilsWhiteFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteFemale = Integer.parseInt(o);
		this.pupilsWhiteFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsWhiteFemaleInit() {
		if(!pupilsWhiteFemaleWrap.alreadyInitialized) {
			_pupilsWhiteFemale(pupilsWhiteFemaleWrap);
			if(pupilsWhiteFemale == null)
				setPupilsWhiteFemale(pupilsWhiteFemaleWrap.o);
		}
		pupilsWhiteFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsWhiteFemale() {
		return pupilsWhiteFemale;
	}

	public String strPupilsWhiteFemale() {
		return pupilsWhiteFemale == null ? "" : pupilsWhiteFemale.toString();
	}

	public String jsonPupilsWhiteFemale() {
		return pupilsWhiteFemale == null ? "" : pupilsWhiteFemale.toString();
	}

	public String nomAffichagePupilsWhiteFemale() {
		return "White female";
	}

	public String htmTooltipPupilsWhiteFemale() {
		return null;
	}

	public String htmPupilsWhiteFemale() {
		return pupilsWhiteFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsWhiteFemale());
	}

	public void inputPupilsWhiteFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "White female")
				.a("id", classApiMethodMethod, "_pupilsWhiteFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsWhiteFemale classReportCard inputReportCard", pk, "PupilsWhiteFemale w3-input w3-border ");
					a("name", "setPupilsWhiteFemale");
				} else {
					a("class", "valuePupilsWhiteFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsWhiteFemale w3-input w3-border ");
					a("name", "pupilsWhiteFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsWhiteFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsWhiteFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsWhiteFemale')); }); ");
				}
				a("value", strPupilsWhiteFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsWhiteFemale ").f().sx(htmPupilsWhiteFemale()).g("span");
		}
	}

	public void htmPupilsWhiteFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsWhiteFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsWhiteFemale").a("class", "").f().sx("White female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsWhiteFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsWhiteFemale')); $('#", classApiMethodMethod, "_pupilsWhiteFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsWhiteFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsWhiteFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsWhiteFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////
	// pupilsWhiteMale //
	/////////////////////

	/**	 The entity pupilsWhiteMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsWhiteMale;
	@JsonIgnore
	public Wrap<Integer> pupilsWhiteMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsWhiteMale").o(pupilsWhiteMale);

	/**	<br/> The entity pupilsWhiteMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteMale">Find the entity pupilsWhiteMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteMale(Wrap<Integer> c);

	public Integer getPupilsWhiteMale() {
		return pupilsWhiteMale;
	}

	public void setPupilsWhiteMale(Integer pupilsWhiteMale) {
		this.pupilsWhiteMale = pupilsWhiteMale;
		this.pupilsWhiteMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteMale = Integer.parseInt(o);
		this.pupilsWhiteMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsWhiteMaleInit() {
		if(!pupilsWhiteMaleWrap.alreadyInitialized) {
			_pupilsWhiteMale(pupilsWhiteMaleWrap);
			if(pupilsWhiteMale == null)
				setPupilsWhiteMale(pupilsWhiteMaleWrap.o);
		}
		pupilsWhiteMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsWhiteMale() {
		return pupilsWhiteMale;
	}

	public String strPupilsWhiteMale() {
		return pupilsWhiteMale == null ? "" : pupilsWhiteMale.toString();
	}

	public String jsonPupilsWhiteMale() {
		return pupilsWhiteMale == null ? "" : pupilsWhiteMale.toString();
	}

	public String nomAffichagePupilsWhiteMale() {
		return "White male";
	}

	public String htmTooltipPupilsWhiteMale() {
		return null;
	}

	public String htmPupilsWhiteMale() {
		return pupilsWhiteMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsWhiteMale());
	}

	public void inputPupilsWhiteMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "White male")
				.a("id", classApiMethodMethod, "_pupilsWhiteMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsWhiteMale classReportCard inputReportCard", pk, "PupilsWhiteMale w3-input w3-border ");
					a("name", "setPupilsWhiteMale");
				} else {
					a("class", "valuePupilsWhiteMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsWhiteMale w3-input w3-border ");
					a("name", "pupilsWhiteMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsWhiteMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsWhiteMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsWhiteMale')); }); ");
				}
				a("value", strPupilsWhiteMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsWhiteMale ").f().sx(htmPupilsWhiteMale()).g("span");
		}
	}

	public void htmPupilsWhiteMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsWhiteMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsWhiteMale").a("class", "").f().sx("White male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsWhiteMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsWhiteMale')); $('#", classApiMethodMethod, "_pupilsWhiteMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsWhiteMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsWhiteMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsWhiteMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////////
	// pupilsWhiteTotal //
	//////////////////////

	/**	 The entity pupilsWhiteTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsWhiteTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsWhiteTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsWhiteTotal").o(pupilsWhiteTotal);

	/**	<br/> The entity pupilsWhiteTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteTotal">Find the entity pupilsWhiteTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteTotal(Wrap<Integer> c);

	public Integer getPupilsWhiteTotal() {
		return pupilsWhiteTotal;
	}

	public void setPupilsWhiteTotal(Integer pupilsWhiteTotal) {
		this.pupilsWhiteTotal = pupilsWhiteTotal;
		this.pupilsWhiteTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteTotal = Integer.parseInt(o);
		this.pupilsWhiteTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsWhiteTotalInit() {
		if(!pupilsWhiteTotalWrap.alreadyInitialized) {
			_pupilsWhiteTotal(pupilsWhiteTotalWrap);
			if(pupilsWhiteTotal == null)
				setPupilsWhiteTotal(pupilsWhiteTotalWrap.o);
		}
		pupilsWhiteTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsWhiteTotal() {
		return pupilsWhiteTotal;
	}

	public String strPupilsWhiteTotal() {
		return pupilsWhiteTotal == null ? "" : pupilsWhiteTotal.toString();
	}

	public String jsonPupilsWhiteTotal() {
		return pupilsWhiteTotal == null ? "" : pupilsWhiteTotal.toString();
	}

	public String nomAffichagePupilsWhiteTotal() {
		return "Whites total";
	}

	public String htmTooltipPupilsWhiteTotal() {
		return null;
	}

	public String htmPupilsWhiteTotal() {
		return pupilsWhiteTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsWhiteTotal());
	}

	public void inputPupilsWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Whites total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsWhiteTotal ").f().sx(strPupilsWhiteTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// pupilsWhitePercent //
	////////////////////////

	/**	 The entity pupilsWhitePercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsWhitePercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsWhitePercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsWhitePercent").o(pupilsWhitePercent);

	/**	<br/> The entity pupilsWhitePercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhitePercent">Find the entity pupilsWhitePercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhitePercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsWhitePercent() {
		return pupilsWhitePercent;
	}

	public void setPupilsWhitePercent(BigDecimal pupilsWhitePercent) {
		this.pupilsWhitePercent = pupilsWhitePercent;
		this.pupilsWhitePercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhitePercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsWhitePercent(Double o) {
			this.pupilsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsWhitePercent(Integer o) {
			this.pupilsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsWhitePercentInit() {
		if(!pupilsWhitePercentWrap.alreadyInitialized) {
			_pupilsWhitePercent(pupilsWhitePercentWrap);
			if(pupilsWhitePercent == null)
				setPupilsWhitePercent(pupilsWhitePercentWrap.o);
		}
		pupilsWhitePercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsWhitePercent() {
		return pupilsWhitePercent == null ? null : pupilsWhitePercent.doubleValue();
	}

	public String strPupilsWhitePercent() {
		return pupilsWhitePercent == null ? "" : pupilsWhitePercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsWhitePercent() {
		return pupilsWhitePercent == null ? "" : pupilsWhitePercent.toString();
	}

	public String nomAffichagePupilsWhitePercent() {
		return "Whites percent";
	}

	public String htmTooltipPupilsWhitePercent() {
		return null;
	}

	public String htmPupilsWhitePercent() {
		return pupilsWhitePercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsWhitePercent());
	}

	public void inputPupilsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Whites percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsWhitePercent ").f().sx(strPupilsWhitePercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////
	// pupilsPacificIslanderFemale //
	/////////////////////////////////

	/**	 The entity pupilsPacificIslanderFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsPacificIslanderFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsPacificIslanderFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsPacificIslanderFemale").o(pupilsPacificIslanderFemale);

	/**	<br/> The entity pupilsPacificIslanderFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderFemale">Find the entity pupilsPacificIslanderFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderFemale(Wrap<Integer> c);

	public Integer getPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale;
	}

	public void setPupilsPacificIslanderFemale(Integer pupilsPacificIslanderFemale) {
		this.pupilsPacificIslanderFemale = pupilsPacificIslanderFemale;
		this.pupilsPacificIslanderFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderFemale = Integer.parseInt(o);
		this.pupilsPacificIslanderFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsPacificIslanderFemaleInit() {
		if(!pupilsPacificIslanderFemaleWrap.alreadyInitialized) {
			_pupilsPacificIslanderFemale(pupilsPacificIslanderFemaleWrap);
			if(pupilsPacificIslanderFemale == null)
				setPupilsPacificIslanderFemale(pupilsPacificIslanderFemaleWrap.o);
		}
		pupilsPacificIslanderFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale;
	}

	public String strPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale == null ? "" : pupilsPacificIslanderFemale.toString();
	}

	public String jsonPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale == null ? "" : pupilsPacificIslanderFemale.toString();
	}

	public String nomAffichagePupilsPacificIslanderFemale() {
		return "Pacific Islander female";
	}

	public String htmTooltipPupilsPacificIslanderFemale() {
		return null;
	}

	public String htmPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsPacificIslanderFemale());
	}

	public void inputPupilsPacificIslanderFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Pacific Islander female")
				.a("id", classApiMethodMethod, "_pupilsPacificIslanderFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsPacificIslanderFemale classReportCard inputReportCard", pk, "PupilsPacificIslanderFemale w3-input w3-border ");
					a("name", "setPupilsPacificIslanderFemale");
				} else {
					a("class", "valuePupilsPacificIslanderFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsPacificIslanderFemale w3-input w3-border ");
					a("name", "pupilsPacificIslanderFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsPacificIslanderFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsPacificIslanderFemale')); }); ");
				}
				a("value", strPupilsPacificIslanderFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsPacificIslanderFemale ").f().sx(htmPupilsPacificIslanderFemale()).g("span");
		}
	}

	public void htmPupilsPacificIslanderFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsPacificIslanderFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsPacificIslanderFemale").a("class", "").f().sx("Pacific Islander female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsPacificIslanderFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderFemale')); $('#", classApiMethodMethod, "_pupilsPacificIslanderFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsPacificIslanderFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsPacificIslanderFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////////////////
	// pupilsPacificIslanderMale //
	///////////////////////////////

	/**	 The entity pupilsPacificIslanderMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsPacificIslanderMale;
	@JsonIgnore
	public Wrap<Integer> pupilsPacificIslanderMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsPacificIslanderMale").o(pupilsPacificIslanderMale);

	/**	<br/> The entity pupilsPacificIslanderMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderMale">Find the entity pupilsPacificIslanderMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderMale(Wrap<Integer> c);

	public Integer getPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale;
	}

	public void setPupilsPacificIslanderMale(Integer pupilsPacificIslanderMale) {
		this.pupilsPacificIslanderMale = pupilsPacificIslanderMale;
		this.pupilsPacificIslanderMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderMale = Integer.parseInt(o);
		this.pupilsPacificIslanderMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsPacificIslanderMaleInit() {
		if(!pupilsPacificIslanderMaleWrap.alreadyInitialized) {
			_pupilsPacificIslanderMale(pupilsPacificIslanderMaleWrap);
			if(pupilsPacificIslanderMale == null)
				setPupilsPacificIslanderMale(pupilsPacificIslanderMaleWrap.o);
		}
		pupilsPacificIslanderMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale;
	}

	public String strPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale == null ? "" : pupilsPacificIslanderMale.toString();
	}

	public String jsonPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale == null ? "" : pupilsPacificIslanderMale.toString();
	}

	public String nomAffichagePupilsPacificIslanderMale() {
		return "Pacific Islander male";
	}

	public String htmTooltipPupilsPacificIslanderMale() {
		return null;
	}

	public String htmPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsPacificIslanderMale());
	}

	public void inputPupilsPacificIslanderMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Pacific Islander male")
				.a("id", classApiMethodMethod, "_pupilsPacificIslanderMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsPacificIslanderMale classReportCard inputReportCard", pk, "PupilsPacificIslanderMale w3-input w3-border ");
					a("name", "setPupilsPacificIslanderMale");
				} else {
					a("class", "valuePupilsPacificIslanderMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsPacificIslanderMale w3-input w3-border ");
					a("name", "pupilsPacificIslanderMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsPacificIslanderMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsPacificIslanderMale')); }); ");
				}
				a("value", strPupilsPacificIslanderMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsPacificIslanderMale ").f().sx(htmPupilsPacificIslanderMale()).g("span");
		}
	}

	public void htmPupilsPacificIslanderMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsPacificIslanderMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsPacificIslanderMale").a("class", "").f().sx("Pacific Islander male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsPacificIslanderMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderMale')); $('#", classApiMethodMethod, "_pupilsPacificIslanderMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsPacificIslanderMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsPacificIslanderMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsPacificIslanderMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////////////
	// pupilsPacificIslanderTotal //
	////////////////////////////////

	/**	 The entity pupilsPacificIslanderTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsPacificIslanderTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsPacificIslanderTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsPacificIslanderTotal").o(pupilsPacificIslanderTotal);

	/**	<br/> The entity pupilsPacificIslanderTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderTotal">Find the entity pupilsPacificIslanderTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderTotal(Wrap<Integer> c);

	public Integer getPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal;
	}

	public void setPupilsPacificIslanderTotal(Integer pupilsPacificIslanderTotal) {
		this.pupilsPacificIslanderTotal = pupilsPacificIslanderTotal;
		this.pupilsPacificIslanderTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderTotal = Integer.parseInt(o);
		this.pupilsPacificIslanderTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsPacificIslanderTotalInit() {
		if(!pupilsPacificIslanderTotalWrap.alreadyInitialized) {
			_pupilsPacificIslanderTotal(pupilsPacificIslanderTotalWrap);
			if(pupilsPacificIslanderTotal == null)
				setPupilsPacificIslanderTotal(pupilsPacificIslanderTotalWrap.o);
		}
		pupilsPacificIslanderTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal;
	}

	public String strPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal == null ? "" : pupilsPacificIslanderTotal.toString();
	}

	public String jsonPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal == null ? "" : pupilsPacificIslanderTotal.toString();
	}

	public String nomAffichagePupilsPacificIslanderTotal() {
		return "Pacific Islanders total";
	}

	public String htmTooltipPupilsPacificIslanderTotal() {
		return null;
	}

	public String htmPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsPacificIslanderTotal());
	}

	public void inputPupilsPacificIslanderTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsPacificIslanderTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Pacific Islanders total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsPacificIslanderTotal ").f().sx(strPupilsPacificIslanderTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////
	// pupilsPacificIslanderPercent //
	//////////////////////////////////

	/**	 The entity pupilsPacificIslanderPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsPacificIslanderPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsPacificIslanderPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsPacificIslanderPercent").o(pupilsPacificIslanderPercent);

	/**	<br/> The entity pupilsPacificIslanderPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderPercent">Find the entity pupilsPacificIslanderPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent;
	}

	public void setPupilsPacificIslanderPercent(BigDecimal pupilsPacificIslanderPercent) {
		this.pupilsPacificIslanderPercent = pupilsPacificIslanderPercent;
		this.pupilsPacificIslanderPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsPacificIslanderPercent(Double o) {
			this.pupilsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsPacificIslanderPercent(Integer o) {
			this.pupilsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsPacificIslanderPercentInit() {
		if(!pupilsPacificIslanderPercentWrap.alreadyInitialized) {
			_pupilsPacificIslanderPercent(pupilsPacificIslanderPercentWrap);
			if(pupilsPacificIslanderPercent == null)
				setPupilsPacificIslanderPercent(pupilsPacificIslanderPercentWrap.o);
		}
		pupilsPacificIslanderPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent == null ? null : pupilsPacificIslanderPercent.doubleValue();
	}

	public String strPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent == null ? "" : pupilsPacificIslanderPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent == null ? "" : pupilsPacificIslanderPercent.toString();
	}

	public String nomAffichagePupilsPacificIslanderPercent() {
		return "Pacific Islanders percent";
	}

	public String htmTooltipPupilsPacificIslanderPercent() {
		return null;
	}

	public String htmPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsPacificIslanderPercent());
	}

	public void inputPupilsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Pacific Islanders percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsPacificIslanderPercent ").f().sx(strPupilsPacificIslanderPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////
	// pupilsMultiRacialFemale //
	/////////////////////////////

	/**	 The entity pupilsMultiRacialFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsMultiRacialFemale;
	@JsonIgnore
	public Wrap<Integer> pupilsMultiRacialFemaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsMultiRacialFemale").o(pupilsMultiRacialFemale);

	/**	<br/> The entity pupilsMultiRacialFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialFemale">Find the entity pupilsMultiRacialFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialFemale(Wrap<Integer> c);

	public Integer getPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale;
	}

	public void setPupilsMultiRacialFemale(Integer pupilsMultiRacialFemale) {
		this.pupilsMultiRacialFemale = pupilsMultiRacialFemale;
		this.pupilsMultiRacialFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialFemale = Integer.parseInt(o);
		this.pupilsMultiRacialFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsMultiRacialFemaleInit() {
		if(!pupilsMultiRacialFemaleWrap.alreadyInitialized) {
			_pupilsMultiRacialFemale(pupilsMultiRacialFemaleWrap);
			if(pupilsMultiRacialFemale == null)
				setPupilsMultiRacialFemale(pupilsMultiRacialFemaleWrap.o);
		}
		pupilsMultiRacialFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale;
	}

	public String strPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale == null ? "" : pupilsMultiRacialFemale.toString();
	}

	public String jsonPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale == null ? "" : pupilsMultiRacialFemale.toString();
	}

	public String nomAffichagePupilsMultiRacialFemale() {
		return "Multi Racial female";
	}

	public String htmTooltipPupilsMultiRacialFemale() {
		return null;
	}

	public String htmPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsMultiRacialFemale());
	}

	public void inputPupilsMultiRacialFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Multi Racial female")
				.a("id", classApiMethodMethod, "_pupilsMultiRacialFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsMultiRacialFemale classReportCard inputReportCard", pk, "PupilsMultiRacialFemale w3-input w3-border ");
					a("name", "setPupilsMultiRacialFemale");
				} else {
					a("class", "valuePupilsMultiRacialFemale w3-input w3-border classReportCard inputReportCard", pk, "PupilsMultiRacialFemale w3-input w3-border ");
					a("name", "pupilsMultiRacialFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsMultiRacialFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsMultiRacialFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsMultiRacialFemale')); }); ");
				}
				a("value", strPupilsMultiRacialFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsMultiRacialFemale ").f().sx(htmPupilsMultiRacialFemale()).g("span");
		}
	}

	public void htmPupilsMultiRacialFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsMultiRacialFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsMultiRacialFemale").a("class", "").f().sx("Multi Racial female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsMultiRacialFemale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsMultiRacialFemale')); $('#", classApiMethodMethod, "_pupilsMultiRacialFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsMultiRacialFemale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsMultiRacialFemale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsMultiRacialFemale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////////////
	// pupilsMultiRacialMale //
	///////////////////////////

	/**	 The entity pupilsMultiRacialMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsMultiRacialMale;
	@JsonIgnore
	public Wrap<Integer> pupilsMultiRacialMaleWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsMultiRacialMale").o(pupilsMultiRacialMale);

	/**	<br/> The entity pupilsMultiRacialMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialMale">Find the entity pupilsMultiRacialMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialMale(Wrap<Integer> c);

	public Integer getPupilsMultiRacialMale() {
		return pupilsMultiRacialMale;
	}

	public void setPupilsMultiRacialMale(Integer pupilsMultiRacialMale) {
		this.pupilsMultiRacialMale = pupilsMultiRacialMale;
		this.pupilsMultiRacialMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialMale = Integer.parseInt(o);
		this.pupilsMultiRacialMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsMultiRacialMaleInit() {
		if(!pupilsMultiRacialMaleWrap.alreadyInitialized) {
			_pupilsMultiRacialMale(pupilsMultiRacialMaleWrap);
			if(pupilsMultiRacialMale == null)
				setPupilsMultiRacialMale(pupilsMultiRacialMaleWrap.o);
		}
		pupilsMultiRacialMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsMultiRacialMale() {
		return pupilsMultiRacialMale;
	}

	public String strPupilsMultiRacialMale() {
		return pupilsMultiRacialMale == null ? "" : pupilsMultiRacialMale.toString();
	}

	public String jsonPupilsMultiRacialMale() {
		return pupilsMultiRacialMale == null ? "" : pupilsMultiRacialMale.toString();
	}

	public String nomAffichagePupilsMultiRacialMale() {
		return "Multi Racial male";
	}

	public String htmTooltipPupilsMultiRacialMale() {
		return null;
	}

	public String htmPupilsMultiRacialMale() {
		return pupilsMultiRacialMale == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsMultiRacialMale());
	}

	public void inputPupilsMultiRacialMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Multi Racial male")
				.a("id", classApiMethodMethod, "_pupilsMultiRacialMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPupilsMultiRacialMale classReportCard inputReportCard", pk, "PupilsMultiRacialMale w3-input w3-border ");
					a("name", "setPupilsMultiRacialMale");
				} else {
					a("class", "valuePupilsMultiRacialMale w3-input w3-border classReportCard inputReportCard", pk, "PupilsMultiRacialMale w3-input w3-border ");
					a("name", "pupilsMultiRacialMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPupilsMultiRacialMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_pupilsMultiRacialMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsMultiRacialMale')); }); ");
				}
				a("value", strPupilsMultiRacialMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "PupilsMultiRacialMale ").f().sx(htmPupilsMultiRacialMale()).g("span");
		}
	}

	public void htmPupilsMultiRacialMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardPupilsMultiRacialMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_pupilsMultiRacialMale").a("class", "").f().sx("Multi Racial male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPupilsMultiRacialMale(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_pupilsMultiRacialMale')); $('#", classApiMethodMethod, "_pupilsMultiRacialMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setPupilsMultiRacialMale', null, function() { addGlow($('#", classApiMethodMethod, "_pupilsMultiRacialMale')); }, function() { addError($('#", classApiMethodMethod, "_pupilsMultiRacialMale')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////////////
	// pupilsMultiRacialTotal //
	////////////////////////////

	/**	 The entity pupilsMultiRacialTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pupilsMultiRacialTotal;
	@JsonIgnore
	public Wrap<Integer> pupilsMultiRacialTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("pupilsMultiRacialTotal").o(pupilsMultiRacialTotal);

	/**	<br/> The entity pupilsMultiRacialTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialTotal">Find the entity pupilsMultiRacialTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialTotal(Wrap<Integer> c);

	public Integer getPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal;
	}

	public void setPupilsMultiRacialTotal(Integer pupilsMultiRacialTotal) {
		this.pupilsMultiRacialTotal = pupilsMultiRacialTotal;
		this.pupilsMultiRacialTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialTotal = Integer.parseInt(o);
		this.pupilsMultiRacialTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsMultiRacialTotalInit() {
		if(!pupilsMultiRacialTotalWrap.alreadyInitialized) {
			_pupilsMultiRacialTotal(pupilsMultiRacialTotalWrap);
			if(pupilsMultiRacialTotal == null)
				setPupilsMultiRacialTotal(pupilsMultiRacialTotalWrap.o);
		}
		pupilsMultiRacialTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal;
	}

	public String strPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal == null ? "" : pupilsMultiRacialTotal.toString();
	}

	public String jsonPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal == null ? "" : pupilsMultiRacialTotal.toString();
	}

	public String nomAffichagePupilsMultiRacialTotal() {
		return "Multi Racials total";
	}

	public String htmTooltipPupilsMultiRacialTotal() {
		return null;
	}

	public String htmPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsMultiRacialTotal());
	}

	public void inputPupilsMultiRacialTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsMultiRacialTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Multi Racials total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsMultiRacialTotal ").f().sx(strPupilsMultiRacialTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////
	// pupilsMultiRacialPercent //
	//////////////////////////////

	/**	 The entity pupilsMultiRacialPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal pupilsMultiRacialPercent;
	@JsonIgnore
	public Wrap<BigDecimal> pupilsMultiRacialPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("pupilsMultiRacialPercent").o(pupilsMultiRacialPercent);

	/**	<br/> The entity pupilsMultiRacialPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialPercent">Find the entity pupilsMultiRacialPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialPercent(Wrap<BigDecimal> c);

	public BigDecimal getPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent;
	}

	public void setPupilsMultiRacialPercent(BigDecimal pupilsMultiRacialPercent) {
		this.pupilsMultiRacialPercent = pupilsMultiRacialPercent;
		this.pupilsMultiRacialPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsMultiRacialPercent(Double o) {
			this.pupilsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setPupilsMultiRacialPercent(Integer o) {
			this.pupilsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.pupilsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard pupilsMultiRacialPercentInit() {
		if(!pupilsMultiRacialPercentWrap.alreadyInitialized) {
			_pupilsMultiRacialPercent(pupilsMultiRacialPercentWrap);
			if(pupilsMultiRacialPercent == null)
				setPupilsMultiRacialPercent(pupilsMultiRacialPercentWrap.o);
		}
		pupilsMultiRacialPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent == null ? null : pupilsMultiRacialPercent.doubleValue();
	}

	public String strPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent == null ? "" : pupilsMultiRacialPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent == null ? "" : pupilsMultiRacialPercent.toString();
	}

	public String nomAffichagePupilsMultiRacialPercent() {
		return "Multi Racials percent";
	}

	public String htmTooltipPupilsMultiRacialPercent() {
		return null;
	}

	public String htmPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent == null ? "" : StringEscapeUtils.escapeHtml4(strPupilsMultiRacialPercent());
	}

	public void inputPupilsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmPupilsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Multi Racials percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "PupilsMultiRacialPercent ").f().sx(strPupilsMultiRacialPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////
	// delinquentComplaintsTotal //
	///////////////////////////////

	/**	 The entity delinquentComplaintsTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer delinquentComplaintsTotal;
	@JsonIgnore
	public Wrap<Integer> delinquentComplaintsTotalWrap = new Wrap<Integer>().p(this).c(Integer.class).var("delinquentComplaintsTotal").o(delinquentComplaintsTotal);

	/**	<br/> The entity delinquentComplaintsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsTotal">Find the entity delinquentComplaintsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsTotal(Wrap<Integer> c);

	public Integer getDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal;
	}

	public void setDelinquentComplaintsTotal(Integer delinquentComplaintsTotal) {
		this.delinquentComplaintsTotal = delinquentComplaintsTotal;
		this.delinquentComplaintsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsTotal = Integer.parseInt(o);
		this.delinquentComplaintsTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsTotalInit() {
		if(!delinquentComplaintsTotalWrap.alreadyInitialized) {
			_delinquentComplaintsTotal(delinquentComplaintsTotalWrap);
			if(delinquentComplaintsTotal == null)
				setDelinquentComplaintsTotal(delinquentComplaintsTotalWrap.o);
		}
		delinquentComplaintsTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal;
	}

	public String strDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal == null ? "" : delinquentComplaintsTotal.toString();
	}

	public String jsonDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal == null ? "" : delinquentComplaintsTotal.toString();
	}

	public String nomAffichageDelinquentComplaintsTotal() {
		return "delinquent complaints total";
	}

	public String htmTooltipDelinquentComplaintsTotal() {
		return null;
	}

	public String htmDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsTotal());
	}

	public void inputDelinquentComplaintsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "delinquent complaints total")
				.a("id", classApiMethodMethod, "_delinquentComplaintsTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsTotal classReportCard inputReportCard", pk, "DelinquentComplaintsTotal w3-input w3-border ");
					a("name", "setDelinquentComplaintsTotal");
				} else {
					a("class", "valueDelinquentComplaintsTotal w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsTotal w3-input w3-border ");
					a("name", "delinquentComplaintsTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsTotal')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsTotal')); }); ");
				}
				a("value", strDelinquentComplaintsTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsTotal ").f().sx(htmDelinquentComplaintsTotal()).g("span");
		}
	}

	public void htmDelinquentComplaintsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsTotal").a("class", "").f().sx("delinquent complaints total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsTotal(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsTotal')); $('#", classApiMethodMethod, "_delinquentComplaintsTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsTotal', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsTotal')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsTotal')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////////////////////
	// delinquentComplaintsAtSchool //
	//////////////////////////////////

	/**	 The entity delinquentComplaintsAtSchool
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer delinquentComplaintsAtSchool;
	@JsonIgnore
	public Wrap<Integer> delinquentComplaintsAtSchoolWrap = new Wrap<Integer>().p(this).c(Integer.class).var("delinquentComplaintsAtSchool").o(delinquentComplaintsAtSchool);

	/**	<br/> The entity delinquentComplaintsAtSchool
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsAtSchool">Find the entity delinquentComplaintsAtSchool in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsAtSchool(Wrap<Integer> c);

	public Integer getDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool;
	}

	public void setDelinquentComplaintsAtSchool(Integer delinquentComplaintsAtSchool) {
		this.delinquentComplaintsAtSchool = delinquentComplaintsAtSchool;
		this.delinquentComplaintsAtSchoolWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsAtSchool(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsAtSchool = Integer.parseInt(o);
		this.delinquentComplaintsAtSchoolWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsAtSchoolInit() {
		if(!delinquentComplaintsAtSchoolWrap.alreadyInitialized) {
			_delinquentComplaintsAtSchool(delinquentComplaintsAtSchoolWrap);
			if(delinquentComplaintsAtSchool == null)
				setDelinquentComplaintsAtSchool(delinquentComplaintsAtSchoolWrap.o);
		}
		delinquentComplaintsAtSchoolWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool;
	}

	public String strDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool == null ? "" : delinquentComplaintsAtSchool.toString();
	}

	public String jsonDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool == null ? "" : delinquentComplaintsAtSchool.toString();
	}

	public String nomAffichageDelinquentComplaintsAtSchool() {
		return "delinquent complaints at school";
	}

	public String htmTooltipDelinquentComplaintsAtSchool() {
		return null;
	}

	public String htmDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsAtSchool());
	}

	public void inputDelinquentComplaintsAtSchool(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "delinquent complaints at school")
				.a("id", classApiMethodMethod, "_delinquentComplaintsAtSchool");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsAtSchool classReportCard inputReportCard", pk, "DelinquentComplaintsAtSchool w3-input w3-border ");
					a("name", "setDelinquentComplaintsAtSchool");
				} else {
					a("class", "valueDelinquentComplaintsAtSchool w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsAtSchool w3-input w3-border ");
					a("name", "delinquentComplaintsAtSchool");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsAtSchool', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsAtSchool')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsAtSchool')); }); ");
				}
				a("value", strDelinquentComplaintsAtSchool())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsAtSchool ").f().sx(htmDelinquentComplaintsAtSchool()).g("span");
		}
	}

	public void htmDelinquentComplaintsAtSchool(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsAtSchool").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsAtSchool").a("class", "").f().sx("delinquent complaints at school").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsAtSchool(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsAtSchool')); $('#", classApiMethodMethod, "_delinquentComplaintsAtSchool').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsAtSchool', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsAtSchool')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsAtSchool')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////////////////////////////
	// delinquentComplaintsAtSchoolPercent //
	/////////////////////////////////////////

	/**	 The entity delinquentComplaintsAtSchoolPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsAtSchoolPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsAtSchoolPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsAtSchoolPercent").o(delinquentComplaintsAtSchoolPercent);

	/**	<br/> The entity delinquentComplaintsAtSchoolPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsAtSchoolPercent">Find the entity delinquentComplaintsAtSchoolPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsAtSchoolPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent;
	}

	public void setDelinquentComplaintsAtSchoolPercent(BigDecimal delinquentComplaintsAtSchoolPercent) {
		this.delinquentComplaintsAtSchoolPercent = delinquentComplaintsAtSchoolPercent;
		this.delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsAtSchoolPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsAtSchoolPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsAtSchoolPercent(Double o) {
			this.delinquentComplaintsAtSchoolPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsAtSchoolPercent(Integer o) {
			this.delinquentComplaintsAtSchoolPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsAtSchoolPercentInit() {
		if(!delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized) {
			_delinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercentWrap);
			if(delinquentComplaintsAtSchoolPercent == null)
				setDelinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercentWrap.o);
		}
		delinquentComplaintsAtSchoolPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent == null ? null : delinquentComplaintsAtSchoolPercent.doubleValue();
	}

	public String strDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent == null ? "" : delinquentComplaintsAtSchoolPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent == null ? "" : delinquentComplaintsAtSchoolPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsAtSchoolPercent() {
		return "delinquent complaints at school percent";
	}

	public String htmTooltipDelinquentComplaintsAtSchoolPercent() {
		return null;
	}

	public String htmDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsAtSchoolPercent());
	}

	public void inputDelinquentComplaintsAtSchoolPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsAtSchoolPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("delinquent complaints at school percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsAtSchoolPercent ").f().sx(strDelinquentComplaintsAtSchoolPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////
	// stateKey //
	//////////////

	/**	 The entity stateKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long stateKey;
	@JsonIgnore
	public Wrap<Long> stateKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("stateKey").o(stateKey);

	/**	<br/> The entity stateKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateKey">Find the entity stateKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stateKey(Wrap<Long> c);

	public Long getStateKey() {
		return stateKey;
	}

	public void setStateKey(Long stateKey) {
		this.stateKey = stateKey;
		this.stateKeyWrap.alreadyInitialized = true;
	}
	public ReportCard setStateKey(String o) {
		if(NumberUtils.isParsable(o))
			this.stateKey = Long.parseLong(o);
		this.stateKeyWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard stateKeyInit() {
		if(!stateKeyWrap.alreadyInitialized) {
			_stateKey(stateKeyWrap);
			if(stateKey == null)
				setStateKey(stateKeyWrap.o);
		}
		stateKeyWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrStateKey() {
		return stateKey;
	}

	public String strStateKey() {
		return stateKey == null ? "" : stateKey.toString();
	}

	public String jsonStateKey() {
		return stateKey == null ? "" : stateKey.toString();
	}

	public String nomAffichageStateKey() {
		return null;
	}

	public String htmTooltipStateKey() {
		return null;
	}

	public String htmStateKey() {
		return stateKey == null ? "" : StringEscapeUtils.escapeHtml4(strStateKey());
	}

	///////////////
	// stateName //
	///////////////

	/**	 The entity stateName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String stateName;
	@JsonIgnore
	public Wrap<String> stateNameWrap = new Wrap<String>().p(this).c(String.class).var("stateName").o(stateName);

	/**	<br/> The entity stateName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateName">Find the entity stateName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stateName(Wrap<String> c);

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
		this.stateNameWrap.alreadyInitialized = true;
	}
	protected ReportCard stateNameInit() {
		if(!stateNameWrap.alreadyInitialized) {
			_stateName(stateNameWrap);
			if(stateName == null)
				setStateName(stateNameWrap.o);
		}
		stateNameWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrStateName() {
		return stateName;
	}

	public String strStateName() {
		return stateName == null ? "" : stateName;
	}

	public String jsonStateName() {
		return stateName == null ? "" : stateName;
	}

	public String nomAffichageStateName() {
		return null;
	}

	public String htmTooltipStateName() {
		return null;
	}

	public String htmStateName() {
		return stateName == null ? "" : StringEscapeUtils.escapeHtml4(strStateName());
	}

	///////////////////////
	// stateAbbreviation //
	///////////////////////

	/**	 The entity stateAbbreviation
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String stateAbbreviation;
	@JsonIgnore
	public Wrap<String> stateAbbreviationWrap = new Wrap<String>().p(this).c(String.class).var("stateAbbreviation").o(stateAbbreviation);

	/**	<br/> The entity stateAbbreviation
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateAbbreviation">Find the entity stateAbbreviation in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stateAbbreviation(Wrap<String> c);

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
		this.stateAbbreviationWrap.alreadyInitialized = true;
	}
	protected ReportCard stateAbbreviationInit() {
		if(!stateAbbreviationWrap.alreadyInitialized) {
			_stateAbbreviation(stateAbbreviationWrap);
			if(stateAbbreviation == null)
				setStateAbbreviation(stateAbbreviationWrap.o);
		}
		stateAbbreviationWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrStateAbbreviation() {
		return stateAbbreviation;
	}

	public String strStateAbbreviation() {
		return stateAbbreviation == null ? "" : stateAbbreviation;
	}

	public String jsonStateAbbreviation() {
		return stateAbbreviation == null ? "" : stateAbbreviation;
	}

	public String nomAffichageStateAbbreviation() {
		return null;
	}

	public String htmTooltipStateAbbreviation() {
		return null;
	}

	public String htmStateAbbreviation() {
		return stateAbbreviation == null ? "" : StringEscapeUtils.escapeHtml4(strStateAbbreviation());
	}

	////////////////
	// countyName //
	////////////////

	/**	 The entity countyName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String countyName;
	@JsonIgnore
	public Wrap<String> countyNameWrap = new Wrap<String>().p(this).c(String.class).var("countyName").o(countyName);

	/**	<br/> The entity countyName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyName">Find the entity countyName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _countyName(Wrap<String> c);

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
		this.countyNameWrap.alreadyInitialized = true;
	}
	protected ReportCard countyNameInit() {
		if(!countyNameWrap.alreadyInitialized) {
			_countyName(countyNameWrap);
			if(countyName == null)
				setCountyName(countyNameWrap.o);
		}
		countyNameWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrCountyName() {
		return countyName;
	}

	public String strCountyName() {
		return countyName == null ? "" : countyName;
	}

	public String jsonCountyName() {
		return countyName == null ? "" : countyName;
	}

	public String nomAffichageCountyName() {
		return null;
	}

	public String htmTooltipCountyName() {
		return null;
	}

	public String htmCountyName() {
		return countyName == null ? "" : StringEscapeUtils.escapeHtml4(strCountyName());
	}

	////////////////////////
	// countyCompleteName //
	////////////////////////

	/**	 The entity countyCompleteName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String countyCompleteName;
	@JsonIgnore
	public Wrap<String> countyCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("countyCompleteName").o(countyCompleteName);

	/**	<br/> The entity countyCompleteName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyCompleteName">Find the entity countyCompleteName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _countyCompleteName(Wrap<String> c);

	public String getCountyCompleteName() {
		return countyCompleteName;
	}

	public void setCountyCompleteName(String countyCompleteName) {
		this.countyCompleteName = countyCompleteName;
		this.countyCompleteNameWrap.alreadyInitialized = true;
	}
	protected ReportCard countyCompleteNameInit() {
		if(!countyCompleteNameWrap.alreadyInitialized) {
			_countyCompleteName(countyCompleteNameWrap);
			if(countyCompleteName == null)
				setCountyCompleteName(countyCompleteNameWrap.o);
		}
		countyCompleteNameWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrCountyCompleteName() {
		return countyCompleteName;
	}

	public String strCountyCompleteName() {
		return countyCompleteName == null ? "" : countyCompleteName;
	}

	public String jsonCountyCompleteName() {
		return countyCompleteName == null ? "" : countyCompleteName;
	}

	public String nomAffichageCountyCompleteName() {
		return null;
	}

	public String htmTooltipCountyCompleteName() {
		return null;
	}

	public String htmCountyCompleteName() {
		return countyCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strCountyCompleteName());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedReportCard = false;

	public ReportCard initDeepReportCard(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedReportCard) {
			alreadyInitializedReportCard = true;
			initDeepReportCard();
		}
		return (ReportCard)this;
	}

	public void initDeepReportCard() {
		initReportCard();
		super.initDeepCluster(siteRequest_);
	}

	public void initReportCard() {
		reportCardKeyInit();
		reportCardStartYearInit();
		reportCardEndYearInit();
		countySearchInit();
		county_Init();
		countyKeyInit();
		pupilsTotalInit();
		pupilsIndianFemaleInit();
		pupilsIndianMaleInit();
		pupilsIndianTotalInit();
		pupilsIndianPercentInit();
		pupilsAsianFemaleInit();
		pupilsAsianMaleInit();
		pupilsAsianTotalInit();
		pupilsAsianPercentInit();
		pupilsHispanicFemaleInit();
		pupilsHispanicMaleInit();
		pupilsHispanicTotalInit();
		pupilsHispanicPercentInit();
		pupilsBlackFemaleInit();
		pupilsBlackMaleInit();
		pupilsBlackTotalInit();
		pupilsBlackPercentInit();
		pupilsWhiteFemaleInit();
		pupilsWhiteMaleInit();
		pupilsWhiteTotalInit();
		pupilsWhitePercentInit();
		pupilsPacificIslanderFemaleInit();
		pupilsPacificIslanderMaleInit();
		pupilsPacificIslanderTotalInit();
		pupilsPacificIslanderPercentInit();
		pupilsMultiRacialFemaleInit();
		pupilsMultiRacialMaleInit();
		pupilsMultiRacialTotalInit();
		pupilsMultiRacialPercentInit();
		delinquentComplaintsTotalInit();
		delinquentComplaintsAtSchoolInit();
		delinquentComplaintsAtSchoolPercentInit();
		stateKeyInit();
		stateNameInit();
		stateAbbreviationInit();
		countyNameInit();
		countyCompleteNameInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepReportCard(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportCard(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
		if(countySearch != null)
			countySearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportCard(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportCard(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainReportCard(String var) {
		ReportCard oReportCard = (ReportCard)this;
		switch(var) {
			case "reportCardKey":
				return oReportCard.reportCardKey;
			case "reportCardStartYear":
				return oReportCard.reportCardStartYear;
			case "reportCardEndYear":
				return oReportCard.reportCardEndYear;
			case "countySearch":
				return oReportCard.countySearch;
			case "county_":
				return oReportCard.county_;
			case "countyKey":
				return oReportCard.countyKey;
			case "pupilsTotal":
				return oReportCard.pupilsTotal;
			case "pupilsIndianFemale":
				return oReportCard.pupilsIndianFemale;
			case "pupilsIndianMale":
				return oReportCard.pupilsIndianMale;
			case "pupilsIndianTotal":
				return oReportCard.pupilsIndianTotal;
			case "pupilsIndianPercent":
				return oReportCard.pupilsIndianPercent;
			case "pupilsAsianFemale":
				return oReportCard.pupilsAsianFemale;
			case "pupilsAsianMale":
				return oReportCard.pupilsAsianMale;
			case "pupilsAsianTotal":
				return oReportCard.pupilsAsianTotal;
			case "pupilsAsianPercent":
				return oReportCard.pupilsAsianPercent;
			case "pupilsHispanicFemale":
				return oReportCard.pupilsHispanicFemale;
			case "pupilsHispanicMale":
				return oReportCard.pupilsHispanicMale;
			case "pupilsHispanicTotal":
				return oReportCard.pupilsHispanicTotal;
			case "pupilsHispanicPercent":
				return oReportCard.pupilsHispanicPercent;
			case "pupilsBlackFemale":
				return oReportCard.pupilsBlackFemale;
			case "pupilsBlackMale":
				return oReportCard.pupilsBlackMale;
			case "pupilsBlackTotal":
				return oReportCard.pupilsBlackTotal;
			case "pupilsBlackPercent":
				return oReportCard.pupilsBlackPercent;
			case "pupilsWhiteFemale":
				return oReportCard.pupilsWhiteFemale;
			case "pupilsWhiteMale":
				return oReportCard.pupilsWhiteMale;
			case "pupilsWhiteTotal":
				return oReportCard.pupilsWhiteTotal;
			case "pupilsWhitePercent":
				return oReportCard.pupilsWhitePercent;
			case "pupilsPacificIslanderFemale":
				return oReportCard.pupilsPacificIslanderFemale;
			case "pupilsPacificIslanderMale":
				return oReportCard.pupilsPacificIslanderMale;
			case "pupilsPacificIslanderTotal":
				return oReportCard.pupilsPacificIslanderTotal;
			case "pupilsPacificIslanderPercent":
				return oReportCard.pupilsPacificIslanderPercent;
			case "pupilsMultiRacialFemale":
				return oReportCard.pupilsMultiRacialFemale;
			case "pupilsMultiRacialMale":
				return oReportCard.pupilsMultiRacialMale;
			case "pupilsMultiRacialTotal":
				return oReportCard.pupilsMultiRacialTotal;
			case "pupilsMultiRacialPercent":
				return oReportCard.pupilsMultiRacialPercent;
			case "delinquentComplaintsTotal":
				return oReportCard.delinquentComplaintsTotal;
			case "delinquentComplaintsAtSchool":
				return oReportCard.delinquentComplaintsAtSchool;
			case "delinquentComplaintsAtSchoolPercent":
				return oReportCard.delinquentComplaintsAtSchoolPercent;
			case "stateKey":
				return oReportCard.stateKey;
			case "stateName":
				return oReportCard.stateName;
			case "stateAbbreviation":
				return oReportCard.stateAbbreviation;
			case "countyName":
				return oReportCard.countyName;
			case "countyCompleteName":
				return oReportCard.countyCompleteName;
			default:
				return super.obtainCluster(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeReportCard(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeReportCard(String var, Object val) {
		ReportCard oReportCard = (ReportCard)this;
		switch(var) {
			case "countyKey":
				oReportCard.setCountyKey((Long)val);
				if(!saves.contains(var))
					saves.add(var);
				return val;
			default:
				return super.attributeCluster(var, val);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineReportCard(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportCard(String var, String val) {
		switch(var) {
			case "reportCardStartYear":
				if(val != null)
					setReportCardStartYear(val);
				saves.add(var);
				return val;
			case "pupilsTotal":
				if(val != null)
					setPupilsTotal(val);
				saves.add(var);
				return val;
			case "pupilsIndianFemale":
				if(val != null)
					setPupilsIndianFemale(val);
				saves.add(var);
				return val;
			case "pupilsIndianMale":
				if(val != null)
					setPupilsIndianMale(val);
				saves.add(var);
				return val;
			case "pupilsAsianFemale":
				if(val != null)
					setPupilsAsianFemale(val);
				saves.add(var);
				return val;
			case "pupilsAsianMale":
				if(val != null)
					setPupilsAsianMale(val);
				saves.add(var);
				return val;
			case "pupilsHispanicFemale":
				if(val != null)
					setPupilsHispanicFemale(val);
				saves.add(var);
				return val;
			case "pupilsHispanicMale":
				if(val != null)
					setPupilsHispanicMale(val);
				saves.add(var);
				return val;
			case "pupilsBlackFemale":
				if(val != null)
					setPupilsBlackFemale(val);
				saves.add(var);
				return val;
			case "pupilsBlackMale":
				if(val != null)
					setPupilsBlackMale(val);
				saves.add(var);
				return val;
			case "pupilsWhiteFemale":
				if(val != null)
					setPupilsWhiteFemale(val);
				saves.add(var);
				return val;
			case "pupilsWhiteMale":
				if(val != null)
					setPupilsWhiteMale(val);
				saves.add(var);
				return val;
			case "pupilsPacificIslanderFemale":
				if(val != null)
					setPupilsPacificIslanderFemale(val);
				saves.add(var);
				return val;
			case "pupilsPacificIslanderMale":
				if(val != null)
					setPupilsPacificIslanderMale(val);
				saves.add(var);
				return val;
			case "pupilsMultiRacialFemale":
				if(val != null)
					setPupilsMultiRacialFemale(val);
				saves.add(var);
				return val;
			case "pupilsMultiRacialMale":
				if(val != null)
					setPupilsMultiRacialMale(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsTotal":
				if(val != null)
					setDelinquentComplaintsTotal(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsAtSchool":
				if(val != null)
					setDelinquentComplaintsAtSchool(val);
				saves.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateReportCard(solrDocument);
	}
	public void populateReportCard(SolrDocument solrDocument) {
		ReportCard oReportCard = (ReportCard)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("reportCardKey")) {
				Long reportCardKey = (Long)solrDocument.get("reportCardKey_stored_long");
				if(reportCardKey != null)
					oReportCard.setReportCardKey(reportCardKey);
			}

			if(saves.contains("reportCardStartYear")) {
				Integer reportCardStartYear = (Integer)solrDocument.get("reportCardStartYear_stored_int");
				if(reportCardStartYear != null)
					oReportCard.setReportCardStartYear(reportCardStartYear);
			}

			if(saves.contains("reportCardEndYear")) {
				Integer reportCardEndYear = (Integer)solrDocument.get("reportCardEndYear_stored_int");
				if(reportCardEndYear != null)
					oReportCard.setReportCardEndYear(reportCardEndYear);
			}

			Long countyKey = (Long)solrDocument.get("countyKey_stored_long");
			if(countyKey != null)
				oReportCard.setCountyKey(countyKey);

			if(saves.contains("pupilsTotal")) {
				Integer pupilsTotal = (Integer)solrDocument.get("pupilsTotal_stored_int");
				if(pupilsTotal != null)
					oReportCard.setPupilsTotal(pupilsTotal);
			}

			if(saves.contains("pupilsIndianFemale")) {
				Integer pupilsIndianFemale = (Integer)solrDocument.get("pupilsIndianFemale_stored_int");
				if(pupilsIndianFemale != null)
					oReportCard.setPupilsIndianFemale(pupilsIndianFemale);
			}

			if(saves.contains("pupilsIndianMale")) {
				Integer pupilsIndianMale = (Integer)solrDocument.get("pupilsIndianMale_stored_int");
				if(pupilsIndianMale != null)
					oReportCard.setPupilsIndianMale(pupilsIndianMale);
			}

			if(saves.contains("pupilsIndianTotal")) {
				Integer pupilsIndianTotal = (Integer)solrDocument.get("pupilsIndianTotal_stored_int");
				if(pupilsIndianTotal != null)
					oReportCard.setPupilsIndianTotal(pupilsIndianTotal);
			}

			if(saves.contains("pupilsIndianPercent")) {
				Double pupilsIndianPercent = (Double)solrDocument.get("pupilsIndianPercent_stored_double");
				if(pupilsIndianPercent != null)
					oReportCard.setPupilsIndianPercent(pupilsIndianPercent);
			}

			if(saves.contains("pupilsAsianFemale")) {
				Integer pupilsAsianFemale = (Integer)solrDocument.get("pupilsAsianFemale_stored_int");
				if(pupilsAsianFemale != null)
					oReportCard.setPupilsAsianFemale(pupilsAsianFemale);
			}

			if(saves.contains("pupilsAsianMale")) {
				Integer pupilsAsianMale = (Integer)solrDocument.get("pupilsAsianMale_stored_int");
				if(pupilsAsianMale != null)
					oReportCard.setPupilsAsianMale(pupilsAsianMale);
			}

			if(saves.contains("pupilsAsianTotal")) {
				Integer pupilsAsianTotal = (Integer)solrDocument.get("pupilsAsianTotal_stored_int");
				if(pupilsAsianTotal != null)
					oReportCard.setPupilsAsianTotal(pupilsAsianTotal);
			}

			if(saves.contains("pupilsAsianPercent")) {
				Double pupilsAsianPercent = (Double)solrDocument.get("pupilsAsianPercent_stored_double");
				if(pupilsAsianPercent != null)
					oReportCard.setPupilsAsianPercent(pupilsAsianPercent);
			}

			if(saves.contains("pupilsHispanicFemale")) {
				Integer pupilsHispanicFemale = (Integer)solrDocument.get("pupilsHispanicFemale_stored_int");
				if(pupilsHispanicFemale != null)
					oReportCard.setPupilsHispanicFemale(pupilsHispanicFemale);
			}

			if(saves.contains("pupilsHispanicMale")) {
				Integer pupilsHispanicMale = (Integer)solrDocument.get("pupilsHispanicMale_stored_int");
				if(pupilsHispanicMale != null)
					oReportCard.setPupilsHispanicMale(pupilsHispanicMale);
			}

			if(saves.contains("pupilsHispanicTotal")) {
				Integer pupilsHispanicTotal = (Integer)solrDocument.get("pupilsHispanicTotal_stored_int");
				if(pupilsHispanicTotal != null)
					oReportCard.setPupilsHispanicTotal(pupilsHispanicTotal);
			}

			if(saves.contains("pupilsHispanicPercent")) {
				Double pupilsHispanicPercent = (Double)solrDocument.get("pupilsHispanicPercent_stored_double");
				if(pupilsHispanicPercent != null)
					oReportCard.setPupilsHispanicPercent(pupilsHispanicPercent);
			}

			if(saves.contains("pupilsBlackFemale")) {
				Integer pupilsBlackFemale = (Integer)solrDocument.get("pupilsBlackFemale_stored_int");
				if(pupilsBlackFemale != null)
					oReportCard.setPupilsBlackFemale(pupilsBlackFemale);
			}

			if(saves.contains("pupilsBlackMale")) {
				Integer pupilsBlackMale = (Integer)solrDocument.get("pupilsBlackMale_stored_int");
				if(pupilsBlackMale != null)
					oReportCard.setPupilsBlackMale(pupilsBlackMale);
			}

			if(saves.contains("pupilsBlackTotal")) {
				Integer pupilsBlackTotal = (Integer)solrDocument.get("pupilsBlackTotal_stored_int");
				if(pupilsBlackTotal != null)
					oReportCard.setPupilsBlackTotal(pupilsBlackTotal);
			}

			if(saves.contains("pupilsBlackPercent")) {
				Double pupilsBlackPercent = (Double)solrDocument.get("pupilsBlackPercent_stored_double");
				if(pupilsBlackPercent != null)
					oReportCard.setPupilsBlackPercent(pupilsBlackPercent);
			}

			if(saves.contains("pupilsWhiteFemale")) {
				Integer pupilsWhiteFemale = (Integer)solrDocument.get("pupilsWhiteFemale_stored_int");
				if(pupilsWhiteFemale != null)
					oReportCard.setPupilsWhiteFemale(pupilsWhiteFemale);
			}

			if(saves.contains("pupilsWhiteMale")) {
				Integer pupilsWhiteMale = (Integer)solrDocument.get("pupilsWhiteMale_stored_int");
				if(pupilsWhiteMale != null)
					oReportCard.setPupilsWhiteMale(pupilsWhiteMale);
			}

			if(saves.contains("pupilsWhiteTotal")) {
				Integer pupilsWhiteTotal = (Integer)solrDocument.get("pupilsWhiteTotal_stored_int");
				if(pupilsWhiteTotal != null)
					oReportCard.setPupilsWhiteTotal(pupilsWhiteTotal);
			}

			if(saves.contains("pupilsWhitePercent")) {
				Double pupilsWhitePercent = (Double)solrDocument.get("pupilsWhitePercent_stored_double");
				if(pupilsWhitePercent != null)
					oReportCard.setPupilsWhitePercent(pupilsWhitePercent);
			}

			if(saves.contains("pupilsPacificIslanderFemale")) {
				Integer pupilsPacificIslanderFemale = (Integer)solrDocument.get("pupilsPacificIslanderFemale_stored_int");
				if(pupilsPacificIslanderFemale != null)
					oReportCard.setPupilsPacificIslanderFemale(pupilsPacificIslanderFemale);
			}

			if(saves.contains("pupilsPacificIslanderMale")) {
				Integer pupilsPacificIslanderMale = (Integer)solrDocument.get("pupilsPacificIslanderMale_stored_int");
				if(pupilsPacificIslanderMale != null)
					oReportCard.setPupilsPacificIslanderMale(pupilsPacificIslanderMale);
			}

			if(saves.contains("pupilsPacificIslanderTotal")) {
				Integer pupilsPacificIslanderTotal = (Integer)solrDocument.get("pupilsPacificIslanderTotal_stored_int");
				if(pupilsPacificIslanderTotal != null)
					oReportCard.setPupilsPacificIslanderTotal(pupilsPacificIslanderTotal);
			}

			if(saves.contains("pupilsPacificIslanderPercent")) {
				Double pupilsPacificIslanderPercent = (Double)solrDocument.get("pupilsPacificIslanderPercent_stored_double");
				if(pupilsPacificIslanderPercent != null)
					oReportCard.setPupilsPacificIslanderPercent(pupilsPacificIslanderPercent);
			}

			if(saves.contains("pupilsMultiRacialFemale")) {
				Integer pupilsMultiRacialFemale = (Integer)solrDocument.get("pupilsMultiRacialFemale_stored_int");
				if(pupilsMultiRacialFemale != null)
					oReportCard.setPupilsMultiRacialFemale(pupilsMultiRacialFemale);
			}

			if(saves.contains("pupilsMultiRacialMale")) {
				Integer pupilsMultiRacialMale = (Integer)solrDocument.get("pupilsMultiRacialMale_stored_int");
				if(pupilsMultiRacialMale != null)
					oReportCard.setPupilsMultiRacialMale(pupilsMultiRacialMale);
			}

			if(saves.contains("pupilsMultiRacialTotal")) {
				Integer pupilsMultiRacialTotal = (Integer)solrDocument.get("pupilsMultiRacialTotal_stored_int");
				if(pupilsMultiRacialTotal != null)
					oReportCard.setPupilsMultiRacialTotal(pupilsMultiRacialTotal);
			}

			if(saves.contains("pupilsMultiRacialPercent")) {
				Double pupilsMultiRacialPercent = (Double)solrDocument.get("pupilsMultiRacialPercent_stored_double");
				if(pupilsMultiRacialPercent != null)
					oReportCard.setPupilsMultiRacialPercent(pupilsMultiRacialPercent);
			}

			if(saves.contains("delinquentComplaintsTotal")) {
				Integer delinquentComplaintsTotal = (Integer)solrDocument.get("delinquentComplaintsTotal_stored_int");
				if(delinquentComplaintsTotal != null)
					oReportCard.setDelinquentComplaintsTotal(delinquentComplaintsTotal);
			}

			if(saves.contains("delinquentComplaintsAtSchool")) {
				Integer delinquentComplaintsAtSchool = (Integer)solrDocument.get("delinquentComplaintsAtSchool_stored_int");
				if(delinquentComplaintsAtSchool != null)
					oReportCard.setDelinquentComplaintsAtSchool(delinquentComplaintsAtSchool);
			}

			if(saves.contains("delinquentComplaintsAtSchoolPercent")) {
				Double delinquentComplaintsAtSchoolPercent = (Double)solrDocument.get("delinquentComplaintsAtSchoolPercent_stored_double");
				if(delinquentComplaintsAtSchoolPercent != null)
					oReportCard.setDelinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercent);
			}

			if(saves.contains("stateKey")) {
				Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
				if(stateKey != null)
					oReportCard.setStateKey(stateKey);
			}

			if(saves.contains("stateName")) {
				String stateName = (String)solrDocument.get("stateName_stored_string");
				if(stateName != null)
					oReportCard.setStateName(stateName);
			}

			if(saves.contains("stateAbbreviation")) {
				String stateAbbreviation = (String)solrDocument.get("stateAbbreviation_stored_string");
				if(stateAbbreviation != null)
					oReportCard.setStateAbbreviation(stateAbbreviation);
			}

			if(saves.contains("countyName")) {
				String countyName = (String)solrDocument.get("countyName_stored_string");
				if(countyName != null)
					oReportCard.setCountyName(countyName);
			}

			if(saves.contains("countyCompleteName")) {
				String countyCompleteName = (String)solrDocument.get("countyCompleteName_stored_string");
				if(countyCompleteName != null)
					oReportCard.setCountyCompleteName(countyCompleteName);
			}
		}

		super.populateCluster(solrDocument);
	}

	/////////////
	// index //
	/////////////

	public static void index() {
		try {
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.getSiteConfig().setConfigPath("/usr/local/src/southerncoalition/config/southerncoalition.config");
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery("*:*");
			solrQuery.setRows(1);
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.southerncoalition.enus.reportcard.ReportCard"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			ReportCard o = new ReportCard();
			o.siteRequestReportCard(siteRequest);
			o.initDeepReportCard(siteRequest);
			o.indexReportCard();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexReportCard();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexReportCard(document);
	}

	public void indexReportCard(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexReportCard(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexReportCard() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexReportCard(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexReportCard(SolrInputDocument document) {
		if(reportCardKey != null) {
			document.addField("reportCardKey_indexed_long", reportCardKey);
			document.addField("reportCardKey_stored_long", reportCardKey);
		}
		if(reportCardStartYear != null) {
			document.addField("reportCardStartYear_indexed_int", reportCardStartYear);
			document.addField("reportCardStartYear_stored_int", reportCardStartYear);
		}
		if(reportCardEndYear != null) {
			document.addField("reportCardEndYear_indexed_int", reportCardEndYear);
			document.addField("reportCardEndYear_stored_int", reportCardEndYear);
		}
		if(countyKey != null) {
			document.addField("countyKey_indexed_long", countyKey);
			document.addField("countyKey_stored_long", countyKey);
		}
		if(pupilsTotal != null) {
			document.addField("pupilsTotal_indexed_int", pupilsTotal);
			document.addField("pupilsTotal_stored_int", pupilsTotal);
		}
		if(pupilsIndianFemale != null) {
			document.addField("pupilsIndianFemale_indexed_int", pupilsIndianFemale);
			document.addField("pupilsIndianFemale_stored_int", pupilsIndianFemale);
		}
		if(pupilsIndianMale != null) {
			document.addField("pupilsIndianMale_indexed_int", pupilsIndianMale);
			document.addField("pupilsIndianMale_stored_int", pupilsIndianMale);
		}
		if(pupilsIndianTotal != null) {
			document.addField("pupilsIndianTotal_indexed_int", pupilsIndianTotal);
			document.addField("pupilsIndianTotal_stored_int", pupilsIndianTotal);
		}
		if(pupilsIndianPercent != null) {
			document.addField("pupilsIndianPercent_indexed_double", pupilsIndianPercent.doubleValue());
			document.addField("pupilsIndianPercent_stored_double", pupilsIndianPercent.doubleValue());
		}
		if(pupilsAsianFemale != null) {
			document.addField("pupilsAsianFemale_indexed_int", pupilsAsianFemale);
			document.addField("pupilsAsianFemale_stored_int", pupilsAsianFemale);
		}
		if(pupilsAsianMale != null) {
			document.addField("pupilsAsianMale_indexed_int", pupilsAsianMale);
			document.addField("pupilsAsianMale_stored_int", pupilsAsianMale);
		}
		if(pupilsAsianTotal != null) {
			document.addField("pupilsAsianTotal_indexed_int", pupilsAsianTotal);
			document.addField("pupilsAsianTotal_stored_int", pupilsAsianTotal);
		}
		if(pupilsAsianPercent != null) {
			document.addField("pupilsAsianPercent_indexed_double", pupilsAsianPercent.doubleValue());
			document.addField("pupilsAsianPercent_stored_double", pupilsAsianPercent.doubleValue());
		}
		if(pupilsHispanicFemale != null) {
			document.addField("pupilsHispanicFemale_indexed_int", pupilsHispanicFemale);
			document.addField("pupilsHispanicFemale_stored_int", pupilsHispanicFemale);
		}
		if(pupilsHispanicMale != null) {
			document.addField("pupilsHispanicMale_indexed_int", pupilsHispanicMale);
			document.addField("pupilsHispanicMale_stored_int", pupilsHispanicMale);
		}
		if(pupilsHispanicTotal != null) {
			document.addField("pupilsHispanicTotal_indexed_int", pupilsHispanicTotal);
			document.addField("pupilsHispanicTotal_stored_int", pupilsHispanicTotal);
		}
		if(pupilsHispanicPercent != null) {
			document.addField("pupilsHispanicPercent_indexed_double", pupilsHispanicPercent.doubleValue());
			document.addField("pupilsHispanicPercent_stored_double", pupilsHispanicPercent.doubleValue());
		}
		if(pupilsBlackFemale != null) {
			document.addField("pupilsBlackFemale_indexed_int", pupilsBlackFemale);
			document.addField("pupilsBlackFemale_stored_int", pupilsBlackFemale);
		}
		if(pupilsBlackMale != null) {
			document.addField("pupilsBlackMale_indexed_int", pupilsBlackMale);
			document.addField("pupilsBlackMale_stored_int", pupilsBlackMale);
		}
		if(pupilsBlackTotal != null) {
			document.addField("pupilsBlackTotal_indexed_int", pupilsBlackTotal);
			document.addField("pupilsBlackTotal_stored_int", pupilsBlackTotal);
		}
		if(pupilsBlackPercent != null) {
			document.addField("pupilsBlackPercent_indexed_double", pupilsBlackPercent.doubleValue());
			document.addField("pupilsBlackPercent_stored_double", pupilsBlackPercent.doubleValue());
		}
		if(pupilsWhiteFemale != null) {
			document.addField("pupilsWhiteFemale_indexed_int", pupilsWhiteFemale);
			document.addField("pupilsWhiteFemale_stored_int", pupilsWhiteFemale);
		}
		if(pupilsWhiteMale != null) {
			document.addField("pupilsWhiteMale_indexed_int", pupilsWhiteMale);
			document.addField("pupilsWhiteMale_stored_int", pupilsWhiteMale);
		}
		if(pupilsWhiteTotal != null) {
			document.addField("pupilsWhiteTotal_indexed_int", pupilsWhiteTotal);
			document.addField("pupilsWhiteTotal_stored_int", pupilsWhiteTotal);
		}
		if(pupilsWhitePercent != null) {
			document.addField("pupilsWhitePercent_indexed_double", pupilsWhitePercent.doubleValue());
			document.addField("pupilsWhitePercent_stored_double", pupilsWhitePercent.doubleValue());
		}
		if(pupilsPacificIslanderFemale != null) {
			document.addField("pupilsPacificIslanderFemale_indexed_int", pupilsPacificIslanderFemale);
			document.addField("pupilsPacificIslanderFemale_stored_int", pupilsPacificIslanderFemale);
		}
		if(pupilsPacificIslanderMale != null) {
			document.addField("pupilsPacificIslanderMale_indexed_int", pupilsPacificIslanderMale);
			document.addField("pupilsPacificIslanderMale_stored_int", pupilsPacificIslanderMale);
		}
		if(pupilsPacificIslanderTotal != null) {
			document.addField("pupilsPacificIslanderTotal_indexed_int", pupilsPacificIslanderTotal);
			document.addField("pupilsPacificIslanderTotal_stored_int", pupilsPacificIslanderTotal);
		}
		if(pupilsPacificIslanderPercent != null) {
			document.addField("pupilsPacificIslanderPercent_indexed_double", pupilsPacificIslanderPercent.doubleValue());
			document.addField("pupilsPacificIslanderPercent_stored_double", pupilsPacificIslanderPercent.doubleValue());
		}
		if(pupilsMultiRacialFemale != null) {
			document.addField("pupilsMultiRacialFemale_indexed_int", pupilsMultiRacialFemale);
			document.addField("pupilsMultiRacialFemale_stored_int", pupilsMultiRacialFemale);
		}
		if(pupilsMultiRacialMale != null) {
			document.addField("pupilsMultiRacialMale_indexed_int", pupilsMultiRacialMale);
			document.addField("pupilsMultiRacialMale_stored_int", pupilsMultiRacialMale);
		}
		if(pupilsMultiRacialTotal != null) {
			document.addField("pupilsMultiRacialTotal_indexed_int", pupilsMultiRacialTotal);
			document.addField("pupilsMultiRacialTotal_stored_int", pupilsMultiRacialTotal);
		}
		if(pupilsMultiRacialPercent != null) {
			document.addField("pupilsMultiRacialPercent_indexed_double", pupilsMultiRacialPercent.doubleValue());
			document.addField("pupilsMultiRacialPercent_stored_double", pupilsMultiRacialPercent.doubleValue());
		}
		if(delinquentComplaintsTotal != null) {
			document.addField("delinquentComplaintsTotal_indexed_int", delinquentComplaintsTotal);
			document.addField("delinquentComplaintsTotal_stored_int", delinquentComplaintsTotal);
		}
		if(delinquentComplaintsAtSchool != null) {
			document.addField("delinquentComplaintsAtSchool_indexed_int", delinquentComplaintsAtSchool);
			document.addField("delinquentComplaintsAtSchool_stored_int", delinquentComplaintsAtSchool);
		}
		if(delinquentComplaintsAtSchoolPercent != null) {
			document.addField("delinquentComplaintsAtSchoolPercent_indexed_double", delinquentComplaintsAtSchoolPercent.doubleValue());
			document.addField("delinquentComplaintsAtSchoolPercent_stored_double", delinquentComplaintsAtSchoolPercent.doubleValue());
		}
		if(stateKey != null) {
			document.addField("stateKey_indexed_long", stateKey);
			document.addField("stateKey_stored_long", stateKey);
		}
		if(stateName != null) {
			document.addField("stateName_indexed_string", stateName);
			document.addField("stateName_stored_string", stateName);
		}
		if(stateAbbreviation != null) {
			document.addField("stateAbbreviation_indexed_string", stateAbbreviation);
			document.addField("stateAbbreviation_stored_string", stateAbbreviation);
		}
		if(countyName != null) {
			document.addField("countyName_indexed_string", countyName);
			document.addField("countyName_stored_string", countyName);
		}
		if(countyCompleteName != null) {
			document.addField("countyCompleteName_indexed_string", countyCompleteName);
			document.addField("countyCompleteName_stored_string", countyCompleteName);
		}
		super.indexCluster(document);

	}

	public void unindexReportCard() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepReportCard(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedReportCard(String entityVar) {
		switch(entityVar) {
			case "reportCardKey":
				return "reportCardKey_indexed_long";
			case "reportCardStartYear":
				return "reportCardStartYear_indexed_int";
			case "reportCardEndYear":
				return "reportCardEndYear_indexed_int";
			case "countyKey":
				return "countyKey_indexed_long";
			case "pupilsTotal":
				return "pupilsTotal_indexed_int";
			case "pupilsIndianFemale":
				return "pupilsIndianFemale_indexed_int";
			case "pupilsIndianMale":
				return "pupilsIndianMale_indexed_int";
			case "pupilsIndianTotal":
				return "pupilsIndianTotal_indexed_int";
			case "pupilsIndianPercent":
				return "pupilsIndianPercent_indexed_double";
			case "pupilsAsianFemale":
				return "pupilsAsianFemale_indexed_int";
			case "pupilsAsianMale":
				return "pupilsAsianMale_indexed_int";
			case "pupilsAsianTotal":
				return "pupilsAsianTotal_indexed_int";
			case "pupilsAsianPercent":
				return "pupilsAsianPercent_indexed_double";
			case "pupilsHispanicFemale":
				return "pupilsHispanicFemale_indexed_int";
			case "pupilsHispanicMale":
				return "pupilsHispanicMale_indexed_int";
			case "pupilsHispanicTotal":
				return "pupilsHispanicTotal_indexed_int";
			case "pupilsHispanicPercent":
				return "pupilsHispanicPercent_indexed_double";
			case "pupilsBlackFemale":
				return "pupilsBlackFemale_indexed_int";
			case "pupilsBlackMale":
				return "pupilsBlackMale_indexed_int";
			case "pupilsBlackTotal":
				return "pupilsBlackTotal_indexed_int";
			case "pupilsBlackPercent":
				return "pupilsBlackPercent_indexed_double";
			case "pupilsWhiteFemale":
				return "pupilsWhiteFemale_indexed_int";
			case "pupilsWhiteMale":
				return "pupilsWhiteMale_indexed_int";
			case "pupilsWhiteTotal":
				return "pupilsWhiteTotal_indexed_int";
			case "pupilsWhitePercent":
				return "pupilsWhitePercent_indexed_double";
			case "pupilsPacificIslanderFemale":
				return "pupilsPacificIslanderFemale_indexed_int";
			case "pupilsPacificIslanderMale":
				return "pupilsPacificIslanderMale_indexed_int";
			case "pupilsPacificIslanderTotal":
				return "pupilsPacificIslanderTotal_indexed_int";
			case "pupilsPacificIslanderPercent":
				return "pupilsPacificIslanderPercent_indexed_double";
			case "pupilsMultiRacialFemale":
				return "pupilsMultiRacialFemale_indexed_int";
			case "pupilsMultiRacialMale":
				return "pupilsMultiRacialMale_indexed_int";
			case "pupilsMultiRacialTotal":
				return "pupilsMultiRacialTotal_indexed_int";
			case "pupilsMultiRacialPercent":
				return "pupilsMultiRacialPercent_indexed_double";
			case "delinquentComplaintsTotal":
				return "delinquentComplaintsTotal_indexed_int";
			case "delinquentComplaintsAtSchool":
				return "delinquentComplaintsAtSchool_indexed_int";
			case "delinquentComplaintsAtSchoolPercent":
				return "delinquentComplaintsAtSchoolPercent_indexed_double";
			case "stateKey":
				return "stateKey_indexed_long";
			case "stateName":
				return "stateName_indexed_string";
			case "stateAbbreviation":
				return "stateAbbreviation_indexed_string";
			case "countyName":
				return "countyName_indexed_string";
			case "countyCompleteName":
				return "countyCompleteName_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchReportCard(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedReportCard(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeReportCard(solrDocument);
	}
	public void storeReportCard(SolrDocument solrDocument) {
		ReportCard oReportCard = (ReportCard)this;

		Long reportCardKey = (Long)solrDocument.get("reportCardKey_stored_long");
		if(reportCardKey != null)
			oReportCard.setReportCardKey(reportCardKey);

		Integer reportCardStartYear = (Integer)solrDocument.get("reportCardStartYear_stored_int");
		if(reportCardStartYear != null)
			oReportCard.setReportCardStartYear(reportCardStartYear);

		Integer reportCardEndYear = (Integer)solrDocument.get("reportCardEndYear_stored_int");
		if(reportCardEndYear != null)
			oReportCard.setReportCardEndYear(reportCardEndYear);

		Long countyKey = (Long)solrDocument.get("countyKey_stored_long");
		if(countyKey != null)
			oReportCard.setCountyKey(countyKey);

		Integer pupilsTotal = (Integer)solrDocument.get("pupilsTotal_stored_int");
		if(pupilsTotal != null)
			oReportCard.setPupilsTotal(pupilsTotal);

		Integer pupilsIndianFemale = (Integer)solrDocument.get("pupilsIndianFemale_stored_int");
		if(pupilsIndianFemale != null)
			oReportCard.setPupilsIndianFemale(pupilsIndianFemale);

		Integer pupilsIndianMale = (Integer)solrDocument.get("pupilsIndianMale_stored_int");
		if(pupilsIndianMale != null)
			oReportCard.setPupilsIndianMale(pupilsIndianMale);

		Integer pupilsIndianTotal = (Integer)solrDocument.get("pupilsIndianTotal_stored_int");
		if(pupilsIndianTotal != null)
			oReportCard.setPupilsIndianTotal(pupilsIndianTotal);

		Double pupilsIndianPercent = (Double)solrDocument.get("pupilsIndianPercent_stored_double");
		if(pupilsIndianPercent != null)
			oReportCard.setPupilsIndianPercent(pupilsIndianPercent);

		Integer pupilsAsianFemale = (Integer)solrDocument.get("pupilsAsianFemale_stored_int");
		if(pupilsAsianFemale != null)
			oReportCard.setPupilsAsianFemale(pupilsAsianFemale);

		Integer pupilsAsianMale = (Integer)solrDocument.get("pupilsAsianMale_stored_int");
		if(pupilsAsianMale != null)
			oReportCard.setPupilsAsianMale(pupilsAsianMale);

		Integer pupilsAsianTotal = (Integer)solrDocument.get("pupilsAsianTotal_stored_int");
		if(pupilsAsianTotal != null)
			oReportCard.setPupilsAsianTotal(pupilsAsianTotal);

		Double pupilsAsianPercent = (Double)solrDocument.get("pupilsAsianPercent_stored_double");
		if(pupilsAsianPercent != null)
			oReportCard.setPupilsAsianPercent(pupilsAsianPercent);

		Integer pupilsHispanicFemale = (Integer)solrDocument.get("pupilsHispanicFemale_stored_int");
		if(pupilsHispanicFemale != null)
			oReportCard.setPupilsHispanicFemale(pupilsHispanicFemale);

		Integer pupilsHispanicMale = (Integer)solrDocument.get("pupilsHispanicMale_stored_int");
		if(pupilsHispanicMale != null)
			oReportCard.setPupilsHispanicMale(pupilsHispanicMale);

		Integer pupilsHispanicTotal = (Integer)solrDocument.get("pupilsHispanicTotal_stored_int");
		if(pupilsHispanicTotal != null)
			oReportCard.setPupilsHispanicTotal(pupilsHispanicTotal);

		Double pupilsHispanicPercent = (Double)solrDocument.get("pupilsHispanicPercent_stored_double");
		if(pupilsHispanicPercent != null)
			oReportCard.setPupilsHispanicPercent(pupilsHispanicPercent);

		Integer pupilsBlackFemale = (Integer)solrDocument.get("pupilsBlackFemale_stored_int");
		if(pupilsBlackFemale != null)
			oReportCard.setPupilsBlackFemale(pupilsBlackFemale);

		Integer pupilsBlackMale = (Integer)solrDocument.get("pupilsBlackMale_stored_int");
		if(pupilsBlackMale != null)
			oReportCard.setPupilsBlackMale(pupilsBlackMale);

		Integer pupilsBlackTotal = (Integer)solrDocument.get("pupilsBlackTotal_stored_int");
		if(pupilsBlackTotal != null)
			oReportCard.setPupilsBlackTotal(pupilsBlackTotal);

		Double pupilsBlackPercent = (Double)solrDocument.get("pupilsBlackPercent_stored_double");
		if(pupilsBlackPercent != null)
			oReportCard.setPupilsBlackPercent(pupilsBlackPercent);

		Integer pupilsWhiteFemale = (Integer)solrDocument.get("pupilsWhiteFemale_stored_int");
		if(pupilsWhiteFemale != null)
			oReportCard.setPupilsWhiteFemale(pupilsWhiteFemale);

		Integer pupilsWhiteMale = (Integer)solrDocument.get("pupilsWhiteMale_stored_int");
		if(pupilsWhiteMale != null)
			oReportCard.setPupilsWhiteMale(pupilsWhiteMale);

		Integer pupilsWhiteTotal = (Integer)solrDocument.get("pupilsWhiteTotal_stored_int");
		if(pupilsWhiteTotal != null)
			oReportCard.setPupilsWhiteTotal(pupilsWhiteTotal);

		Double pupilsWhitePercent = (Double)solrDocument.get("pupilsWhitePercent_stored_double");
		if(pupilsWhitePercent != null)
			oReportCard.setPupilsWhitePercent(pupilsWhitePercent);

		Integer pupilsPacificIslanderFemale = (Integer)solrDocument.get("pupilsPacificIslanderFemale_stored_int");
		if(pupilsPacificIslanderFemale != null)
			oReportCard.setPupilsPacificIslanderFemale(pupilsPacificIslanderFemale);

		Integer pupilsPacificIslanderMale = (Integer)solrDocument.get("pupilsPacificIslanderMale_stored_int");
		if(pupilsPacificIslanderMale != null)
			oReportCard.setPupilsPacificIslanderMale(pupilsPacificIslanderMale);

		Integer pupilsPacificIslanderTotal = (Integer)solrDocument.get("pupilsPacificIslanderTotal_stored_int");
		if(pupilsPacificIslanderTotal != null)
			oReportCard.setPupilsPacificIslanderTotal(pupilsPacificIslanderTotal);

		Double pupilsPacificIslanderPercent = (Double)solrDocument.get("pupilsPacificIslanderPercent_stored_double");
		if(pupilsPacificIslanderPercent != null)
			oReportCard.setPupilsPacificIslanderPercent(pupilsPacificIslanderPercent);

		Integer pupilsMultiRacialFemale = (Integer)solrDocument.get("pupilsMultiRacialFemale_stored_int");
		if(pupilsMultiRacialFemale != null)
			oReportCard.setPupilsMultiRacialFemale(pupilsMultiRacialFemale);

		Integer pupilsMultiRacialMale = (Integer)solrDocument.get("pupilsMultiRacialMale_stored_int");
		if(pupilsMultiRacialMale != null)
			oReportCard.setPupilsMultiRacialMale(pupilsMultiRacialMale);

		Integer pupilsMultiRacialTotal = (Integer)solrDocument.get("pupilsMultiRacialTotal_stored_int");
		if(pupilsMultiRacialTotal != null)
			oReportCard.setPupilsMultiRacialTotal(pupilsMultiRacialTotal);

		Double pupilsMultiRacialPercent = (Double)solrDocument.get("pupilsMultiRacialPercent_stored_double");
		if(pupilsMultiRacialPercent != null)
			oReportCard.setPupilsMultiRacialPercent(pupilsMultiRacialPercent);

		Integer delinquentComplaintsTotal = (Integer)solrDocument.get("delinquentComplaintsTotal_stored_int");
		if(delinquentComplaintsTotal != null)
			oReportCard.setDelinquentComplaintsTotal(delinquentComplaintsTotal);

		Integer delinquentComplaintsAtSchool = (Integer)solrDocument.get("delinquentComplaintsAtSchool_stored_int");
		if(delinquentComplaintsAtSchool != null)
			oReportCard.setDelinquentComplaintsAtSchool(delinquentComplaintsAtSchool);

		Double delinquentComplaintsAtSchoolPercent = (Double)solrDocument.get("delinquentComplaintsAtSchoolPercent_stored_double");
		if(delinquentComplaintsAtSchoolPercent != null)
			oReportCard.setDelinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercent);

		Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
		if(stateKey != null)
			oReportCard.setStateKey(stateKey);

		String stateName = (String)solrDocument.get("stateName_stored_string");
		if(stateName != null)
			oReportCard.setStateName(stateName);

		String stateAbbreviation = (String)solrDocument.get("stateAbbreviation_stored_string");
		if(stateAbbreviation != null)
			oReportCard.setStateAbbreviation(stateAbbreviation);

		String countyName = (String)solrDocument.get("countyName_stored_string");
		if(countyName != null)
			oReportCard.setCountyName(countyName);

		String countyCompleteName = (String)solrDocument.get("countyCompleteName_stored_string");
		if(countyCompleteName != null)
			oReportCard.setCountyCompleteName(countyCompleteName);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportCard() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportCard) {
			ReportCard original = (ReportCard)o;
			if(!Objects.equals(reportCardKey, original.getReportCardKey()))
				apiRequest.addVars("reportCardKey");
			if(!Objects.equals(reportCardStartYear, original.getReportCardStartYear()))
				apiRequest.addVars("reportCardStartYear");
			if(!Objects.equals(reportCardEndYear, original.getReportCardEndYear()))
				apiRequest.addVars("reportCardEndYear");
			if(!Objects.equals(countyKey, original.getCountyKey()))
				apiRequest.addVars("countyKey");
			if(!Objects.equals(pupilsTotal, original.getPupilsTotal()))
				apiRequest.addVars("pupilsTotal");
			if(!Objects.equals(pupilsIndianFemale, original.getPupilsIndianFemale()))
				apiRequest.addVars("pupilsIndianFemale");
			if(!Objects.equals(pupilsIndianMale, original.getPupilsIndianMale()))
				apiRequest.addVars("pupilsIndianMale");
			if(!Objects.equals(pupilsIndianTotal, original.getPupilsIndianTotal()))
				apiRequest.addVars("pupilsIndianTotal");
			if(!Objects.equals(pupilsIndianPercent, original.getPupilsIndianPercent()))
				apiRequest.addVars("pupilsIndianPercent");
			if(!Objects.equals(pupilsAsianFemale, original.getPupilsAsianFemale()))
				apiRequest.addVars("pupilsAsianFemale");
			if(!Objects.equals(pupilsAsianMale, original.getPupilsAsianMale()))
				apiRequest.addVars("pupilsAsianMale");
			if(!Objects.equals(pupilsAsianTotal, original.getPupilsAsianTotal()))
				apiRequest.addVars("pupilsAsianTotal");
			if(!Objects.equals(pupilsAsianPercent, original.getPupilsAsianPercent()))
				apiRequest.addVars("pupilsAsianPercent");
			if(!Objects.equals(pupilsHispanicFemale, original.getPupilsHispanicFemale()))
				apiRequest.addVars("pupilsHispanicFemale");
			if(!Objects.equals(pupilsHispanicMale, original.getPupilsHispanicMale()))
				apiRequest.addVars("pupilsHispanicMale");
			if(!Objects.equals(pupilsHispanicTotal, original.getPupilsHispanicTotal()))
				apiRequest.addVars("pupilsHispanicTotal");
			if(!Objects.equals(pupilsHispanicPercent, original.getPupilsHispanicPercent()))
				apiRequest.addVars("pupilsHispanicPercent");
			if(!Objects.equals(pupilsBlackFemale, original.getPupilsBlackFemale()))
				apiRequest.addVars("pupilsBlackFemale");
			if(!Objects.equals(pupilsBlackMale, original.getPupilsBlackMale()))
				apiRequest.addVars("pupilsBlackMale");
			if(!Objects.equals(pupilsBlackTotal, original.getPupilsBlackTotal()))
				apiRequest.addVars("pupilsBlackTotal");
			if(!Objects.equals(pupilsBlackPercent, original.getPupilsBlackPercent()))
				apiRequest.addVars("pupilsBlackPercent");
			if(!Objects.equals(pupilsWhiteFemale, original.getPupilsWhiteFemale()))
				apiRequest.addVars("pupilsWhiteFemale");
			if(!Objects.equals(pupilsWhiteMale, original.getPupilsWhiteMale()))
				apiRequest.addVars("pupilsWhiteMale");
			if(!Objects.equals(pupilsWhiteTotal, original.getPupilsWhiteTotal()))
				apiRequest.addVars("pupilsWhiteTotal");
			if(!Objects.equals(pupilsWhitePercent, original.getPupilsWhitePercent()))
				apiRequest.addVars("pupilsWhitePercent");
			if(!Objects.equals(pupilsPacificIslanderFemale, original.getPupilsPacificIslanderFemale()))
				apiRequest.addVars("pupilsPacificIslanderFemale");
			if(!Objects.equals(pupilsPacificIslanderMale, original.getPupilsPacificIslanderMale()))
				apiRequest.addVars("pupilsPacificIslanderMale");
			if(!Objects.equals(pupilsPacificIslanderTotal, original.getPupilsPacificIslanderTotal()))
				apiRequest.addVars("pupilsPacificIslanderTotal");
			if(!Objects.equals(pupilsPacificIslanderPercent, original.getPupilsPacificIslanderPercent()))
				apiRequest.addVars("pupilsPacificIslanderPercent");
			if(!Objects.equals(pupilsMultiRacialFemale, original.getPupilsMultiRacialFemale()))
				apiRequest.addVars("pupilsMultiRacialFemale");
			if(!Objects.equals(pupilsMultiRacialMale, original.getPupilsMultiRacialMale()))
				apiRequest.addVars("pupilsMultiRacialMale");
			if(!Objects.equals(pupilsMultiRacialTotal, original.getPupilsMultiRacialTotal()))
				apiRequest.addVars("pupilsMultiRacialTotal");
			if(!Objects.equals(pupilsMultiRacialPercent, original.getPupilsMultiRacialPercent()))
				apiRequest.addVars("pupilsMultiRacialPercent");
			if(!Objects.equals(delinquentComplaintsTotal, original.getDelinquentComplaintsTotal()))
				apiRequest.addVars("delinquentComplaintsTotal");
			if(!Objects.equals(delinquentComplaintsAtSchool, original.getDelinquentComplaintsAtSchool()))
				apiRequest.addVars("delinquentComplaintsAtSchool");
			if(!Objects.equals(delinquentComplaintsAtSchoolPercent, original.getDelinquentComplaintsAtSchoolPercent()))
				apiRequest.addVars("delinquentComplaintsAtSchoolPercent");
			if(!Objects.equals(stateKey, original.getStateKey()))
				apiRequest.addVars("stateKey");
			if(!Objects.equals(stateName, original.getStateName()))
				apiRequest.addVars("stateName");
			if(!Objects.equals(stateAbbreviation, original.getStateAbbreviation()))
				apiRequest.addVars("stateAbbreviation");
			if(!Objects.equals(countyName, original.getCountyName()))
				apiRequest.addVars("countyName");
			if(!Objects.equals(countyCompleteName, original.getCountyCompleteName()))
				apiRequest.addVars("countyCompleteName");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), reportCardKey, reportCardStartYear, reportCardEndYear, countyKey, pupilsTotal, pupilsIndianFemale, pupilsIndianMale, pupilsIndianTotal, pupilsIndianPercent, pupilsAsianFemale, pupilsAsianMale, pupilsAsianTotal, pupilsAsianPercent, pupilsHispanicFemale, pupilsHispanicMale, pupilsHispanicTotal, pupilsHispanicPercent, pupilsBlackFemale, pupilsBlackMale, pupilsBlackTotal, pupilsBlackPercent, pupilsWhiteFemale, pupilsWhiteMale, pupilsWhiteTotal, pupilsWhitePercent, pupilsPacificIslanderFemale, pupilsPacificIslanderMale, pupilsPacificIslanderTotal, pupilsPacificIslanderPercent, pupilsMultiRacialFemale, pupilsMultiRacialMale, pupilsMultiRacialTotal, pupilsMultiRacialPercent, delinquentComplaintsTotal, delinquentComplaintsAtSchool, delinquentComplaintsAtSchoolPercent, stateKey, stateName, stateAbbreviation, countyName, countyCompleteName);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof ReportCard))
			return false;
		ReportCard that = (ReportCard)o;
		return super.equals(o)
				&& Objects.equals( reportCardKey, that.reportCardKey )
				&& Objects.equals( reportCardStartYear, that.reportCardStartYear )
				&& Objects.equals( reportCardEndYear, that.reportCardEndYear )
				&& Objects.equals( countyKey, that.countyKey )
				&& Objects.equals( pupilsTotal, that.pupilsTotal )
				&& Objects.equals( pupilsIndianFemale, that.pupilsIndianFemale )
				&& Objects.equals( pupilsIndianMale, that.pupilsIndianMale )
				&& Objects.equals( pupilsIndianTotal, that.pupilsIndianTotal )
				&& Objects.equals( pupilsIndianPercent, that.pupilsIndianPercent )
				&& Objects.equals( pupilsAsianFemale, that.pupilsAsianFemale )
				&& Objects.equals( pupilsAsianMale, that.pupilsAsianMale )
				&& Objects.equals( pupilsAsianTotal, that.pupilsAsianTotal )
				&& Objects.equals( pupilsAsianPercent, that.pupilsAsianPercent )
				&& Objects.equals( pupilsHispanicFemale, that.pupilsHispanicFemale )
				&& Objects.equals( pupilsHispanicMale, that.pupilsHispanicMale )
				&& Objects.equals( pupilsHispanicTotal, that.pupilsHispanicTotal )
				&& Objects.equals( pupilsHispanicPercent, that.pupilsHispanicPercent )
				&& Objects.equals( pupilsBlackFemale, that.pupilsBlackFemale )
				&& Objects.equals( pupilsBlackMale, that.pupilsBlackMale )
				&& Objects.equals( pupilsBlackTotal, that.pupilsBlackTotal )
				&& Objects.equals( pupilsBlackPercent, that.pupilsBlackPercent )
				&& Objects.equals( pupilsWhiteFemale, that.pupilsWhiteFemale )
				&& Objects.equals( pupilsWhiteMale, that.pupilsWhiteMale )
				&& Objects.equals( pupilsWhiteTotal, that.pupilsWhiteTotal )
				&& Objects.equals( pupilsWhitePercent, that.pupilsWhitePercent )
				&& Objects.equals( pupilsPacificIslanderFemale, that.pupilsPacificIslanderFemale )
				&& Objects.equals( pupilsPacificIslanderMale, that.pupilsPacificIslanderMale )
				&& Objects.equals( pupilsPacificIslanderTotal, that.pupilsPacificIslanderTotal )
				&& Objects.equals( pupilsPacificIslanderPercent, that.pupilsPacificIslanderPercent )
				&& Objects.equals( pupilsMultiRacialFemale, that.pupilsMultiRacialFemale )
				&& Objects.equals( pupilsMultiRacialMale, that.pupilsMultiRacialMale )
				&& Objects.equals( pupilsMultiRacialTotal, that.pupilsMultiRacialTotal )
				&& Objects.equals( pupilsMultiRacialPercent, that.pupilsMultiRacialPercent )
				&& Objects.equals( delinquentComplaintsTotal, that.delinquentComplaintsTotal )
				&& Objects.equals( delinquentComplaintsAtSchool, that.delinquentComplaintsAtSchool )
				&& Objects.equals( delinquentComplaintsAtSchoolPercent, that.delinquentComplaintsAtSchoolPercent )
				&& Objects.equals( stateKey, that.stateKey )
				&& Objects.equals( stateName, that.stateName )
				&& Objects.equals( stateAbbreviation, that.stateAbbreviation )
				&& Objects.equals( countyName, that.countyName )
				&& Objects.equals( countyCompleteName, that.countyCompleteName );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ReportCard { ");
		sb.append( "reportCardKey: " ).append(reportCardKey);
		sb.append( ", reportCardStartYear: " ).append(reportCardStartYear);
		sb.append( ", reportCardEndYear: " ).append(reportCardEndYear);
		sb.append( ", countyKey: " ).append(countyKey);
		sb.append( ", pupilsTotal: " ).append(pupilsTotal);
		sb.append( ", pupilsIndianFemale: " ).append(pupilsIndianFemale);
		sb.append( ", pupilsIndianMale: " ).append(pupilsIndianMale);
		sb.append( ", pupilsIndianTotal: " ).append(pupilsIndianTotal);
		sb.append( ", pupilsIndianPercent: " ).append(pupilsIndianPercent);
		sb.append( ", pupilsAsianFemale: " ).append(pupilsAsianFemale);
		sb.append( ", pupilsAsianMale: " ).append(pupilsAsianMale);
		sb.append( ", pupilsAsianTotal: " ).append(pupilsAsianTotal);
		sb.append( ", pupilsAsianPercent: " ).append(pupilsAsianPercent);
		sb.append( ", pupilsHispanicFemale: " ).append(pupilsHispanicFemale);
		sb.append( ", pupilsHispanicMale: " ).append(pupilsHispanicMale);
		sb.append( ", pupilsHispanicTotal: " ).append(pupilsHispanicTotal);
		sb.append( ", pupilsHispanicPercent: " ).append(pupilsHispanicPercent);
		sb.append( ", pupilsBlackFemale: " ).append(pupilsBlackFemale);
		sb.append( ", pupilsBlackMale: " ).append(pupilsBlackMale);
		sb.append( ", pupilsBlackTotal: " ).append(pupilsBlackTotal);
		sb.append( ", pupilsBlackPercent: " ).append(pupilsBlackPercent);
		sb.append( ", pupilsWhiteFemale: " ).append(pupilsWhiteFemale);
		sb.append( ", pupilsWhiteMale: " ).append(pupilsWhiteMale);
		sb.append( ", pupilsWhiteTotal: " ).append(pupilsWhiteTotal);
		sb.append( ", pupilsWhitePercent: " ).append(pupilsWhitePercent);
		sb.append( ", pupilsPacificIslanderFemale: " ).append(pupilsPacificIslanderFemale);
		sb.append( ", pupilsPacificIslanderMale: " ).append(pupilsPacificIslanderMale);
		sb.append( ", pupilsPacificIslanderTotal: " ).append(pupilsPacificIslanderTotal);
		sb.append( ", pupilsPacificIslanderPercent: " ).append(pupilsPacificIslanderPercent);
		sb.append( ", pupilsMultiRacialFemale: " ).append(pupilsMultiRacialFemale);
		sb.append( ", pupilsMultiRacialMale: " ).append(pupilsMultiRacialMale);
		sb.append( ", pupilsMultiRacialTotal: " ).append(pupilsMultiRacialTotal);
		sb.append( ", pupilsMultiRacialPercent: " ).append(pupilsMultiRacialPercent);
		sb.append( ", delinquentComplaintsTotal: " ).append(delinquentComplaintsTotal);
		sb.append( ", delinquentComplaintsAtSchool: " ).append(delinquentComplaintsAtSchool);
		sb.append( ", delinquentComplaintsAtSchoolPercent: " ).append(delinquentComplaintsAtSchoolPercent);
		sb.append( ", stateKey: " ).append(stateKey);
		sb.append( ", stateName: \"" ).append(stateName).append( "\"" );
		sb.append( ", stateAbbreviation: \"" ).append(stateAbbreviation).append( "\"" );
		sb.append( ", countyName: \"" ).append(countyName).append( "\"" );
		sb.append( ", countyCompleteName: \"" ).append(countyCompleteName).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
