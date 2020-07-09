package org.southerncoalition.enus.writer;

import java.util.Arrays;
import org.southerncoalition.enus.request.api.ApiRequest;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.southerncoalition.enus.writer.AllWriters;
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
import java.lang.Object;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ClassWritersGen<DEV> extends Object {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ClassWriters.class);

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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Trouver l'entité siteRequest_ dans Solr</a>
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
	protected ClassWriters siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	////////////
	// wClass //
	////////////

	/**	L'entité « wClass »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wClass;
	@JsonIgnore
	public Wrap<AllWriter> wClassWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wClass").o(wClass);

	/**	<br/>L'entité « wClass »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wClass">Trouver l'entité wClass dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wClass(Wrap<AllWriter> c);

	public AllWriter getWClass() {
		return wClass;
	}

	public void setWClass(AllWriter wClass) {
		this.wClass = wClass;
		this.wClassWrap.alreadyInitialized = true;
	}
	protected ClassWriters wClassInit() {
		if(!wClassWrap.alreadyInitialized) {
			_wClass(wClassWrap);
			if(wClass == null)
				setWClass(wClassWrap.o);
		}
		if(wClass != null)
			wClass.initDeepForClass(siteRequest_);
		wClassWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	/////////////
	// wFields //
	/////////////

	/**	L'entité « wFields »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wFields;
	@JsonIgnore
	public Wrap<AllWriter> wFieldsWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wFields").o(wFields);

	/**	<br/>L'entité « wFields »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wFields">Trouver l'entité wFields dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wFields(Wrap<AllWriter> c);

	public AllWriter getWFields() {
		return wFields;
	}

	public void setWFields(AllWriter wFields) {
		this.wFields = wFields;
		this.wFieldsWrap.alreadyInitialized = true;
	}
	protected ClassWriters wFieldsInit() {
		if(!wFieldsWrap.alreadyInitialized) {
			_wFields(wFieldsWrap);
			if(wFields == null)
				setWFields(wFieldsWrap.o);
		}
		if(wFields != null)
			wFields.initDeepForClass(siteRequest_);
		wFieldsWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	/////////////////////
	// wGettersSetters //
	/////////////////////

	/**	L'entité « wGettersSetters »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wGettersSetters;
	@JsonIgnore
	public Wrap<AllWriter> wGettersSettersWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wGettersSetters").o(wGettersSetters);

	/**	<br/>L'entité « wGettersSetters »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wGettersSetters">Trouver l'entité wGettersSetters dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wGettersSetters(Wrap<AllWriter> c);

	public AllWriter getWGettersSetters() {
		return wGettersSetters;
	}

	public void setWGettersSetters(AllWriter wGettersSetters) {
		this.wGettersSetters = wGettersSetters;
		this.wGettersSettersWrap.alreadyInitialized = true;
	}
	protected ClassWriters wGettersSettersInit() {
		if(!wGettersSettersWrap.alreadyInitialized) {
			_wGettersSetters(wGettersSettersWrap);
			if(wGettersSetters == null)
				setWGettersSetters(wGettersSettersWrap.o);
		}
		if(wGettersSetters != null)
			wGettersSetters.initDeepForClass(siteRequest_);
		wGettersSettersWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	///////////////
	// wHashCode //
	///////////////

	/**	L'entité « wHashCode »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wHashCode;
	@JsonIgnore
	public Wrap<AllWriter> wHashCodeWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wHashCode").o(wHashCode);

	/**	<br/>L'entité « wHashCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wHashCode">Trouver l'entité wHashCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wHashCode(Wrap<AllWriter> c);

	public AllWriter getWHashCode() {
		return wHashCode;
	}

	public void setWHashCode(AllWriter wHashCode) {
		this.wHashCode = wHashCode;
		this.wHashCodeWrap.alreadyInitialized = true;
	}
	protected ClassWriters wHashCodeInit() {
		if(!wHashCodeWrap.alreadyInitialized) {
			_wHashCode(wHashCodeWrap);
			if(wHashCode == null)
				setWHashCode(wHashCodeWrap.o);
		}
		if(wHashCode != null)
			wHashCode.initDeepForClass(siteRequest_);
		wHashCodeWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	///////////////
	// wToString //
	///////////////

	/**	L'entité « wToString »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wToString;
	@JsonIgnore
	public Wrap<AllWriter> wToStringWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wToString").o(wToString);

	/**	<br/>L'entité « wToString »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wToString">Trouver l'entité wToString dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wToString(Wrap<AllWriter> c);

	public AllWriter getWToString() {
		return wToString;
	}

	public void setWToString(AllWriter wToString) {
		this.wToString = wToString;
		this.wToStringWrap.alreadyInitialized = true;
	}
	protected ClassWriters wToStringInit() {
		if(!wToStringWrap.alreadyInitialized) {
			_wToString(wToStringWrap);
			if(wToString == null)
				setWToString(wToStringWrap.o);
		}
		if(wToString != null)
			wToString.initDeepForClass(siteRequest_);
		wToStringWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	/////////////
	// wEquals //
	/////////////

	/**	L'entité « wEquals »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wEquals;
	@JsonIgnore
	public Wrap<AllWriter> wEqualsWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wEquals").o(wEquals);

	/**	<br/>L'entité « wEquals »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wEquals">Trouver l'entité wEquals dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wEquals(Wrap<AllWriter> c);

	public AllWriter getWEquals() {
		return wEquals;
	}

	public void setWEquals(AllWriter wEquals) {
		this.wEquals = wEquals;
		this.wEqualsWrap.alreadyInitialized = true;
	}
	protected ClassWriters wEqualsInit() {
		if(!wEqualsWrap.alreadyInitialized) {
			_wEquals(wEqualsWrap);
			if(wEquals == null)
				setWEquals(wEqualsWrap.o);
		}
		if(wEquals != null)
			wEquals.initDeepForClass(siteRequest_);
		wEqualsWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	//////////////
	// wImports //
	//////////////

	/**	L'entité « wImports »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wImports;
	@JsonIgnore
	public Wrap<AllWriter> wImportsWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wImports").o(wImports);

	/**	<br/>L'entité « wImports »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wImports">Trouver l'entité wImports dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wImports(Wrap<AllWriter> c);

	public AllWriter getWImports() {
		return wImports;
	}

	public void setWImports(AllWriter wImports) {
		this.wImports = wImports;
		this.wImportsWrap.alreadyInitialized = true;
	}
	protected ClassWriters wImportsInit() {
		if(!wImportsWrap.alreadyInitialized) {
			_wImports(wImportsWrap);
			if(wImports == null)
				setWImports(wImportsWrap.o);
		}
		if(wImports != null)
			wImports.initDeepForClass(siteRequest_);
		wImportsWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	/////////////////
	// wNamedQuery //
	/////////////////

	/**	L'entité « wNamedQuery »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wNamedQuery;
	@JsonIgnore
	public Wrap<AllWriter> wNamedQueryWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wNamedQuery").o(wNamedQuery);

	/**	<br/>L'entité « wNamedQuery »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wNamedQuery">Trouver l'entité wNamedQuery dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wNamedQuery(Wrap<AllWriter> c);

	public AllWriter getWNamedQuery() {
		return wNamedQuery;
	}

	public void setWNamedQuery(AllWriter wNamedQuery) {
		this.wNamedQuery = wNamedQuery;
		this.wNamedQueryWrap.alreadyInitialized = true;
	}
	protected ClassWriters wNamedQueryInit() {
		if(!wNamedQueryWrap.alreadyInitialized) {
			_wNamedQuery(wNamedQueryWrap);
			if(wNamedQuery == null)
				setWNamedQuery(wNamedQueryWrap.o);
		}
		if(wNamedQuery != null)
			wNamedQuery.initDeepForClass(siteRequest_);
		wNamedQueryWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	////////////
	// wIndex //
	////////////

	/**	L'entité « wIndex »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wIndex;
	@JsonIgnore
	public Wrap<AllWriter> wIndexWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wIndex").o(wIndex);

	/**	<br/>L'entité « wIndex »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wIndex">Trouver l'entité wIndex dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wIndex(Wrap<AllWriter> c);

	public AllWriter getWIndex() {
		return wIndex;
	}

	public void setWIndex(AllWriter wIndex) {
		this.wIndex = wIndex;
		this.wIndexWrap.alreadyInitialized = true;
	}
	protected ClassWriters wIndexInit() {
		if(!wIndexWrap.alreadyInitialized) {
			_wIndex(wIndexWrap);
			if(wIndex == null)
				setWIndex(wIndexWrap.o);
		}
		if(wIndex != null)
			wIndex.initDeepForClass(siteRequest_);
		wIndexWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	////////////
	// wStore //
	////////////

	/**	L'entité « wStore »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wStore;
	@JsonIgnore
	public Wrap<AllWriter> wStoreWrap = new Wrap<AllWriter>().p(this).c(AllWriter.class).var("wStore").o(wStore);

	/**	<br/>L'entité « wStore »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wStore">Trouver l'entité wStore dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wStore(Wrap<AllWriter> c);

	public AllWriter getWStore() {
		return wStore;
	}

	public void setWStore(AllWriter wStore) {
		this.wStore = wStore;
		this.wStoreWrap.alreadyInitialized = true;
	}
	protected ClassWriters wStoreInit() {
		if(!wStoreWrap.alreadyInitialized) {
			_wStore(wStoreWrap);
			if(wStore == null)
				setWStore(wStoreWrap.o);
		}
		if(wStore != null)
			wStore.initDeepForClass(siteRequest_);
		wStoreWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	////////////////
	// writersApi //
	////////////////

	/**	L'entité « writersApi »
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected AllWriters writersApi;
	@JsonIgnore
	public Wrap<AllWriters> writersApiWrap = new Wrap<AllWriters>().p(this).c(AllWriters.class).var("writersApi").o(writersApi);

	/**	<br/>L'entité « writersApi »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.southerncoalition.enus.writer.ClassWriters&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:writersApi">Trouver l'entité writersApi dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _writersApi(Wrap<AllWriters> c);

	public AllWriters getWritersApi() {
		return writersApi;
	}

	public void setWritersApi(AllWriters writersApi) {
		this.writersApi = writersApi;
		this.writersApiWrap.alreadyInitialized = true;
	}
	protected ClassWriters writersApiInit() {
		if(!writersApiWrap.alreadyInitialized) {
			_writersApi(writersApiWrap);
			if(writersApi == null)
				setWritersApi(writersApiWrap.o);
		}
		if(writersApi != null)
			writersApi.initDeepForClass(siteRequest_);
		writersApiWrap.alreadyInitialized(true);
		return (ClassWriters)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedClassWriters = false;

	public ClassWriters initDeepClassWriters(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedClassWriters) {
			alreadyInitializedClassWriters = true;
			initDeepClassWriters();
		}
		return (ClassWriters)this;
	}

	public void initDeepClassWriters() {
		initClassWriters();
	}

	public void initClassWriters() {
		siteRequest_Init();
		wClassInit();
		wFieldsInit();
		wGettersSettersInit();
		wHashCodeInit();
		wToStringInit();
		wEqualsInit();
		wImportsInit();
		wNamedQueryInit();
		wIndexInit();
		wStoreInit();
		writersApiInit();
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepClassWriters(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestClassWriters(SiteRequestEnUS siteRequest_) {
		if(wClass != null)
			wClass.setSiteRequest_(siteRequest_);
		if(wFields != null)
			wFields.setSiteRequest_(siteRequest_);
		if(wGettersSetters != null)
			wGettersSetters.setSiteRequest_(siteRequest_);
		if(wHashCode != null)
			wHashCode.setSiteRequest_(siteRequest_);
		if(wToString != null)
			wToString.setSiteRequest_(siteRequest_);
		if(wEquals != null)
			wEquals.setSiteRequest_(siteRequest_);
		if(wImports != null)
			wImports.setSiteRequest_(siteRequest_);
		if(wNamedQuery != null)
			wNamedQuery.setSiteRequest_(siteRequest_);
		if(wIndex != null)
			wIndex.setSiteRequest_(siteRequest_);
		if(wStore != null)
			wStore.setSiteRequest_(siteRequest_);
		if(writersApi != null)
			writersApi.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestClassWriters(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainClassWriters(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainClassWriters(String var) {
		ClassWriters oClassWriters = (ClassWriters)this;
		switch(var) {
			case "siteRequest_":
				return oClassWriters.siteRequest_;
			case "wClass":
				return oClassWriters.wClass;
			case "wFields":
				return oClassWriters.wFields;
			case "wGettersSetters":
				return oClassWriters.wGettersSetters;
			case "wHashCode":
				return oClassWriters.wHashCode;
			case "wToString":
				return oClassWriters.wToString;
			case "wEquals":
				return oClassWriters.wEquals;
			case "wImports":
				return oClassWriters.wImports;
			case "wNamedQuery":
				return oClassWriters.wNamedQuery;
			case "wIndex":
				return oClassWriters.wIndex;
			case "wStore":
				return oClassWriters.wStore;
			case "writersApi":
				return oClassWriters.writersApi;
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
				o = attributeClassWriters(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeClassWriters(String var, Object val) {
		ClassWriters oClassWriters = (ClassWriters)this;
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
					o = defineClassWriters(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineClassWriters(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestClassWriters() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ClassWriters) {
			ClassWriters original = (ClassWriters)o;
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
		if(!(o instanceof ClassWriters))
			return false;
		ClassWriters that = (ClassWriters)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClassWriters { ");
		sb.append(" }");
		return sb.toString();
	}
}
