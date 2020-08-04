package org.southerncoalition.enus.county;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.southerncoalition.enus.county.SiteCountyGenPage;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.county.SiteCountyPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteCountyPageGen<DEV> extends SiteCountyGenPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteCountyPage.class);

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteCountyPage = false;

	public SiteCountyPage initDeepSiteCountyPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteCountyPage) {
			alreadyInitializedSiteCountyPage = true;
			initDeepSiteCountyPage();
		}
		return (SiteCountyPage)this;
	}

	public void initDeepSiteCountyPage() {
		initSiteCountyPage();
		super.initDeepSiteCountyGenPage(siteRequest_);
	}

	public void initSiteCountyPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteCountyPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteCountyPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestSiteCountyGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteCountyPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteCountyPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSiteCountyPage(String var) {
		SiteCountyPage oSiteCountyPage = (SiteCountyPage)this;
		switch(var) {
			default:
				return super.obtainSiteCountyGenPage(var);
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
				o = attributeSiteCountyPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteCountyPage(String var, Object val) {
		SiteCountyPage oSiteCountyPage = (SiteCountyPage)this;
		switch(var) {
			default:
				return super.attributeSiteCountyGenPage(var, val);
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
					o = defineSiteCountyPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteCountyPage(String var, String val) {
		switch(var) {
			default:
				return super.defineSiteCountyGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsSiteCountyPage();
		super.htmlScripts();
	}

	public void htmlScriptsSiteCountyPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptSiteCountyPage();
		super.htmlScript();
	}

	public void htmlScriptSiteCountyPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodySiteCountyPage();
		super.htmlBody();
	}

	public void htmlBodySiteCountyPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlSiteCountyPage();
		super.html();
	}

	public void htmlSiteCountyPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaSiteCountyPage();
		super.htmlMeta();
	}

	public void htmlMetaSiteCountyPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesSiteCountyPage();
		super.htmlStyles();
	}

	public void htmlStylesSiteCountyPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleSiteCountyPage();
		super.htmlStyle();
	}

	public void htmlStyleSiteCountyPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteCountyPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteCountyPage) {
			SiteCountyPage original = (SiteCountyPage)o;
			super.apiRequestSiteCountyGenPage();
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
		if(!(o instanceof SiteCountyPage))
			return false;
		SiteCountyPage that = (SiteCountyPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteCountyPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
