package org.southerncoalition.enus.writer; 

import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.southerncoalition.enus.wrap.Wrap;

public class SqlWriters extends SqlWritersGen<Object> {  

	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}
//
//	protected void _solrDocumentClass(Wrap<SolrDocument> c) {
//	}
//
//	protected void _searchEntitiesResults(Wrap<SolrDocumentList> c) {
//	}
//
//	protected void _projectPathLinux(Wrap<String> c) {
//	}
//
//	protected void _repositoryPackageName(Wrap<String> c) {
//	}
//
//	protected void _persistPackageName(Wrap<String> c) {
//	}
//
//	protected void _classSimpleName(Wrap<String> c) {
//	}
//
//	protected void _persistSimpleName(Wrap<String> c) {
//	}
//
//	protected void _classApiMethods(List<String> c) {
//	}
//
//	protected void _siteContext(Wrap<SiteContext> c) {
//		c.o(siteRequest_.getSiteContext_());
//	}
//
//	protected void _classAbsolutePath(Wrap<String> c) {
//		c.o((String)solrDocumentClass.get("classAbsolutePath_stored_string"));
//	}
//
//	protected void _pathSqlDir(Wrap<String> c) {
//		c.o(projectPathLinux + "/src/test/resources/sql");
//	}
//
//	protected void _dirSql(Wrap<File> c) {
//		File o = new File(pathSqlDir);
//		o.mkdirs();
//		c.o(o);
//	}
//
//	protected void _fileRepository(Wrap<File> c) {
//		c.o(new File(pathRepository));
//	}
//
//	protected void _fileRepositoryImpl(Wrap<File> c) {
//		c.o(new File(pathRepositoryImpl));
//	}
//
//	protected void _wRepository(Wrap<AllWriter> c) {
//		c.o(AllWriter.create(siteRequest_, fileRepository, "    "));
//	}
//
//	protected void _wRepositoryImpl(Wrap<AllWriter> c) {
//		c.o(AllWriter.create(siteRequest_, fileRepositoryImpl, "    "));
//	}
//
//	public void writeSqlMigration() {
//
//		SolrQuery searchMigration = new SolrQuery();
//		searchMigration.setQuery("*:*");
//		searchMigration.setRows(1000000);
//		searchMigration.addFilterQuery("classAbsolutePath_indexed_string:" + ClientUtils.escapeQueryChars(classAbsolutePath));
////		searchMigration.addFilterQuery("partIsEntity_indexed_boolean:true");
//		searchMigration.addFilterQuery("sql_indexed_int:[* TO *]");
//		searchMigration.addSort("sql_indexed_int", ORDER.asc);
//		searchMigration.addSort("partNumber_indexed_int", ORDER.asc);
//		QueryResponse searchMigrationResponse = siteContext.getSolrClientComputate().query(searchMigration);
//		SolrDocumentList searchMigrationResults = searchMigrationResponse.getResults();
//		Integer searchMigrationLines = searchMigration.getRows();
//		Long resultIndex;
//		Integer sqlMigration;
//		Boolean sqlCreate;
//		Boolean sqlDrop;
//
//		for(Long i = searchMigrationResults.getStart(); i < searchMigrationResults.getNumFound(); i+=searchMigrationLines) {
//			for(Integer j = 0; j < searchMigrationResults.size(); j++) {
//				resultIndex = i + j;
//				solrDocumentClass = searchMigrationResults.get(j);
//
//				sqlMigration = (Integer)solrDocumentClass.get("sqlMigration_stored_int");
//				sqlCreate = (Boolean)solrDocumentClass.get("sqlCreate_stored_boolean");
//				sqlDrop = (Boolean)solrDocumentClass.get("sqlDrop_stored_boolean");
////				modelProject = (String)solrDocumentClass.get("modelProject_stored_string");
//			}
//			searchMigration.setStart(i.intValue() + searchMigrationLines);
//			searchMigrationResponse = siteContext.getSolrClientComputate().query(searchMigration);
//			searchMigrationResults = searchMigrationResponse.getResults();
//			searchMigrationLines = searchMigration.getRows();
//		}
//	}
//
//	public void writeRepositories() {
//		l("package " + repositoryPackageName + ";");
//		l();
//		l("import java.util.List;");
//		l("import javax.persistence.EntityManager;");
//		l("import org.slf4j.Logger;");
//		l("import org.slf4j.LoggerFactory;");
//		l("import org.springframework.beans.factory.annotation.Autowired;");
//		l("import org.springframework.stereotype.Repository;");
//		l("import org.springframework.transaction.annotation.Transactional;");
////		l("import com.citi.auth.api.repository.AuthenticationMethodRepository;");
////		l("import com.citi.auth.enums.EventTypeENUM;");
////		l("import com.citi.auth.model.AuthenticationMethod;");
//		l("import ", persistPackageName, ".", persistSimpleName, ";");
//		l();
//		l("@Repository");
//		l("@Transactional");
//		lRepository("public interface " + repositorySimpleName + " {");
//		lRepositoryImpl("public class " + repositoryImplSimpleName + " implements ", repositorySimpleName, " {");
//
//		lRepositoryImpl();
//		tlRepositoryImpl(1, "private static final Logger LOGGER = LoggerFactory .getLogger( ", repositoryImplSimpleName, ".class );");
//		lRepositoryImpl();
//		tlRepositoryImpl(1, "@Autowired");
//		tlRepositoryImpl(1, "private EntityManager entityManager;");
//		if(classApiMethods != null) {
//			for(String classApiMethod : classApiMethods) {
//				String paramName = StringUtils.uncapitalize(persistSimpleName);
//	
//				l();
//				String classApiKeywordMethod = (String)solrDocumentClass.get("classApiKeyword" + classApiMethod + "_stored_string");
//				if(StringUtils.contains(classApiKeywordMethod, "-")) {
//					String[] varParts = StringUtils.split(classApiKeywordMethod, "-");
//					classApiKeywordMethod = "";
//					for(String varPart : varParts) {
//						classApiKeywordMethod += StringUtils.capitalize(varPart);
//					}
//				}
//	
//				tlRepositoryImpl(1, "@Override");
//	
//				t(1, "public ");
//				if(StringUtils.contains(classApiMethod, "Search"))
//					s("List<");
//				s(persistSimpleName);
//				if(StringUtils.contains(classApiMethod, "Search"))
//					s(">");
//				s(" ");
//	
//				s(StringUtils.uncapitalize(classApiKeywordMethod));
//	//				if(StringUtils.contains(classApiMethod, "POST"))
//	//					s("persist");
//	//				else if(StringUtils.contains(classApiMethod, "PATCH") || StringUtils.contains(classApiMethod, "PUT"))
//	//					s("merge");
//	//				else if(StringUtils.contains(classApiMethod, "GET"))
//	//					s("find");
//	//				else if(StringUtils.contains(classApiMethod, "Search"))
//	//					s("createNamedQuery");
//	
//				s("( ");
//				AllWriter javaParams = AllWriter.create(siteRequest_, "    ");
//				AllWriter sqlParams = AllWriter.create(siteRequest_, "    ");
//				AllWriter log1 = AllWriter.create(siteRequest_, "    ");
//				AllWriter log2 = AllWriter.create(siteRequest_, "    ");
//
//				if(StringUtils.contains(classApiMethod, "Search") || StringUtils.contains(classApiMethod, "GET") || StringUtils.contains(classApiMethod, "PUT") || StringUtils.contains(classApiMethod, "PATCH") || StringUtils.contains(classApiMethod, "DELETE")) {
//					for(int i = 0; i < searchEntitiesResults.size(); i++) {
//						SolrDocument entitySolrDocument = searchEntitiesResults.get(i);
//						List<String> entityKeywords = (List<String>)entitySolrDocument.get("entityKeywords_stored_strings");
//						String entitySimpleNameComplete = (String)entitySolrDocument.get("entitySimpleNameComplete_enUS_stored_string");
//						String entityVar = (String)entitySolrDocument.get("entityVar_enUS_stored_string");
//						String sqlColumnName = (String)entitySolrDocument.get("sqlColumnName_stored_string");
//						sqlColumnName = sqlColumnName == null ? entityVar : sqlColumnName;
//	
//						if(entityKeywords == null)
//							entityKeywords = new ArrayList<>();
//	
//						if(entityKeywords.contains(classApiMethod + ".request")) {
//							if(!javaParams.getEmpty()) {
//								javaParams.s(", ");
//								log1.s(", ");
//							}
//							javaParams.s(entitySimpleNameComplete, " ", entityVar);
//							sqlParams.tl(4, ".setParameter( \"", sqlColumnName, "\", ", entityVar, " )");
//							log1.s(entityVar, ": {}");
//							log2.s(", ", entityVar);
//						}
//	//						if(!"Model".equals(identifier) && !"Persist".equals(identifier) && entityOptionsVar.size() == 0) {
//	//							if(StringUtils.endsWith(identifier, "Request")) {
//	//								if(!wNamedQuery.getEmpty())
//	//									wNamedQuery.s(" AND");
//	//								wNamedQuery.s(" ", sqlColumnName, "=?");
//	//							}
//	//			
//	//							if(StringUtils.endsWith(identifier, "Response")) {
//	//								if(!wNamedQuery.getEmpty())
//	//									wNamedQuery.s(",");
//	//								wNamedQuery.s(" ", sqlColumnName);
//	//							}
//	//						}
//					}
//					s(javaParams);
//				}
//				else {
//					s(persistSimpleName, " ", paramName);
//				}
//				s(" )");
//	
//				lRepository(";");
//				lRepositoryImpl(" {");
//	
//				if(StringUtils.contains(classApiMethod, "POST")) {
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before persist ", classSimpleName, " {}\", ", paramName, " );");
//					tRepositoryImpl(2, "entityManager.");
//					sRepositoryImpl("persist");
//					lRepositoryImpl("( ", paramName, " );");
//					tlRepositoryImpl(2, "LOGGER.debug( \"After persist ", classSimpleName, " {}\", ", paramName, " );");
//					tlRepositoryImpl(2, "return ", paramName, ";");
//				}
//				else if(StringUtils.contains(classApiMethod, "PATCH")) {
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before PATCH ", classSimpleName, " ", log1, "\"", log2, " );");
//					tRepositoryImpl(2, "return entityManager.");
//					sRepositoryImpl("createNamedQuery");
//					lRepositoryImpl("( ", persistSimpleName, ".QUERY_NAME_", classApiKeywordMethod, ", ", persistSimpleName, ".class )");
//					sRepositoryImpl(sqlParams);
//					tlRepositoryImpl(4, ".getResultList();");
//				}
//				else if( StringUtils.contains(classApiMethod, "PUT")) {
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before GET ", classSimpleName, " ", log1, "\"", log2, " );");
//					tRepositoryImpl(2, "return entityManager.");
//					sRepositoryImpl("createNamedQuery");
//					lRepositoryImpl("( ", persistSimpleName, ".QUERY_NAME_", classApiKeywordMethod, ", ", persistSimpleName, ".class )");
//					sRepositoryImpl(sqlParams);
//					tlRepositoryImpl(4, ".getSingleResult();");
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before persist ", classSimpleName, " {}\", ", paramName, " );");
//					tRepositoryImpl(2, "entityManager.");
//					sRepositoryImpl("persist");
//					lRepositoryImpl("( ", paramName, " );");
//					tlRepositoryImpl(2, "LOGGER.debug( \"After persist ", classSimpleName, " {}\", ", paramName, " );");
//				}
//				else if(StringUtils.contains(classApiMethod, "GET")) {
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before GET ", classSimpleName, " ", log1, "\"", log2, " );");
//					tRepositoryImpl(2, "return entityManager.");
//					sRepositoryImpl("createNamedQuery");
//					lRepositoryImpl("( ", persistSimpleName, ".QUERY_NAME_", classApiKeywordMethod, ", ", persistSimpleName, ".class )");
//					sRepositoryImpl(sqlParams);
//					tlRepositoryImpl(4, ".getSingleResult();");
//				}
//				else if(StringUtils.contains(classApiMethod, "Search")) {
//					tlRepositoryImpl(2, "LOGGER.debug( \"Before search ", classSimpleName, " ", log1, "\"", log2, " );");
//					tRepositoryImpl(2, "return entityManager.");
//					sRepositoryImpl("createNamedQuery");
//					lRepositoryImpl("( ", persistSimpleName, ".QUERY_NAME_", classApiKeywordMethod, ", ", persistSimpleName, ".class )");
//					sRepositoryImpl(sqlParams);
//					tlRepositoryImpl(4, ".getResultList();");
//				}
//				tlRepositoryImpl(1, "}");
//			}
//		}
//
//		l("}");
//		flushClose();
//
//	}
//
//	// Class //
//
//	public AllWriter tRepository(int nombreTabulations, Object...objets) {
//		return wRepository.t(nombreTabulations, objets);
//	}
//	public AllWriter tlRepository(int nombreTabulations, Object...objets) {
//		return wRepository.tl(nombreTabulations, objets);
//	}
//
//	public AllWriter lRepository(Object...objets) {
//		return wRepository.l(objets);
//	}
//
//	public AllWriter sRepository(Object...objets) { 
//		return wRepository.s(objets);
//	}
//
//	// NamedQueries //
//
//	public AllWriter tRepositoryImpl(int nombreTabulations, Object...objets) {
//		return wRepositoryImpl.t(nombreTabulations, objets);
//	}
//	public AllWriter tlRepositoryImpl(int nombreTabulations, Object...objets) {
//		return wRepositoryImpl.tl(nombreTabulations, objets);
//	}
//
//	public AllWriter lRepositoryImpl(Object...objets) {
//		return wRepositoryImpl.l(objets);
//	}
//
//	public AllWriter sRepositoryImpl(Object...objets) { 
//		return wRepositoryImpl.s(objets);
//	}
//
//	public void t(int nombreTabulations, Object...objets) {
//		wRepository.t(nombreTabulations, objets);
//		wRepositoryImpl.t(nombreTabulations, objets);
//	}
//	public void tl(int nombreTabulations, Object...objets) {
//		wRepository.tl(nombreTabulations, objets);
//		wRepositoryImpl.tl(nombreTabulations, objets);
//	}
//
//	public void l(Object...objets) {
//		wRepository.l(objets);
//		wRepositoryImpl.l(objets);
//	}
//
//	public void s(Object...objets) { 
//		wRepository.s(objets);
//		wRepositoryImpl.s(objets);
//	}
//
//	public void flushClose() throws IOException {
//		wRepository.flushClose();
//		wRepositoryImpl.flushClose();
//	}
}
