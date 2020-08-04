package org.southerncoalition.enus.reportcard;

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
import org.apache.commons.lang3.math.NumberUtils;
import org.southerncoalition.enus.reportcard.ReportCard;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCardGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ReportCardGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportCardGenPage.class);

	////////////////////
	// listReportCard //
	////////////////////

	/**	 The entity listReportCard
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportCard> listReportCard;
	@JsonIgnore
	public Wrap<SearchList<ReportCard>> listReportCardWrap = new Wrap<SearchList<ReportCard>>().p(this).c(SearchList.class).var("listReportCard").o(listReportCard);

	/**	<br/> The entity listReportCard
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCardGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listReportCard">Find the entity listReportCard in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listReportCard(Wrap<SearchList<ReportCard>> c);

	public SearchList<ReportCard> getListReportCard() {
		return listReportCard;
	}

	public void setListReportCard(SearchList<ReportCard> listReportCard) {
		this.listReportCard = listReportCard;
		this.listReportCardWrap.alreadyInitialized = true;
	}
	protected ReportCardGenPage listReportCardInit() {
		if(!listReportCardWrap.alreadyInitialized) {
			_listReportCard(listReportCardWrap);
			if(listReportCard == null)
				setListReportCard(listReportCardWrap.o);
		}
		if(listReportCard != null)
			listReportCard.initDeepForClass(siteRequest_);
		listReportCardWrap.alreadyInitialized(true);
		return (ReportCardGenPage)this;
	}

	////////////////
	// reportCard //
	////////////////

	/**	 The entity reportCard
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected ReportCard reportCard;
	@JsonIgnore
	public Wrap<ReportCard> reportCardWrap = new Wrap<ReportCard>().p(this).c(ReportCard.class).var("reportCard").o(reportCard);

	/**	<br/> The entity reportCard
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.reportcard.ReportCardGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCard">Find the entity reportCard in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCard(Wrap<ReportCard> c);

	public ReportCard getReportCard() {
		return reportCard;
	}

	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
		this.reportCardWrap.alreadyInitialized = true;
	}
	protected ReportCardGenPage reportCardInit() {
		if(!reportCardWrap.alreadyInitialized) {
			_reportCard(reportCardWrap);
			if(reportCard == null)
				setReportCard(reportCardWrap.o);
		}
		if(reportCard != null)
			reportCard.initDeepForClass(siteRequest_);
		reportCardWrap.alreadyInitialized(true);
		return (ReportCardGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedReportCardGenPage = false;

	public ReportCardGenPage initDeepReportCardGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedReportCardGenPage) {
			alreadyInitializedReportCardGenPage = true;
			initDeepReportCardGenPage();
		}
		return (ReportCardGenPage)this;
	}

	public void initDeepReportCardGenPage() {
		initReportCardGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initReportCardGenPage() {
		listReportCardInit();
		reportCardInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepReportCardGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportCardGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listReportCard != null)
			listReportCard.setSiteRequest_(siteRequest_);
		if(reportCard != null)
			reportCard.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportCardGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportCardGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainReportCardGenPage(String var) {
		ReportCardGenPage oReportCardGenPage = (ReportCardGenPage)this;
		switch(var) {
			case "listReportCard":
				return oReportCardGenPage.listReportCard;
			case "reportCard":
				return oReportCardGenPage.reportCard;
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
				o = attributeReportCardGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeReportCardGenPage(String var, Object val) {
		ReportCardGenPage oReportCardGenPage = (ReportCardGenPage)this;
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
					o = defineReportCardGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportCardGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsReportCardGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsReportCardGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptReportCardGenPage();
		super.htmlScript();
	}

	public void htmlScriptReportCardGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyReportCardGenPage();
		super.htmlBody();
	}

	public void htmlBodyReportCardGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlReportCardGenPage();
		super.html();
	}

	public void htmlReportCardGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaReportCardGenPage();
		super.htmlMeta();
	}

	public void htmlMetaReportCardGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesReportCardGenPage();
		super.htmlStyles();
	}

	public void htmlStylesReportCardGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleReportCardGenPage();
		super.htmlStyle();
	}

	public void htmlStyleReportCardGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportCardGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportCardGenPage) {
			ReportCardGenPage original = (ReportCardGenPage)o;
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
		if(!(o instanceof ReportCardGenPage))
			return false;
		ReportCardGenPage that = (ReportCardGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ReportCardGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
