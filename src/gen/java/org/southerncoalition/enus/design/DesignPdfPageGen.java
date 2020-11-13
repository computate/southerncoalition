package org.southerncoalition.enus.design;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.agency.SiteAgency;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.southerncoalition.enus.state.SiteState;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.southerncoalition.enus.html.part.HtmlPart;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.southerncoalition.enus.cluster.Cluster;
import java.math.RoundingMode;
import org.southerncoalition.enus.design.PageDesign;
import org.southerncoalition.enus.wrap.Wrap;
import org.southerncoalition.enus.writer.AllWriter;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.design.DesignPdfGenPage;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.southerncoalition.enus.reportcard.ReportCard;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class DesignPdfPageGen<DEV> extends DesignPdfGenPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(DesignPdfPage.class);

	////////
	// w1 //
	////////

	/**	 The entity w1
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter w1;
	@JsonIgnore
	public Wrap<AllWriter> w1Wrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("w1").o(w1);

	/**	<br/> The entity w1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:w1">Find the entity w1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _w1(Wrap<AllWriter> c);

	public AllWriter getW1() {
		return w1;
	}

	public void setW1(AllWriter w1) {
		this.w1 = w1;
		this.w1Wrap.alreadyInitialized = true;
	}
	public static AllWriter staticSetW1(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage w1Init() {
		if(!w1Wrap.alreadyInitialized) {
			_w1(w1Wrap);
			if(w1 == null)
				setW1(w1Wrap.o);
		}
		if(w1 != null)
			w1.initDeepForClass(siteRequest_);
		w1Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	////////
	// w2 //
	////////

	/**	 The entity w2
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter w2;
	@JsonIgnore
	public Wrap<AllWriter> w2Wrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("w2").o(w2);

	/**	<br/> The entity w2
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:w2">Find the entity w2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _w2(Wrap<AllWriter> c);

	public AllWriter getW2() {
		return w2;
	}

	public void setW2(AllWriter w2) {
		this.w2 = w2;
		this.w2Wrap.alreadyInitialized = true;
	}
	public static AllWriter staticSetW2(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage w2Init() {
		if(!w2Wrap.alreadyInitialized) {
			_w2(w2Wrap);
			if(w2 == null)
				setW2(w2Wrap.o);
		}
		if(w2 != null)
			w2.initDeepForClass(siteRequest_);
		w2Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	////////////////
	// pageDesign //
	////////////////

	/**	 The entity pageDesign
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected PageDesign pageDesign;
	@JsonIgnore
	public Wrap<PageDesign> pageDesignWrap = new Wrap<PageDesign>().p(this).c(PageDesign.class).var("pageDesign").o(pageDesign);

	/**	<br/> The entity pageDesign
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageDesign">Find the entity pageDesign in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDesign(Wrap<PageDesign> c);

	public PageDesign getPageDesign() {
		return pageDesign;
	}

	public void setPageDesign(PageDesign pageDesign) {
		this.pageDesign = pageDesign;
		this.pageDesignWrap.alreadyInitialized = true;
	}
	public static PageDesign staticSetPageDesign(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage pageDesignInit() {
		if(!pageDesignWrap.alreadyInitialized) {
			_pageDesign(pageDesignWrap);
			if(pageDesign == null)
				setPageDesign(pageDesignWrap.o);
		}
		if(pageDesign != null)
			pageDesign.initDeepForClass(siteRequest_);
		pageDesignWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////////
	// pageDesignId //
	//////////////////

	/**	 The entity pageDesignId
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pageDesignId;
	@JsonIgnore
	public Wrap<String> pageDesignIdWrap = new Wrap<String>().p(this).c(String.class).var("pageDesignId").o(pageDesignId);

	/**	<br/> The entity pageDesignId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageDesignId">Find the entity pageDesignId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDesignId(Wrap<String> c);

	public String getPageDesignId() {
		return pageDesignId;
	}
	public void setPageDesignId(String o) {
		this.pageDesignId = DesignPdfPage.staticSetPageDesignId(siteRequest_, o);
		this.pageDesignIdWrap.alreadyInitialized = true;
	}
	public static String staticSetPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage pageDesignIdInit() {
		if(!pageDesignIdWrap.alreadyInitialized) {
			_pageDesignId(pageDesignIdWrap);
			if(pageDesignId == null)
				setPageDesignId(pageDesignIdWrap.o);
		}
		pageDesignIdWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrPageDesignId(siteRequest_, DesignPdfPage.staticSolrPageDesignId(siteRequest_, DesignPdfPage.staticSetPageDesignId(siteRequest_, o)));
	}

	public String solrPageDesignId() {
		return DesignPdfPage.staticSolrPageDesignId(siteRequest_, pageDesignId);
	}

	public String strPageDesignId() {
		return pageDesignId == null ? "" : pageDesignId;
	}

	public String jsonPageDesignId() {
		return pageDesignId == null ? "" : pageDesignId;
	}

	public String nomAffichagePageDesignId() {
		return null;
	}

	public String htmTooltipPageDesignId() {
		return null;
	}

	public String htmPageDesignId() {
		return pageDesignId == null ? "" : StringEscapeUtils.escapeHtml4(strPageDesignId());
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStartYear">Find the entity reportCardStartYear in Solr</a>
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
	public void setReportCardStartYear(String o) {
		this.reportCardStartYear = DesignPdfPage.staticSetReportCardStartYear(siteRequest_, o);
		this.reportCardStartYearWrap.alreadyInitialized = true;
	}
	public static Integer staticSetReportCardStartYear(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected DesignPdfPage reportCardStartYearInit() {
		if(!reportCardStartYearWrap.alreadyInitialized) {
			_reportCardStartYear(reportCardStartYearWrap);
			if(reportCardStartYear == null)
				setReportCardStartYear(reportCardStartYearWrap.o);
		}
		reportCardStartYearWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static Integer staticSolrReportCardStartYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrReportCardStartYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReportCardStartYear(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrReportCardStartYear(siteRequest_, DesignPdfPage.staticSolrReportCardStartYear(siteRequest_, DesignPdfPage.staticSetReportCardStartYear(siteRequest_, o)));
	}

	public Integer solrReportCardStartYear() {
		return DesignPdfPage.staticSolrReportCardStartYear(siteRequest_, reportCardStartYear);
	}

	public String strReportCardStartYear() {
		return reportCardStartYear == null ? "" : reportCardStartYear.toString();
	}

	public String jsonReportCardStartYear() {
		return reportCardStartYear == null ? "" : reportCardStartYear.toString();
	}

	public String nomAffichageReportCardStartYear() {
		return null;
	}

	public String htmTooltipReportCardStartYear() {
		return null;
	}

	public String htmReportCardStartYear() {
		return reportCardStartYear == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardStartYear());
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardEndYear">Find the entity reportCardEndYear in Solr</a>
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
	public void setReportCardEndYear(String o) {
		this.reportCardEndYear = DesignPdfPage.staticSetReportCardEndYear(siteRequest_, o);
		this.reportCardEndYearWrap.alreadyInitialized = true;
	}
	public static Integer staticSetReportCardEndYear(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected DesignPdfPage reportCardEndYearInit() {
		if(!reportCardEndYearWrap.alreadyInitialized) {
			_reportCardEndYear(reportCardEndYearWrap);
			if(reportCardEndYear == null)
				setReportCardEndYear(reportCardEndYearWrap.o);
		}
		reportCardEndYearWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static Integer staticSolrReportCardEndYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrReportCardEndYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReportCardEndYear(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrReportCardEndYear(siteRequest_, DesignPdfPage.staticSolrReportCardEndYear(siteRequest_, DesignPdfPage.staticSetReportCardEndYear(siteRequest_, o)));
	}

	public Integer solrReportCardEndYear() {
		return DesignPdfPage.staticSolrReportCardEndYear(siteRequest_, reportCardEndYear);
	}

	public String strReportCardEndYear() {
		return reportCardEndYear == null ? "" : reportCardEndYear.toString();
	}

	public String jsonReportCardEndYear() {
		return reportCardEndYear == null ? "" : reportCardEndYear.toString();
	}

	public String nomAffichageReportCardEndYear() {
		return null;
	}

	public String htmTooltipReportCardEndYear() {
		return null;
	}

	public String htmReportCardEndYear() {
		return reportCardEndYear == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardEndYear());
	}

	//////////////////////
	// reportCardSearch //
	//////////////////////

	/**	 The entity reportCardSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<ReportCard>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportCard> reportCardSearch = new SearchList<ReportCard>();
	@JsonIgnore
	public Wrap<SearchList<ReportCard>> reportCardSearchWrap = new Wrap<SearchList<ReportCard>>().p(this).c(SearchList.class).var("reportCardSearch").o(reportCardSearch);

	/**	<br/> The entity reportCardSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<ReportCard>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardSearch">Find the entity reportCardSearch in Solr</a>
	 * <br/>
	 * @param reportCardSearch is the entity already constructed. 
	 **/
	protected abstract void _reportCardSearch(SearchList<ReportCard> l);

	public SearchList<ReportCard> getReportCardSearch() {
		return reportCardSearch;
	}

	public void setReportCardSearch(SearchList<ReportCard> reportCardSearch) {
		this.reportCardSearch = reportCardSearch;
		this.reportCardSearchWrap.alreadyInitialized = true;
	}
	public static SearchList<ReportCard> staticSetReportCardSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage reportCardSearchInit() {
		if(!reportCardSearchWrap.alreadyInitialized) {
			_reportCardSearch(reportCardSearch);
		}
		reportCardSearch.initDeepForClass(siteRequest_);
		reportCardSearchWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////////////////
	// reportCardStartYears //
	//////////////////////////

	/**	 The entity reportCardStartYears
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<String> reportCardStartYears = new ArrayList<String>();
	@JsonIgnore
	public Wrap<List<String>> reportCardStartYearsWrap = new Wrap<List<String>>().p(this).c(List.class).var("reportCardStartYears").o(reportCardStartYears);

	/**	<br/> The entity reportCardStartYears
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStartYears">Find the entity reportCardStartYears in Solr</a>
	 * <br/>
	 * @param reportCardStartYears is the entity already constructed. 
	 **/
	protected abstract void _reportCardStartYears(List<String> l);

	public List<String> getReportCardStartYears() {
		return reportCardStartYears;
	}

	public void setReportCardStartYears(List<String> reportCardStartYears) {
		this.reportCardStartYears = reportCardStartYears;
		this.reportCardStartYearsWrap.alreadyInitialized = true;
	}
	public static String staticSetReportCardStartYears(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignPdfPage addReportCardStartYears(String...objets) {
		for(String o : objets) {
			addReportCardStartYears(o);
		}
		return (DesignPdfPage)this;
	}
	public DesignPdfPage addReportCardStartYears(String o) {
		if(o != null && !reportCardStartYears.contains(o))
			this.reportCardStartYears.add(o);
		return (DesignPdfPage)this;
	}
	public void setReportCardStartYears(JsonArray objets) {
		reportCardStartYears.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addReportCardStartYears(o);
		}
	}
	protected DesignPdfPage reportCardStartYearsInit() {
		if(!reportCardStartYearsWrap.alreadyInitialized) {
			_reportCardStartYears(reportCardStartYears);
		}
		reportCardStartYearsWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrReportCardStartYears(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrReportCardStartYears(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReportCardStartYears(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrReportCardStartYears(siteRequest_, DesignPdfPage.staticSolrReportCardStartYears(siteRequest_, DesignPdfPage.staticSetReportCardStartYears(siteRequest_, o)));
	}

	public List<String> solrReportCardStartYears() {
		List<String> l = new ArrayList<String>();
		for(String o : reportCardStartYears) {
			l.add(DesignPdfPage.staticSolrReportCardStartYears(siteRequest_, o));
		}
		return l;
	}

	public String strReportCardStartYears() {
		return reportCardStartYears == null ? "" : reportCardStartYears.toString();
	}

	public String jsonReportCardStartYears() {
		return reportCardStartYears == null ? "" : reportCardStartYears.toString();
	}

	public String nomAffichageReportCardStartYears() {
		return null;
	}

	public String htmTooltipReportCardStartYears() {
		return null;
	}

	public String htmReportCardStartYears() {
		return reportCardStartYears == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardStartYears());
	}

	////////////////////////////////
	// reportCardStartYearCurrent //
	////////////////////////////////

	/**	 The entity reportCardStartYearCurrent
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String reportCardStartYearCurrent;
	@JsonIgnore
	public Wrap<String> reportCardStartYearCurrentWrap = new Wrap<String>().p(this).c(String.class).var("reportCardStartYearCurrent").o(reportCardStartYearCurrent);

	/**	<br/> The entity reportCardStartYearCurrent
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStartYearCurrent">Find the entity reportCardStartYearCurrent in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardStartYearCurrent(Wrap<String> c);

	public String getReportCardStartYearCurrent() {
		return reportCardStartYearCurrent;
	}
	public void setReportCardStartYearCurrent(String o) {
		this.reportCardStartYearCurrent = DesignPdfPage.staticSetReportCardStartYearCurrent(siteRequest_, o);
		this.reportCardStartYearCurrentWrap.alreadyInitialized = true;
	}
	public static String staticSetReportCardStartYearCurrent(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage reportCardStartYearCurrentInit() {
		if(!reportCardStartYearCurrentWrap.alreadyInitialized) {
			_reportCardStartYearCurrent(reportCardStartYearCurrentWrap);
			if(reportCardStartYearCurrent == null)
				setReportCardStartYearCurrent(reportCardStartYearCurrentWrap.o);
		}
		reportCardStartYearCurrentWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrReportCardStartYearCurrent(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrReportCardStartYearCurrent(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqReportCardStartYearCurrent(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrReportCardStartYearCurrent(siteRequest_, DesignPdfPage.staticSolrReportCardStartYearCurrent(siteRequest_, DesignPdfPage.staticSetReportCardStartYearCurrent(siteRequest_, o)));
	}

	public String solrReportCardStartYearCurrent() {
		return DesignPdfPage.staticSolrReportCardStartYearCurrent(siteRequest_, reportCardStartYearCurrent);
	}

	public String strReportCardStartYearCurrent() {
		return reportCardStartYearCurrent == null ? "" : reportCardStartYearCurrent;
	}

	public String jsonReportCardStartYearCurrent() {
		return reportCardStartYearCurrent == null ? "" : reportCardStartYearCurrent;
	}

	public String nomAffichageReportCardStartYearCurrent() {
		return null;
	}

	public String htmTooltipReportCardStartYearCurrent() {
		return null;
	}

	public String htmReportCardStartYearCurrent() {
		return reportCardStartYearCurrent == null ? "" : StringEscapeUtils.escapeHtml4(strReportCardStartYearCurrent());
	}

	/////////////////
	// reportCard_ //
	/////////////////

	/**	 The entity reportCard_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected ReportCard reportCard_;
	@JsonIgnore
	public Wrap<ReportCard> reportCard_Wrap = new Wrap<ReportCard>().p(this).c(ReportCard.class).var("reportCard_").o(reportCard_);

	/**	<br/> The entity reportCard_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCard_">Find the entity reportCard_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCard_(Wrap<ReportCard> c);

	public ReportCard getReportCard_() {
		return reportCard_;
	}

	public void setReportCard_(ReportCard reportCard_) {
		this.reportCard_ = reportCard_;
		this.reportCard_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCard_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage reportCard_Init() {
		if(!reportCard_Wrap.alreadyInitialized) {
			_reportCard_(reportCard_Wrap);
			if(reportCard_ == null)
				setReportCard_(reportCard_Wrap.o);
		}
		reportCard_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	/////////////////
	// reportCards //
	/////////////////

	/**	 The entity reportCards
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<ReportCard> reportCards;
	@JsonIgnore
	public Wrap<List<ReportCard>> reportCardsWrap = new Wrap<List<ReportCard>>().p(this).c(List.class).var("reportCards").o(reportCards);

	/**	<br/> The entity reportCards
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCards">Find the entity reportCards in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCards(Wrap<List<ReportCard>> c);

	public List<ReportCard> getReportCards() {
		return reportCards;
	}

	public void setReportCards(List<ReportCard> reportCards) {
		this.reportCards = reportCards;
		this.reportCardsWrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCards(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignPdfPage addReportCards(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCards(o);
		}
		return (DesignPdfPage)this;
	}
	public DesignPdfPage addReportCards(ReportCard o) {
		if(o != null && !reportCards.contains(o))
			this.reportCards.add(o);
		return (DesignPdfPage)this;
	}
	protected DesignPdfPage reportCardsInit() {
		if(!reportCardsWrap.alreadyInitialized) {
			_reportCards(reportCardsWrap);
			if(reportCards == null)
				setReportCards(reportCardsWrap.o);
		}
		reportCardsWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardStates_">Find the entity reportCardStates_ in Solr</a>
	 * <br/>
	 * @param reportCardStates_ is the entity already constructed. 
	 **/
	protected abstract void _reportCardStates_(List<ReportCard> c);

	public List<ReportCard> getReportCardStates_() {
		return reportCardStates_;
	}

	public void setReportCardStates_(List<ReportCard> reportCardStates_) {
		this.reportCardStates_ = reportCardStates_;
		this.reportCardStates_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCardStates_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignPdfPage addReportCardStates_(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCardStates_(o);
		}
		return (DesignPdfPage)this;
	}
	public DesignPdfPage addReportCardStates_(ReportCard o) {
		if(o != null && !reportCardStates_.contains(o))
			this.reportCardStates_.add(o);
		return (DesignPdfPage)this;
	}
	protected DesignPdfPage reportCardStates_Init() {
		if(!reportCardStates_Wrap.alreadyInitialized) {
			_reportCardStates_(reportCardStates_);
		}
		reportCardStates_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	/////////////////////////
	// reportCardAgencies_ //
	/////////////////////////

	/**	 The entity reportCardAgencies_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<ReportCard> reportCardAgencies_;
	@JsonIgnore
	public Wrap<List<ReportCard>> reportCardAgencies_Wrap = new Wrap<List<ReportCard>>().p(this).c(List.class).var("reportCardAgencies_").o(reportCardAgencies_);

	/**	<br/> The entity reportCardAgencies_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardAgencies_">Find the entity reportCardAgencies_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardAgencies_(Wrap<List<ReportCard>> c);

	public List<ReportCard> getReportCardAgencies_() {
		return reportCardAgencies_;
	}

	public void setReportCardAgencies_(List<ReportCard> reportCardAgencies_) {
		this.reportCardAgencies_ = reportCardAgencies_;
		this.reportCardAgencies_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCardAgencies_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignPdfPage addReportCardAgencies_(ReportCard...objets) {
		for(ReportCard o : objets) {
			addReportCardAgencies_(o);
		}
		return (DesignPdfPage)this;
	}
	public DesignPdfPage addReportCardAgencies_(ReportCard o) {
		if(o != null && !reportCardAgencies_.contains(o))
			this.reportCardAgencies_.add(o);
		return (DesignPdfPage)this;
	}
	protected DesignPdfPage reportCardAgencies_Init() {
		if(!reportCardAgencies_Wrap.alreadyInitialized) {
			_reportCardAgencies_(reportCardAgencies_Wrap);
			if(reportCardAgencies_ == null)
				setReportCardAgencies_(reportCardAgencies_Wrap.o);
		}
		reportCardAgencies_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////////////
	// reportCardState_ //
	//////////////////////

	/**	 The entity reportCardState_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected ReportCard reportCardState_;
	@JsonIgnore
	public Wrap<ReportCard> reportCardState_Wrap = new Wrap<ReportCard>().p(this).c(ReportCard.class).var("reportCardState_").o(reportCardState_);

	/**	<br/> The entity reportCardState_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardState_">Find the entity reportCardState_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardState_(Wrap<ReportCard> c);

	public ReportCard getReportCardState_() {
		return reportCardState_;
	}

	public void setReportCardState_(ReportCard reportCardState_) {
		this.reportCardState_ = reportCardState_;
		this.reportCardState_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCardState_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage reportCardState_Init() {
		if(!reportCardState_Wrap.alreadyInitialized) {
			_reportCardState_(reportCardState_Wrap);
			if(reportCardState_ == null)
				setReportCardState_(reportCardState_Wrap.o);
		}
		reportCardState_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	///////////////////////
	// reportCardAgency_ //
	///////////////////////

	/**	 The entity reportCardAgency_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected ReportCard reportCardAgency_;
	@JsonIgnore
	public Wrap<ReportCard> reportCardAgency_Wrap = new Wrap<ReportCard>().p(this).c(ReportCard.class).var("reportCardAgency_").o(reportCardAgency_);

	/**	<br/> The entity reportCardAgency_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardAgency_">Find the entity reportCardAgency_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardAgency_(Wrap<ReportCard> c);

	public ReportCard getReportCardAgency_() {
		return reportCardAgency_;
	}

	public void setReportCardAgency_(ReportCard reportCardAgency_) {
		this.reportCardAgency_ = reportCardAgency_;
		this.reportCardAgency_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCardAgency_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage reportCardAgency_Init() {
		if(!reportCardAgency_Wrap.alreadyInitialized) {
			_reportCardAgency_(reportCardAgency_Wrap);
			if(reportCardAgency_ == null)
				setReportCardAgency_(reportCardAgency_Wrap.o);
		}
		reportCardAgency_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	///////////////////////////
	// reportCardReportCard_ //
	///////////////////////////

	/**	 The entity reportCardReportCard_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected ReportCard reportCardReportCard_;
	@JsonIgnore
	public Wrap<ReportCard> reportCardReportCard_Wrap = new Wrap<ReportCard>().p(this).c(ReportCard.class).var("reportCardReportCard_").o(reportCardReportCard_);

	/**	<br/> The entity reportCardReportCard_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportCardReportCard_">Find the entity reportCardReportCard_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportCardReportCard_(Wrap<ReportCard> c);

	public ReportCard getReportCardReportCard_() {
		return reportCardReportCard_;
	}

	public void setReportCardReportCard_(ReportCard reportCardReportCard_) {
		this.reportCardReportCard_ = reportCardReportCard_;
		this.reportCardReportCard_Wrap.alreadyInitialized = true;
	}
	public static ReportCard staticSetReportCardReportCard_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage reportCardReportCard_Init() {
		if(!reportCardReportCard_Wrap.alreadyInitialized) {
			_reportCardReportCard_(reportCardReportCard_Wrap);
			if(reportCardReportCard_ == null)
				setReportCardReportCard_(reportCardReportCard_Wrap.o);
		}
		reportCardReportCard_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////////
	// agencySearch //
	//////////////////

	/**	 The entity agencySearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteAgency>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteAgency> agencySearch = new SearchList<SiteAgency>();
	@JsonIgnore
	public Wrap<SearchList<SiteAgency>> agencySearchWrap = new Wrap<SearchList<SiteAgency>>().p(this).c(SearchList.class).var("agencySearch").o(agencySearch);

	/**	<br/> The entity agencySearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteAgency>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencySearch">Find the entity agencySearch in Solr</a>
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
	public static SearchList<SiteAgency> staticSetAgencySearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage agencySearchInit() {
		if(!agencySearchWrap.alreadyInitialized) {
			_agencySearch(agencySearch);
		}
		agencySearch.initDeepForClass(siteRequest_);
		agencySearchWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agency_">Find the entity agency_ in Solr</a>
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
	public static SiteAgency staticSetAgency_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage agency_Init() {
		if(!agency_Wrap.alreadyInitialized) {
			_agency_(agency_Wrap);
			if(agency_ == null)
				setAgency_(agency_Wrap.o);
		}
		agency_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:agencyKey">Find the entity agencyKey in Solr</a>
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
	public void setAgencyKey(String o) {
		this.agencyKey = DesignPdfPage.staticSetAgencyKey(siteRequest_, o);
		this.agencyKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetAgencyKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected DesignPdfPage agencyKeyInit() {
		if(!agencyKeyWrap.alreadyInitialized) {
			_agencyKey(agencyKeyWrap);
			if(agencyKey == null)
				setAgencyKey(agencyKeyWrap.o);
		}
		agencyKeyWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static Long staticSolrAgencyKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrAgencyKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAgencyKey(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrAgencyKey(siteRequest_, DesignPdfPage.staticSolrAgencyKey(siteRequest_, DesignPdfPage.staticSetAgencyKey(siteRequest_, o)));
	}

	public Long solrAgencyKey() {
		return DesignPdfPage.staticSolrAgencyKey(siteRequest_, agencyKey);
	}

	public String strAgencyKey() {
		return agencyKey == null ? "" : agencyKey.toString();
	}

	public String jsonAgencyKey() {
		return agencyKey == null ? "" : agencyKey.toString();
	}

	public String nomAffichageAgencyKey() {
		return null;
	}

	public String htmTooltipAgencyKey() {
		return null;
	}

	public String htmAgencyKey() {
		return agencyKey == null ? "" : StringEscapeUtils.escapeHtml4(strAgencyKey());
	}

	/////////////////
	// stateSearch //
	/////////////////

	/**	 The entity stateSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteState>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteState> stateSearch = new SearchList<SiteState>();
	@JsonIgnore
	public Wrap<SearchList<SiteState>> stateSearchWrap = new Wrap<SearchList<SiteState>>().p(this).c(SearchList.class).var("stateSearch").o(stateSearch);

	/**	<br/> The entity stateSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteState>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateSearch">Find the entity stateSearch in Solr</a>
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
	public static SearchList<SiteState> staticSetStateSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage stateSearchInit() {
		if(!stateSearchWrap.alreadyInitialized) {
			_stateSearch(stateSearch);
		}
		stateSearch.initDeepForClass(siteRequest_);
		stateSearchWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:state_">Find the entity state_ in Solr</a>
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
	public static SiteState staticSetState_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage state_Init() {
		if(!state_Wrap.alreadyInitialized) {
			_state_(state_Wrap);
			if(state_ == null)
				setState_(state_Wrap.o);
		}
		state_Wrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	////////////////////
	// emailToAddress //
	////////////////////

	/**	 The entity emailToAddress
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailToAddress;
	@JsonIgnore
	public Wrap<String> emailToAddressWrap = new Wrap<String>().p(this).c(String.class).var("emailToAddress").o(emailToAddress);

	/**	<br/> The entity emailToAddress
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailToAddress">Find the entity emailToAddress in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailToAddress(Wrap<String> c);

	public String getEmailToAddress() {
		return emailToAddress;
	}
	public void setEmailToAddress(String o) {
		this.emailToAddress = DesignPdfPage.staticSetEmailToAddress(siteRequest_, o);
		this.emailToAddressWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage emailToAddressInit() {
		if(!emailToAddressWrap.alreadyInitialized) {
			_emailToAddress(emailToAddressWrap);
			if(emailToAddress == null)
				setEmailToAddress(emailToAddressWrap.o);
		}
		emailToAddressWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrEmailToAddress(siteRequest_, DesignPdfPage.staticSolrEmailToAddress(siteRequest_, DesignPdfPage.staticSetEmailToAddress(siteRequest_, o)));
	}

	public String solrEmailToAddress() {
		return DesignPdfPage.staticSolrEmailToAddress(siteRequest_, emailToAddress);
	}

	public String strEmailToAddress() {
		return emailToAddress == null ? "" : emailToAddress;
	}

	public String jsonEmailToAddress() {
		return emailToAddress == null ? "" : emailToAddress;
	}

	public String nomAffichageEmailToAddress() {
		return null;
	}

	public String htmTooltipEmailToAddress() {
		return null;
	}

	public String htmEmailToAddress() {
		return emailToAddress == null ? "" : StringEscapeUtils.escapeHtml4(strEmailToAddress());
	}

	/////////////////
	// emailToName //
	/////////////////

	/**	 The entity emailToName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailToName;
	@JsonIgnore
	public Wrap<String> emailToNameWrap = new Wrap<String>().p(this).c(String.class).var("emailToName").o(emailToName);

	/**	<br/> The entity emailToName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailToName">Find the entity emailToName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailToName(Wrap<String> c);

	public String getEmailToName() {
		return emailToName;
	}
	public void setEmailToName(String o) {
		this.emailToName = DesignPdfPage.staticSetEmailToName(siteRequest_, o);
		this.emailToNameWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage emailToNameInit() {
		if(!emailToNameWrap.alreadyInitialized) {
			_emailToName(emailToNameWrap);
			if(emailToName == null)
				setEmailToName(emailToNameWrap.o);
		}
		emailToNameWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrEmailToName(siteRequest_, DesignPdfPage.staticSolrEmailToName(siteRequest_, DesignPdfPage.staticSetEmailToName(siteRequest_, o)));
	}

	public String solrEmailToName() {
		return DesignPdfPage.staticSolrEmailToName(siteRequest_, emailToName);
	}

	public String strEmailToName() {
		return emailToName == null ? "" : emailToName;
	}

	public String jsonEmailToName() {
		return emailToName == null ? "" : emailToName;
	}

	public String nomAffichageEmailToName() {
		return null;
	}

	public String htmTooltipEmailToName() {
		return null;
	}

	public String htmEmailToName() {
		return emailToName == null ? "" : StringEscapeUtils.escapeHtml4(strEmailToName());
	}

	//////////////////
	// emailMessage //
	//////////////////

	/**	 The entity emailMessage
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailMessage;
	@JsonIgnore
	public Wrap<String> emailMessageWrap = new Wrap<String>().p(this).c(String.class).var("emailMessage").o(emailMessage);

	/**	<br/> The entity emailMessage
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailMessage">Find the entity emailMessage in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailMessage(Wrap<String> c);

	public String getEmailMessage() {
		return emailMessage;
	}
	public void setEmailMessage(String o) {
		this.emailMessage = DesignPdfPage.staticSetEmailMessage(siteRequest_, o);
		this.emailMessageWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage emailMessageInit() {
		if(!emailMessageWrap.alreadyInitialized) {
			_emailMessage(emailMessageWrap);
			if(emailMessage == null)
				setEmailMessage(emailMessageWrap.o);
		}
		emailMessageWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrEmailMessage(siteRequest_, DesignPdfPage.staticSolrEmailMessage(siteRequest_, DesignPdfPage.staticSetEmailMessage(siteRequest_, o)));
	}

	public String solrEmailMessage() {
		return DesignPdfPage.staticSolrEmailMessage(siteRequest_, emailMessage);
	}

	public String strEmailMessage() {
		return emailMessage == null ? "" : emailMessage;
	}

	public String jsonEmailMessage() {
		return emailMessage == null ? "" : emailMessage;
	}

	public String nomAffichageEmailMessage() {
		return null;
	}

	public String htmTooltipEmailMessage() {
		return null;
	}

	public String htmEmailMessage() {
		return emailMessage == null ? "" : StringEscapeUtils.escapeHtml4(strEmailMessage());
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateKey">Find the entity stateKey in Solr</a>
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
	public void setStateKey(String o) {
		this.stateKey = DesignPdfPage.staticSetStateKey(siteRequest_, o);
		this.stateKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetStateKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected DesignPdfPage stateKeyInit() {
		if(!stateKeyWrap.alreadyInitialized) {
			_stateKey(stateKeyWrap);
			if(stateKey == null)
				setStateKey(stateKeyWrap.o);
		}
		stateKeyWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static Long staticSolrStateKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrStateKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStateKey(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrStateKey(siteRequest_, DesignPdfPage.staticSolrStateKey(siteRequest_, DesignPdfPage.staticSetStateKey(siteRequest_, o)));
	}

	public Long solrStateKey() {
		return DesignPdfPage.staticSolrStateKey(siteRequest_, stateKey);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stateName">Find the entity stateName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stateName(Wrap<String> c);

	public String getStateName() {
		return stateName;
	}
	public void setStateName(String o) {
		this.stateName = DesignPdfPage.staticSetStateName(siteRequest_, o);
		this.stateNameWrap.alreadyInitialized = true;
	}
	public static String staticSetStateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignPdfPage stateNameInit() {
		if(!stateNameWrap.alreadyInitialized) {
			_stateName(stateNameWrap);
			if(stateName == null)
				setStateName(stateNameWrap.o);
		}
		stateNameWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	public static String staticSolrStateName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrStateName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStateName(SiteRequestEnUS siteRequest_, String o) {
		return DesignPdfPage.staticSolrStrStateName(siteRequest_, DesignPdfPage.staticSolrStateName(siteRequest_, DesignPdfPage.staticSetStateName(siteRequest_, o)));
	}

	public String solrStateName() {
		return DesignPdfPage.staticSolrStateName(siteRequest_, stateName);
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

	////////////////////
	// htmlPartSearch //
	////////////////////

	/**	 The entity htmlPartSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<HtmlPart>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<HtmlPart> htmlPartSearch = new SearchList<HtmlPart>();
	@JsonIgnore
	public Wrap<SearchList<HtmlPart>> htmlPartSearchWrap = new Wrap<SearchList<HtmlPart>>().p(this).c(SearchList.class).var("htmlPartSearch").o(htmlPartSearch);

	/**	<br/> The entity htmlPartSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<HtmlPart>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlPartSearch">Find the entity htmlPartSearch in Solr</a>
	 * <br/>
	 * @param htmlPartSearch is the entity already constructed. 
	 **/
	protected abstract void _htmlPartSearch(SearchList<HtmlPart> l);

	public SearchList<HtmlPart> getHtmlPartSearch() {
		return htmlPartSearch;
	}

	public void setHtmlPartSearch(SearchList<HtmlPart> htmlPartSearch) {
		this.htmlPartSearch = htmlPartSearch;
		this.htmlPartSearchWrap.alreadyInitialized = true;
	}
	public static SearchList<HtmlPart> staticSetHtmlPartSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfPage htmlPartSearchInit() {
		if(!htmlPartSearchWrap.alreadyInitialized) {
			_htmlPartSearch(htmlPartSearch);
		}
		htmlPartSearch.initDeepForClass(siteRequest_);
		htmlPartSearchWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////////
	// htmlPartList //
	//////////////////

	/**	 The entity htmlPartList
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<HtmlPart> htmlPartList;
	@JsonIgnore
	public Wrap<List<HtmlPart>> htmlPartListWrap = new Wrap<List<HtmlPart>>().p(this).c(List.class).var("htmlPartList").o(htmlPartList);

	/**	<br/> The entity htmlPartList
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.design.DesignPdfPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlPartList">Find the entity htmlPartList in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _htmlPartList(Wrap<List<HtmlPart>> c);

	public List<HtmlPart> getHtmlPartList() {
		return htmlPartList;
	}

	public void setHtmlPartList(List<HtmlPart> htmlPartList) {
		this.htmlPartList = htmlPartList;
		this.htmlPartListWrap.alreadyInitialized = true;
	}
	public static HtmlPart staticSetHtmlPartList(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignPdfPage addHtmlPartList(HtmlPart...objets) {
		for(HtmlPart o : objets) {
			addHtmlPartList(o);
		}
		return (DesignPdfPage)this;
	}
	public DesignPdfPage addHtmlPartList(HtmlPart o) {
		if(o != null && !htmlPartList.contains(o))
			this.htmlPartList.add(o);
		return (DesignPdfPage)this;
	}
	protected DesignPdfPage htmlPartListInit() {
		if(!htmlPartListWrap.alreadyInitialized) {
			_htmlPartList(htmlPartListWrap);
			if(htmlPartList == null)
				setHtmlPartList(htmlPartListWrap.o);
		}
		htmlPartListWrap.alreadyInitialized(true);
		return (DesignPdfPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedDesignPdfPage = false;

	public DesignPdfPage initDeepDesignPdfPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedDesignPdfPage) {
			alreadyInitializedDesignPdfPage = true;
			initDeepDesignPdfPage();
		}
		return (DesignPdfPage)this;
	}

	public void initDeepDesignPdfPage() {
		initDesignPdfPage();
		super.initDeepDesignPdfGenPage(siteRequest_);
	}

	public void initDesignPdfPage() {
		w1Init();
		w2Init();
		pageDesignInit();
		pageDesignIdInit();
		reportCardStartYearInit();
		reportCardEndYearInit();
		reportCardSearchInit();
		reportCardStartYearsInit();
		reportCardStartYearCurrentInit();
		reportCard_Init();
		reportCardsInit();
		reportCardStates_Init();
		reportCardAgencies_Init();
		reportCardState_Init();
		reportCardAgency_Init();
		reportCardReportCard_Init();
		agencySearchInit();
		agency_Init();
		agencyKeyInit();
		stateSearchInit();
		state_Init();
		emailToAddressInit();
		emailToNameInit();
		emailMessageInit();
		stateKeyInit();
		stateNameInit();
		htmlPartSearchInit();
		htmlPartListInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepDesignPdfPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestDesignPdfPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestDesignPdfGenPage(siteRequest_);
		if(w1 != null)
			w1.setSiteRequest_(siteRequest_);
		if(w2 != null)
			w2.setSiteRequest_(siteRequest_);
		if(pageDesign != null)
			pageDesign.setSiteRequest_(siteRequest_);
		if(reportCardSearch != null)
			reportCardSearch.setSiteRequest_(siteRequest_);
		if(agencySearch != null)
			agencySearch.setSiteRequest_(siteRequest_);
		if(stateSearch != null)
			stateSearch.setSiteRequest_(siteRequest_);
		if(htmlPartSearch != null)
			htmlPartSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestDesignPdfPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainDesignPdfPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainDesignPdfPage(String var) {
		DesignPdfPage oDesignPdfPage = (DesignPdfPage)this;
		switch(var) {
			case "w1":
				return oDesignPdfPage.w1;
			case "w2":
				return oDesignPdfPage.w2;
			case "pageDesign":
				return oDesignPdfPage.pageDesign;
			case "pageDesignId":
				return oDesignPdfPage.pageDesignId;
			case "reportCardStartYear":
				return oDesignPdfPage.reportCardStartYear;
			case "reportCardEndYear":
				return oDesignPdfPage.reportCardEndYear;
			case "reportCardSearch":
				return oDesignPdfPage.reportCardSearch;
			case "reportCardStartYears":
				return oDesignPdfPage.reportCardStartYears;
			case "reportCardStartYearCurrent":
				return oDesignPdfPage.reportCardStartYearCurrent;
			case "reportCard_":
				return oDesignPdfPage.reportCard_;
			case "reportCards":
				return oDesignPdfPage.reportCards;
			case "reportCardStates_":
				return oDesignPdfPage.reportCardStates_;
			case "reportCardAgencies_":
				return oDesignPdfPage.reportCardAgencies_;
			case "reportCardState_":
				return oDesignPdfPage.reportCardState_;
			case "reportCardAgency_":
				return oDesignPdfPage.reportCardAgency_;
			case "reportCardReportCard_":
				return oDesignPdfPage.reportCardReportCard_;
			case "agencySearch":
				return oDesignPdfPage.agencySearch;
			case "agency_":
				return oDesignPdfPage.agency_;
			case "agencyKey":
				return oDesignPdfPage.agencyKey;
			case "stateSearch":
				return oDesignPdfPage.stateSearch;
			case "state_":
				return oDesignPdfPage.state_;
			case "emailToAddress":
				return oDesignPdfPage.emailToAddress;
			case "emailToName":
				return oDesignPdfPage.emailToName;
			case "emailMessage":
				return oDesignPdfPage.emailMessage;
			case "stateKey":
				return oDesignPdfPage.stateKey;
			case "stateName":
				return oDesignPdfPage.stateName;
			case "htmlPartSearch":
				return oDesignPdfPage.htmlPartSearch;
			case "htmlPartList":
				return oDesignPdfPage.htmlPartList;
			default:
				return super.obtainDesignPdfGenPage(var);
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
				o = attributeDesignPdfPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeDesignPdfPage(String var, Object val) {
		DesignPdfPage oDesignPdfPage = (DesignPdfPage)this;
		switch(var) {
			default:
				return super.attributeDesignPdfGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetDesignPdfPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetDesignPdfPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignPdfPage.staticSetPageDesignId(siteRequest_, o);
		case "reportCardStartYear":
			return DesignPdfPage.staticSetReportCardStartYear(siteRequest_, o);
		case "reportCardEndYear":
			return DesignPdfPage.staticSetReportCardEndYear(siteRequest_, o);
		case "reportCardStartYears":
			return DesignPdfPage.staticSetReportCardStartYears(siteRequest_, o);
		case "reportCardStartYearCurrent":
			return DesignPdfPage.staticSetReportCardStartYearCurrent(siteRequest_, o);
		case "agencyKey":
			return DesignPdfPage.staticSetAgencyKey(siteRequest_, o);
		case "emailToAddress":
			return DesignPdfPage.staticSetEmailToAddress(siteRequest_, o);
		case "emailToName":
			return DesignPdfPage.staticSetEmailToName(siteRequest_, o);
		case "emailMessage":
			return DesignPdfPage.staticSetEmailMessage(siteRequest_, o);
		case "stateKey":
			return DesignPdfPage.staticSetStateKey(siteRequest_, o);
		case "stateName":
			return DesignPdfPage.staticSetStateName(siteRequest_, o);
			default:
				return DesignPdfGenPage.staticSetDesignPdfGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrDesignPdfPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrDesignPdfPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignPdfPage.staticSolrPageDesignId(siteRequest_, (String)o);
		case "reportCardStartYear":
			return DesignPdfPage.staticSolrReportCardStartYear(siteRequest_, (Integer)o);
		case "reportCardEndYear":
			return DesignPdfPage.staticSolrReportCardEndYear(siteRequest_, (Integer)o);
		case "reportCardStartYears":
			return DesignPdfPage.staticSolrReportCardStartYears(siteRequest_, (String)o);
		case "reportCardStartYearCurrent":
			return DesignPdfPage.staticSolrReportCardStartYearCurrent(siteRequest_, (String)o);
		case "agencyKey":
			return DesignPdfPage.staticSolrAgencyKey(siteRequest_, (Long)o);
		case "emailToAddress":
			return DesignPdfPage.staticSolrEmailToAddress(siteRequest_, (String)o);
		case "emailToName":
			return DesignPdfPage.staticSolrEmailToName(siteRequest_, (String)o);
		case "emailMessage":
			return DesignPdfPage.staticSolrEmailMessage(siteRequest_, (String)o);
		case "stateKey":
			return DesignPdfPage.staticSolrStateKey(siteRequest_, (Long)o);
		case "stateName":
			return DesignPdfPage.staticSolrStateName(siteRequest_, (String)o);
			default:
				return DesignPdfGenPage.staticSolrDesignPdfGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrDesignPdfPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrDesignPdfPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignPdfPage.staticSolrStrPageDesignId(siteRequest_, (String)o);
		case "reportCardStartYear":
			return DesignPdfPage.staticSolrStrReportCardStartYear(siteRequest_, (Integer)o);
		case "reportCardEndYear":
			return DesignPdfPage.staticSolrStrReportCardEndYear(siteRequest_, (Integer)o);
		case "reportCardStartYears":
			return DesignPdfPage.staticSolrStrReportCardStartYears(siteRequest_, (String)o);
		case "reportCardStartYearCurrent":
			return DesignPdfPage.staticSolrStrReportCardStartYearCurrent(siteRequest_, (String)o);
		case "agencyKey":
			return DesignPdfPage.staticSolrStrAgencyKey(siteRequest_, (Long)o);
		case "emailToAddress":
			return DesignPdfPage.staticSolrStrEmailToAddress(siteRequest_, (String)o);
		case "emailToName":
			return DesignPdfPage.staticSolrStrEmailToName(siteRequest_, (String)o);
		case "emailMessage":
			return DesignPdfPage.staticSolrStrEmailMessage(siteRequest_, (String)o);
		case "stateKey":
			return DesignPdfPage.staticSolrStrStateKey(siteRequest_, (Long)o);
		case "stateName":
			return DesignPdfPage.staticSolrStrStateName(siteRequest_, (String)o);
			default:
				return DesignPdfGenPage.staticSolrStrDesignPdfGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqDesignPdfPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqDesignPdfPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignPdfPage.staticSolrFqPageDesignId(siteRequest_, o);
		case "reportCardStartYear":
			return DesignPdfPage.staticSolrFqReportCardStartYear(siteRequest_, o);
		case "reportCardEndYear":
			return DesignPdfPage.staticSolrFqReportCardEndYear(siteRequest_, o);
		case "reportCardStartYears":
			return DesignPdfPage.staticSolrFqReportCardStartYears(siteRequest_, o);
		case "reportCardStartYearCurrent":
			return DesignPdfPage.staticSolrFqReportCardStartYearCurrent(siteRequest_, o);
		case "agencyKey":
			return DesignPdfPage.staticSolrFqAgencyKey(siteRequest_, o);
		case "emailToAddress":
			return DesignPdfPage.staticSolrFqEmailToAddress(siteRequest_, o);
		case "emailToName":
			return DesignPdfPage.staticSolrFqEmailToName(siteRequest_, o);
		case "emailMessage":
			return DesignPdfPage.staticSolrFqEmailMessage(siteRequest_, o);
		case "stateKey":
			return DesignPdfPage.staticSolrFqStateKey(siteRequest_, o);
		case "stateName":
			return DesignPdfPage.staticSolrFqStateName(siteRequest_, o);
			default:
				return DesignPdfGenPage.staticSolrFqDesignPdfGenPage(entityVar,  siteRequest_, o);
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
					o = defineDesignPdfPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineDesignPdfPage(String var, String val) {
		switch(var) {
			default:
				return super.defineDesignPdfGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsDesignPdfPage();
		super.htmlScripts();
	}

	public void htmlScriptsDesignPdfPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptDesignPdfPage();
		super.htmlScript();
	}

	public void htmlScriptDesignPdfPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyDesignPdfPage();
		super.htmlBody();
	}

	public void htmlBodyDesignPdfPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlDesignPdfPage();
		super.html();
	}

	public void htmlDesignPdfPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaDesignPdfPage();
		super.htmlMeta();
	}

	public void htmlMetaDesignPdfPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesDesignPdfPage();
		super.htmlStyles();
	}

	public void htmlStylesDesignPdfPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleDesignPdfPage();
		super.htmlStyle();
	}

	public void htmlStyleDesignPdfPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestDesignPdfPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof DesignPdfPage) {
			DesignPdfPage original = (DesignPdfPage)o;
			super.apiRequestDesignPdfGenPage();
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
		if(!(o instanceof DesignPdfPage))
			return false;
		DesignPdfPage that = (DesignPdfPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("DesignPdfPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
