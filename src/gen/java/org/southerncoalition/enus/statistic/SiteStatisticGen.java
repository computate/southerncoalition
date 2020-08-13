package org.southerncoalition.enus.statistic;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.southerncoalition.enus.context.SiteContextEnUS;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteStatisticGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteStatistic.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String SiteStatistic_AName = "a statistic";
	public static final String SiteStatistic_This = "this ";
	public static final String SiteStatistic_ThisName = "this statistic";
	public static final String SiteStatistic_A = "a ";
	public static final String SiteStatistic_TheName = "the statistic";
	public static final String SiteStatistic_NameSingular = "statistic";
	public static final String SiteStatistic_NamePlural = "statistics";
	public static final String SiteStatistic_NameActual = "current statistic";
	public static final String SiteStatistic_AllName = "all the statistics";
	public static final String SiteStatistic_SearchAllNameBy = "search statistics by ";
	public static final String SiteStatistic_Title = "statistics";
	public static final String SiteStatistic_ThePluralName = "the statistics";
	public static final String SiteStatistic_NoNameFound = "no statistic found";
	public static final String SiteStatistic_NameVar = "statistic";
	public static final String SiteStatistic_OfName = "of statistic";
	public static final String SiteStatistic_ANameAdjective = "a statistic";
	public static final String SiteStatistic_NameAdjectiveSingular = "statistic";
	public static final String SiteStatistic_NameAdjectivePlural = "statistics";
	public static final String SiteStatistic_Color = "pale-green";
	public static final String SiteStatistic_IconGroup = "regular";
	public static final String SiteStatistic_IconName = "newspaper";

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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardKey">Find the entity reportCardKey in Solr</a>
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
	public SiteStatistic setReportCardKey(String o) {
		if(NumberUtils.isParsable(o))
			this.reportCardKey = Long.parseLong(o);
		this.reportCardKeyWrap.alreadyInitialized = true;
		return (SiteStatistic)this;
	}
	protected SiteStatistic reportCardKeyInit() {
		if(!reportCardKeyWrap.alreadyInitialized) {
			_reportCardKey(reportCardKeyWrap);
			if(reportCardKey == null)
				setReportCardKey(reportCardKeyWrap.o);
		}
		reportCardKeyWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
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

	/////////
	// num //
	/////////

	/**	 The entity num
	 *	 is defined as null before being initialized. 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long num;
	@JsonIgnore
	public Wrap<Long> numWrap = new Wrap<Long>().p(this).c(Long.class).var("num").o(num);

	/**	<br/> The entity num
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:num">Find the entity num in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _num(Wrap<Long> c);

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
		this.numWrap.alreadyInitialized = true;
	}
	public SiteStatistic setNum(String o) {
		if(NumberUtils.isParsable(o))
			this.num = Long.parseLong(o);
		this.numWrap.alreadyInitialized = true;
		return (SiteStatistic)this;
	}
	protected SiteStatistic numInit() {
		if(!numWrap.alreadyInitialized) {
			_num(numWrap);
			if(num == null)
				setNum(numWrap.o);
		}
		numWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
	}

	public Long solrNum() {
		return num;
	}

	public String strNum() {
		return num == null ? "" : num.toString();
	}

	public String jsonNum() {
		return num == null ? "" : num.toString();
	}

	public String nomAffichageNum() {
		return null;
	}

	public String htmTooltipNum() {
		return null;
	}

	public String htmNum() {
		return num == null ? "" : StringEscapeUtils.escapeHtml4(strNum());
	}

	///////////////
	// pupilRace //
	///////////////

	/**	 The entity pupilRace
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pupilRace;
	@JsonIgnore
	public Wrap<String> pupilRaceWrap = new Wrap<String>().p(this).c(String.class).var("pupilRace").o(pupilRace);

	/**	<br/> The entity pupilRace
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilRace">Find the entity pupilRace in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilRace(Wrap<String> c);

	public String getPupilRace() {
		return pupilRace;
	}

	public void setPupilRace(String pupilRace) {
		this.pupilRace = pupilRace;
		this.pupilRaceWrap.alreadyInitialized = true;
	}
	protected SiteStatistic pupilRaceInit() {
		if(!pupilRaceWrap.alreadyInitialized) {
			_pupilRace(pupilRaceWrap);
			if(pupilRace == null)
				setPupilRace(pupilRaceWrap.o);
		}
		pupilRaceWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
	}

	public String solrPupilRace() {
		return pupilRace;
	}

	public String strPupilRace() {
		return pupilRace == null ? "" : pupilRace;
	}

	public String jsonPupilRace() {
		return pupilRace == null ? "" : pupilRace;
	}

	public String nomAffichagePupilRace() {
		return null;
	}

	public String htmTooltipPupilRace() {
		return null;
	}

	public String htmPupilRace() {
		return pupilRace == null ? "" : StringEscapeUtils.escapeHtml4(strPupilRace());
	}

	////////////////////
	// pupilRaceColor //
	////////////////////

	/**	 The entity pupilRaceColor
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pupilRaceColor;
	@JsonIgnore
	public Wrap<String> pupilRaceColorWrap = new Wrap<String>().p(this).c(String.class).var("pupilRaceColor").o(pupilRaceColor);

	/**	<br/> The entity pupilRaceColor
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilRaceColor">Find the entity pupilRaceColor in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilRaceColor(Wrap<String> c);

	public String getPupilRaceColor() {
		return pupilRaceColor;
	}

	public void setPupilRaceColor(String pupilRaceColor) {
		this.pupilRaceColor = pupilRaceColor;
		this.pupilRaceColorWrap.alreadyInitialized = true;
	}
	protected SiteStatistic pupilRaceColorInit() {
		if(!pupilRaceColorWrap.alreadyInitialized) {
			_pupilRaceColor(pupilRaceColorWrap);
			if(pupilRaceColor == null)
				setPupilRaceColor(pupilRaceColorWrap.o);
		}
		pupilRaceColorWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
	}

	public String solrPupilRaceColor() {
		return pupilRaceColor;
	}

	public String strPupilRaceColor() {
		return pupilRaceColor == null ? "" : pupilRaceColor;
	}

	public String jsonPupilRaceColor() {
		return pupilRaceColor == null ? "" : pupilRaceColor;
	}

	public String nomAffichagePupilRaceColor() {
		return null;
	}

	public String htmTooltipPupilRaceColor() {
		return null;
	}

	public String htmPupilRaceColor() {
		return pupilRaceColor == null ? "" : StringEscapeUtils.escapeHtml4(strPupilRaceColor());
	}

	//////////////////////
	// pupilRaceReduced //
	//////////////////////

	/**	 The entity pupilRaceReduced
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pupilRaceReduced;
	@JsonIgnore
	public Wrap<String> pupilRaceReducedWrap = new Wrap<String>().p(this).c(String.class).var("pupilRaceReduced").o(pupilRaceReduced);

	/**	<br/> The entity pupilRaceReduced
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilRaceReduced">Find the entity pupilRaceReduced in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilRaceReduced(Wrap<String> c);

	public String getPupilRaceReduced() {
		return pupilRaceReduced;
	}

	public void setPupilRaceReduced(String pupilRaceReduced) {
		this.pupilRaceReduced = pupilRaceReduced;
		this.pupilRaceReducedWrap.alreadyInitialized = true;
	}
	protected SiteStatistic pupilRaceReducedInit() {
		if(!pupilRaceReducedWrap.alreadyInitialized) {
			_pupilRaceReduced(pupilRaceReducedWrap);
			if(pupilRaceReduced == null)
				setPupilRaceReduced(pupilRaceReducedWrap.o);
		}
		pupilRaceReducedWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
	}

	public String solrPupilRaceReduced() {
		return pupilRaceReduced;
	}

	public String strPupilRaceReduced() {
		return pupilRaceReduced == null ? "" : pupilRaceReduced;
	}

	public String jsonPupilRaceReduced() {
		return pupilRaceReduced == null ? "" : pupilRaceReduced;
	}

	public String nomAffichagePupilRaceReduced() {
		return null;
	}

	public String htmTooltipPupilRaceReduced() {
		return null;
	}

	public String htmPupilRaceReduced() {
		return pupilRaceReduced == null ? "" : StringEscapeUtils.escapeHtml4(strPupilRaceReduced());
	}

	///////////////////////////
	// pupilRaceReducedColor //
	///////////////////////////

	/**	 The entity pupilRaceReducedColor
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pupilRaceReducedColor;
	@JsonIgnore
	public Wrap<String> pupilRaceReducedColorWrap = new Wrap<String>().p(this).c(String.class).var("pupilRaceReducedColor").o(pupilRaceReducedColor);

	/**	<br/> The entity pupilRaceReducedColor
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.SiteStatistic&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pupilRaceReducedColor">Find the entity pupilRaceReducedColor in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pupilRaceReducedColor(Wrap<String> c);

	public String getPupilRaceReducedColor() {
		return pupilRaceReducedColor;
	}

	public void setPupilRaceReducedColor(String pupilRaceReducedColor) {
		this.pupilRaceReducedColor = pupilRaceReducedColor;
		this.pupilRaceReducedColorWrap.alreadyInitialized = true;
	}
	protected SiteStatistic pupilRaceReducedColorInit() {
		if(!pupilRaceReducedColorWrap.alreadyInitialized) {
			_pupilRaceReducedColor(pupilRaceReducedColorWrap);
			if(pupilRaceReducedColor == null)
				setPupilRaceReducedColor(pupilRaceReducedColorWrap.o);
		}
		pupilRaceReducedColorWrap.alreadyInitialized(true);
		return (SiteStatistic)this;
	}

	public String solrPupilRaceReducedColor() {
		return pupilRaceReducedColor;
	}

	public String strPupilRaceReducedColor() {
		return pupilRaceReducedColor == null ? "" : pupilRaceReducedColor;
	}

	public String jsonPupilRaceReducedColor() {
		return pupilRaceReducedColor == null ? "" : pupilRaceReducedColor;
	}

	public String nomAffichagePupilRaceReducedColor() {
		return null;
	}

	public String htmTooltipPupilRaceReducedColor() {
		return null;
	}

	public String htmPupilRaceReducedColor() {
		return pupilRaceReducedColor == null ? "" : StringEscapeUtils.escapeHtml4(strPupilRaceReducedColor());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteStatistic = false;

	public SiteStatistic initDeepSiteStatistic(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteStatistic) {
			alreadyInitializedSiteStatistic = true;
			initDeepSiteStatistic();
		}
		return (SiteStatistic)this;
	}

	public void initDeepSiteStatistic() {
		initSiteStatistic();
		super.initDeepCluster(siteRequest_);
	}

	public void initSiteStatistic() {
		reportCardKeyInit();
		numInit();
		pupilRaceInit();
		pupilRaceColorInit();
		pupilRaceReducedInit();
		pupilRaceReducedColorInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteStatistic(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteStatistic(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteStatistic(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteStatistic(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSiteStatistic(String var) {
		SiteStatistic oSiteStatistic = (SiteStatistic)this;
		switch(var) {
			case "reportCardKey":
				return oSiteStatistic.reportCardKey;
			case "num":
				return oSiteStatistic.num;
			case "pupilRace":
				return oSiteStatistic.pupilRace;
			case "pupilRaceColor":
				return oSiteStatistic.pupilRaceColor;
			case "pupilRaceReduced":
				return oSiteStatistic.pupilRaceReduced;
			case "pupilRaceReducedColor":
				return oSiteStatistic.pupilRaceReducedColor;
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
				o = attributeSiteStatistic(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteStatistic(String var, Object val) {
		SiteStatistic oSiteStatistic = (SiteStatistic)this;
		switch(var) {
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
					o = defineSiteStatistic(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteStatistic(String var, String val) {
		switch(var) {
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateSiteStatistic(solrDocument);
	}
	public void populateSiteStatistic(SolrDocument solrDocument) {
		SiteStatistic oSiteStatistic = (SiteStatistic)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("reportCardKey")) {
				Long reportCardKey = (Long)solrDocument.get("reportCardKey_stored_long");
				if(reportCardKey != null)
					oSiteStatistic.setReportCardKey(reportCardKey);
			}

			if(saves.contains("num")) {
				Long num = (Long)solrDocument.get("num_stored_long");
				if(num != null)
					oSiteStatistic.setNum(num);
			}

			if(saves.contains("pupilRace")) {
				String pupilRace = (String)solrDocument.get("pupilRace_stored_string");
				if(pupilRace != null)
					oSiteStatistic.setPupilRace(pupilRace);
			}

			if(saves.contains("pupilRaceColor")) {
				String pupilRaceColor = (String)solrDocument.get("pupilRaceColor_stored_string");
				if(pupilRaceColor != null)
					oSiteStatistic.setPupilRaceColor(pupilRaceColor);
			}

			if(saves.contains("pupilRaceReduced")) {
				String pupilRaceReduced = (String)solrDocument.get("pupilRaceReduced_stored_string");
				if(pupilRaceReduced != null)
					oSiteStatistic.setPupilRaceReduced(pupilRaceReduced);
			}

			if(saves.contains("pupilRaceReducedColor")) {
				String pupilRaceReducedColor = (String)solrDocument.get("pupilRaceReducedColor_stored_string");
				if(pupilRaceReducedColor != null)
					oSiteStatistic.setPupilRaceReducedColor(pupilRaceReducedColor);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.southerncoalition.enus.statistic.SiteStatistic"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			SiteStatistic o = new SiteStatistic();
			o.siteRequestSiteStatistic(siteRequest);
			o.initDeepSiteStatistic(siteRequest);
			o.indexSiteStatistic();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexSiteStatistic();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexSiteStatistic(document);
	}

	public void indexSiteStatistic(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteStatistic(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteStatistic() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteStatistic(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteStatistic(SolrInputDocument document) {
		if(reportCardKey != null) {
			document.addField("reportCardKey_indexed_long", reportCardKey);
			document.addField("reportCardKey_stored_long", reportCardKey);
		}
		if(num != null) {
			document.addField("num_indexed_long", num);
			document.addField("num_stored_long", num);
		}
		if(pupilRace != null) {
			document.addField("pupilRace_indexed_string", pupilRace);
			document.addField("pupilRace_stored_string", pupilRace);
		}
		if(pupilRaceColor != null) {
			document.addField("pupilRaceColor_indexed_string", pupilRaceColor);
			document.addField("pupilRaceColor_stored_string", pupilRaceColor);
		}
		if(pupilRaceReduced != null) {
			document.addField("pupilRaceReduced_indexed_string", pupilRaceReduced);
			document.addField("pupilRaceReduced_stored_string", pupilRaceReduced);
		}
		if(pupilRaceReducedColor != null) {
			document.addField("pupilRaceReducedColor_indexed_string", pupilRaceReducedColor);
			document.addField("pupilRaceReducedColor_stored_string", pupilRaceReducedColor);
		}
		super.indexCluster(document);

	}

	public void unindexSiteStatistic() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepSiteStatistic(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedSiteStatistic(String entityVar) {
		switch(entityVar) {
			case "reportCardKey":
				return "reportCardKey_indexed_long";
			case "num":
				return "num_indexed_long";
			case "pupilRace":
				return "pupilRace_indexed_string";
			case "pupilRaceColor":
				return "pupilRaceColor_indexed_string";
			case "pupilRaceReduced":
				return "pupilRaceReduced_indexed_string";
			case "pupilRaceReducedColor":
				return "pupilRaceReducedColor_indexed_string";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchSiteStatistic(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedSiteStatistic(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSiteStatistic(solrDocument);
	}
	public void storeSiteStatistic(SolrDocument solrDocument) {
		SiteStatistic oSiteStatistic = (SiteStatistic)this;

		Long reportCardKey = (Long)solrDocument.get("reportCardKey_stored_long");
		if(reportCardKey != null)
			oSiteStatistic.setReportCardKey(reportCardKey);

		Long num = (Long)solrDocument.get("num_stored_long");
		if(num != null)
			oSiteStatistic.setNum(num);

		String pupilRace = (String)solrDocument.get("pupilRace_stored_string");
		if(pupilRace != null)
			oSiteStatistic.setPupilRace(pupilRace);

		String pupilRaceColor = (String)solrDocument.get("pupilRaceColor_stored_string");
		if(pupilRaceColor != null)
			oSiteStatistic.setPupilRaceColor(pupilRaceColor);

		String pupilRaceReduced = (String)solrDocument.get("pupilRaceReduced_stored_string");
		if(pupilRaceReduced != null)
			oSiteStatistic.setPupilRaceReduced(pupilRaceReduced);

		String pupilRaceReducedColor = (String)solrDocument.get("pupilRaceReducedColor_stored_string");
		if(pupilRaceReducedColor != null)
			oSiteStatistic.setPupilRaceReducedColor(pupilRaceReducedColor);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteStatistic() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteStatistic) {
			SiteStatistic original = (SiteStatistic)o;
			if(!Objects.equals(reportCardKey, original.getReportCardKey()))
				apiRequest.addVars("reportCardKey");
			if(!Objects.equals(num, original.getNum()))
				apiRequest.addVars("num");
			if(!Objects.equals(pupilRace, original.getPupilRace()))
				apiRequest.addVars("pupilRace");
			if(!Objects.equals(pupilRaceColor, original.getPupilRaceColor()))
				apiRequest.addVars("pupilRaceColor");
			if(!Objects.equals(pupilRaceReduced, original.getPupilRaceReduced()))
				apiRequest.addVars("pupilRaceReduced");
			if(!Objects.equals(pupilRaceReducedColor, original.getPupilRaceReducedColor()))
				apiRequest.addVars("pupilRaceReducedColor");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), reportCardKey, num, pupilRace, pupilRaceColor, pupilRaceReduced, pupilRaceReducedColor);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SiteStatistic))
			return false;
		SiteStatistic that = (SiteStatistic)o;
		return super.equals(o)
				&& Objects.equals( reportCardKey, that.reportCardKey )
				&& Objects.equals( num, that.num )
				&& Objects.equals( pupilRace, that.pupilRace )
				&& Objects.equals( pupilRaceColor, that.pupilRaceColor )
				&& Objects.equals( pupilRaceReduced, that.pupilRaceReduced )
				&& Objects.equals( pupilRaceReducedColor, that.pupilRaceReducedColor );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteStatistic { ");
		sb.append( "reportCardKey: " ).append(reportCardKey);
		sb.append( ", num: " ).append(num);
		sb.append( ", pupilRace: \"" ).append(pupilRace).append( "\"" );
		sb.append( ", pupilRaceColor: \"" ).append(pupilRaceColor).append( "\"" );
		sb.append( ", pupilRaceReduced: \"" ).append(pupilRaceReduced).append( "\"" );
		sb.append( ", pupilRaceReducedColor: \"" ).append(pupilRaceReducedColor).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
