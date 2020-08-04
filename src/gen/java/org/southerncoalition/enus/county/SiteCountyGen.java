package org.southerncoalition.enus.county;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.search.SearchList;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.southerncoalition.enus.state.SiteState;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import java.util.ArrayList;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteCountyGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteCounty.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String SiteCounty_AName = "a county";
	public static final String SiteCounty_This = "this ";
	public static final String SiteCounty_ThisName = "this county";
	public static final String SiteCounty_A = "a ";
	public static final String SiteCounty_TheName = "the county";
	public static final String SiteCounty_NameSingular = "county";
	public static final String SiteCounty_NamePlural = "counties";
	public static final String SiteCounty_NameActual = "current county";
	public static final String SiteCounty_AllName = "all the counties";
	public static final String SiteCounty_SearchAllNameBy = "search counties by ";
	public static final String SiteCounty_Title = "counties";
	public static final String SiteCounty_ThePluralName = "the counties";
	public static final String SiteCounty_NoNameFound = "no county found";
	public static final String SiteCounty_NameVar = "county";
	public static final String SiteCounty_OfName = "of county";
	public static final String SiteCounty_ANameAdjective = "a county";
	public static final String SiteCounty_NameAdjectiveSingular = "county";
	public static final String SiteCounty_NameAdjectivePlural = "counties";
	public static final String SiteCounty_Color = "pale-yellow";
	public static final String SiteCounty_IconGroup = "regular";
	public static final String SiteCounty_IconName = "road";

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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyKey">Find the entity countyKey in Solr</a>
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
	public SiteCounty setCountyKey(String o) {
		if(NumberUtils.isParsable(o))
			this.countyKey = Long.parseLong(o);
		this.countyKeyWrap.alreadyInitialized = true;
		return (SiteCounty)this;
	}
	protected SiteCounty countyKeyInit() {
		if(!countyKeyWrap.alreadyInitialized) {
			_countyKey(countyKeyWrap);
			if(countyKey == null)
				setCountyKey(countyKeyWrap.o);
		}
		countyKeyWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
		return null;
	}

	public String htmTooltipCountyKey() {
		return null;
	}

	public String htmCountyKey() {
		return countyKey == null ? "" : StringEscapeUtils.escapeHtml4(strCountyKey());
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyName">Find the entity countyName in Solr</a>
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
	protected SiteCounty countyNameInit() {
		if(!countyNameWrap.alreadyInitialized) {
			_countyName(countyNameWrap);
			if(countyName == null)
				setCountyName(countyNameWrap.o);
		}
		countyNameWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
		return "name";
	}

	public String htmTooltipCountyName() {
		return null;
	}

	public String htmCountyName() {
		return countyName == null ? "" : StringEscapeUtils.escapeHtml4(strCountyName());
	}

	public void inputCountyName(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "name")
				.a("id", classApiMethodMethod, "_countyName");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setCountyName classSiteCounty inputSiteCounty", pk, "CountyName w3-input w3-border ");
					a("name", "setCountyName");
				} else {
					a("class", "valueCountyName w3-input w3-border classSiteCounty inputSiteCounty", pk, "CountyName w3-input w3-border ");
					a("name", "countyName");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setCountyName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_countyName')); }, function() { addError($('#", classApiMethodMethod, "_countyName')); }); ");
				}
				a("value", strCountyName())
			.fg();

		} else {
			e("span").a("class", "varSiteCounty", pk, "CountyName ").f().sx(htmCountyName()).g("span");
		}
	}

	public void htmCountyName(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SiteCountyCountyName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_countyName").a("class", "").f().sx("name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputCountyName(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-yellow ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_countyName')); $('#", classApiMethodMethod, "_countyName').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#SiteCountyForm :input[name=pk]').val() }], 'setCountyName', null, function() { addGlow($('#", classApiMethodMethod, "_countyName')); }, function() { addError($('#", classApiMethodMethod, "_countyName')); }); ")
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

	/////////////////
	// stateSearch //
	/////////////////

	/**	 The entity stateSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteState>(). 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteState> stateSearch = new SearchList<SiteState>();
	@JsonIgnore
	public Wrap<SearchList<SiteState>> stateSearchWrap = new Wrap<SearchList<SiteState>>().p(this).c(SearchList.class).var("stateSearch").o(stateSearch);

	/**	<br/> The entity stateSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteState>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateSearch">Find the entity stateSearch in Solr</a>
	 * <br/>
	 * @param stateSearch is the entity already constructed. 
	 **/
	protected abstract void _stateSearch(SearchList<SiteState> l);

	public SearchList<SiteState> getStateSearch() {
		return stateSearch;
	}

	public void setStateSearch(SearchList<SiteState> stateSearch) {
		this.stateSearch = stateSearch;
		this.stateSearchWrap.alreadyInitialized = true;
	}
	protected SiteCounty stateSearchInit() {
		if(!stateSearchWrap.alreadyInitialized) {
			_stateSearch(stateSearch);
		}
		stateSearch.initDeepForClass(siteRequest_);
		stateSearchWrap.alreadyInitialized(true);
		return (SiteCounty)this;
	}

	////////////
	// state_ //
	////////////

	/**	 The entity state_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteState state_;
	@JsonIgnore
	public Wrap<SiteState> state_Wrap = new Wrap<SiteState>().p(this).c(SiteState.class).var("state_").o(state_);

	/**	<br/> The entity state_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:state_">Find the entity state_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _state_(Wrap<SiteState> c);

	public SiteState getState_() {
		return state_;
	}

	public void setState_(SiteState state_) {
		this.state_ = state_;
		this.state_Wrap.alreadyInitialized = true;
	}
	protected SiteCounty state_Init() {
		if(!state_Wrap.alreadyInitialized) {
			_state_(state_Wrap);
			if(state_ == null)
				setState_(state_Wrap.o);
		}
		state_Wrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateKey">Find the entity stateKey in Solr</a>
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
	public SiteCounty setStateKey(String o) {
		if(NumberUtils.isParsable(o))
			this.stateKey = Long.parseLong(o);
		this.stateKeyWrap.alreadyInitialized = true;
		return (SiteCounty)this;
	}
	protected SiteCounty stateKeyInit() {
		if(!stateKeyWrap.alreadyInitialized) {
			_stateKey(stateKeyWrap);
			if(stateKey == null)
				setStateKey(stateKeyWrap.o);
		}
		stateKeyWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
		return "state";
	}

	public String htmTooltipStateKey() {
		return null;
	}

	public String htmStateKey() {
		return stateKey == null ? "" : StringEscapeUtils.escapeHtml4(strStateKey());
	}

	public void inputStateKey(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
				e("input")
					.a("type", "text")
					.a("placeholder", "state")
					.a("class", "value suggestStateKey w3-input w3-border w3-cell w3-cell-middle ")
					.a("name", "setStateKey")
					.a("id", classApiMethodMethod, "_stateKey")
					.a("autocomplete", "off")
					.a("oninput", "suggestSiteCountyStateKey($(this).val() ? searchSiteStateFilters($(this.parentElement)) : [", pk == null ? "" : "{'name':'fq','value':'countyKeys:" + pk + "'}", "], $('#listSiteCountyStateKey_", classApiMethodMethod, "'), ", pk, "); ")
				.fg();

		} else {
			e("span").a("class", "varSiteCounty", pk, "StateKey ").f().sx(htmStateKey()).g("span");
		}
	}

	public void htmStateKey(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SiteCountyStateKey").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/state?fq=countyKeys:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-pale-blue w3-hover-pale-blue ").f();
								e("i").a("class", "far fa-globe-americas ").f().g("i");
								sx("state");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate a state to this county");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputStateKey(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listSiteCountyStateKey_", classApiMethodMethod).f();
								} g("ul");
								if(
										CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), SiteState.ROLES)
										|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), SiteState.ROLES)
										) {
									{ e("div").a("class", "w3-cell-row ").f();
										e("button")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-blue ")
											.a("id", classApiMethodMethod, "_stateKey_add")
											.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postSiteStateVals({ countyKeys: [ \"", pk, "\" ] }, function() {}, function() { addError($('#", classApiMethodMethod, "stateKey')); });")
											.f().sx("add a state")
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

	////////////////////
	// reportCardKeys //
	////////////////////

	/**	 The entity reportCardKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> reportCardKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> reportCardKeysWrap = new Wrap<List<Long>>().p(this).c(List.class).var("reportCardKeys").o(reportCardKeys);

	/**	<br/> The entity reportCardKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardKeys">Find the entity reportCardKeys in Solr</a>
	 * <br/>
	 * @param reportCardKeys is the entity already constructed. 
	 **/
	protected abstract void _reportCardKeys(List<Long> c);

	public List<Long> getReportCardKeys() {
		return reportCardKeys;
	}

	public void setReportCardKeys(List<Long> reportCardKeys) {
		this.reportCardKeys = reportCardKeys;
		this.reportCardKeysWrap.alreadyInitialized = true;
	}
	public SiteCounty addReportCardKeys(Long...objets) {
		for(Long o : objets) {
			addReportCardKeys(o);
		}
		return (SiteCounty)this;
	}
	public SiteCounty addReportCardKeys(Long o) {
		if(o != null && !reportCardKeys.contains(o))
			this.reportCardKeys.add(o);
		return (SiteCounty)this;
	}
	public SiteCounty setReportCardKeys(JsonArray objets) {
		reportCardKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addReportCardKeys(o);
		}
		return (SiteCounty)this;
	}
	public SiteCounty addReportCardKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addReportCardKeys(p);
		}
		return (SiteCounty)this;
	}
	protected SiteCounty reportCardKeysInit() {
		if(!reportCardKeysWrap.alreadyInitialized) {
			_reportCardKeys(reportCardKeys);
		}
		reportCardKeysWrap.alreadyInitialized(true);
		return (SiteCounty)this;
	}

	public List<Long> solrReportCardKeys() {
		return reportCardKeys;
	}

	public String strReportCardKeys() {
		return reportCardKeys == null ? "" : reportCardKeys.toString();
	}

	public String jsonReportCardKeys() {
		return reportCardKeys == null ? "" : reportCardKeys.toString();
	}

	public String nomAffichageReportCardKeys() {
		return "report cards";
	}

	public String htmTooltipReportCardKeys() {
		return null;
	}

	public String htmReportCardKeys() {
		return reportCardKeys == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardKeys());
	}

	public void inputReportCardKeys(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
				e("input")
					.a("type", "text")
					.a("placeholder", "report cards")
					.a("class", "value suggestReportCardKeys w3-input w3-border w3-cell w3-cell-middle ")
					.a("name", "setReportCardKeys")
					.a("id", classApiMethodMethod, "_reportCardKeys")
					.a("autocomplete", "off")
					.a("oninput", "suggestSiteCountyReportCardKeys($(this).val() ? searchReportCardFilters($(this.parentElement)) : [", pk == null ? "" : "{'name':'fq','value':'countyKey:" + pk + "'}", "], $('#listSiteCountyReportCardKeys_", classApiMethodMethod, "'), ", pk, "); ")
				.fg();

		} else {
			e("span").a("class", "varSiteCounty", pk, "ReportCardKeys ").f().sx(htmReportCardKeys()).g("span");
		}
	}

	public void htmReportCardKeys(String classApiMethodMethod) {
		SiteCounty s = (SiteCounty)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SiteCountyReportCardKeys").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/reportcard?fq=countyKey:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-pale-green w3-hover-pale-green ").f();
								e("i").a("class", "far fa-newspaper ").f().g("i");
								sx("report cards");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate  to this county");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputReportCardKeys(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listSiteCountyReportCardKeys_", classApiMethodMethod).f();
								} g("ul");
								if(
										CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ReportCard.ROLES)
										|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ReportCard.ROLES)
										) {
									{ e("div").a("class", "w3-cell-row ").f();
										e("button")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
											.a("id", classApiMethodMethod, "_reportCardKeys_add")
											.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postReportCardVals({ countyKey: \"", pk, "\" }, function() {}, function() { addError($('#", classApiMethodMethod, "reportCardKeys')); });")
											.f().sx("add a report card")
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateName">Find the entity stateName in Solr</a>
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
	protected SiteCounty stateNameInit() {
		if(!stateNameWrap.alreadyInitialized) {
			_stateName(stateNameWrap);
			if(stateName == null)
				setStateName(stateNameWrap.o);
		}
		stateNameWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateAbbreviation">Find the entity stateAbbreviation in Solr</a>
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
	protected SiteCounty stateAbbreviationInit() {
		if(!stateAbbreviationWrap.alreadyInitialized) {
			_stateAbbreviation(stateAbbreviationWrap);
			if(stateAbbreviation == null)
				setStateAbbreviation(stateAbbreviationWrap.o);
		}
		stateAbbreviationWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCounty&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:countyCompleteName">Find the entity countyCompleteName in Solr</a>
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
	protected SiteCounty countyCompleteNameInit() {
		if(!countyCompleteNameWrap.alreadyInitialized) {
			_countyCompleteName(countyCompleteNameWrap);
			if(countyCompleteName == null)
				setCountyCompleteName(countyCompleteNameWrap.o);
		}
		countyCompleteNameWrap.alreadyInitialized(true);
		return (SiteCounty)this;
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

	protected boolean alreadyInitializedSiteCounty = false;

	public SiteCounty initDeepSiteCounty(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteCounty) {
			alreadyInitializedSiteCounty = true;
			initDeepSiteCounty();
		}
		return (SiteCounty)this;
	}

	public void initDeepSiteCounty() {
		initSiteCounty();
		super.initDeepCluster(siteRequest_);
	}

	public void initSiteCounty() {
		countyKeyInit();
		countyNameInit();
		stateSearchInit();
		state_Init();
		stateKeyInit();
		reportCardKeysInit();
		stateNameInit();
		stateAbbreviationInit();
		countyCompleteNameInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteCounty(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteCounty(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
		if(stateSearch != null)
			stateSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteCounty(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteCounty(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSiteCounty(String var) {
		SiteCounty oSiteCounty = (SiteCounty)this;
		switch(var) {
			case "countyKey":
				return oSiteCounty.countyKey;
			case "countyName":
				return oSiteCounty.countyName;
			case "stateSearch":
				return oSiteCounty.stateSearch;
			case "state_":
				return oSiteCounty.state_;
			case "stateKey":
				return oSiteCounty.stateKey;
			case "reportCardKeys":
				return oSiteCounty.reportCardKeys;
			case "stateName":
				return oSiteCounty.stateName;
			case "stateAbbreviation":
				return oSiteCounty.stateAbbreviation;
			case "countyCompleteName":
				return oSiteCounty.countyCompleteName;
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
				o = attributeSiteCounty(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteCounty(String var, Object val) {
		SiteCounty oSiteCounty = (SiteCounty)this;
		switch(var) {
			case "stateKey":
				oSiteCounty.setStateKey((Long)val);
				if(!saves.contains(var))
					saves.add(var);
				return val;
			case "reportCardKeys":
				oSiteCounty.addReportCardKeys((Long)val);
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
					o = defineSiteCounty(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteCounty(String var, String val) {
		switch(var) {
			case "countyName":
				if(val != null)
					setCountyName(val);
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
		populateSiteCounty(solrDocument);
	}
	public void populateSiteCounty(SolrDocument solrDocument) {
		SiteCounty oSiteCounty = (SiteCounty)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("countyKey")) {
				Long countyKey = (Long)solrDocument.get("countyKey_stored_long");
				if(countyKey != null)
					oSiteCounty.setCountyKey(countyKey);
			}

			if(saves.contains("countyName")) {
				String countyName = (String)solrDocument.get("countyName_stored_string");
				if(countyName != null)
					oSiteCounty.setCountyName(countyName);
			}

			Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
			if(stateKey != null)
				oSiteCounty.setStateKey(stateKey);

			List<Long> reportCardKeys = (List<Long>)solrDocument.get("reportCardKeys_stored_longs");
			if(reportCardKeys != null)
				oSiteCounty.reportCardKeys.addAll(reportCardKeys);

			if(saves.contains("stateName")) {
				String stateName = (String)solrDocument.get("stateName_stored_string");
				if(stateName != null)
					oSiteCounty.setStateName(stateName);
			}

			if(saves.contains("stateAbbreviation")) {
				String stateAbbreviation = (String)solrDocument.get("stateAbbreviation_stored_string");
				if(stateAbbreviation != null)
					oSiteCounty.setStateAbbreviation(stateAbbreviation);
			}

			if(saves.contains("countyCompleteName")) {
				String countyCompleteName = (String)solrDocument.get("countyCompleteName_stored_string");
				if(countyCompleteName != null)
					oSiteCounty.setCountyCompleteName(countyCompleteName);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.southerncoalition.enus.county.SiteCounty"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			SiteCounty o = new SiteCounty();
			o.siteRequestSiteCounty(siteRequest);
			o.initDeepSiteCounty(siteRequest);
			o.indexSiteCounty();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexSiteCounty();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexSiteCounty(document);
	}

	public void indexSiteCounty(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteCounty(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteCounty() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteCounty(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteCounty(SolrInputDocument document) {
		if(countyKey != null) {
			document.addField("countyKey_indexed_long", countyKey);
			document.addField("countyKey_stored_long", countyKey);
		}
		if(countyName != null) {
			document.addField("countyName_indexed_string", countyName);
			document.addField("countyName_stored_string", countyName);
		}
		if(stateKey != null) {
			document.addField("stateKey_indexed_long", stateKey);
			document.addField("stateKey_stored_long", stateKey);
		}
		if(reportCardKeys != null) {
			for(java.lang.Long o : reportCardKeys) {
				document.addField("reportCardKeys_indexed_longs", o);
			}
			for(java.lang.Long o : reportCardKeys) {
				document.addField("reportCardKeys_stored_longs", o);
			}
		}
		if(stateName != null) {
			document.addField("stateName_indexed_string", stateName);
			document.addField("stateName_stored_string", stateName);
		}
		if(stateAbbreviation != null) {
			document.addField("stateAbbreviation_indexed_string", stateAbbreviation);
			document.addField("stateAbbreviation_stored_string", stateAbbreviation);
		}
		if(countyCompleteName != null) {
			document.addField("countyCompleteName_indexed_string", countyCompleteName);
			document.addField("countyCompleteName_stored_string", countyCompleteName);
		}
		super.indexCluster(document);

	}

	public void unindexSiteCounty() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepSiteCounty(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedSiteCounty(String entityVar) {
		switch(entityVar) {
			case "countyKey":
				return "countyKey_indexed_long";
			case "countyName":
				return "countyName_indexed_string";
			case "stateKey":
				return "stateKey_indexed_long";
			case "reportCardKeys":
				return "reportCardKeys_indexed_longs";
			case "stateName":
				return "stateName_indexed_string";
			case "stateAbbreviation":
				return "stateAbbreviation_indexed_string";
			case "countyCompleteName":
				return "countyCompleteName_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchSiteCounty(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedSiteCounty(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSiteCounty(solrDocument);
	}
	public void storeSiteCounty(SolrDocument solrDocument) {
		SiteCounty oSiteCounty = (SiteCounty)this;

		Long countyKey = (Long)solrDocument.get("countyKey_stored_long");
		if(countyKey != null)
			oSiteCounty.setCountyKey(countyKey);

		String countyName = (String)solrDocument.get("countyName_stored_string");
		if(countyName != null)
			oSiteCounty.setCountyName(countyName);

		Long stateKey = (Long)solrDocument.get("stateKey_stored_long");
		if(stateKey != null)
			oSiteCounty.setStateKey(stateKey);

		List<Long> reportCardKeys = (List<Long>)solrDocument.get("reportCardKeys_stored_longs");
		if(reportCardKeys != null)
			oSiteCounty.reportCardKeys.addAll(reportCardKeys);

		String stateName = (String)solrDocument.get("stateName_stored_string");
		if(stateName != null)
			oSiteCounty.setStateName(stateName);

		String stateAbbreviation = (String)solrDocument.get("stateAbbreviation_stored_string");
		if(stateAbbreviation != null)
			oSiteCounty.setStateAbbreviation(stateAbbreviation);

		String countyCompleteName = (String)solrDocument.get("countyCompleteName_stored_string");
		if(countyCompleteName != null)
			oSiteCounty.setCountyCompleteName(countyCompleteName);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteCounty() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteCounty) {
			SiteCounty original = (SiteCounty)o;
			if(!Objects.equals(countyKey, original.getCountyKey()))
				apiRequest.addVars("countyKey");
			if(!Objects.equals(countyName, original.getCountyName()))
				apiRequest.addVars("countyName");
			if(!Objects.equals(stateKey, original.getStateKey()))
				apiRequest.addVars("stateKey");
			if(!Objects.equals(reportCardKeys, original.getReportCardKeys()))
				apiRequest.addVars("reportCardKeys");
			if(!Objects.equals(stateName, original.getStateName()))
				apiRequest.addVars("stateName");
			if(!Objects.equals(stateAbbreviation, original.getStateAbbreviation()))
				apiRequest.addVars("stateAbbreviation");
			if(!Objects.equals(countyCompleteName, original.getCountyCompleteName()))
				apiRequest.addVars("countyCompleteName");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), countyKey, countyName, stateKey, reportCardKeys, stateName, stateAbbreviation, countyCompleteName);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SiteCounty))
			return false;
		SiteCounty that = (SiteCounty)o;
		return super.equals(o)
				&& Objects.equals( countyKey, that.countyKey )
				&& Objects.equals( countyName, that.countyName )
				&& Objects.equals( stateKey, that.stateKey )
				&& Objects.equals( reportCardKeys, that.reportCardKeys )
				&& Objects.equals( stateName, that.stateName )
				&& Objects.equals( stateAbbreviation, that.stateAbbreviation )
				&& Objects.equals( countyCompleteName, that.countyCompleteName );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteCounty { ");
		sb.append( "countyKey: " ).append(countyKey);
		sb.append( ", countyName: \"" ).append(countyName).append( "\"" );
		sb.append( ", stateKey: " ).append(stateKey);
		sb.append( ", reportCardKeys: " ).append(reportCardKeys);
		sb.append( ", stateName: \"" ).append(stateName).append( "\"" );
		sb.append( ", stateAbbreviation: \"" ).append(stateAbbreviation).append( "\"" );
		sb.append( ", countyCompleteName: \"" ).append(countyCompleteName).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
