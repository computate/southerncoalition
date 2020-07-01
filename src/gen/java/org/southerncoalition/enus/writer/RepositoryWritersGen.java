package org.southerncoalition.enus.writer;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.solr.common.SolrDocumentList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.southerncoalition.enus.cluster.Cluster;
import org.southerncoalition.enus.wrap.Wrap;
import org.southerncoalition.enus.writer.AllWriter;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import java.io.File;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.southerncoalition.enus.context.SiteContextEnUS;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class RepositoryWritersGen<DEV> extends Object {
	protected static final Logger LOGGER = LoggerFactory.getLogger(RepositoryWriters.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	L'entité « siteRequest_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;
	@JsonIgnore
	public Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().p(this).c(SiteRequestEnUS.class).var("siteRequest_").o(siteRequest_);

	/**	<br/>L'entité « siteRequest_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Trouver l'entité siteRequest_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> c);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
		this.siteRequest_Wrap.alreadyInitialized = true;
	}
	protected RepositoryWriters siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	///////////////////////
	// solrDocumentClass //
	///////////////////////

	/**	L'entité « solrDocumentClass »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SolrDocument solrDocumentClass;
	@JsonIgnore
	public Wrap<SolrDocument> solrDocumentClassWrap = new Wrap<SolrDocument>().p(this).c(SolrDocument.class).var("solrDocumentClass").o(solrDocumentClass);

	/**	<br/>L'entité « solrDocumentClass »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:solrDocumentClass">Trouver l'entité solrDocumentClass dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _solrDocumentClass(Wrap<SolrDocument> c);

	public SolrDocument getSolrDocumentClass() {
		return solrDocumentClass;
	}

	public void setSolrDocumentClass(SolrDocument solrDocumentClass) {
		this.solrDocumentClass = solrDocumentClass;
		this.solrDocumentClassWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters solrDocumentClassInit() {
		if(!solrDocumentClassWrap.alreadyInitialized) {
			_solrDocumentClass(solrDocumentClassWrap);
			if(solrDocumentClass == null)
				setSolrDocumentClass(solrDocumentClassWrap.o);
		}
		solrDocumentClassWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	///////////////////////////
	// searchEntitiesResults //
	///////////////////////////

	/**	L'entité « searchEntitiesResults »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SolrDocumentList searchEntitiesResults;
	@JsonIgnore
	public Wrap<SolrDocumentList> searchEntitiesResultsWrap = new Wrap<SolrDocumentList>().p(this).c(SolrDocumentList.class).var("searchEntitiesResults").o(searchEntitiesResults);

	/**	<br/>L'entité « searchEntitiesResults »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchEntitiesResults">Trouver l'entité searchEntitiesResults dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _searchEntitiesResults(Wrap<SolrDocumentList> c);

	public SolrDocumentList getSearchEntitiesResults() {
		return searchEntitiesResults;
	}

	public void setSearchEntitiesResults(SolrDocumentList searchEntitiesResults) {
		this.searchEntitiesResults = searchEntitiesResults;
		this.searchEntitiesResultsWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters searchEntitiesResultsInit() {
		if(!searchEntitiesResultsWrap.alreadyInitialized) {
			_searchEntitiesResults(searchEntitiesResultsWrap);
			if(searchEntitiesResults == null)
				setSearchEntitiesResults(searchEntitiesResultsWrap.o);
		}
		searchEntitiesResultsWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	//////////////////////
	// projectPathLinux //
	//////////////////////

	/**	L'entité « projectPathLinux »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String projectPathLinux;
	@JsonIgnore
	public Wrap<String> projectPathLinuxWrap = new Wrap<String>().p(this).c(String.class).var("projectPathLinux").o(projectPathLinux);

	/**	<br/>L'entité « projectPathLinux »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:projectPathLinux">Trouver l'entité projectPathLinux dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _projectPathLinux(Wrap<String> c);

	public String getProjectPathLinux() {
		return projectPathLinux;
	}

	public void setProjectPathLinux(String projectPathLinux) {
		this.projectPathLinux = projectPathLinux;
		this.projectPathLinuxWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters projectPathLinuxInit() {
		if(!projectPathLinuxWrap.alreadyInitialized) {
			_projectPathLinux(projectPathLinuxWrap);
			if(projectPathLinux == null)
				setProjectPathLinux(projectPathLinuxWrap.o);
		}
		projectPathLinuxWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrProjectPathLinux() {
		return projectPathLinux;
	}

	public String strProjectPathLinux() {
		return projectPathLinux == null ? "" : projectPathLinux;
	}

	public String jsonProjectPathLinux() {
		return projectPathLinux == null ? "" : projectPathLinux;
	}

	public String nomAffichageProjectPathLinux() {
		return null;
	}

	public String htmTooltipProjectPathLinux() {
		return null;
	}

	public String htmProjectPathLinux() {
		return projectPathLinux == null ? "" : StringEscapeUtils.escapeHtml4(strProjectPathLinux());
	}

	///////////////////////////
	// repositoryPackageName //
	///////////////////////////

	/**	L'entité « repositoryPackageName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String repositoryPackageName;
	@JsonIgnore
	public Wrap<String> repositoryPackageNameWrap = new Wrap<String>().p(this).c(String.class).var("repositoryPackageName").o(repositoryPackageName);

	/**	<br/>L'entité « repositoryPackageName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:repositoryPackageName">Trouver l'entité repositoryPackageName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _repositoryPackageName(Wrap<String> c);

	public String getRepositoryPackageName() {
		return repositoryPackageName;
	}

	public void setRepositoryPackageName(String repositoryPackageName) {
		this.repositoryPackageName = repositoryPackageName;
		this.repositoryPackageNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters repositoryPackageNameInit() {
		if(!repositoryPackageNameWrap.alreadyInitialized) {
			_repositoryPackageName(repositoryPackageNameWrap);
			if(repositoryPackageName == null)
				setRepositoryPackageName(repositoryPackageNameWrap.o);
		}
		repositoryPackageNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrRepositoryPackageName() {
		return repositoryPackageName;
	}

	public String strRepositoryPackageName() {
		return repositoryPackageName == null ? "" : repositoryPackageName;
	}

	public String jsonRepositoryPackageName() {
		return repositoryPackageName == null ? "" : repositoryPackageName;
	}

	public String nomAffichageRepositoryPackageName() {
		return null;
	}

	public String htmTooltipRepositoryPackageName() {
		return null;
	}

	public String htmRepositoryPackageName() {
		return repositoryPackageName == null ? "" : StringEscapeUtils.escapeHtml4(strRepositoryPackageName());
	}

	////////////////////////
	// persistPackageName //
	////////////////////////

	/**	L'entité « persistPackageName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String persistPackageName;
	@JsonIgnore
	public Wrap<String> persistPackageNameWrap = new Wrap<String>().p(this).c(String.class).var("persistPackageName").o(persistPackageName);

	/**	<br/>L'entité « persistPackageName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:persistPackageName">Trouver l'entité persistPackageName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _persistPackageName(Wrap<String> c);

	public String getPersistPackageName() {
		return persistPackageName;
	}

	public void setPersistPackageName(String persistPackageName) {
		this.persistPackageName = persistPackageName;
		this.persistPackageNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters persistPackageNameInit() {
		if(!persistPackageNameWrap.alreadyInitialized) {
			_persistPackageName(persistPackageNameWrap);
			if(persistPackageName == null)
				setPersistPackageName(persistPackageNameWrap.o);
		}
		persistPackageNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPersistPackageName() {
		return persistPackageName;
	}

	public String strPersistPackageName() {
		return persistPackageName == null ? "" : persistPackageName;
	}

	public String jsonPersistPackageName() {
		return persistPackageName == null ? "" : persistPackageName;
	}

	public String nomAffichagePersistPackageName() {
		return null;
	}

	public String htmTooltipPersistPackageName() {
		return null;
	}

	public String htmPersistPackageName() {
		return persistPackageName == null ? "" : StringEscapeUtils.escapeHtml4(strPersistPackageName());
	}

	/////////////////////
	// classSimpleName //
	/////////////////////

	/**	L'entité « classSimpleName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String classSimpleName;
	@JsonIgnore
	public Wrap<String> classSimpleNameWrap = new Wrap<String>().p(this).c(String.class).var("classSimpleName").o(classSimpleName);

	/**	<br/>L'entité « classSimpleName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSimpleName">Trouver l'entité classSimpleName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> c);

	public String getClassSimpleName() {
		return classSimpleName;
	}

	public void setClassSimpleName(String classSimpleName) {
		this.classSimpleName = classSimpleName;
		this.classSimpleNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters classSimpleNameInit() {
		if(!classSimpleNameWrap.alreadyInitialized) {
			_classSimpleName(classSimpleNameWrap);
			if(classSimpleName == null)
				setClassSimpleName(classSimpleNameWrap.o);
		}
		classSimpleNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrClassSimpleName() {
		return classSimpleName;
	}

	public String strClassSimpleName() {
		return classSimpleName == null ? "" : classSimpleName;
	}

	public String jsonClassSimpleName() {
		return classSimpleName == null ? "" : classSimpleName;
	}

	public String nomAffichageClassSimpleName() {
		return null;
	}

	public String htmTooltipClassSimpleName() {
		return null;
	}

	public String htmClassSimpleName() {
		return classSimpleName == null ? "" : StringEscapeUtils.escapeHtml4(strClassSimpleName());
	}

	///////////////////////
	// persistSimpleName //
	///////////////////////

	/**	L'entité « persistSimpleName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String persistSimpleName;
	@JsonIgnore
	public Wrap<String> persistSimpleNameWrap = new Wrap<String>().p(this).c(String.class).var("persistSimpleName").o(persistSimpleName);

	/**	<br/>L'entité « persistSimpleName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:persistSimpleName">Trouver l'entité persistSimpleName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _persistSimpleName(Wrap<String> c);

	public String getPersistSimpleName() {
		return persistSimpleName;
	}

	public void setPersistSimpleName(String persistSimpleName) {
		this.persistSimpleName = persistSimpleName;
		this.persistSimpleNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters persistSimpleNameInit() {
		if(!persistSimpleNameWrap.alreadyInitialized) {
			_persistSimpleName(persistSimpleNameWrap);
			if(persistSimpleName == null)
				setPersistSimpleName(persistSimpleNameWrap.o);
		}
		persistSimpleNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPersistSimpleName() {
		return persistSimpleName;
	}

	public String strPersistSimpleName() {
		return persistSimpleName == null ? "" : persistSimpleName;
	}

	public String jsonPersistSimpleName() {
		return persistSimpleName == null ? "" : persistSimpleName;
	}

	public String nomAffichagePersistSimpleName() {
		return null;
	}

	public String htmTooltipPersistSimpleName() {
		return null;
	}

	public String htmPersistSimpleName() {
		return persistSimpleName == null ? "" : StringEscapeUtils.escapeHtml4(strPersistSimpleName());
	}

	/////////////////////
	// classApiMethods //
	/////////////////////

	/**	L'entité « classApiMethods »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<String> classApiMethods = new ArrayList<String>();
	@JsonIgnore
	public Wrap<List<String>> classApiMethodsWrap = new Wrap<List<String>>().p(this).c(List.class).var("classApiMethods").o(classApiMethods);

	/**	<br/>L'entité « classApiMethods »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiMethods">Trouver l'entité classApiMethods dans Solr</a>
	 * <br/>
	 * @param classApiMethods est l'entité déjà construit. 
	 **/
	protected abstract void _classApiMethods(List<String> c);

	public List<String> getClassApiMethods() {
		return classApiMethods;
	}

	public void setClassApiMethods(List<String> classApiMethods) {
		this.classApiMethods = classApiMethods;
		this.classApiMethodsWrap.alreadyInitialized = true;
	}
	public RepositoryWriters addClassApiMethods(String...objets) {
		for(String o : objets) {
			addClassApiMethods(o);
		}
		return (RepositoryWriters)this;
	}
	public RepositoryWriters addClassApiMethods(String o) {
		if(o != null && !classApiMethods.contains(o))
			this.classApiMethods.add(o);
		return (RepositoryWriters)this;
	}
	public RepositoryWriters setClassApiMethods(JsonArray objets) {
		classApiMethods.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassApiMethods(o);
		}
		return (RepositoryWriters)this;
	}
	protected RepositoryWriters classApiMethodsInit() {
		if(!classApiMethodsWrap.alreadyInitialized) {
			_classApiMethods(classApiMethods);
		}
		classApiMethodsWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public List<String> solrClassApiMethods() {
		return classApiMethods;
	}

	public String strClassApiMethods() {
		return classApiMethods == null ? "" : classApiMethods.toString();
	}

	public String jsonClassApiMethods() {
		return classApiMethods == null ? "" : classApiMethods.toString();
	}

	public String nomAffichageClassApiMethods() {
		return null;
	}

	public String htmTooltipClassApiMethods() {
		return null;
	}

	public String htmClassApiMethods() {
		return classApiMethods == null ? "" : StringEscapeUtils.escapeHtml4(strClassApiMethods());
	}

	/////////////////
	// siteContext //
	/////////////////

	/**	L'entité « siteContext »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteContextEnUS siteContext;
	@JsonIgnore
	public Wrap<SiteContextEnUS> siteContextWrap = new Wrap<SiteContextEnUS>().p(this).c(SiteContextEnUS.class).var("siteContext").o(siteContext);

	/**	<br/>L'entité « siteContext »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteContext">Trouver l'entité siteContext dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _siteContext(Wrap<SiteContextEnUS> c);

	public SiteContextEnUS getSiteContext() {
		return siteContext;
	}

	public void setSiteContext(SiteContextEnUS siteContext) {
		this.siteContext = siteContext;
		this.siteContextWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters siteContextInit() {
		if(!siteContextWrap.alreadyInitialized) {
			_siteContext(siteContextWrap);
			if(siteContext == null)
				setSiteContext(siteContextWrap.o);
		}
		if(siteContext != null)
			siteContext.initDeepForClass(siteRequest_);
		siteContextWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	///////////////////////
	// classAbsolutePath //
	///////////////////////

	/**	L'entité « classAbsolutePath »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String classAbsolutePath;
	@JsonIgnore
	public Wrap<String> classAbsolutePathWrap = new Wrap<String>().p(this).c(String.class).var("classAbsolutePath").o(classAbsolutePath);

	/**	<br/>L'entité « classAbsolutePath »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classAbsolutePath">Trouver l'entité classAbsolutePath dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _classAbsolutePath(Wrap<String> c);

	public String getClassAbsolutePath() {
		return classAbsolutePath;
	}

	public void setClassAbsolutePath(String classAbsolutePath) {
		this.classAbsolutePath = classAbsolutePath;
		this.classAbsolutePathWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters classAbsolutePathInit() {
		if(!classAbsolutePathWrap.alreadyInitialized) {
			_classAbsolutePath(classAbsolutePathWrap);
			if(classAbsolutePath == null)
				setClassAbsolutePath(classAbsolutePathWrap.o);
		}
		classAbsolutePathWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrClassAbsolutePath() {
		return classAbsolutePath;
	}

	public String strClassAbsolutePath() {
		return classAbsolutePath == null ? "" : classAbsolutePath;
	}

	public String jsonClassAbsolutePath() {
		return classAbsolutePath == null ? "" : classAbsolutePath;
	}

	public String nomAffichageClassAbsolutePath() {
		return null;
	}

	public String htmTooltipClassAbsolutePath() {
		return null;
	}

	public String htmClassAbsolutePath() {
		return classAbsolutePath == null ? "" : StringEscapeUtils.escapeHtml4(strClassAbsolutePath());
	}

	//////////////////////////
	// repositorySimpleName //
	//////////////////////////

	/**	L'entité « repositorySimpleName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String repositorySimpleName;
	@JsonIgnore
	public Wrap<String> repositorySimpleNameWrap = new Wrap<String>().p(this).c(String.class).var("repositorySimpleName").o(repositorySimpleName);

	/**	<br/>L'entité « repositorySimpleName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:repositorySimpleName">Trouver l'entité repositorySimpleName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _repositorySimpleName(Wrap<String> c);

	public String getRepositorySimpleName() {
		return repositorySimpleName;
	}

	public void setRepositorySimpleName(String repositorySimpleName) {
		this.repositorySimpleName = repositorySimpleName;
		this.repositorySimpleNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters repositorySimpleNameInit() {
		if(!repositorySimpleNameWrap.alreadyInitialized) {
			_repositorySimpleName(repositorySimpleNameWrap);
			if(repositorySimpleName == null)
				setRepositorySimpleName(repositorySimpleNameWrap.o);
		}
		repositorySimpleNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrRepositorySimpleName() {
		return repositorySimpleName;
	}

	public String strRepositorySimpleName() {
		return repositorySimpleName == null ? "" : repositorySimpleName;
	}

	public String jsonRepositorySimpleName() {
		return repositorySimpleName == null ? "" : repositorySimpleName;
	}

	public String nomAffichageRepositorySimpleName() {
		return null;
	}

	public String htmTooltipRepositorySimpleName() {
		return null;
	}

	public String htmRepositorySimpleName() {
		return repositorySimpleName == null ? "" : StringEscapeUtils.escapeHtml4(strRepositorySimpleName());
	}

	//////////////////////////////
	// repositoryImplSimpleName //
	//////////////////////////////

	/**	L'entité « repositoryImplSimpleName »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String repositoryImplSimpleName;
	@JsonIgnore
	public Wrap<String> repositoryImplSimpleNameWrap = new Wrap<String>().p(this).c(String.class).var("repositoryImplSimpleName").o(repositoryImplSimpleName);

	/**	<br/>L'entité « repositoryImplSimpleName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:repositoryImplSimpleName">Trouver l'entité repositoryImplSimpleName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _repositoryImplSimpleName(Wrap<String> c);

	public String getRepositoryImplSimpleName() {
		return repositoryImplSimpleName;
	}

	public void setRepositoryImplSimpleName(String repositoryImplSimpleName) {
		this.repositoryImplSimpleName = repositoryImplSimpleName;
		this.repositoryImplSimpleNameWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters repositoryImplSimpleNameInit() {
		if(!repositoryImplSimpleNameWrap.alreadyInitialized) {
			_repositoryImplSimpleName(repositoryImplSimpleNameWrap);
			if(repositoryImplSimpleName == null)
				setRepositoryImplSimpleName(repositoryImplSimpleNameWrap.o);
		}
		repositoryImplSimpleNameWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrRepositoryImplSimpleName() {
		return repositoryImplSimpleName;
	}

	public String strRepositoryImplSimpleName() {
		return repositoryImplSimpleName == null ? "" : repositoryImplSimpleName;
	}

	public String jsonRepositoryImplSimpleName() {
		return repositoryImplSimpleName == null ? "" : repositoryImplSimpleName;
	}

	public String nomAffichageRepositoryImplSimpleName() {
		return null;
	}

	public String htmTooltipRepositoryImplSimpleName() {
		return null;
	}

	public String htmRepositoryImplSimpleName() {
		return repositoryImplSimpleName == null ? "" : StringEscapeUtils.escapeHtml4(strRepositoryImplSimpleName());
	}

	/////////////
	// pathDir //
	/////////////

	/**	L'entité « pathDir »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pathDir;
	@JsonIgnore
	public Wrap<String> pathDirWrap = new Wrap<String>().p(this).c(String.class).var("pathDir").o(pathDir);

	/**	<br/>L'entité « pathDir »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pathDir">Trouver l'entité pathDir dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pathDir(Wrap<String> c);

	public String getPathDir() {
		return pathDir;
	}

	public void setPathDir(String pathDir) {
		this.pathDir = pathDir;
		this.pathDirWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters pathDirInit() {
		if(!pathDirWrap.alreadyInitialized) {
			_pathDir(pathDirWrap);
			if(pathDir == null)
				setPathDir(pathDirWrap.o);
		}
		pathDirWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPathDir() {
		return pathDir;
	}

	public String strPathDir() {
		return pathDir == null ? "" : pathDir;
	}

	public String jsonPathDir() {
		return pathDir == null ? "" : pathDir;
	}

	public String nomAffichagePathDir() {
		return null;
	}

	public String htmTooltipPathDir() {
		return null;
	}

	public String htmPathDir() {
		return pathDir == null ? "" : StringEscapeUtils.escapeHtml4(strPathDir());
	}

	/////////
	// dir //
	/////////

	/**	L'entité « dir »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected File dir;
	@JsonIgnore
	public Wrap<File> dirWrap = new Wrap<File>().p(this).c(File.class).var("dir").o(dir);

	/**	<br/>L'entité « dir »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dir">Trouver l'entité dir dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _dir(Wrap<File> c);

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
		this.dirWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters dirInit() {
		if(!dirWrap.alreadyInitialized) {
			_dir(dirWrap);
			if(dir == null)
				setDir(dirWrap.o);
		}
		dirWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	////////////////////
	// pathRepository //
	////////////////////

	/**	L'entité « pathRepository »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pathRepository;
	@JsonIgnore
	public Wrap<String> pathRepositoryWrap = new Wrap<String>().p(this).c(String.class).var("pathRepository").o(pathRepository);

	/**	<br/>L'entité « pathRepository »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pathRepository">Trouver l'entité pathRepository dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pathRepository(Wrap<String> c);

	public String getPathRepository() {
		return pathRepository;
	}

	public void setPathRepository(String pathRepository) {
		this.pathRepository = pathRepository;
		this.pathRepositoryWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters pathRepositoryInit() {
		if(!pathRepositoryWrap.alreadyInitialized) {
			_pathRepository(pathRepositoryWrap);
			if(pathRepository == null)
				setPathRepository(pathRepositoryWrap.o);
		}
		pathRepositoryWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPathRepository() {
		return pathRepository;
	}

	public String strPathRepository() {
		return pathRepository == null ? "" : pathRepository;
	}

	public String jsonPathRepository() {
		return pathRepository == null ? "" : pathRepository;
	}

	public String nomAffichagePathRepository() {
		return null;
	}

	public String htmTooltipPathRepository() {
		return null;
	}

	public String htmPathRepository() {
		return pathRepository == null ? "" : StringEscapeUtils.escapeHtml4(strPathRepository());
	}

	////////////////////////
	// pathRepositoryImpl //
	////////////////////////

	/**	L'entité « pathRepositoryImpl »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pathRepositoryImpl;
	@JsonIgnore
	public Wrap<String> pathRepositoryImplWrap = new Wrap<String>().p(this).c(String.class).var("pathRepositoryImpl").o(pathRepositoryImpl);

	/**	<br/>L'entité « pathRepositoryImpl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pathRepositoryImpl">Trouver l'entité pathRepositoryImpl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pathRepositoryImpl(Wrap<String> c);

	public String getPathRepositoryImpl() {
		return pathRepositoryImpl;
	}

	public void setPathRepositoryImpl(String pathRepositoryImpl) {
		this.pathRepositoryImpl = pathRepositoryImpl;
		this.pathRepositoryImplWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters pathRepositoryImplInit() {
		if(!pathRepositoryImplWrap.alreadyInitialized) {
			_pathRepositoryImpl(pathRepositoryImplWrap);
			if(pathRepositoryImpl == null)
				setPathRepositoryImpl(pathRepositoryImplWrap.o);
		}
		pathRepositoryImplWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPathRepositoryImpl() {
		return pathRepositoryImpl;
	}

	public String strPathRepositoryImpl() {
		return pathRepositoryImpl == null ? "" : pathRepositoryImpl;
	}

	public String jsonPathRepositoryImpl() {
		return pathRepositoryImpl == null ? "" : pathRepositoryImpl;
	}

	public String nomAffichagePathRepositoryImpl() {
		return null;
	}

	public String htmTooltipPathRepositoryImpl() {
		return null;
	}

	public String htmPathRepositoryImpl() {
		return pathRepositoryImpl == null ? "" : StringEscapeUtils.escapeHtml4(strPathRepositoryImpl());
	}

	////////////////
	// pathSqlDir //
	////////////////

	/**	L'entité « pathSqlDir »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pathSqlDir;
	@JsonIgnore
	public Wrap<String> pathSqlDirWrap = new Wrap<String>().p(this).c(String.class).var("pathSqlDir").o(pathSqlDir);

	/**	<br/>L'entité « pathSqlDir »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pathSqlDir">Trouver l'entité pathSqlDir dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pathSqlDir(Wrap<String> c);

	public String getPathSqlDir() {
		return pathSqlDir;
	}

	public void setPathSqlDir(String pathSqlDir) {
		this.pathSqlDir = pathSqlDir;
		this.pathSqlDirWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters pathSqlDirInit() {
		if(!pathSqlDirWrap.alreadyInitialized) {
			_pathSqlDir(pathSqlDirWrap);
			if(pathSqlDir == null)
				setPathSqlDir(pathSqlDirWrap.o);
		}
		pathSqlDirWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	public String solrPathSqlDir() {
		return pathSqlDir;
	}

	public String strPathSqlDir() {
		return pathSqlDir == null ? "" : pathSqlDir;
	}

	public String jsonPathSqlDir() {
		return pathSqlDir == null ? "" : pathSqlDir;
	}

	public String nomAffichagePathSqlDir() {
		return null;
	}

	public String htmTooltipPathSqlDir() {
		return null;
	}

	public String htmPathSqlDir() {
		return pathSqlDir == null ? "" : StringEscapeUtils.escapeHtml4(strPathSqlDir());
	}

	////////////////////
	// fileRepository //
	////////////////////

	/**	L'entité « fileRepository »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected File fileRepository;
	@JsonIgnore
	public Wrap<File> fileRepositoryWrap = new Wrap<File>().p(this).c(File.class).var("fileRepository").o(fileRepository);

	/**	<br/>L'entité « fileRepository »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:fileRepository">Trouver l'entité fileRepository dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _fileRepository(Wrap<File> c);

	public File getFileRepository() {
		return fileRepository;
	}

	public void setFileRepository(File fileRepository) {
		this.fileRepository = fileRepository;
		this.fileRepositoryWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters fileRepositoryInit() {
		if(!fileRepositoryWrap.alreadyInitialized) {
			_fileRepository(fileRepositoryWrap);
			if(fileRepository == null)
				setFileRepository(fileRepositoryWrap.o);
		}
		fileRepositoryWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	////////////////////////
	// fileRepositoryImpl //
	////////////////////////

	/**	L'entité « fileRepositoryImpl »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected File fileRepositoryImpl;
	@JsonIgnore
	public Wrap<File> fileRepositoryImplWrap = new Wrap<File>().p(this).c(File.class).var("fileRepositoryImpl").o(fileRepositoryImpl);

	/**	<br/>L'entité « fileRepositoryImpl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:fileRepositoryImpl">Trouver l'entité fileRepositoryImpl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _fileRepositoryImpl(Wrap<File> c);

	public File getFileRepositoryImpl() {
		return fileRepositoryImpl;
	}

	public void setFileRepositoryImpl(File fileRepositoryImpl) {
		this.fileRepositoryImpl = fileRepositoryImpl;
		this.fileRepositoryImplWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters fileRepositoryImplInit() {
		if(!fileRepositoryImplWrap.alreadyInitialized) {
			_fileRepositoryImpl(fileRepositoryImplWrap);
			if(fileRepositoryImpl == null)
				setFileRepositoryImpl(fileRepositoryImplWrap.o);
		}
		fileRepositoryImplWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	/////////////////
	// wRepository //
	/////////////////

	/**	L'entité « wRepository »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRepository;
	@JsonIgnore
	public Wrap<AllWriter> wRepositoryWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wRepository").o(wRepository);

	/**	<br/>L'entité « wRepository »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRepository">Trouver l'entité wRepository dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wRepository(Wrap<AllWriter> c);

	public AllWriter getWRepository() {
		return wRepository;
	}

	public void setWRepository(AllWriter wRepository) {
		this.wRepository = wRepository;
		this.wRepositoryWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters wRepositoryInit() {
		if(!wRepositoryWrap.alreadyInitialized) {
			_wRepository(wRepositoryWrap);
			if(wRepository == null)
				setWRepository(wRepositoryWrap.o);
		}
		if(wRepository != null)
			wRepository.initDeepForClass(siteRequest_);
		wRepositoryWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	/////////////////////
	// wRepositoryImpl //
	/////////////////////

	/**	L'entité « wRepositoryImpl »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRepositoryImpl;
	@JsonIgnore
	public Wrap<AllWriter> wRepositoryImplWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wRepositoryImpl").o(wRepositoryImpl);

	/**	<br/>L'entité « wRepositoryImpl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.RepositoryWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRepositoryImpl">Trouver l'entité wRepositoryImpl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wRepositoryImpl(Wrap<AllWriter> c);

	public AllWriter getWRepositoryImpl() {
		return wRepositoryImpl;
	}

	public void setWRepositoryImpl(AllWriter wRepositoryImpl) {
		this.wRepositoryImpl = wRepositoryImpl;
		this.wRepositoryImplWrap.alreadyInitialized = true;
	}
	protected RepositoryWriters wRepositoryImplInit() {
		if(!wRepositoryImplWrap.alreadyInitialized) {
			_wRepositoryImpl(wRepositoryImplWrap);
			if(wRepositoryImpl == null)
				setWRepositoryImpl(wRepositoryImplWrap.o);
		}
		if(wRepositoryImpl != null)
			wRepositoryImpl.initDeepForClass(siteRequest_);
		wRepositoryImplWrap.alreadyInitialized(true);
		return (RepositoryWriters)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedRepositoryWriters = false;

	public RepositoryWriters initDeepRepositoryWriters(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedRepositoryWriters) {
			alreadyInitializedRepositoryWriters = true;
			initDeepRepositoryWriters();
		}
		return (RepositoryWriters)this;
	}

	public void initDeepRepositoryWriters() {
		initRepositoryWriters();
	}

	public void initRepositoryWriters() {
		siteRequest_Init();
		solrDocumentClassInit();
		searchEntitiesResultsInit();
		projectPathLinuxInit();
		repositoryPackageNameInit();
		persistPackageNameInit();
		classSimpleNameInit();
		persistSimpleNameInit();
		classApiMethodsInit();
		siteContextInit();
		classAbsolutePathInit();
		repositorySimpleNameInit();
		repositoryImplSimpleNameInit();
		pathDirInit();
		dirInit();
		pathRepositoryInit();
		pathRepositoryImplInit();
		pathSqlDirInit();
		fileRepositoryInit();
		fileRepositoryImplInit();
		wRepositoryInit();
		wRepositoryImplInit();
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepRepositoryWriters(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestRepositoryWriters(SiteRequestEnUS siteRequest_) {
		if(wRepository != null)
			wRepository.setSiteRequest_(siteRequest_);
		if(wRepositoryImpl != null)
			wRepositoryImpl.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestRepositoryWriters(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainRepositoryWriters(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainRepositoryWriters(String var) {
		RepositoryWriters oRepositoryWriters = (RepositoryWriters)this;
		switch(var) {
			case "siteRequest_":
				return oRepositoryWriters.siteRequest_;
			case "solrDocumentClass":
				return oRepositoryWriters.solrDocumentClass;
			case "searchEntitiesResults":
				return oRepositoryWriters.searchEntitiesResults;
			case "projectPathLinux":
				return oRepositoryWriters.projectPathLinux;
			case "repositoryPackageName":
				return oRepositoryWriters.repositoryPackageName;
			case "persistPackageName":
				return oRepositoryWriters.persistPackageName;
			case "classSimpleName":
				return oRepositoryWriters.classSimpleName;
			case "persistSimpleName":
				return oRepositoryWriters.persistSimpleName;
			case "classApiMethods":
				return oRepositoryWriters.classApiMethods;
			case "siteContext":
				return oRepositoryWriters.siteContext;
			case "classAbsolutePath":
				return oRepositoryWriters.classAbsolutePath;
			case "repositorySimpleName":
				return oRepositoryWriters.repositorySimpleName;
			case "repositoryImplSimpleName":
				return oRepositoryWriters.repositoryImplSimpleName;
			case "pathDir":
				return oRepositoryWriters.pathDir;
			case "dir":
				return oRepositoryWriters.dir;
			case "pathRepository":
				return oRepositoryWriters.pathRepository;
			case "pathRepositoryImpl":
				return oRepositoryWriters.pathRepositoryImpl;
			case "pathSqlDir":
				return oRepositoryWriters.pathSqlDir;
			case "fileRepository":
				return oRepositoryWriters.fileRepository;
			case "fileRepositoryImpl":
				return oRepositoryWriters.fileRepositoryImpl;
			case "wRepository":
				return oRepositoryWriters.wRepository;
			case "wRepositoryImpl":
				return oRepositoryWriters.wRepositoryImpl;
			default:
				return null;
		}
	}

	///////////////
	// attribute //
	///////////////

	public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeRepositoryWriters(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeRepositoryWriters(String var, Object val) {
		RepositoryWriters oRepositoryWriters = (RepositoryWriters)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineRepositoryWriters(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineRepositoryWriters(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestRepositoryWriters() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof RepositoryWriters) {
			RepositoryWriters original = (RepositoryWriters)o;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof RepositoryWriters))
			return false;
		RepositoryWriters that = (RepositoryWriters)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RepositoryWriters { ");
		sb.append(" }");
		return sb.toString();
	}
}
