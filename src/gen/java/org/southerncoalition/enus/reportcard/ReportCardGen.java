package org.southerncoalition.enus.reportcard;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.search.SearchList;
import java.util.Date;
import org.southerncoalition.enus.agency.SiteAgency;
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
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.commons.lang3.math.NumberUtils;
import org.southerncoalition.enus.reportcard.ReportCard;
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

	////////////////////////////
	// reportCardStartYearStr //
	////////////////////////////

	/**	 The entity reportCardStartYearStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String reportCardStartYearStr;
	@JsonIgnore
	public Wrap<String> reportCardStartYearStrWrap = new Wrap<String>().p(this).c(String.class).var("reportCardStartYearStr").o(reportCardStartYearStr);

	/**	<br/> The entity reportCardStartYearStr
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStartYearStr">Find the entity reportCardStartYearStr in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardStartYearStr(Wrap<String> c);

	public String getReportCardStartYearStr() {
		return reportCardStartYearStr;
	}

	public void setReportCardStartYearStr(String reportCardStartYearStr) {
		this.reportCardStartYearStr = reportCardStartYearStr;
		this.reportCardStartYearStrWrap.alreadyInitialized = true;
	}
	protected ReportCard reportCardStartYearStrInit() {
		if(!reportCardStartYearStrWrap.alreadyInitialized) {
			_reportCardStartYearStr(reportCardStartYearStrWrap);
			if(reportCardStartYearStr == null)
				setReportCardStartYearStr(reportCardStartYearStrWrap.o);
		}
		reportCardStartYearStrWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrReportCardStartYearStr() {
		return reportCardStartYearStr;
	}

	public String strReportCardStartYearStr() {
		return reportCardStartYearStr == null ? "" : reportCardStartYearStr;
	}

	public String jsonReportCardStartYearStr() {
		return reportCardStartYearStr == null ? "" : reportCardStartYearStr;
	}

	public String nomAffichageReportCardStartYearStr() {
		return null;
	}

	public String htmTooltipReportCardStartYearStr() {
		return null;
	}

	public String htmReportCardStartYearStr() {
		return reportCardStartYearStr == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardStartYearStr());
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

	////////////////////////
	// reportCardYearsStr //
	////////////////////////

	/**	 The entity reportCardYearsStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String reportCardYearsStr;
	@JsonIgnore
	public Wrap<String> reportCardYearsStrWrap = new Wrap<String>().p(this).c(String.class).var("reportCardYearsStr").o(reportCardYearsStr);

	/**	<br/> The entity reportCardYearsStr
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardYearsStr">Find the entity reportCardYearsStr in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardYearsStr(Wrap<String> c);

	public String getReportCardYearsStr() {
		return reportCardYearsStr;
	}

	public void setReportCardYearsStr(String reportCardYearsStr) {
		this.reportCardYearsStr = reportCardYearsStr;
		this.reportCardYearsStrWrap.alreadyInitialized = true;
	}
	protected ReportCard reportCardYearsStrInit() {
		if(!reportCardYearsStrWrap.alreadyInitialized) {
			_reportCardYearsStr(reportCardYearsStrWrap);
			if(reportCardYearsStr == null)
				setReportCardYearsStr(reportCardYearsStrWrap.o);
		}
		reportCardYearsStrWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrReportCardYearsStr() {
		return reportCardYearsStr;
	}

	public String strReportCardYearsStr() {
		return reportCardYearsStr == null ? "" : reportCardYearsStr;
	}

	public String jsonReportCardYearsStr() {
		return reportCardYearsStr == null ? "" : reportCardYearsStr;
	}

	public String nomAffichageReportCardYearsStr() {
		return null;
	}

	public String htmTooltipReportCardYearsStr() {
		return null;
	}

	public String htmReportCardYearsStr() {
		return reportCardYearsStr == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardYearsStr());
	}

	//////////////////
	// agencySearch //
	//////////////////

	/**	 The entity agencySearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteAgency>(). 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteAgency> agencySearch = new SearchList<SiteAgency>();
	@JsonIgnore
	public Wrap<SearchList<SiteAgency>> agencySearchWrap = new Wrap<SearchList<SiteAgency>>().p(this).c(SearchList.class).var("agencySearch").o(agencySearch);

	/**	<br/> The entity agencySearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteAgency>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencySearch">Find the entity agencySearch in Solr</a>
	 * <br/>
	 * @param agencySearch is the entity already constructed. 
	 **/
	protected abstract void _agencySearch(SearchList<SiteAgency> l);

	public SearchList<SiteAgency> getAgencySearch() {
		return agencySearch;
	}

	public void setAgencySearch(SearchList<SiteAgency> agencySearch) {
		this.agencySearch = agencySearch;
		this.agencySearchWrap.alreadyInitialized = true;
	}
	protected ReportCard agencySearchInit() {
		if(!agencySearchWrap.alreadyInitialized) {
			_agencySearch(agencySearch);
		}
		agencySearch.initDeepForClass(siteRequest_);
		agencySearchWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	/////////////
	// agency_ //
	/////////////

	/**	 The entity agency_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteAgency agency_;
	@JsonIgnore
	public Wrap<SiteAgency> agency_Wrap = new Wrap<SiteAgency>().p(this).c(SiteAgency.class).var("agency_").o(agency_);

	/**	<br/> The entity agency_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agency_">Find the entity agency_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agency_(Wrap<SiteAgency> c);

	public SiteAgency getAgency_() {
		return agency_;
	}

	public void setAgency_(SiteAgency agency_) {
		this.agency_ = agency_;
		this.agency_Wrap.alreadyInitialized = true;
	}
	protected ReportCard agency_Init() {
		if(!agency_Wrap.alreadyInitialized) {
			_agency_(agency_Wrap);
			if(agency_ == null)
				setAgency_(agency_Wrap.o);
		}
		agency_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	///////////////
	// agencyKey //
	///////////////

	/**	 The entity agencyKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long agencyKey;
	@JsonIgnore
	public Wrap<Long> agencyKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("agencyKey").o(agencyKey);

	/**	<br/> The entity agencyKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyKey">Find the entity agencyKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyKey(Wrap<Long> c);

	public Long getAgencyKey() {
		return agencyKey;
	}

	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
		this.agencyKeyWrap.alreadyInitialized = true;
	}
	public ReportCard setAgencyKey(String o) {
		if(NumberUtils.isParsable(o))
			this.agencyKey = Long.parseLong(o);
		this.agencyKeyWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard agencyKeyInit() {
		if(!agencyKeyWrap.alreadyInitialized) {
			_agencyKey(agencyKeyWrap);
			if(agencyKey == null)
				setAgencyKey(agencyKeyWrap.o);
		}
		agencyKeyWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrAgencyKey() {
		return agencyKey;
	}

	public String strAgencyKey() {
		return agencyKey == null ? "" : agencyKey.toString();
	}

	public String jsonAgencyKey() {
		return agencyKey == null ? "" : agencyKey.toString();
	}

	public String nomAffichageAgencyKey() {
		return "agency";
	}

	public String htmTooltipAgencyKey() {
		return null;
	}

	public String htmAgencyKey() {
		return agencyKey == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyKey());
	}

	public void inputAgencyKey(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
				e("input")
					.a("type", "text")
					.a("placeholder", "agency")
					.a("class", "value suggestAgencyKey w3-input w3-border w3-cell w3-cell-middle ")
					.a("name", "setAgencyKey")
					.a("id", classApiMethodMethod, "_agencyKey")
					.a("autocomplete", "off")
					.a("oninput", "suggestReportCardAgencyKey($(this).val() ? searchSiteAgencyFilters($(this.parentElement)) : [", pk == null ? "" : "{'name':'fq','value':'reportCardKeys:" + pk + "'}", "], $('#listReportCardAgencyKey_", classApiMethodMethod, "'), ", pk, "); ")
				.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "AgencyKey ").f().sx(htmAgencyKey()).g("span");
		}
	}

	public void htmAgencyKey(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardAgencyKey").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/agency?fq=reportCardKeys:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-pale-yellow w3-hover-pale-yellow ").f();
								e("i").a("class", "far fa-road ").f().g("i");
								sx("agency");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate a agency to this report card");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputAgencyKey(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listReportCardAgencyKey_", classApiMethodMethod).f();
								} g("ul");
								if(
										CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), SiteAgency.ROLES)
										|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), SiteAgency.ROLES)
										) {
									{ e("div").a("class", "w3-cell-row ").f();
										e("button")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-yellow ")
											.a("id", classApiMethodMethod, "_agencyKey_add")
											.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postSiteAgencyVals({ reportCardKeys: [ \"", pk, "\" ] }, function() {}, function() { addError($('#", classApiMethodMethod, "agencyKey')); });")
											.f().sx("add a agency")
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
	protected Long pupilsTotal;
	@JsonIgnore
	public Wrap<Long> pupilsTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsTotal").o(pupilsTotal);

	/**	<br/> The entity pupilsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsTotal">Find the entity pupilsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsTotal(Wrap<Long> c);

	public Long getPupilsTotal() {
		return pupilsTotal;
	}

	public void setPupilsTotal(Long pupilsTotal) {
		this.pupilsTotal = pupilsTotal;
		this.pupilsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsTotal = Long.parseLong(o);
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

	public Long solrPupilsTotal() {
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
	protected Long pupilsIndianFemale;
	@JsonIgnore
	public Wrap<Long> pupilsIndianFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsIndianFemale").o(pupilsIndianFemale);

	/**	<br/> The entity pupilsIndianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianFemale">Find the entity pupilsIndianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianFemale(Wrap<Long> c);

	public Long getPupilsIndianFemale() {
		return pupilsIndianFemale;
	}

	public void setPupilsIndianFemale(Long pupilsIndianFemale) {
		this.pupilsIndianFemale = pupilsIndianFemale;
		this.pupilsIndianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianFemale = Long.parseLong(o);
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

	public Long solrPupilsIndianFemale() {
		return pupilsIndianFemale;
	}

	public String strPupilsIndianFemale() {
		return pupilsIndianFemale == null ? "" : pupilsIndianFemale.toString();
	}

	public String jsonPupilsIndianFemale() {
		return pupilsIndianFemale == null ? "" : pupilsIndianFemale.toString();
	}

	public String nomAffichagePupilsIndianFemale() {
		return "First Nation female";
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
				.a("placeholder", "First Nation female")
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
							e("label").a("for", classApiMethodMethod, "_pupilsIndianFemale").a("class", "").f().sx("First Nation female").g("label");
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
	protected Long pupilsIndianMale;
	@JsonIgnore
	public Wrap<Long> pupilsIndianMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsIndianMale").o(pupilsIndianMale);

	/**	<br/> The entity pupilsIndianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianMale">Find the entity pupilsIndianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianMale(Wrap<Long> c);

	public Long getPupilsIndianMale() {
		return pupilsIndianMale;
	}

	public void setPupilsIndianMale(Long pupilsIndianMale) {
		this.pupilsIndianMale = pupilsIndianMale;
		this.pupilsIndianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianMale = Long.parseLong(o);
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

	public Long solrPupilsIndianMale() {
		return pupilsIndianMale;
	}

	public String strPupilsIndianMale() {
		return pupilsIndianMale == null ? "" : pupilsIndianMale.toString();
	}

	public String jsonPupilsIndianMale() {
		return pupilsIndianMale == null ? "" : pupilsIndianMale.toString();
	}

	public String nomAffichagePupilsIndianMale() {
		return "First Nation male";
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
				.a("placeholder", "First Nation male")
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
							e("label").a("for", classApiMethodMethod, "_pupilsIndianMale").a("class", "").f().sx("First Nation male").g("label");
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
	protected Long pupilsIndianTotal;
	@JsonIgnore
	public Wrap<Long> pupilsIndianTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsIndianTotal").o(pupilsIndianTotal);

	/**	<br/> The entity pupilsIndianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsIndianTotal">Find the entity pupilsIndianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsIndianTotal(Wrap<Long> c);

	public Long getPupilsIndianTotal() {
		return pupilsIndianTotal;
	}

	public void setPupilsIndianTotal(Long pupilsIndianTotal) {
		this.pupilsIndianTotal = pupilsIndianTotal;
		this.pupilsIndianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsIndianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsIndianTotal = Long.parseLong(o);
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

	public Long solrPupilsIndianTotal() {
		return pupilsIndianTotal;
	}

	public String strPupilsIndianTotal() {
		return pupilsIndianTotal == null ? "" : pupilsIndianTotal.toString();
	}

	public String jsonPupilsIndianTotal() {
		return pupilsIndianTotal == null ? "" : pupilsIndianTotal.toString();
	}

	public String nomAffichagePupilsIndianTotal() {
		return "First Nation total";
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
							e("label").a("class", "").f().sx("First Nation total").g("label");
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
		return "First Nation percent";
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
							e("label").a("class", "").f().sx("First Nation percent").g("label");
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
	protected Long pupilsAsianFemale;
	@JsonIgnore
	public Wrap<Long> pupilsAsianFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsAsianFemale").o(pupilsAsianFemale);

	/**	<br/> The entity pupilsAsianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianFemale">Find the entity pupilsAsianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianFemale(Wrap<Long> c);

	public Long getPupilsAsianFemale() {
		return pupilsAsianFemale;
	}

	public void setPupilsAsianFemale(Long pupilsAsianFemale) {
		this.pupilsAsianFemale = pupilsAsianFemale;
		this.pupilsAsianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianFemale = Long.parseLong(o);
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

	public Long solrPupilsAsianFemale() {
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
	protected Long pupilsAsianMale;
	@JsonIgnore
	public Wrap<Long> pupilsAsianMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsAsianMale").o(pupilsAsianMale);

	/**	<br/> The entity pupilsAsianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianMale">Find the entity pupilsAsianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianMale(Wrap<Long> c);

	public Long getPupilsAsianMale() {
		return pupilsAsianMale;
	}

	public void setPupilsAsianMale(Long pupilsAsianMale) {
		this.pupilsAsianMale = pupilsAsianMale;
		this.pupilsAsianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianMale = Long.parseLong(o);
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

	public Long solrPupilsAsianMale() {
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
	protected Long pupilsAsianTotal;
	@JsonIgnore
	public Wrap<Long> pupilsAsianTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsAsianTotal").o(pupilsAsianTotal);

	/**	<br/> The entity pupilsAsianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsAsianTotal">Find the entity pupilsAsianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsAsianTotal(Wrap<Long> c);

	public Long getPupilsAsianTotal() {
		return pupilsAsianTotal;
	}

	public void setPupilsAsianTotal(Long pupilsAsianTotal) {
		this.pupilsAsianTotal = pupilsAsianTotal;
		this.pupilsAsianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsAsianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsAsianTotal = Long.parseLong(o);
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

	public Long solrPupilsAsianTotal() {
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
	protected Long pupilsHispanicFemale;
	@JsonIgnore
	public Wrap<Long> pupilsHispanicFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsHispanicFemale").o(pupilsHispanicFemale);

	/**	<br/> The entity pupilsHispanicFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicFemale">Find the entity pupilsHispanicFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicFemale(Wrap<Long> c);

	public Long getPupilsHispanicFemale() {
		return pupilsHispanicFemale;
	}

	public void setPupilsHispanicFemale(Long pupilsHispanicFemale) {
		this.pupilsHispanicFemale = pupilsHispanicFemale;
		this.pupilsHispanicFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicFemale = Long.parseLong(o);
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

	public Long solrPupilsHispanicFemale() {
		return pupilsHispanicFemale;
	}

	public String strPupilsHispanicFemale() {
		return pupilsHispanicFemale == null ? "" : pupilsHispanicFemale.toString();
	}

	public String jsonPupilsHispanicFemale() {
		return pupilsHispanicFemale == null ? "" : pupilsHispanicFemale.toString();
	}

	public String nomAffichagePupilsHispanicFemale() {
		return "Latinx female";
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
				.a("placeholder", "Latinx female")
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
							e("label").a("for", classApiMethodMethod, "_pupilsHispanicFemale").a("class", "").f().sx("Latinx female").g("label");
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
	protected Long pupilsHispanicMale;
	@JsonIgnore
	public Wrap<Long> pupilsHispanicMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsHispanicMale").o(pupilsHispanicMale);

	/**	<br/> The entity pupilsHispanicMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicMale">Find the entity pupilsHispanicMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicMale(Wrap<Long> c);

	public Long getPupilsHispanicMale() {
		return pupilsHispanicMale;
	}

	public void setPupilsHispanicMale(Long pupilsHispanicMale) {
		this.pupilsHispanicMale = pupilsHispanicMale;
		this.pupilsHispanicMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicMale = Long.parseLong(o);
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

	public Long solrPupilsHispanicMale() {
		return pupilsHispanicMale;
	}

	public String strPupilsHispanicMale() {
		return pupilsHispanicMale == null ? "" : pupilsHispanicMale.toString();
	}

	public String jsonPupilsHispanicMale() {
		return pupilsHispanicMale == null ? "" : pupilsHispanicMale.toString();
	}

	public String nomAffichagePupilsHispanicMale() {
		return "Latinx male";
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
				.a("placeholder", "Latinx male")
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
							e("label").a("for", classApiMethodMethod, "_pupilsHispanicMale").a("class", "").f().sx("Latinx male").g("label");
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
	protected Long pupilsHispanicTotal;
	@JsonIgnore
	public Wrap<Long> pupilsHispanicTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsHispanicTotal").o(pupilsHispanicTotal);

	/**	<br/> The entity pupilsHispanicTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsHispanicTotal">Find the entity pupilsHispanicTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsHispanicTotal(Wrap<Long> c);

	public Long getPupilsHispanicTotal() {
		return pupilsHispanicTotal;
	}

	public void setPupilsHispanicTotal(Long pupilsHispanicTotal) {
		this.pupilsHispanicTotal = pupilsHispanicTotal;
		this.pupilsHispanicTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsHispanicTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsHispanicTotal = Long.parseLong(o);
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

	public Long solrPupilsHispanicTotal() {
		return pupilsHispanicTotal;
	}

	public String strPupilsHispanicTotal() {
		return pupilsHispanicTotal == null ? "" : pupilsHispanicTotal.toString();
	}

	public String jsonPupilsHispanicTotal() {
		return pupilsHispanicTotal == null ? "" : pupilsHispanicTotal.toString();
	}

	public String nomAffichagePupilsHispanicTotal() {
		return "Latinx total";
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
							e("label").a("class", "").f().sx("Latinx total").g("label");
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
		return "Latinx percent";
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
							e("label").a("class", "").f().sx("Latinx percent").g("label");
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
	protected Long pupilsBlackFemale;
	@JsonIgnore
	public Wrap<Long> pupilsBlackFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsBlackFemale").o(pupilsBlackFemale);

	/**	<br/> The entity pupilsBlackFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackFemale">Find the entity pupilsBlackFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackFemale(Wrap<Long> c);

	public Long getPupilsBlackFemale() {
		return pupilsBlackFemale;
	}

	public void setPupilsBlackFemale(Long pupilsBlackFemale) {
		this.pupilsBlackFemale = pupilsBlackFemale;
		this.pupilsBlackFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackFemale = Long.parseLong(o);
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

	public Long solrPupilsBlackFemale() {
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
	protected Long pupilsBlackMale;
	@JsonIgnore
	public Wrap<Long> pupilsBlackMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsBlackMale").o(pupilsBlackMale);

	/**	<br/> The entity pupilsBlackMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackMale">Find the entity pupilsBlackMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackMale(Wrap<Long> c);

	public Long getPupilsBlackMale() {
		return pupilsBlackMale;
	}

	public void setPupilsBlackMale(Long pupilsBlackMale) {
		this.pupilsBlackMale = pupilsBlackMale;
		this.pupilsBlackMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackMale = Long.parseLong(o);
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

	public Long solrPupilsBlackMale() {
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
	protected Long pupilsBlackTotal;
	@JsonIgnore
	public Wrap<Long> pupilsBlackTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsBlackTotal").o(pupilsBlackTotal);

	/**	<br/> The entity pupilsBlackTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsBlackTotal">Find the entity pupilsBlackTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsBlackTotal(Wrap<Long> c);

	public Long getPupilsBlackTotal() {
		return pupilsBlackTotal;
	}

	public void setPupilsBlackTotal(Long pupilsBlackTotal) {
		this.pupilsBlackTotal = pupilsBlackTotal;
		this.pupilsBlackTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsBlackTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsBlackTotal = Long.parseLong(o);
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

	public Long solrPupilsBlackTotal() {
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
	protected Long pupilsWhiteFemale;
	@JsonIgnore
	public Wrap<Long> pupilsWhiteFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsWhiteFemale").o(pupilsWhiteFemale);

	/**	<br/> The entity pupilsWhiteFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteFemale">Find the entity pupilsWhiteFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteFemale(Wrap<Long> c);

	public Long getPupilsWhiteFemale() {
		return pupilsWhiteFemale;
	}

	public void setPupilsWhiteFemale(Long pupilsWhiteFemale) {
		this.pupilsWhiteFemale = pupilsWhiteFemale;
		this.pupilsWhiteFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteFemale = Long.parseLong(o);
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

	public Long solrPupilsWhiteFemale() {
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
	protected Long pupilsWhiteMale;
	@JsonIgnore
	public Wrap<Long> pupilsWhiteMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsWhiteMale").o(pupilsWhiteMale);

	/**	<br/> The entity pupilsWhiteMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteMale">Find the entity pupilsWhiteMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteMale(Wrap<Long> c);

	public Long getPupilsWhiteMale() {
		return pupilsWhiteMale;
	}

	public void setPupilsWhiteMale(Long pupilsWhiteMale) {
		this.pupilsWhiteMale = pupilsWhiteMale;
		this.pupilsWhiteMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteMale = Long.parseLong(o);
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

	public Long solrPupilsWhiteMale() {
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
	protected Long pupilsWhiteTotal;
	@JsonIgnore
	public Wrap<Long> pupilsWhiteTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsWhiteTotal").o(pupilsWhiteTotal);

	/**	<br/> The entity pupilsWhiteTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsWhiteTotal">Find the entity pupilsWhiteTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsWhiteTotal(Wrap<Long> c);

	public Long getPupilsWhiteTotal() {
		return pupilsWhiteTotal;
	}

	public void setPupilsWhiteTotal(Long pupilsWhiteTotal) {
		this.pupilsWhiteTotal = pupilsWhiteTotal;
		this.pupilsWhiteTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsWhiteTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsWhiteTotal = Long.parseLong(o);
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

	public Long solrPupilsWhiteTotal() {
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
	protected Long pupilsPacificIslanderFemale;
	@JsonIgnore
	public Wrap<Long> pupilsPacificIslanderFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsPacificIslanderFemale").o(pupilsPacificIslanderFemale);

	/**	<br/> The entity pupilsPacificIslanderFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderFemale">Find the entity pupilsPacificIslanderFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderFemale(Wrap<Long> c);

	public Long getPupilsPacificIslanderFemale() {
		return pupilsPacificIslanderFemale;
	}

	public void setPupilsPacificIslanderFemale(Long pupilsPacificIslanderFemale) {
		this.pupilsPacificIslanderFemale = pupilsPacificIslanderFemale;
		this.pupilsPacificIslanderFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderFemale = Long.parseLong(o);
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

	public Long solrPupilsPacificIslanderFemale() {
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
	protected Long pupilsPacificIslanderMale;
	@JsonIgnore
	public Wrap<Long> pupilsPacificIslanderMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsPacificIslanderMale").o(pupilsPacificIslanderMale);

	/**	<br/> The entity pupilsPacificIslanderMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderMale">Find the entity pupilsPacificIslanderMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderMale(Wrap<Long> c);

	public Long getPupilsPacificIslanderMale() {
		return pupilsPacificIslanderMale;
	}

	public void setPupilsPacificIslanderMale(Long pupilsPacificIslanderMale) {
		this.pupilsPacificIslanderMale = pupilsPacificIslanderMale;
		this.pupilsPacificIslanderMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderMale = Long.parseLong(o);
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

	public Long solrPupilsPacificIslanderMale() {
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
	protected Long pupilsPacificIslanderTotal;
	@JsonIgnore
	public Wrap<Long> pupilsPacificIslanderTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsPacificIslanderTotal").o(pupilsPacificIslanderTotal);

	/**	<br/> The entity pupilsPacificIslanderTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsPacificIslanderTotal">Find the entity pupilsPacificIslanderTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsPacificIslanderTotal(Wrap<Long> c);

	public Long getPupilsPacificIslanderTotal() {
		return pupilsPacificIslanderTotal;
	}

	public void setPupilsPacificIslanderTotal(Long pupilsPacificIslanderTotal) {
		this.pupilsPacificIslanderTotal = pupilsPacificIslanderTotal;
		this.pupilsPacificIslanderTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsPacificIslanderTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsPacificIslanderTotal = Long.parseLong(o);
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

	public Long solrPupilsPacificIslanderTotal() {
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
	protected Long pupilsMultiRacialFemale;
	@JsonIgnore
	public Wrap<Long> pupilsMultiRacialFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsMultiRacialFemale").o(pupilsMultiRacialFemale);

	/**	<br/> The entity pupilsMultiRacialFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialFemale">Find the entity pupilsMultiRacialFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialFemale(Wrap<Long> c);

	public Long getPupilsMultiRacialFemale() {
		return pupilsMultiRacialFemale;
	}

	public void setPupilsMultiRacialFemale(Long pupilsMultiRacialFemale) {
		this.pupilsMultiRacialFemale = pupilsMultiRacialFemale;
		this.pupilsMultiRacialFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialFemale = Long.parseLong(o);
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

	public Long solrPupilsMultiRacialFemale() {
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
	protected Long pupilsMultiRacialMale;
	@JsonIgnore
	public Wrap<Long> pupilsMultiRacialMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsMultiRacialMale").o(pupilsMultiRacialMale);

	/**	<br/> The entity pupilsMultiRacialMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialMale">Find the entity pupilsMultiRacialMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialMale(Wrap<Long> c);

	public Long getPupilsMultiRacialMale() {
		return pupilsMultiRacialMale;
	}

	public void setPupilsMultiRacialMale(Long pupilsMultiRacialMale) {
		this.pupilsMultiRacialMale = pupilsMultiRacialMale;
		this.pupilsMultiRacialMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialMale(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialMale = Long.parseLong(o);
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

	public Long solrPupilsMultiRacialMale() {
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
	protected Long pupilsMultiRacialTotal;
	@JsonIgnore
	public Wrap<Long> pupilsMultiRacialTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("pupilsMultiRacialTotal").o(pupilsMultiRacialTotal);

	/**	<br/> The entity pupilsMultiRacialTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilsMultiRacialTotal">Find the entity pupilsMultiRacialTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilsMultiRacialTotal(Wrap<Long> c);

	public Long getPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal;
	}

	public void setPupilsMultiRacialTotal(Long pupilsMultiRacialTotal) {
		this.pupilsMultiRacialTotal = pupilsMultiRacialTotal;
		this.pupilsMultiRacialTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setPupilsMultiRacialTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.pupilsMultiRacialTotal = Long.parseLong(o);
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

	public Long solrPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal;
	}

	public String strPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal == null ? "" : pupilsMultiRacialTotal.toString();
	}

	public String jsonPupilsMultiRacialTotal() {
		return pupilsMultiRacialTotal == null ? "" : pupilsMultiRacialTotal.toString();
	}

	public String nomAffichagePupilsMultiRacialTotal() {
		return "Multi Racial total";
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
							e("label").a("class", "").f().sx("Multi Racial total").g("label");
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
		return "Multi Racial percent";
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
							e("label").a("class", "").f().sx("Multi Racial percent").g("label");
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

	//////////////////
	// teachersMale //
	//////////////////

	/**	 The entity teachersMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersMale;
	@JsonIgnore
	public Wrap<Long> teachersMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersMale").o(teachersMale);

	/**	<br/> The entity teachersMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersMale">Find the entity teachersMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersMale(Wrap<Long> c);

	public Long getTeachersMale() {
		return teachersMale;
	}

	public void setTeachersMale(Long teachersMale) {
		this.teachersMale = teachersMale;
		this.teachersMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersMale(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersMale = Long.parseLong(o);
		this.teachersMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersMaleInit() {
		if(!teachersMaleWrap.alreadyInitialized) {
			_teachersMale(teachersMaleWrap);
			if(teachersMale == null)
				setTeachersMale(teachersMaleWrap.o);
		}
		teachersMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersMale() {
		return teachersMale;
	}

	public String strTeachersMale() {
		return teachersMale == null ? "" : teachersMale.toString();
	}

	public String jsonTeachersMale() {
		return teachersMale == null ? "" : teachersMale.toString();
	}

	public String nomAffichageTeachersMale() {
		return "male teachers total";
	}

	public String htmTooltipTeachersMale() {
		return null;
	}

	public String htmTeachersMale() {
		return teachersMale == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersMale());
	}

	public void inputTeachersMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "male teachers total")
				.a("id", classApiMethodMethod, "_teachersMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setTeachersMale classReportCard inputReportCard", pk, "TeachersMale w3-input w3-border ");
					a("name", "setTeachersMale");
				} else {
					a("class", "valueTeachersMale w3-input w3-border classReportCard inputReportCard", pk, "TeachersMale w3-input w3-border ");
					a("name", "teachersMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setTeachersMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_teachersMale')); }, function() { addError($('#", classApiMethodMethod, "_teachersMale')); }); ");
				}
				a("value", strTeachersMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "TeachersMale ").f().sx(htmTeachersMale()).g("span");
		}
	}

	public void htmTeachersMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardTeachersMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_teachersMale").a("class", "").f().sx("male teachers total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTeachersMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_teachersMale')); $('#", classApiMethodMethod, "_teachersMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setTeachersMale', null, function() { addGlow($('#", classApiMethodMethod, "_teachersMale')); }, function() { addError($('#", classApiMethodMethod, "_teachersMale')); }); ")
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

	////////////////////
	// teachersFemale //
	////////////////////

	/**	 The entity teachersFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersFemale;
	@JsonIgnore
	public Wrap<Long> teachersFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersFemale").o(teachersFemale);

	/**	<br/> The entity teachersFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersFemale">Find the entity teachersFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersFemale(Wrap<Long> c);

	public Long getTeachersFemale() {
		return teachersFemale;
	}

	public void setTeachersFemale(Long teachersFemale) {
		this.teachersFemale = teachersFemale;
		this.teachersFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersFemale = Long.parseLong(o);
		this.teachersFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersFemaleInit() {
		if(!teachersFemaleWrap.alreadyInitialized) {
			_teachersFemale(teachersFemaleWrap);
			if(teachersFemale == null)
				setTeachersFemale(teachersFemaleWrap.o);
		}
		teachersFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersFemale() {
		return teachersFemale;
	}

	public String strTeachersFemale() {
		return teachersFemale == null ? "" : teachersFemale.toString();
	}

	public String jsonTeachersFemale() {
		return teachersFemale == null ? "" : teachersFemale.toString();
	}

	public String nomAffichageTeachersFemale() {
		return "female teachers total";
	}

	public String htmTooltipTeachersFemale() {
		return null;
	}

	public String htmTeachersFemale() {
		return teachersFemale == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersFemale());
	}

	public void inputTeachersFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "female teachers total")
				.a("id", classApiMethodMethod, "_teachersFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setTeachersFemale classReportCard inputReportCard", pk, "TeachersFemale w3-input w3-border ");
					a("name", "setTeachersFemale");
				} else {
					a("class", "valueTeachersFemale w3-input w3-border classReportCard inputReportCard", pk, "TeachersFemale w3-input w3-border ");
					a("name", "teachersFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setTeachersFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_teachersFemale')); }, function() { addError($('#", classApiMethodMethod, "_teachersFemale')); }); ");
				}
				a("value", strTeachersFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "TeachersFemale ").f().sx(htmTeachersFemale()).g("span");
		}
	}

	public void htmTeachersFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardTeachersFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_teachersFemale").a("class", "").f().sx("female teachers total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTeachersFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_teachersFemale')); $('#", classApiMethodMethod, "_teachersFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setTeachersFemale', null, function() { addGlow($('#", classApiMethodMethod, "_teachersFemale')); }, function() { addError($('#", classApiMethodMethod, "_teachersFemale')); }); ")
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

	///////////////////
	// teachersTotal //
	///////////////////

	/**	 The entity teachersTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersTotal;
	@JsonIgnore
	public Wrap<Long> teachersTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersTotal").o(teachersTotal);

	/**	<br/> The entity teachersTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersTotal">Find the entity teachersTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersTotal(Wrap<Long> c);

	public Long getTeachersTotal() {
		return teachersTotal;
	}

	public void setTeachersTotal(Long teachersTotal) {
		this.teachersTotal = teachersTotal;
		this.teachersTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersTotal = Long.parseLong(o);
		this.teachersTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersTotalInit() {
		if(!teachersTotalWrap.alreadyInitialized) {
			_teachersTotal(teachersTotalWrap);
			if(teachersTotal == null)
				setTeachersTotal(teachersTotalWrap.o);
		}
		teachersTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersTotal() {
		return teachersTotal;
	}

	public String strTeachersTotal() {
		return teachersTotal == null ? "" : teachersTotal.toString();
	}

	public String jsonTeachersTotal() {
		return teachersTotal == null ? "" : teachersTotal.toString();
	}

	public String nomAffichageTeachersTotal() {
		return "teachers total";
	}

	public String htmTooltipTeachersTotal() {
		return null;
	}

	public String htmTeachersTotal() {
		return teachersTotal == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersTotal());
	}

	public void inputTeachersTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmTeachersTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("teachers total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "TeachersTotal ").f().sx(strTeachersTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// teachersWhiteTotal //
	////////////////////////

	/**	 The entity teachersWhiteTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersWhiteTotal;
	@JsonIgnore
	public Wrap<Long> teachersWhiteTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersWhiteTotal").o(teachersWhiteTotal);

	/**	<br/> The entity teachersWhiteTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersWhiteTotal">Find the entity teachersWhiteTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersWhiteTotal(Wrap<Long> c);

	public Long getTeachersWhiteTotal() {
		return teachersWhiteTotal;
	}

	public void setTeachersWhiteTotal(Long teachersWhiteTotal) {
		this.teachersWhiteTotal = teachersWhiteTotal;
		this.teachersWhiteTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersWhiteTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersWhiteTotal = Long.parseLong(o);
		this.teachersWhiteTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersWhiteTotalInit() {
		if(!teachersWhiteTotalWrap.alreadyInitialized) {
			_teachersWhiteTotal(teachersWhiteTotalWrap);
			if(teachersWhiteTotal == null)
				setTeachersWhiteTotal(teachersWhiteTotalWrap.o);
		}
		teachersWhiteTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersWhiteTotal() {
		return teachersWhiteTotal;
	}

	public String strTeachersWhiteTotal() {
		return teachersWhiteTotal == null ? "" : teachersWhiteTotal.toString();
	}

	public String jsonTeachersWhiteTotal() {
		return teachersWhiteTotal == null ? "" : teachersWhiteTotal.toString();
	}

	public String nomAffichageTeachersWhiteTotal() {
		return "White teachers";
	}

	public String htmTooltipTeachersWhiteTotal() {
		return null;
	}

	public String htmTeachersWhiteTotal() {
		return teachersWhiteTotal == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersWhiteTotal());
	}

	public void inputTeachersWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "White teachers")
				.a("id", classApiMethodMethod, "_teachersWhiteTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setTeachersWhiteTotal classReportCard inputReportCard", pk, "TeachersWhiteTotal w3-input w3-border ");
					a("name", "setTeachersWhiteTotal");
				} else {
					a("class", "valueTeachersWhiteTotal w3-input w3-border classReportCard inputReportCard", pk, "TeachersWhiteTotal w3-input w3-border ");
					a("name", "teachersWhiteTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setTeachersWhiteTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_teachersWhiteTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersWhiteTotal')); }); ");
				}
				a("value", strTeachersWhiteTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "TeachersWhiteTotal ").f().sx(htmTeachersWhiteTotal()).g("span");
		}
	}

	public void htmTeachersWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardTeachersWhiteTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_teachersWhiteTotal").a("class", "").f().sx("White teachers").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTeachersWhiteTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_teachersWhiteTotal')); $('#", classApiMethodMethod, "_teachersWhiteTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setTeachersWhiteTotal', null, function() { addGlow($('#", classApiMethodMethod, "_teachersWhiteTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersWhiteTotal')); }); ")
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

	//////////////////////////
	// teachersWhitePercent //
	//////////////////////////

	/**	 The entity teachersWhitePercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal teachersWhitePercent;
	@JsonIgnore
	public Wrap<BigDecimal> teachersWhitePercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("teachersWhitePercent").o(teachersWhitePercent);

	/**	<br/> The entity teachersWhitePercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersWhitePercent">Find the entity teachersWhitePercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersWhitePercent(Wrap<BigDecimal> c);

	public BigDecimal getTeachersWhitePercent() {
		return teachersWhitePercent;
	}

	public void setTeachersWhitePercent(BigDecimal teachersWhitePercent) {
		this.teachersWhitePercent = teachersWhitePercent;
		this.teachersWhitePercentWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersWhitePercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.teachersWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersWhitePercent(Double o) {
			this.teachersWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersWhitePercent(Integer o) {
			this.teachersWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersWhitePercentInit() {
		if(!teachersWhitePercentWrap.alreadyInitialized) {
			_teachersWhitePercent(teachersWhitePercentWrap);
			if(teachersWhitePercent == null)
				setTeachersWhitePercent(teachersWhitePercentWrap.o);
		}
		teachersWhitePercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrTeachersWhitePercent() {
		return teachersWhitePercent == null ? null : teachersWhitePercent.doubleValue();
	}

	public String strTeachersWhitePercent() {
		return teachersWhitePercent == null ? "" : teachersWhitePercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonTeachersWhitePercent() {
		return teachersWhitePercent == null ? "" : teachersWhitePercent.toString();
	}

	public String nomAffichageTeachersWhitePercent() {
		return "White teachers percent";
	}

	public String htmTooltipTeachersWhitePercent() {
		return null;
	}

	public String htmTeachersWhitePercent() {
		return teachersWhitePercent == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersWhitePercent());
	}

	public void inputTeachersWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmTeachersWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("White teachers percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "TeachersWhitePercent ").f().sx(strTeachersWhitePercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// teachersBlackTotal //
	////////////////////////

	/**	 The entity teachersBlackTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersBlackTotal;
	@JsonIgnore
	public Wrap<Long> teachersBlackTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersBlackTotal").o(teachersBlackTotal);

	/**	<br/> The entity teachersBlackTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersBlackTotal">Find the entity teachersBlackTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersBlackTotal(Wrap<Long> c);

	public Long getTeachersBlackTotal() {
		return teachersBlackTotal;
	}

	public void setTeachersBlackTotal(Long teachersBlackTotal) {
		this.teachersBlackTotal = teachersBlackTotal;
		this.teachersBlackTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersBlackTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersBlackTotal = Long.parseLong(o);
		this.teachersBlackTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersBlackTotalInit() {
		if(!teachersBlackTotalWrap.alreadyInitialized) {
			_teachersBlackTotal(teachersBlackTotalWrap);
			if(teachersBlackTotal == null)
				setTeachersBlackTotal(teachersBlackTotalWrap.o);
		}
		teachersBlackTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersBlackTotal() {
		return teachersBlackTotal;
	}

	public String strTeachersBlackTotal() {
		return teachersBlackTotal == null ? "" : teachersBlackTotal.toString();
	}

	public String jsonTeachersBlackTotal() {
		return teachersBlackTotal == null ? "" : teachersBlackTotal.toString();
	}

	public String nomAffichageTeachersBlackTotal() {
		return "Black teachers";
	}

	public String htmTooltipTeachersBlackTotal() {
		return null;
	}

	public String htmTeachersBlackTotal() {
		return teachersBlackTotal == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersBlackTotal());
	}

	public void inputTeachersBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Black teachers")
				.a("id", classApiMethodMethod, "_teachersBlackTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setTeachersBlackTotal classReportCard inputReportCard", pk, "TeachersBlackTotal w3-input w3-border ");
					a("name", "setTeachersBlackTotal");
				} else {
					a("class", "valueTeachersBlackTotal w3-input w3-border classReportCard inputReportCard", pk, "TeachersBlackTotal w3-input w3-border ");
					a("name", "teachersBlackTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setTeachersBlackTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_teachersBlackTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersBlackTotal')); }); ");
				}
				a("value", strTeachersBlackTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "TeachersBlackTotal ").f().sx(htmTeachersBlackTotal()).g("span");
		}
	}

	public void htmTeachersBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardTeachersBlackTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_teachersBlackTotal").a("class", "").f().sx("Black teachers").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTeachersBlackTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_teachersBlackTotal')); $('#", classApiMethodMethod, "_teachersBlackTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setTeachersBlackTotal', null, function() { addGlow($('#", classApiMethodMethod, "_teachersBlackTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersBlackTotal')); }); ")
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

	//////////////////////////
	// teachersBlackPercent //
	//////////////////////////

	/**	 The entity teachersBlackPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal teachersBlackPercent;
	@JsonIgnore
	public Wrap<BigDecimal> teachersBlackPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("teachersBlackPercent").o(teachersBlackPercent);

	/**	<br/> The entity teachersBlackPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersBlackPercent">Find the entity teachersBlackPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersBlackPercent(Wrap<BigDecimal> c);

	public BigDecimal getTeachersBlackPercent() {
		return teachersBlackPercent;
	}

	public void setTeachersBlackPercent(BigDecimal teachersBlackPercent) {
		this.teachersBlackPercent = teachersBlackPercent;
		this.teachersBlackPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersBlackPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.teachersBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersBlackPercent(Double o) {
			this.teachersBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersBlackPercent(Integer o) {
			this.teachersBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersBlackPercentInit() {
		if(!teachersBlackPercentWrap.alreadyInitialized) {
			_teachersBlackPercent(teachersBlackPercentWrap);
			if(teachersBlackPercent == null)
				setTeachersBlackPercent(teachersBlackPercentWrap.o);
		}
		teachersBlackPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrTeachersBlackPercent() {
		return teachersBlackPercent == null ? null : teachersBlackPercent.doubleValue();
	}

	public String strTeachersBlackPercent() {
		return teachersBlackPercent == null ? "" : teachersBlackPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonTeachersBlackPercent() {
		return teachersBlackPercent == null ? "" : teachersBlackPercent.toString();
	}

	public String nomAffichageTeachersBlackPercent() {
		return "Black teachers percent";
	}

	public String htmTooltipTeachersBlackPercent() {
		return null;
	}

	public String htmTeachersBlackPercent() {
		return teachersBlackPercent == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersBlackPercent());
	}

	public void inputTeachersBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmTeachersBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Black teachers percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "TeachersBlackPercent ").f().sx(strTeachersBlackPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////
	// teachersOtherTotal //
	////////////////////////

	/**	 The entity teachersOtherTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long teachersOtherTotal;
	@JsonIgnore
	public Wrap<Long> teachersOtherTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("teachersOtherTotal").o(teachersOtherTotal);

	/**	<br/> The entity teachersOtherTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersOtherTotal">Find the entity teachersOtherTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersOtherTotal(Wrap<Long> c);

	public Long getTeachersOtherTotal() {
		return teachersOtherTotal;
	}

	public void setTeachersOtherTotal(Long teachersOtherTotal) {
		this.teachersOtherTotal = teachersOtherTotal;
		this.teachersOtherTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersOtherTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.teachersOtherTotal = Long.parseLong(o);
		this.teachersOtherTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersOtherTotalInit() {
		if(!teachersOtherTotalWrap.alreadyInitialized) {
			_teachersOtherTotal(teachersOtherTotalWrap);
			if(teachersOtherTotal == null)
				setTeachersOtherTotal(teachersOtherTotalWrap.o);
		}
		teachersOtherTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrTeachersOtherTotal() {
		return teachersOtherTotal;
	}

	public String strTeachersOtherTotal() {
		return teachersOtherTotal == null ? "" : teachersOtherTotal.toString();
	}

	public String jsonTeachersOtherTotal() {
		return teachersOtherTotal == null ? "" : teachersOtherTotal.toString();
	}

	public String nomAffichageTeachersOtherTotal() {
		return "Other teachers";
	}

	public String htmTooltipTeachersOtherTotal() {
		return null;
	}

	public String htmTeachersOtherTotal() {
		return teachersOtherTotal == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersOtherTotal());
	}

	public void inputTeachersOtherTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Other teachers")
				.a("id", classApiMethodMethod, "_teachersOtherTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setTeachersOtherTotal classReportCard inputReportCard", pk, "TeachersOtherTotal w3-input w3-border ");
					a("name", "setTeachersOtherTotal");
				} else {
					a("class", "valueTeachersOtherTotal w3-input w3-border classReportCard inputReportCard", pk, "TeachersOtherTotal w3-input w3-border ");
					a("name", "teachersOtherTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setTeachersOtherTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_teachersOtherTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersOtherTotal')); }); ");
				}
				a("value", strTeachersOtherTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "TeachersOtherTotal ").f().sx(htmTeachersOtherTotal()).g("span");
		}
	}

	public void htmTeachersOtherTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardTeachersOtherTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_teachersOtherTotal").a("class", "").f().sx("Other teachers").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputTeachersOtherTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_teachersOtherTotal')); $('#", classApiMethodMethod, "_teachersOtherTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setTeachersOtherTotal', null, function() { addGlow($('#", classApiMethodMethod, "_teachersOtherTotal')); }, function() { addError($('#", classApiMethodMethod, "_teachersOtherTotal')); }); ")
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

	//////////////////////////
	// teachersOtherPercent //
	//////////////////////////

	/**	 The entity teachersOtherPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal teachersOtherPercent;
	@JsonIgnore
	public Wrap<BigDecimal> teachersOtherPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("teachersOtherPercent").o(teachersOtherPercent);

	/**	<br/> The entity teachersOtherPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:teachersOtherPercent">Find the entity teachersOtherPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _teachersOtherPercent(Wrap<BigDecimal> c);

	public BigDecimal getTeachersOtherPercent() {
		return teachersOtherPercent;
	}

	public void setTeachersOtherPercent(BigDecimal teachersOtherPercent) {
		this.teachersOtherPercent = teachersOtherPercent;
		this.teachersOtherPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setTeachersOtherPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.teachersOtherPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersOtherPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersOtherPercent(Double o) {
			this.teachersOtherPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersOtherPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setTeachersOtherPercent(Integer o) {
			this.teachersOtherPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.teachersOtherPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard teachersOtherPercentInit() {
		if(!teachersOtherPercentWrap.alreadyInitialized) {
			_teachersOtherPercent(teachersOtherPercentWrap);
			if(teachersOtherPercent == null)
				setTeachersOtherPercent(teachersOtherPercentWrap.o);
		}
		teachersOtherPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrTeachersOtherPercent() {
		return teachersOtherPercent == null ? null : teachersOtherPercent.doubleValue();
	}

	public String strTeachersOtherPercent() {
		return teachersOtherPercent == null ? "" : teachersOtherPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonTeachersOtherPercent() {
		return teachersOtherPercent == null ? "" : teachersOtherPercent.toString();
	}

	public String nomAffichageTeachersOtherPercent() {
		return "Others percent";
	}

	public String htmTooltipTeachersOtherPercent() {
		return null;
	}

	public String htmTeachersOtherPercent() {
		return teachersOtherPercent == null ? "" : StringEscapeUtils.escapeHtml4(strTeachersOtherPercent());
	}

	public void inputTeachersOtherPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmTeachersOtherPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Others percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "TeachersOtherPercent ").f().sx(strTeachersOtherPercent()).g("span");
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
	protected Long delinquentComplaintsTotal;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsTotal").o(delinquentComplaintsTotal);

	/**	<br/> The entity delinquentComplaintsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsTotal">Find the entity delinquentComplaintsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsTotal(Wrap<Long> c);

	public Long getDelinquentComplaintsTotal() {
		return delinquentComplaintsTotal;
	}

	public void setDelinquentComplaintsTotal(Long delinquentComplaintsTotal) {
		this.delinquentComplaintsTotal = delinquentComplaintsTotal;
		this.delinquentComplaintsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsTotal = Long.parseLong(o);
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

	public Long solrDelinquentComplaintsTotal() {
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
	protected Long delinquentComplaintsAtSchool;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsAtSchoolWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsAtSchool").o(delinquentComplaintsAtSchool);

	/**	<br/> The entity delinquentComplaintsAtSchool
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsAtSchool">Find the entity delinquentComplaintsAtSchool in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsAtSchool(Wrap<Long> c);

	public Long getDelinquentComplaintsAtSchool() {
		return delinquentComplaintsAtSchool;
	}

	public void setDelinquentComplaintsAtSchool(Long delinquentComplaintsAtSchool) {
		this.delinquentComplaintsAtSchool = delinquentComplaintsAtSchool;
		this.delinquentComplaintsAtSchoolWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsAtSchool(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsAtSchool = Long.parseLong(o);
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

	public Long solrDelinquentComplaintsAtSchool() {
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

	///////////////////////////////
	// delinquentComplaintsAsian //
	///////////////////////////////

	/**	 The entity delinquentComplaintsAsian
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsAsian;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsAsianWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsAsian").o(delinquentComplaintsAsian);

	/**	<br/> The entity delinquentComplaintsAsian
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsAsian">Find the entity delinquentComplaintsAsian in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsAsian(Wrap<Long> c);

	public Long getDelinquentComplaintsAsian() {
		return delinquentComplaintsAsian;
	}

	public void setDelinquentComplaintsAsian(Long delinquentComplaintsAsian) {
		this.delinquentComplaintsAsian = delinquentComplaintsAsian;
		this.delinquentComplaintsAsianWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsAsian(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsAsian = Long.parseLong(o);
		this.delinquentComplaintsAsianWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsAsianInit() {
		if(!delinquentComplaintsAsianWrap.alreadyInitialized) {
			_delinquentComplaintsAsian(delinquentComplaintsAsianWrap);
			if(delinquentComplaintsAsian == null)
				setDelinquentComplaintsAsian(delinquentComplaintsAsianWrap.o);
		}
		delinquentComplaintsAsianWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsAsian() {
		return delinquentComplaintsAsian;
	}

	public String strDelinquentComplaintsAsian() {
		return delinquentComplaintsAsian == null ? "" : delinquentComplaintsAsian.toString();
	}

	public String jsonDelinquentComplaintsAsian() {
		return delinquentComplaintsAsian == null ? "" : delinquentComplaintsAsian.toString();
	}

	public String nomAffichageDelinquentComplaintsAsian() {
		return "Asian complaints";
	}

	public String htmTooltipDelinquentComplaintsAsian() {
		return null;
	}

	public String htmDelinquentComplaintsAsian() {
		return delinquentComplaintsAsian == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsAsian());
	}

	public void inputDelinquentComplaintsAsian(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Asian complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsAsian");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsAsian classReportCard inputReportCard", pk, "DelinquentComplaintsAsian w3-input w3-border ");
					a("name", "setDelinquentComplaintsAsian");
				} else {
					a("class", "valueDelinquentComplaintsAsian w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsAsian w3-input w3-border ");
					a("name", "delinquentComplaintsAsian");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsAsian', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsAsian')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsAsian')); }); ");
				}
				a("value", strDelinquentComplaintsAsian())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsAsian ").f().sx(htmDelinquentComplaintsAsian()).g("span");
		}
	}

	public void htmDelinquentComplaintsAsian(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsAsian").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsAsian").a("class", "").f().sx("Asian complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsAsian(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsAsian')); $('#", classApiMethodMethod, "_delinquentComplaintsAsian').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsAsian', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsAsian')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsAsian')); }); ")
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

	//////////////////////////////////////
	// delinquentComplaintsAsianPercent //
	//////////////////////////////////////

	/**	 The entity delinquentComplaintsAsianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsAsianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsAsianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsAsianPercent").o(delinquentComplaintsAsianPercent);

	/**	<br/> The entity delinquentComplaintsAsianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsAsianPercent">Find the entity delinquentComplaintsAsianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsAsianPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent;
	}

	public void setDelinquentComplaintsAsianPercent(BigDecimal delinquentComplaintsAsianPercent) {
		this.delinquentComplaintsAsianPercent = delinquentComplaintsAsianPercent;
		this.delinquentComplaintsAsianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsAsianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsAsianPercent(Double o) {
			this.delinquentComplaintsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsAsianPercent(Integer o) {
			this.delinquentComplaintsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsAsianPercentInit() {
		if(!delinquentComplaintsAsianPercentWrap.alreadyInitialized) {
			_delinquentComplaintsAsianPercent(delinquentComplaintsAsianPercentWrap);
			if(delinquentComplaintsAsianPercent == null)
				setDelinquentComplaintsAsianPercent(delinquentComplaintsAsianPercentWrap.o);
		}
		delinquentComplaintsAsianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent == null ? null : delinquentComplaintsAsianPercent.doubleValue();
	}

	public String strDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent == null ? "" : delinquentComplaintsAsianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent == null ? "" : delinquentComplaintsAsianPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsAsianPercent() {
		return "Asian complaints percent";
	}

	public String htmTooltipDelinquentComplaintsAsianPercent() {
		return null;
	}

	public String htmDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsAsianPercent());
	}

	public void inputDelinquentComplaintsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Asian complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsAsianPercent ").f().sx(strDelinquentComplaintsAsianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////
	// delinquentComplaintsBlack //
	///////////////////////////////

	/**	 The entity delinquentComplaintsBlack
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsBlack;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsBlackWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsBlack").o(delinquentComplaintsBlack);

	/**	<br/> The entity delinquentComplaintsBlack
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsBlack">Find the entity delinquentComplaintsBlack in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsBlack(Wrap<Long> c);

	public Long getDelinquentComplaintsBlack() {
		return delinquentComplaintsBlack;
	}

	public void setDelinquentComplaintsBlack(Long delinquentComplaintsBlack) {
		this.delinquentComplaintsBlack = delinquentComplaintsBlack;
		this.delinquentComplaintsBlackWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsBlack(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsBlack = Long.parseLong(o);
		this.delinquentComplaintsBlackWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsBlackInit() {
		if(!delinquentComplaintsBlackWrap.alreadyInitialized) {
			_delinquentComplaintsBlack(delinquentComplaintsBlackWrap);
			if(delinquentComplaintsBlack == null)
				setDelinquentComplaintsBlack(delinquentComplaintsBlackWrap.o);
		}
		delinquentComplaintsBlackWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsBlack() {
		return delinquentComplaintsBlack;
	}

	public String strDelinquentComplaintsBlack() {
		return delinquentComplaintsBlack == null ? "" : delinquentComplaintsBlack.toString();
	}

	public String jsonDelinquentComplaintsBlack() {
		return delinquentComplaintsBlack == null ? "" : delinquentComplaintsBlack.toString();
	}

	public String nomAffichageDelinquentComplaintsBlack() {
		return "Black complaints";
	}

	public String htmTooltipDelinquentComplaintsBlack() {
		return null;
	}

	public String htmDelinquentComplaintsBlack() {
		return delinquentComplaintsBlack == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsBlack());
	}

	public void inputDelinquentComplaintsBlack(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Black complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsBlack");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsBlack classReportCard inputReportCard", pk, "DelinquentComplaintsBlack w3-input w3-border ");
					a("name", "setDelinquentComplaintsBlack");
				} else {
					a("class", "valueDelinquentComplaintsBlack w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsBlack w3-input w3-border ");
					a("name", "delinquentComplaintsBlack");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsBlack', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsBlack')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsBlack')); }); ");
				}
				a("value", strDelinquentComplaintsBlack())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsBlack ").f().sx(htmDelinquentComplaintsBlack()).g("span");
		}
	}

	public void htmDelinquentComplaintsBlack(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsBlack").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsBlack").a("class", "").f().sx("Black complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsBlack(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsBlack')); $('#", classApiMethodMethod, "_delinquentComplaintsBlack').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsBlack', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsBlack')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsBlack')); }); ")
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

	//////////////////////////////////////
	// delinquentComplaintsBlackPercent //
	//////////////////////////////////////

	/**	 The entity delinquentComplaintsBlackPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsBlackPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsBlackPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsBlackPercent").o(delinquentComplaintsBlackPercent);

	/**	<br/> The entity delinquentComplaintsBlackPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsBlackPercent">Find the entity delinquentComplaintsBlackPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsBlackPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent;
	}

	public void setDelinquentComplaintsBlackPercent(BigDecimal delinquentComplaintsBlackPercent) {
		this.delinquentComplaintsBlackPercent = delinquentComplaintsBlackPercent;
		this.delinquentComplaintsBlackPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsBlackPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsBlackPercent(Double o) {
			this.delinquentComplaintsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsBlackPercent(Integer o) {
			this.delinquentComplaintsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsBlackPercentInit() {
		if(!delinquentComplaintsBlackPercentWrap.alreadyInitialized) {
			_delinquentComplaintsBlackPercent(delinquentComplaintsBlackPercentWrap);
			if(delinquentComplaintsBlackPercent == null)
				setDelinquentComplaintsBlackPercent(delinquentComplaintsBlackPercentWrap.o);
		}
		delinquentComplaintsBlackPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent == null ? null : delinquentComplaintsBlackPercent.doubleValue();
	}

	public String strDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent == null ? "" : delinquentComplaintsBlackPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent == null ? "" : delinquentComplaintsBlackPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsBlackPercent() {
		return "Black complaints percent";
	}

	public String htmTooltipDelinquentComplaintsBlackPercent() {
		return null;
	}

	public String htmDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsBlackPercent());
	}

	public void inputDelinquentComplaintsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Black complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsBlackPercent ").f().sx(strDelinquentComplaintsBlackPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////
	// delinquentComplaintsHispanic //
	//////////////////////////////////

	/**	 The entity delinquentComplaintsHispanic
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsHispanic;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsHispanicWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsHispanic").o(delinquentComplaintsHispanic);

	/**	<br/> The entity delinquentComplaintsHispanic
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsHispanic">Find the entity delinquentComplaintsHispanic in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsHispanic(Wrap<Long> c);

	public Long getDelinquentComplaintsHispanic() {
		return delinquentComplaintsHispanic;
	}

	public void setDelinquentComplaintsHispanic(Long delinquentComplaintsHispanic) {
		this.delinquentComplaintsHispanic = delinquentComplaintsHispanic;
		this.delinquentComplaintsHispanicWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsHispanic(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsHispanic = Long.parseLong(o);
		this.delinquentComplaintsHispanicWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsHispanicInit() {
		if(!delinquentComplaintsHispanicWrap.alreadyInitialized) {
			_delinquentComplaintsHispanic(delinquentComplaintsHispanicWrap);
			if(delinquentComplaintsHispanic == null)
				setDelinquentComplaintsHispanic(delinquentComplaintsHispanicWrap.o);
		}
		delinquentComplaintsHispanicWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsHispanic() {
		return delinquentComplaintsHispanic;
	}

	public String strDelinquentComplaintsHispanic() {
		return delinquentComplaintsHispanic == null ? "" : delinquentComplaintsHispanic.toString();
	}

	public String jsonDelinquentComplaintsHispanic() {
		return delinquentComplaintsHispanic == null ? "" : delinquentComplaintsHispanic.toString();
	}

	public String nomAffichageDelinquentComplaintsHispanic() {
		return "Latinx complaints";
	}

	public String htmTooltipDelinquentComplaintsHispanic() {
		return null;
	}

	public String htmDelinquentComplaintsHispanic() {
		return delinquentComplaintsHispanic == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsHispanic());
	}

	public void inputDelinquentComplaintsHispanic(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Latinx complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsHispanic");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsHispanic classReportCard inputReportCard", pk, "DelinquentComplaintsHispanic w3-input w3-border ");
					a("name", "setDelinquentComplaintsHispanic");
				} else {
					a("class", "valueDelinquentComplaintsHispanic w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsHispanic w3-input w3-border ");
					a("name", "delinquentComplaintsHispanic");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsHispanic', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsHispanic')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsHispanic')); }); ");
				}
				a("value", strDelinquentComplaintsHispanic())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsHispanic ").f().sx(htmDelinquentComplaintsHispanic()).g("span");
		}
	}

	public void htmDelinquentComplaintsHispanic(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsHispanic").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsHispanic").a("class", "").f().sx("Latinx complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsHispanic(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsHispanic')); $('#", classApiMethodMethod, "_delinquentComplaintsHispanic').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsHispanic', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsHispanic')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsHispanic')); }); ")
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
	// delinquentComplaintsHispanicPercent //
	/////////////////////////////////////////

	/**	 The entity delinquentComplaintsHispanicPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsHispanicPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsHispanicPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsHispanicPercent").o(delinquentComplaintsHispanicPercent);

	/**	<br/> The entity delinquentComplaintsHispanicPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsHispanicPercent">Find the entity delinquentComplaintsHispanicPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsHispanicPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent;
	}

	public void setDelinquentComplaintsHispanicPercent(BigDecimal delinquentComplaintsHispanicPercent) {
		this.delinquentComplaintsHispanicPercent = delinquentComplaintsHispanicPercent;
		this.delinquentComplaintsHispanicPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsHispanicPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsHispanicPercent(Double o) {
			this.delinquentComplaintsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsHispanicPercent(Integer o) {
			this.delinquentComplaintsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsHispanicPercentInit() {
		if(!delinquentComplaintsHispanicPercentWrap.alreadyInitialized) {
			_delinquentComplaintsHispanicPercent(delinquentComplaintsHispanicPercentWrap);
			if(delinquentComplaintsHispanicPercent == null)
				setDelinquentComplaintsHispanicPercent(delinquentComplaintsHispanicPercentWrap.o);
		}
		delinquentComplaintsHispanicPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent == null ? null : delinquentComplaintsHispanicPercent.doubleValue();
	}

	public String strDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent == null ? "" : delinquentComplaintsHispanicPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent == null ? "" : delinquentComplaintsHispanicPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsHispanicPercent() {
		return "Latinx complaints percent";
	}

	public String htmTooltipDelinquentComplaintsHispanicPercent() {
		return null;
	}

	public String htmDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsHispanicPercent());
	}

	public void inputDelinquentComplaintsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Latinx complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsHispanicPercent ").f().sx(strDelinquentComplaintsHispanicPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////
	// delinquentComplaintsMultiRacial //
	/////////////////////////////////////

	/**	 The entity delinquentComplaintsMultiRacial
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsMultiRacial;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsMultiRacialWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsMultiRacial").o(delinquentComplaintsMultiRacial);

	/**	<br/> The entity delinquentComplaintsMultiRacial
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsMultiRacial">Find the entity delinquentComplaintsMultiRacial in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsMultiRacial(Wrap<Long> c);

	public Long getDelinquentComplaintsMultiRacial() {
		return delinquentComplaintsMultiRacial;
	}

	public void setDelinquentComplaintsMultiRacial(Long delinquentComplaintsMultiRacial) {
		this.delinquentComplaintsMultiRacial = delinquentComplaintsMultiRacial;
		this.delinquentComplaintsMultiRacialWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsMultiRacial(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsMultiRacial = Long.parseLong(o);
		this.delinquentComplaintsMultiRacialWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsMultiRacialInit() {
		if(!delinquentComplaintsMultiRacialWrap.alreadyInitialized) {
			_delinquentComplaintsMultiRacial(delinquentComplaintsMultiRacialWrap);
			if(delinquentComplaintsMultiRacial == null)
				setDelinquentComplaintsMultiRacial(delinquentComplaintsMultiRacialWrap.o);
		}
		delinquentComplaintsMultiRacialWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsMultiRacial() {
		return delinquentComplaintsMultiRacial;
	}

	public String strDelinquentComplaintsMultiRacial() {
		return delinquentComplaintsMultiRacial == null ? "" : delinquentComplaintsMultiRacial.toString();
	}

	public String jsonDelinquentComplaintsMultiRacial() {
		return delinquentComplaintsMultiRacial == null ? "" : delinquentComplaintsMultiRacial.toString();
	}

	public String nomAffichageDelinquentComplaintsMultiRacial() {
		return "Multi Racial complaints";
	}

	public String htmTooltipDelinquentComplaintsMultiRacial() {
		return null;
	}

	public String htmDelinquentComplaintsMultiRacial() {
		return delinquentComplaintsMultiRacial == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsMultiRacial());
	}

	public void inputDelinquentComplaintsMultiRacial(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Multi Racial complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsMultiRacial");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsMultiRacial classReportCard inputReportCard", pk, "DelinquentComplaintsMultiRacial w3-input w3-border ");
					a("name", "setDelinquentComplaintsMultiRacial");
				} else {
					a("class", "valueDelinquentComplaintsMultiRacial w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsMultiRacial w3-input w3-border ");
					a("name", "delinquentComplaintsMultiRacial");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsMultiRacial', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial')); }); ");
				}
				a("value", strDelinquentComplaintsMultiRacial())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsMultiRacial ").f().sx(htmDelinquentComplaintsMultiRacial()).g("span");
		}
	}

	public void htmDelinquentComplaintsMultiRacial(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsMultiRacial").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsMultiRacial").a("class", "").f().sx("Multi Racial complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsMultiRacial(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial')); $('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsMultiRacial', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsMultiRacial')); }); ")
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

	////////////////////////////////////////////
	// delinquentComplaintsMultiRacialPercent //
	////////////////////////////////////////////

	/**	 The entity delinquentComplaintsMultiRacialPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsMultiRacialPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsMultiRacialPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsMultiRacialPercent").o(delinquentComplaintsMultiRacialPercent);

	/**	<br/> The entity delinquentComplaintsMultiRacialPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsMultiRacialPercent">Find the entity delinquentComplaintsMultiRacialPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsMultiRacialPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent;
	}

	public void setDelinquentComplaintsMultiRacialPercent(BigDecimal delinquentComplaintsMultiRacialPercent) {
		this.delinquentComplaintsMultiRacialPercent = delinquentComplaintsMultiRacialPercent;
		this.delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsMultiRacialPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsMultiRacialPercent(Double o) {
			this.delinquentComplaintsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsMultiRacialPercent(Integer o) {
			this.delinquentComplaintsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsMultiRacialPercentInit() {
		if(!delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized) {
			_delinquentComplaintsMultiRacialPercent(delinquentComplaintsMultiRacialPercentWrap);
			if(delinquentComplaintsMultiRacialPercent == null)
				setDelinquentComplaintsMultiRacialPercent(delinquentComplaintsMultiRacialPercentWrap.o);
		}
		delinquentComplaintsMultiRacialPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent == null ? null : delinquentComplaintsMultiRacialPercent.doubleValue();
	}

	public String strDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent == null ? "" : delinquentComplaintsMultiRacialPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent == null ? "" : delinquentComplaintsMultiRacialPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsMultiRacialPercent() {
		return "Multi Racial complaints percent";
	}

	public String htmTooltipDelinquentComplaintsMultiRacialPercent() {
		return null;
	}

	public String htmDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsMultiRacialPercent());
	}

	public void inputDelinquentComplaintsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Multi Racial complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsMultiRacialPercent ").f().sx(strDelinquentComplaintsMultiRacialPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////////////
	// delinquentComplaintsIndian //
	////////////////////////////////

	/**	 The entity delinquentComplaintsIndian
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsIndian;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsIndianWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsIndian").o(delinquentComplaintsIndian);

	/**	<br/> The entity delinquentComplaintsIndian
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsIndian">Find the entity delinquentComplaintsIndian in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsIndian(Wrap<Long> c);

	public Long getDelinquentComplaintsIndian() {
		return delinquentComplaintsIndian;
	}

	public void setDelinquentComplaintsIndian(Long delinquentComplaintsIndian) {
		this.delinquentComplaintsIndian = delinquentComplaintsIndian;
		this.delinquentComplaintsIndianWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsIndian(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsIndian = Long.parseLong(o);
		this.delinquentComplaintsIndianWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsIndianInit() {
		if(!delinquentComplaintsIndianWrap.alreadyInitialized) {
			_delinquentComplaintsIndian(delinquentComplaintsIndianWrap);
			if(delinquentComplaintsIndian == null)
				setDelinquentComplaintsIndian(delinquentComplaintsIndianWrap.o);
		}
		delinquentComplaintsIndianWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsIndian() {
		return delinquentComplaintsIndian;
	}

	public String strDelinquentComplaintsIndian() {
		return delinquentComplaintsIndian == null ? "" : delinquentComplaintsIndian.toString();
	}

	public String jsonDelinquentComplaintsIndian() {
		return delinquentComplaintsIndian == null ? "" : delinquentComplaintsIndian.toString();
	}

	public String nomAffichageDelinquentComplaintsIndian() {
		return "First Nation complaints";
	}

	public String htmTooltipDelinquentComplaintsIndian() {
		return null;
	}

	public String htmDelinquentComplaintsIndian() {
		return delinquentComplaintsIndian == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsIndian());
	}

	public void inputDelinquentComplaintsIndian(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "First Nation complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsIndian");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsIndian classReportCard inputReportCard", pk, "DelinquentComplaintsIndian w3-input w3-border ");
					a("name", "setDelinquentComplaintsIndian");
				} else {
					a("class", "valueDelinquentComplaintsIndian w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsIndian w3-input w3-border ");
					a("name", "delinquentComplaintsIndian");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsIndian', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsIndian')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsIndian')); }); ");
				}
				a("value", strDelinquentComplaintsIndian())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsIndian ").f().sx(htmDelinquentComplaintsIndian()).g("span");
		}
	}

	public void htmDelinquentComplaintsIndian(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsIndian").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsIndian").a("class", "").f().sx("First Nation complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsIndian(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsIndian')); $('#", classApiMethodMethod, "_delinquentComplaintsIndian').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsIndian', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsIndian')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsIndian')); }); ")
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

	///////////////////////////////////////
	// delinquentComplaintsIndianPercent //
	///////////////////////////////////////

	/**	 The entity delinquentComplaintsIndianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsIndianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsIndianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsIndianPercent").o(delinquentComplaintsIndianPercent);

	/**	<br/> The entity delinquentComplaintsIndianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsIndianPercent">Find the entity delinquentComplaintsIndianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsIndianPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent;
	}

	public void setDelinquentComplaintsIndianPercent(BigDecimal delinquentComplaintsIndianPercent) {
		this.delinquentComplaintsIndianPercent = delinquentComplaintsIndianPercent;
		this.delinquentComplaintsIndianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsIndianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsIndianPercent(Double o) {
			this.delinquentComplaintsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsIndianPercent(Integer o) {
			this.delinquentComplaintsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsIndianPercentInit() {
		if(!delinquentComplaintsIndianPercentWrap.alreadyInitialized) {
			_delinquentComplaintsIndianPercent(delinquentComplaintsIndianPercentWrap);
			if(delinquentComplaintsIndianPercent == null)
				setDelinquentComplaintsIndianPercent(delinquentComplaintsIndianPercentWrap.o);
		}
		delinquentComplaintsIndianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent == null ? null : delinquentComplaintsIndianPercent.doubleValue();
	}

	public String strDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent == null ? "" : delinquentComplaintsIndianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent == null ? "" : delinquentComplaintsIndianPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsIndianPercent() {
		return "First Nation complaints percent";
	}

	public String htmTooltipDelinquentComplaintsIndianPercent() {
		return null;
	}

	public String htmDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsIndianPercent());
	}

	public void inputDelinquentComplaintsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("First Nation complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsIndianPercent ").f().sx(strDelinquentComplaintsIndianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////
	// delinquentComplaintsWhite //
	///////////////////////////////

	/**	 The entity delinquentComplaintsWhite
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsWhite;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsWhiteWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsWhite").o(delinquentComplaintsWhite);

	/**	<br/> The entity delinquentComplaintsWhite
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsWhite">Find the entity delinquentComplaintsWhite in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsWhite(Wrap<Long> c);

	public Long getDelinquentComplaintsWhite() {
		return delinquentComplaintsWhite;
	}

	public void setDelinquentComplaintsWhite(Long delinquentComplaintsWhite) {
		this.delinquentComplaintsWhite = delinquentComplaintsWhite;
		this.delinquentComplaintsWhiteWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsWhite(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsWhite = Long.parseLong(o);
		this.delinquentComplaintsWhiteWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsWhiteInit() {
		if(!delinquentComplaintsWhiteWrap.alreadyInitialized) {
			_delinquentComplaintsWhite(delinquentComplaintsWhiteWrap);
			if(delinquentComplaintsWhite == null)
				setDelinquentComplaintsWhite(delinquentComplaintsWhiteWrap.o);
		}
		delinquentComplaintsWhiteWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsWhite() {
		return delinquentComplaintsWhite;
	}

	public String strDelinquentComplaintsWhite() {
		return delinquentComplaintsWhite == null ? "" : delinquentComplaintsWhite.toString();
	}

	public String jsonDelinquentComplaintsWhite() {
		return delinquentComplaintsWhite == null ? "" : delinquentComplaintsWhite.toString();
	}

	public String nomAffichageDelinquentComplaintsWhite() {
		return "White complaints";
	}

	public String htmTooltipDelinquentComplaintsWhite() {
		return null;
	}

	public String htmDelinquentComplaintsWhite() {
		return delinquentComplaintsWhite == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsWhite());
	}

	public void inputDelinquentComplaintsWhite(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "White complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsWhite");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsWhite classReportCard inputReportCard", pk, "DelinquentComplaintsWhite w3-input w3-border ");
					a("name", "setDelinquentComplaintsWhite");
				} else {
					a("class", "valueDelinquentComplaintsWhite w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsWhite w3-input w3-border ");
					a("name", "delinquentComplaintsWhite");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsWhite', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsWhite')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsWhite')); }); ");
				}
				a("value", strDelinquentComplaintsWhite())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsWhite ").f().sx(htmDelinquentComplaintsWhite()).g("span");
		}
	}

	public void htmDelinquentComplaintsWhite(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsWhite").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsWhite").a("class", "").f().sx("White complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsWhite(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsWhite')); $('#", classApiMethodMethod, "_delinquentComplaintsWhite').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsWhite', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsWhite')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsWhite')); }); ")
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

	//////////////////////////////////////
	// delinquentComplaintsWhitePercent //
	//////////////////////////////////////

	/**	 The entity delinquentComplaintsWhitePercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsWhitePercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsWhitePercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsWhitePercent").o(delinquentComplaintsWhitePercent);

	/**	<br/> The entity delinquentComplaintsWhitePercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsWhitePercent">Find the entity delinquentComplaintsWhitePercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsWhitePercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent;
	}

	public void setDelinquentComplaintsWhitePercent(BigDecimal delinquentComplaintsWhitePercent) {
		this.delinquentComplaintsWhitePercent = delinquentComplaintsWhitePercent;
		this.delinquentComplaintsWhitePercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsWhitePercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsWhitePercent(Double o) {
			this.delinquentComplaintsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsWhitePercent(Integer o) {
			this.delinquentComplaintsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsWhitePercentInit() {
		if(!delinquentComplaintsWhitePercentWrap.alreadyInitialized) {
			_delinquentComplaintsWhitePercent(delinquentComplaintsWhitePercentWrap);
			if(delinquentComplaintsWhitePercent == null)
				setDelinquentComplaintsWhitePercent(delinquentComplaintsWhitePercentWrap.o);
		}
		delinquentComplaintsWhitePercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent == null ? null : delinquentComplaintsWhitePercent.doubleValue();
	}

	public String strDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent == null ? "" : delinquentComplaintsWhitePercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent == null ? "" : delinquentComplaintsWhitePercent.toString();
	}

	public String nomAffichageDelinquentComplaintsWhitePercent() {
		return "White complaints percent";
	}

	public String htmTooltipDelinquentComplaintsWhitePercent() {
		return null;
	}

	public String htmDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsWhitePercent());
	}

	public void inputDelinquentComplaintsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("White complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsWhitePercent ").f().sx(strDelinquentComplaintsWhitePercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////////
	// delinquentComplaintsPacificIslander //
	/////////////////////////////////////////

	/**	 The entity delinquentComplaintsPacificIslander
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long delinquentComplaintsPacificIslander;
	@JsonIgnore
	public Wrap<Long> delinquentComplaintsPacificIslanderWrap = new Wrap<Long>().p(this).c(Long.class).var("delinquentComplaintsPacificIslander").o(delinquentComplaintsPacificIslander);

	/**	<br/> The entity delinquentComplaintsPacificIslander
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsPacificIslander">Find the entity delinquentComplaintsPacificIslander in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsPacificIslander(Wrap<Long> c);

	public Long getDelinquentComplaintsPacificIslander() {
		return delinquentComplaintsPacificIslander;
	}

	public void setDelinquentComplaintsPacificIslander(Long delinquentComplaintsPacificIslander) {
		this.delinquentComplaintsPacificIslander = delinquentComplaintsPacificIslander;
		this.delinquentComplaintsPacificIslanderWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsPacificIslander(String o) {
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsPacificIslander = Long.parseLong(o);
		this.delinquentComplaintsPacificIslanderWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsPacificIslanderInit() {
		if(!delinquentComplaintsPacificIslanderWrap.alreadyInitialized) {
			_delinquentComplaintsPacificIslander(delinquentComplaintsPacificIslanderWrap);
			if(delinquentComplaintsPacificIslander == null)
				setDelinquentComplaintsPacificIslander(delinquentComplaintsPacificIslanderWrap.o);
		}
		delinquentComplaintsPacificIslanderWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrDelinquentComplaintsPacificIslander() {
		return delinquentComplaintsPacificIslander;
	}

	public String strDelinquentComplaintsPacificIslander() {
		return delinquentComplaintsPacificIslander == null ? "" : delinquentComplaintsPacificIslander.toString();
	}

	public String jsonDelinquentComplaintsPacificIslander() {
		return delinquentComplaintsPacificIslander == null ? "" : delinquentComplaintsPacificIslander.toString();
	}

	public String nomAffichageDelinquentComplaintsPacificIslander() {
		return "Pacific Islander complaints";
	}

	public String htmTooltipDelinquentComplaintsPacificIslander() {
		return null;
	}

	public String htmDelinquentComplaintsPacificIslander() {
		return delinquentComplaintsPacificIslander == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsPacificIslander());
	}

	public void inputDelinquentComplaintsPacificIslander(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "Pacific Islander complaints")
				.a("id", classApiMethodMethod, "_delinquentComplaintsPacificIslander");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setDelinquentComplaintsPacificIslander classReportCard inputReportCard", pk, "DelinquentComplaintsPacificIslander w3-input w3-border ");
					a("name", "setDelinquentComplaintsPacificIslander");
				} else {
					a("class", "valueDelinquentComplaintsPacificIslander w3-input w3-border classReportCard inputReportCard", pk, "DelinquentComplaintsPacificIslander w3-input w3-border ");
					a("name", "delinquentComplaintsPacificIslander");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setDelinquentComplaintsPacificIslander', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander')); }); ");
				}
				a("value", strDelinquentComplaintsPacificIslander())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "DelinquentComplaintsPacificIslander ").f().sx(htmDelinquentComplaintsPacificIslander()).g("span");
		}
	}

	public void htmDelinquentComplaintsPacificIslander(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardDelinquentComplaintsPacificIslander").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_delinquentComplaintsPacificIslander").a("class", "").f().sx("Pacific Islander complaints").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputDelinquentComplaintsPacificIslander(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander')); $('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setDelinquentComplaintsPacificIslander', null, function() { addGlow($('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander')); }, function() { addError($('#", classApiMethodMethod, "_delinquentComplaintsPacificIslander')); }); ")
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

	////////////////////////////////////////////////
	// delinquentComplaintsPacificIslanderPercent //
	////////////////////////////////////////////////

	/**	 The entity delinquentComplaintsPacificIslanderPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal delinquentComplaintsPacificIslanderPercent;
	@JsonIgnore
	public Wrap<BigDecimal> delinquentComplaintsPacificIslanderPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("delinquentComplaintsPacificIslanderPercent").o(delinquentComplaintsPacificIslanderPercent);

	/**	<br/> The entity delinquentComplaintsPacificIslanderPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:delinquentComplaintsPacificIslanderPercent">Find the entity delinquentComplaintsPacificIslanderPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _delinquentComplaintsPacificIslanderPercent(Wrap<BigDecimal> c);

	public BigDecimal getDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent;
	}

	public void setDelinquentComplaintsPacificIslanderPercent(BigDecimal delinquentComplaintsPacificIslanderPercent) {
		this.delinquentComplaintsPacificIslanderPercent = delinquentComplaintsPacificIslanderPercent;
		this.delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setDelinquentComplaintsPacificIslanderPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.delinquentComplaintsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsPacificIslanderPercent(Double o) {
			this.delinquentComplaintsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setDelinquentComplaintsPacificIslanderPercent(Integer o) {
			this.delinquentComplaintsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard delinquentComplaintsPacificIslanderPercentInit() {
		if(!delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized) {
			_delinquentComplaintsPacificIslanderPercent(delinquentComplaintsPacificIslanderPercentWrap);
			if(delinquentComplaintsPacificIslanderPercent == null)
				setDelinquentComplaintsPacificIslanderPercent(delinquentComplaintsPacificIslanderPercentWrap.o);
		}
		delinquentComplaintsPacificIslanderPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent == null ? null : delinquentComplaintsPacificIslanderPercent.doubleValue();
	}

	public String strDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent == null ? "" : delinquentComplaintsPacificIslanderPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent == null ? "" : delinquentComplaintsPacificIslanderPercent.toString();
	}

	public String nomAffichageDelinquentComplaintsPacificIslanderPercent() {
		return "Pacific Islander complaints percent";
	}

	public String htmTooltipDelinquentComplaintsPacificIslanderPercent() {
		return null;
	}

	public String htmDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent == null ? "" : StringEscapeUtils.escapeHtml4(strDelinquentComplaintsPacificIslanderPercent());
	}

	public void inputDelinquentComplaintsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmDelinquentComplaintsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("Pacific Islander complaints percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "DelinquentComplaintsPacificIslanderPercent ").f().sx(strDelinquentComplaintsPacificIslanderPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////
	// shortTermSuspensionRate //
	/////////////////////////////

	/**	 The entity shortTermSuspensionRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionRate;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionRateWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionRate").o(shortTermSuspensionRate);

	/**	<br/> The entity shortTermSuspensionRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionRate">Find the entity shortTermSuspensionRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionRate(Wrap<Long> c);

	public Long getShortTermSuspensionRate() {
		return shortTermSuspensionRate;
	}

	public void setShortTermSuspensionRate(Long shortTermSuspensionRate) {
		this.shortTermSuspensionRate = shortTermSuspensionRate;
		this.shortTermSuspensionRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionRate(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionRate = Long.parseLong(o);
		this.shortTermSuspensionRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionRateInit() {
		if(!shortTermSuspensionRateWrap.alreadyInitialized) {
			_shortTermSuspensionRate(shortTermSuspensionRateWrap);
			if(shortTermSuspensionRate == null)
				setShortTermSuspensionRate(shortTermSuspensionRateWrap.o);
		}
		shortTermSuspensionRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionRate() {
		return shortTermSuspensionRate;
	}

	public String strShortTermSuspensionRate() {
		return shortTermSuspensionRate == null ? "" : shortTermSuspensionRate.toString();
	}

	public String jsonShortTermSuspensionRate() {
		return shortTermSuspensionRate == null ? "" : shortTermSuspensionRate.toString();
	}

	public String nomAffichageShortTermSuspensionRate() {
		return "short-term suspension rate";
	}

	public String htmTooltipShortTermSuspensionRate() {
		return null;
	}

	public String htmShortTermSuspensionRate() {
		return shortTermSuspensionRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionRate());
	}

	public void inputShortTermSuspensionRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspension rate")
				.a("id", classApiMethodMethod, "_shortTermSuspensionRate");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionRate classReportCard inputReportCard", pk, "ShortTermSuspensionRate w3-input w3-border ");
					a("name", "setShortTermSuspensionRate");
				} else {
					a("class", "valueShortTermSuspensionRate w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionRate w3-input w3-border ");
					a("name", "shortTermSuspensionRate");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionRate', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionRate')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionRate')); }); ");
				}
				a("value", strShortTermSuspensionRate())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionRate ").f().sx(htmShortTermSuspensionRate()).g("span");
		}
	}

	public void htmShortTermSuspensionRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionRate").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionRate").a("class", "").f().sx("short-term suspension rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionRate(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionRate')); $('#", classApiMethodMethod, "_shortTermSuspensionRate').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionRate', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionRate')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionRate')); }); ")
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
	// shortTermSuspensionsTotal //
	///////////////////////////////

	/**	 The entity shortTermSuspensionsTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsTotal").o(shortTermSuspensionsTotal);

	/**	<br/> The entity shortTermSuspensionsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsTotal">Find the entity shortTermSuspensionsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal;
	}

	public void setShortTermSuspensionsTotal(Long shortTermSuspensionsTotal) {
		this.shortTermSuspensionsTotal = shortTermSuspensionsTotal;
		this.shortTermSuspensionsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsTotal = Long.parseLong(o);
		this.shortTermSuspensionsTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsTotalInit() {
		if(!shortTermSuspensionsTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsTotal(shortTermSuspensionsTotalWrap);
			if(shortTermSuspensionsTotal == null)
				setShortTermSuspensionsTotal(shortTermSuspensionsTotalWrap.o);
		}
		shortTermSuspensionsTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal;
	}

	public String strShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal == null ? "" : shortTermSuspensionsTotal.toString();
	}

	public String jsonShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal == null ? "" : shortTermSuspensionsTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsTotal() {
		return "short-term suspensions total";
	}

	public String htmTooltipShortTermSuspensionsTotal() {
		return null;
	}

	public String htmShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsTotal());
	}

	public void inputShortTermSuspensionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions total")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsTotal classReportCard inputReportCard", pk, "ShortTermSuspensionsTotal w3-input w3-border ");
					a("name", "setShortTermSuspensionsTotal");
				} else {
					a("class", "valueShortTermSuspensionsTotal w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsTotal w3-input w3-border ");
					a("name", "shortTermSuspensionsTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsTotal')); }); ");
				}
				a("value", strShortTermSuspensionsTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsTotal ").f().sx(htmShortTermSuspensionsTotal()).g("span");
		}
	}

	public void htmShortTermSuspensionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsTotal").a("class", "").f().sx("short-term suspensions total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsTotal')); $('#", classApiMethodMethod, "_shortTermSuspensionsTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsTotal', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsTotal')); }); ")
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

	//////////////////////////////
	// longTermSuspensionsTotal //
	//////////////////////////////

	/**	 The entity longTermSuspensionsTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long longTermSuspensionsTotal;
	@JsonIgnore
	public Wrap<Long> longTermSuspensionsTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("longTermSuspensionsTotal").o(longTermSuspensionsTotal);

	/**	<br/> The entity longTermSuspensionsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:longTermSuspensionsTotal">Find the entity longTermSuspensionsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _longTermSuspensionsTotal(Wrap<Long> c);

	public Long getLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal;
	}

	public void setLongTermSuspensionsTotal(Long longTermSuspensionsTotal) {
		this.longTermSuspensionsTotal = longTermSuspensionsTotal;
		this.longTermSuspensionsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setLongTermSuspensionsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.longTermSuspensionsTotal = Long.parseLong(o);
		this.longTermSuspensionsTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard longTermSuspensionsTotalInit() {
		if(!longTermSuspensionsTotalWrap.alreadyInitialized) {
			_longTermSuspensionsTotal(longTermSuspensionsTotalWrap);
			if(longTermSuspensionsTotal == null)
				setLongTermSuspensionsTotal(longTermSuspensionsTotalWrap.o);
		}
		longTermSuspensionsTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal;
	}

	public String strLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal == null ? "" : longTermSuspensionsTotal.toString();
	}

	public String jsonLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal == null ? "" : longTermSuspensionsTotal.toString();
	}

	public String nomAffichageLongTermSuspensionsTotal() {
		return "long-term suspensions total";
	}

	public String htmTooltipLongTermSuspensionsTotal() {
		return null;
	}

	public String htmLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal == null ? "" : StringEscapeUtils.escapeHtml4(strLongTermSuspensionsTotal());
	}

	public void inputLongTermSuspensionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "long-term suspensions total")
				.a("id", classApiMethodMethod, "_longTermSuspensionsTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setLongTermSuspensionsTotal classReportCard inputReportCard", pk, "LongTermSuspensionsTotal w3-input w3-border ");
					a("name", "setLongTermSuspensionsTotal");
				} else {
					a("class", "valueLongTermSuspensionsTotal w3-input w3-border classReportCard inputReportCard", pk, "LongTermSuspensionsTotal w3-input w3-border ");
					a("name", "longTermSuspensionsTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setLongTermSuspensionsTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_longTermSuspensionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_longTermSuspensionsTotal')); }); ");
				}
				a("value", strLongTermSuspensionsTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "LongTermSuspensionsTotal ").f().sx(htmLongTermSuspensionsTotal()).g("span");
		}
	}

	public void htmLongTermSuspensionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardLongTermSuspensionsTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_longTermSuspensionsTotal").a("class", "").f().sx("long-term suspensions total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputLongTermSuspensionsTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_longTermSuspensionsTotal')); $('#", classApiMethodMethod, "_longTermSuspensionsTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setLongTermSuspensionsTotal', null, function() { addGlow($('#", classApiMethodMethod, "_longTermSuspensionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_longTermSuspensionsTotal')); }); ")
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
	// expulsionsTotal //
	/////////////////////

	/**	 The entity expulsionsTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long expulsionsTotal;
	@JsonIgnore
	public Wrap<Long> expulsionsTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("expulsionsTotal").o(expulsionsTotal);

	/**	<br/> The entity expulsionsTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:expulsionsTotal">Find the entity expulsionsTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _expulsionsTotal(Wrap<Long> c);

	public Long getExpulsionsTotal() {
		return expulsionsTotal;
	}

	public void setExpulsionsTotal(Long expulsionsTotal) {
		this.expulsionsTotal = expulsionsTotal;
		this.expulsionsTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setExpulsionsTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.expulsionsTotal = Long.parseLong(o);
		this.expulsionsTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard expulsionsTotalInit() {
		if(!expulsionsTotalWrap.alreadyInitialized) {
			_expulsionsTotal(expulsionsTotalWrap);
			if(expulsionsTotal == null)
				setExpulsionsTotal(expulsionsTotalWrap.o);
		}
		expulsionsTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrExpulsionsTotal() {
		return expulsionsTotal;
	}

	public String strExpulsionsTotal() {
		return expulsionsTotal == null ? "" : expulsionsTotal.toString();
	}

	public String jsonExpulsionsTotal() {
		return expulsionsTotal == null ? "" : expulsionsTotal.toString();
	}

	public String nomAffichageExpulsionsTotal() {
		return "expulsions total";
	}

	public String htmTooltipExpulsionsTotal() {
		return null;
	}

	public String htmExpulsionsTotal() {
		return expulsionsTotal == null ? "" : StringEscapeUtils.escapeHtml4(strExpulsionsTotal());
	}

	public void inputExpulsionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "expulsions total")
				.a("id", classApiMethodMethod, "_expulsionsTotal");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setExpulsionsTotal classReportCard inputReportCard", pk, "ExpulsionsTotal w3-input w3-border ");
					a("name", "setExpulsionsTotal");
				} else {
					a("class", "valueExpulsionsTotal w3-input w3-border classReportCard inputReportCard", pk, "ExpulsionsTotal w3-input w3-border ");
					a("name", "expulsionsTotal");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setExpulsionsTotal', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_expulsionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_expulsionsTotal')); }); ");
				}
				a("value", strExpulsionsTotal())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ExpulsionsTotal ").f().sx(htmExpulsionsTotal()).g("span");
		}
	}

	public void htmExpulsionsTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardExpulsionsTotal").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_expulsionsTotal").a("class", "").f().sx("expulsions total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputExpulsionsTotal(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_expulsionsTotal')); $('#", classApiMethodMethod, "_expulsionsTotal').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setExpulsionsTotal', null, function() { addGlow($('#", classApiMethodMethod, "_expulsionsTotal')); }, function() { addError($('#", classApiMethodMethod, "_expulsionsTotal')); }); ")
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

	/////////////////////////////////////
	// shortTermSuspensionsAsianFemale //
	/////////////////////////////////////

	/**	 The entity shortTermSuspensionsAsianFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsAsianFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsAsianFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsAsianFemale").o(shortTermSuspensionsAsianFemale);

	/**	<br/> The entity shortTermSuspensionsAsianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAsianFemale">Find the entity shortTermSuspensionsAsianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAsianFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsAsianFemale() {
		return shortTermSuspensionsAsianFemale;
	}

	public void setShortTermSuspensionsAsianFemale(Long shortTermSuspensionsAsianFemale) {
		this.shortTermSuspensionsAsianFemale = shortTermSuspensionsAsianFemale;
		this.shortTermSuspensionsAsianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAsianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAsianFemale = Long.parseLong(o);
		this.shortTermSuspensionsAsianFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAsianFemaleInit() {
		if(!shortTermSuspensionsAsianFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsAsianFemale(shortTermSuspensionsAsianFemaleWrap);
			if(shortTermSuspensionsAsianFemale == null)
				setShortTermSuspensionsAsianFemale(shortTermSuspensionsAsianFemaleWrap.o);
		}
		shortTermSuspensionsAsianFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsAsianFemale() {
		return shortTermSuspensionsAsianFemale;
	}

	public String strShortTermSuspensionsAsianFemale() {
		return shortTermSuspensionsAsianFemale == null ? "" : shortTermSuspensionsAsianFemale.toString();
	}

	public String jsonShortTermSuspensionsAsianFemale() {
		return shortTermSuspensionsAsianFemale == null ? "" : shortTermSuspensionsAsianFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsAsianFemale() {
		return "short-term suspensions Asian female";
	}

	public String htmTooltipShortTermSuspensionsAsianFemale() {
		return null;
	}

	public String htmShortTermSuspensionsAsianFemale() {
		return shortTermSuspensionsAsianFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAsianFemale());
	}

	public void inputShortTermSuspensionsAsianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Asian female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsAsianFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsAsianFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsAsianFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsAsianFemale");
				} else {
					a("class", "valueShortTermSuspensionsAsianFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsAsianFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsAsianFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsAsianFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale')); }); ");
				}
				a("value", strShortTermSuspensionsAsianFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAsianFemale ").f().sx(htmShortTermSuspensionsAsianFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsAsianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsAsianFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsAsianFemale").a("class", "").f().sx("short-term suspensions Asian female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsAsianFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsAsianFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsAsianFemale')); }); ")
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

	///////////////////////////////////
	// shortTermSuspensionsAsianMale //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsAsianMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsAsianMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsAsianMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsAsianMale").o(shortTermSuspensionsAsianMale);

	/**	<br/> The entity shortTermSuspensionsAsianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAsianMale">Find the entity shortTermSuspensionsAsianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAsianMale(Wrap<Long> c);

	public Long getShortTermSuspensionsAsianMale() {
		return shortTermSuspensionsAsianMale;
	}

	public void setShortTermSuspensionsAsianMale(Long shortTermSuspensionsAsianMale) {
		this.shortTermSuspensionsAsianMale = shortTermSuspensionsAsianMale;
		this.shortTermSuspensionsAsianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAsianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAsianMale = Long.parseLong(o);
		this.shortTermSuspensionsAsianMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAsianMaleInit() {
		if(!shortTermSuspensionsAsianMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsAsianMale(shortTermSuspensionsAsianMaleWrap);
			if(shortTermSuspensionsAsianMale == null)
				setShortTermSuspensionsAsianMale(shortTermSuspensionsAsianMaleWrap.o);
		}
		shortTermSuspensionsAsianMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsAsianMale() {
		return shortTermSuspensionsAsianMale;
	}

	public String strShortTermSuspensionsAsianMale() {
		return shortTermSuspensionsAsianMale == null ? "" : shortTermSuspensionsAsianMale.toString();
	}

	public String jsonShortTermSuspensionsAsianMale() {
		return shortTermSuspensionsAsianMale == null ? "" : shortTermSuspensionsAsianMale.toString();
	}

	public String nomAffichageShortTermSuspensionsAsianMale() {
		return "short-term suspensions Asian male";
	}

	public String htmTooltipShortTermSuspensionsAsianMale() {
		return null;
	}

	public String htmShortTermSuspensionsAsianMale() {
		return shortTermSuspensionsAsianMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAsianMale());
	}

	public void inputShortTermSuspensionsAsianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Asian male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsAsianMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsAsianMale classReportCard inputReportCard", pk, "ShortTermSuspensionsAsianMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsAsianMale");
				} else {
					a("class", "valueShortTermSuspensionsAsianMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsAsianMale w3-input w3-border ");
					a("name", "shortTermSuspensionsAsianMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsAsianMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale')); }); ");
				}
				a("value", strShortTermSuspensionsAsianMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAsianMale ").f().sx(htmShortTermSuspensionsAsianMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsAsianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsAsianMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsAsianMale").a("class", "").f().sx("short-term suspensions Asian male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsAsianMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsAsianMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsAsianMale')); }); ")
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

	////////////////////////////////////
	// shortTermSuspensionsAsianTotal //
	////////////////////////////////////

	/**	 The entity shortTermSuspensionsAsianTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsAsianTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsAsianTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsAsianTotal").o(shortTermSuspensionsAsianTotal);

	/**	<br/> The entity shortTermSuspensionsAsianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAsianTotal">Find the entity shortTermSuspensionsAsianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAsianTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsAsianTotal() {
		return shortTermSuspensionsAsianTotal;
	}

	public void setShortTermSuspensionsAsianTotal(Long shortTermSuspensionsAsianTotal) {
		this.shortTermSuspensionsAsianTotal = shortTermSuspensionsAsianTotal;
		this.shortTermSuspensionsAsianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAsianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAsianTotal = Long.parseLong(o);
		this.shortTermSuspensionsAsianTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAsianTotalInit() {
		if(!shortTermSuspensionsAsianTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsAsianTotal(shortTermSuspensionsAsianTotalWrap);
			if(shortTermSuspensionsAsianTotal == null)
				setShortTermSuspensionsAsianTotal(shortTermSuspensionsAsianTotalWrap.o);
		}
		shortTermSuspensionsAsianTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsAsianTotal() {
		return shortTermSuspensionsAsianTotal;
	}

	public String strShortTermSuspensionsAsianTotal() {
		return shortTermSuspensionsAsianTotal == null ? "" : shortTermSuspensionsAsianTotal.toString();
	}

	public String jsonShortTermSuspensionsAsianTotal() {
		return shortTermSuspensionsAsianTotal == null ? "" : shortTermSuspensionsAsianTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsAsianTotal() {
		return "short-term suspensions Asians total";
	}

	public String htmTooltipShortTermSuspensionsAsianTotal() {
		return null;
	}

	public String htmShortTermSuspensionsAsianTotal() {
		return shortTermSuspensionsAsianTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAsianTotal());
	}

	public void inputShortTermSuspensionsAsianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsAsianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Asians total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAsianTotal ").f().sx(strShortTermSuspensionsAsianTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsAsianPercent //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsAsianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsAsianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsAsianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsAsianPercent").o(shortTermSuspensionsAsianPercent);

	/**	<br/> The entity shortTermSuspensionsAsianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAsianPercent">Find the entity shortTermSuspensionsAsianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAsianPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent;
	}

	public void setShortTermSuspensionsAsianPercent(BigDecimal shortTermSuspensionsAsianPercent) {
		this.shortTermSuspensionsAsianPercent = shortTermSuspensionsAsianPercent;
		this.shortTermSuspensionsAsianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAsianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAsianPercent(Double o) {
			this.shortTermSuspensionsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAsianPercent(Integer o) {
			this.shortTermSuspensionsAsianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAsianPercentInit() {
		if(!shortTermSuspensionsAsianPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsAsianPercent(shortTermSuspensionsAsianPercentWrap);
			if(shortTermSuspensionsAsianPercent == null)
				setShortTermSuspensionsAsianPercent(shortTermSuspensionsAsianPercentWrap.o);
		}
		shortTermSuspensionsAsianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent == null ? null : shortTermSuspensionsAsianPercent.doubleValue();
	}

	public String strShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent == null ? "" : shortTermSuspensionsAsianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent == null ? "" : shortTermSuspensionsAsianPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsAsianPercent() {
		return "short-term suspensions Asians percent";
	}

	public String htmTooltipShortTermSuspensionsAsianPercent() {
		return null;
	}

	public String htmShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAsianPercent());
	}

	public void inputShortTermSuspensionsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsAsianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Asians percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAsianPercent ").f().sx(strShortTermSuspensionsAsianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////
	// shortTermSuspensionsAsianRate //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsAsianRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsAsianRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsAsianRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsAsianRate").o(shortTermSuspensionsAsianRate);

	/**	<br/> The entity shortTermSuspensionsAsianRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAsianRate">Find the entity shortTermSuspensionsAsianRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAsianRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate;
	}

	public void setShortTermSuspensionsAsianRate(BigDecimal shortTermSuspensionsAsianRate) {
		this.shortTermSuspensionsAsianRate = shortTermSuspensionsAsianRate;
		this.shortTermSuspensionsAsianRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAsianRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAsianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAsianRate(Double o) {
			this.shortTermSuspensionsAsianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAsianRate(Integer o) {
			this.shortTermSuspensionsAsianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAsianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAsianRateInit() {
		if(!shortTermSuspensionsAsianRateWrap.alreadyInitialized) {
			_shortTermSuspensionsAsianRate(shortTermSuspensionsAsianRateWrap);
			if(shortTermSuspensionsAsianRate == null)
				setShortTermSuspensionsAsianRate(shortTermSuspensionsAsianRateWrap.o);
		}
		shortTermSuspensionsAsianRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate == null ? null : shortTermSuspensionsAsianRate.doubleValue();
	}

	public String strShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate == null ? "" : shortTermSuspensionsAsianRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate == null ? "" : shortTermSuspensionsAsianRate.toString();
	}

	public String nomAffichageShortTermSuspensionsAsianRate() {
		return "short-term suspensions Asians rate";
	}

	public String htmTooltipShortTermSuspensionsAsianRate() {
		return null;
	}

	public String htmShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAsianRate());
	}

	public void inputShortTermSuspensionsAsianRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsAsianRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Asians rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAsianRate ").f().sx(strShortTermSuspensionsAsianRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////
	// shortTermSuspensionsBlackFemale //
	/////////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsBlackFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsBlackFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsBlackFemale").o(shortTermSuspensionsBlackFemale);

	/**	<br/> The entity shortTermSuspensionsBlackFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackFemale">Find the entity shortTermSuspensionsBlackFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsBlackFemale() {
		return shortTermSuspensionsBlackFemale;
	}

	public void setShortTermSuspensionsBlackFemale(Long shortTermSuspensionsBlackFemale) {
		this.shortTermSuspensionsBlackFemale = shortTermSuspensionsBlackFemale;
		this.shortTermSuspensionsBlackFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackFemale = Long.parseLong(o);
		this.shortTermSuspensionsBlackFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackFemaleInit() {
		if(!shortTermSuspensionsBlackFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackFemale(shortTermSuspensionsBlackFemaleWrap);
			if(shortTermSuspensionsBlackFemale == null)
				setShortTermSuspensionsBlackFemale(shortTermSuspensionsBlackFemaleWrap.o);
		}
		shortTermSuspensionsBlackFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsBlackFemale() {
		return shortTermSuspensionsBlackFemale;
	}

	public String strShortTermSuspensionsBlackFemale() {
		return shortTermSuspensionsBlackFemale == null ? "" : shortTermSuspensionsBlackFemale.toString();
	}

	public String jsonShortTermSuspensionsBlackFemale() {
		return shortTermSuspensionsBlackFemale == null ? "" : shortTermSuspensionsBlackFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackFemale() {
		return "short-term suspensions Black female";
	}

	public String htmTooltipShortTermSuspensionsBlackFemale() {
		return null;
	}

	public String htmShortTermSuspensionsBlackFemale() {
		return shortTermSuspensionsBlackFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackFemale());
	}

	public void inputShortTermSuspensionsBlackFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Black female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsBlackFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsBlackFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsBlackFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsBlackFemale");
				} else {
					a("class", "valueShortTermSuspensionsBlackFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsBlackFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsBlackFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsBlackFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale')); }); ");
				}
				a("value", strShortTermSuspensionsBlackFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackFemale ").f().sx(htmShortTermSuspensionsBlackFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsBlackFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsBlackFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsBlackFemale").a("class", "").f().sx("short-term suspensions Black female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsBlackFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsBlackFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsBlackFemale')); }); ")
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

	///////////////////////////////////
	// shortTermSuspensionsBlackMale //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsBlackMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsBlackMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsBlackMale").o(shortTermSuspensionsBlackMale);

	/**	<br/> The entity shortTermSuspensionsBlackMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackMale">Find the entity shortTermSuspensionsBlackMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackMale(Wrap<Long> c);

	public Long getShortTermSuspensionsBlackMale() {
		return shortTermSuspensionsBlackMale;
	}

	public void setShortTermSuspensionsBlackMale(Long shortTermSuspensionsBlackMale) {
		this.shortTermSuspensionsBlackMale = shortTermSuspensionsBlackMale;
		this.shortTermSuspensionsBlackMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackMale = Long.parseLong(o);
		this.shortTermSuspensionsBlackMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackMaleInit() {
		if(!shortTermSuspensionsBlackMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackMale(shortTermSuspensionsBlackMaleWrap);
			if(shortTermSuspensionsBlackMale == null)
				setShortTermSuspensionsBlackMale(shortTermSuspensionsBlackMaleWrap.o);
		}
		shortTermSuspensionsBlackMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsBlackMale() {
		return shortTermSuspensionsBlackMale;
	}

	public String strShortTermSuspensionsBlackMale() {
		return shortTermSuspensionsBlackMale == null ? "" : shortTermSuspensionsBlackMale.toString();
	}

	public String jsonShortTermSuspensionsBlackMale() {
		return shortTermSuspensionsBlackMale == null ? "" : shortTermSuspensionsBlackMale.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackMale() {
		return "short-term suspensions Black male";
	}

	public String htmTooltipShortTermSuspensionsBlackMale() {
		return null;
	}

	public String htmShortTermSuspensionsBlackMale() {
		return shortTermSuspensionsBlackMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackMale());
	}

	public void inputShortTermSuspensionsBlackMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Black male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsBlackMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsBlackMale classReportCard inputReportCard", pk, "ShortTermSuspensionsBlackMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsBlackMale");
				} else {
					a("class", "valueShortTermSuspensionsBlackMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsBlackMale w3-input w3-border ");
					a("name", "shortTermSuspensionsBlackMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsBlackMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale')); }); ");
				}
				a("value", strShortTermSuspensionsBlackMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackMale ").f().sx(htmShortTermSuspensionsBlackMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsBlackMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsBlackMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsBlackMale").a("class", "").f().sx("short-term suspensions Black male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsBlackMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsBlackMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsBlackMale')); }); ")
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

	////////////////////////////////////
	// shortTermSuspensionsBlackTotal //
	////////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsBlackTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsBlackTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsBlackTotal").o(shortTermSuspensionsBlackTotal);

	/**	<br/> The entity shortTermSuspensionsBlackTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackTotal">Find the entity shortTermSuspensionsBlackTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsBlackTotal() {
		return shortTermSuspensionsBlackTotal;
	}

	public void setShortTermSuspensionsBlackTotal(Long shortTermSuspensionsBlackTotal) {
		this.shortTermSuspensionsBlackTotal = shortTermSuspensionsBlackTotal;
		this.shortTermSuspensionsBlackTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackTotal = Long.parseLong(o);
		this.shortTermSuspensionsBlackTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackTotalInit() {
		if(!shortTermSuspensionsBlackTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackTotal(shortTermSuspensionsBlackTotalWrap);
			if(shortTermSuspensionsBlackTotal == null)
				setShortTermSuspensionsBlackTotal(shortTermSuspensionsBlackTotalWrap.o);
		}
		shortTermSuspensionsBlackTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsBlackTotal() {
		return shortTermSuspensionsBlackTotal;
	}

	public String strShortTermSuspensionsBlackTotal() {
		return shortTermSuspensionsBlackTotal == null ? "" : shortTermSuspensionsBlackTotal.toString();
	}

	public String jsonShortTermSuspensionsBlackTotal() {
		return shortTermSuspensionsBlackTotal == null ? "" : shortTermSuspensionsBlackTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackTotal() {
		return "short-term suspensions Blacks total";
	}

	public String htmTooltipShortTermSuspensionsBlackTotal() {
		return null;
	}

	public String htmShortTermSuspensionsBlackTotal() {
		return shortTermSuspensionsBlackTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackTotal());
	}

	public void inputShortTermSuspensionsBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsBlackTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Blacks total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackTotal ").f().sx(strShortTermSuspensionsBlackTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsBlackPercent //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsBlackPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsBlackPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsBlackPercent").o(shortTermSuspensionsBlackPercent);

	/**	<br/> The entity shortTermSuspensionsBlackPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackPercent">Find the entity shortTermSuspensionsBlackPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent;
	}

	public void setShortTermSuspensionsBlackPercent(BigDecimal shortTermSuspensionsBlackPercent) {
		this.shortTermSuspensionsBlackPercent = shortTermSuspensionsBlackPercent;
		this.shortTermSuspensionsBlackPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackPercent(Double o) {
			this.shortTermSuspensionsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackPercent(Integer o) {
			this.shortTermSuspensionsBlackPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackPercentInit() {
		if(!shortTermSuspensionsBlackPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackPercent(shortTermSuspensionsBlackPercentWrap);
			if(shortTermSuspensionsBlackPercent == null)
				setShortTermSuspensionsBlackPercent(shortTermSuspensionsBlackPercentWrap.o);
		}
		shortTermSuspensionsBlackPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent == null ? null : shortTermSuspensionsBlackPercent.doubleValue();
	}

	public String strShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent == null ? "" : shortTermSuspensionsBlackPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent == null ? "" : shortTermSuspensionsBlackPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackPercent() {
		return "short-term suspensions Blacks percent";
	}

	public String htmTooltipShortTermSuspensionsBlackPercent() {
		return null;
	}

	public String htmShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackPercent());
	}

	public void inputShortTermSuspensionsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsBlackPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Blacks percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackPercent ").f().sx(strShortTermSuspensionsBlackPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////
	// shortTermSuspensionsBlackRate //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsBlackRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsBlackRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsBlackRate").o(shortTermSuspensionsBlackRate);

	/**	<br/> The entity shortTermSuspensionsBlackRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackRate">Find the entity shortTermSuspensionsBlackRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate;
	}

	public void setShortTermSuspensionsBlackRate(BigDecimal shortTermSuspensionsBlackRate) {
		this.shortTermSuspensionsBlackRate = shortTermSuspensionsBlackRate;
		this.shortTermSuspensionsBlackRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackRate(Double o) {
			this.shortTermSuspensionsBlackRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackRate(Integer o) {
			this.shortTermSuspensionsBlackRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackRateInit() {
		if(!shortTermSuspensionsBlackRateWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackRate(shortTermSuspensionsBlackRateWrap);
			if(shortTermSuspensionsBlackRate == null)
				setShortTermSuspensionsBlackRate(shortTermSuspensionsBlackRateWrap.o);
		}
		shortTermSuspensionsBlackRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate == null ? null : shortTermSuspensionsBlackRate.doubleValue();
	}

	public String strShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate == null ? "" : shortTermSuspensionsBlackRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate == null ? "" : shortTermSuspensionsBlackRate.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackRate() {
		return "short-term suspensions Blacks rate";
	}

	public String htmTooltipShortTermSuspensionsBlackRate() {
		return null;
	}

	public String htmShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackRate());
	}

	public void inputShortTermSuspensionsBlackRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsBlackRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Blacks rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackRate ").f().sx(strShortTermSuspensionsBlackRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////////////////////
	// shortTermSuspensionsHispanicFemale //
	////////////////////////////////////////

	/**	 The entity shortTermSuspensionsHispanicFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsHispanicFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsHispanicFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsHispanicFemale").o(shortTermSuspensionsHispanicFemale);

	/**	<br/> The entity shortTermSuspensionsHispanicFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsHispanicFemale">Find the entity shortTermSuspensionsHispanicFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsHispanicFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsHispanicFemale() {
		return shortTermSuspensionsHispanicFemale;
	}

	public void setShortTermSuspensionsHispanicFemale(Long shortTermSuspensionsHispanicFemale) {
		this.shortTermSuspensionsHispanicFemale = shortTermSuspensionsHispanicFemale;
		this.shortTermSuspensionsHispanicFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsHispanicFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsHispanicFemale = Long.parseLong(o);
		this.shortTermSuspensionsHispanicFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsHispanicFemaleInit() {
		if(!shortTermSuspensionsHispanicFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsHispanicFemale(shortTermSuspensionsHispanicFemaleWrap);
			if(shortTermSuspensionsHispanicFemale == null)
				setShortTermSuspensionsHispanicFemale(shortTermSuspensionsHispanicFemaleWrap.o);
		}
		shortTermSuspensionsHispanicFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsHispanicFemale() {
		return shortTermSuspensionsHispanicFemale;
	}

	public String strShortTermSuspensionsHispanicFemale() {
		return shortTermSuspensionsHispanicFemale == null ? "" : shortTermSuspensionsHispanicFemale.toString();
	}

	public String jsonShortTermSuspensionsHispanicFemale() {
		return shortTermSuspensionsHispanicFemale == null ? "" : shortTermSuspensionsHispanicFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsHispanicFemale() {
		return "short-term suspensions Latinx female";
	}

	public String htmTooltipShortTermSuspensionsHispanicFemale() {
		return null;
	}

	public String htmShortTermSuspensionsHispanicFemale() {
		return shortTermSuspensionsHispanicFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsHispanicFemale());
	}

	public void inputShortTermSuspensionsHispanicFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Latinx female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsHispanicFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsHispanicFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsHispanicFemale");
				} else {
					a("class", "valueShortTermSuspensionsHispanicFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsHispanicFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsHispanicFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsHispanicFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale')); }); ");
				}
				a("value", strShortTermSuspensionsHispanicFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsHispanicFemale ").f().sx(htmShortTermSuspensionsHispanicFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsHispanicFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsHispanicFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale").a("class", "").f().sx("short-term suspensions Latinx female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsHispanicFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsHispanicFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicFemale')); }); ")
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

	//////////////////////////////////////
	// shortTermSuspensionsHispanicMale //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsHispanicMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsHispanicMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsHispanicMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsHispanicMale").o(shortTermSuspensionsHispanicMale);

	/**	<br/> The entity shortTermSuspensionsHispanicMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsHispanicMale">Find the entity shortTermSuspensionsHispanicMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsHispanicMale(Wrap<Long> c);

	public Long getShortTermSuspensionsHispanicMale() {
		return shortTermSuspensionsHispanicMale;
	}

	public void setShortTermSuspensionsHispanicMale(Long shortTermSuspensionsHispanicMale) {
		this.shortTermSuspensionsHispanicMale = shortTermSuspensionsHispanicMale;
		this.shortTermSuspensionsHispanicMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsHispanicMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsHispanicMale = Long.parseLong(o);
		this.shortTermSuspensionsHispanicMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsHispanicMaleInit() {
		if(!shortTermSuspensionsHispanicMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsHispanicMale(shortTermSuspensionsHispanicMaleWrap);
			if(shortTermSuspensionsHispanicMale == null)
				setShortTermSuspensionsHispanicMale(shortTermSuspensionsHispanicMaleWrap.o);
		}
		shortTermSuspensionsHispanicMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsHispanicMale() {
		return shortTermSuspensionsHispanicMale;
	}

	public String strShortTermSuspensionsHispanicMale() {
		return shortTermSuspensionsHispanicMale == null ? "" : shortTermSuspensionsHispanicMale.toString();
	}

	public String jsonShortTermSuspensionsHispanicMale() {
		return shortTermSuspensionsHispanicMale == null ? "" : shortTermSuspensionsHispanicMale.toString();
	}

	public String nomAffichageShortTermSuspensionsHispanicMale() {
		return "short-term suspensions Latinx male";
	}

	public String htmTooltipShortTermSuspensionsHispanicMale() {
		return null;
	}

	public String htmShortTermSuspensionsHispanicMale() {
		return shortTermSuspensionsHispanicMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsHispanicMale());
	}

	public void inputShortTermSuspensionsHispanicMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Latinx male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsHispanicMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsHispanicMale classReportCard inputReportCard", pk, "ShortTermSuspensionsHispanicMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsHispanicMale");
				} else {
					a("class", "valueShortTermSuspensionsHispanicMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsHispanicMale w3-input w3-border ");
					a("name", "shortTermSuspensionsHispanicMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsHispanicMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale')); }); ");
				}
				a("value", strShortTermSuspensionsHispanicMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsHispanicMale ").f().sx(htmShortTermSuspensionsHispanicMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsHispanicMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsHispanicMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsHispanicMale").a("class", "").f().sx("short-term suspensions Latinx male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsHispanicMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsHispanicMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsHispanicMale')); }); ")
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

	///////////////////////////////////////
	// shortTermSuspensionsHispanicTotal //
	///////////////////////////////////////

	/**	 The entity shortTermSuspensionsHispanicTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsHispanicTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsHispanicTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsHispanicTotal").o(shortTermSuspensionsHispanicTotal);

	/**	<br/> The entity shortTermSuspensionsHispanicTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsHispanicTotal">Find the entity shortTermSuspensionsHispanicTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsHispanicTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsHispanicTotal() {
		return shortTermSuspensionsHispanicTotal;
	}

	public void setShortTermSuspensionsHispanicTotal(Long shortTermSuspensionsHispanicTotal) {
		this.shortTermSuspensionsHispanicTotal = shortTermSuspensionsHispanicTotal;
		this.shortTermSuspensionsHispanicTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsHispanicTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsHispanicTotal = Long.parseLong(o);
		this.shortTermSuspensionsHispanicTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsHispanicTotalInit() {
		if(!shortTermSuspensionsHispanicTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsHispanicTotal(shortTermSuspensionsHispanicTotalWrap);
			if(shortTermSuspensionsHispanicTotal == null)
				setShortTermSuspensionsHispanicTotal(shortTermSuspensionsHispanicTotalWrap.o);
		}
		shortTermSuspensionsHispanicTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsHispanicTotal() {
		return shortTermSuspensionsHispanicTotal;
	}

	public String strShortTermSuspensionsHispanicTotal() {
		return shortTermSuspensionsHispanicTotal == null ? "" : shortTermSuspensionsHispanicTotal.toString();
	}

	public String jsonShortTermSuspensionsHispanicTotal() {
		return shortTermSuspensionsHispanicTotal == null ? "" : shortTermSuspensionsHispanicTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsHispanicTotal() {
		return "short-term suspensions Latinx total";
	}

	public String htmTooltipShortTermSuspensionsHispanicTotal() {
		return null;
	}

	public String htmShortTermSuspensionsHispanicTotal() {
		return shortTermSuspensionsHispanicTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsHispanicTotal());
	}

	public void inputShortTermSuspensionsHispanicTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsHispanicTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Latinx total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsHispanicTotal ").f().sx(strShortTermSuspensionsHispanicTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////////
	// shortTermSuspensionsHispanicPercent //
	/////////////////////////////////////////

	/**	 The entity shortTermSuspensionsHispanicPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsHispanicPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsHispanicPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsHispanicPercent").o(shortTermSuspensionsHispanicPercent);

	/**	<br/> The entity shortTermSuspensionsHispanicPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsHispanicPercent">Find the entity shortTermSuspensionsHispanicPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsHispanicPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent;
	}

	public void setShortTermSuspensionsHispanicPercent(BigDecimal shortTermSuspensionsHispanicPercent) {
		this.shortTermSuspensionsHispanicPercent = shortTermSuspensionsHispanicPercent;
		this.shortTermSuspensionsHispanicPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsHispanicPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsHispanicPercent(Double o) {
			this.shortTermSuspensionsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsHispanicPercent(Integer o) {
			this.shortTermSuspensionsHispanicPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsHispanicPercentInit() {
		if(!shortTermSuspensionsHispanicPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsHispanicPercent(shortTermSuspensionsHispanicPercentWrap);
			if(shortTermSuspensionsHispanicPercent == null)
				setShortTermSuspensionsHispanicPercent(shortTermSuspensionsHispanicPercentWrap.o);
		}
		shortTermSuspensionsHispanicPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent == null ? null : shortTermSuspensionsHispanicPercent.doubleValue();
	}

	public String strShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent == null ? "" : shortTermSuspensionsHispanicPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent == null ? "" : shortTermSuspensionsHispanicPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsHispanicPercent() {
		return "short-term suspensions Latinx percent";
	}

	public String htmTooltipShortTermSuspensionsHispanicPercent() {
		return null;
	}

	public String htmShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsHispanicPercent());
	}

	public void inputShortTermSuspensionsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsHispanicPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Latinx percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsHispanicPercent ").f().sx(strShortTermSuspensionsHispanicPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsHispanicRate //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsHispanicRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsHispanicRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsHispanicRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsHispanicRate").o(shortTermSuspensionsHispanicRate);

	/**	<br/> The entity shortTermSuspensionsHispanicRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsHispanicRate">Find the entity shortTermSuspensionsHispanicRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsHispanicRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate;
	}

	public void setShortTermSuspensionsHispanicRate(BigDecimal shortTermSuspensionsHispanicRate) {
		this.shortTermSuspensionsHispanicRate = shortTermSuspensionsHispanicRate;
		this.shortTermSuspensionsHispanicRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsHispanicRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsHispanicRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsHispanicRate(Double o) {
			this.shortTermSuspensionsHispanicRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsHispanicRate(Integer o) {
			this.shortTermSuspensionsHispanicRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsHispanicRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsHispanicRateInit() {
		if(!shortTermSuspensionsHispanicRateWrap.alreadyInitialized) {
			_shortTermSuspensionsHispanicRate(shortTermSuspensionsHispanicRateWrap);
			if(shortTermSuspensionsHispanicRate == null)
				setShortTermSuspensionsHispanicRate(shortTermSuspensionsHispanicRateWrap.o);
		}
		shortTermSuspensionsHispanicRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate == null ? null : shortTermSuspensionsHispanicRate.doubleValue();
	}

	public String strShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate == null ? "" : shortTermSuspensionsHispanicRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate == null ? "" : shortTermSuspensionsHispanicRate.toString();
	}

	public String nomAffichageShortTermSuspensionsHispanicRate() {
		return "short-term suspensions Latinx rate";
	}

	public String htmTooltipShortTermSuspensionsHispanicRate() {
		return null;
	}

	public String htmShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsHispanicRate());
	}

	public void inputShortTermSuspensionsHispanicRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsHispanicRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Latinx rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsHispanicRate ").f().sx(strShortTermSuspensionsHispanicRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsIndianFemale //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsIndianFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsIndianFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsIndianFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsIndianFemale").o(shortTermSuspensionsIndianFemale);

	/**	<br/> The entity shortTermSuspensionsIndianFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsIndianFemale">Find the entity shortTermSuspensionsIndianFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsIndianFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsIndianFemale() {
		return shortTermSuspensionsIndianFemale;
	}

	public void setShortTermSuspensionsIndianFemale(Long shortTermSuspensionsIndianFemale) {
		this.shortTermSuspensionsIndianFemale = shortTermSuspensionsIndianFemale;
		this.shortTermSuspensionsIndianFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsIndianFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsIndianFemale = Long.parseLong(o);
		this.shortTermSuspensionsIndianFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsIndianFemaleInit() {
		if(!shortTermSuspensionsIndianFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsIndianFemale(shortTermSuspensionsIndianFemaleWrap);
			if(shortTermSuspensionsIndianFemale == null)
				setShortTermSuspensionsIndianFemale(shortTermSuspensionsIndianFemaleWrap.o);
		}
		shortTermSuspensionsIndianFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsIndianFemale() {
		return shortTermSuspensionsIndianFemale;
	}

	public String strShortTermSuspensionsIndianFemale() {
		return shortTermSuspensionsIndianFemale == null ? "" : shortTermSuspensionsIndianFemale.toString();
	}

	public String jsonShortTermSuspensionsIndianFemale() {
		return shortTermSuspensionsIndianFemale == null ? "" : shortTermSuspensionsIndianFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsIndianFemale() {
		return "short-term suspensions First Nation female";
	}

	public String htmTooltipShortTermSuspensionsIndianFemale() {
		return null;
	}

	public String htmShortTermSuspensionsIndianFemale() {
		return shortTermSuspensionsIndianFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsIndianFemale());
	}

	public void inputShortTermSuspensionsIndianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions First Nation female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsIndianFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsIndianFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsIndianFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsIndianFemale");
				} else {
					a("class", "valueShortTermSuspensionsIndianFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsIndianFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsIndianFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsIndianFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale')); }); ");
				}
				a("value", strShortTermSuspensionsIndianFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsIndianFemale ").f().sx(htmShortTermSuspensionsIndianFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsIndianFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsIndianFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsIndianFemale").a("class", "").f().sx("short-term suspensions First Nation female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsIndianFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsIndianFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsIndianFemale')); }); ")
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

	////////////////////////////////////
	// shortTermSuspensionsIndianMale //
	////////////////////////////////////

	/**	 The entity shortTermSuspensionsIndianMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsIndianMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsIndianMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsIndianMale").o(shortTermSuspensionsIndianMale);

	/**	<br/> The entity shortTermSuspensionsIndianMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsIndianMale">Find the entity shortTermSuspensionsIndianMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsIndianMale(Wrap<Long> c);

	public Long getShortTermSuspensionsIndianMale() {
		return shortTermSuspensionsIndianMale;
	}

	public void setShortTermSuspensionsIndianMale(Long shortTermSuspensionsIndianMale) {
		this.shortTermSuspensionsIndianMale = shortTermSuspensionsIndianMale;
		this.shortTermSuspensionsIndianMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsIndianMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsIndianMale = Long.parseLong(o);
		this.shortTermSuspensionsIndianMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsIndianMaleInit() {
		if(!shortTermSuspensionsIndianMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsIndianMale(shortTermSuspensionsIndianMaleWrap);
			if(shortTermSuspensionsIndianMale == null)
				setShortTermSuspensionsIndianMale(shortTermSuspensionsIndianMaleWrap.o);
		}
		shortTermSuspensionsIndianMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsIndianMale() {
		return shortTermSuspensionsIndianMale;
	}

	public String strShortTermSuspensionsIndianMale() {
		return shortTermSuspensionsIndianMale == null ? "" : shortTermSuspensionsIndianMale.toString();
	}

	public String jsonShortTermSuspensionsIndianMale() {
		return shortTermSuspensionsIndianMale == null ? "" : shortTermSuspensionsIndianMale.toString();
	}

	public String nomAffichageShortTermSuspensionsIndianMale() {
		return "short-term suspensions First Nation male";
	}

	public String htmTooltipShortTermSuspensionsIndianMale() {
		return null;
	}

	public String htmShortTermSuspensionsIndianMale() {
		return shortTermSuspensionsIndianMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsIndianMale());
	}

	public void inputShortTermSuspensionsIndianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions First Nation male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsIndianMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsIndianMale classReportCard inputReportCard", pk, "ShortTermSuspensionsIndianMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsIndianMale");
				} else {
					a("class", "valueShortTermSuspensionsIndianMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsIndianMale w3-input w3-border ");
					a("name", "shortTermSuspensionsIndianMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsIndianMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale')); }); ");
				}
				a("value", strShortTermSuspensionsIndianMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsIndianMale ").f().sx(htmShortTermSuspensionsIndianMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsIndianMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsIndianMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsIndianMale").a("class", "").f().sx("short-term suspensions First Nation male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsIndianMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsIndianMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsIndianMale')); }); ")
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

	/////////////////////////////////////
	// shortTermSuspensionsIndianTotal //
	/////////////////////////////////////

	/**	 The entity shortTermSuspensionsIndianTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsIndianTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsIndianTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsIndianTotal").o(shortTermSuspensionsIndianTotal);

	/**	<br/> The entity shortTermSuspensionsIndianTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsIndianTotal">Find the entity shortTermSuspensionsIndianTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsIndianTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsIndianTotal() {
		return shortTermSuspensionsIndianTotal;
	}

	public void setShortTermSuspensionsIndianTotal(Long shortTermSuspensionsIndianTotal) {
		this.shortTermSuspensionsIndianTotal = shortTermSuspensionsIndianTotal;
		this.shortTermSuspensionsIndianTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsIndianTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsIndianTotal = Long.parseLong(o);
		this.shortTermSuspensionsIndianTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsIndianTotalInit() {
		if(!shortTermSuspensionsIndianTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsIndianTotal(shortTermSuspensionsIndianTotalWrap);
			if(shortTermSuspensionsIndianTotal == null)
				setShortTermSuspensionsIndianTotal(shortTermSuspensionsIndianTotalWrap.o);
		}
		shortTermSuspensionsIndianTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsIndianTotal() {
		return shortTermSuspensionsIndianTotal;
	}

	public String strShortTermSuspensionsIndianTotal() {
		return shortTermSuspensionsIndianTotal == null ? "" : shortTermSuspensionsIndianTotal.toString();
	}

	public String jsonShortTermSuspensionsIndianTotal() {
		return shortTermSuspensionsIndianTotal == null ? "" : shortTermSuspensionsIndianTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsIndianTotal() {
		return "short-term suspensions First Nation total";
	}

	public String htmTooltipShortTermSuspensionsIndianTotal() {
		return null;
	}

	public String htmShortTermSuspensionsIndianTotal() {
		return shortTermSuspensionsIndianTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsIndianTotal());
	}

	public void inputShortTermSuspensionsIndianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsIndianTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions First Nation total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsIndianTotal ").f().sx(strShortTermSuspensionsIndianTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////////
	// shortTermSuspensionsIndianPercent //
	///////////////////////////////////////

	/**	 The entity shortTermSuspensionsIndianPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsIndianPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsIndianPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsIndianPercent").o(shortTermSuspensionsIndianPercent);

	/**	<br/> The entity shortTermSuspensionsIndianPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsIndianPercent">Find the entity shortTermSuspensionsIndianPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsIndianPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent;
	}

	public void setShortTermSuspensionsIndianPercent(BigDecimal shortTermSuspensionsIndianPercent) {
		this.shortTermSuspensionsIndianPercent = shortTermSuspensionsIndianPercent;
		this.shortTermSuspensionsIndianPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsIndianPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsIndianPercent(Double o) {
			this.shortTermSuspensionsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsIndianPercent(Integer o) {
			this.shortTermSuspensionsIndianPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsIndianPercentInit() {
		if(!shortTermSuspensionsIndianPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsIndianPercent(shortTermSuspensionsIndianPercentWrap);
			if(shortTermSuspensionsIndianPercent == null)
				setShortTermSuspensionsIndianPercent(shortTermSuspensionsIndianPercentWrap.o);
		}
		shortTermSuspensionsIndianPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent == null ? null : shortTermSuspensionsIndianPercent.doubleValue();
	}

	public String strShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent == null ? "" : shortTermSuspensionsIndianPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent == null ? "" : shortTermSuspensionsIndianPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsIndianPercent() {
		return "short-term suspensions First Nation percent";
	}

	public String htmTooltipShortTermSuspensionsIndianPercent() {
		return null;
	}

	public String htmShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsIndianPercent());
	}

	public void inputShortTermSuspensionsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsIndianPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions First Nation percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsIndianPercent ").f().sx(strShortTermSuspensionsIndianPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////////////////
	// shortTermSuspensionsIndianRate //
	////////////////////////////////////

	/**	 The entity shortTermSuspensionsIndianRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsIndianRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsIndianRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsIndianRate").o(shortTermSuspensionsIndianRate);

	/**	<br/> The entity shortTermSuspensionsIndianRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsIndianRate">Find the entity shortTermSuspensionsIndianRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsIndianRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate;
	}

	public void setShortTermSuspensionsIndianRate(BigDecimal shortTermSuspensionsIndianRate) {
		this.shortTermSuspensionsIndianRate = shortTermSuspensionsIndianRate;
		this.shortTermSuspensionsIndianRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsIndianRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsIndianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsIndianRate(Double o) {
			this.shortTermSuspensionsIndianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsIndianRate(Integer o) {
			this.shortTermSuspensionsIndianRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsIndianRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsIndianRateInit() {
		if(!shortTermSuspensionsIndianRateWrap.alreadyInitialized) {
			_shortTermSuspensionsIndianRate(shortTermSuspensionsIndianRateWrap);
			if(shortTermSuspensionsIndianRate == null)
				setShortTermSuspensionsIndianRate(shortTermSuspensionsIndianRateWrap.o);
		}
		shortTermSuspensionsIndianRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate == null ? null : shortTermSuspensionsIndianRate.doubleValue();
	}

	public String strShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate == null ? "" : shortTermSuspensionsIndianRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate == null ? "" : shortTermSuspensionsIndianRate.toString();
	}

	public String nomAffichageShortTermSuspensionsIndianRate() {
		return "short-term suspensions First Nation rate";
	}

	public String htmTooltipShortTermSuspensionsIndianRate() {
		return null;
	}

	public String htmShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsIndianRate());
	}

	public void inputShortTermSuspensionsIndianRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsIndianRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions First Nation rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsIndianRate ").f().sx(strShortTermSuspensionsIndianRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////////////
	// shortTermSuspensionsMultiRacialFemale //
	///////////////////////////////////////////

	/**	 The entity shortTermSuspensionsMultiRacialFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsMultiRacialFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsMultiRacialFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsMultiRacialFemale").o(shortTermSuspensionsMultiRacialFemale);

	/**	<br/> The entity shortTermSuspensionsMultiRacialFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsMultiRacialFemale">Find the entity shortTermSuspensionsMultiRacialFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsMultiRacialFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsMultiRacialFemale() {
		return shortTermSuspensionsMultiRacialFemale;
	}

	public void setShortTermSuspensionsMultiRacialFemale(Long shortTermSuspensionsMultiRacialFemale) {
		this.shortTermSuspensionsMultiRacialFemale = shortTermSuspensionsMultiRacialFemale;
		this.shortTermSuspensionsMultiRacialFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsMultiRacialFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsMultiRacialFemale = Long.parseLong(o);
		this.shortTermSuspensionsMultiRacialFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsMultiRacialFemaleInit() {
		if(!shortTermSuspensionsMultiRacialFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsMultiRacialFemale(shortTermSuspensionsMultiRacialFemaleWrap);
			if(shortTermSuspensionsMultiRacialFemale == null)
				setShortTermSuspensionsMultiRacialFemale(shortTermSuspensionsMultiRacialFemaleWrap.o);
		}
		shortTermSuspensionsMultiRacialFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsMultiRacialFemale() {
		return shortTermSuspensionsMultiRacialFemale;
	}

	public String strShortTermSuspensionsMultiRacialFemale() {
		return shortTermSuspensionsMultiRacialFemale == null ? "" : shortTermSuspensionsMultiRacialFemale.toString();
	}

	public String jsonShortTermSuspensionsMultiRacialFemale() {
		return shortTermSuspensionsMultiRacialFemale == null ? "" : shortTermSuspensionsMultiRacialFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsMultiRacialFemale() {
		return "short-term suspensions Multi Racial female";
	}

	public String htmTooltipShortTermSuspensionsMultiRacialFemale() {
		return null;
	}

	public String htmShortTermSuspensionsMultiRacialFemale() {
		return shortTermSuspensionsMultiRacialFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsMultiRacialFemale());
	}

	public void inputShortTermSuspensionsMultiRacialFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Multi Racial female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsMultiRacialFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsMultiRacialFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsMultiRacialFemale");
				} else {
					a("class", "valueShortTermSuspensionsMultiRacialFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsMultiRacialFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsMultiRacialFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsMultiRacialFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale')); }); ");
				}
				a("value", strShortTermSuspensionsMultiRacialFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsMultiRacialFemale ").f().sx(htmShortTermSuspensionsMultiRacialFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsMultiRacialFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsMultiRacialFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale").a("class", "").f().sx("short-term suspensions Multi Racial female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsMultiRacialFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsMultiRacialFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialFemale')); }); ")
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
	// shortTermSuspensionsMultiRacialMale //
	/////////////////////////////////////////

	/**	 The entity shortTermSuspensionsMultiRacialMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsMultiRacialMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsMultiRacialMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsMultiRacialMale").o(shortTermSuspensionsMultiRacialMale);

	/**	<br/> The entity shortTermSuspensionsMultiRacialMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsMultiRacialMale">Find the entity shortTermSuspensionsMultiRacialMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsMultiRacialMale(Wrap<Long> c);

	public Long getShortTermSuspensionsMultiRacialMale() {
		return shortTermSuspensionsMultiRacialMale;
	}

	public void setShortTermSuspensionsMultiRacialMale(Long shortTermSuspensionsMultiRacialMale) {
		this.shortTermSuspensionsMultiRacialMale = shortTermSuspensionsMultiRacialMale;
		this.shortTermSuspensionsMultiRacialMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsMultiRacialMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsMultiRacialMale = Long.parseLong(o);
		this.shortTermSuspensionsMultiRacialMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsMultiRacialMaleInit() {
		if(!shortTermSuspensionsMultiRacialMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsMultiRacialMale(shortTermSuspensionsMultiRacialMaleWrap);
			if(shortTermSuspensionsMultiRacialMale == null)
				setShortTermSuspensionsMultiRacialMale(shortTermSuspensionsMultiRacialMaleWrap.o);
		}
		shortTermSuspensionsMultiRacialMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsMultiRacialMale() {
		return shortTermSuspensionsMultiRacialMale;
	}

	public String strShortTermSuspensionsMultiRacialMale() {
		return shortTermSuspensionsMultiRacialMale == null ? "" : shortTermSuspensionsMultiRacialMale.toString();
	}

	public String jsonShortTermSuspensionsMultiRacialMale() {
		return shortTermSuspensionsMultiRacialMale == null ? "" : shortTermSuspensionsMultiRacialMale.toString();
	}

	public String nomAffichageShortTermSuspensionsMultiRacialMale() {
		return "short-term suspensions Multi Racial male";
	}

	public String htmTooltipShortTermSuspensionsMultiRacialMale() {
		return null;
	}

	public String htmShortTermSuspensionsMultiRacialMale() {
		return shortTermSuspensionsMultiRacialMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsMultiRacialMale());
	}

	public void inputShortTermSuspensionsMultiRacialMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Multi Racial male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsMultiRacialMale classReportCard inputReportCard", pk, "ShortTermSuspensionsMultiRacialMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsMultiRacialMale");
				} else {
					a("class", "valueShortTermSuspensionsMultiRacialMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsMultiRacialMale w3-input w3-border ");
					a("name", "shortTermSuspensionsMultiRacialMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsMultiRacialMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale')); }); ");
				}
				a("value", strShortTermSuspensionsMultiRacialMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsMultiRacialMale ").f().sx(htmShortTermSuspensionsMultiRacialMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsMultiRacialMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsMultiRacialMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale").a("class", "").f().sx("short-term suspensions Multi Racial male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsMultiRacialMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsMultiRacialMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsMultiRacialMale')); }); ")
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

	//////////////////////////////////////////
	// shortTermSuspensionsMultiRacialTotal //
	//////////////////////////////////////////

	/**	 The entity shortTermSuspensionsMultiRacialTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsMultiRacialTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsMultiRacialTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsMultiRacialTotal").o(shortTermSuspensionsMultiRacialTotal);

	/**	<br/> The entity shortTermSuspensionsMultiRacialTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsMultiRacialTotal">Find the entity shortTermSuspensionsMultiRacialTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsMultiRacialTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsMultiRacialTotal() {
		return shortTermSuspensionsMultiRacialTotal;
	}

	public void setShortTermSuspensionsMultiRacialTotal(Long shortTermSuspensionsMultiRacialTotal) {
		this.shortTermSuspensionsMultiRacialTotal = shortTermSuspensionsMultiRacialTotal;
		this.shortTermSuspensionsMultiRacialTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsMultiRacialTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsMultiRacialTotal = Long.parseLong(o);
		this.shortTermSuspensionsMultiRacialTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsMultiRacialTotalInit() {
		if(!shortTermSuspensionsMultiRacialTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsMultiRacialTotal(shortTermSuspensionsMultiRacialTotalWrap);
			if(shortTermSuspensionsMultiRacialTotal == null)
				setShortTermSuspensionsMultiRacialTotal(shortTermSuspensionsMultiRacialTotalWrap.o);
		}
		shortTermSuspensionsMultiRacialTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsMultiRacialTotal() {
		return shortTermSuspensionsMultiRacialTotal;
	}

	public String strShortTermSuspensionsMultiRacialTotal() {
		return shortTermSuspensionsMultiRacialTotal == null ? "" : shortTermSuspensionsMultiRacialTotal.toString();
	}

	public String jsonShortTermSuspensionsMultiRacialTotal() {
		return shortTermSuspensionsMultiRacialTotal == null ? "" : shortTermSuspensionsMultiRacialTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsMultiRacialTotal() {
		return "short-term suspensions Multi Racial total";
	}

	public String htmTooltipShortTermSuspensionsMultiRacialTotal() {
		return null;
	}

	public String htmShortTermSuspensionsMultiRacialTotal() {
		return shortTermSuspensionsMultiRacialTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsMultiRacialTotal());
	}

	public void inputShortTermSuspensionsMultiRacialTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsMultiRacialTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Multi Racial total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsMultiRacialTotal ").f().sx(strShortTermSuspensionsMultiRacialTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////////////////////////
	// shortTermSuspensionsMultiRacialPercent //
	////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsMultiRacialPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsMultiRacialPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsMultiRacialPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsMultiRacialPercent").o(shortTermSuspensionsMultiRacialPercent);

	/**	<br/> The entity shortTermSuspensionsMultiRacialPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsMultiRacialPercent">Find the entity shortTermSuspensionsMultiRacialPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsMultiRacialPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent;
	}

	public void setShortTermSuspensionsMultiRacialPercent(BigDecimal shortTermSuspensionsMultiRacialPercent) {
		this.shortTermSuspensionsMultiRacialPercent = shortTermSuspensionsMultiRacialPercent;
		this.shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsMultiRacialPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsMultiRacialPercent(Double o) {
			this.shortTermSuspensionsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsMultiRacialPercent(Integer o) {
			this.shortTermSuspensionsMultiRacialPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsMultiRacialPercentInit() {
		if(!shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsMultiRacialPercent(shortTermSuspensionsMultiRacialPercentWrap);
			if(shortTermSuspensionsMultiRacialPercent == null)
				setShortTermSuspensionsMultiRacialPercent(shortTermSuspensionsMultiRacialPercentWrap.o);
		}
		shortTermSuspensionsMultiRacialPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent == null ? null : shortTermSuspensionsMultiRacialPercent.doubleValue();
	}

	public String strShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent == null ? "" : shortTermSuspensionsMultiRacialPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent == null ? "" : shortTermSuspensionsMultiRacialPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsMultiRacialPercent() {
		return "short-term suspensions Multi Racial percent";
	}

	public String htmTooltipShortTermSuspensionsMultiRacialPercent() {
		return null;
	}

	public String htmShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsMultiRacialPercent());
	}

	public void inputShortTermSuspensionsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsMultiRacialPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Multi Racial percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsMultiRacialPercent ").f().sx(strShortTermSuspensionsMultiRacialPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////////
	// shortTermSuspensionsMultiRacialRate //
	/////////////////////////////////////////

	/**	 The entity shortTermSuspensionsMultiRacialRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsMultiRacialRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsMultiRacialRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsMultiRacialRate").o(shortTermSuspensionsMultiRacialRate);

	/**	<br/> The entity shortTermSuspensionsMultiRacialRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsMultiRacialRate">Find the entity shortTermSuspensionsMultiRacialRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsMultiRacialRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate;
	}

	public void setShortTermSuspensionsMultiRacialRate(BigDecimal shortTermSuspensionsMultiRacialRate) {
		this.shortTermSuspensionsMultiRacialRate = shortTermSuspensionsMultiRacialRate;
		this.shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsMultiRacialRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsMultiRacialRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsMultiRacialRate(Double o) {
			this.shortTermSuspensionsMultiRacialRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsMultiRacialRate(Integer o) {
			this.shortTermSuspensionsMultiRacialRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsMultiRacialRateInit() {
		if(!shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized) {
			_shortTermSuspensionsMultiRacialRate(shortTermSuspensionsMultiRacialRateWrap);
			if(shortTermSuspensionsMultiRacialRate == null)
				setShortTermSuspensionsMultiRacialRate(shortTermSuspensionsMultiRacialRateWrap.o);
		}
		shortTermSuspensionsMultiRacialRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate == null ? null : shortTermSuspensionsMultiRacialRate.doubleValue();
	}

	public String strShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate == null ? "" : shortTermSuspensionsMultiRacialRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate == null ? "" : shortTermSuspensionsMultiRacialRate.toString();
	}

	public String nomAffichageShortTermSuspensionsMultiRacialRate() {
		return "short-term suspensions Multi Racial rate";
	}

	public String htmTooltipShortTermSuspensionsMultiRacialRate() {
		return null;
	}

	public String htmShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsMultiRacialRate());
	}

	public void inputShortTermSuspensionsMultiRacialRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsMultiRacialRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Multi Racial rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsMultiRacialRate ").f().sx(strShortTermSuspensionsMultiRacialRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////////////////
	// shortTermSuspensionsPacificIslanderFemale //
	///////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsPacificIslanderFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsPacificIslanderFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsPacificIslanderFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsPacificIslanderFemale").o(shortTermSuspensionsPacificIslanderFemale);

	/**	<br/> The entity shortTermSuspensionsPacificIslanderFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsPacificIslanderFemale">Find the entity shortTermSuspensionsPacificIslanderFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsPacificIslanderFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsPacificIslanderFemale() {
		return shortTermSuspensionsPacificIslanderFemale;
	}

	public void setShortTermSuspensionsPacificIslanderFemale(Long shortTermSuspensionsPacificIslanderFemale) {
		this.shortTermSuspensionsPacificIslanderFemale = shortTermSuspensionsPacificIslanderFemale;
		this.shortTermSuspensionsPacificIslanderFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsPacificIslanderFemale = Long.parseLong(o);
		this.shortTermSuspensionsPacificIslanderFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsPacificIslanderFemaleInit() {
		if(!shortTermSuspensionsPacificIslanderFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsPacificIslanderFemale(shortTermSuspensionsPacificIslanderFemaleWrap);
			if(shortTermSuspensionsPacificIslanderFemale == null)
				setShortTermSuspensionsPacificIslanderFemale(shortTermSuspensionsPacificIslanderFemaleWrap.o);
		}
		shortTermSuspensionsPacificIslanderFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsPacificIslanderFemale() {
		return shortTermSuspensionsPacificIslanderFemale;
	}

	public String strShortTermSuspensionsPacificIslanderFemale() {
		return shortTermSuspensionsPacificIslanderFemale == null ? "" : shortTermSuspensionsPacificIslanderFemale.toString();
	}

	public String jsonShortTermSuspensionsPacificIslanderFemale() {
		return shortTermSuspensionsPacificIslanderFemale == null ? "" : shortTermSuspensionsPacificIslanderFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsPacificIslanderFemale() {
		return "short-term suspensions Pacific Islander female";
	}

	public String htmTooltipShortTermSuspensionsPacificIslanderFemale() {
		return null;
	}

	public String htmShortTermSuspensionsPacificIslanderFemale() {
		return shortTermSuspensionsPacificIslanderFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsPacificIslanderFemale());
	}

	public void inputShortTermSuspensionsPacificIslanderFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Pacific Islander female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsPacificIslanderFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsPacificIslanderFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsPacificIslanderFemale");
				} else {
					a("class", "valueShortTermSuspensionsPacificIslanderFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsPacificIslanderFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsPacificIslanderFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsPacificIslanderFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale')); }); ");
				}
				a("value", strShortTermSuspensionsPacificIslanderFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsPacificIslanderFemale ").f().sx(htmShortTermSuspensionsPacificIslanderFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsPacificIslanderFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsPacificIslanderFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale").a("class", "").f().sx("short-term suspensions Pacific Islander female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsPacificIslanderFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsPacificIslanderFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderFemale')); }); ")
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

	/////////////////////////////////////////////
	// shortTermSuspensionsPacificIslanderMale //
	/////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsPacificIslanderMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsPacificIslanderMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsPacificIslanderMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsPacificIslanderMale").o(shortTermSuspensionsPacificIslanderMale);

	/**	<br/> The entity shortTermSuspensionsPacificIslanderMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsPacificIslanderMale">Find the entity shortTermSuspensionsPacificIslanderMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsPacificIslanderMale(Wrap<Long> c);

	public Long getShortTermSuspensionsPacificIslanderMale() {
		return shortTermSuspensionsPacificIslanderMale;
	}

	public void setShortTermSuspensionsPacificIslanderMale(Long shortTermSuspensionsPacificIslanderMale) {
		this.shortTermSuspensionsPacificIslanderMale = shortTermSuspensionsPacificIslanderMale;
		this.shortTermSuspensionsPacificIslanderMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsPacificIslanderMale = Long.parseLong(o);
		this.shortTermSuspensionsPacificIslanderMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsPacificIslanderMaleInit() {
		if(!shortTermSuspensionsPacificIslanderMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsPacificIslanderMale(shortTermSuspensionsPacificIslanderMaleWrap);
			if(shortTermSuspensionsPacificIslanderMale == null)
				setShortTermSuspensionsPacificIslanderMale(shortTermSuspensionsPacificIslanderMaleWrap.o);
		}
		shortTermSuspensionsPacificIslanderMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsPacificIslanderMale() {
		return shortTermSuspensionsPacificIslanderMale;
	}

	public String strShortTermSuspensionsPacificIslanderMale() {
		return shortTermSuspensionsPacificIslanderMale == null ? "" : shortTermSuspensionsPacificIslanderMale.toString();
	}

	public String jsonShortTermSuspensionsPacificIslanderMale() {
		return shortTermSuspensionsPacificIslanderMale == null ? "" : shortTermSuspensionsPacificIslanderMale.toString();
	}

	public String nomAffichageShortTermSuspensionsPacificIslanderMale() {
		return "short-term suspensions Pacific Islander male";
	}

	public String htmTooltipShortTermSuspensionsPacificIslanderMale() {
		return null;
	}

	public String htmShortTermSuspensionsPacificIslanderMale() {
		return shortTermSuspensionsPacificIslanderMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsPacificIslanderMale());
	}

	public void inputShortTermSuspensionsPacificIslanderMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions Pacific Islander male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsPacificIslanderMale classReportCard inputReportCard", pk, "ShortTermSuspensionsPacificIslanderMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsPacificIslanderMale");
				} else {
					a("class", "valueShortTermSuspensionsPacificIslanderMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsPacificIslanderMale w3-input w3-border ");
					a("name", "shortTermSuspensionsPacificIslanderMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsPacificIslanderMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale')); }); ");
				}
				a("value", strShortTermSuspensionsPacificIslanderMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsPacificIslanderMale ").f().sx(htmShortTermSuspensionsPacificIslanderMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsPacificIslanderMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsPacificIslanderMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale").a("class", "").f().sx("short-term suspensions Pacific Islander male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsPacificIslanderMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsPacificIslanderMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsPacificIslanderMale')); }); ")
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

	//////////////////////////////////////////////
	// shortTermSuspensionsPacificIslanderTotal //
	//////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsPacificIslanderTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsPacificIslanderTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsPacificIslanderTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsPacificIslanderTotal").o(shortTermSuspensionsPacificIslanderTotal);

	/**	<br/> The entity shortTermSuspensionsPacificIslanderTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsPacificIslanderTotal">Find the entity shortTermSuspensionsPacificIslanderTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsPacificIslanderTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsPacificIslanderTotal() {
		return shortTermSuspensionsPacificIslanderTotal;
	}

	public void setShortTermSuspensionsPacificIslanderTotal(Long shortTermSuspensionsPacificIslanderTotal) {
		this.shortTermSuspensionsPacificIslanderTotal = shortTermSuspensionsPacificIslanderTotal;
		this.shortTermSuspensionsPacificIslanderTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsPacificIslanderTotal = Long.parseLong(o);
		this.shortTermSuspensionsPacificIslanderTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsPacificIslanderTotalInit() {
		if(!shortTermSuspensionsPacificIslanderTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsPacificIslanderTotal(shortTermSuspensionsPacificIslanderTotalWrap);
			if(shortTermSuspensionsPacificIslanderTotal == null)
				setShortTermSuspensionsPacificIslanderTotal(shortTermSuspensionsPacificIslanderTotalWrap.o);
		}
		shortTermSuspensionsPacificIslanderTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsPacificIslanderTotal() {
		return shortTermSuspensionsPacificIslanderTotal;
	}

	public String strShortTermSuspensionsPacificIslanderTotal() {
		return shortTermSuspensionsPacificIslanderTotal == null ? "" : shortTermSuspensionsPacificIslanderTotal.toString();
	}

	public String jsonShortTermSuspensionsPacificIslanderTotal() {
		return shortTermSuspensionsPacificIslanderTotal == null ? "" : shortTermSuspensionsPacificIslanderTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsPacificIslanderTotal() {
		return "short-term suspensions Pacific Islanders total";
	}

	public String htmTooltipShortTermSuspensionsPacificIslanderTotal() {
		return null;
	}

	public String htmShortTermSuspensionsPacificIslanderTotal() {
		return shortTermSuspensionsPacificIslanderTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsPacificIslanderTotal());
	}

	public void inputShortTermSuspensionsPacificIslanderTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsPacificIslanderTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Pacific Islanders total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsPacificIslanderTotal ").f().sx(strShortTermSuspensionsPacificIslanderTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	////////////////////////////////////////////////
	// shortTermSuspensionsPacificIslanderPercent //
	////////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsPacificIslanderPercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsPacificIslanderPercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsPacificIslanderPercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsPacificIslanderPercent").o(shortTermSuspensionsPacificIslanderPercent);

	/**	<br/> The entity shortTermSuspensionsPacificIslanderPercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsPacificIslanderPercent">Find the entity shortTermSuspensionsPacificIslanderPercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsPacificIslanderPercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent;
	}

	public void setShortTermSuspensionsPacificIslanderPercent(BigDecimal shortTermSuspensionsPacificIslanderPercent) {
		this.shortTermSuspensionsPacificIslanderPercent = shortTermSuspensionsPacificIslanderPercent;
		this.shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderPercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderPercent(Double o) {
			this.shortTermSuspensionsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderPercent(Integer o) {
			this.shortTermSuspensionsPacificIslanderPercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsPacificIslanderPercentInit() {
		if(!shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized) {
			_shortTermSuspensionsPacificIslanderPercent(shortTermSuspensionsPacificIslanderPercentWrap);
			if(shortTermSuspensionsPacificIslanderPercent == null)
				setShortTermSuspensionsPacificIslanderPercent(shortTermSuspensionsPacificIslanderPercentWrap.o);
		}
		shortTermSuspensionsPacificIslanderPercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent == null ? null : shortTermSuspensionsPacificIslanderPercent.doubleValue();
	}

	public String strShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent == null ? "" : shortTermSuspensionsPacificIslanderPercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent == null ? "" : shortTermSuspensionsPacificIslanderPercent.toString();
	}

	public String nomAffichageShortTermSuspensionsPacificIslanderPercent() {
		return "short-term suspensions Pacific Islanders percent";
	}

	public String htmTooltipShortTermSuspensionsPacificIslanderPercent() {
		return null;
	}

	public String htmShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsPacificIslanderPercent());
	}

	public void inputShortTermSuspensionsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsPacificIslanderPercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Pacific Islanders percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsPacificIslanderPercent ").f().sx(strShortTermSuspensionsPacificIslanderPercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////////////
	// shortTermSuspensionsPacificIslanderRate //
	/////////////////////////////////////////////

	/**	 The entity shortTermSuspensionsPacificIslanderRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsPacificIslanderRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsPacificIslanderRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsPacificIslanderRate").o(shortTermSuspensionsPacificIslanderRate);

	/**	<br/> The entity shortTermSuspensionsPacificIslanderRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsPacificIslanderRate">Find the entity shortTermSuspensionsPacificIslanderRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsPacificIslanderRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate;
	}

	public void setShortTermSuspensionsPacificIslanderRate(BigDecimal shortTermSuspensionsPacificIslanderRate) {
		this.shortTermSuspensionsPacificIslanderRate = shortTermSuspensionsPacificIslanderRate;
		this.shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsPacificIslanderRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderRate(Double o) {
			this.shortTermSuspensionsPacificIslanderRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsPacificIslanderRate(Integer o) {
			this.shortTermSuspensionsPacificIslanderRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsPacificIslanderRateInit() {
		if(!shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized) {
			_shortTermSuspensionsPacificIslanderRate(shortTermSuspensionsPacificIslanderRateWrap);
			if(shortTermSuspensionsPacificIslanderRate == null)
				setShortTermSuspensionsPacificIslanderRate(shortTermSuspensionsPacificIslanderRateWrap.o);
		}
		shortTermSuspensionsPacificIslanderRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate == null ? null : shortTermSuspensionsPacificIslanderRate.doubleValue();
	}

	public String strShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate == null ? "" : shortTermSuspensionsPacificIslanderRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate == null ? "" : shortTermSuspensionsPacificIslanderRate.toString();
	}

	public String nomAffichageShortTermSuspensionsPacificIslanderRate() {
		return "short-term suspensions Pacific Islanders rate";
	}

	public String htmTooltipShortTermSuspensionsPacificIslanderRate() {
		return null;
	}

	public String htmShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsPacificIslanderRate());
	}

	public void inputShortTermSuspensionsPacificIslanderRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsPacificIslanderRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Pacific Islanders rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsPacificIslanderRate ").f().sx(strShortTermSuspensionsPacificIslanderRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////////
	// shortTermSuspensionsWhiteFemale //
	/////////////////////////////////////

	/**	 The entity shortTermSuspensionsWhiteFemale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsWhiteFemale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsWhiteFemaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsWhiteFemale").o(shortTermSuspensionsWhiteFemale);

	/**	<br/> The entity shortTermSuspensionsWhiteFemale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsWhiteFemale">Find the entity shortTermSuspensionsWhiteFemale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsWhiteFemale(Wrap<Long> c);

	public Long getShortTermSuspensionsWhiteFemale() {
		return shortTermSuspensionsWhiteFemale;
	}

	public void setShortTermSuspensionsWhiteFemale(Long shortTermSuspensionsWhiteFemale) {
		this.shortTermSuspensionsWhiteFemale = shortTermSuspensionsWhiteFemale;
		this.shortTermSuspensionsWhiteFemaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsWhiteFemale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsWhiteFemale = Long.parseLong(o);
		this.shortTermSuspensionsWhiteFemaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsWhiteFemaleInit() {
		if(!shortTermSuspensionsWhiteFemaleWrap.alreadyInitialized) {
			_shortTermSuspensionsWhiteFemale(shortTermSuspensionsWhiteFemaleWrap);
			if(shortTermSuspensionsWhiteFemale == null)
				setShortTermSuspensionsWhiteFemale(shortTermSuspensionsWhiteFemaleWrap.o);
		}
		shortTermSuspensionsWhiteFemaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsWhiteFemale() {
		return shortTermSuspensionsWhiteFemale;
	}

	public String strShortTermSuspensionsWhiteFemale() {
		return shortTermSuspensionsWhiteFemale == null ? "" : shortTermSuspensionsWhiteFemale.toString();
	}

	public String jsonShortTermSuspensionsWhiteFemale() {
		return shortTermSuspensionsWhiteFemale == null ? "" : shortTermSuspensionsWhiteFemale.toString();
	}

	public String nomAffichageShortTermSuspensionsWhiteFemale() {
		return "short-term suspensions White female";
	}

	public String htmTooltipShortTermSuspensionsWhiteFemale() {
		return null;
	}

	public String htmShortTermSuspensionsWhiteFemale() {
		return shortTermSuspensionsWhiteFemale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsWhiteFemale());
	}

	public void inputShortTermSuspensionsWhiteFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions White female")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsWhiteFemale classReportCard inputReportCard", pk, "ShortTermSuspensionsWhiteFemale w3-input w3-border ");
					a("name", "setShortTermSuspensionsWhiteFemale");
				} else {
					a("class", "valueShortTermSuspensionsWhiteFemale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsWhiteFemale w3-input w3-border ");
					a("name", "shortTermSuspensionsWhiteFemale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsWhiteFemale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale')); }); ");
				}
				a("value", strShortTermSuspensionsWhiteFemale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsWhiteFemale ").f().sx(htmShortTermSuspensionsWhiteFemale()).g("span");
		}
	}

	public void htmShortTermSuspensionsWhiteFemale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsWhiteFemale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale").a("class", "").f().sx("short-term suspensions White female").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsWhiteFemale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale')); $('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsWhiteFemale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteFemale')); }); ")
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

	///////////////////////////////////
	// shortTermSuspensionsWhiteMale //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsWhiteMale
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsWhiteMale;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsWhiteMaleWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsWhiteMale").o(shortTermSuspensionsWhiteMale);

	/**	<br/> The entity shortTermSuspensionsWhiteMale
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsWhiteMale">Find the entity shortTermSuspensionsWhiteMale in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsWhiteMale(Wrap<Long> c);

	public Long getShortTermSuspensionsWhiteMale() {
		return shortTermSuspensionsWhiteMale;
	}

	public void setShortTermSuspensionsWhiteMale(Long shortTermSuspensionsWhiteMale) {
		this.shortTermSuspensionsWhiteMale = shortTermSuspensionsWhiteMale;
		this.shortTermSuspensionsWhiteMaleWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsWhiteMale(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsWhiteMale = Long.parseLong(o);
		this.shortTermSuspensionsWhiteMaleWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsWhiteMaleInit() {
		if(!shortTermSuspensionsWhiteMaleWrap.alreadyInitialized) {
			_shortTermSuspensionsWhiteMale(shortTermSuspensionsWhiteMaleWrap);
			if(shortTermSuspensionsWhiteMale == null)
				setShortTermSuspensionsWhiteMale(shortTermSuspensionsWhiteMaleWrap.o);
		}
		shortTermSuspensionsWhiteMaleWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsWhiteMale() {
		return shortTermSuspensionsWhiteMale;
	}

	public String strShortTermSuspensionsWhiteMale() {
		return shortTermSuspensionsWhiteMale == null ? "" : shortTermSuspensionsWhiteMale.toString();
	}

	public String jsonShortTermSuspensionsWhiteMale() {
		return shortTermSuspensionsWhiteMale == null ? "" : shortTermSuspensionsWhiteMale.toString();
	}

	public String nomAffichageShortTermSuspensionsWhiteMale() {
		return "short-term suspensions White male";
	}

	public String htmTooltipShortTermSuspensionsWhiteMale() {
		return null;
	}

	public String htmShortTermSuspensionsWhiteMale() {
		return shortTermSuspensionsWhiteMale == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsWhiteMale());
	}

	public void inputShortTermSuspensionsWhiteMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "short-term suspensions White male")
				.a("id", classApiMethodMethod, "_shortTermSuspensionsWhiteMale");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setShortTermSuspensionsWhiteMale classReportCard inputReportCard", pk, "ShortTermSuspensionsWhiteMale w3-input w3-border ");
					a("name", "setShortTermSuspensionsWhiteMale");
				} else {
					a("class", "valueShortTermSuspensionsWhiteMale w3-input w3-border classReportCard inputReportCard", pk, "ShortTermSuspensionsWhiteMale w3-input w3-border ");
					a("name", "shortTermSuspensionsWhiteMale");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setShortTermSuspensionsWhiteMale', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale')); }); ");
				}
				a("value", strShortTermSuspensionsWhiteMale())
			.fg();

		} else {
			e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsWhiteMale ").f().sx(htmShortTermSuspensionsWhiteMale()).g("span");
		}
	}

	public void htmShortTermSuspensionsWhiteMale(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "ReportCardShortTermSuspensionsWhiteMale").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_shortTermSuspensionsWhiteMale").a("class", "").f().sx("short-term suspensions White male").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputShortTermSuspensionsWhiteMale(classApiMethodMethod);
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
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale')); $('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#ReportCardForm :input[name=pk]').val() }], 'setShortTermSuspensionsWhiteMale', null, function() { addGlow($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale')); }, function() { addError($('#", classApiMethodMethod, "_shortTermSuspensionsWhiteMale')); }); ")
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

	////////////////////////////////////
	// shortTermSuspensionsWhiteTotal //
	////////////////////////////////////

	/**	 The entity shortTermSuspensionsWhiteTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long shortTermSuspensionsWhiteTotal;
	@JsonIgnore
	public Wrap<Long> shortTermSuspensionsWhiteTotalWrap = new Wrap<Long>().p(this).c(Long.class).var("shortTermSuspensionsWhiteTotal").o(shortTermSuspensionsWhiteTotal);

	/**	<br/> The entity shortTermSuspensionsWhiteTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsWhiteTotal">Find the entity shortTermSuspensionsWhiteTotal in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsWhiteTotal(Wrap<Long> c);

	public Long getShortTermSuspensionsWhiteTotal() {
		return shortTermSuspensionsWhiteTotal;
	}

	public void setShortTermSuspensionsWhiteTotal(Long shortTermSuspensionsWhiteTotal) {
		this.shortTermSuspensionsWhiteTotal = shortTermSuspensionsWhiteTotal;
		this.shortTermSuspensionsWhiteTotalWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsWhiteTotal(String o) {
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsWhiteTotal = Long.parseLong(o);
		this.shortTermSuspensionsWhiteTotalWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsWhiteTotalInit() {
		if(!shortTermSuspensionsWhiteTotalWrap.alreadyInitialized) {
			_shortTermSuspensionsWhiteTotal(shortTermSuspensionsWhiteTotalWrap);
			if(shortTermSuspensionsWhiteTotal == null)
				setShortTermSuspensionsWhiteTotal(shortTermSuspensionsWhiteTotalWrap.o);
		}
		shortTermSuspensionsWhiteTotalWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Long solrShortTermSuspensionsWhiteTotal() {
		return shortTermSuspensionsWhiteTotal;
	}

	public String strShortTermSuspensionsWhiteTotal() {
		return shortTermSuspensionsWhiteTotal == null ? "" : shortTermSuspensionsWhiteTotal.toString();
	}

	public String jsonShortTermSuspensionsWhiteTotal() {
		return shortTermSuspensionsWhiteTotal == null ? "" : shortTermSuspensionsWhiteTotal.toString();
	}

	public String nomAffichageShortTermSuspensionsWhiteTotal() {
		return "short-term suspensions Whites total";
	}

	public String htmTooltipShortTermSuspensionsWhiteTotal() {
		return null;
	}

	public String htmShortTermSuspensionsWhiteTotal() {
		return shortTermSuspensionsWhiteTotal == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsWhiteTotal());
	}

	public void inputShortTermSuspensionsWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsWhiteTotal(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Whites total").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsWhiteTotal ").f().sx(strShortTermSuspensionsWhiteTotal()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsWhitePercent //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsWhitePercent
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsWhitePercent;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsWhitePercentWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsWhitePercent").o(shortTermSuspensionsWhitePercent);

	/**	<br/> The entity shortTermSuspensionsWhitePercent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsWhitePercent">Find the entity shortTermSuspensionsWhitePercent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsWhitePercent(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent;
	}

	public void setShortTermSuspensionsWhitePercent(BigDecimal shortTermSuspensionsWhitePercent) {
		this.shortTermSuspensionsWhitePercent = shortTermSuspensionsWhitePercent;
		this.shortTermSuspensionsWhitePercentWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsWhitePercent(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsWhitePercent(Double o) {
			this.shortTermSuspensionsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsWhitePercent(Integer o) {
			this.shortTermSuspensionsWhitePercent = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhitePercentWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsWhitePercentInit() {
		if(!shortTermSuspensionsWhitePercentWrap.alreadyInitialized) {
			_shortTermSuspensionsWhitePercent(shortTermSuspensionsWhitePercentWrap);
			if(shortTermSuspensionsWhitePercent == null)
				setShortTermSuspensionsWhitePercent(shortTermSuspensionsWhitePercentWrap.o);
		}
		shortTermSuspensionsWhitePercentWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent == null ? null : shortTermSuspensionsWhitePercent.doubleValue();
	}

	public String strShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent == null ? "" : shortTermSuspensionsWhitePercent.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent == null ? "" : shortTermSuspensionsWhitePercent.toString();
	}

	public String nomAffichageShortTermSuspensionsWhitePercent() {
		return "short-term suspensions Whites percent";
	}

	public String htmTooltipShortTermSuspensionsWhitePercent() {
		return null;
	}

	public String htmShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsWhitePercent());
	}

	public void inputShortTermSuspensionsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsWhitePercent(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Whites percent").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsWhitePercent ").f().sx(strShortTermSuspensionsWhitePercent()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	///////////////////////////////////
	// shortTermSuspensionsWhiteRate //
	///////////////////////////////////

	/**	 The entity shortTermSuspensionsWhiteRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsWhiteRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsWhiteRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsWhiteRate").o(shortTermSuspensionsWhiteRate);

	/**	<br/> The entity shortTermSuspensionsWhiteRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsWhiteRate">Find the entity shortTermSuspensionsWhiteRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsWhiteRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate;
	}

	public void setShortTermSuspensionsWhiteRate(BigDecimal shortTermSuspensionsWhiteRate) {
		this.shortTermSuspensionsWhiteRate = shortTermSuspensionsWhiteRate;
		this.shortTermSuspensionsWhiteRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsWhiteRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsWhiteRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhiteRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsWhiteRate(Double o) {
			this.shortTermSuspensionsWhiteRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhiteRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsWhiteRate(Integer o) {
			this.shortTermSuspensionsWhiteRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsWhiteRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsWhiteRateInit() {
		if(!shortTermSuspensionsWhiteRateWrap.alreadyInitialized) {
			_shortTermSuspensionsWhiteRate(shortTermSuspensionsWhiteRateWrap);
			if(shortTermSuspensionsWhiteRate == null)
				setShortTermSuspensionsWhiteRate(shortTermSuspensionsWhiteRateWrap.o);
		}
		shortTermSuspensionsWhiteRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate == null ? null : shortTermSuspensionsWhiteRate.doubleValue();
	}

	public String strShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate == null ? "" : shortTermSuspensionsWhiteRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate == null ? "" : shortTermSuspensionsWhiteRate.toString();
	}

	public String nomAffichageShortTermSuspensionsWhiteRate() {
		return "short-term suspensions Whites rate";
	}

	public String htmTooltipShortTermSuspensionsWhiteRate() {
		return null;
	}

	public String htmShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsWhiteRate());
	}

	public void inputShortTermSuspensionsWhiteRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsWhiteRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Whites rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsWhiteRate ").f().sx(strShortTermSuspensionsWhiteRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	/////////////////////////////////
	// shortTermSuspensionsAllRate //
	/////////////////////////////////

	/**	 The entity shortTermSuspensionsAllRate
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsAllRate;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsAllRateWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsAllRate").o(shortTermSuspensionsAllRate);

	/**	<br/> The entity shortTermSuspensionsAllRate
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsAllRate">Find the entity shortTermSuspensionsAllRate in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsAllRate(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate;
	}

	public void setShortTermSuspensionsAllRate(BigDecimal shortTermSuspensionsAllRate) {
		this.shortTermSuspensionsAllRate = shortTermSuspensionsAllRate;
		this.shortTermSuspensionsAllRateWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsAllRate(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsAllRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAllRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAllRate(Double o) {
			this.shortTermSuspensionsAllRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAllRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsAllRate(Integer o) {
			this.shortTermSuspensionsAllRate = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsAllRateWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsAllRateInit() {
		if(!shortTermSuspensionsAllRateWrap.alreadyInitialized) {
			_shortTermSuspensionsAllRate(shortTermSuspensionsAllRateWrap);
			if(shortTermSuspensionsAllRate == null)
				setShortTermSuspensionsAllRate(shortTermSuspensionsAllRateWrap.o);
		}
		shortTermSuspensionsAllRateWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate == null ? null : shortTermSuspensionsAllRate.doubleValue();
	}

	public String strShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate == null ? "" : shortTermSuspensionsAllRate.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate == null ? "" : shortTermSuspensionsAllRate.toString();
	}

	public String nomAffichageShortTermSuspensionsAllRate() {
		return "short-term suspensions Pacific Islanders rate";
	}

	public String htmTooltipShortTermSuspensionsAllRate() {
		return null;
	}

	public String htmShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsAllRate());
	}

	public void inputShortTermSuspensionsAllRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsAllRate(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions Pacific Islanders rate").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsAllRate ").f().sx(strShortTermSuspensionsAllRate()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////////////////////////////
	// shortTermSuspensionsBlackVsWhite //
	//////////////////////////////////////

	/**	 The entity shortTermSuspensionsBlackVsWhite
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal shortTermSuspensionsBlackVsWhite;
	@JsonIgnore
	public Wrap<BigDecimal> shortTermSuspensionsBlackVsWhiteWrap = new Wrap<BigDecimal>().p(this).c(BigDecimal.class).var("shortTermSuspensionsBlackVsWhite").o(shortTermSuspensionsBlackVsWhite);

	/**	<br/> The entity shortTermSuspensionsBlackVsWhite
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:shortTermSuspensionsBlackVsWhite">Find the entity shortTermSuspensionsBlackVsWhite in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _shortTermSuspensionsBlackVsWhite(Wrap<BigDecimal> c);

	public BigDecimal getShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite;
	}

	public void setShortTermSuspensionsBlackVsWhite(BigDecimal shortTermSuspensionsBlackVsWhite) {
		this.shortTermSuspensionsBlackVsWhite = shortTermSuspensionsBlackVsWhite;
		this.shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized = true;
	}
	public ReportCard setShortTermSuspensionsBlackVsWhite(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.shortTermSuspensionsBlackVsWhite = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackVsWhite(Double o) {
			this.shortTermSuspensionsBlackVsWhite = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	public ReportCard setShortTermSuspensionsBlackVsWhite(Integer o) {
			this.shortTermSuspensionsBlackVsWhite = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING);
		this.shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard shortTermSuspensionsBlackVsWhiteInit() {
		if(!shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized) {
			_shortTermSuspensionsBlackVsWhite(shortTermSuspensionsBlackVsWhiteWrap);
			if(shortTermSuspensionsBlackVsWhite == null)
				setShortTermSuspensionsBlackVsWhite(shortTermSuspensionsBlackVsWhiteWrap.o);
		}
		shortTermSuspensionsBlackVsWhiteWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Double solrShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite == null ? null : shortTermSuspensionsBlackVsWhite.doubleValue();
	}

	public String strShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite == null ? "" : shortTermSuspensionsBlackVsWhite.setScale(2, RoundingMode.CEILING).toString();
	}

	public String jsonShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite == null ? "" : shortTermSuspensionsBlackVsWhite.toString();
	}

	public String nomAffichageShortTermSuspensionsBlackVsWhite() {
		return "short-term suspensions black vs white";
	}

	public String htmTooltipShortTermSuspensionsBlackVsWhite() {
		return null;
	}

	public String htmShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite == null ? "" : StringEscapeUtils.escapeHtml4(strShortTermSuspensionsBlackVsWhite());
	}

	public void inputShortTermSuspensionsBlackVsWhite(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
	}

	public void htmShortTermSuspensionsBlackVsWhite(String classApiMethodMethod) {
		ReportCard s = (ReportCard)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("class", "").f().sx("short-term suspensions black vs white").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").a("class", "varReportCard", pk, "ShortTermSuspensionsBlackVsWhite ").f().sx(strShortTermSuspensionsBlackVsWhite()).g("span");
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

	/////////////
	// stateId //
	/////////////

	/**	 The entity stateId
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String stateId;
	@JsonIgnore
	public Wrap<String> stateIdWrap = new Wrap<String>().p(this).c(String.class).var("stateId").o(stateId);

	/**	<br/> The entity stateId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateId">Find the entity stateId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stateId(Wrap<String> c);

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
		this.stateIdWrap.alreadyInitialized = true;
	}
	protected ReportCard stateIdInit() {
		if(!stateIdWrap.alreadyInitialized) {
			_stateId(stateIdWrap);
			if(stateId == null)
				setStateId(stateIdWrap.o);
		}
		stateIdWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrStateId() {
		return stateId;
	}

	public String strStateId() {
		return stateId == null ? "" : stateId;
	}

	public String jsonStateId() {
		return stateId == null ? "" : stateId;
	}

	public String nomAffichageStateId() {
		return null;
	}

	public String htmTooltipStateId() {
		return null;
	}

	public String htmStateId() {
		return stateId == null ? "" : StringEscapeUtils.escapeHtml4(strStateId());
	}

	//////////////
	// agencyId //
	//////////////

	/**	 The entity agencyId
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyId;
	@JsonIgnore
	public Wrap<String> agencyIdWrap = new Wrap<String>().p(this).c(String.class).var("agencyId").o(agencyId);

	/**	<br/> The entity agencyId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyId">Find the entity agencyId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyId(Wrap<String> c);

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
		this.agencyIdWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyIdInit() {
		if(!agencyIdWrap.alreadyInitialized) {
			_agencyId(agencyIdWrap);
			if(agencyId == null)
				setAgencyId(agencyIdWrap.o);
		}
		agencyIdWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyId() {
		return agencyId;
	}

	public String strAgencyId() {
		return agencyId == null ? "" : agencyId;
	}

	public String jsonAgencyId() {
		return agencyId == null ? "" : agencyId;
	}

	public String nomAffichageAgencyId() {
		return null;
	}

	public String htmTooltipAgencyId() {
		return null;
	}

	public String htmAgencyId() {
		return agencyId == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyId());
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
	// agencyName //
	////////////////

	/**	 The entity agencyName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyName;
	@JsonIgnore
	public Wrap<String> agencyNameWrap = new Wrap<String>().p(this).c(String.class).var("agencyName").o(agencyName);

	/**	<br/> The entity agencyName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyName">Find the entity agencyName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyName(Wrap<String> c);

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
		this.agencyNameWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyNameInit() {
		if(!agencyNameWrap.alreadyInitialized) {
			_agencyName(agencyNameWrap);
			if(agencyName == null)
				setAgencyName(agencyNameWrap.o);
		}
		agencyNameWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyName() {
		return agencyName;
	}

	public String strAgencyName() {
		return agencyName == null ? "" : agencyName;
	}

	public String jsonAgencyName() {
		return agencyName == null ? "" : agencyName;
	}

	public String nomAffichageAgencyName() {
		return null;
	}

	public String htmTooltipAgencyName() {
		return null;
	}

	public String htmAgencyName() {
		return agencyName == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyName());
	}

	////////////////////////
	// agencyCompleteName //
	////////////////////////

	/**	 The entity agencyCompleteName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyCompleteName;
	@JsonIgnore
	public Wrap<String> agencyCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("agencyCompleteName").o(agencyCompleteName);

	/**	<br/> The entity agencyCompleteName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyCompleteName">Find the entity agencyCompleteName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyCompleteName(Wrap<String> c);

	public String getAgencyCompleteName() {
		return agencyCompleteName;
	}

	public void setAgencyCompleteName(String agencyCompleteName) {
		this.agencyCompleteName = agencyCompleteName;
		this.agencyCompleteNameWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyCompleteNameInit() {
		if(!agencyCompleteNameWrap.alreadyInitialized) {
			_agencyCompleteName(agencyCompleteNameWrap);
			if(agencyCompleteName == null)
				setAgencyCompleteName(agencyCompleteNameWrap.o);
		}
		agencyCompleteNameWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyCompleteName() {
		return agencyCompleteName;
	}

	public String strAgencyCompleteName() {
		return agencyCompleteName == null ? "" : agencyCompleteName;
	}

	public String jsonAgencyCompleteName() {
		return agencyCompleteName == null ? "" : agencyCompleteName;
	}

	public String nomAffichageAgencyCompleteName() {
		return null;
	}

	public String htmTooltipAgencyCompleteName() {
		return null;
	}

	public String htmAgencyCompleteName() {
		return agencyCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyCompleteName());
	}

	///////////////////////
	// reportCardNumber_ //
	///////////////////////

	/**	 The entity reportCardNumber_
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportCardNumber_;
	@JsonIgnore
	public Wrap<Integer> reportCardNumber_Wrap = new Wrap<Integer>().p(this).c(Integer.class).var("reportCardNumber_").o(reportCardNumber_);

	/**	<br/> The entity reportCardNumber_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardNumber_">Find the entity reportCardNumber_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardNumber_(Wrap<Integer> c);

	public Integer getReportCardNumber_() {
		return reportCardNumber_;
	}

	public void setReportCardNumber_(Integer reportCardNumber_) {
		this.reportCardNumber_ = reportCardNumber_;
		this.reportCardNumber_Wrap.alreadyInitialized = true;
	}
	public ReportCard setReportCardNumber_(String o) {
		if(NumberUtils.isParsable(o))
			this.reportCardNumber_ = Integer.parseInt(o);
		this.reportCardNumber_Wrap.alreadyInitialized = true;
		return (ReportCard)this;
	}
	protected ReportCard reportCardNumber_Init() {
		if(!reportCardNumber_Wrap.alreadyInitialized) {
			_reportCardNumber_(reportCardNumber_Wrap);
			if(reportCardNumber_ == null)
				setReportCardNumber_(reportCardNumber_Wrap.o);
		}
		reportCardNumber_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public Integer solrReportCardNumber_() {
		return reportCardNumber_;
	}

	public String strReportCardNumber_() {
		return reportCardNumber_ == null ? "" : reportCardNumber_.toString();
	}

	public String jsonReportCardNumber_() {
		return reportCardNumber_ == null ? "" : reportCardNumber_.toString();
	}

	public String nomAffichageReportCardNumber_() {
		return null;
	}

	public String htmTooltipReportCardNumber_() {
		return null;
	}

	public String htmReportCardNumber_() {
		return reportCardNumber_ == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardNumber_());
	}

	///////////////////////
	// reportCardStates_ //
	///////////////////////

	/**	 The entity reportCardStates_
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<ReportCard>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<ReportCard> reportCardStates_ = new ArrayList<ReportCard>();
	@JsonIgnore
	public Wrap<List<ReportCard>> reportCardStates_Wrap = new Wrap<List<ReportCard>>().p(this).c(List.class).var("reportCardStates_").o(reportCardStates_);

	/**	<br/> The entity reportCardStates_
	 *  It is constructed before being initialized with the constructor by default List<ReportCard>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStates_">Find the entity reportCardStates_ in Solr</a>
	 * <br/>
	 * @param reportCardStates_ is the entity already constructed. 
	 **/
	protected abstract void _reportCardStates_(List<ReportCard> l);

	public List<ReportCard> getReportCardStates_() {
		return reportCardStates_;
	}

	public void setReportCardStates_(List<ReportCard> reportCardStates_) {
		this.reportCardStates_ = reportCardStates_;
		this.reportCardStates_Wrap.alreadyInitialized = true;
	}
	public ReportCard addReportCardStates_(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCardStates_(o);
		}
		return (ReportCard)this;
	}
	public ReportCard addReportCardStates_(ReportCard o) {
		if(o != null && !reportCardStates_.contains(o))
			this.reportCardStates_.add(o);
		return (ReportCard)this;
	}
	protected ReportCard reportCardStates_Init() {
		if(!reportCardStates_Wrap.alreadyInitialized) {
			_reportCardStates_(reportCardStates_);
		}
		reportCardStates_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	/////////////////////////
	// reportCardAgencies_ //
	/////////////////////////

	/**	 The entity reportCardAgencies_
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<ReportCard>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<ReportCard> reportCardAgencies_ = new ArrayList<ReportCard>();
	@JsonIgnore
	public Wrap<List<ReportCard>> reportCardAgencies_Wrap = new Wrap<List<ReportCard>>().p(this).c(List.class).var("reportCardAgencies_").o(reportCardAgencies_);

	/**	<br/> The entity reportCardAgencies_
	 *  It is constructed before being initialized with the constructor by default List<ReportCard>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardAgencies_">Find the entity reportCardAgencies_ in Solr</a>
	 * <br/>
	 * @param reportCardAgencies_ is the entity already constructed. 
	 **/
	protected abstract void _reportCardAgencies_(List<ReportCard> l);

	public List<ReportCard> getReportCardAgencies_() {
		return reportCardAgencies_;
	}

	public void setReportCardAgencies_(List<ReportCard> reportCardAgencies_) {
		this.reportCardAgencies_ = reportCardAgencies_;
		this.reportCardAgencies_Wrap.alreadyInitialized = true;
	}
	public ReportCard addReportCardAgencies_(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCardAgencies_(o);
		}
		return (ReportCard)this;
	}
	public ReportCard addReportCardAgencies_(ReportCard o) {
		if(o != null && !reportCardAgencies_.contains(o))
			this.reportCardAgencies_.add(o);
		return (ReportCard)this;
	}
	protected ReportCard reportCardAgencies_Init() {
		if(!reportCardAgencies_Wrap.alreadyInitialized) {
			_reportCardAgencies_(reportCardAgencies_);
		}
		reportCardAgencies_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	////////////////////////////
	// reportCardReportCards_ //
	////////////////////////////

	/**	 The entity reportCardReportCards_
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<ReportCard>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<ReportCard> reportCardReportCards_ = new ArrayList<ReportCard>();
	@JsonIgnore
	public Wrap<List<ReportCard>> reportCardReportCards_Wrap = new Wrap<List<ReportCard>>().p(this).c(List.class).var("reportCardReportCards_").o(reportCardReportCards_);

	/**	<br/> The entity reportCardReportCards_
	 *  It is constructed before being initialized with the constructor by default List<ReportCard>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardReportCards_">Find the entity reportCardReportCards_ in Solr</a>
	 * <br/>
	 * @param reportCardReportCards_ is the entity already constructed. 
	 **/
	protected abstract void _reportCardReportCards_(List<ReportCard> l);

	public List<ReportCard> getReportCardReportCards_() {
		return reportCardReportCards_;
	}

	public void setReportCardReportCards_(List<ReportCard> reportCardReportCards_) {
		this.reportCardReportCards_ = reportCardReportCards_;
		this.reportCardReportCards_Wrap.alreadyInitialized = true;
	}
	public ReportCard addReportCardReportCards_(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCardReportCards_(o);
		}
		return (ReportCard)this;
	}
	public ReportCard addReportCardReportCards_(ReportCard o) {
		if(o != null && !reportCardReportCards_.contains(o))
			this.reportCardReportCards_.add(o);
		return (ReportCard)this;
	}
	protected ReportCard reportCardReportCards_Init() {
		if(!reportCardReportCards_Wrap.alreadyInitialized) {
			_reportCardReportCards_(reportCardReportCards_);
		}
		reportCardReportCards_Wrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	/////////////////////////////
	// agencyDemographicsGraph //
	/////////////////////////////

	/**	 The entity agencyDemographicsGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyDemographicsGraph;
	@JsonIgnore
	public Wrap<String> agencyDemographicsGraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyDemographicsGraph").o(agencyDemographicsGraph);

	/**	<br/> The entity agencyDemographicsGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyDemographicsGraph">Find the entity agencyDemographicsGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyDemographicsGraph(Wrap<String> w);

	public String getAgencyDemographicsGraph() {
		return agencyDemographicsGraph;
	}

	public void setAgencyDemographicsGraph(String agencyDemographicsGraph) {
		this.agencyDemographicsGraph = agencyDemographicsGraph;
		this.agencyDemographicsGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyDemographicsGraphInit() {
		if(!agencyDemographicsGraphWrap.alreadyInitialized) {
			_agencyDemographicsGraph(agencyDemographicsGraphWrap);
			if(agencyDemographicsGraph == null)
				setAgencyDemographicsGraph(agencyDemographicsGraphWrap.o);
		}
		agencyDemographicsGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyDemographicsGraph() {
		return agencyDemographicsGraph;
	}

	public String strAgencyDemographicsGraph() {
		return agencyDemographicsGraph == null ? "" : agencyDemographicsGraph;
	}

	public String jsonAgencyDemographicsGraph() {
		return agencyDemographicsGraph == null ? "" : agencyDemographicsGraph;
	}

	public String nomAffichageAgencyDemographicsGraph() {
		return null;
	}

	public String htmTooltipAgencyDemographicsGraph() {
		return null;
	}

	public String htmAgencyDemographicsGraph() {
		return agencyDemographicsGraph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyDemographicsGraph());
	}

	///////////////////////////////
	// agencyStudentsByRaceGraph //
	///////////////////////////////

	/**	 The entity agencyStudentsByRaceGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyStudentsByRaceGraph;
	@JsonIgnore
	public Wrap<String> agencyStudentsByRaceGraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyStudentsByRaceGraph").o(agencyStudentsByRaceGraph);

	/**	<br/> The entity agencyStudentsByRaceGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyStudentsByRaceGraph">Find the entity agencyStudentsByRaceGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyStudentsByRaceGraph(Wrap<String> w);

	public String getAgencyStudentsByRaceGraph() {
		return agencyStudentsByRaceGraph;
	}

	public void setAgencyStudentsByRaceGraph(String agencyStudentsByRaceGraph) {
		this.agencyStudentsByRaceGraph = agencyStudentsByRaceGraph;
		this.agencyStudentsByRaceGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyStudentsByRaceGraphInit() {
		if(!agencyStudentsByRaceGraphWrap.alreadyInitialized) {
			_agencyStudentsByRaceGraph(agencyStudentsByRaceGraphWrap);
			if(agencyStudentsByRaceGraph == null)
				setAgencyStudentsByRaceGraph(agencyStudentsByRaceGraphWrap.o);
		}
		agencyStudentsByRaceGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyStudentsByRaceGraph() {
		return agencyStudentsByRaceGraph;
	}

	public String strAgencyStudentsByRaceGraph() {
		return agencyStudentsByRaceGraph == null ? "" : agencyStudentsByRaceGraph;
	}

	public String jsonAgencyStudentsByRaceGraph() {
		return agencyStudentsByRaceGraph == null ? "" : agencyStudentsByRaceGraph;
	}

	public String nomAffichageAgencyStudentsByRaceGraph() {
		return null;
	}

	public String htmTooltipAgencyStudentsByRaceGraph() {
		return null;
	}

	public String htmAgencyStudentsByRaceGraph() {
		return agencyStudentsByRaceGraph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyStudentsByRaceGraph());
	}

	///////////////////////////////
	// agencyTeachersByRaceGraph //
	///////////////////////////////

	/**	 The entity agencyTeachersByRaceGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyTeachersByRaceGraph;
	@JsonIgnore
	public Wrap<String> agencyTeachersByRaceGraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyTeachersByRaceGraph").o(agencyTeachersByRaceGraph);

	/**	<br/> The entity agencyTeachersByRaceGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyTeachersByRaceGraph">Find the entity agencyTeachersByRaceGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyTeachersByRaceGraph(Wrap<String> w);

	public String getAgencyTeachersByRaceGraph() {
		return agencyTeachersByRaceGraph;
	}

	public void setAgencyTeachersByRaceGraph(String agencyTeachersByRaceGraph) {
		this.agencyTeachersByRaceGraph = agencyTeachersByRaceGraph;
		this.agencyTeachersByRaceGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyTeachersByRaceGraphInit() {
		if(!agencyTeachersByRaceGraphWrap.alreadyInitialized) {
			_agencyTeachersByRaceGraph(agencyTeachersByRaceGraphWrap);
			if(agencyTeachersByRaceGraph == null)
				setAgencyTeachersByRaceGraph(agencyTeachersByRaceGraphWrap.o);
		}
		agencyTeachersByRaceGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyTeachersByRaceGraph() {
		return agencyTeachersByRaceGraph;
	}

	public String strAgencyTeachersByRaceGraph() {
		return agencyTeachersByRaceGraph == null ? "" : agencyTeachersByRaceGraph;
	}

	public String jsonAgencyTeachersByRaceGraph() {
		return agencyTeachersByRaceGraph == null ? "" : agencyTeachersByRaceGraph;
	}

	public String nomAffichageAgencyTeachersByRaceGraph() {
		return null;
	}

	public String htmTooltipAgencyTeachersByRaceGraph() {
		return null;
	}

	public String htmAgencyTeachersByRaceGraph() {
		return agencyTeachersByRaceGraph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyTeachersByRaceGraph());
	}

	///////////////////////////
	// agencyGrades3To8Graph //
	///////////////////////////

	/**	 The entity agencyGrades3To8Graph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyGrades3To8Graph;
	@JsonIgnore
	public Wrap<String> agencyGrades3To8GraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyGrades3To8Graph").o(agencyGrades3To8Graph);

	/**	<br/> The entity agencyGrades3To8Graph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyGrades3To8Graph">Find the entity agencyGrades3To8Graph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyGrades3To8Graph(Wrap<String> w);

	public String getAgencyGrades3To8Graph() {
		return agencyGrades3To8Graph;
	}

	public void setAgencyGrades3To8Graph(String agencyGrades3To8Graph) {
		this.agencyGrades3To8Graph = agencyGrades3To8Graph;
		this.agencyGrades3To8GraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyGrades3To8GraphInit() {
		if(!agencyGrades3To8GraphWrap.alreadyInitialized) {
			_agencyGrades3To8Graph(agencyGrades3To8GraphWrap);
			if(agencyGrades3To8Graph == null)
				setAgencyGrades3To8Graph(agencyGrades3To8GraphWrap.o);
		}
		agencyGrades3To8GraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyGrades3To8Graph() {
		return agencyGrades3To8Graph;
	}

	public String strAgencyGrades3To8Graph() {
		return agencyGrades3To8Graph == null ? "" : agencyGrades3To8Graph;
	}

	public String jsonAgencyGrades3To8Graph() {
		return agencyGrades3To8Graph == null ? "" : agencyGrades3To8Graph;
	}

	public String nomAffichageAgencyGrades3To8Graph() {
		return null;
	}

	public String htmTooltipAgencyGrades3To8Graph() {
		return null;
	}

	public String htmAgencyGrades3To8Graph() {
		return agencyGrades3To8Graph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyGrades3To8Graph());
	}

	////////////////////////////
	// agencyGrades9To12Graph //
	////////////////////////////

	/**	 The entity agencyGrades9To12Graph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyGrades9To12Graph;
	@JsonIgnore
	public Wrap<String> agencyGrades9To12GraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyGrades9To12Graph").o(agencyGrades9To12Graph);

	/**	<br/> The entity agencyGrades9To12Graph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyGrades9To12Graph">Find the entity agencyGrades9To12Graph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyGrades9To12Graph(Wrap<String> w);

	public String getAgencyGrades9To12Graph() {
		return agencyGrades9To12Graph;
	}

	public void setAgencyGrades9To12Graph(String agencyGrades9To12Graph) {
		this.agencyGrades9To12Graph = agencyGrades9To12Graph;
		this.agencyGrades9To12GraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyGrades9To12GraphInit() {
		if(!agencyGrades9To12GraphWrap.alreadyInitialized) {
			_agencyGrades9To12Graph(agencyGrades9To12GraphWrap);
			if(agencyGrades9To12Graph == null)
				setAgencyGrades9To12Graph(agencyGrades9To12GraphWrap.o);
		}
		agencyGrades9To12GraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyGrades9To12Graph() {
		return agencyGrades9To12Graph;
	}

	public String strAgencyGrades9To12Graph() {
		return agencyGrades9To12Graph == null ? "" : agencyGrades9To12Graph;
	}

	public String jsonAgencyGrades9To12Graph() {
		return agencyGrades9To12Graph == null ? "" : agencyGrades9To12Graph;
	}

	public String nomAffichageAgencyGrades9To12Graph() {
		return null;
	}

	public String htmTooltipAgencyGrades9To12Graph() {
		return null;
	}

	public String htmAgencyGrades9To12Graph() {
		return agencyGrades9To12Graph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyGrades9To12Graph());
	}

	//////////////////////////////////////
	// agencyGraduatesWithin4YearsGraph //
	//////////////////////////////////////

	/**	 The entity agencyGraduatesWithin4YearsGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String agencyGraduatesWithin4YearsGraph;
	@JsonIgnore
	public Wrap<String> agencyGraduatesWithin4YearsGraphWrap = new Wrap<String>().p(this).c(String.class).var("agencyGraduatesWithin4YearsGraph").o(agencyGraduatesWithin4YearsGraph);

	/**	<br/> The entity agencyGraduatesWithin4YearsGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyGraduatesWithin4YearsGraph">Find the entity agencyGraduatesWithin4YearsGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _agencyGraduatesWithin4YearsGraph(Wrap<String> w);

	public String getAgencyGraduatesWithin4YearsGraph() {
		return agencyGraduatesWithin4YearsGraph;
	}

	public void setAgencyGraduatesWithin4YearsGraph(String agencyGraduatesWithin4YearsGraph) {
		this.agencyGraduatesWithin4YearsGraph = agencyGraduatesWithin4YearsGraph;
		this.agencyGraduatesWithin4YearsGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard agencyGraduatesWithin4YearsGraphInit() {
		if(!agencyGraduatesWithin4YearsGraphWrap.alreadyInitialized) {
			_agencyGraduatesWithin4YearsGraph(agencyGraduatesWithin4YearsGraphWrap);
			if(agencyGraduatesWithin4YearsGraph == null)
				setAgencyGraduatesWithin4YearsGraph(agencyGraduatesWithin4YearsGraphWrap.o);
		}
		agencyGraduatesWithin4YearsGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrAgencyGraduatesWithin4YearsGraph() {
		return agencyGraduatesWithin4YearsGraph;
	}

	public String strAgencyGraduatesWithin4YearsGraph() {
		return agencyGraduatesWithin4YearsGraph == null ? "" : agencyGraduatesWithin4YearsGraph;
	}

	public String jsonAgencyGraduatesWithin4YearsGraph() {
		return agencyGraduatesWithin4YearsGraph == null ? "" : agencyGraduatesWithin4YearsGraph;
	}

	public String nomAffichageAgencyGraduatesWithin4YearsGraph() {
		return null;
	}

	public String htmTooltipAgencyGraduatesWithin4YearsGraph() {
		return null;
	}

	public String htmAgencyGraduatesWithin4YearsGraph() {
		return agencyGraduatesWithin4YearsGraph == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyGraduatesWithin4YearsGraph());
	}

	////////////////////////////
	// suspensionsByRaceGraph //
	////////////////////////////

	/**	 The entity suspensionsByRaceGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String suspensionsByRaceGraph;
	@JsonIgnore
	public Wrap<String> suspensionsByRaceGraphWrap = new Wrap<String>().p(this).c(String.class).var("suspensionsByRaceGraph").o(suspensionsByRaceGraph);

	/**	<br/> The entity suspensionsByRaceGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:suspensionsByRaceGraph">Find the entity suspensionsByRaceGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _suspensionsByRaceGraph(Wrap<String> w);

	public String getSuspensionsByRaceGraph() {
		return suspensionsByRaceGraph;
	}

	public void setSuspensionsByRaceGraph(String suspensionsByRaceGraph) {
		this.suspensionsByRaceGraph = suspensionsByRaceGraph;
		this.suspensionsByRaceGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard suspensionsByRaceGraphInit() {
		if(!suspensionsByRaceGraphWrap.alreadyInitialized) {
			_suspensionsByRaceGraph(suspensionsByRaceGraphWrap);
			if(suspensionsByRaceGraph == null)
				setSuspensionsByRaceGraph(suspensionsByRaceGraphWrap.o);
		}
		suspensionsByRaceGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrSuspensionsByRaceGraph() {
		return suspensionsByRaceGraph;
	}

	public String strSuspensionsByRaceGraph() {
		return suspensionsByRaceGraph == null ? "" : suspensionsByRaceGraph;
	}

	public String jsonSuspensionsByRaceGraph() {
		return suspensionsByRaceGraph == null ? "" : suspensionsByRaceGraph;
	}

	public String nomAffichageSuspensionsByRaceGraph() {
		return null;
	}

	public String htmTooltipSuspensionsByRaceGraph() {
		return null;
	}

	public String htmSuspensionsByRaceGraph() {
		return suspensionsByRaceGraph == null ? "" : StringEscapeUtils.escapeHtml4(strSuspensionsByRaceGraph());
	}

	////////////////////////////////
	// suspensionRatesByRaceGraph //
	////////////////////////////////

	/**	 The entity suspensionRatesByRaceGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String suspensionRatesByRaceGraph;
	@JsonIgnore
	public Wrap<String> suspensionRatesByRaceGraphWrap = new Wrap<String>().p(this).c(String.class).var("suspensionRatesByRaceGraph").o(suspensionRatesByRaceGraph);

	/**	<br/> The entity suspensionRatesByRaceGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:suspensionRatesByRaceGraph">Find the entity suspensionRatesByRaceGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _suspensionRatesByRaceGraph(Wrap<String> w);

	public String getSuspensionRatesByRaceGraph() {
		return suspensionRatesByRaceGraph;
	}

	public void setSuspensionRatesByRaceGraph(String suspensionRatesByRaceGraph) {
		this.suspensionRatesByRaceGraph = suspensionRatesByRaceGraph;
		this.suspensionRatesByRaceGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard suspensionRatesByRaceGraphInit() {
		if(!suspensionRatesByRaceGraphWrap.alreadyInitialized) {
			_suspensionRatesByRaceGraph(suspensionRatesByRaceGraphWrap);
			if(suspensionRatesByRaceGraph == null)
				setSuspensionRatesByRaceGraph(suspensionRatesByRaceGraphWrap.o);
		}
		suspensionRatesByRaceGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrSuspensionRatesByRaceGraph() {
		return suspensionRatesByRaceGraph;
	}

	public String strSuspensionRatesByRaceGraph() {
		return suspensionRatesByRaceGraph == null ? "" : suspensionRatesByRaceGraph;
	}

	public String jsonSuspensionRatesByRaceGraph() {
		return suspensionRatesByRaceGraph == null ? "" : suspensionRatesByRaceGraph;
	}

	public String nomAffichageSuspensionRatesByRaceGraph() {
		return null;
	}

	public String htmTooltipSuspensionRatesByRaceGraph() {
		return null;
	}

	public String htmSuspensionRatesByRaceGraph() {
		return suspensionRatesByRaceGraph == null ? "" : StringEscapeUtils.escapeHtml4(strSuspensionRatesByRaceGraph());
	}

	//////////////////////////////////////
	// countySchoolBasedComplaintsGraph //
	//////////////////////////////////////

	/**	 The entity countySchoolBasedComplaintsGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String countySchoolBasedComplaintsGraph;
	@JsonIgnore
	public Wrap<String> countySchoolBasedComplaintsGraphWrap = new Wrap<String>().p(this).c(String.class).var("countySchoolBasedComplaintsGraph").o(countySchoolBasedComplaintsGraph);

	/**	<br/> The entity countySchoolBasedComplaintsGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countySchoolBasedComplaintsGraph">Find the entity countySchoolBasedComplaintsGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _countySchoolBasedComplaintsGraph(Wrap<String> w);

	public String getCountySchoolBasedComplaintsGraph() {
		return countySchoolBasedComplaintsGraph;
	}

	public void setCountySchoolBasedComplaintsGraph(String countySchoolBasedComplaintsGraph) {
		this.countySchoolBasedComplaintsGraph = countySchoolBasedComplaintsGraph;
		this.countySchoolBasedComplaintsGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard countySchoolBasedComplaintsGraphInit() {
		if(!countySchoolBasedComplaintsGraphWrap.alreadyInitialized) {
			_countySchoolBasedComplaintsGraph(countySchoolBasedComplaintsGraphWrap);
			if(countySchoolBasedComplaintsGraph == null)
				setCountySchoolBasedComplaintsGraph(countySchoolBasedComplaintsGraphWrap.o);
		}
		countySchoolBasedComplaintsGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrCountySchoolBasedComplaintsGraph() {
		return countySchoolBasedComplaintsGraph;
	}

	public String strCountySchoolBasedComplaintsGraph() {
		return countySchoolBasedComplaintsGraph == null ? "" : countySchoolBasedComplaintsGraph;
	}

	public String jsonCountySchoolBasedComplaintsGraph() {
		return countySchoolBasedComplaintsGraph == null ? "" : countySchoolBasedComplaintsGraph;
	}

	public String nomAffichageCountySchoolBasedComplaintsGraph() {
		return null;
	}

	public String htmTooltipCountySchoolBasedComplaintsGraph() {
		return null;
	}

	public String htmCountySchoolBasedComplaintsGraph() {
		return countySchoolBasedComplaintsGraph == null ? "" : StringEscapeUtils.escapeHtml4(strCountySchoolBasedComplaintsGraph());
	}

	////////////////////////////////
	// schoolBasedComplaintsGraph //
	////////////////////////////////

	/**	 The entity schoolBasedComplaintsGraph
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String schoolBasedComplaintsGraph;
	@JsonIgnore
	public Wrap<String> schoolBasedComplaintsGraphWrap = new Wrap<String>().p(this).c(String.class).var("schoolBasedComplaintsGraph").o(schoolBasedComplaintsGraph);

	/**	<br/> The entity schoolBasedComplaintsGraph
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCard&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:schoolBasedComplaintsGraph">Find the entity schoolBasedComplaintsGraph in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _schoolBasedComplaintsGraph(Wrap<String> w);

	public String getSchoolBasedComplaintsGraph() {
		return schoolBasedComplaintsGraph;
	}

	public void setSchoolBasedComplaintsGraph(String schoolBasedComplaintsGraph) {
		this.schoolBasedComplaintsGraph = schoolBasedComplaintsGraph;
		this.schoolBasedComplaintsGraphWrap.alreadyInitialized = true;
	}
	protected ReportCard schoolBasedComplaintsGraphInit() {
		if(!schoolBasedComplaintsGraphWrap.alreadyInitialized) {
			_schoolBasedComplaintsGraph(schoolBasedComplaintsGraphWrap);
			if(schoolBasedComplaintsGraph == null)
				setSchoolBasedComplaintsGraph(schoolBasedComplaintsGraphWrap.o);
		}
		schoolBasedComplaintsGraphWrap.alreadyInitialized(true);
		return (ReportCard)this;
	}

	public String solrSchoolBasedComplaintsGraph() {
		return schoolBasedComplaintsGraph;
	}

	public String strSchoolBasedComplaintsGraph() {
		return schoolBasedComplaintsGraph == null ? "" : schoolBasedComplaintsGraph;
	}

	public String jsonSchoolBasedComplaintsGraph() {
		return schoolBasedComplaintsGraph == null ? "" : schoolBasedComplaintsGraph;
	}

	public String nomAffichageSchoolBasedComplaintsGraph() {
		return null;
	}

	public String htmTooltipSchoolBasedComplaintsGraph() {
		return null;
	}

	public String htmSchoolBasedComplaintsGraph() {
		return schoolBasedComplaintsGraph == null ? "" : StringEscapeUtils.escapeHtml4(strSchoolBasedComplaintsGraph());
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
		reportCardStartYearStrInit();
		reportCardEndYearInit();
		reportCardYearsStrInit();
		agencySearchInit();
		agency_Init();
		agencyKeyInit();
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
		teachersMaleInit();
		teachersFemaleInit();
		teachersTotalInit();
		teachersWhiteTotalInit();
		teachersWhitePercentInit();
		teachersBlackTotalInit();
		teachersBlackPercentInit();
		teachersOtherTotalInit();
		teachersOtherPercentInit();
		delinquentComplaintsTotalInit();
		delinquentComplaintsAtSchoolInit();
		delinquentComplaintsAtSchoolPercentInit();
		delinquentComplaintsAsianInit();
		delinquentComplaintsAsianPercentInit();
		delinquentComplaintsBlackInit();
		delinquentComplaintsBlackPercentInit();
		delinquentComplaintsHispanicInit();
		delinquentComplaintsHispanicPercentInit();
		delinquentComplaintsMultiRacialInit();
		delinquentComplaintsMultiRacialPercentInit();
		delinquentComplaintsIndianInit();
		delinquentComplaintsIndianPercentInit();
		delinquentComplaintsWhiteInit();
		delinquentComplaintsWhitePercentInit();
		delinquentComplaintsPacificIslanderInit();
		delinquentComplaintsPacificIslanderPercentInit();
		shortTermSuspensionRateInit();
		shortTermSuspensionsTotalInit();
		longTermSuspensionsTotalInit();
		expulsionsTotalInit();
		shortTermSuspensionsAsianFemaleInit();
		shortTermSuspensionsAsianMaleInit();
		shortTermSuspensionsAsianTotalInit();
		shortTermSuspensionsAsianPercentInit();
		shortTermSuspensionsAsianRateInit();
		shortTermSuspensionsBlackFemaleInit();
		shortTermSuspensionsBlackMaleInit();
		shortTermSuspensionsBlackTotalInit();
		shortTermSuspensionsBlackPercentInit();
		shortTermSuspensionsBlackRateInit();
		shortTermSuspensionsHispanicFemaleInit();
		shortTermSuspensionsHispanicMaleInit();
		shortTermSuspensionsHispanicTotalInit();
		shortTermSuspensionsHispanicPercentInit();
		shortTermSuspensionsHispanicRateInit();
		shortTermSuspensionsIndianFemaleInit();
		shortTermSuspensionsIndianMaleInit();
		shortTermSuspensionsIndianTotalInit();
		shortTermSuspensionsIndianPercentInit();
		shortTermSuspensionsIndianRateInit();
		shortTermSuspensionsMultiRacialFemaleInit();
		shortTermSuspensionsMultiRacialMaleInit();
		shortTermSuspensionsMultiRacialTotalInit();
		shortTermSuspensionsMultiRacialPercentInit();
		shortTermSuspensionsMultiRacialRateInit();
		shortTermSuspensionsPacificIslanderFemaleInit();
		shortTermSuspensionsPacificIslanderMaleInit();
		shortTermSuspensionsPacificIslanderTotalInit();
		shortTermSuspensionsPacificIslanderPercentInit();
		shortTermSuspensionsPacificIslanderRateInit();
		shortTermSuspensionsWhiteFemaleInit();
		shortTermSuspensionsWhiteMaleInit();
		shortTermSuspensionsWhiteTotalInit();
		shortTermSuspensionsWhitePercentInit();
		shortTermSuspensionsWhiteRateInit();
		shortTermSuspensionsAllRateInit();
		shortTermSuspensionsBlackVsWhiteInit();
		stateKeyInit();
		stateIdInit();
		agencyIdInit();
		stateNameInit();
		stateAbbreviationInit();
		agencyNameInit();
		agencyCompleteNameInit();
		reportCardNumber_Init();
		reportCardStates_Init();
		reportCardAgencies_Init();
		reportCardReportCards_Init();
		agencyDemographicsGraphInit();
		agencyStudentsByRaceGraphInit();
		agencyTeachersByRaceGraphInit();
		agencyGrades3To8GraphInit();
		agencyGrades9To12GraphInit();
		agencyGraduatesWithin4YearsGraphInit();
		suspensionsByRaceGraphInit();
		suspensionRatesByRaceGraphInit();
		countySchoolBasedComplaintsGraphInit();
		schoolBasedComplaintsGraphInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepReportCard(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportCard(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
		if(agencySearch != null)
			agencySearch.setSiteRequest_(siteRequest_);
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
			case "reportCardStartYearStr":
				return oReportCard.reportCardStartYearStr;
			case "reportCardEndYear":
				return oReportCard.reportCardEndYear;
			case "reportCardYearsStr":
				return oReportCard.reportCardYearsStr;
			case "agencySearch":
				return oReportCard.agencySearch;
			case "agency_":
				return oReportCard.agency_;
			case "agencyKey":
				return oReportCard.agencyKey;
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
			case "teachersMale":
				return oReportCard.teachersMale;
			case "teachersFemale":
				return oReportCard.teachersFemale;
			case "teachersTotal":
				return oReportCard.teachersTotal;
			case "teachersWhiteTotal":
				return oReportCard.teachersWhiteTotal;
			case "teachersWhitePercent":
				return oReportCard.teachersWhitePercent;
			case "teachersBlackTotal":
				return oReportCard.teachersBlackTotal;
			case "teachersBlackPercent":
				return oReportCard.teachersBlackPercent;
			case "teachersOtherTotal":
				return oReportCard.teachersOtherTotal;
			case "teachersOtherPercent":
				return oReportCard.teachersOtherPercent;
			case "delinquentComplaintsTotal":
				return oReportCard.delinquentComplaintsTotal;
			case "delinquentComplaintsAtSchool":
				return oReportCard.delinquentComplaintsAtSchool;
			case "delinquentComplaintsAtSchoolPercent":
				return oReportCard.delinquentComplaintsAtSchoolPercent;
			case "delinquentComplaintsAsian":
				return oReportCard.delinquentComplaintsAsian;
			case "delinquentComplaintsAsianPercent":
				return oReportCard.delinquentComplaintsAsianPercent;
			case "delinquentComplaintsBlack":
				return oReportCard.delinquentComplaintsBlack;
			case "delinquentComplaintsBlackPercent":
				return oReportCard.delinquentComplaintsBlackPercent;
			case "delinquentComplaintsHispanic":
				return oReportCard.delinquentComplaintsHispanic;
			case "delinquentComplaintsHispanicPercent":
				return oReportCard.delinquentComplaintsHispanicPercent;
			case "delinquentComplaintsMultiRacial":
				return oReportCard.delinquentComplaintsMultiRacial;
			case "delinquentComplaintsMultiRacialPercent":
				return oReportCard.delinquentComplaintsMultiRacialPercent;
			case "delinquentComplaintsIndian":
				return oReportCard.delinquentComplaintsIndian;
			case "delinquentComplaintsIndianPercent":
				return oReportCard.delinquentComplaintsIndianPercent;
			case "delinquentComplaintsWhite":
				return oReportCard.delinquentComplaintsWhite;
			case "delinquentComplaintsWhitePercent":
				return oReportCard.delinquentComplaintsWhitePercent;
			case "delinquentComplaintsPacificIslander":
				return oReportCard.delinquentComplaintsPacificIslander;
			case "delinquentComplaintsPacificIslanderPercent":
				return oReportCard.delinquentComplaintsPacificIslanderPercent;
			case "shortTermSuspensionRate":
				return oReportCard.shortTermSuspensionRate;
			case "shortTermSuspensionsTotal":
				return oReportCard.shortTermSuspensionsTotal;
			case "longTermSuspensionsTotal":
				return oReportCard.longTermSuspensionsTotal;
			case "expulsionsTotal":
				return oReportCard.expulsionsTotal;
			case "shortTermSuspensionsAsianFemale":
				return oReportCard.shortTermSuspensionsAsianFemale;
			case "shortTermSuspensionsAsianMale":
				return oReportCard.shortTermSuspensionsAsianMale;
			case "shortTermSuspensionsAsianTotal":
				return oReportCard.shortTermSuspensionsAsianTotal;
			case "shortTermSuspensionsAsianPercent":
				return oReportCard.shortTermSuspensionsAsianPercent;
			case "shortTermSuspensionsAsianRate":
				return oReportCard.shortTermSuspensionsAsianRate;
			case "shortTermSuspensionsBlackFemale":
				return oReportCard.shortTermSuspensionsBlackFemale;
			case "shortTermSuspensionsBlackMale":
				return oReportCard.shortTermSuspensionsBlackMale;
			case "shortTermSuspensionsBlackTotal":
				return oReportCard.shortTermSuspensionsBlackTotal;
			case "shortTermSuspensionsBlackPercent":
				return oReportCard.shortTermSuspensionsBlackPercent;
			case "shortTermSuspensionsBlackRate":
				return oReportCard.shortTermSuspensionsBlackRate;
			case "shortTermSuspensionsHispanicFemale":
				return oReportCard.shortTermSuspensionsHispanicFemale;
			case "shortTermSuspensionsHispanicMale":
				return oReportCard.shortTermSuspensionsHispanicMale;
			case "shortTermSuspensionsHispanicTotal":
				return oReportCard.shortTermSuspensionsHispanicTotal;
			case "shortTermSuspensionsHispanicPercent":
				return oReportCard.shortTermSuspensionsHispanicPercent;
			case "shortTermSuspensionsHispanicRate":
				return oReportCard.shortTermSuspensionsHispanicRate;
			case "shortTermSuspensionsIndianFemale":
				return oReportCard.shortTermSuspensionsIndianFemale;
			case "shortTermSuspensionsIndianMale":
				return oReportCard.shortTermSuspensionsIndianMale;
			case "shortTermSuspensionsIndianTotal":
				return oReportCard.shortTermSuspensionsIndianTotal;
			case "shortTermSuspensionsIndianPercent":
				return oReportCard.shortTermSuspensionsIndianPercent;
			case "shortTermSuspensionsIndianRate":
				return oReportCard.shortTermSuspensionsIndianRate;
			case "shortTermSuspensionsMultiRacialFemale":
				return oReportCard.shortTermSuspensionsMultiRacialFemale;
			case "shortTermSuspensionsMultiRacialMale":
				return oReportCard.shortTermSuspensionsMultiRacialMale;
			case "shortTermSuspensionsMultiRacialTotal":
				return oReportCard.shortTermSuspensionsMultiRacialTotal;
			case "shortTermSuspensionsMultiRacialPercent":
				return oReportCard.shortTermSuspensionsMultiRacialPercent;
			case "shortTermSuspensionsMultiRacialRate":
				return oReportCard.shortTermSuspensionsMultiRacialRate;
			case "shortTermSuspensionsPacificIslanderFemale":
				return oReportCard.shortTermSuspensionsPacificIslanderFemale;
			case "shortTermSuspensionsPacificIslanderMale":
				return oReportCard.shortTermSuspensionsPacificIslanderMale;
			case "shortTermSuspensionsPacificIslanderTotal":
				return oReportCard.shortTermSuspensionsPacificIslanderTotal;
			case "shortTermSuspensionsPacificIslanderPercent":
				return oReportCard.shortTermSuspensionsPacificIslanderPercent;
			case "shortTermSuspensionsPacificIslanderRate":
				return oReportCard.shortTermSuspensionsPacificIslanderRate;
			case "shortTermSuspensionsWhiteFemale":
				return oReportCard.shortTermSuspensionsWhiteFemale;
			case "shortTermSuspensionsWhiteMale":
				return oReportCard.shortTermSuspensionsWhiteMale;
			case "shortTermSuspensionsWhiteTotal":
				return oReportCard.shortTermSuspensionsWhiteTotal;
			case "shortTermSuspensionsWhitePercent":
				return oReportCard.shortTermSuspensionsWhitePercent;
			case "shortTermSuspensionsWhiteRate":
				return oReportCard.shortTermSuspensionsWhiteRate;
			case "shortTermSuspensionsAllRate":
				return oReportCard.shortTermSuspensionsAllRate;
			case "shortTermSuspensionsBlackVsWhite":
				return oReportCard.shortTermSuspensionsBlackVsWhite;
			case "stateKey":
				return oReportCard.stateKey;
			case "stateId":
				return oReportCard.stateId;
			case "agencyId":
				return oReportCard.agencyId;
			case "stateName":
				return oReportCard.stateName;
			case "stateAbbreviation":
				return oReportCard.stateAbbreviation;
			case "agencyName":
				return oReportCard.agencyName;
			case "agencyCompleteName":
				return oReportCard.agencyCompleteName;
			case "reportCardNumber_":
				return oReportCard.reportCardNumber_;
			case "reportCardStates_":
				return oReportCard.reportCardStates_;
			case "reportCardAgencies_":
				return oReportCard.reportCardAgencies_;
			case "reportCardReportCards_":
				return oReportCard.reportCardReportCards_;
			case "agencyDemographicsGraph":
				return oReportCard.agencyDemographicsGraph;
			case "agencyStudentsByRaceGraph":
				return oReportCard.agencyStudentsByRaceGraph;
			case "agencyTeachersByRaceGraph":
				return oReportCard.agencyTeachersByRaceGraph;
			case "agencyGrades3To8Graph":
				return oReportCard.agencyGrades3To8Graph;
			case "agencyGrades9To12Graph":
				return oReportCard.agencyGrades9To12Graph;
			case "agencyGraduatesWithin4YearsGraph":
				return oReportCard.agencyGraduatesWithin4YearsGraph;
			case "suspensionsByRaceGraph":
				return oReportCard.suspensionsByRaceGraph;
			case "suspensionRatesByRaceGraph":
				return oReportCard.suspensionRatesByRaceGraph;
			case "countySchoolBasedComplaintsGraph":
				return oReportCard.countySchoolBasedComplaintsGraph;
			case "schoolBasedComplaintsGraph":
				return oReportCard.schoolBasedComplaintsGraph;
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
			case "agencyKey":
				if(oReportCard.getAgencyKey() == null)
					oReportCard.setAgencyKey((Long)val);
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
			case "teachersMale":
				if(val != null)
					setTeachersMale(val);
				saves.add(var);
				return val;
			case "teachersFemale":
				if(val != null)
					setTeachersFemale(val);
				saves.add(var);
				return val;
			case "teachersWhiteTotal":
				if(val != null)
					setTeachersWhiteTotal(val);
				saves.add(var);
				return val;
			case "teachersBlackTotal":
				if(val != null)
					setTeachersBlackTotal(val);
				saves.add(var);
				return val;
			case "teachersOtherTotal":
				if(val != null)
					setTeachersOtherTotal(val);
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
			case "delinquentComplaintsAsian":
				if(val != null)
					setDelinquentComplaintsAsian(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsBlack":
				if(val != null)
					setDelinquentComplaintsBlack(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsHispanic":
				if(val != null)
					setDelinquentComplaintsHispanic(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsMultiRacial":
				if(val != null)
					setDelinquentComplaintsMultiRacial(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsIndian":
				if(val != null)
					setDelinquentComplaintsIndian(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsWhite":
				if(val != null)
					setDelinquentComplaintsWhite(val);
				saves.add(var);
				return val;
			case "delinquentComplaintsPacificIslander":
				if(val != null)
					setDelinquentComplaintsPacificIslander(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionRate":
				if(val != null)
					setShortTermSuspensionRate(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsTotal":
				if(val != null)
					setShortTermSuspensionsTotal(val);
				saves.add(var);
				return val;
			case "longTermSuspensionsTotal":
				if(val != null)
					setLongTermSuspensionsTotal(val);
				saves.add(var);
				return val;
			case "expulsionsTotal":
				if(val != null)
					setExpulsionsTotal(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsAsianFemale":
				if(val != null)
					setShortTermSuspensionsAsianFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsAsianMale":
				if(val != null)
					setShortTermSuspensionsAsianMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsBlackFemale":
				if(val != null)
					setShortTermSuspensionsBlackFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsBlackMale":
				if(val != null)
					setShortTermSuspensionsBlackMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsHispanicFemale":
				if(val != null)
					setShortTermSuspensionsHispanicFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsHispanicMale":
				if(val != null)
					setShortTermSuspensionsHispanicMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsIndianFemale":
				if(val != null)
					setShortTermSuspensionsIndianFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsIndianMale":
				if(val != null)
					setShortTermSuspensionsIndianMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsMultiRacialFemale":
				if(val != null)
					setShortTermSuspensionsMultiRacialFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsMultiRacialMale":
				if(val != null)
					setShortTermSuspensionsMultiRacialMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsPacificIslanderFemale":
				if(val != null)
					setShortTermSuspensionsPacificIslanderFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsPacificIslanderMale":
				if(val != null)
					setShortTermSuspensionsPacificIslanderMale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsWhiteFemale":
				if(val != null)
					setShortTermSuspensionsWhiteFemale(val);
				saves.add(var);
				return val;
			case "shortTermSuspensionsWhiteMale":
				if(val != null)
					setShortTermSuspensionsWhiteMale(val);
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

			if(saves.contains("reportCardYearsStr")) {
				String reportCardYearsStr = (String)solrDocument.get("reportCardYearsStr_stored_string");
				if(reportCardYearsStr != null)
					oReportCard.setReportCardYearsStr(reportCardYearsStr);
			}

			Long agencyKey = (Long)solrDocument.get("agencyKey_stored_long");
			if(agencyKey != null)
				oReportCard.setAgencyKey(agencyKey);

			if(saves.contains("pupilsTotal")) {
				Long pupilsTotal = (Long)solrDocument.get("pupilsTotal_stored_long");
				if(pupilsTotal != null)
					oReportCard.setPupilsTotal(pupilsTotal);
			}

			if(saves.contains("pupilsIndianFemale")) {
				Long pupilsIndianFemale = (Long)solrDocument.get("pupilsIndianFemale_stored_long");
				if(pupilsIndianFemale != null)
					oReportCard.setPupilsIndianFemale(pupilsIndianFemale);
			}

			if(saves.contains("pupilsIndianMale")) {
				Long pupilsIndianMale = (Long)solrDocument.get("pupilsIndianMale_stored_long");
				if(pupilsIndianMale != null)
					oReportCard.setPupilsIndianMale(pupilsIndianMale);
			}

			if(saves.contains("pupilsIndianTotal")) {
				Long pupilsIndianTotal = (Long)solrDocument.get("pupilsIndianTotal_stored_long");
				if(pupilsIndianTotal != null)
					oReportCard.setPupilsIndianTotal(pupilsIndianTotal);
			}

			if(saves.contains("pupilsIndianPercent")) {
				Double pupilsIndianPercent = (Double)solrDocument.get("pupilsIndianPercent_stored_double");
				if(pupilsIndianPercent != null)
					oReportCard.setPupilsIndianPercent(pupilsIndianPercent);
			}

			if(saves.contains("pupilsAsianFemale")) {
				Long pupilsAsianFemale = (Long)solrDocument.get("pupilsAsianFemale_stored_long");
				if(pupilsAsianFemale != null)
					oReportCard.setPupilsAsianFemale(pupilsAsianFemale);
			}

			if(saves.contains("pupilsAsianMale")) {
				Long pupilsAsianMale = (Long)solrDocument.get("pupilsAsianMale_stored_long");
				if(pupilsAsianMale != null)
					oReportCard.setPupilsAsianMale(pupilsAsianMale);
			}

			if(saves.contains("pupilsAsianTotal")) {
				Long pupilsAsianTotal = (Long)solrDocument.get("pupilsAsianTotal_stored_long");
				if(pupilsAsianTotal != null)
					oReportCard.setPupilsAsianTotal(pupilsAsianTotal);
			}

			if(saves.contains("pupilsAsianPercent")) {
				Double pupilsAsianPercent = (Double)solrDocument.get("pupilsAsianPercent_stored_double");
				if(pupilsAsianPercent != null)
					oReportCard.setPupilsAsianPercent(pupilsAsianPercent);
			}

			if(saves.contains("pupilsHispanicFemale")) {
				Long pupilsHispanicFemale = (Long)solrDocument.get("pupilsHispanicFemale_stored_long");
				if(pupilsHispanicFemale != null)
					oReportCard.setPupilsHispanicFemale(pupilsHispanicFemale);
			}

			if(saves.contains("pupilsHispanicMale")) {
				Long pupilsHispanicMale = (Long)solrDocument.get("pupilsHispanicMale_stored_long");
				if(pupilsHispanicMale != null)
					oReportCard.setPupilsHispanicMale(pupilsHispanicMale);
			}

			if(saves.contains("pupilsHispanicTotal")) {
				Long pupilsHispanicTotal = (Long)solrDocument.get("pupilsHispanicTotal_stored_long");
				if(pupilsHispanicTotal != null)
					oReportCard.setPupilsHispanicTotal(pupilsHispanicTotal);
			}

			if(saves.contains("pupilsHispanicPercent")) {
				Double pupilsHispanicPercent = (Double)solrDocument.get("pupilsHispanicPercent_stored_double");
				if(pupilsHispanicPercent != null)
					oReportCard.setPupilsHispanicPercent(pupilsHispanicPercent);
			}

			if(saves.contains("pupilsBlackFemale")) {
				Long pupilsBlackFemale = (Long)solrDocument.get("pupilsBlackFemale_stored_long");
				if(pupilsBlackFemale != null)
					oReportCard.setPupilsBlackFemale(pupilsBlackFemale);
			}

			if(saves.contains("pupilsBlackMale")) {
				Long pupilsBlackMale = (Long)solrDocument.get("pupilsBlackMale_stored_long");
				if(pupilsBlackMale != null)
					oReportCard.setPupilsBlackMale(pupilsBlackMale);
			}

			if(saves.contains("pupilsBlackTotal")) {
				Long pupilsBlackTotal = (Long)solrDocument.get("pupilsBlackTotal_stored_long");
				if(pupilsBlackTotal != null)
					oReportCard.setPupilsBlackTotal(pupilsBlackTotal);
			}

			if(saves.contains("pupilsBlackPercent")) {
				Double pupilsBlackPercent = (Double)solrDocument.get("pupilsBlackPercent_stored_double");
				if(pupilsBlackPercent != null)
					oReportCard.setPupilsBlackPercent(pupilsBlackPercent);
			}

			if(saves.contains("pupilsWhiteFemale")) {
				Long pupilsWhiteFemale = (Long)solrDocument.get("pupilsWhiteFemale_stored_long");
				if(pupilsWhiteFemale != null)
					oReportCard.setPupilsWhiteFemale(pupilsWhiteFemale);
			}

			if(saves.contains("pupilsWhiteMale")) {
				Long pupilsWhiteMale = (Long)solrDocument.get("pupilsWhiteMale_stored_long");
				if(pupilsWhiteMale != null)
					oReportCard.setPupilsWhiteMale(pupilsWhiteMale);
			}

			if(saves.contains("pupilsWhiteTotal")) {
				Long pupilsWhiteTotal = (Long)solrDocument.get("pupilsWhiteTotal_stored_long");
				if(pupilsWhiteTotal != null)
					oReportCard.setPupilsWhiteTotal(pupilsWhiteTotal);
			}

			if(saves.contains("pupilsWhitePercent")) {
				Double pupilsWhitePercent = (Double)solrDocument.get("pupilsWhitePercent_stored_double");
				if(pupilsWhitePercent != null)
					oReportCard.setPupilsWhitePercent(pupilsWhitePercent);
			}

			if(saves.contains("pupilsPacificIslanderFemale")) {
				Long pupilsPacificIslanderFemale = (Long)solrDocument.get("pupilsPacificIslanderFemale_stored_long");
				if(pupilsPacificIslanderFemale != null)
					oReportCard.setPupilsPacificIslanderFemale(pupilsPacificIslanderFemale);
			}

			if(saves.contains("pupilsPacificIslanderMale")) {
				Long pupilsPacificIslanderMale = (Long)solrDocument.get("pupilsPacificIslanderMale_stored_long");
				if(pupilsPacificIslanderMale != null)
					oReportCard.setPupilsPacificIslanderMale(pupilsPacificIslanderMale);
			}

			if(saves.contains("pupilsPacificIslanderTotal")) {
				Long pupilsPacificIslanderTotal = (Long)solrDocument.get("pupilsPacificIslanderTotal_stored_long");
				if(pupilsPacificIslanderTotal != null)
					oReportCard.setPupilsPacificIslanderTotal(pupilsPacificIslanderTotal);
			}

			if(saves.contains("pupilsPacificIslanderPercent")) {
				Double pupilsPacificIslanderPercent = (Double)solrDocument.get("pupilsPacificIslanderPercent_stored_double");
				if(pupilsPacificIslanderPercent != null)
					oReportCard.setPupilsPacificIslanderPercent(pupilsPacificIslanderPercent);
			}

			if(saves.contains("pupilsMultiRacialFemale")) {
				Long pupilsMultiRacialFemale = (Long)solrDocument.get("pupilsMultiRacialFemale_stored_long");
				if(pupilsMultiRacialFemale != null)
					oReportCard.setPupilsMultiRacialFemale(pupilsMultiRacialFemale);
			}

			if(saves.contains("pupilsMultiRacialMale")) {
				Long pupilsMultiRacialMale = (Long)solrDocument.get("pupilsMultiRacialMale_stored_long");
				if(pupilsMultiRacialMale != null)
					oReportCard.setPupilsMultiRacialMale(pupilsMultiRacialMale);
			}

			if(saves.contains("pupilsMultiRacialTotal")) {
				Long pupilsMultiRacialTotal = (Long)solrDocument.get("pupilsMultiRacialTotal_stored_long");
				if(pupilsMultiRacialTotal != null)
					oReportCard.setPupilsMultiRacialTotal(pupilsMultiRacialTotal);
			}

			if(saves.contains("pupilsMultiRacialPercent")) {
				Double pupilsMultiRacialPercent = (Double)solrDocument.get("pupilsMultiRacialPercent_stored_double");
				if(pupilsMultiRacialPercent != null)
					oReportCard.setPupilsMultiRacialPercent(pupilsMultiRacialPercent);
			}

			if(saves.contains("teachersMale")) {
				Long teachersMale = (Long)solrDocument.get("teachersMale_stored_long");
				if(teachersMale != null)
					oReportCard.setTeachersMale(teachersMale);
			}

			if(saves.contains("teachersFemale")) {
				Long teachersFemale = (Long)solrDocument.get("teachersFemale_stored_long");
				if(teachersFemale != null)
					oReportCard.setTeachersFemale(teachersFemale);
			}

			if(saves.contains("teachersTotal")) {
				Long teachersTotal = (Long)solrDocument.get("teachersTotal_stored_long");
				if(teachersTotal != null)
					oReportCard.setTeachersTotal(teachersTotal);
			}

			if(saves.contains("teachersWhiteTotal")) {
				Long teachersWhiteTotal = (Long)solrDocument.get("teachersWhiteTotal_stored_long");
				if(teachersWhiteTotal != null)
					oReportCard.setTeachersWhiteTotal(teachersWhiteTotal);
			}

			if(saves.contains("teachersWhitePercent")) {
				Double teachersWhitePercent = (Double)solrDocument.get("teachersWhitePercent_stored_double");
				if(teachersWhitePercent != null)
					oReportCard.setTeachersWhitePercent(teachersWhitePercent);
			}

			if(saves.contains("teachersBlackTotal")) {
				Long teachersBlackTotal = (Long)solrDocument.get("teachersBlackTotal_stored_long");
				if(teachersBlackTotal != null)
					oReportCard.setTeachersBlackTotal(teachersBlackTotal);
			}

			if(saves.contains("teachersBlackPercent")) {
				Double teachersBlackPercent = (Double)solrDocument.get("teachersBlackPercent_stored_double");
				if(teachersBlackPercent != null)
					oReportCard.setTeachersBlackPercent(teachersBlackPercent);
			}

			if(saves.contains("teachersOtherTotal")) {
				Long teachersOtherTotal = (Long)solrDocument.get("teachersOtherTotal_stored_long");
				if(teachersOtherTotal != null)
					oReportCard.setTeachersOtherTotal(teachersOtherTotal);
			}

			if(saves.contains("teachersOtherPercent")) {
				Double teachersOtherPercent = (Double)solrDocument.get("teachersOtherPercent_stored_double");
				if(teachersOtherPercent != null)
					oReportCard.setTeachersOtherPercent(teachersOtherPercent);
			}

			if(saves.contains("delinquentComplaintsTotal")) {
				Long delinquentComplaintsTotal = (Long)solrDocument.get("delinquentComplaintsTotal_stored_long");
				if(delinquentComplaintsTotal != null)
					oReportCard.setDelinquentComplaintsTotal(delinquentComplaintsTotal);
			}

			if(saves.contains("delinquentComplaintsAtSchool")) {
				Long delinquentComplaintsAtSchool = (Long)solrDocument.get("delinquentComplaintsAtSchool_stored_long");
				if(delinquentComplaintsAtSchool != null)
					oReportCard.setDelinquentComplaintsAtSchool(delinquentComplaintsAtSchool);
			}

			if(saves.contains("delinquentComplaintsAtSchoolPercent")) {
				Double delinquentComplaintsAtSchoolPercent = (Double)solrDocument.get("delinquentComplaintsAtSchoolPercent_stored_double");
				if(delinquentComplaintsAtSchoolPercent != null)
					oReportCard.setDelinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercent);
			}

			if(saves.contains("delinquentComplaintsAsian")) {
				Long delinquentComplaintsAsian = (Long)solrDocument.get("delinquentComplaintsAsian_stored_long");
				if(delinquentComplaintsAsian != null)
					oReportCard.setDelinquentComplaintsAsian(delinquentComplaintsAsian);
			}

			if(saves.contains("delinquentComplaintsAsianPercent")) {
				Double delinquentComplaintsAsianPercent = (Double)solrDocument.get("delinquentComplaintsAsianPercent_stored_double");
				if(delinquentComplaintsAsianPercent != null)
					oReportCard.setDelinquentComplaintsAsianPercent(delinquentComplaintsAsianPercent);
			}

			if(saves.contains("delinquentComplaintsBlack")) {
				Long delinquentComplaintsBlack = (Long)solrDocument.get("delinquentComplaintsBlack_stored_long");
				if(delinquentComplaintsBlack != null)
					oReportCard.setDelinquentComplaintsBlack(delinquentComplaintsBlack);
			}

			if(saves.contains("delinquentComplaintsBlackPercent")) {
				Double delinquentComplaintsBlackPercent = (Double)solrDocument.get("delinquentComplaintsBlackPercent_stored_double");
				if(delinquentComplaintsBlackPercent != null)
					oReportCard.setDelinquentComplaintsBlackPercent(delinquentComplaintsBlackPercent);
			}

			if(saves.contains("delinquentComplaintsHispanic")) {
				Long delinquentComplaintsHispanic = (Long)solrDocument.get("delinquentComplaintsHispanic_stored_long");
				if(delinquentComplaintsHispanic != null)
					oReportCard.setDelinquentComplaintsHispanic(delinquentComplaintsHispanic);
			}

			if(saves.contains("delinquentComplaintsHispanicPercent")) {
				Double delinquentComplaintsHispanicPercent = (Double)solrDocument.get("delinquentComplaintsHispanicPercent_stored_double");
				if(delinquentComplaintsHispanicPercent != null)
					oReportCard.setDelinquentComplaintsHispanicPercent(delinquentComplaintsHispanicPercent);
			}

			if(saves.contains("delinquentComplaintsMultiRacial")) {
				Long delinquentComplaintsMultiRacial = (Long)solrDocument.get("delinquentComplaintsMultiRacial_stored_long");
				if(delinquentComplaintsMultiRacial != null)
					oReportCard.setDelinquentComplaintsMultiRacial(delinquentComplaintsMultiRacial);
			}

			if(saves.contains("delinquentComplaintsMultiRacialPercent")) {
				Double delinquentComplaintsMultiRacialPercent = (Double)solrDocument.get("delinquentComplaintsMultiRacialPercent_stored_double");
				if(delinquentComplaintsMultiRacialPercent != null)
					oReportCard.setDelinquentComplaintsMultiRacialPercent(delinquentComplaintsMultiRacialPercent);
			}

			if(saves.contains("delinquentComplaintsIndian")) {
				Long delinquentComplaintsIndian = (Long)solrDocument.get("delinquentComplaintsIndian_stored_long");
				if(delinquentComplaintsIndian != null)
					oReportCard.setDelinquentComplaintsIndian(delinquentComplaintsIndian);
			}

			if(saves.contains("delinquentComplaintsIndianPercent")) {
				Double delinquentComplaintsIndianPercent = (Double)solrDocument.get("delinquentComplaintsIndianPercent_stored_double");
				if(delinquentComplaintsIndianPercent != null)
					oReportCard.setDelinquentComplaintsIndianPercent(delinquentComplaintsIndianPercent);
			}

			if(saves.contains("delinquentComplaintsWhite")) {
				Long delinquentComplaintsWhite = (Long)solrDocument.get("delinquentComplaintsWhite_stored_long");
				if(delinquentComplaintsWhite != null)
					oReportCard.setDelinquentComplaintsWhite(delinquentComplaintsWhite);
			}

			if(saves.contains("delinquentComplaintsWhitePercent")) {
				Double delinquentComplaintsWhitePercent = (Double)solrDocument.get("delinquentComplaintsWhitePercent_stored_double");
				if(delinquentComplaintsWhitePercent != null)
					oReportCard.setDelinquentComplaintsWhitePercent(delinquentComplaintsWhitePercent);
			}

			if(saves.contains("delinquentComplaintsPacificIslander")) {
				Long delinquentComplaintsPacificIslander = (Long)solrDocument.get("delinquentComplaintsPacificIslander_stored_long");
				if(delinquentComplaintsPacificIslander != null)
					oReportCard.setDelinquentComplaintsPacificIslander(delinquentComplaintsPacificIslander);
			}

			if(saves.contains("delinquentComplaintsPacificIslanderPercent")) {
				Double delinquentComplaintsPacificIslanderPercent = (Double)solrDocument.get("delinquentComplaintsPacificIslanderPercent_stored_double");
				if(delinquentComplaintsPacificIslanderPercent != null)
					oReportCard.setDelinquentComplaintsPacificIslanderPercent(delinquentComplaintsPacificIslanderPercent);
			}

			if(saves.contains("shortTermSuspensionRate")) {
				Long shortTermSuspensionRate = (Long)solrDocument.get("shortTermSuspensionRate_stored_long");
				if(shortTermSuspensionRate != null)
					oReportCard.setShortTermSuspensionRate(shortTermSuspensionRate);
			}

			if(saves.contains("shortTermSuspensionsTotal")) {
				Long shortTermSuspensionsTotal = (Long)solrDocument.get("shortTermSuspensionsTotal_stored_long");
				if(shortTermSuspensionsTotal != null)
					oReportCard.setShortTermSuspensionsTotal(shortTermSuspensionsTotal);
			}

			if(saves.contains("longTermSuspensionsTotal")) {
				Long longTermSuspensionsTotal = (Long)solrDocument.get("longTermSuspensionsTotal_stored_long");
				if(longTermSuspensionsTotal != null)
					oReportCard.setLongTermSuspensionsTotal(longTermSuspensionsTotal);
			}

			if(saves.contains("expulsionsTotal")) {
				Long expulsionsTotal = (Long)solrDocument.get("expulsionsTotal_stored_long");
				if(expulsionsTotal != null)
					oReportCard.setExpulsionsTotal(expulsionsTotal);
			}

			if(saves.contains("shortTermSuspensionsAsianFemale")) {
				Long shortTermSuspensionsAsianFemale = (Long)solrDocument.get("shortTermSuspensionsAsianFemale_stored_long");
				if(shortTermSuspensionsAsianFemale != null)
					oReportCard.setShortTermSuspensionsAsianFemale(shortTermSuspensionsAsianFemale);
			}

			if(saves.contains("shortTermSuspensionsAsianMale")) {
				Long shortTermSuspensionsAsianMale = (Long)solrDocument.get("shortTermSuspensionsAsianMale_stored_long");
				if(shortTermSuspensionsAsianMale != null)
					oReportCard.setShortTermSuspensionsAsianMale(shortTermSuspensionsAsianMale);
			}

			if(saves.contains("shortTermSuspensionsAsianTotal")) {
				Long shortTermSuspensionsAsianTotal = (Long)solrDocument.get("shortTermSuspensionsAsianTotal_stored_long");
				if(shortTermSuspensionsAsianTotal != null)
					oReportCard.setShortTermSuspensionsAsianTotal(shortTermSuspensionsAsianTotal);
			}

			if(saves.contains("shortTermSuspensionsAsianPercent")) {
				Double shortTermSuspensionsAsianPercent = (Double)solrDocument.get("shortTermSuspensionsAsianPercent_stored_double");
				if(shortTermSuspensionsAsianPercent != null)
					oReportCard.setShortTermSuspensionsAsianPercent(shortTermSuspensionsAsianPercent);
			}

			if(saves.contains("shortTermSuspensionsAsianRate")) {
				Double shortTermSuspensionsAsianRate = (Double)solrDocument.get("shortTermSuspensionsAsianRate_stored_double");
				if(shortTermSuspensionsAsianRate != null)
					oReportCard.setShortTermSuspensionsAsianRate(shortTermSuspensionsAsianRate);
			}

			if(saves.contains("shortTermSuspensionsBlackFemale")) {
				Long shortTermSuspensionsBlackFemale = (Long)solrDocument.get("shortTermSuspensionsBlackFemale_stored_long");
				if(shortTermSuspensionsBlackFemale != null)
					oReportCard.setShortTermSuspensionsBlackFemale(shortTermSuspensionsBlackFemale);
			}

			if(saves.contains("shortTermSuspensionsBlackMale")) {
				Long shortTermSuspensionsBlackMale = (Long)solrDocument.get("shortTermSuspensionsBlackMale_stored_long");
				if(shortTermSuspensionsBlackMale != null)
					oReportCard.setShortTermSuspensionsBlackMale(shortTermSuspensionsBlackMale);
			}

			if(saves.contains("shortTermSuspensionsBlackTotal")) {
				Long shortTermSuspensionsBlackTotal = (Long)solrDocument.get("shortTermSuspensionsBlackTotal_stored_long");
				if(shortTermSuspensionsBlackTotal != null)
					oReportCard.setShortTermSuspensionsBlackTotal(shortTermSuspensionsBlackTotal);
			}

			if(saves.contains("shortTermSuspensionsBlackPercent")) {
				Double shortTermSuspensionsBlackPercent = (Double)solrDocument.get("shortTermSuspensionsBlackPercent_stored_double");
				if(shortTermSuspensionsBlackPercent != null)
					oReportCard.setShortTermSuspensionsBlackPercent(shortTermSuspensionsBlackPercent);
			}

			if(saves.contains("shortTermSuspensionsBlackRate")) {
				Double shortTermSuspensionsBlackRate = (Double)solrDocument.get("shortTermSuspensionsBlackRate_stored_double");
				if(shortTermSuspensionsBlackRate != null)
					oReportCard.setShortTermSuspensionsBlackRate(shortTermSuspensionsBlackRate);
			}

			if(saves.contains("shortTermSuspensionsHispanicFemale")) {
				Long shortTermSuspensionsHispanicFemale = (Long)solrDocument.get("shortTermSuspensionsHispanicFemale_stored_long");
				if(shortTermSuspensionsHispanicFemale != null)
					oReportCard.setShortTermSuspensionsHispanicFemale(shortTermSuspensionsHispanicFemale);
			}

			if(saves.contains("shortTermSuspensionsHispanicMale")) {
				Long shortTermSuspensionsHispanicMale = (Long)solrDocument.get("shortTermSuspensionsHispanicMale_stored_long");
				if(shortTermSuspensionsHispanicMale != null)
					oReportCard.setShortTermSuspensionsHispanicMale(shortTermSuspensionsHispanicMale);
			}

			if(saves.contains("shortTermSuspensionsHispanicTotal")) {
				Long shortTermSuspensionsHispanicTotal = (Long)solrDocument.get("shortTermSuspensionsHispanicTotal_stored_long");
				if(shortTermSuspensionsHispanicTotal != null)
					oReportCard.setShortTermSuspensionsHispanicTotal(shortTermSuspensionsHispanicTotal);
			}

			if(saves.contains("shortTermSuspensionsHispanicPercent")) {
				Double shortTermSuspensionsHispanicPercent = (Double)solrDocument.get("shortTermSuspensionsHispanicPercent_stored_double");
				if(shortTermSuspensionsHispanicPercent != null)
					oReportCard.setShortTermSuspensionsHispanicPercent(shortTermSuspensionsHispanicPercent);
			}

			if(saves.contains("shortTermSuspensionsHispanicRate")) {
				Double shortTermSuspensionsHispanicRate = (Double)solrDocument.get("shortTermSuspensionsHispanicRate_stored_double");
				if(shortTermSuspensionsHispanicRate != null)
					oReportCard.setShortTermSuspensionsHispanicRate(shortTermSuspensionsHispanicRate);
			}

			if(saves.contains("shortTermSuspensionsIndianFemale")) {
				Long shortTermSuspensionsIndianFemale = (Long)solrDocument.get("shortTermSuspensionsIndianFemale_stored_long");
				if(shortTermSuspensionsIndianFemale != null)
					oReportCard.setShortTermSuspensionsIndianFemale(shortTermSuspensionsIndianFemale);
			}

			if(saves.contains("shortTermSuspensionsIndianMale")) {
				Long shortTermSuspensionsIndianMale = (Long)solrDocument.get("shortTermSuspensionsIndianMale_stored_long");
				if(shortTermSuspensionsIndianMale != null)
					oReportCard.setShortTermSuspensionsIndianMale(shortTermSuspensionsIndianMale);
			}

			if(saves.contains("shortTermSuspensionsIndianTotal")) {
				Long shortTermSuspensionsIndianTotal = (Long)solrDocument.get("shortTermSuspensionsIndianTotal_stored_long");
				if(shortTermSuspensionsIndianTotal != null)
					oReportCard.setShortTermSuspensionsIndianTotal(shortTermSuspensionsIndianTotal);
			}

			if(saves.contains("shortTermSuspensionsIndianPercent")) {
				Double shortTermSuspensionsIndianPercent = (Double)solrDocument.get("shortTermSuspensionsIndianPercent_stored_double");
				if(shortTermSuspensionsIndianPercent != null)
					oReportCard.setShortTermSuspensionsIndianPercent(shortTermSuspensionsIndianPercent);
			}

			if(saves.contains("shortTermSuspensionsIndianRate")) {
				Double shortTermSuspensionsIndianRate = (Double)solrDocument.get("shortTermSuspensionsIndianRate_stored_double");
				if(shortTermSuspensionsIndianRate != null)
					oReportCard.setShortTermSuspensionsIndianRate(shortTermSuspensionsIndianRate);
			}

			if(saves.contains("shortTermSuspensionsMultiRacialFemale")) {
				Long shortTermSuspensionsMultiRacialFemale = (Long)solrDocument.get("shortTermSuspensionsMultiRacialFemale_stored_long");
				if(shortTermSuspensionsMultiRacialFemale != null)
					oReportCard.setShortTermSuspensionsMultiRacialFemale(shortTermSuspensionsMultiRacialFemale);
			}

			if(saves.contains("shortTermSuspensionsMultiRacialMale")) {
				Long shortTermSuspensionsMultiRacialMale = (Long)solrDocument.get("shortTermSuspensionsMultiRacialMale_stored_long");
				if(shortTermSuspensionsMultiRacialMale != null)
					oReportCard.setShortTermSuspensionsMultiRacialMale(shortTermSuspensionsMultiRacialMale);
			}

			if(saves.contains("shortTermSuspensionsMultiRacialTotal")) {
				Long shortTermSuspensionsMultiRacialTotal = (Long)solrDocument.get("shortTermSuspensionsMultiRacialTotal_stored_long");
				if(shortTermSuspensionsMultiRacialTotal != null)
					oReportCard.setShortTermSuspensionsMultiRacialTotal(shortTermSuspensionsMultiRacialTotal);
			}

			if(saves.contains("shortTermSuspensionsMultiRacialPercent")) {
				Double shortTermSuspensionsMultiRacialPercent = (Double)solrDocument.get("shortTermSuspensionsMultiRacialPercent_stored_double");
				if(shortTermSuspensionsMultiRacialPercent != null)
					oReportCard.setShortTermSuspensionsMultiRacialPercent(shortTermSuspensionsMultiRacialPercent);
			}

			if(saves.contains("shortTermSuspensionsMultiRacialRate")) {
				Double shortTermSuspensionsMultiRacialRate = (Double)solrDocument.get("shortTermSuspensionsMultiRacialRate_stored_double");
				if(shortTermSuspensionsMultiRacialRate != null)
					oReportCard.setShortTermSuspensionsMultiRacialRate(shortTermSuspensionsMultiRacialRate);
			}

			if(saves.contains("shortTermSuspensionsPacificIslanderFemale")) {
				Long shortTermSuspensionsPacificIslanderFemale = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderFemale_stored_long");
				if(shortTermSuspensionsPacificIslanderFemale != null)
					oReportCard.setShortTermSuspensionsPacificIslanderFemale(shortTermSuspensionsPacificIslanderFemale);
			}

			if(saves.contains("shortTermSuspensionsPacificIslanderMale")) {
				Long shortTermSuspensionsPacificIslanderMale = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderMale_stored_long");
				if(shortTermSuspensionsPacificIslanderMale != null)
					oReportCard.setShortTermSuspensionsPacificIslanderMale(shortTermSuspensionsPacificIslanderMale);
			}

			if(saves.contains("shortTermSuspensionsPacificIslanderTotal")) {
				Long shortTermSuspensionsPacificIslanderTotal = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderTotal_stored_long");
				if(shortTermSuspensionsPacificIslanderTotal != null)
					oReportCard.setShortTermSuspensionsPacificIslanderTotal(shortTermSuspensionsPacificIslanderTotal);
			}

			if(saves.contains("shortTermSuspensionsPacificIslanderPercent")) {
				Double shortTermSuspensionsPacificIslanderPercent = (Double)solrDocument.get("shortTermSuspensionsPacificIslanderPercent_stored_double");
				if(shortTermSuspensionsPacificIslanderPercent != null)
					oReportCard.setShortTermSuspensionsPacificIslanderPercent(shortTermSuspensionsPacificIslanderPercent);
			}

			if(saves.contains("shortTermSuspensionsPacificIslanderRate")) {
				Double shortTermSuspensionsPacificIslanderRate = (Double)solrDocument.get("shortTermSuspensionsPacificIslanderRate_stored_double");
				if(shortTermSuspensionsPacificIslanderRate != null)
					oReportCard.setShortTermSuspensionsPacificIslanderRate(shortTermSuspensionsPacificIslanderRate);
			}

			if(saves.contains("shortTermSuspensionsWhiteFemale")) {
				Long shortTermSuspensionsWhiteFemale = (Long)solrDocument.get("shortTermSuspensionsWhiteFemale_stored_long");
				if(shortTermSuspensionsWhiteFemale != null)
					oReportCard.setShortTermSuspensionsWhiteFemale(shortTermSuspensionsWhiteFemale);
			}

			if(saves.contains("shortTermSuspensionsWhiteMale")) {
				Long shortTermSuspensionsWhiteMale = (Long)solrDocument.get("shortTermSuspensionsWhiteMale_stored_long");
				if(shortTermSuspensionsWhiteMale != null)
					oReportCard.setShortTermSuspensionsWhiteMale(shortTermSuspensionsWhiteMale);
			}

			if(saves.contains("shortTermSuspensionsWhiteTotal")) {
				Long shortTermSuspensionsWhiteTotal = (Long)solrDocument.get("shortTermSuspensionsWhiteTotal_stored_long");
				if(shortTermSuspensionsWhiteTotal != null)
					oReportCard.setShortTermSuspensionsWhiteTotal(shortTermSuspensionsWhiteTotal);
			}

			if(saves.contains("shortTermSuspensionsWhitePercent")) {
				Double shortTermSuspensionsWhitePercent = (Double)solrDocument.get("shortTermSuspensionsWhitePercent_stored_double");
				if(shortTermSuspensionsWhitePercent != null)
					oReportCard.setShortTermSuspensionsWhitePercent(shortTermSuspensionsWhitePercent);
			}

			if(saves.contains("shortTermSuspensionsWhiteRate")) {
				Double shortTermSuspensionsWhiteRate = (Double)solrDocument.get("shortTermSuspensionsWhiteRate_stored_double");
				if(shortTermSuspensionsWhiteRate != null)
					oReportCard.setShortTermSuspensionsWhiteRate(shortTermSuspensionsWhiteRate);
			}

			if(saves.contains("shortTermSuspensionsAllRate")) {
				Double shortTermSuspensionsAllRate = (Double)solrDocument.get("shortTermSuspensionsAllRate_stored_double");
				if(shortTermSuspensionsAllRate != null)
					oReportCard.setShortTermSuspensionsAllRate(shortTermSuspensionsAllRate);
			}

			if(saves.contains("shortTermSuspensionsBlackVsWhite")) {
				Double shortTermSuspensionsBlackVsWhite = (Double)solrDocument.get("shortTermSuspensionsBlackVsWhite_stored_double");
				if(shortTermSuspensionsBlackVsWhite != null)
					oReportCard.setShortTermSuspensionsBlackVsWhite(shortTermSuspensionsBlackVsWhite);
			}

			if(saves.contains("stateKey")) {
				Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
				if(stateKey != null)
					oReportCard.setStateKey(stateKey);
			}

			if(saves.contains("stateId")) {
				String stateId = (String)solrDocument.get("stateId_stored_string");
				if(stateId != null)
					oReportCard.setStateId(stateId);
			}

			if(saves.contains("agencyId")) {
				String agencyId = (String)solrDocument.get("agencyId_stored_string");
				if(agencyId != null)
					oReportCard.setAgencyId(agencyId);
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

			if(saves.contains("agencyName")) {
				String agencyName = (String)solrDocument.get("agencyName_stored_string");
				if(agencyName != null)
					oReportCard.setAgencyName(agencyName);
			}

			if(saves.contains("agencyCompleteName")) {
				String agencyCompleteName = (String)solrDocument.get("agencyCompleteName_stored_string");
				if(agencyCompleteName != null)
					oReportCard.setAgencyCompleteName(agencyCompleteName);
			}

			if(saves.contains("agencyDemographicsGraph")) {
				String agencyDemographicsGraph = (String)solrDocument.get("agencyDemographicsGraph_stored_string");
				if(agencyDemographicsGraph != null)
					oReportCard.setAgencyDemographicsGraph(agencyDemographicsGraph);
			}

			if(saves.contains("agencyStudentsByRaceGraph")) {
				String agencyStudentsByRaceGraph = (String)solrDocument.get("agencyStudentsByRaceGraph_stored_string");
				if(agencyStudentsByRaceGraph != null)
					oReportCard.setAgencyStudentsByRaceGraph(agencyStudentsByRaceGraph);
			}

			if(saves.contains("agencyTeachersByRaceGraph")) {
				String agencyTeachersByRaceGraph = (String)solrDocument.get("agencyTeachersByRaceGraph_stored_string");
				if(agencyTeachersByRaceGraph != null)
					oReportCard.setAgencyTeachersByRaceGraph(agencyTeachersByRaceGraph);
			}

			if(saves.contains("agencyGrades3To8Graph")) {
				String agencyGrades3To8Graph = (String)solrDocument.get("agencyGrades3To8Graph_stored_string");
				if(agencyGrades3To8Graph != null)
					oReportCard.setAgencyGrades3To8Graph(agencyGrades3To8Graph);
			}

			if(saves.contains("agencyGrades9To12Graph")) {
				String agencyGrades9To12Graph = (String)solrDocument.get("agencyGrades9To12Graph_stored_string");
				if(agencyGrades9To12Graph != null)
					oReportCard.setAgencyGrades9To12Graph(agencyGrades9To12Graph);
			}

			if(saves.contains("agencyGraduatesWithin4YearsGraph")) {
				String agencyGraduatesWithin4YearsGraph = (String)solrDocument.get("agencyGraduatesWithin4YearsGraph_stored_string");
				if(agencyGraduatesWithin4YearsGraph != null)
					oReportCard.setAgencyGraduatesWithin4YearsGraph(agencyGraduatesWithin4YearsGraph);
			}

			if(saves.contains("suspensionsByRaceGraph")) {
				String suspensionsByRaceGraph = (String)solrDocument.get("suspensionsByRaceGraph_stored_string");
				if(suspensionsByRaceGraph != null)
					oReportCard.setSuspensionsByRaceGraph(suspensionsByRaceGraph);
			}

			if(saves.contains("suspensionRatesByRaceGraph")) {
				String suspensionRatesByRaceGraph = (String)solrDocument.get("suspensionRatesByRaceGraph_stored_string");
				if(suspensionRatesByRaceGraph != null)
					oReportCard.setSuspensionRatesByRaceGraph(suspensionRatesByRaceGraph);
			}

			if(saves.contains("countySchoolBasedComplaintsGraph")) {
				String countySchoolBasedComplaintsGraph = (String)solrDocument.get("countySchoolBasedComplaintsGraph_stored_string");
				if(countySchoolBasedComplaintsGraph != null)
					oReportCard.setCountySchoolBasedComplaintsGraph(countySchoolBasedComplaintsGraph);
			}

			if(saves.contains("schoolBasedComplaintsGraph")) {
				String schoolBasedComplaintsGraph = (String)solrDocument.get("schoolBasedComplaintsGraph_stored_string");
				if(schoolBasedComplaintsGraph != null)
					oReportCard.setSchoolBasedComplaintsGraph(schoolBasedComplaintsGraph);
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
		if(reportCardYearsStr != null) {
			document.addField("reportCardYearsStr_indexed_string", reportCardYearsStr);
			document.addField("reportCardYearsStr_stored_string", reportCardYearsStr);
		}
		if(agencyKey != null) {
			document.addField("agencyKey_indexed_long", agencyKey);
			document.addField("agencyKey_stored_long", agencyKey);
		}
		if(pupilsTotal != null) {
			document.addField("pupilsTotal_indexed_long", pupilsTotal);
			document.addField("pupilsTotal_stored_long", pupilsTotal);
		}
		if(pupilsIndianFemale != null) {
			document.addField("pupilsIndianFemale_indexed_long", pupilsIndianFemale);
			document.addField("pupilsIndianFemale_stored_long", pupilsIndianFemale);
		}
		if(pupilsIndianMale != null) {
			document.addField("pupilsIndianMale_indexed_long", pupilsIndianMale);
			document.addField("pupilsIndianMale_stored_long", pupilsIndianMale);
		}
		if(pupilsIndianTotal != null) {
			document.addField("pupilsIndianTotal_indexed_long", pupilsIndianTotal);
			document.addField("pupilsIndianTotal_stored_long", pupilsIndianTotal);
		}
		if(pupilsIndianPercent != null) {
			document.addField("pupilsIndianPercent_indexed_double", pupilsIndianPercent.doubleValue());
			document.addField("pupilsIndianPercent_stored_double", pupilsIndianPercent.doubleValue());
		}
		if(pupilsAsianFemale != null) {
			document.addField("pupilsAsianFemale_indexed_long", pupilsAsianFemale);
			document.addField("pupilsAsianFemale_stored_long", pupilsAsianFemale);
		}
		if(pupilsAsianMale != null) {
			document.addField("pupilsAsianMale_indexed_long", pupilsAsianMale);
			document.addField("pupilsAsianMale_stored_long", pupilsAsianMale);
		}
		if(pupilsAsianTotal != null) {
			document.addField("pupilsAsianTotal_indexed_long", pupilsAsianTotal);
			document.addField("pupilsAsianTotal_stored_long", pupilsAsianTotal);
		}
		if(pupilsAsianPercent != null) {
			document.addField("pupilsAsianPercent_indexed_double", pupilsAsianPercent.doubleValue());
			document.addField("pupilsAsianPercent_stored_double", pupilsAsianPercent.doubleValue());
		}
		if(pupilsHispanicFemale != null) {
			document.addField("pupilsHispanicFemale_indexed_long", pupilsHispanicFemale);
			document.addField("pupilsHispanicFemale_stored_long", pupilsHispanicFemale);
		}
		if(pupilsHispanicMale != null) {
			document.addField("pupilsHispanicMale_indexed_long", pupilsHispanicMale);
			document.addField("pupilsHispanicMale_stored_long", pupilsHispanicMale);
		}
		if(pupilsHispanicTotal != null) {
			document.addField("pupilsHispanicTotal_indexed_long", pupilsHispanicTotal);
			document.addField("pupilsHispanicTotal_stored_long", pupilsHispanicTotal);
		}
		if(pupilsHispanicPercent != null) {
			document.addField("pupilsHispanicPercent_indexed_double", pupilsHispanicPercent.doubleValue());
			document.addField("pupilsHispanicPercent_stored_double", pupilsHispanicPercent.doubleValue());
		}
		if(pupilsBlackFemale != null) {
			document.addField("pupilsBlackFemale_indexed_long", pupilsBlackFemale);
			document.addField("pupilsBlackFemale_stored_long", pupilsBlackFemale);
		}
		if(pupilsBlackMale != null) {
			document.addField("pupilsBlackMale_indexed_long", pupilsBlackMale);
			document.addField("pupilsBlackMale_stored_long", pupilsBlackMale);
		}
		if(pupilsBlackTotal != null) {
			document.addField("pupilsBlackTotal_indexed_long", pupilsBlackTotal);
			document.addField("pupilsBlackTotal_stored_long", pupilsBlackTotal);
		}
		if(pupilsBlackPercent != null) {
			document.addField("pupilsBlackPercent_indexed_double", pupilsBlackPercent.doubleValue());
			document.addField("pupilsBlackPercent_stored_double", pupilsBlackPercent.doubleValue());
		}
		if(pupilsWhiteFemale != null) {
			document.addField("pupilsWhiteFemale_indexed_long", pupilsWhiteFemale);
			document.addField("pupilsWhiteFemale_stored_long", pupilsWhiteFemale);
		}
		if(pupilsWhiteMale != null) {
			document.addField("pupilsWhiteMale_indexed_long", pupilsWhiteMale);
			document.addField("pupilsWhiteMale_stored_long", pupilsWhiteMale);
		}
		if(pupilsWhiteTotal != null) {
			document.addField("pupilsWhiteTotal_indexed_long", pupilsWhiteTotal);
			document.addField("pupilsWhiteTotal_stored_long", pupilsWhiteTotal);
		}
		if(pupilsWhitePercent != null) {
			document.addField("pupilsWhitePercent_indexed_double", pupilsWhitePercent.doubleValue());
			document.addField("pupilsWhitePercent_stored_double", pupilsWhitePercent.doubleValue());
		}
		if(pupilsPacificIslanderFemale != null) {
			document.addField("pupilsPacificIslanderFemale_indexed_long", pupilsPacificIslanderFemale);
			document.addField("pupilsPacificIslanderFemale_stored_long", pupilsPacificIslanderFemale);
		}
		if(pupilsPacificIslanderMale != null) {
			document.addField("pupilsPacificIslanderMale_indexed_long", pupilsPacificIslanderMale);
			document.addField("pupilsPacificIslanderMale_stored_long", pupilsPacificIslanderMale);
		}
		if(pupilsPacificIslanderTotal != null) {
			document.addField("pupilsPacificIslanderTotal_indexed_long", pupilsPacificIslanderTotal);
			document.addField("pupilsPacificIslanderTotal_stored_long", pupilsPacificIslanderTotal);
		}
		if(pupilsPacificIslanderPercent != null) {
			document.addField("pupilsPacificIslanderPercent_indexed_double", pupilsPacificIslanderPercent.doubleValue());
			document.addField("pupilsPacificIslanderPercent_stored_double", pupilsPacificIslanderPercent.doubleValue());
		}
		if(pupilsMultiRacialFemale != null) {
			document.addField("pupilsMultiRacialFemale_indexed_long", pupilsMultiRacialFemale);
			document.addField("pupilsMultiRacialFemale_stored_long", pupilsMultiRacialFemale);
		}
		if(pupilsMultiRacialMale != null) {
			document.addField("pupilsMultiRacialMale_indexed_long", pupilsMultiRacialMale);
			document.addField("pupilsMultiRacialMale_stored_long", pupilsMultiRacialMale);
		}
		if(pupilsMultiRacialTotal != null) {
			document.addField("pupilsMultiRacialTotal_indexed_long", pupilsMultiRacialTotal);
			document.addField("pupilsMultiRacialTotal_stored_long", pupilsMultiRacialTotal);
		}
		if(pupilsMultiRacialPercent != null) {
			document.addField("pupilsMultiRacialPercent_indexed_double", pupilsMultiRacialPercent.doubleValue());
			document.addField("pupilsMultiRacialPercent_stored_double", pupilsMultiRacialPercent.doubleValue());
		}
		if(teachersMale != null) {
			document.addField("teachersMale_indexed_long", teachersMale);
			document.addField("teachersMale_stored_long", teachersMale);
		}
		if(teachersFemale != null) {
			document.addField("teachersFemale_indexed_long", teachersFemale);
			document.addField("teachersFemale_stored_long", teachersFemale);
		}
		if(teachersTotal != null) {
			document.addField("teachersTotal_indexed_long", teachersTotal);
			document.addField("teachersTotal_stored_long", teachersTotal);
		}
		if(teachersWhiteTotal != null) {
			document.addField("teachersWhiteTotal_indexed_long", teachersWhiteTotal);
			document.addField("teachersWhiteTotal_stored_long", teachersWhiteTotal);
		}
		if(teachersWhitePercent != null) {
			document.addField("teachersWhitePercent_indexed_double", teachersWhitePercent.doubleValue());
			document.addField("teachersWhitePercent_stored_double", teachersWhitePercent.doubleValue());
		}
		if(teachersBlackTotal != null) {
			document.addField("teachersBlackTotal_indexed_long", teachersBlackTotal);
			document.addField("teachersBlackTotal_stored_long", teachersBlackTotal);
		}
		if(teachersBlackPercent != null) {
			document.addField("teachersBlackPercent_indexed_double", teachersBlackPercent.doubleValue());
			document.addField("teachersBlackPercent_stored_double", teachersBlackPercent.doubleValue());
		}
		if(teachersOtherTotal != null) {
			document.addField("teachersOtherTotal_indexed_long", teachersOtherTotal);
			document.addField("teachersOtherTotal_stored_long", teachersOtherTotal);
		}
		if(teachersOtherPercent != null) {
			document.addField("teachersOtherPercent_indexed_double", teachersOtherPercent.doubleValue());
			document.addField("teachersOtherPercent_stored_double", teachersOtherPercent.doubleValue());
		}
		if(delinquentComplaintsTotal != null) {
			document.addField("delinquentComplaintsTotal_indexed_long", delinquentComplaintsTotal);
			document.addField("delinquentComplaintsTotal_stored_long", delinquentComplaintsTotal);
		}
		if(delinquentComplaintsAtSchool != null) {
			document.addField("delinquentComplaintsAtSchool_indexed_long", delinquentComplaintsAtSchool);
			document.addField("delinquentComplaintsAtSchool_stored_long", delinquentComplaintsAtSchool);
		}
		if(delinquentComplaintsAtSchoolPercent != null) {
			document.addField("delinquentComplaintsAtSchoolPercent_indexed_double", delinquentComplaintsAtSchoolPercent.doubleValue());
			document.addField("delinquentComplaintsAtSchoolPercent_stored_double", delinquentComplaintsAtSchoolPercent.doubleValue());
		}
		if(delinquentComplaintsAsian != null) {
			document.addField("delinquentComplaintsAsian_indexed_long", delinquentComplaintsAsian);
			document.addField("delinquentComplaintsAsian_stored_long", delinquentComplaintsAsian);
		}
		if(delinquentComplaintsAsianPercent != null) {
			document.addField("delinquentComplaintsAsianPercent_indexed_double", delinquentComplaintsAsianPercent.doubleValue());
			document.addField("delinquentComplaintsAsianPercent_stored_double", delinquentComplaintsAsianPercent.doubleValue());
		}
		if(delinquentComplaintsBlack != null) {
			document.addField("delinquentComplaintsBlack_indexed_long", delinquentComplaintsBlack);
			document.addField("delinquentComplaintsBlack_stored_long", delinquentComplaintsBlack);
		}
		if(delinquentComplaintsBlackPercent != null) {
			document.addField("delinquentComplaintsBlackPercent_indexed_double", delinquentComplaintsBlackPercent.doubleValue());
			document.addField("delinquentComplaintsBlackPercent_stored_double", delinquentComplaintsBlackPercent.doubleValue());
		}
		if(delinquentComplaintsHispanic != null) {
			document.addField("delinquentComplaintsHispanic_indexed_long", delinquentComplaintsHispanic);
			document.addField("delinquentComplaintsHispanic_stored_long", delinquentComplaintsHispanic);
		}
		if(delinquentComplaintsHispanicPercent != null) {
			document.addField("delinquentComplaintsHispanicPercent_indexed_double", delinquentComplaintsHispanicPercent.doubleValue());
			document.addField("delinquentComplaintsHispanicPercent_stored_double", delinquentComplaintsHispanicPercent.doubleValue());
		}
		if(delinquentComplaintsMultiRacial != null) {
			document.addField("delinquentComplaintsMultiRacial_indexed_long", delinquentComplaintsMultiRacial);
			document.addField("delinquentComplaintsMultiRacial_stored_long", delinquentComplaintsMultiRacial);
		}
		if(delinquentComplaintsMultiRacialPercent != null) {
			document.addField("delinquentComplaintsMultiRacialPercent_indexed_double", delinquentComplaintsMultiRacialPercent.doubleValue());
			document.addField("delinquentComplaintsMultiRacialPercent_stored_double", delinquentComplaintsMultiRacialPercent.doubleValue());
		}
		if(delinquentComplaintsIndian != null) {
			document.addField("delinquentComplaintsIndian_indexed_long", delinquentComplaintsIndian);
			document.addField("delinquentComplaintsIndian_stored_long", delinquentComplaintsIndian);
		}
		if(delinquentComplaintsIndianPercent != null) {
			document.addField("delinquentComplaintsIndianPercent_indexed_double", delinquentComplaintsIndianPercent.doubleValue());
			document.addField("delinquentComplaintsIndianPercent_stored_double", delinquentComplaintsIndianPercent.doubleValue());
		}
		if(delinquentComplaintsWhite != null) {
			document.addField("delinquentComplaintsWhite_indexed_long", delinquentComplaintsWhite);
			document.addField("delinquentComplaintsWhite_stored_long", delinquentComplaintsWhite);
		}
		if(delinquentComplaintsWhitePercent != null) {
			document.addField("delinquentComplaintsWhitePercent_indexed_double", delinquentComplaintsWhitePercent.doubleValue());
			document.addField("delinquentComplaintsWhitePercent_stored_double", delinquentComplaintsWhitePercent.doubleValue());
		}
		if(delinquentComplaintsPacificIslander != null) {
			document.addField("delinquentComplaintsPacificIslander_indexed_long", delinquentComplaintsPacificIslander);
			document.addField("delinquentComplaintsPacificIslander_stored_long", delinquentComplaintsPacificIslander);
		}
		if(delinquentComplaintsPacificIslanderPercent != null) {
			document.addField("delinquentComplaintsPacificIslanderPercent_indexed_double", delinquentComplaintsPacificIslanderPercent.doubleValue());
			document.addField("delinquentComplaintsPacificIslanderPercent_stored_double", delinquentComplaintsPacificIslanderPercent.doubleValue());
		}
		if(shortTermSuspensionRate != null) {
			document.addField("shortTermSuspensionRate_indexed_long", shortTermSuspensionRate);
			document.addField("shortTermSuspensionRate_stored_long", shortTermSuspensionRate);
		}
		if(shortTermSuspensionsTotal != null) {
			document.addField("shortTermSuspensionsTotal_indexed_long", shortTermSuspensionsTotal);
			document.addField("shortTermSuspensionsTotal_stored_long", shortTermSuspensionsTotal);
		}
		if(longTermSuspensionsTotal != null) {
			document.addField("longTermSuspensionsTotal_indexed_long", longTermSuspensionsTotal);
			document.addField("longTermSuspensionsTotal_stored_long", longTermSuspensionsTotal);
		}
		if(expulsionsTotal != null) {
			document.addField("expulsionsTotal_indexed_long", expulsionsTotal);
			document.addField("expulsionsTotal_stored_long", expulsionsTotal);
		}
		if(shortTermSuspensionsAsianFemale != null) {
			document.addField("shortTermSuspensionsAsianFemale_indexed_long", shortTermSuspensionsAsianFemale);
			document.addField("shortTermSuspensionsAsianFemale_stored_long", shortTermSuspensionsAsianFemale);
		}
		if(shortTermSuspensionsAsianMale != null) {
			document.addField("shortTermSuspensionsAsianMale_indexed_long", shortTermSuspensionsAsianMale);
			document.addField("shortTermSuspensionsAsianMale_stored_long", shortTermSuspensionsAsianMale);
		}
		if(shortTermSuspensionsAsianTotal != null) {
			document.addField("shortTermSuspensionsAsianTotal_indexed_long", shortTermSuspensionsAsianTotal);
			document.addField("shortTermSuspensionsAsianTotal_stored_long", shortTermSuspensionsAsianTotal);
		}
		if(shortTermSuspensionsAsianPercent != null) {
			document.addField("shortTermSuspensionsAsianPercent_indexed_double", shortTermSuspensionsAsianPercent.doubleValue());
			document.addField("shortTermSuspensionsAsianPercent_stored_double", shortTermSuspensionsAsianPercent.doubleValue());
		}
		if(shortTermSuspensionsAsianRate != null) {
			document.addField("shortTermSuspensionsAsianRate_indexed_double", shortTermSuspensionsAsianRate.doubleValue());
			document.addField("shortTermSuspensionsAsianRate_stored_double", shortTermSuspensionsAsianRate.doubleValue());
		}
		if(shortTermSuspensionsBlackFemale != null) {
			document.addField("shortTermSuspensionsBlackFemale_indexed_long", shortTermSuspensionsBlackFemale);
			document.addField("shortTermSuspensionsBlackFemale_stored_long", shortTermSuspensionsBlackFemale);
		}
		if(shortTermSuspensionsBlackMale != null) {
			document.addField("shortTermSuspensionsBlackMale_indexed_long", shortTermSuspensionsBlackMale);
			document.addField("shortTermSuspensionsBlackMale_stored_long", shortTermSuspensionsBlackMale);
		}
		if(shortTermSuspensionsBlackTotal != null) {
			document.addField("shortTermSuspensionsBlackTotal_indexed_long", shortTermSuspensionsBlackTotal);
			document.addField("shortTermSuspensionsBlackTotal_stored_long", shortTermSuspensionsBlackTotal);
		}
		if(shortTermSuspensionsBlackPercent != null) {
			document.addField("shortTermSuspensionsBlackPercent_indexed_double", shortTermSuspensionsBlackPercent.doubleValue());
			document.addField("shortTermSuspensionsBlackPercent_stored_double", shortTermSuspensionsBlackPercent.doubleValue());
		}
		if(shortTermSuspensionsBlackRate != null) {
			document.addField("shortTermSuspensionsBlackRate_indexed_double", shortTermSuspensionsBlackRate.doubleValue());
			document.addField("shortTermSuspensionsBlackRate_stored_double", shortTermSuspensionsBlackRate.doubleValue());
		}
		if(shortTermSuspensionsHispanicFemale != null) {
			document.addField("shortTermSuspensionsHispanicFemale_indexed_long", shortTermSuspensionsHispanicFemale);
			document.addField("shortTermSuspensionsHispanicFemale_stored_long", shortTermSuspensionsHispanicFemale);
		}
		if(shortTermSuspensionsHispanicMale != null) {
			document.addField("shortTermSuspensionsHispanicMale_indexed_long", shortTermSuspensionsHispanicMale);
			document.addField("shortTermSuspensionsHispanicMale_stored_long", shortTermSuspensionsHispanicMale);
		}
		if(shortTermSuspensionsHispanicTotal != null) {
			document.addField("shortTermSuspensionsHispanicTotal_indexed_long", shortTermSuspensionsHispanicTotal);
			document.addField("shortTermSuspensionsHispanicTotal_stored_long", shortTermSuspensionsHispanicTotal);
		}
		if(shortTermSuspensionsHispanicPercent != null) {
			document.addField("shortTermSuspensionsHispanicPercent_indexed_double", shortTermSuspensionsHispanicPercent.doubleValue());
			document.addField("shortTermSuspensionsHispanicPercent_stored_double", shortTermSuspensionsHispanicPercent.doubleValue());
		}
		if(shortTermSuspensionsHispanicRate != null) {
			document.addField("shortTermSuspensionsHispanicRate_indexed_double", shortTermSuspensionsHispanicRate.doubleValue());
			document.addField("shortTermSuspensionsHispanicRate_stored_double", shortTermSuspensionsHispanicRate.doubleValue());
		}
		if(shortTermSuspensionsIndianFemale != null) {
			document.addField("shortTermSuspensionsIndianFemale_indexed_long", shortTermSuspensionsIndianFemale);
			document.addField("shortTermSuspensionsIndianFemale_stored_long", shortTermSuspensionsIndianFemale);
		}
		if(shortTermSuspensionsIndianMale != null) {
			document.addField("shortTermSuspensionsIndianMale_indexed_long", shortTermSuspensionsIndianMale);
			document.addField("shortTermSuspensionsIndianMale_stored_long", shortTermSuspensionsIndianMale);
		}
		if(shortTermSuspensionsIndianTotal != null) {
			document.addField("shortTermSuspensionsIndianTotal_indexed_long", shortTermSuspensionsIndianTotal);
			document.addField("shortTermSuspensionsIndianTotal_stored_long", shortTermSuspensionsIndianTotal);
		}
		if(shortTermSuspensionsIndianPercent != null) {
			document.addField("shortTermSuspensionsIndianPercent_indexed_double", shortTermSuspensionsIndianPercent.doubleValue());
			document.addField("shortTermSuspensionsIndianPercent_stored_double", shortTermSuspensionsIndianPercent.doubleValue());
		}
		if(shortTermSuspensionsIndianRate != null) {
			document.addField("shortTermSuspensionsIndianRate_indexed_double", shortTermSuspensionsIndianRate.doubleValue());
			document.addField("shortTermSuspensionsIndianRate_stored_double", shortTermSuspensionsIndianRate.doubleValue());
		}
		if(shortTermSuspensionsMultiRacialFemale != null) {
			document.addField("shortTermSuspensionsMultiRacialFemale_indexed_long", shortTermSuspensionsMultiRacialFemale);
			document.addField("shortTermSuspensionsMultiRacialFemale_stored_long", shortTermSuspensionsMultiRacialFemale);
		}
		if(shortTermSuspensionsMultiRacialMale != null) {
			document.addField("shortTermSuspensionsMultiRacialMale_indexed_long", shortTermSuspensionsMultiRacialMale);
			document.addField("shortTermSuspensionsMultiRacialMale_stored_long", shortTermSuspensionsMultiRacialMale);
		}
		if(shortTermSuspensionsMultiRacialTotal != null) {
			document.addField("shortTermSuspensionsMultiRacialTotal_indexed_long", shortTermSuspensionsMultiRacialTotal);
			document.addField("shortTermSuspensionsMultiRacialTotal_stored_long", shortTermSuspensionsMultiRacialTotal);
		}
		if(shortTermSuspensionsMultiRacialPercent != null) {
			document.addField("shortTermSuspensionsMultiRacialPercent_indexed_double", shortTermSuspensionsMultiRacialPercent.doubleValue());
			document.addField("shortTermSuspensionsMultiRacialPercent_stored_double", shortTermSuspensionsMultiRacialPercent.doubleValue());
		}
		if(shortTermSuspensionsMultiRacialRate != null) {
			document.addField("shortTermSuspensionsMultiRacialRate_indexed_double", shortTermSuspensionsMultiRacialRate.doubleValue());
			document.addField("shortTermSuspensionsMultiRacialRate_stored_double", shortTermSuspensionsMultiRacialRate.doubleValue());
		}
		if(shortTermSuspensionsPacificIslanderFemale != null) {
			document.addField("shortTermSuspensionsPacificIslanderFemale_indexed_long", shortTermSuspensionsPacificIslanderFemale);
			document.addField("shortTermSuspensionsPacificIslanderFemale_stored_long", shortTermSuspensionsPacificIslanderFemale);
		}
		if(shortTermSuspensionsPacificIslanderMale != null) {
			document.addField("shortTermSuspensionsPacificIslanderMale_indexed_long", shortTermSuspensionsPacificIslanderMale);
			document.addField("shortTermSuspensionsPacificIslanderMale_stored_long", shortTermSuspensionsPacificIslanderMale);
		}
		if(shortTermSuspensionsPacificIslanderTotal != null) {
			document.addField("shortTermSuspensionsPacificIslanderTotal_indexed_long", shortTermSuspensionsPacificIslanderTotal);
			document.addField("shortTermSuspensionsPacificIslanderTotal_stored_long", shortTermSuspensionsPacificIslanderTotal);
		}
		if(shortTermSuspensionsPacificIslanderPercent != null) {
			document.addField("shortTermSuspensionsPacificIslanderPercent_indexed_double", shortTermSuspensionsPacificIslanderPercent.doubleValue());
			document.addField("shortTermSuspensionsPacificIslanderPercent_stored_double", shortTermSuspensionsPacificIslanderPercent.doubleValue());
		}
		if(shortTermSuspensionsPacificIslanderRate != null) {
			document.addField("shortTermSuspensionsPacificIslanderRate_indexed_double", shortTermSuspensionsPacificIslanderRate.doubleValue());
			document.addField("shortTermSuspensionsPacificIslanderRate_stored_double", shortTermSuspensionsPacificIslanderRate.doubleValue());
		}
		if(shortTermSuspensionsWhiteFemale != null) {
			document.addField("shortTermSuspensionsWhiteFemale_indexed_long", shortTermSuspensionsWhiteFemale);
			document.addField("shortTermSuspensionsWhiteFemale_stored_long", shortTermSuspensionsWhiteFemale);
		}
		if(shortTermSuspensionsWhiteMale != null) {
			document.addField("shortTermSuspensionsWhiteMale_indexed_long", shortTermSuspensionsWhiteMale);
			document.addField("shortTermSuspensionsWhiteMale_stored_long", shortTermSuspensionsWhiteMale);
		}
		if(shortTermSuspensionsWhiteTotal != null) {
			document.addField("shortTermSuspensionsWhiteTotal_indexed_long", shortTermSuspensionsWhiteTotal);
			document.addField("shortTermSuspensionsWhiteTotal_stored_long", shortTermSuspensionsWhiteTotal);
		}
		if(shortTermSuspensionsWhitePercent != null) {
			document.addField("shortTermSuspensionsWhitePercent_indexed_double", shortTermSuspensionsWhitePercent.doubleValue());
			document.addField("shortTermSuspensionsWhitePercent_stored_double", shortTermSuspensionsWhitePercent.doubleValue());
		}
		if(shortTermSuspensionsWhiteRate != null) {
			document.addField("shortTermSuspensionsWhiteRate_indexed_double", shortTermSuspensionsWhiteRate.doubleValue());
			document.addField("shortTermSuspensionsWhiteRate_stored_double", shortTermSuspensionsWhiteRate.doubleValue());
		}
		if(shortTermSuspensionsAllRate != null) {
			document.addField("shortTermSuspensionsAllRate_indexed_double", shortTermSuspensionsAllRate.doubleValue());
			document.addField("shortTermSuspensionsAllRate_stored_double", shortTermSuspensionsAllRate.doubleValue());
		}
		if(shortTermSuspensionsBlackVsWhite != null) {
			document.addField("shortTermSuspensionsBlackVsWhite_indexed_double", shortTermSuspensionsBlackVsWhite.doubleValue());
			document.addField("shortTermSuspensionsBlackVsWhite_stored_double", shortTermSuspensionsBlackVsWhite.doubleValue());
		}
		if(stateKey != null) {
			document.addField("stateKey_indexed_long", stateKey);
			document.addField("stateKey_stored_long", stateKey);
		}
		if(stateId != null) {
			document.addField("stateId_indexed_string", stateId);
			document.addField("stateId_stored_string", stateId);
		}
		if(agencyId != null) {
			document.addField("agencyId_indexed_string", agencyId);
			document.addField("agencyId_stored_string", agencyId);
		}
		if(stateName != null) {
			document.addField("stateName_indexed_string", stateName);
			document.addField("stateName_stored_string", stateName);
		}
		if(stateAbbreviation != null) {
			document.addField("stateAbbreviation_indexed_string", stateAbbreviation);
			document.addField("stateAbbreviation_stored_string", stateAbbreviation);
		}
		if(agencyName != null) {
			document.addField("agencyName_indexed_string", agencyName);
			document.addField("agencyName_stored_string", agencyName);
		}
		if(agencyCompleteName != null) {
			document.addField("agencyCompleteName_indexed_string", agencyCompleteName);
			document.addField("agencyCompleteName_stored_string", agencyCompleteName);
		}
		if(agencyDemographicsGraph != null) {
			document.addField("agencyDemographicsGraph_stored_string", agencyDemographicsGraph);
		}
		if(agencyStudentsByRaceGraph != null) {
			document.addField("agencyStudentsByRaceGraph_stored_string", agencyStudentsByRaceGraph);
		}
		if(agencyTeachersByRaceGraph != null) {
			document.addField("agencyTeachersByRaceGraph_stored_string", agencyTeachersByRaceGraph);
		}
		if(agencyGrades3To8Graph != null) {
			document.addField("agencyGrades3To8Graph_stored_string", agencyGrades3To8Graph);
		}
		if(agencyGrades9To12Graph != null) {
			document.addField("agencyGrades9To12Graph_stored_string", agencyGrades9To12Graph);
		}
		if(agencyGraduatesWithin4YearsGraph != null) {
			document.addField("agencyGraduatesWithin4YearsGraph_stored_string", agencyGraduatesWithin4YearsGraph);
		}
		if(suspensionsByRaceGraph != null) {
			document.addField("suspensionsByRaceGraph_stored_string", suspensionsByRaceGraph);
		}
		if(suspensionRatesByRaceGraph != null) {
			document.addField("suspensionRatesByRaceGraph_stored_string", suspensionRatesByRaceGraph);
		}
		if(countySchoolBasedComplaintsGraph != null) {
			document.addField("countySchoolBasedComplaintsGraph_stored_string", countySchoolBasedComplaintsGraph);
		}
		if(schoolBasedComplaintsGraph != null) {
			document.addField("schoolBasedComplaintsGraph_stored_string", schoolBasedComplaintsGraph);
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
			case "reportCardYearsStr":
				return "reportCardYearsStr_indexed_string";
			case "agencyKey":
				return "agencyKey_indexed_long";
			case "pupilsTotal":
				return "pupilsTotal_indexed_long";
			case "pupilsIndianFemale":
				return "pupilsIndianFemale_indexed_long";
			case "pupilsIndianMale":
				return "pupilsIndianMale_indexed_long";
			case "pupilsIndianTotal":
				return "pupilsIndianTotal_indexed_long";
			case "pupilsIndianPercent":
				return "pupilsIndianPercent_indexed_double";
			case "pupilsAsianFemale":
				return "pupilsAsianFemale_indexed_long";
			case "pupilsAsianMale":
				return "pupilsAsianMale_indexed_long";
			case "pupilsAsianTotal":
				return "pupilsAsianTotal_indexed_long";
			case "pupilsAsianPercent":
				return "pupilsAsianPercent_indexed_double";
			case "pupilsHispanicFemale":
				return "pupilsHispanicFemale_indexed_long";
			case "pupilsHispanicMale":
				return "pupilsHispanicMale_indexed_long";
			case "pupilsHispanicTotal":
				return "pupilsHispanicTotal_indexed_long";
			case "pupilsHispanicPercent":
				return "pupilsHispanicPercent_indexed_double";
			case "pupilsBlackFemale":
				return "pupilsBlackFemale_indexed_long";
			case "pupilsBlackMale":
				return "pupilsBlackMale_indexed_long";
			case "pupilsBlackTotal":
				return "pupilsBlackTotal_indexed_long";
			case "pupilsBlackPercent":
				return "pupilsBlackPercent_indexed_double";
			case "pupilsWhiteFemale":
				return "pupilsWhiteFemale_indexed_long";
			case "pupilsWhiteMale":
				return "pupilsWhiteMale_indexed_long";
			case "pupilsWhiteTotal":
				return "pupilsWhiteTotal_indexed_long";
			case "pupilsWhitePercent":
				return "pupilsWhitePercent_indexed_double";
			case "pupilsPacificIslanderFemale":
				return "pupilsPacificIslanderFemale_indexed_long";
			case "pupilsPacificIslanderMale":
				return "pupilsPacificIslanderMale_indexed_long";
			case "pupilsPacificIslanderTotal":
				return "pupilsPacificIslanderTotal_indexed_long";
			case "pupilsPacificIslanderPercent":
				return "pupilsPacificIslanderPercent_indexed_double";
			case "pupilsMultiRacialFemale":
				return "pupilsMultiRacialFemale_indexed_long";
			case "pupilsMultiRacialMale":
				return "pupilsMultiRacialMale_indexed_long";
			case "pupilsMultiRacialTotal":
				return "pupilsMultiRacialTotal_indexed_long";
			case "pupilsMultiRacialPercent":
				return "pupilsMultiRacialPercent_indexed_double";
			case "teachersMale":
				return "teachersMale_indexed_long";
			case "teachersFemale":
				return "teachersFemale_indexed_long";
			case "teachersTotal":
				return "teachersTotal_indexed_long";
			case "teachersWhiteTotal":
				return "teachersWhiteTotal_indexed_long";
			case "teachersWhitePercent":
				return "teachersWhitePercent_indexed_double";
			case "teachersBlackTotal":
				return "teachersBlackTotal_indexed_long";
			case "teachersBlackPercent":
				return "teachersBlackPercent_indexed_double";
			case "teachersOtherTotal":
				return "teachersOtherTotal_indexed_long";
			case "teachersOtherPercent":
				return "teachersOtherPercent_indexed_double";
			case "delinquentComplaintsTotal":
				return "delinquentComplaintsTotal_indexed_long";
			case "delinquentComplaintsAtSchool":
				return "delinquentComplaintsAtSchool_indexed_long";
			case "delinquentComplaintsAtSchoolPercent":
				return "delinquentComplaintsAtSchoolPercent_indexed_double";
			case "delinquentComplaintsAsian":
				return "delinquentComplaintsAsian_indexed_long";
			case "delinquentComplaintsAsianPercent":
				return "delinquentComplaintsAsianPercent_indexed_double";
			case "delinquentComplaintsBlack":
				return "delinquentComplaintsBlack_indexed_long";
			case "delinquentComplaintsBlackPercent":
				return "delinquentComplaintsBlackPercent_indexed_double";
			case "delinquentComplaintsHispanic":
				return "delinquentComplaintsHispanic_indexed_long";
			case "delinquentComplaintsHispanicPercent":
				return "delinquentComplaintsHispanicPercent_indexed_double";
			case "delinquentComplaintsMultiRacial":
				return "delinquentComplaintsMultiRacial_indexed_long";
			case "delinquentComplaintsMultiRacialPercent":
				return "delinquentComplaintsMultiRacialPercent_indexed_double";
			case "delinquentComplaintsIndian":
				return "delinquentComplaintsIndian_indexed_long";
			case "delinquentComplaintsIndianPercent":
				return "delinquentComplaintsIndianPercent_indexed_double";
			case "delinquentComplaintsWhite":
				return "delinquentComplaintsWhite_indexed_long";
			case "delinquentComplaintsWhitePercent":
				return "delinquentComplaintsWhitePercent_indexed_double";
			case "delinquentComplaintsPacificIslander":
				return "delinquentComplaintsPacificIslander_indexed_long";
			case "delinquentComplaintsPacificIslanderPercent":
				return "delinquentComplaintsPacificIslanderPercent_indexed_double";
			case "shortTermSuspensionRate":
				return "shortTermSuspensionRate_indexed_long";
			case "shortTermSuspensionsTotal":
				return "shortTermSuspensionsTotal_indexed_long";
			case "longTermSuspensionsTotal":
				return "longTermSuspensionsTotal_indexed_long";
			case "expulsionsTotal":
				return "expulsionsTotal_indexed_long";
			case "shortTermSuspensionsAsianFemale":
				return "shortTermSuspensionsAsianFemale_indexed_long";
			case "shortTermSuspensionsAsianMale":
				return "shortTermSuspensionsAsianMale_indexed_long";
			case "shortTermSuspensionsAsianTotal":
				return "shortTermSuspensionsAsianTotal_indexed_long";
			case "shortTermSuspensionsAsianPercent":
				return "shortTermSuspensionsAsianPercent_indexed_double";
			case "shortTermSuspensionsAsianRate":
				return "shortTermSuspensionsAsianRate_indexed_double";
			case "shortTermSuspensionsBlackFemale":
				return "shortTermSuspensionsBlackFemale_indexed_long";
			case "shortTermSuspensionsBlackMale":
				return "shortTermSuspensionsBlackMale_indexed_long";
			case "shortTermSuspensionsBlackTotal":
				return "shortTermSuspensionsBlackTotal_indexed_long";
			case "shortTermSuspensionsBlackPercent":
				return "shortTermSuspensionsBlackPercent_indexed_double";
			case "shortTermSuspensionsBlackRate":
				return "shortTermSuspensionsBlackRate_indexed_double";
			case "shortTermSuspensionsHispanicFemale":
				return "shortTermSuspensionsHispanicFemale_indexed_long";
			case "shortTermSuspensionsHispanicMale":
				return "shortTermSuspensionsHispanicMale_indexed_long";
			case "shortTermSuspensionsHispanicTotal":
				return "shortTermSuspensionsHispanicTotal_indexed_long";
			case "shortTermSuspensionsHispanicPercent":
				return "shortTermSuspensionsHispanicPercent_indexed_double";
			case "shortTermSuspensionsHispanicRate":
				return "shortTermSuspensionsHispanicRate_indexed_double";
			case "shortTermSuspensionsIndianFemale":
				return "shortTermSuspensionsIndianFemale_indexed_long";
			case "shortTermSuspensionsIndianMale":
				return "shortTermSuspensionsIndianMale_indexed_long";
			case "shortTermSuspensionsIndianTotal":
				return "shortTermSuspensionsIndianTotal_indexed_long";
			case "shortTermSuspensionsIndianPercent":
				return "shortTermSuspensionsIndianPercent_indexed_double";
			case "shortTermSuspensionsIndianRate":
				return "shortTermSuspensionsIndianRate_indexed_double";
			case "shortTermSuspensionsMultiRacialFemale":
				return "shortTermSuspensionsMultiRacialFemale_indexed_long";
			case "shortTermSuspensionsMultiRacialMale":
				return "shortTermSuspensionsMultiRacialMale_indexed_long";
			case "shortTermSuspensionsMultiRacialTotal":
				return "shortTermSuspensionsMultiRacialTotal_indexed_long";
			case "shortTermSuspensionsMultiRacialPercent":
				return "shortTermSuspensionsMultiRacialPercent_indexed_double";
			case "shortTermSuspensionsMultiRacialRate":
				return "shortTermSuspensionsMultiRacialRate_indexed_double";
			case "shortTermSuspensionsPacificIslanderFemale":
				return "shortTermSuspensionsPacificIslanderFemale_indexed_long";
			case "shortTermSuspensionsPacificIslanderMale":
				return "shortTermSuspensionsPacificIslanderMale_indexed_long";
			case "shortTermSuspensionsPacificIslanderTotal":
				return "shortTermSuspensionsPacificIslanderTotal_indexed_long";
			case "shortTermSuspensionsPacificIslanderPercent":
				return "shortTermSuspensionsPacificIslanderPercent_indexed_double";
			case "shortTermSuspensionsPacificIslanderRate":
				return "shortTermSuspensionsPacificIslanderRate_indexed_double";
			case "shortTermSuspensionsWhiteFemale":
				return "shortTermSuspensionsWhiteFemale_indexed_long";
			case "shortTermSuspensionsWhiteMale":
				return "shortTermSuspensionsWhiteMale_indexed_long";
			case "shortTermSuspensionsWhiteTotal":
				return "shortTermSuspensionsWhiteTotal_indexed_long";
			case "shortTermSuspensionsWhitePercent":
				return "shortTermSuspensionsWhitePercent_indexed_double";
			case "shortTermSuspensionsWhiteRate":
				return "shortTermSuspensionsWhiteRate_indexed_double";
			case "shortTermSuspensionsAllRate":
				return "shortTermSuspensionsAllRate_indexed_double";
			case "shortTermSuspensionsBlackVsWhite":
				return "shortTermSuspensionsBlackVsWhite_indexed_double";
			case "stateKey":
				return "stateKey_indexed_long";
			case "stateId":
				return "stateId_indexed_string";
			case "agencyId":
				return "agencyId_indexed_string";
			case "stateName":
				return "stateName_indexed_string";
			case "stateAbbreviation":
				return "stateAbbreviation_indexed_string";
			case "agencyName":
				return "agencyName_indexed_string";
			case "agencyCompleteName":
				return "agencyCompleteName_indexed_string";
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

		String reportCardYearsStr = (String)solrDocument.get("reportCardYearsStr_stored_string");
		if(reportCardYearsStr != null)
			oReportCard.setReportCardYearsStr(reportCardYearsStr);

		Long agencyKey = (Long)solrDocument.get("agencyKey_stored_long");
		if(agencyKey != null)
			oReportCard.setAgencyKey(agencyKey);

		Long pupilsTotal = (Long)solrDocument.get("pupilsTotal_stored_long");
		if(pupilsTotal != null)
			oReportCard.setPupilsTotal(pupilsTotal);

		Long pupilsIndianFemale = (Long)solrDocument.get("pupilsIndianFemale_stored_long");
		if(pupilsIndianFemale != null)
			oReportCard.setPupilsIndianFemale(pupilsIndianFemale);

		Long pupilsIndianMale = (Long)solrDocument.get("pupilsIndianMale_stored_long");
		if(pupilsIndianMale != null)
			oReportCard.setPupilsIndianMale(pupilsIndianMale);

		Long pupilsIndianTotal = (Long)solrDocument.get("pupilsIndianTotal_stored_long");
		if(pupilsIndianTotal != null)
			oReportCard.setPupilsIndianTotal(pupilsIndianTotal);

		Double pupilsIndianPercent = (Double)solrDocument.get("pupilsIndianPercent_stored_double");
		if(pupilsIndianPercent != null)
			oReportCard.setPupilsIndianPercent(pupilsIndianPercent);

		Long pupilsAsianFemale = (Long)solrDocument.get("pupilsAsianFemale_stored_long");
		if(pupilsAsianFemale != null)
			oReportCard.setPupilsAsianFemale(pupilsAsianFemale);

		Long pupilsAsianMale = (Long)solrDocument.get("pupilsAsianMale_stored_long");
		if(pupilsAsianMale != null)
			oReportCard.setPupilsAsianMale(pupilsAsianMale);

		Long pupilsAsianTotal = (Long)solrDocument.get("pupilsAsianTotal_stored_long");
		if(pupilsAsianTotal != null)
			oReportCard.setPupilsAsianTotal(pupilsAsianTotal);

		Double pupilsAsianPercent = (Double)solrDocument.get("pupilsAsianPercent_stored_double");
		if(pupilsAsianPercent != null)
			oReportCard.setPupilsAsianPercent(pupilsAsianPercent);

		Long pupilsHispanicFemale = (Long)solrDocument.get("pupilsHispanicFemale_stored_long");
		if(pupilsHispanicFemale != null)
			oReportCard.setPupilsHispanicFemale(pupilsHispanicFemale);

		Long pupilsHispanicMale = (Long)solrDocument.get("pupilsHispanicMale_stored_long");
		if(pupilsHispanicMale != null)
			oReportCard.setPupilsHispanicMale(pupilsHispanicMale);

		Long pupilsHispanicTotal = (Long)solrDocument.get("pupilsHispanicTotal_stored_long");
		if(pupilsHispanicTotal != null)
			oReportCard.setPupilsHispanicTotal(pupilsHispanicTotal);

		Double pupilsHispanicPercent = (Double)solrDocument.get("pupilsHispanicPercent_stored_double");
		if(pupilsHispanicPercent != null)
			oReportCard.setPupilsHispanicPercent(pupilsHispanicPercent);

		Long pupilsBlackFemale = (Long)solrDocument.get("pupilsBlackFemale_stored_long");
		if(pupilsBlackFemale != null)
			oReportCard.setPupilsBlackFemale(pupilsBlackFemale);

		Long pupilsBlackMale = (Long)solrDocument.get("pupilsBlackMale_stored_long");
		if(pupilsBlackMale != null)
			oReportCard.setPupilsBlackMale(pupilsBlackMale);

		Long pupilsBlackTotal = (Long)solrDocument.get("pupilsBlackTotal_stored_long");
		if(pupilsBlackTotal != null)
			oReportCard.setPupilsBlackTotal(pupilsBlackTotal);

		Double pupilsBlackPercent = (Double)solrDocument.get("pupilsBlackPercent_stored_double");
		if(pupilsBlackPercent != null)
			oReportCard.setPupilsBlackPercent(pupilsBlackPercent);

		Long pupilsWhiteFemale = (Long)solrDocument.get("pupilsWhiteFemale_stored_long");
		if(pupilsWhiteFemale != null)
			oReportCard.setPupilsWhiteFemale(pupilsWhiteFemale);

		Long pupilsWhiteMale = (Long)solrDocument.get("pupilsWhiteMale_stored_long");
		if(pupilsWhiteMale != null)
			oReportCard.setPupilsWhiteMale(pupilsWhiteMale);

		Long pupilsWhiteTotal = (Long)solrDocument.get("pupilsWhiteTotal_stored_long");
		if(pupilsWhiteTotal != null)
			oReportCard.setPupilsWhiteTotal(pupilsWhiteTotal);

		Double pupilsWhitePercent = (Double)solrDocument.get("pupilsWhitePercent_stored_double");
		if(pupilsWhitePercent != null)
			oReportCard.setPupilsWhitePercent(pupilsWhitePercent);

		Long pupilsPacificIslanderFemale = (Long)solrDocument.get("pupilsPacificIslanderFemale_stored_long");
		if(pupilsPacificIslanderFemale != null)
			oReportCard.setPupilsPacificIslanderFemale(pupilsPacificIslanderFemale);

		Long pupilsPacificIslanderMale = (Long)solrDocument.get("pupilsPacificIslanderMale_stored_long");
		if(pupilsPacificIslanderMale != null)
			oReportCard.setPupilsPacificIslanderMale(pupilsPacificIslanderMale);

		Long pupilsPacificIslanderTotal = (Long)solrDocument.get("pupilsPacificIslanderTotal_stored_long");
		if(pupilsPacificIslanderTotal != null)
			oReportCard.setPupilsPacificIslanderTotal(pupilsPacificIslanderTotal);

		Double pupilsPacificIslanderPercent = (Double)solrDocument.get("pupilsPacificIslanderPercent_stored_double");
		if(pupilsPacificIslanderPercent != null)
			oReportCard.setPupilsPacificIslanderPercent(pupilsPacificIslanderPercent);

		Long pupilsMultiRacialFemale = (Long)solrDocument.get("pupilsMultiRacialFemale_stored_long");
		if(pupilsMultiRacialFemale != null)
			oReportCard.setPupilsMultiRacialFemale(pupilsMultiRacialFemale);

		Long pupilsMultiRacialMale = (Long)solrDocument.get("pupilsMultiRacialMale_stored_long");
		if(pupilsMultiRacialMale != null)
			oReportCard.setPupilsMultiRacialMale(pupilsMultiRacialMale);

		Long pupilsMultiRacialTotal = (Long)solrDocument.get("pupilsMultiRacialTotal_stored_long");
		if(pupilsMultiRacialTotal != null)
			oReportCard.setPupilsMultiRacialTotal(pupilsMultiRacialTotal);

		Double pupilsMultiRacialPercent = (Double)solrDocument.get("pupilsMultiRacialPercent_stored_double");
		if(pupilsMultiRacialPercent != null)
			oReportCard.setPupilsMultiRacialPercent(pupilsMultiRacialPercent);

		Long teachersMale = (Long)solrDocument.get("teachersMale_stored_long");
		if(teachersMale != null)
			oReportCard.setTeachersMale(teachersMale);

		Long teachersFemale = (Long)solrDocument.get("teachersFemale_stored_long");
		if(teachersFemale != null)
			oReportCard.setTeachersFemale(teachersFemale);

		Long teachersTotal = (Long)solrDocument.get("teachersTotal_stored_long");
		if(teachersTotal != null)
			oReportCard.setTeachersTotal(teachersTotal);

		Long teachersWhiteTotal = (Long)solrDocument.get("teachersWhiteTotal_stored_long");
		if(teachersWhiteTotal != null)
			oReportCard.setTeachersWhiteTotal(teachersWhiteTotal);

		Double teachersWhitePercent = (Double)solrDocument.get("teachersWhitePercent_stored_double");
		if(teachersWhitePercent != null)
			oReportCard.setTeachersWhitePercent(teachersWhitePercent);

		Long teachersBlackTotal = (Long)solrDocument.get("teachersBlackTotal_stored_long");
		if(teachersBlackTotal != null)
			oReportCard.setTeachersBlackTotal(teachersBlackTotal);

		Double teachersBlackPercent = (Double)solrDocument.get("teachersBlackPercent_stored_double");
		if(teachersBlackPercent != null)
			oReportCard.setTeachersBlackPercent(teachersBlackPercent);

		Long teachersOtherTotal = (Long)solrDocument.get("teachersOtherTotal_stored_long");
		if(teachersOtherTotal != null)
			oReportCard.setTeachersOtherTotal(teachersOtherTotal);

		Double teachersOtherPercent = (Double)solrDocument.get("teachersOtherPercent_stored_double");
		if(teachersOtherPercent != null)
			oReportCard.setTeachersOtherPercent(teachersOtherPercent);

		Long delinquentComplaintsTotal = (Long)solrDocument.get("delinquentComplaintsTotal_stored_long");
		if(delinquentComplaintsTotal != null)
			oReportCard.setDelinquentComplaintsTotal(delinquentComplaintsTotal);

		Long delinquentComplaintsAtSchool = (Long)solrDocument.get("delinquentComplaintsAtSchool_stored_long");
		if(delinquentComplaintsAtSchool != null)
			oReportCard.setDelinquentComplaintsAtSchool(delinquentComplaintsAtSchool);

		Double delinquentComplaintsAtSchoolPercent = (Double)solrDocument.get("delinquentComplaintsAtSchoolPercent_stored_double");
		if(delinquentComplaintsAtSchoolPercent != null)
			oReportCard.setDelinquentComplaintsAtSchoolPercent(delinquentComplaintsAtSchoolPercent);

		Long delinquentComplaintsAsian = (Long)solrDocument.get("delinquentComplaintsAsian_stored_long");
		if(delinquentComplaintsAsian != null)
			oReportCard.setDelinquentComplaintsAsian(delinquentComplaintsAsian);

		Double delinquentComplaintsAsianPercent = (Double)solrDocument.get("delinquentComplaintsAsianPercent_stored_double");
		if(delinquentComplaintsAsianPercent != null)
			oReportCard.setDelinquentComplaintsAsianPercent(delinquentComplaintsAsianPercent);

		Long delinquentComplaintsBlack = (Long)solrDocument.get("delinquentComplaintsBlack_stored_long");
		if(delinquentComplaintsBlack != null)
			oReportCard.setDelinquentComplaintsBlack(delinquentComplaintsBlack);

		Double delinquentComplaintsBlackPercent = (Double)solrDocument.get("delinquentComplaintsBlackPercent_stored_double");
		if(delinquentComplaintsBlackPercent != null)
			oReportCard.setDelinquentComplaintsBlackPercent(delinquentComplaintsBlackPercent);

		Long delinquentComplaintsHispanic = (Long)solrDocument.get("delinquentComplaintsHispanic_stored_long");
		if(delinquentComplaintsHispanic != null)
			oReportCard.setDelinquentComplaintsHispanic(delinquentComplaintsHispanic);

		Double delinquentComplaintsHispanicPercent = (Double)solrDocument.get("delinquentComplaintsHispanicPercent_stored_double");
		if(delinquentComplaintsHispanicPercent != null)
			oReportCard.setDelinquentComplaintsHispanicPercent(delinquentComplaintsHispanicPercent);

		Long delinquentComplaintsMultiRacial = (Long)solrDocument.get("delinquentComplaintsMultiRacial_stored_long");
		if(delinquentComplaintsMultiRacial != null)
			oReportCard.setDelinquentComplaintsMultiRacial(delinquentComplaintsMultiRacial);

		Double delinquentComplaintsMultiRacialPercent = (Double)solrDocument.get("delinquentComplaintsMultiRacialPercent_stored_double");
		if(delinquentComplaintsMultiRacialPercent != null)
			oReportCard.setDelinquentComplaintsMultiRacialPercent(delinquentComplaintsMultiRacialPercent);

		Long delinquentComplaintsIndian = (Long)solrDocument.get("delinquentComplaintsIndian_stored_long");
		if(delinquentComplaintsIndian != null)
			oReportCard.setDelinquentComplaintsIndian(delinquentComplaintsIndian);

		Double delinquentComplaintsIndianPercent = (Double)solrDocument.get("delinquentComplaintsIndianPercent_stored_double");
		if(delinquentComplaintsIndianPercent != null)
			oReportCard.setDelinquentComplaintsIndianPercent(delinquentComplaintsIndianPercent);

		Long delinquentComplaintsWhite = (Long)solrDocument.get("delinquentComplaintsWhite_stored_long");
		if(delinquentComplaintsWhite != null)
			oReportCard.setDelinquentComplaintsWhite(delinquentComplaintsWhite);

		Double delinquentComplaintsWhitePercent = (Double)solrDocument.get("delinquentComplaintsWhitePercent_stored_double");
		if(delinquentComplaintsWhitePercent != null)
			oReportCard.setDelinquentComplaintsWhitePercent(delinquentComplaintsWhitePercent);

		Long delinquentComplaintsPacificIslander = (Long)solrDocument.get("delinquentComplaintsPacificIslander_stored_long");
		if(delinquentComplaintsPacificIslander != null)
			oReportCard.setDelinquentComplaintsPacificIslander(delinquentComplaintsPacificIslander);

		Double delinquentComplaintsPacificIslanderPercent = (Double)solrDocument.get("delinquentComplaintsPacificIslanderPercent_stored_double");
		if(delinquentComplaintsPacificIslanderPercent != null)
			oReportCard.setDelinquentComplaintsPacificIslanderPercent(delinquentComplaintsPacificIslanderPercent);

		Long shortTermSuspensionRate = (Long)solrDocument.get("shortTermSuspensionRate_stored_long");
		if(shortTermSuspensionRate != null)
			oReportCard.setShortTermSuspensionRate(shortTermSuspensionRate);

		Long shortTermSuspensionsTotal = (Long)solrDocument.get("shortTermSuspensionsTotal_stored_long");
		if(shortTermSuspensionsTotal != null)
			oReportCard.setShortTermSuspensionsTotal(shortTermSuspensionsTotal);

		Long longTermSuspensionsTotal = (Long)solrDocument.get("longTermSuspensionsTotal_stored_long");
		if(longTermSuspensionsTotal != null)
			oReportCard.setLongTermSuspensionsTotal(longTermSuspensionsTotal);

		Long expulsionsTotal = (Long)solrDocument.get("expulsionsTotal_stored_long");
		if(expulsionsTotal != null)
			oReportCard.setExpulsionsTotal(expulsionsTotal);

		Long shortTermSuspensionsAsianFemale = (Long)solrDocument.get("shortTermSuspensionsAsianFemale_stored_long");
		if(shortTermSuspensionsAsianFemale != null)
			oReportCard.setShortTermSuspensionsAsianFemale(shortTermSuspensionsAsianFemale);

		Long shortTermSuspensionsAsianMale = (Long)solrDocument.get("shortTermSuspensionsAsianMale_stored_long");
		if(shortTermSuspensionsAsianMale != null)
			oReportCard.setShortTermSuspensionsAsianMale(shortTermSuspensionsAsianMale);

		Long shortTermSuspensionsAsianTotal = (Long)solrDocument.get("shortTermSuspensionsAsianTotal_stored_long");
		if(shortTermSuspensionsAsianTotal != null)
			oReportCard.setShortTermSuspensionsAsianTotal(shortTermSuspensionsAsianTotal);

		Double shortTermSuspensionsAsianPercent = (Double)solrDocument.get("shortTermSuspensionsAsianPercent_stored_double");
		if(shortTermSuspensionsAsianPercent != null)
			oReportCard.setShortTermSuspensionsAsianPercent(shortTermSuspensionsAsianPercent);

		Double shortTermSuspensionsAsianRate = (Double)solrDocument.get("shortTermSuspensionsAsianRate_stored_double");
		if(shortTermSuspensionsAsianRate != null)
			oReportCard.setShortTermSuspensionsAsianRate(shortTermSuspensionsAsianRate);

		Long shortTermSuspensionsBlackFemale = (Long)solrDocument.get("shortTermSuspensionsBlackFemale_stored_long");
		if(shortTermSuspensionsBlackFemale != null)
			oReportCard.setShortTermSuspensionsBlackFemale(shortTermSuspensionsBlackFemale);

		Long shortTermSuspensionsBlackMale = (Long)solrDocument.get("shortTermSuspensionsBlackMale_stored_long");
		if(shortTermSuspensionsBlackMale != null)
			oReportCard.setShortTermSuspensionsBlackMale(shortTermSuspensionsBlackMale);

		Long shortTermSuspensionsBlackTotal = (Long)solrDocument.get("shortTermSuspensionsBlackTotal_stored_long");
		if(shortTermSuspensionsBlackTotal != null)
			oReportCard.setShortTermSuspensionsBlackTotal(shortTermSuspensionsBlackTotal);

		Double shortTermSuspensionsBlackPercent = (Double)solrDocument.get("shortTermSuspensionsBlackPercent_stored_double");
		if(shortTermSuspensionsBlackPercent != null)
			oReportCard.setShortTermSuspensionsBlackPercent(shortTermSuspensionsBlackPercent);

		Double shortTermSuspensionsBlackRate = (Double)solrDocument.get("shortTermSuspensionsBlackRate_stored_double");
		if(shortTermSuspensionsBlackRate != null)
			oReportCard.setShortTermSuspensionsBlackRate(shortTermSuspensionsBlackRate);

		Long shortTermSuspensionsHispanicFemale = (Long)solrDocument.get("shortTermSuspensionsHispanicFemale_stored_long");
		if(shortTermSuspensionsHispanicFemale != null)
			oReportCard.setShortTermSuspensionsHispanicFemale(shortTermSuspensionsHispanicFemale);

		Long shortTermSuspensionsHispanicMale = (Long)solrDocument.get("shortTermSuspensionsHispanicMale_stored_long");
		if(shortTermSuspensionsHispanicMale != null)
			oReportCard.setShortTermSuspensionsHispanicMale(shortTermSuspensionsHispanicMale);

		Long shortTermSuspensionsHispanicTotal = (Long)solrDocument.get("shortTermSuspensionsHispanicTotal_stored_long");
		if(shortTermSuspensionsHispanicTotal != null)
			oReportCard.setShortTermSuspensionsHispanicTotal(shortTermSuspensionsHispanicTotal);

		Double shortTermSuspensionsHispanicPercent = (Double)solrDocument.get("shortTermSuspensionsHispanicPercent_stored_double");
		if(shortTermSuspensionsHispanicPercent != null)
			oReportCard.setShortTermSuspensionsHispanicPercent(shortTermSuspensionsHispanicPercent);

		Double shortTermSuspensionsHispanicRate = (Double)solrDocument.get("shortTermSuspensionsHispanicRate_stored_double");
		if(shortTermSuspensionsHispanicRate != null)
			oReportCard.setShortTermSuspensionsHispanicRate(shortTermSuspensionsHispanicRate);

		Long shortTermSuspensionsIndianFemale = (Long)solrDocument.get("shortTermSuspensionsIndianFemale_stored_long");
		if(shortTermSuspensionsIndianFemale != null)
			oReportCard.setShortTermSuspensionsIndianFemale(shortTermSuspensionsIndianFemale);

		Long shortTermSuspensionsIndianMale = (Long)solrDocument.get("shortTermSuspensionsIndianMale_stored_long");
		if(shortTermSuspensionsIndianMale != null)
			oReportCard.setShortTermSuspensionsIndianMale(shortTermSuspensionsIndianMale);

		Long shortTermSuspensionsIndianTotal = (Long)solrDocument.get("shortTermSuspensionsIndianTotal_stored_long");
		if(shortTermSuspensionsIndianTotal != null)
			oReportCard.setShortTermSuspensionsIndianTotal(shortTermSuspensionsIndianTotal);

		Double shortTermSuspensionsIndianPercent = (Double)solrDocument.get("shortTermSuspensionsIndianPercent_stored_double");
		if(shortTermSuspensionsIndianPercent != null)
			oReportCard.setShortTermSuspensionsIndianPercent(shortTermSuspensionsIndianPercent);

		Double shortTermSuspensionsIndianRate = (Double)solrDocument.get("shortTermSuspensionsIndianRate_stored_double");
		if(shortTermSuspensionsIndianRate != null)
			oReportCard.setShortTermSuspensionsIndianRate(shortTermSuspensionsIndianRate);

		Long shortTermSuspensionsMultiRacialFemale = (Long)solrDocument.get("shortTermSuspensionsMultiRacialFemale_stored_long");
		if(shortTermSuspensionsMultiRacialFemale != null)
			oReportCard.setShortTermSuspensionsMultiRacialFemale(shortTermSuspensionsMultiRacialFemale);

		Long shortTermSuspensionsMultiRacialMale = (Long)solrDocument.get("shortTermSuspensionsMultiRacialMale_stored_long");
		if(shortTermSuspensionsMultiRacialMale != null)
			oReportCard.setShortTermSuspensionsMultiRacialMale(shortTermSuspensionsMultiRacialMale);

		Long shortTermSuspensionsMultiRacialTotal = (Long)solrDocument.get("shortTermSuspensionsMultiRacialTotal_stored_long");
		if(shortTermSuspensionsMultiRacialTotal != null)
			oReportCard.setShortTermSuspensionsMultiRacialTotal(shortTermSuspensionsMultiRacialTotal);

		Double shortTermSuspensionsMultiRacialPercent = (Double)solrDocument.get("shortTermSuspensionsMultiRacialPercent_stored_double");
		if(shortTermSuspensionsMultiRacialPercent != null)
			oReportCard.setShortTermSuspensionsMultiRacialPercent(shortTermSuspensionsMultiRacialPercent);

		Double shortTermSuspensionsMultiRacialRate = (Double)solrDocument.get("shortTermSuspensionsMultiRacialRate_stored_double");
		if(shortTermSuspensionsMultiRacialRate != null)
			oReportCard.setShortTermSuspensionsMultiRacialRate(shortTermSuspensionsMultiRacialRate);

		Long shortTermSuspensionsPacificIslanderFemale = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderFemale_stored_long");
		if(shortTermSuspensionsPacificIslanderFemale != null)
			oReportCard.setShortTermSuspensionsPacificIslanderFemale(shortTermSuspensionsPacificIslanderFemale);

		Long shortTermSuspensionsPacificIslanderMale = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderMale_stored_long");
		if(shortTermSuspensionsPacificIslanderMale != null)
			oReportCard.setShortTermSuspensionsPacificIslanderMale(shortTermSuspensionsPacificIslanderMale);

		Long shortTermSuspensionsPacificIslanderTotal = (Long)solrDocument.get("shortTermSuspensionsPacificIslanderTotal_stored_long");
		if(shortTermSuspensionsPacificIslanderTotal != null)
			oReportCard.setShortTermSuspensionsPacificIslanderTotal(shortTermSuspensionsPacificIslanderTotal);

		Double shortTermSuspensionsPacificIslanderPercent = (Double)solrDocument.get("shortTermSuspensionsPacificIslanderPercent_stored_double");
		if(shortTermSuspensionsPacificIslanderPercent != null)
			oReportCard.setShortTermSuspensionsPacificIslanderPercent(shortTermSuspensionsPacificIslanderPercent);

		Double shortTermSuspensionsPacificIslanderRate = (Double)solrDocument.get("shortTermSuspensionsPacificIslanderRate_stored_double");
		if(shortTermSuspensionsPacificIslanderRate != null)
			oReportCard.setShortTermSuspensionsPacificIslanderRate(shortTermSuspensionsPacificIslanderRate);

		Long shortTermSuspensionsWhiteFemale = (Long)solrDocument.get("shortTermSuspensionsWhiteFemale_stored_long");
		if(shortTermSuspensionsWhiteFemale != null)
			oReportCard.setShortTermSuspensionsWhiteFemale(shortTermSuspensionsWhiteFemale);

		Long shortTermSuspensionsWhiteMale = (Long)solrDocument.get("shortTermSuspensionsWhiteMale_stored_long");
		if(shortTermSuspensionsWhiteMale != null)
			oReportCard.setShortTermSuspensionsWhiteMale(shortTermSuspensionsWhiteMale);

		Long shortTermSuspensionsWhiteTotal = (Long)solrDocument.get("shortTermSuspensionsWhiteTotal_stored_long");
		if(shortTermSuspensionsWhiteTotal != null)
			oReportCard.setShortTermSuspensionsWhiteTotal(shortTermSuspensionsWhiteTotal);

		Double shortTermSuspensionsWhitePercent = (Double)solrDocument.get("shortTermSuspensionsWhitePercent_stored_double");
		if(shortTermSuspensionsWhitePercent != null)
			oReportCard.setShortTermSuspensionsWhitePercent(shortTermSuspensionsWhitePercent);

		Double shortTermSuspensionsWhiteRate = (Double)solrDocument.get("shortTermSuspensionsWhiteRate_stored_double");
		if(shortTermSuspensionsWhiteRate != null)
			oReportCard.setShortTermSuspensionsWhiteRate(shortTermSuspensionsWhiteRate);

		Double shortTermSuspensionsAllRate = (Double)solrDocument.get("shortTermSuspensionsAllRate_stored_double");
		if(shortTermSuspensionsAllRate != null)
			oReportCard.setShortTermSuspensionsAllRate(shortTermSuspensionsAllRate);

		Double shortTermSuspensionsBlackVsWhite = (Double)solrDocument.get("shortTermSuspensionsBlackVsWhite_stored_double");
		if(shortTermSuspensionsBlackVsWhite != null)
			oReportCard.setShortTermSuspensionsBlackVsWhite(shortTermSuspensionsBlackVsWhite);

		Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
		if(stateKey != null)
			oReportCard.setStateKey(stateKey);

		String stateId = (String)solrDocument.get("stateId_stored_string");
		if(stateId != null)
			oReportCard.setStateId(stateId);

		String agencyId = (String)solrDocument.get("agencyId_stored_string");
		if(agencyId != null)
			oReportCard.setAgencyId(agencyId);

		String stateName = (String)solrDocument.get("stateName_stored_string");
		if(stateName != null)
			oReportCard.setStateName(stateName);

		String stateAbbreviation = (String)solrDocument.get("stateAbbreviation_stored_string");
		if(stateAbbreviation != null)
			oReportCard.setStateAbbreviation(stateAbbreviation);

		String agencyName = (String)solrDocument.get("agencyName_stored_string");
		if(agencyName != null)
			oReportCard.setAgencyName(agencyName);

		String agencyCompleteName = (String)solrDocument.get("agencyCompleteName_stored_string");
		if(agencyCompleteName != null)
			oReportCard.setAgencyCompleteName(agencyCompleteName);

		String agencyDemographicsGraph = (String)solrDocument.get("agencyDemographicsGraph_stored_string");
		if(agencyDemographicsGraph != null)
			oReportCard.setAgencyDemographicsGraph(agencyDemographicsGraph);

		String agencyStudentsByRaceGraph = (String)solrDocument.get("agencyStudentsByRaceGraph_stored_string");
		if(agencyStudentsByRaceGraph != null)
			oReportCard.setAgencyStudentsByRaceGraph(agencyStudentsByRaceGraph);

		String agencyTeachersByRaceGraph = (String)solrDocument.get("agencyTeachersByRaceGraph_stored_string");
		if(agencyTeachersByRaceGraph != null)
			oReportCard.setAgencyTeachersByRaceGraph(agencyTeachersByRaceGraph);

		String agencyGrades3To8Graph = (String)solrDocument.get("agencyGrades3To8Graph_stored_string");
		if(agencyGrades3To8Graph != null)
			oReportCard.setAgencyGrades3To8Graph(agencyGrades3To8Graph);

		String agencyGrades9To12Graph = (String)solrDocument.get("agencyGrades9To12Graph_stored_string");
		if(agencyGrades9To12Graph != null)
			oReportCard.setAgencyGrades9To12Graph(agencyGrades9To12Graph);

		String agencyGraduatesWithin4YearsGraph = (String)solrDocument.get("agencyGraduatesWithin4YearsGraph_stored_string");
		if(agencyGraduatesWithin4YearsGraph != null)
			oReportCard.setAgencyGraduatesWithin4YearsGraph(agencyGraduatesWithin4YearsGraph);

		String suspensionsByRaceGraph = (String)solrDocument.get("suspensionsByRaceGraph_stored_string");
		if(suspensionsByRaceGraph != null)
			oReportCard.setSuspensionsByRaceGraph(suspensionsByRaceGraph);

		String suspensionRatesByRaceGraph = (String)solrDocument.get("suspensionRatesByRaceGraph_stored_string");
		if(suspensionRatesByRaceGraph != null)
			oReportCard.setSuspensionRatesByRaceGraph(suspensionRatesByRaceGraph);

		String countySchoolBasedComplaintsGraph = (String)solrDocument.get("countySchoolBasedComplaintsGraph_stored_string");
		if(countySchoolBasedComplaintsGraph != null)
			oReportCard.setCountySchoolBasedComplaintsGraph(countySchoolBasedComplaintsGraph);

		String schoolBasedComplaintsGraph = (String)solrDocument.get("schoolBasedComplaintsGraph_stored_string");
		if(schoolBasedComplaintsGraph != null)
			oReportCard.setSchoolBasedComplaintsGraph(schoolBasedComplaintsGraph);

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
			if(!Objects.equals(reportCardYearsStr, original.getReportCardYearsStr()))
				apiRequest.addVars("reportCardYearsStr");
			if(!Objects.equals(agencyKey, original.getAgencyKey()))
				apiRequest.addVars("agencyKey");
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
			if(!Objects.equals(teachersMale, original.getTeachersMale()))
				apiRequest.addVars("teachersMale");
			if(!Objects.equals(teachersFemale, original.getTeachersFemale()))
				apiRequest.addVars("teachersFemale");
			if(!Objects.equals(teachersTotal, original.getTeachersTotal()))
				apiRequest.addVars("teachersTotal");
			if(!Objects.equals(teachersWhiteTotal, original.getTeachersWhiteTotal()))
				apiRequest.addVars("teachersWhiteTotal");
			if(!Objects.equals(teachersWhitePercent, original.getTeachersWhitePercent()))
				apiRequest.addVars("teachersWhitePercent");
			if(!Objects.equals(teachersBlackTotal, original.getTeachersBlackTotal()))
				apiRequest.addVars("teachersBlackTotal");
			if(!Objects.equals(teachersBlackPercent, original.getTeachersBlackPercent()))
				apiRequest.addVars("teachersBlackPercent");
			if(!Objects.equals(teachersOtherTotal, original.getTeachersOtherTotal()))
				apiRequest.addVars("teachersOtherTotal");
			if(!Objects.equals(teachersOtherPercent, original.getTeachersOtherPercent()))
				apiRequest.addVars("teachersOtherPercent");
			if(!Objects.equals(delinquentComplaintsTotal, original.getDelinquentComplaintsTotal()))
				apiRequest.addVars("delinquentComplaintsTotal");
			if(!Objects.equals(delinquentComplaintsAtSchool, original.getDelinquentComplaintsAtSchool()))
				apiRequest.addVars("delinquentComplaintsAtSchool");
			if(!Objects.equals(delinquentComplaintsAtSchoolPercent, original.getDelinquentComplaintsAtSchoolPercent()))
				apiRequest.addVars("delinquentComplaintsAtSchoolPercent");
			if(!Objects.equals(delinquentComplaintsAsian, original.getDelinquentComplaintsAsian()))
				apiRequest.addVars("delinquentComplaintsAsian");
			if(!Objects.equals(delinquentComplaintsAsianPercent, original.getDelinquentComplaintsAsianPercent()))
				apiRequest.addVars("delinquentComplaintsAsianPercent");
			if(!Objects.equals(delinquentComplaintsBlack, original.getDelinquentComplaintsBlack()))
				apiRequest.addVars("delinquentComplaintsBlack");
			if(!Objects.equals(delinquentComplaintsBlackPercent, original.getDelinquentComplaintsBlackPercent()))
				apiRequest.addVars("delinquentComplaintsBlackPercent");
			if(!Objects.equals(delinquentComplaintsHispanic, original.getDelinquentComplaintsHispanic()))
				apiRequest.addVars("delinquentComplaintsHispanic");
			if(!Objects.equals(delinquentComplaintsHispanicPercent, original.getDelinquentComplaintsHispanicPercent()))
				apiRequest.addVars("delinquentComplaintsHispanicPercent");
			if(!Objects.equals(delinquentComplaintsMultiRacial, original.getDelinquentComplaintsMultiRacial()))
				apiRequest.addVars("delinquentComplaintsMultiRacial");
			if(!Objects.equals(delinquentComplaintsMultiRacialPercent, original.getDelinquentComplaintsMultiRacialPercent()))
				apiRequest.addVars("delinquentComplaintsMultiRacialPercent");
			if(!Objects.equals(delinquentComplaintsIndian, original.getDelinquentComplaintsIndian()))
				apiRequest.addVars("delinquentComplaintsIndian");
			if(!Objects.equals(delinquentComplaintsIndianPercent, original.getDelinquentComplaintsIndianPercent()))
				apiRequest.addVars("delinquentComplaintsIndianPercent");
			if(!Objects.equals(delinquentComplaintsWhite, original.getDelinquentComplaintsWhite()))
				apiRequest.addVars("delinquentComplaintsWhite");
			if(!Objects.equals(delinquentComplaintsWhitePercent, original.getDelinquentComplaintsWhitePercent()))
				apiRequest.addVars("delinquentComplaintsWhitePercent");
			if(!Objects.equals(delinquentComplaintsPacificIslander, original.getDelinquentComplaintsPacificIslander()))
				apiRequest.addVars("delinquentComplaintsPacificIslander");
			if(!Objects.equals(delinquentComplaintsPacificIslanderPercent, original.getDelinquentComplaintsPacificIslanderPercent()))
				apiRequest.addVars("delinquentComplaintsPacificIslanderPercent");
			if(!Objects.equals(shortTermSuspensionRate, original.getShortTermSuspensionRate()))
				apiRequest.addVars("shortTermSuspensionRate");
			if(!Objects.equals(shortTermSuspensionsTotal, original.getShortTermSuspensionsTotal()))
				apiRequest.addVars("shortTermSuspensionsTotal");
			if(!Objects.equals(longTermSuspensionsTotal, original.getLongTermSuspensionsTotal()))
				apiRequest.addVars("longTermSuspensionsTotal");
			if(!Objects.equals(expulsionsTotal, original.getExpulsionsTotal()))
				apiRequest.addVars("expulsionsTotal");
			if(!Objects.equals(shortTermSuspensionsAsianFemale, original.getShortTermSuspensionsAsianFemale()))
				apiRequest.addVars("shortTermSuspensionsAsianFemale");
			if(!Objects.equals(shortTermSuspensionsAsianMale, original.getShortTermSuspensionsAsianMale()))
				apiRequest.addVars("shortTermSuspensionsAsianMale");
			if(!Objects.equals(shortTermSuspensionsAsianTotal, original.getShortTermSuspensionsAsianTotal()))
				apiRequest.addVars("shortTermSuspensionsAsianTotal");
			if(!Objects.equals(shortTermSuspensionsAsianPercent, original.getShortTermSuspensionsAsianPercent()))
				apiRequest.addVars("shortTermSuspensionsAsianPercent");
			if(!Objects.equals(shortTermSuspensionsAsianRate, original.getShortTermSuspensionsAsianRate()))
				apiRequest.addVars("shortTermSuspensionsAsianRate");
			if(!Objects.equals(shortTermSuspensionsBlackFemale, original.getShortTermSuspensionsBlackFemale()))
				apiRequest.addVars("shortTermSuspensionsBlackFemale");
			if(!Objects.equals(shortTermSuspensionsBlackMale, original.getShortTermSuspensionsBlackMale()))
				apiRequest.addVars("shortTermSuspensionsBlackMale");
			if(!Objects.equals(shortTermSuspensionsBlackTotal, original.getShortTermSuspensionsBlackTotal()))
				apiRequest.addVars("shortTermSuspensionsBlackTotal");
			if(!Objects.equals(shortTermSuspensionsBlackPercent, original.getShortTermSuspensionsBlackPercent()))
				apiRequest.addVars("shortTermSuspensionsBlackPercent");
			if(!Objects.equals(shortTermSuspensionsBlackRate, original.getShortTermSuspensionsBlackRate()))
				apiRequest.addVars("shortTermSuspensionsBlackRate");
			if(!Objects.equals(shortTermSuspensionsHispanicFemale, original.getShortTermSuspensionsHispanicFemale()))
				apiRequest.addVars("shortTermSuspensionsHispanicFemale");
			if(!Objects.equals(shortTermSuspensionsHispanicMale, original.getShortTermSuspensionsHispanicMale()))
				apiRequest.addVars("shortTermSuspensionsHispanicMale");
			if(!Objects.equals(shortTermSuspensionsHispanicTotal, original.getShortTermSuspensionsHispanicTotal()))
				apiRequest.addVars("shortTermSuspensionsHispanicTotal");
			if(!Objects.equals(shortTermSuspensionsHispanicPercent, original.getShortTermSuspensionsHispanicPercent()))
				apiRequest.addVars("shortTermSuspensionsHispanicPercent");
			if(!Objects.equals(shortTermSuspensionsHispanicRate, original.getShortTermSuspensionsHispanicRate()))
				apiRequest.addVars("shortTermSuspensionsHispanicRate");
			if(!Objects.equals(shortTermSuspensionsIndianFemale, original.getShortTermSuspensionsIndianFemale()))
				apiRequest.addVars("shortTermSuspensionsIndianFemale");
			if(!Objects.equals(shortTermSuspensionsIndianMale, original.getShortTermSuspensionsIndianMale()))
				apiRequest.addVars("shortTermSuspensionsIndianMale");
			if(!Objects.equals(shortTermSuspensionsIndianTotal, original.getShortTermSuspensionsIndianTotal()))
				apiRequest.addVars("shortTermSuspensionsIndianTotal");
			if(!Objects.equals(shortTermSuspensionsIndianPercent, original.getShortTermSuspensionsIndianPercent()))
				apiRequest.addVars("shortTermSuspensionsIndianPercent");
			if(!Objects.equals(shortTermSuspensionsIndianRate, original.getShortTermSuspensionsIndianRate()))
				apiRequest.addVars("shortTermSuspensionsIndianRate");
			if(!Objects.equals(shortTermSuspensionsMultiRacialFemale, original.getShortTermSuspensionsMultiRacialFemale()))
				apiRequest.addVars("shortTermSuspensionsMultiRacialFemale");
			if(!Objects.equals(shortTermSuspensionsMultiRacialMale, original.getShortTermSuspensionsMultiRacialMale()))
				apiRequest.addVars("shortTermSuspensionsMultiRacialMale");
			if(!Objects.equals(shortTermSuspensionsMultiRacialTotal, original.getShortTermSuspensionsMultiRacialTotal()))
				apiRequest.addVars("shortTermSuspensionsMultiRacialTotal");
			if(!Objects.equals(shortTermSuspensionsMultiRacialPercent, original.getShortTermSuspensionsMultiRacialPercent()))
				apiRequest.addVars("shortTermSuspensionsMultiRacialPercent");
			if(!Objects.equals(shortTermSuspensionsMultiRacialRate, original.getShortTermSuspensionsMultiRacialRate()))
				apiRequest.addVars("shortTermSuspensionsMultiRacialRate");
			if(!Objects.equals(shortTermSuspensionsPacificIslanderFemale, original.getShortTermSuspensionsPacificIslanderFemale()))
				apiRequest.addVars("shortTermSuspensionsPacificIslanderFemale");
			if(!Objects.equals(shortTermSuspensionsPacificIslanderMale, original.getShortTermSuspensionsPacificIslanderMale()))
				apiRequest.addVars("shortTermSuspensionsPacificIslanderMale");
			if(!Objects.equals(shortTermSuspensionsPacificIslanderTotal, original.getShortTermSuspensionsPacificIslanderTotal()))
				apiRequest.addVars("shortTermSuspensionsPacificIslanderTotal");
			if(!Objects.equals(shortTermSuspensionsPacificIslanderPercent, original.getShortTermSuspensionsPacificIslanderPercent()))
				apiRequest.addVars("shortTermSuspensionsPacificIslanderPercent");
			if(!Objects.equals(shortTermSuspensionsPacificIslanderRate, original.getShortTermSuspensionsPacificIslanderRate()))
				apiRequest.addVars("shortTermSuspensionsPacificIslanderRate");
			if(!Objects.equals(shortTermSuspensionsWhiteFemale, original.getShortTermSuspensionsWhiteFemale()))
				apiRequest.addVars("shortTermSuspensionsWhiteFemale");
			if(!Objects.equals(shortTermSuspensionsWhiteMale, original.getShortTermSuspensionsWhiteMale()))
				apiRequest.addVars("shortTermSuspensionsWhiteMale");
			if(!Objects.equals(shortTermSuspensionsWhiteTotal, original.getShortTermSuspensionsWhiteTotal()))
				apiRequest.addVars("shortTermSuspensionsWhiteTotal");
			if(!Objects.equals(shortTermSuspensionsWhitePercent, original.getShortTermSuspensionsWhitePercent()))
				apiRequest.addVars("shortTermSuspensionsWhitePercent");
			if(!Objects.equals(shortTermSuspensionsWhiteRate, original.getShortTermSuspensionsWhiteRate()))
				apiRequest.addVars("shortTermSuspensionsWhiteRate");
			if(!Objects.equals(shortTermSuspensionsAllRate, original.getShortTermSuspensionsAllRate()))
				apiRequest.addVars("shortTermSuspensionsAllRate");
			if(!Objects.equals(shortTermSuspensionsBlackVsWhite, original.getShortTermSuspensionsBlackVsWhite()))
				apiRequest.addVars("shortTermSuspensionsBlackVsWhite");
			if(!Objects.equals(stateKey, original.getStateKey()))
				apiRequest.addVars("stateKey");
			if(!Objects.equals(stateId, original.getStateId()))
				apiRequest.addVars("stateId");
			if(!Objects.equals(agencyId, original.getAgencyId()))
				apiRequest.addVars("agencyId");
			if(!Objects.equals(stateName, original.getStateName()))
				apiRequest.addVars("stateName");
			if(!Objects.equals(stateAbbreviation, original.getStateAbbreviation()))
				apiRequest.addVars("stateAbbreviation");
			if(!Objects.equals(agencyName, original.getAgencyName()))
				apiRequest.addVars("agencyName");
			if(!Objects.equals(agencyCompleteName, original.getAgencyCompleteName()))
				apiRequest.addVars("agencyCompleteName");
			if(!Objects.equals(agencyDemographicsGraph, original.getAgencyDemographicsGraph()))
				apiRequest.addVars("agencyDemographicsGraph");
			if(!Objects.equals(agencyStudentsByRaceGraph, original.getAgencyStudentsByRaceGraph()))
				apiRequest.addVars("agencyStudentsByRaceGraph");
			if(!Objects.equals(agencyTeachersByRaceGraph, original.getAgencyTeachersByRaceGraph()))
				apiRequest.addVars("agencyTeachersByRaceGraph");
			if(!Objects.equals(agencyGrades3To8Graph, original.getAgencyGrades3To8Graph()))
				apiRequest.addVars("agencyGrades3To8Graph");
			if(!Objects.equals(agencyGrades9To12Graph, original.getAgencyGrades9To12Graph()))
				apiRequest.addVars("agencyGrades9To12Graph");
			if(!Objects.equals(agencyGraduatesWithin4YearsGraph, original.getAgencyGraduatesWithin4YearsGraph()))
				apiRequest.addVars("agencyGraduatesWithin4YearsGraph");
			if(!Objects.equals(suspensionsByRaceGraph, original.getSuspensionsByRaceGraph()))
				apiRequest.addVars("suspensionsByRaceGraph");
			if(!Objects.equals(suspensionRatesByRaceGraph, original.getSuspensionRatesByRaceGraph()))
				apiRequest.addVars("suspensionRatesByRaceGraph");
			if(!Objects.equals(countySchoolBasedComplaintsGraph, original.getCountySchoolBasedComplaintsGraph()))
				apiRequest.addVars("countySchoolBasedComplaintsGraph");
			if(!Objects.equals(schoolBasedComplaintsGraph, original.getSchoolBasedComplaintsGraph()))
				apiRequest.addVars("schoolBasedComplaintsGraph");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), reportCardKey, reportCardStartYear, reportCardEndYear, reportCardYearsStr, agencyKey, pupilsTotal, pupilsIndianFemale, pupilsIndianMale, pupilsIndianTotal, pupilsIndianPercent, pupilsAsianFemale, pupilsAsianMale, pupilsAsianTotal, pupilsAsianPercent, pupilsHispanicFemale, pupilsHispanicMale, pupilsHispanicTotal, pupilsHispanicPercent, pupilsBlackFemale, pupilsBlackMale, pupilsBlackTotal, pupilsBlackPercent, pupilsWhiteFemale, pupilsWhiteMale, pupilsWhiteTotal, pupilsWhitePercent, pupilsPacificIslanderFemale, pupilsPacificIslanderMale, pupilsPacificIslanderTotal, pupilsPacificIslanderPercent, pupilsMultiRacialFemale, pupilsMultiRacialMale, pupilsMultiRacialTotal, pupilsMultiRacialPercent, teachersMale, teachersFemale, teachersTotal, teachersWhiteTotal, teachersWhitePercent, teachersBlackTotal, teachersBlackPercent, teachersOtherTotal, teachersOtherPercent, delinquentComplaintsTotal, delinquentComplaintsAtSchool, delinquentComplaintsAtSchoolPercent, delinquentComplaintsAsian, delinquentComplaintsAsianPercent, delinquentComplaintsBlack, delinquentComplaintsBlackPercent, delinquentComplaintsHispanic, delinquentComplaintsHispanicPercent, delinquentComplaintsMultiRacial, delinquentComplaintsMultiRacialPercent, delinquentComplaintsIndian, delinquentComplaintsIndianPercent, delinquentComplaintsWhite, delinquentComplaintsWhitePercent, delinquentComplaintsPacificIslander, delinquentComplaintsPacificIslanderPercent, shortTermSuspensionRate, shortTermSuspensionsTotal, longTermSuspensionsTotal, expulsionsTotal, shortTermSuspensionsAsianFemale, shortTermSuspensionsAsianMale, shortTermSuspensionsAsianTotal, shortTermSuspensionsAsianPercent, shortTermSuspensionsAsianRate, shortTermSuspensionsBlackFemale, shortTermSuspensionsBlackMale, shortTermSuspensionsBlackTotal, shortTermSuspensionsBlackPercent, shortTermSuspensionsBlackRate, shortTermSuspensionsHispanicFemale, shortTermSuspensionsHispanicMale, shortTermSuspensionsHispanicTotal, shortTermSuspensionsHispanicPercent, shortTermSuspensionsHispanicRate, shortTermSuspensionsIndianFemale, shortTermSuspensionsIndianMale, shortTermSuspensionsIndianTotal, shortTermSuspensionsIndianPercent, shortTermSuspensionsIndianRate, shortTermSuspensionsMultiRacialFemale, shortTermSuspensionsMultiRacialMale, shortTermSuspensionsMultiRacialTotal, shortTermSuspensionsMultiRacialPercent, shortTermSuspensionsMultiRacialRate, shortTermSuspensionsPacificIslanderFemale, shortTermSuspensionsPacificIslanderMale, shortTermSuspensionsPacificIslanderTotal, shortTermSuspensionsPacificIslanderPercent, shortTermSuspensionsPacificIslanderRate, shortTermSuspensionsWhiteFemale, shortTermSuspensionsWhiteMale, shortTermSuspensionsWhiteTotal, shortTermSuspensionsWhitePercent, shortTermSuspensionsWhiteRate, shortTermSuspensionsAllRate, shortTermSuspensionsBlackVsWhite, stateKey, stateId, agencyId, stateName, stateAbbreviation, agencyName, agencyCompleteName, agencyDemographicsGraph, agencyStudentsByRaceGraph, agencyTeachersByRaceGraph, agencyGrades3To8Graph, agencyGrades9To12Graph, agencyGraduatesWithin4YearsGraph, suspensionsByRaceGraph, suspensionRatesByRaceGraph, countySchoolBasedComplaintsGraph, schoolBasedComplaintsGraph);
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
				&& Objects.equals( reportCardYearsStr, that.reportCardYearsStr )
				&& Objects.equals( agencyKey, that.agencyKey )
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
				&& Objects.equals( teachersMale, that.teachersMale )
				&& Objects.equals( teachersFemale, that.teachersFemale )
				&& Objects.equals( teachersTotal, that.teachersTotal )
				&& Objects.equals( teachersWhiteTotal, that.teachersWhiteTotal )
				&& Objects.equals( teachersWhitePercent, that.teachersWhitePercent )
				&& Objects.equals( teachersBlackTotal, that.teachersBlackTotal )
				&& Objects.equals( teachersBlackPercent, that.teachersBlackPercent )
				&& Objects.equals( teachersOtherTotal, that.teachersOtherTotal )
				&& Objects.equals( teachersOtherPercent, that.teachersOtherPercent )
				&& Objects.equals( delinquentComplaintsTotal, that.delinquentComplaintsTotal )
				&& Objects.equals( delinquentComplaintsAtSchool, that.delinquentComplaintsAtSchool )
				&& Objects.equals( delinquentComplaintsAtSchoolPercent, that.delinquentComplaintsAtSchoolPercent )
				&& Objects.equals( delinquentComplaintsAsian, that.delinquentComplaintsAsian )
				&& Objects.equals( delinquentComplaintsAsianPercent, that.delinquentComplaintsAsianPercent )
				&& Objects.equals( delinquentComplaintsBlack, that.delinquentComplaintsBlack )
				&& Objects.equals( delinquentComplaintsBlackPercent, that.delinquentComplaintsBlackPercent )
				&& Objects.equals( delinquentComplaintsHispanic, that.delinquentComplaintsHispanic )
				&& Objects.equals( delinquentComplaintsHispanicPercent, that.delinquentComplaintsHispanicPercent )
				&& Objects.equals( delinquentComplaintsMultiRacial, that.delinquentComplaintsMultiRacial )
				&& Objects.equals( delinquentComplaintsMultiRacialPercent, that.delinquentComplaintsMultiRacialPercent )
				&& Objects.equals( delinquentComplaintsIndian, that.delinquentComplaintsIndian )
				&& Objects.equals( delinquentComplaintsIndianPercent, that.delinquentComplaintsIndianPercent )
				&& Objects.equals( delinquentComplaintsWhite, that.delinquentComplaintsWhite )
				&& Objects.equals( delinquentComplaintsWhitePercent, that.delinquentComplaintsWhitePercent )
				&& Objects.equals( delinquentComplaintsPacificIslander, that.delinquentComplaintsPacificIslander )
				&& Objects.equals( delinquentComplaintsPacificIslanderPercent, that.delinquentComplaintsPacificIslanderPercent )
				&& Objects.equals( shortTermSuspensionRate, that.shortTermSuspensionRate )
				&& Objects.equals( shortTermSuspensionsTotal, that.shortTermSuspensionsTotal )
				&& Objects.equals( longTermSuspensionsTotal, that.longTermSuspensionsTotal )
				&& Objects.equals( expulsionsTotal, that.expulsionsTotal )
				&& Objects.equals( shortTermSuspensionsAsianFemale, that.shortTermSuspensionsAsianFemale )
				&& Objects.equals( shortTermSuspensionsAsianMale, that.shortTermSuspensionsAsianMale )
				&& Objects.equals( shortTermSuspensionsAsianTotal, that.shortTermSuspensionsAsianTotal )
				&& Objects.equals( shortTermSuspensionsAsianPercent, that.shortTermSuspensionsAsianPercent )
				&& Objects.equals( shortTermSuspensionsAsianRate, that.shortTermSuspensionsAsianRate )
				&& Objects.equals( shortTermSuspensionsBlackFemale, that.shortTermSuspensionsBlackFemale )
				&& Objects.equals( shortTermSuspensionsBlackMale, that.shortTermSuspensionsBlackMale )
				&& Objects.equals( shortTermSuspensionsBlackTotal, that.shortTermSuspensionsBlackTotal )
				&& Objects.equals( shortTermSuspensionsBlackPercent, that.shortTermSuspensionsBlackPercent )
				&& Objects.equals( shortTermSuspensionsBlackRate, that.shortTermSuspensionsBlackRate )
				&& Objects.equals( shortTermSuspensionsHispanicFemale, that.shortTermSuspensionsHispanicFemale )
				&& Objects.equals( shortTermSuspensionsHispanicMale, that.shortTermSuspensionsHispanicMale )
				&& Objects.equals( shortTermSuspensionsHispanicTotal, that.shortTermSuspensionsHispanicTotal )
				&& Objects.equals( shortTermSuspensionsHispanicPercent, that.shortTermSuspensionsHispanicPercent )
				&& Objects.equals( shortTermSuspensionsHispanicRate, that.shortTermSuspensionsHispanicRate )
				&& Objects.equals( shortTermSuspensionsIndianFemale, that.shortTermSuspensionsIndianFemale )
				&& Objects.equals( shortTermSuspensionsIndianMale, that.shortTermSuspensionsIndianMale )
				&& Objects.equals( shortTermSuspensionsIndianTotal, that.shortTermSuspensionsIndianTotal )
				&& Objects.equals( shortTermSuspensionsIndianPercent, that.shortTermSuspensionsIndianPercent )
				&& Objects.equals( shortTermSuspensionsIndianRate, that.shortTermSuspensionsIndianRate )
				&& Objects.equals( shortTermSuspensionsMultiRacialFemale, that.shortTermSuspensionsMultiRacialFemale )
				&& Objects.equals( shortTermSuspensionsMultiRacialMale, that.shortTermSuspensionsMultiRacialMale )
				&& Objects.equals( shortTermSuspensionsMultiRacialTotal, that.shortTermSuspensionsMultiRacialTotal )
				&& Objects.equals( shortTermSuspensionsMultiRacialPercent, that.shortTermSuspensionsMultiRacialPercent )
				&& Objects.equals( shortTermSuspensionsMultiRacialRate, that.shortTermSuspensionsMultiRacialRate )
				&& Objects.equals( shortTermSuspensionsPacificIslanderFemale, that.shortTermSuspensionsPacificIslanderFemale )
				&& Objects.equals( shortTermSuspensionsPacificIslanderMale, that.shortTermSuspensionsPacificIslanderMale )
				&& Objects.equals( shortTermSuspensionsPacificIslanderTotal, that.shortTermSuspensionsPacificIslanderTotal )
				&& Objects.equals( shortTermSuspensionsPacificIslanderPercent, that.shortTermSuspensionsPacificIslanderPercent )
				&& Objects.equals( shortTermSuspensionsPacificIslanderRate, that.shortTermSuspensionsPacificIslanderRate )
				&& Objects.equals( shortTermSuspensionsWhiteFemale, that.shortTermSuspensionsWhiteFemale )
				&& Objects.equals( shortTermSuspensionsWhiteMale, that.shortTermSuspensionsWhiteMale )
				&& Objects.equals( shortTermSuspensionsWhiteTotal, that.shortTermSuspensionsWhiteTotal )
				&& Objects.equals( shortTermSuspensionsWhitePercent, that.shortTermSuspensionsWhitePercent )
				&& Objects.equals( shortTermSuspensionsWhiteRate, that.shortTermSuspensionsWhiteRate )
				&& Objects.equals( shortTermSuspensionsAllRate, that.shortTermSuspensionsAllRate )
				&& Objects.equals( shortTermSuspensionsBlackVsWhite, that.shortTermSuspensionsBlackVsWhite )
				&& Objects.equals( stateKey, that.stateKey )
				&& Objects.equals( stateId, that.stateId )
				&& Objects.equals( agencyId, that.agencyId )
				&& Objects.equals( stateName, that.stateName )
				&& Objects.equals( stateAbbreviation, that.stateAbbreviation )
				&& Objects.equals( agencyName, that.agencyName )
				&& Objects.equals( agencyCompleteName, that.agencyCompleteName )
				&& Objects.equals( agencyDemographicsGraph, that.agencyDemographicsGraph )
				&& Objects.equals( agencyStudentsByRaceGraph, that.agencyStudentsByRaceGraph )
				&& Objects.equals( agencyTeachersByRaceGraph, that.agencyTeachersByRaceGraph )
				&& Objects.equals( agencyGrades3To8Graph, that.agencyGrades3To8Graph )
				&& Objects.equals( agencyGrades9To12Graph, that.agencyGrades9To12Graph )
				&& Objects.equals( agencyGraduatesWithin4YearsGraph, that.agencyGraduatesWithin4YearsGraph )
				&& Objects.equals( suspensionsByRaceGraph, that.suspensionsByRaceGraph )
				&& Objects.equals( suspensionRatesByRaceGraph, that.suspensionRatesByRaceGraph )
				&& Objects.equals( countySchoolBasedComplaintsGraph, that.countySchoolBasedComplaintsGraph )
				&& Objects.equals( schoolBasedComplaintsGraph, that.schoolBasedComplaintsGraph );
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
		sb.append( ", reportCardYearsStr: \"" ).append(reportCardYearsStr).append( "\"" );
		sb.append( ", agencyKey: " ).append(agencyKey);
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
		sb.append( ", teachersMale: " ).append(teachersMale);
		sb.append( ", teachersFemale: " ).append(teachersFemale);
		sb.append( ", teachersTotal: " ).append(teachersTotal);
		sb.append( ", teachersWhiteTotal: " ).append(teachersWhiteTotal);
		sb.append( ", teachersWhitePercent: " ).append(teachersWhitePercent);
		sb.append( ", teachersBlackTotal: " ).append(teachersBlackTotal);
		sb.append( ", teachersBlackPercent: " ).append(teachersBlackPercent);
		sb.append( ", teachersOtherTotal: " ).append(teachersOtherTotal);
		sb.append( ", teachersOtherPercent: " ).append(teachersOtherPercent);
		sb.append( ", delinquentComplaintsTotal: " ).append(delinquentComplaintsTotal);
		sb.append( ", delinquentComplaintsAtSchool: " ).append(delinquentComplaintsAtSchool);
		sb.append( ", delinquentComplaintsAtSchoolPercent: " ).append(delinquentComplaintsAtSchoolPercent);
		sb.append( ", delinquentComplaintsAsian: " ).append(delinquentComplaintsAsian);
		sb.append( ", delinquentComplaintsAsianPercent: " ).append(delinquentComplaintsAsianPercent);
		sb.append( ", delinquentComplaintsBlack: " ).append(delinquentComplaintsBlack);
		sb.append( ", delinquentComplaintsBlackPercent: " ).append(delinquentComplaintsBlackPercent);
		sb.append( ", delinquentComplaintsHispanic: " ).append(delinquentComplaintsHispanic);
		sb.append( ", delinquentComplaintsHispanicPercent: " ).append(delinquentComplaintsHispanicPercent);
		sb.append( ", delinquentComplaintsMultiRacial: " ).append(delinquentComplaintsMultiRacial);
		sb.append( ", delinquentComplaintsMultiRacialPercent: " ).append(delinquentComplaintsMultiRacialPercent);
		sb.append( ", delinquentComplaintsIndian: " ).append(delinquentComplaintsIndian);
		sb.append( ", delinquentComplaintsIndianPercent: " ).append(delinquentComplaintsIndianPercent);
		sb.append( ", delinquentComplaintsWhite: " ).append(delinquentComplaintsWhite);
		sb.append( ", delinquentComplaintsWhitePercent: " ).append(delinquentComplaintsWhitePercent);
		sb.append( ", delinquentComplaintsPacificIslander: " ).append(delinquentComplaintsPacificIslander);
		sb.append( ", delinquentComplaintsPacificIslanderPercent: " ).append(delinquentComplaintsPacificIslanderPercent);
		sb.append( ", shortTermSuspensionRate: " ).append(shortTermSuspensionRate);
		sb.append( ", shortTermSuspensionsTotal: " ).append(shortTermSuspensionsTotal);
		sb.append( ", longTermSuspensionsTotal: " ).append(longTermSuspensionsTotal);
		sb.append( ", expulsionsTotal: " ).append(expulsionsTotal);
		sb.append( ", shortTermSuspensionsAsianFemale: " ).append(shortTermSuspensionsAsianFemale);
		sb.append( ", shortTermSuspensionsAsianMale: " ).append(shortTermSuspensionsAsianMale);
		sb.append( ", shortTermSuspensionsAsianTotal: " ).append(shortTermSuspensionsAsianTotal);
		sb.append( ", shortTermSuspensionsAsianPercent: " ).append(shortTermSuspensionsAsianPercent);
		sb.append( ", shortTermSuspensionsAsianRate: " ).append(shortTermSuspensionsAsianRate);
		sb.append( ", shortTermSuspensionsBlackFemale: " ).append(shortTermSuspensionsBlackFemale);
		sb.append( ", shortTermSuspensionsBlackMale: " ).append(shortTermSuspensionsBlackMale);
		sb.append( ", shortTermSuspensionsBlackTotal: " ).append(shortTermSuspensionsBlackTotal);
		sb.append( ", shortTermSuspensionsBlackPercent: " ).append(shortTermSuspensionsBlackPercent);
		sb.append( ", shortTermSuspensionsBlackRate: " ).append(shortTermSuspensionsBlackRate);
		sb.append( ", shortTermSuspensionsHispanicFemale: " ).append(shortTermSuspensionsHispanicFemale);
		sb.append( ", shortTermSuspensionsHispanicMale: " ).append(shortTermSuspensionsHispanicMale);
		sb.append( ", shortTermSuspensionsHispanicTotal: " ).append(shortTermSuspensionsHispanicTotal);
		sb.append( ", shortTermSuspensionsHispanicPercent: " ).append(shortTermSuspensionsHispanicPercent);
		sb.append( ", shortTermSuspensionsHispanicRate: " ).append(shortTermSuspensionsHispanicRate);
		sb.append( ", shortTermSuspensionsIndianFemale: " ).append(shortTermSuspensionsIndianFemale);
		sb.append( ", shortTermSuspensionsIndianMale: " ).append(shortTermSuspensionsIndianMale);
		sb.append( ", shortTermSuspensionsIndianTotal: " ).append(shortTermSuspensionsIndianTotal);
		sb.append( ", shortTermSuspensionsIndianPercent: " ).append(shortTermSuspensionsIndianPercent);
		sb.append( ", shortTermSuspensionsIndianRate: " ).append(shortTermSuspensionsIndianRate);
		sb.append( ", shortTermSuspensionsMultiRacialFemale: " ).append(shortTermSuspensionsMultiRacialFemale);
		sb.append( ", shortTermSuspensionsMultiRacialMale: " ).append(shortTermSuspensionsMultiRacialMale);
		sb.append( ", shortTermSuspensionsMultiRacialTotal: " ).append(shortTermSuspensionsMultiRacialTotal);
		sb.append( ", shortTermSuspensionsMultiRacialPercent: " ).append(shortTermSuspensionsMultiRacialPercent);
		sb.append( ", shortTermSuspensionsMultiRacialRate: " ).append(shortTermSuspensionsMultiRacialRate);
		sb.append( ", shortTermSuspensionsPacificIslanderFemale: " ).append(shortTermSuspensionsPacificIslanderFemale);
		sb.append( ", shortTermSuspensionsPacificIslanderMale: " ).append(shortTermSuspensionsPacificIslanderMale);
		sb.append( ", shortTermSuspensionsPacificIslanderTotal: " ).append(shortTermSuspensionsPacificIslanderTotal);
		sb.append( ", shortTermSuspensionsPacificIslanderPercent: " ).append(shortTermSuspensionsPacificIslanderPercent);
		sb.append( ", shortTermSuspensionsPacificIslanderRate: " ).append(shortTermSuspensionsPacificIslanderRate);
		sb.append( ", shortTermSuspensionsWhiteFemale: " ).append(shortTermSuspensionsWhiteFemale);
		sb.append( ", shortTermSuspensionsWhiteMale: " ).append(shortTermSuspensionsWhiteMale);
		sb.append( ", shortTermSuspensionsWhiteTotal: " ).append(shortTermSuspensionsWhiteTotal);
		sb.append( ", shortTermSuspensionsWhitePercent: " ).append(shortTermSuspensionsWhitePercent);
		sb.append( ", shortTermSuspensionsWhiteRate: " ).append(shortTermSuspensionsWhiteRate);
		sb.append( ", shortTermSuspensionsAllRate: " ).append(shortTermSuspensionsAllRate);
		sb.append( ", shortTermSuspensionsBlackVsWhite: " ).append(shortTermSuspensionsBlackVsWhite);
		sb.append( ", stateKey: " ).append(stateKey);
		sb.append( ", stateId: \"" ).append(stateId).append( "\"" );
		sb.append( ", agencyId: \"" ).append(agencyId).append( "\"" );
		sb.append( ", stateName: \"" ).append(stateName).append( "\"" );
		sb.append( ", stateAbbreviation: \"" ).append(stateAbbreviation).append( "\"" );
		sb.append( ", agencyName: \"" ).append(agencyName).append( "\"" );
		sb.append( ", agencyCompleteName: \"" ).append(agencyCompleteName).append( "\"" );
		sb.append( ", agencyDemographicsGraph: \"" ).append(agencyDemographicsGraph).append( "\"" );
		sb.append( ", agencyStudentsByRaceGraph: \"" ).append(agencyStudentsByRaceGraph).append( "\"" );
		sb.append( ", agencyTeachersByRaceGraph: \"" ).append(agencyTeachersByRaceGraph).append( "\"" );
		sb.append( ", agencyGrades3To8Graph: \"" ).append(agencyGrades3To8Graph).append( "\"" );
		sb.append( ", agencyGrades9To12Graph: \"" ).append(agencyGrades9To12Graph).append( "\"" );
		sb.append( ", agencyGraduatesWithin4YearsGraph: \"" ).append(agencyGraduatesWithin4YearsGraph).append( "\"" );
		sb.append( ", suspensionsByRaceGraph: \"" ).append(suspensionsByRaceGraph).append( "\"" );
		sb.append( ", suspensionRatesByRaceGraph: \"" ).append(suspensionRatesByRaceGraph).append( "\"" );
		sb.append( ", countySchoolBasedComplaintsGraph: \"" ).append(countySchoolBasedComplaintsGraph).append( "\"" );
		sb.append( ", schoolBasedComplaintsGraph: \"" ).append(schoolBasedComplaintsGraph).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
