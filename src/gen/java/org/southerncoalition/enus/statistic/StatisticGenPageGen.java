package org.southerncoalition.enus.statistic;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.search.SearchList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.logging.Logger;
import org.southerncoalition.enus.cluster.Cluster;
import java.math.RoundingMode;
import org.southerncoalition.enus.wrap.Wrap;
import org.southerncoalition.enus.statistic.SiteStatistic;
import org.southerncoalition.enus.writer.AllWriter;
import java.math.MathContext;
import org.southerncoalition.enus.page.PageLayout;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.StatisticGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class StatisticGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(StatisticGenPage.class);

	///////////////////////
	// listSiteStatistic //
	///////////////////////

	/**	 The entity listSiteStatistic
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteStatistic> listSiteStatistic;
	@JsonIgnore
	public Wrap<SearchList<SiteStatistic>> listSiteStatisticWrap = new Wrap<SearchList<SiteStatistic>>().p(this).c(SearchList.class).var("listSiteStatistic").o(listSiteStatistic);

	/**	<br/> The entity listSiteStatistic
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.StatisticGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteStatistic">Find the entity listSiteStatistic in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSiteStatistic(Wrap<SearchList<SiteStatistic>> c);

	public SearchList<SiteStatistic> getListSiteStatistic() {
		return listSiteStatistic;
	}

	public void setListSiteStatistic(SearchList<SiteStatistic> listSiteStatistic) {
		this.listSiteStatistic = listSiteStatistic;
		this.listSiteStatisticWrap.alreadyInitialized = true;
	}
	protected StatisticGenPage listSiteStatisticInit() {
		if(!listSiteStatisticWrap.alreadyInitialized) {
			_listSiteStatistic(listSiteStatisticWrap);
			if(listSiteStatistic == null)
				setListSiteStatistic(listSiteStatisticWrap.o);
		}
		if(listSiteStatistic != null)
			listSiteStatistic.initDeepForClass(siteRequest_);
		listSiteStatisticWrap.alreadyInitialized(true);
		return (StatisticGenPage)this;
	}

	///////////////////
	// siteStatistic //
	///////////////////

	/**	 The entity siteStatistic
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteStatistic siteStatistic;
	@JsonIgnore
	public Wrap<SiteStatistic> siteStatisticWrap = new Wrap<SiteStatistic>().p(this).c(SiteStatistic.class).var("siteStatistic").o(siteStatistic);

	/**	<br/> The entity siteStatistic
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.statistic.StatisticGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteStatistic">Find the entity siteStatistic in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteStatistic(Wrap<SiteStatistic> c);

	public SiteStatistic getSiteStatistic() {
		return siteStatistic;
	}

	public void setSiteStatistic(SiteStatistic siteStatistic) {
		this.siteStatistic = siteStatistic;
		this.siteStatisticWrap.alreadyInitialized = true;
	}
	protected StatisticGenPage siteStatisticInit() {
		if(!siteStatisticWrap.alreadyInitialized) {
			_siteStatistic(siteStatisticWrap);
			if(siteStatistic == null)
				setSiteStatistic(siteStatisticWrap.o);
		}
		if(siteStatistic != null)
			siteStatistic.initDeepForClass(siteRequest_);
		siteStatisticWrap.alreadyInitialized(true);
		return (StatisticGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedStatisticGenPage = false;

	public StatisticGenPage initDeepStatisticGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedStatisticGenPage) {
			alreadyInitializedStatisticGenPage = true;
			initDeepStatisticGenPage();
		}
		return (StatisticGenPage)this;
	}

	public void initDeepStatisticGenPage() {
		initStatisticGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initStatisticGenPage() {
		listSiteStatisticInit();
		siteStatisticInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepStatisticGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestStatisticGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listSiteStatistic != null)
			listSiteStatistic.setSiteRequest_(siteRequest_);
		if(siteStatistic != null)
			siteStatistic.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestStatisticGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainStatisticGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainStatisticGenPage(String var) {
		StatisticGenPage oStatisticGenPage = (StatisticGenPage)this;
		switch(var) {
			case "listSiteStatistic":
				return oStatisticGenPage.listSiteStatistic;
			case "siteStatistic":
				return oStatisticGenPage.siteStatistic;
			default:
				return super.obtainPageLayout(var);
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
				o = attributeStatisticGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeStatisticGenPage(String var, Object val) {
		StatisticGenPage oStatisticGenPage = (StatisticGenPage)this;
		switch(var) {
			default:
				return super.attributePageLayout(var, val);
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
					o = defineStatisticGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineStatisticGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsStatisticGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsStatisticGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptStatisticGenPage();
		super.htmlScript();
	}

	public void htmlScriptStatisticGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyStatisticGenPage();
		super.htmlBody();
	}

	public void htmlBodyStatisticGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlStatisticGenPage();
		super.html();
	}

	public void htmlStatisticGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaStatisticGenPage();
		super.htmlMeta();
	}

	public void htmlMetaStatisticGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesStatisticGenPage();
		super.htmlStyles();
	}

	public void htmlStylesStatisticGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleStatisticGenPage();
		super.htmlStyle();
	}

	public void htmlStyleStatisticGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestStatisticGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof StatisticGenPage) {
			StatisticGenPage original = (StatisticGenPage)o;
			super.apiRequestPageLayout();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof StatisticGenPage))
			return false;
		StatisticGenPage that = (StatisticGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("StatisticGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
