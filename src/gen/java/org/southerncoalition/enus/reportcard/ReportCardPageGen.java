package org.southerncoalition.enus.reportcard;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.southerncoalition.enus.reportcard.ReportCardGenPage;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCardPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ReportCardPageGen<DEV> extends ReportCardGenPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportCardPage.class);

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedReportCardPage = false;

	public ReportCardPage initDeepReportCardPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedReportCardPage) {
			alreadyInitializedReportCardPage = true;
			initDeepReportCardPage();
		}
		return (ReportCardPage)this;
	}

	public void initDeepReportCardPage() {
		initReportCardPage();
		super.initDeepReportCardGenPage(siteRequest_);
	}

	public void initReportCardPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepReportCardPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportCardPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestReportCardGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportCardPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportCardPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainReportCardPage(String var) {
		ReportCardPage oReportCardPage = (ReportCardPage)this;
		switch(var) {
			default:
				return super.obtainReportCardGenPage(var);
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
				o = attributeReportCardPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeReportCardPage(String var, Object val) {
		ReportCardPage oReportCardPage = (ReportCardPage)this;
		switch(var) {
			default:
				return super.attributeReportCardGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportCardPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportCardPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ReportCardGenPage.staticSetReportCardGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrReportCardPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrReportCardPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ReportCardGenPage.staticSolrReportCardGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrReportCardPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrReportCardPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ReportCardGenPage.staticSolrStrReportCardGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqReportCardPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqReportCardPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ReportCardGenPage.staticSolrFqReportCardGenPage(entityVar,  siteRequest_, o);
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
					o = defineReportCardPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportCardPage(String var, String val) {
		switch(var) {
			default:
				return super.defineReportCardGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsReportCardPage();
		super.htmlScripts();
	}

	public void htmlScriptsReportCardPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptReportCardPage();
		super.htmlScript();
	}

	public void htmlScriptReportCardPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyReportCardPage();
		super.htmlBody();
	}

	public void htmlBodyReportCardPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlReportCardPage();
		super.html();
	}

	public void htmlReportCardPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaReportCardPage();
		super.htmlMeta();
	}

	public void htmlMetaReportCardPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesReportCardPage();
		super.htmlStyles();
	}

	public void htmlStylesReportCardPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleReportCardPage();
		super.htmlStyle();
	}

	public void htmlStyleReportCardPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportCardPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportCardPage) {
			ReportCardPage original = (ReportCardPage)o;
			super.apiRequestReportCardGenPage();
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
		if(!(o instanceof ReportCardPage))
			return false;
		ReportCardPage that = (ReportCardPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ReportCardPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
