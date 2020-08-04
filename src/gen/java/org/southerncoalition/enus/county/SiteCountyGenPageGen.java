package org.southerncoalition.enus.county;

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
import org.southerncoalition.enus.writer.AllWriter;
import java.math.MathContext;
import org.southerncoalition.enus.page.PageLayout;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.southerncoalition.enus.county.SiteCounty;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCountyGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteCountyGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteCountyGenPage.class);

	////////////////////
	// listSiteCounty //
	////////////////////

	/**	 The entity listSiteCounty
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteCounty> listSiteCounty;
	@JsonIgnore
	public Wrap<SearchList<SiteCounty>> listSiteCountyWrap = new Wrap<SearchList<SiteCounty>>().p(this).c(SearchList.class).var("listSiteCounty").o(listSiteCounty);

	/**	<br/> The entity listSiteCounty
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCountyGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listSiteCounty">Find the entity listSiteCounty in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listSiteCounty(Wrap<SearchList<SiteCounty>> c);

	public SearchList<SiteCounty> getListSiteCounty() {
		return listSiteCounty;
	}

	public void setListSiteCounty(SearchList<SiteCounty> listSiteCounty) {
		this.listSiteCounty = listSiteCounty;
		this.listSiteCountyWrap.alreadyInitialized = true;
	}
	protected SiteCountyGenPage listSiteCountyInit() {
		if(!listSiteCountyWrap.alreadyInitialized) {
			_listSiteCounty(listSiteCountyWrap);
			if(listSiteCounty == null)
				setListSiteCounty(listSiteCountyWrap.o);
		}
		if(listSiteCounty != null)
			listSiteCounty.initDeepForClass(siteRequest_);
		listSiteCountyWrap.alreadyInitialized(true);
		return (SiteCountyGenPage)this;
	}

	////////////////
	// siteCounty //
	////////////////

	/**	 The entity siteCounty
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteCounty siteCounty;
	@JsonIgnore
	public Wrap<SiteCounty> siteCountyWrap = new Wrap<SiteCounty>().p(this).c(SiteCounty.class).var("siteCounty").o(siteCounty);

	/**	<br/> The entity siteCounty
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCountyGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteCounty">Find the entity siteCounty in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteCounty(Wrap<SiteCounty> c);

	public SiteCounty getSiteCounty() {
		return siteCounty;
	}

	public void setSiteCounty(SiteCounty siteCounty) {
		this.siteCounty = siteCounty;
		this.siteCountyWrap.alreadyInitialized = true;
	}
	protected SiteCountyGenPage siteCountyInit() {
		if(!siteCountyWrap.alreadyInitialized) {
			_siteCounty(siteCountyWrap);
			if(siteCounty == null)
				setSiteCounty(siteCountyWrap.o);
		}
		if(siteCounty != null)
			siteCounty.initDeepForClass(siteRequest_);
		siteCountyWrap.alreadyInitialized(true);
		return (SiteCountyGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteCountyGenPage = false;

	public SiteCountyGenPage initDeepSiteCountyGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteCountyGenPage) {
			alreadyInitializedSiteCountyGenPage = true;
			initDeepSiteCountyGenPage();
		}
		return (SiteCountyGenPage)this;
	}

	public void initDeepSiteCountyGenPage() {
		initSiteCountyGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initSiteCountyGenPage() {
		listSiteCountyInit();
		siteCountyInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteCountyGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteCountyGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listSiteCounty != null)
			listSiteCounty.setSiteRequest_(siteRequest_);
		if(siteCounty != null)
			siteCounty.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteCountyGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteCountyGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSiteCountyGenPage(String var) {
		SiteCountyGenPage oSiteCountyGenPage = (SiteCountyGenPage)this;
		switch(var) {
			case "listSiteCounty":
				return oSiteCountyGenPage.listSiteCounty;
			case "siteCounty":
				return oSiteCountyGenPage.siteCounty;
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
				o = attributeSiteCountyGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteCountyGenPage(String var, Object val) {
		SiteCountyGenPage oSiteCountyGenPage = (SiteCountyGenPage)this;
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
					o = defineSiteCountyGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteCountyGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsSiteCountyGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsSiteCountyGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptSiteCountyGenPage();
		super.htmlScript();
	}

	public void htmlScriptSiteCountyGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodySiteCountyGenPage();
		super.htmlBody();
	}

	public void htmlBodySiteCountyGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlSiteCountyGenPage();
		super.html();
	}

	public void htmlSiteCountyGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaSiteCountyGenPage();
		super.htmlMeta();
	}

	public void htmlMetaSiteCountyGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesSiteCountyGenPage();
		super.htmlStyles();
	}

	public void htmlStylesSiteCountyGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleSiteCountyGenPage();
		super.htmlStyle();
	}

	public void htmlStyleSiteCountyGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteCountyGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteCountyGenPage) {
			SiteCountyGenPage original = (SiteCountyGenPage)o;
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
		if(!(o instanceof SiteCountyGenPage))
			return false;
		SiteCountyGenPage that = (SiteCountyGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteCountyGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
