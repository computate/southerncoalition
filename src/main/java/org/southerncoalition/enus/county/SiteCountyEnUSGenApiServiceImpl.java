package org.southerncoalition.enus.county;

import org.southerncoalition.enus.state.SiteStateEnUSGenApiServiceImpl;
import org.southerncoalition.enus.state.SiteState;
import org.southerncoalition.enus.reportcard.ReportCardEnUSGenApiServiceImpl;
import org.southerncoalition.enus.reportcard.ReportCard;
import org.southerncoalition.enus.config.SiteConfig;
import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.southerncoalition.enus.context.SiteContextEnUS;
import org.southerncoalition.enus.user.SiteUser;
import org.southerncoalition.enus.request.api.ApiRequest;
import org.southerncoalition.enus.search.SearchResult;
import io.vertx.core.WorkerExecutor;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailMessage;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrDocument;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import io.vertx.ext.web.api.validation.ValidationException;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.CaseInsensitiveHeaders;
import io.vertx.core.AsyncResult;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.core.CompositeFuture;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import org.apache.http.NameValuePair;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.auth.oauth2.KeycloakHelper;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.time.ZonedDateTime;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.southerncoalition.enus.user.SiteUserEnUSApiServiceImpl;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.writer.AllWriter;


/**
 * Translate: false
 **/
public class SiteCountyEnUSGenApiServiceImpl implements SiteCountyEnUSGenApiService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteCountyEnUSGenApiServiceImpl.class);

	protected static final String SERVICE_ADDRESS = "SiteCountyEnUSApiServiceImpl";

	protected SiteContextEnUS siteContext;

	public SiteCountyEnUSGenApiServiceImpl(SiteContextEnUS siteContext) {
		this.siteContext = siteContext;
	}

	// PUTImport //

	@Override
	public void putimportSiteCounty(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/county/import");
		siteRequest.setRequestMethod("PUTImport");
		try {
			LOGGER.info(String.format("putimportSiteCounty started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						putimportSiteCountyResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											ApiRequest apiRequest = new ApiRequest();
											JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
											apiRequest.setRows(jsonArray.size());
											apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
											apiRequest.setNumPATCH(0L);
											apiRequest.initDeepApiRequest(siteRequest);
											siteRequest.setApiRequest_(apiRequest);
											siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
											varsSiteCounty(siteRequest, d -> {
												if(d.succeeded()) {
													listPUTImportSiteCounty(apiRequest, siteRequest, e -> {
														if(e.succeeded()) {
															putimportSiteCountyResponse(siteRequest, f -> {
																if(e.succeeded()) {
																	LOGGER.info(String.format("putimportSiteCounty succeeded. "));
																	blockingCodeHandler.handle(Future.succeededFuture(e.result()));
																} else {
																	LOGGER.error(String.format("putimportSiteCounty failed. ", f.cause()));
																	errorSiteCounty(siteRequest, null, f);
																}
															});
														} else {
															LOGGER.error(String.format("putimportSiteCounty failed. ", e.cause()));
															errorSiteCounty(siteRequest, null, e);
														}
													});
												} else {
													LOGGER.error(String.format("putimportSiteCounty failed. ", d.cause()));
													errorSiteCounty(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putimportSiteCounty failed. ", ex));
											errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putimportSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putimportSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putimportSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTImportSiteCounty(ApiRequest apiRequest, SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				JsonObject json = (JsonObject)obj;

				json.put("inheritPk", json.getValue("pk"));

				json.put("created", json.getValue("created"));

				SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), json);
				siteRequest2.setApiRequest_(apiRequest);
				siteRequest2.setRequestVars(siteRequest.getRequestVars());

				SearchList<SiteCounty> searchList = new SearchList<SiteCounty>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteCounty.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("inheritPk_indexed_long:" + json.getString("pk"));
				searchList.initDeepForClass(siteRequest2);

				if(searchList.size() == 1) {
					SiteCounty o = searchList.getList().stream().findFirst().orElse(null);
					JsonObject json2 = new JsonObject();
					for(String f : json.fieldNames()) {
						json2.put("set" + StringUtils.capitalize(f), json.getValue(f));
					}
					if(o != null) {
						for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
							if(!json.fieldNames().contains(f))
								json2.putNull("set" + StringUtils.capitalize(f));
						}
						siteRequest2.setJsonObject(json2);
						futures.add(
							patchSiteCountyFuture(o, true, a -> {
								if(a.succeeded()) {
								} else {
									LOGGER.error(String.format("listPUTImportSiteCounty failed. ", a.cause()));
									errorSiteCounty(siteRequest2, eventHandler, a);
								}
							})
						);
					}
				} else {
					futures.add(
						postSiteCountyFuture(siteRequest2, true, a -> {
							if(a.succeeded()) {
							} else {
								LOGGER.error(String.format("listPUTImportSiteCounty failed. ", a.cause()));
								errorSiteCounty(siteRequest2, eventHandler, a);
							}
						})
					);
				}
			});
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
					response200PUTImportSiteCounty(siteRequest, eventHandler);
				} else {
					LOGGER.error(String.format("listPUTImportSiteCounty failed. ", a.cause()));
					errorSiteCounty(apiRequest.getSiteRequest_(), eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("listPUTImportSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}

	public void putimportSiteCountyResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTImportSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putimportSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putimportSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTImportSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTImportSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PUTMerge //

	@Override
	public void putmergeSiteCounty(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/county/merge");
		siteRequest.setRequestMethod("PUTMerge");
		try {
			LOGGER.info(String.format("putmergeSiteCounty started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						putmergeSiteCountyResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											ApiRequest apiRequest = new ApiRequest();
											JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
											apiRequest.setRows(jsonArray.size());
											apiRequest.setNumFound(new Integer(jsonArray.size()).longValue());
											apiRequest.setNumPATCH(0L);
											apiRequest.initDeepApiRequest(siteRequest);
											siteRequest.setApiRequest_(apiRequest);
											siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
											varsSiteCounty(siteRequest, d -> {
												if(d.succeeded()) {
													listPUTMergeSiteCounty(apiRequest, siteRequest, e -> {
														if(e.succeeded()) {
															putmergeSiteCountyResponse(siteRequest, f -> {
																if(e.succeeded()) {
																	LOGGER.info(String.format("putmergeSiteCounty succeeded. "));
																	blockingCodeHandler.handle(Future.succeededFuture(e.result()));
																} else {
																	LOGGER.error(String.format("putmergeSiteCounty failed. ", f.cause()));
																	errorSiteCounty(siteRequest, null, f);
																}
															});
														} else {
															LOGGER.error(String.format("putmergeSiteCounty failed. ", e.cause()));
															errorSiteCounty(siteRequest, null, e);
														}
													});
												} else {
													LOGGER.error(String.format("putmergeSiteCounty failed. ", d.cause()));
													errorSiteCounty(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putmergeSiteCounty failed. ", ex));
											errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putmergeSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putmergeSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putmergeSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTMergeSiteCounty(ApiRequest apiRequest, SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				JsonObject json = (JsonObject)obj;

				json.put("inheritPk", json.getValue("pk"));

				SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), json);
				siteRequest2.setApiRequest_(apiRequest);
				siteRequest2.setRequestVars(siteRequest.getRequestVars());

				SearchList<SiteCounty> searchList = new SearchList<SiteCounty>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteCounty.class);
				searchList.addFilterQuery("deleted_indexed_boolean:false");
				searchList.addFilterQuery("archived_indexed_boolean:false");
				searchList.addFilterQuery("pk_indexed_long:" + json.getString("pk"));
				searchList.initDeepForClass(siteRequest2);

				if(searchList.size() == 1) {
					SiteCounty o = searchList.getList().stream().findFirst().orElse(null);
					JsonObject json2 = new JsonObject();
					for(String f : json.fieldNames()) {
						json2.put("set" + StringUtils.capitalize(f), json.getValue(f));
					}
					if(o != null) {
						for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
							if(!json.fieldNames().contains(f))
								json2.putNull("set" + StringUtils.capitalize(f));
						}
						siteRequest2.setJsonObject(json2);
						futures.add(
							patchSiteCountyFuture(o, false, a -> {
								if(a.succeeded()) {
								} else {
									LOGGER.error(String.format("listPUTMergeSiteCounty failed. ", a.cause()));
									errorSiteCounty(siteRequest2, eventHandler, a);
								}
							})
						);
					}
				} else {
					futures.add(
						postSiteCountyFuture(siteRequest2, false, a -> {
							if(a.succeeded()) {
							} else {
								LOGGER.error(String.format("listPUTMergeSiteCounty failed. ", a.cause()));
								errorSiteCounty(siteRequest2, eventHandler, a);
							}
						})
					);
				}
			});
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
					response200PUTMergeSiteCounty(siteRequest, eventHandler);
				} else {
					LOGGER.error(String.format("listPUTMergeSiteCounty failed. ", a.cause()));
					errorSiteCounty(apiRequest.getSiteRequest_(), eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("listPUTMergeSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}

	public void putmergeSiteCountyResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTMergeSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putmergeSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putmergeSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTMergeSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTMergeSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PUTCopy //

	@Override
	public void putcopySiteCounty(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/county/copy");
		siteRequest.setRequestMethod("PUTCopy");
		try {
			LOGGER.info(String.format("putcopySiteCounty started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						putcopySiteCountyResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											aSearchSiteCounty(siteRequest, false, true, "/api/county/copy", "PUTCopy", d -> {
												if(d.succeeded()) {
													SearchList<SiteCounty> listSiteCounty = d.result();
													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(listSiteCounty.getRows());
													apiRequest.setNumFound(listSiteCounty.getQueryResponse().getResults().getNumFound());
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest);
													siteRequest.setApiRequest_(apiRequest);
													siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
													try {
														listPUTCopySiteCounty(apiRequest, listSiteCounty, e -> {
															if(e.succeeded()) {
																putcopySiteCountyResponse(siteRequest, f -> {
																	if(f.succeeded()) {
																		LOGGER.info(String.format("putcopySiteCounty succeeded. "));
																		blockingCodeHandler.handle(Future.succeededFuture(f.result()));
																	} else {
																		LOGGER.error(String.format("putcopySiteCounty failed. ", f.cause()));
																		errorSiteCounty(siteRequest, null, f);
																	}
																});
															} else {
																LOGGER.error(String.format("putcopySiteCounty failed. ", e.cause()));
																errorSiteCounty(siteRequest, null, e);
															}
														});
													} catch(Exception ex) {
														LOGGER.error(String.format("putcopySiteCounty failed. ", ex));
														errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
													}
												} else {
													LOGGER.error(String.format("putcopySiteCounty failed. ", d.cause()));
													errorSiteCounty(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("putcopySiteCounty failed. ", ex));
											errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("putcopySiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("putcopySiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("putcopySiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPUTCopySiteCounty(ApiRequest apiRequest, SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		listSiteCounty.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), siteRequest.getJsonObject());
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			o.setSiteRequest_(siteRequest2);
			futures.add(
				putcopySiteCountyFuture(siteRequest2, JsonObject.mapFrom(o), a -> {
					if(a.succeeded()) {
					} else {
						LOGGER.error(String.format("listPUTCopySiteCounty failed. ", a.cause()));
						errorSiteCounty(siteRequest, eventHandler, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listSiteCounty.size());
				if(listSiteCounty.next()) {
					listPUTCopySiteCounty(apiRequest, listSiteCounty, eventHandler);
				} else {
					response200PUTCopySiteCounty(siteRequest, eventHandler);
				}
			} else {
				LOGGER.error(String.format("listPUTCopySiteCounty failed. ", a.cause()));
				errorSiteCounty(listSiteCounty.getSiteRequest_(), eventHandler, a);
			}
		});
	}

	public Future<SiteCounty> putcopySiteCountyFuture(SiteRequestEnUS siteRequest, JsonObject jsonObject, Handler<AsyncResult<SiteCounty>> eventHandler) {
		Promise<SiteCounty> promise = Promise.promise();
		try {

			jsonObject.put("saves", Optional.ofNullable(jsonObject.getJsonArray("saves")).orElse(new JsonArray()));
			JsonObject jsonPatch = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonObject("patch")).orElse(new JsonObject());
			jsonPatch.stream().forEach(o -> {
				jsonObject.put(o.getKey(), o.getValue());
				jsonObject.getJsonArray("saves").add(o.getKey());
			});

			sqlConnectionSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteCounty(siteRequest, b -> {
						if(b.succeeded()) {
							createSiteCounty(siteRequest, c -> {
								if(c.succeeded()) {
									SiteCounty siteCounty = c.result();
									sqlPUTCopySiteCounty(siteCounty, jsonObject, d -> {
										if(d.succeeded()) {
											defineIndexSiteCounty(siteCounty, e -> {
												if(e.succeeded()) {
													ApiRequest apiRequest = siteRequest.getApiRequest_();
													if(apiRequest != null) {
														apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
														if(apiRequest.getNumFound() == 1L) {
															siteCounty.apiRequestSiteCounty();
														}
														siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
													}
													eventHandler.handle(Future.succeededFuture(siteCounty));
													promise.complete(siteCounty);
												} else {
													LOGGER.error(String.format("putcopySiteCountyFuture failed. ", e.cause()));
													eventHandler.handle(Future.failedFuture(e.cause()));
												}
											});
										} else {
											LOGGER.error(String.format("putcopySiteCountyFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("putcopySiteCountyFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("putcopySiteCountyFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("putcopySiteCountyFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("putcopySiteCountyFuture failed. ", e));
			errorSiteCounty(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPUTCopySiteCounty(SiteCounty o, JsonObject jsonObject, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			List<Future> futures = new ArrayList<>();

			if(jsonObject != null) {
				JsonArray entityVars = jsonObject.getJsonArray("saves");
				for(Integer i = 0; i < entityVars.size(); i++) {
					String entityVar = entityVars.getString(i);
					switch(entityVar) {
					case "inheritPk":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "inheritPk", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.inheritPk failed", b.cause())));
							});
						}));
						break;
					case "archived":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "archived", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.archived failed", b.cause())));
							});
						}));
						break;
					case "deleted":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "deleted", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.deleted failed", b.cause())));
							});
						}));
						break;
					case "countyName":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "countyName", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.countyName failed", b.cause())));
							});
						}));
						break;
					case "stateKey":
							{
						Long l = Long.parseLong(jsonObject.getString(entityVar));
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_addA
									, Tuple.of(l, "countyKeys", pk, "stateKey")
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.stateKey failed", b.cause())));
							});
						}));
						}
						break;
					case "reportCardKeys":
						for(Long l : jsonObject.getJsonArray(entityVar).stream().map(a -> Long.parseLong((String)a)).collect(Collectors.toList())) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_addA
										, Tuple.of(l, "countyKey", pk, "reportCardKeys")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
								});
							}));
							if(!pks.contains(l)) {
								pks.add(l);
								classes.add("ReportCard");
							}
						}
						break;
					}
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture());
				} else {
					LOGGER.error(String.format("sqlPUTCopySiteCounty failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPUTCopySiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void putcopySiteCountyResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PUTCopySiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("putcopySiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("putcopySiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PUTCopySiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PUTCopySiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// POST //

	@Override
	public void postSiteCounty(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/county");
		siteRequest.setRequestMethod("POST");
		try {
			LOGGER.info(String.format("postSiteCounty started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						ApiRequest apiRequest = new ApiRequest();
						apiRequest.setRows(1);
						apiRequest.setNumFound(1L);
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
						postSiteCountyFuture(siteRequest, false, c -> {
							if(c.succeeded()) {
								SiteCounty siteCounty = c.result();
								apiRequest.setPk(siteCounty.getPk());
								postSiteCountyResponse(siteCounty, d -> {
										if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("postSiteCounty succeeded. "));
									} else {
										LOGGER.error(String.format("postSiteCounty failed. ", d.cause()));
										errorSiteCounty(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("postSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("postSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("postSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public Future<SiteCounty> postSiteCountyFuture(SiteRequestEnUS siteRequest, Boolean inheritPk, Handler<AsyncResult<SiteCounty>> eventHandler) {
		Promise<SiteCounty> promise = Promise.promise();
		try {
			sqlConnectionSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteCounty(siteRequest, b -> {
						if(b.succeeded()) {
							createSiteCounty(siteRequest, c -> {
								if(c.succeeded()) {
									SiteCounty siteCounty = c.result();
									sqlPOSTSiteCounty(siteCounty, inheritPk, d -> {
										if(d.succeeded()) {
											defineIndexSiteCounty(siteCounty, e -> {
												if(e.succeeded()) {
													ApiRequest apiRequest = siteRequest.getApiRequest_();
													if(apiRequest != null) {
														apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
														siteCounty.apiRequestSiteCounty();
														siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
													}
													eventHandler.handle(Future.succeededFuture(siteCounty));
													promise.complete(siteCounty);
												} else {
													LOGGER.error(String.format("postSiteCountyFuture failed. ", e.cause()));
													eventHandler.handle(Future.failedFuture(e.cause()));
												}
											});
										} else {
											LOGGER.error(String.format("postSiteCountyFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("postSiteCountyFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("postSiteCountyFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("postSiteCountyFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("postSiteCountyFuture failed. ", e));
			errorSiteCounty(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPOSTSiteCounty(SiteCounty o, Boolean inheritPk, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			List<Future> futures = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "sessionId", siteRequest.getSessionId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(siteRequest.getUserId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userId", siteRequest.getUserId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(siteRequest.getUserKey() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userKey", siteRequest.getUserKey().toString())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case "inheritPk":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "inheritPk", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.inheritPk failed", b.cause())));
							});
						}));
						break;
					case "archived":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "archived", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.archived failed", b.cause())));
							});
						}));
						break;
					case "deleted":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "deleted", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.deleted failed", b.cause())));
							});
						}));
						break;
					case "countyName":
						futures.add(Future.future(a -> {
							tx.preparedQuery(SiteContextEnUS.SQL_setD
									, Tuple.of(pk, "countyName", Optional.ofNullable(jsonObject.getValue(entityVar)).map(s -> s.toString()).orElse(null))
									, b
							-> {
								if(b.succeeded())
									a.handle(Future.succeededFuture());
								else
									a.handle(Future.failedFuture(new Exception("value SiteCounty.countyName failed", b.cause())));
							});
						}));
						break;
					case "stateKey":
						{
							Long l = Long.parseLong(jsonObject.getString(entityVar));
							if(l != null) {
								SearchList<SiteState> searchList = new SearchList<SiteState>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(SiteState.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKeys", pk, "stateKey")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.stateKey failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("SiteState");
									}
								}
							}
						}
						break;
					case "reportCardKeys":
						for(Long l : jsonObject.getJsonArray(entityVar).stream().map(a -> Long.parseLong((String)a)).collect(Collectors.toList())) {
							if(l != null) {
								SearchList<ReportCard> searchList = new SearchList<ReportCard>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(ReportCard.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("ReportCard");
									}
								}
							}
						}
						break;
					}
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture());
				} else {
					LOGGER.error(String.format("sqlPOSTSiteCounty failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPOSTSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void postSiteCountyResponse(SiteCounty siteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = siteCounty.getSiteRequest_();
		try {
			response200POSTSiteCounty(siteCounty, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("postSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("postSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200POSTSiteCounty(SiteCounty o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200POSTSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PATCH //

	@Override
	public void patchSiteCounty(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, body);
		siteRequest.setRequestUri("/api/county");
		siteRequest.setRequestMethod("PATCH");
		try {
			LOGGER.info(String.format("patchSiteCounty started. "));

			List<String> roles = Arrays.asList("SiteAdmin");
			if(
					!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
					&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
					) {
				eventHandler.handle(Future.succeededFuture(
					new OperationResponse(401, "UNAUTHORIZED", 
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "roles required: " + String.join(", ", roles))
								.encodePrettily()
							), new CaseInsensitiveHeaders()
					)
				));
			} else {

				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						patchSiteCountyResponse(siteRequest, c -> {
							if(c.succeeded()) {
								eventHandler.handle(Future.succeededFuture(c.result()));
								WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
								workerExecutor.executeBlocking(
									blockingCodeHandler -> {
										try {
											aSearchSiteCounty(siteRequest, false, true, "/api/county", "PATCH", d -> {
												if(d.succeeded()) {
													SearchList<SiteCounty> listSiteCounty = d.result();
													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(listSiteCounty.getRows());
													apiRequest.setNumFound(listSiteCounty.getQueryResponse().getResults().getNumFound());
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest);
													siteRequest.setApiRequest_(apiRequest);
													siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
													SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listSiteCounty.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(null);
													Date date = null;
													if(facets != null)
														date = (Date)facets.get("max_modified");
													String dt;
													if(date == null)
														dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of("UTC")).minusNanos(1000));
													else
														dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
													listSiteCounty.addFilterQuery(String.format("modified_indexed_date:[* TO %s]", dt));

													try {
														listPATCHSiteCounty(apiRequest, listSiteCounty, dt, e -> {
															if(e.succeeded()) {
																patchSiteCountyResponse(siteRequest, f -> {
																	if(f.succeeded()) {
																		LOGGER.info(String.format("patchSiteCounty succeeded. "));
																		blockingCodeHandler.handle(Future.succeededFuture(f.result()));
																	} else {
																		LOGGER.error(String.format("patchSiteCounty failed. ", f.cause()));
																		errorSiteCounty(siteRequest, null, f);
																	}
																});
															} else {
																LOGGER.error(String.format("patchSiteCounty failed. ", e.cause()));
																errorSiteCounty(siteRequest, null, e);
															}
														});
													} catch(Exception ex) {
														LOGGER.error(String.format("patchSiteCounty failed. ", ex));
														errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
													}
										} else {
													LOGGER.error(String.format("patchSiteCounty failed. ", d.cause()));
													errorSiteCounty(siteRequest, null, d);
												}
											});
										} catch(Exception ex) {
											LOGGER.error(String.format("patchSiteCounty failed. ", ex));
											errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
										}
									}, resultHandler -> {
									}
								);
							} else {
								LOGGER.error(String.format("patchSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("patchSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("patchSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void listPATCHSiteCounty(ApiRequest apiRequest, SearchList<SiteCounty> listSiteCounty, String dt, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		listSiteCounty.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), siteRequest.getJsonObject());
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			o.setSiteRequest_(siteRequest2);
			futures.add(
				patchSiteCountyFuture(o, false, a -> {
					if(a.succeeded()) {
					} else {
						errorSiteCounty(siteRequest2, eventHandler, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				if(listSiteCounty.next(dt)) {
					listPATCHSiteCounty(apiRequest, listSiteCounty, dt, eventHandler);
				} else {
					response200PATCHSiteCounty(siteRequest, eventHandler);
				}
			} else {
				LOGGER.error(String.format("listPATCHSiteCounty failed. ", a.cause()));
				errorSiteCounty(listSiteCounty.getSiteRequest_(), eventHandler, a);
			}
		});
	}

	public Future<SiteCounty> patchSiteCountyFuture(SiteCounty o, Boolean inheritPk, Handler<AsyncResult<SiteCounty>> eventHandler) {
		Promise<SiteCounty> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			if(apiRequest != null && apiRequest.getNumFound() == 1L) {
				apiRequest.setOriginal(o);
				apiRequest.setPk(o.getPk());
			}
			sqlConnectionSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					sqlTransactionSiteCounty(siteRequest, b -> {
						if(b.succeeded()) {
							sqlPATCHSiteCounty(o, inheritPk, c -> {
								if(c.succeeded()) {
									SiteCounty siteCounty = c.result();
									defineIndexSiteCounty(siteCounty, d -> {
										if(d.succeeded()) {
											if(apiRequest != null) {
												apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
												if(apiRequest.getNumFound() == 1L) {
													siteCounty.apiRequestSiteCounty();
												}
												siteRequest.getVertx().eventBus().publish("websocketSiteCounty", JsonObject.mapFrom(apiRequest).toString());
											}
											eventHandler.handle(Future.succeededFuture(siteCounty));
											promise.complete(siteCounty);
										} else {
											LOGGER.error(String.format("patchSiteCountyFuture failed. ", d.cause()));
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									LOGGER.error(String.format("patchSiteCountyFuture failed. ", c.cause()));
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							LOGGER.error(String.format("patchSiteCountyFuture failed. ", b.cause()));
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					LOGGER.error(String.format("patchSiteCountyFuture failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("patchSiteCountyFuture failed. ", e));
			errorSiteCounty(siteRequest, null, Future.failedFuture(e));
		}
		return promise.future();
	}

	public void sqlPATCHSiteCounty(SiteCounty o, Boolean inheritPk, Handler<AsyncResult<SiteCounty>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			SiteCounty o2 = new SiteCounty();
			List<Future> futures = new ArrayList<>();

			if(o.getUserId() == null && siteRequest.getUserId() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
							, Tuple.of(pk, "userId", siteRequest.getUserId())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}
			if(o.getUserKey() == null && siteRequest.getUserKey() != null) {
				futures.add(Future.future(a -> {
					tx.preparedQuery(SiteContextEnUS.SQL_setD
				, Tuple.of(pk, "userKey", siteRequest.getUserKey().toString())
							, b
					-> {
						if(b.succeeded())
							a.handle(Future.succeededFuture());
						else
							a.handle(Future.failedFuture(b.cause()));
					});
				}));
			}

			for(String methodName : methodNames) {
				switch(methodName) {
					case "setInheritPk":
						if(jsonObject.getString(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "inheritPk")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.inheritPk failed", b.cause())));
								});
							}));
						} else {
							o2.setInheritPk(jsonObject.getString(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "inheritPk", o2.jsonInheritPk())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.inheritPk failed", b.cause())));
								});
							}));
						}
						break;
					case "setArchived":
						if(jsonObject.getBoolean(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "archived")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.archived failed", b.cause())));
								});
							}));
						} else {
							o2.setArchived(jsonObject.getBoolean(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "archived", o2.jsonArchived())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.archived failed", b.cause())));
								});
							}));
						}
						break;
					case "setDeleted":
						if(jsonObject.getBoolean(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "deleted")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.deleted failed", b.cause())));
								});
							}));
						} else {
							o2.setDeleted(jsonObject.getBoolean(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "deleted", o2.jsonDeleted())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.deleted failed", b.cause())));
								});
							}));
						}
						break;
					case "setCountyName":
						if(jsonObject.getString(methodName) == null) {
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_removeD
										, Tuple.of(pk, "countyName")
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.countyName failed", b.cause())));
								});
							}));
						} else {
							o2.setCountyName(jsonObject.getString(methodName));
							futures.add(Future.future(a -> {
								tx.preparedQuery(SiteContextEnUS.SQL_setD
										, Tuple.of(pk, "countyName", o2.jsonCountyName())
										, b
								-> {
									if(b.succeeded())
										a.handle(Future.succeededFuture());
									else
										a.handle(Future.failedFuture(new Exception("value SiteCounty.countyName failed", b.cause())));
								});
							}));
						}
						break;
					case "setStateKey":
						{
							Long l = o2.getStateKey();
							if(l != null && !l.equals(o.getStateKey())) {
								SearchList<SiteState> searchList = new SearchList<SiteState>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(SiteState.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null) {
									o2.setStateKey(jsonObject.getString(methodName));
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKeys", pk, "stateKey")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.stateKey failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("SiteState");
									}
								}
							}
						}
						break;
					case "removeStateKey":
						{
							Long l = o2.getStateKey();
							if(l != null) {
								SearchList<SiteState> searchList = new SearchList<SiteState>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(SiteState.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null && l2.equals(o.getStateKey())) {
									o2.setStateKey(jsonObject.getString(methodName));
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_removeA
												, Tuple.of(l2, "countyKeys", pk, "stateKey")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.stateKey failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("SiteState");
									}
								}
							}
						}
						break;
					case "addReportCardKeys":
						{
							Long l = Long.parseLong(jsonObject.getString(methodName));
							if(l != null) {
								SearchList<ReportCard> searchList = new SearchList<ReportCard>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(ReportCard.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null && !o.getReportCardKeys().contains(l2)) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("ReportCard");
									}
								}
							}
						}
						break;
					case "addAllReportCardKeys":
						JsonArray addAllReportCardKeysValues = jsonObject.getJsonArray(methodName);
						if(addAllReportCardKeysValues != null) {
							for(Integer i = 0; i <  addAllReportCardKeysValues.size(); i++) {
								Long l = Long.parseLong(addAllReportCardKeysValues.getString(i));
								if(l != null) {
									SearchList<ReportCard> searchList = new SearchList<ReportCard>();
									searchList.setQuery("*:*");
									searchList.setStore(true);
									searchList.setC(ReportCard.class);
									searchList.addFilterQuery("deleted_indexed_boolean:false");
									searchList.addFilterQuery("archived_indexed_boolean:false");
									searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
									searchList.initDeepSearchList(siteRequest);
									Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
									if(l2 != null && !o.getReportCardKeys().contains(l2)) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
										if(!pks.contains(l2)) {
											pks.add(l2);
											classes.add("ReportCard");
										}
									}
								}
							}
						}
						break;
					case "setReportCardKeys":
						JsonArray setReportCardKeysValues = jsonObject.getJsonArray(methodName);
						JsonArray setReportCardKeysValues2 = new JsonArray();
						if(setReportCardKeysValues != null) {
							for(Integer i = 0; i <  setReportCardKeysValues.size(); i++) {
								Long l = Long.parseLong(setReportCardKeysValues.getString(i));
								if(l != null) {
									SearchList<ReportCard> searchList = new SearchList<ReportCard>();
									searchList.setQuery("*:*");
									searchList.setStore(true);
									searchList.setC(ReportCard.class);
									searchList.addFilterQuery("deleted_indexed_boolean:false");
									searchList.addFilterQuery("archived_indexed_boolean:false");
									searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
									searchList.initDeepSearchList(siteRequest);
									Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
									if(l2 != null)
										setReportCardKeysValues2.add(l2);
									if(l2 != null && !o.getReportCardKeys().contains(l2)) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_addA
												, Tuple.of(l2, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
										if(!pks.contains(l2)) {
											pks.add(l2);
											classes.add("ReportCard");
										}
									}
								}
							}
						}
						if(o.getReportCardKeys() != null) {
							for(Long l :  o.getReportCardKeys()) {
								if(l != null && (setReportCardKeysValues == null || !setReportCardKeysValues2.contains(l))) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_removeA
												, Tuple.of(l, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
								}
							}
						}
						break;
					case "removeReportCardKeys":
						{
							Long l = Long.parseLong(jsonObject.getString(methodName));
							if(l != null) {
								SearchList<ReportCard> searchList = new SearchList<ReportCard>();
								searchList.setQuery("*:*");
								searchList.setStore(true);
								searchList.setC(ReportCard.class);
								searchList.addFilterQuery("deleted_indexed_boolean:false");
								searchList.addFilterQuery("archived_indexed_boolean:false");
								searchList.addFilterQuery((inheritPk ? "inheritPk" : "pk") + "_indexed_long:" + l);
								searchList.initDeepSearchList(siteRequest);
								Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
								if(l2 != null && o.getReportCardKeys().contains(l2)) {
									futures.add(Future.future(a -> {
										tx.preparedQuery(SiteContextEnUS.SQL_removeA
												, Tuple.of(l2, "countyKey", pk, "reportCardKeys")
												, b
										-> {
											if(b.succeeded())
												a.handle(Future.succeededFuture());
											else
												a.handle(Future.failedFuture(new Exception("value SiteCounty.reportCardKeys failed", b.cause())));
										});
									}));
									if(!pks.contains(l2)) {
										pks.add(l2);
										classes.add("ReportCard");
									}
								}
							}
						}
						break;
				}
			}
			CompositeFuture.all(futures).setHandler( a -> {
				if(a.succeeded()) {
					SiteCounty o3 = new SiteCounty();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					eventHandler.handle(Future.succeededFuture(o3));
				} else {
					LOGGER.error(String.format("sqlPATCHSiteCounty failed. ", a.cause()));
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("sqlPATCHSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void patchSiteCountyResponse(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			response200PATCHSiteCounty(siteRequest, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("patchSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("patchSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200PATCHSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200PATCHSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// GET //

	@Override
	public void getSiteCounty(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/county/{id}");
		siteRequest.setRequestMethod("GET");
		try {
			{
				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteCounty(siteRequest, false, true, "/api/county/{id}", "GET", c -> {
							if(c.succeeded()) {
								SearchList<SiteCounty> listSiteCounty = c.result();
								getSiteCountyResponse(listSiteCounty, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("getSiteCounty succeeded. "));
									} else {
										LOGGER.error(String.format("getSiteCounty failed. ", d.cause()));
										errorSiteCounty(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("getSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("getSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("getSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void getSiteCountyResponse(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		try {
			response200GETSiteCounty(listSiteCounty, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("getSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("getSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200GETSiteCounty(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
			SolrDocumentList solrDocuments = listSiteCounty.getSolrDocumentList();

			JsonObject json = JsonObject.mapFrom(listSiteCounty.getList().stream().findFirst().orElse(null));
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200GETSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// Search //

	@Override
	public void searchSiteCounty(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/county");
		siteRequest.setRequestMethod("Search");
		try {
			{
				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteCounty(siteRequest, false, true, "/api/county", "Search", c -> {
							if(c.succeeded()) {
								SearchList<SiteCounty> listSiteCounty = c.result();
								searchSiteCountyResponse(listSiteCounty, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("searchSiteCounty succeeded. "));
									} else {
										LOGGER.error(String.format("searchSiteCounty failed. ", d.cause()));
										errorSiteCounty(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("searchSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("searchSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("searchSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void searchSiteCountyResponse(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		try {
			response200SearchSiteCounty(listSiteCounty, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("searchSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("searchSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200SearchSiteCounty(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
			QueryResponse responseSearch = listSiteCounty.getQueryResponse();
			SolrDocumentList solrDocuments = listSiteCounty.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			Exception exceptionSearch = responseSearch.getException();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			json.put("searchTime", searchTime);
			json.put("transmissionTime", transmissionTime);
			JsonArray l = new JsonArray();
			listSiteCounty.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				List<String> fls = listSiteCounty.getFields();
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk");
						fieldNames.remove("created");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200SearchSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// AdminSearch //

	@Override
	public void adminsearchSiteCounty(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest);
		siteRequest.setRequestUri("/api/admin/county");
		siteRequest.setRequestMethod("AdminSearch");
		try {
			{
				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteCounty(siteRequest, false, true, "/api/admin/county", "AdminSearch", c -> {
							if(c.succeeded()) {
								SearchList<SiteCounty> listSiteCounty = c.result();
								adminsearchSiteCountyResponse(listSiteCounty, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("adminsearchSiteCounty succeeded. "));
									} else {
										LOGGER.error(String.format("adminsearchSiteCounty failed. ", d.cause()));
										errorSiteCounty(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("adminsearchSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("adminsearchSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("adminsearchSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void adminsearchSiteCountyResponse(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		try {
			response200AdminSearchSiteCounty(listSiteCounty, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("adminsearchSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("adminsearchSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200AdminSearchSiteCounty(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
			QueryResponse responseSearch = listSiteCounty.getQueryResponse();
			SolrDocumentList solrDocuments = listSiteCounty.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			Exception exceptionSearch = responseSearch.getException();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			json.put("searchTime", searchTime);
			json.put("transmissionTime", transmissionTime);
			JsonArray l = new JsonArray();
			listSiteCounty.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				List<String> fls = listSiteCounty.getFields();
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk");
						fieldNames.remove("created");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()))));
		} catch(Exception e) {
			LOGGER.error(String.format("response200AdminSearchSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// SearchPage //

	@Override
	public void searchpageSiteCountyId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		searchpageSiteCounty(operationRequest, eventHandler);
	}

	@Override
	public void searchpageSiteCounty(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest);
		siteRequest.setRequestUri("/county");
		siteRequest.setRequestMethod("SearchPage");
		try {
			{
				userSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						aSearchSiteCounty(siteRequest, false, true, "/county", "SearchPage", c -> {
							if(c.succeeded()) {
								SearchList<SiteCounty> listSiteCounty = c.result();
								searchpageSiteCountyResponse(listSiteCounty, d -> {
									if(d.succeeded()) {
										eventHandler.handle(Future.succeededFuture(d.result()));
										LOGGER.info(String.format("searchpageSiteCounty succeeded. "));
									} else {
										LOGGER.error(String.format("searchpageSiteCounty failed. ", d.cause()));
										errorSiteCounty(siteRequest, eventHandler, d);
									}
								});
							} else {
								LOGGER.error(String.format("searchpageSiteCounty failed. ", c.cause()));
								errorSiteCounty(siteRequest, eventHandler, c);
							}
						});
					} else {
						LOGGER.error(String.format("searchpageSiteCounty failed. ", b.cause()));
						errorSiteCounty(siteRequest, eventHandler, b);
					}
				});
			}
		} catch(Exception ex) {
			LOGGER.error(String.format("searchpageSiteCounty failed. ", ex));
			errorSiteCounty(siteRequest, eventHandler, Future.failedFuture(ex));
		}
	}


	public void searchpageSiteCountyPageInit(SiteCountyPage page, SearchList<SiteCounty> listSiteCounty) {
	}
	public void searchpageSiteCountyResponse(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
		try {
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(siteRequest, buffer);
			siteRequest.setW(w);
			response200SearchPageSiteCounty(listSiteCounty, a -> {
				if(a.succeeded()) {
					eventHandler.handle(Future.succeededFuture(a.result()));
				} else {
					LOGGER.error(String.format("searchpageSiteCountyResponse failed. ", a.cause()));
					errorSiteCounty(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception ex) {
			LOGGER.error(String.format("searchpageSiteCountyResponse failed. ", ex));
			errorSiteCounty(siteRequest, null, Future.failedFuture(ex));
		}
	}
	public void response200SearchPageSiteCounty(SearchList<SiteCounty> listSiteCounty, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listSiteCounty.getSiteRequest_();
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(listSiteCounty.getSiteRequest_(), buffer);
			SiteCountyPage page = new SiteCountyPage();
			SolrDocument pageSolrDocument = new SolrDocument();
			CaseInsensitiveHeaders requestHeaders = new CaseInsensitiveHeaders();
			siteRequest.setRequestHeaders(requestHeaders);

			pageSolrDocument.setField("pageUri_frFR_stored_string", "/county");
			page.setPageSolrDocument(pageSolrDocument);
			page.setW(w);
			if(listSiteCounty.size() == 1)
				siteRequest.setRequestPk(listSiteCounty.get(0).getPk());
			siteRequest.setW(w);
			page.setListSiteCounty(listSiteCounty);
			page.setSiteRequest_(siteRequest);
			searchpageSiteCountyPageInit(page, listSiteCounty);
			page.initDeepSiteCountyPage(siteRequest);
			page.html();
			eventHandler.handle(Future.succeededFuture(new OperationResponse(200, "OK", buffer, requestHeaders)));
		} catch(Exception e) {
			LOGGER.error(String.format("response200SearchPageSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// General //

	public Future<SiteCounty> defineIndexSiteCounty(SiteCounty siteCounty, Handler<AsyncResult<SiteCounty>> eventHandler) {
		Promise<SiteCounty> promise = Promise.promise();
		SiteRequestEnUS siteRequest = siteCounty.getSiteRequest_();
		defineSiteCounty(siteCounty, c -> {
			if(c.succeeded()) {
				attributeSiteCounty(siteCounty, d -> {
					if(d.succeeded()) {
						indexSiteCounty(siteCounty, e -> {
							if(e.succeeded()) {
								sqlCommitSiteCounty(siteRequest, f -> {
									if(f.succeeded()) {
										sqlCloseSiteCounty(siteRequest, g -> {
											if(g.succeeded()) {
												refreshSiteCounty(siteCounty, h -> {
													if(h.succeeded()) {
														eventHandler.handle(Future.succeededFuture(siteCounty));
														promise.complete(siteCounty);
													} else {
														LOGGER.error(String.format("refreshSiteCounty failed. ", h.cause()));
														errorSiteCounty(siteRequest, null, h);
													}
												});
											} else {
												LOGGER.error(String.format("defineIndexSiteCounty failed. ", g.cause()));
												errorSiteCounty(siteRequest, null, g);
											}
										});
									} else {
										LOGGER.error(String.format("defineIndexSiteCounty failed. ", f.cause()));
										errorSiteCounty(siteRequest, null, f);
									}
								});
							} else {
								LOGGER.error(String.format("defineIndexSiteCounty failed. ", e.cause()));
								errorSiteCounty(siteRequest, null, e);
							}
						});
					} else {
						LOGGER.error(String.format("defineIndexSiteCounty failed. ", d.cause()));
						errorSiteCounty(siteRequest, null, d);
					}
				});
			} else {
				LOGGER.error(String.format("defineIndexSiteCounty failed. ", c.cause()));
				errorSiteCounty(siteRequest, null, c);
			}
		});
		return promise.future();
	}

	public void createSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<SiteCounty>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();
			String userId = siteRequest.getUserId();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of(siteRequest.getSiteConfig_().getSiteZone())))).orElse(ZonedDateTime.now(ZoneId.of(siteRequest.getSiteConfig_().getSiteZone())));

			tx.preparedQuery(
					SiteContextEnUS.SQL_create
					, Tuple.of(SiteCounty.class.getCanonicalName(), userId, created.toOffsetDateTime())
					, Collectors.toList()
					, createAsync
			-> {
				if(createAsync.succeeded()) {
					Row createLine = createAsync.result().value().stream().findFirst().orElseGet(() -> null);
					Long pk = createLine.getLong(0);
					SiteCounty o = new SiteCounty();
					o.setPk(pk);
					o.setSiteRequest_(siteRequest);
					eventHandler.handle(Future.succeededFuture(o));
				} else {
					LOGGER.error(String.format("createSiteCounty failed. ", createAsync.cause()));
					eventHandler.handle(Future.failedFuture(createAsync.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("createSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void errorSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler, AsyncResult<?> resultAsync) {
		Throwable e = resultAsync.cause();
		JsonObject json = new JsonObject()
				.put("error", new JsonObject()
				.put("message", Optional.ofNullable(e).map(Throwable::getMessage).orElse(null))
				.put("userName", siteRequest.getUserName())
				.put("userFullName", siteRequest.getUserFullName())
				.put("requestUri", siteRequest.getRequestUri())
				.put("requestMethod", siteRequest.getRequestMethod())
				.put("params", siteRequest.getOperationRequest().getParams())
				);
		ExceptionUtils.printRootCauseStackTrace(e);
		OperationResponse responseOperation = new OperationResponse(400, "BAD REQUEST", 
				Buffer.buffer().appendString(json.encodePrettily())
				, new CaseInsensitiveHeaders().add("Content-Type", "application/json")
		);
		SiteConfig siteConfig = siteRequest.getSiteConfig_();
		SiteContextEnUS siteContext = siteRequest.getSiteContext_();
		MailClient mailClient = siteContext.getMailClient();
		MailMessage message = new MailMessage();
		message.setFrom(siteConfig.getEmailFrom());
		message.setTo(siteConfig.getEmailAdmin());
		if(e != null)
			message.setText(String.format("%s\n\n%s", json.encodePrettily(), ExceptionUtils.getStackTrace(e)));
		message.setSubject(String.format(siteConfig.getSiteBaseUrl() + " " + Optional.ofNullable(e).map(Throwable::getMessage).orElse(null)));
		WorkerExecutor workerExecutor = siteContext.getWorkerExecutor();
		workerExecutor.executeBlocking(
			blockingCodeHandler -> {
				mailClient.sendMail(message, result -> {
					if (result.succeeded()) {
						LOGGER.info(result.result());
					} else {
						LOGGER.error(result.cause());
					}
				});
			}, resultHandler -> {
			}
		);
		sqlRollbackSiteCounty(siteRequest, a -> {
			if(a.succeeded()) {
				LOGGER.info(String.format("sql rollback. "));
				sqlCloseSiteCounty(siteRequest, b -> {
					if(b.succeeded()) {
						LOGGER.info(String.format("sql close. "));
						if(eventHandler != null)
							eventHandler.handle(Future.succeededFuture(responseOperation));
					} else {
						if(eventHandler != null)
							eventHandler.handle(Future.succeededFuture(responseOperation));
					}
				});
			} else {
				if(eventHandler != null)
					eventHandler.handle(Future.succeededFuture(responseOperation));
			}
		});
	}

	public void sqlConnectionSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			PgPool pgPool = siteRequest.getSiteContext_().getPgPool();

			if(pgPool == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				pgPool.getConnection(a -> {
					if(a.succeeded()) {
						SqlConnection sqlConnection = a.result();
						siteRequest.setSqlConnection(sqlConnection);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlConnectionSiteCounty failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlTransactionSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();

			if(sqlConnection == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				Transaction tx = sqlConnection.begin();
				siteRequest.setTx(tx);
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlTransactionSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlCommitSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();

			if(tx == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				tx.commit(a -> {
					if(a.succeeded()) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else if("Transaction already completed".equals(a.cause().getMessage())) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlCommitSiteCounty failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlRollbackSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			Transaction tx = siteRequest.getTx();

			if(tx == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				tx.rollback(a -> {
					if(a.succeeded()) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else if("Transaction already completed".equals(a.cause().getMessage())) {
						siteRequest.setTx(null);
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("sqlRollbackSiteCounty failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlCloseSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();

			if(sqlConnection == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlConnection.close();
				siteRequest.setSqlConnection(null);
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("sqlCloseSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public SiteRequestEnUS generateSiteRequestEnUSForSiteCounty(SiteContextEnUS siteContext, OperationRequest operationRequest) {
		return generateSiteRequestEnUSForSiteCounty(siteContext, operationRequest, null);
	}

	public SiteRequestEnUS generateSiteRequestEnUSForSiteCounty(SiteContextEnUS siteContext, OperationRequest operationRequest, JsonObject body) {
		Vertx vertx = siteContext.getVertx();
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		siteRequest.setJsonObject(body);
		siteRequest.setVertx(vertx);
		siteRequest.setSiteContext_(siteContext);
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());
		siteRequest.setOperationRequest(operationRequest);
		siteRequest.initDeepSiteRequestEnUS(siteRequest);

		return siteRequest;
	}

	public void userSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			String userId = siteRequest.getUserId();
			if(userId == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlConnectionSiteCounty(siteRequest, a -> {
					if(a.succeeded()) {
						sqlTransactionSiteCounty(siteRequest, b -> {
							if(b.succeeded()) {
								Transaction tx = siteRequest.getTx();
								tx.preparedQuery(
										SiteContextEnUS.SQL_selectC
										, Tuple.of("org.southerncoalition.enus.user.SiteUser", userId)
										, Collectors.toList()
										, selectCAsync
								-> {
									if(selectCAsync.succeeded()) {
										try {
											Row userValues = selectCAsync.result().value().stream().findFirst().orElse(null);
											SiteUserEnUSApiServiceImpl userService = new SiteUserEnUSApiServiceImpl(siteContext);
											if(userValues == null) {
												JsonObject userVertx = siteRequest.getOperationRequest().getUser();
												JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));

												JsonObject jsonObject = new JsonObject();
												jsonObject.put("userName", jsonPrincipal.getString("preferred_username"));
												jsonObject.put("userFirstName", jsonPrincipal.getString("given_name"));
												jsonObject.put("userLastName", jsonPrincipal.getString("family_name"));
												jsonObject.put("userCompleteName", jsonPrincipal.getString("name"));
												jsonObject.put("userId", jsonPrincipal.getString("sub"));
												jsonObject.put("userEmail", jsonPrincipal.getString("email"));
												userSiteCountyDefine(siteRequest, jsonObject, false);

												SiteRequestEnUS siteRequest2 = new SiteRequestEnUS();
												siteRequest2.setTx(siteRequest.getTx());
												siteRequest2.setSqlConnection(siteRequest.getSqlConnection());
												siteRequest2.setJsonObject(jsonObject);
												siteRequest2.setVertx(siteRequest.getVertx());
												siteRequest2.setSiteContext_(siteContext);
												siteRequest2.setSiteConfig_(siteContext.getSiteConfig());
												siteRequest2.setUserId(siteRequest.getUserId());
												siteRequest2.initDeepSiteRequestEnUS(siteRequest);

												ApiRequest apiRequest = new ApiRequest();
												apiRequest.setRows(1);
												apiRequest.setNumFound(1L);
												apiRequest.setNumPATCH(0L);
												apiRequest.initDeepApiRequest(siteRequest2);
												siteRequest2.setApiRequest_(apiRequest);

												userService.createSiteUser(siteRequest2, c -> {
													if(c.succeeded()) {
														SiteUser siteUser = c.result();
														userService.sqlPOSTSiteUser(siteUser, false, d -> {
															if(d.succeeded()) {
																userService.defineIndexSiteUser(siteUser, e -> {
																	if(e.succeeded()) {
																		siteRequest.setSiteUser(siteUser);
																		siteRequest.setUserName(jsonPrincipal.getString("preferred_username"));
																		siteRequest.setUserFirstName(jsonPrincipal.getString("given_name"));
																		siteRequest.setUserLastName(jsonPrincipal.getString("family_name"));
																		siteRequest.setUserId(jsonPrincipal.getString("sub"));
																		siteRequest.setUserKey(siteUser.getPk());
																		eventHandler.handle(Future.succeededFuture());
																	} else {
																		errorSiteCounty(siteRequest, eventHandler, e);
																	}
																});
															} else {
																errorSiteCounty(siteRequest, eventHandler, d);
															}
														});
													} else {
														errorSiteCounty(siteRequest, eventHandler, c);
													}
												});
											} else {
												Long pkUser = userValues.getLong(0);
												SearchList<SiteUser> searchList = new SearchList<SiteUser>();
												searchList.setQuery("*:*");
												searchList.setStore(true);
												searchList.setC(SiteUser.class);
												searchList.addFilterQuery("userId_indexed_string:" + ClientUtils.escapeQueryChars(userId));
												searchList.addFilterQuery("pk_indexed_long:" + pkUser);
												searchList.initDeepSearchList(siteRequest);
												SiteUser siteUser1 = searchList.getList().stream().findFirst().orElse(null);

												JsonObject userVertx = siteRequest.getOperationRequest().getUser();
												JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));

												JsonObject jsonObject = new JsonObject();
												jsonObject.put("setUserName", jsonPrincipal.getString("preferred_username"));
												jsonObject.put("setUserFirstName", jsonPrincipal.getString("given_name"));
												jsonObject.put("setUserLastName", jsonPrincipal.getString("family_name"));
												jsonObject.put("setUserCompleteName", jsonPrincipal.getString("name"));
												jsonObject.put("setUserId", jsonPrincipal.getString("sub"));
												jsonObject.put("setUserEmail", jsonPrincipal.getString("email"));
												Boolean define = userSiteCountyDefine(siteRequest, jsonObject, true);
												if(define) {
													SiteUser siteUser;
													if(siteUser1 == null) {
														siteUser = new SiteUser();
														siteUser.setPk(pkUser);
														siteUser.setSiteRequest_(siteRequest);
													} else {
														siteUser = siteUser1;
													}

													SiteRequestEnUS siteRequest2 = new SiteRequestEnUS();
													siteRequest2.setTx(siteRequest.getTx());
													siteRequest2.setSqlConnection(siteRequest.getSqlConnection());
													siteRequest2.setJsonObject(jsonObject);
													siteRequest2.setVertx(siteRequest.getVertx());
													siteRequest2.setSiteContext_(siteContext);
													siteRequest2.setSiteConfig_(siteContext.getSiteConfig());
													siteRequest2.setUserId(siteRequest.getUserId());
													siteRequest2.setUserKey(siteRequest.getUserKey());
													siteRequest2.initDeepSiteRequestEnUS(siteRequest);
													siteUser.setSiteRequest_(siteRequest2);

													ApiRequest apiRequest = new ApiRequest();
													apiRequest.setRows(1);
													apiRequest.setNumFound(1L);
													apiRequest.setNumPATCH(0L);
													apiRequest.initDeepApiRequest(siteRequest2);
													siteRequest2.setApiRequest_(apiRequest);

													userService.sqlPATCHSiteUser(siteUser, false, d -> {
														if(d.succeeded()) {
															SiteUser siteUser2 = d.result();
															userService.defineIndexSiteUser(siteUser2, e -> {
																if(e.succeeded()) {
																	siteRequest.setSiteUser(siteUser2);
																	siteRequest.setUserName(siteUser2.getUserName());
																	siteRequest.setUserFirstName(siteUser2.getUserFirstName());
																	siteRequest.setUserLastName(siteUser2.getUserLastName());
																	siteRequest.setUserId(siteUser2.getUserId());
																	siteRequest.setUserKey(siteUser2.getPk());
																	eventHandler.handle(Future.succeededFuture());
																} else {
																	errorSiteCounty(siteRequest, eventHandler, e);
																}
															});
														} else {
															errorSiteCounty(siteRequest, eventHandler, d);
														}
													});
												} else {
													siteRequest.setSiteUser(siteUser1);
													siteRequest.setUserName(siteUser1.getUserName());
													siteRequest.setUserFirstName(siteUser1.getUserFirstName());
													siteRequest.setUserLastName(siteUser1.getUserLastName());
													siteRequest.setUserId(siteUser1.getUserId());
													siteRequest.setUserKey(siteUser1.getPk());
													sqlRollbackSiteCounty(siteRequest, c -> {
														if(c.succeeded()) {
															eventHandler.handle(Future.succeededFuture());
														} else {
															eventHandler.handle(Future.failedFuture(c.cause()));
															errorSiteCounty(siteRequest, eventHandler, c);
														}
													});
												}
											}
										} catch(Exception e) {
											LOGGER.error(String.format("userSiteCounty failed. ", e));
											eventHandler.handle(Future.failedFuture(e));
										}
									} else {
										LOGGER.error(String.format("userSiteCounty failed. ", selectCAsync.cause()));
										eventHandler.handle(Future.failedFuture(selectCAsync.cause()));
									}
								});
							} else {
								LOGGER.error(String.format("userSiteCounty failed. ", b.cause()));
								eventHandler.handle(Future.failedFuture(b.cause()));
							}
						});
					} else {
						LOGGER.error(String.format("userSiteCounty failed. ", a.cause()));
						eventHandler.handle(Future.failedFuture(a.cause()));
					}
				});
			}
		} catch(Exception e) {
			LOGGER.error(String.format("userSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public Boolean userSiteCountyDefine(SiteRequestEnUS siteRequest, JsonObject jsonObject, Boolean patch) {
		if(patch) {
			return false;
		} else {
			return false;
		}
	}

	public void aSearchSiteCountyQ(String uri, String apiMethod, SearchList<SiteCounty> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.setQuery(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : ClientUtils.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public void aSearchSiteCountyFq(String uri, String apiMethod, SearchList<SiteCounty> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(valueIndexed));
	}

	public void aSearchSiteCountySort(String uri, String apiMethod, SearchList<SiteCounty> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.addSort(varIndexed, ORDER.valueOf(valueIndexed));
	}

	public void aSearchSiteCountyRows(String uri, String apiMethod, SearchList<SiteCounty> searchList, Integer valueRows) {
			searchList.setRows(apiMethod != null && apiMethod.contains("Search") ? valueRows : 10);
	}

	public void aSearchSiteCountyStart(String uri, String apiMethod, SearchList<SiteCounty> searchList, Integer valueStart) {
		searchList.setStart(valueStart);
	}

	public void aSearchSiteCountyVar(String uri, String apiMethod, SearchList<SiteCounty> searchList, String var, String value) {
		searchList.getSiteRequest_().getRequestVars().put(var, value);
	}

	public void aSearchSiteCountyUri(String uri, String apiMethod, SearchList<SiteCounty> searchList) {
	}

	public void varsSiteCounty(SiteRequestEnUS siteRequest, Handler<AsyncResult<SearchList<OperationResponse>>> eventHandler) {
		try {
			OperationRequest operationRequest = siteRequest.getOperationRequest();

			operationRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "var":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								siteRequest.getRequestVars().put(entityVar, valueIndexed);
								break;
						}
					}
				} catch(Exception e) {
					LOGGER.error(String.format("aSearchSiteCounty failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
			eventHandler.handle(Future.succeededFuture());
		} catch(Exception e) {
			LOGGER.error(String.format("aSearchSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void aSearchSiteCounty(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, String uri, String apiMethod, Handler<AsyncResult<SearchList<SiteCounty>>> eventHandler) {
		try {
			OperationRequest operationRequest = siteRequest.getOperationRequest();
			String entityListStr = siteRequest.getOperationRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<SiteCounty> searchList = new SearchList<SiteCounty>();
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.setQuery("*:*");
			searchList.setC(SiteCounty.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null)
				searchList.addFields(entityList);
			searchList.add("json.facet", "{max_modified:'max(modified_indexed_date)'}");

			String id = operationRequest.getParams().getJsonObject("path").getString("id");
			if(id != null) {
				searchList.addFilterQuery("(id:" + ClientUtils.escapeQueryChars(id) + " OR objectId_indexed_string:" + ClientUtils.escapeQueryChars(id) + ")");
			}

			operationRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Integer valueStart = null;
				Integer valueRows = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "q":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								varIndexed = "*".equals(entityVar) ? entityVar : SiteCounty.varSearchSiteCounty(entityVar);
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								valueIndexed = StringUtils.isEmpty(valueIndexed) ? "*" : valueIndexed;
								aSearchSiteCountyQ(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "fq":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								varIndexed = SiteCounty.varIndexedSiteCounty(entityVar);
								aSearchSiteCountyFq(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "sort":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = SiteCounty.varIndexedSiteCounty(entityVar);
								aSearchSiteCountySort(uri, apiMethod, searchList, entityVar, valueIndexed, varIndexed);
								break;
							case "start":
								valueStart = (Integer)paramObject;
								aSearchSiteCountyStart(uri, apiMethod, searchList, valueStart);
								break;
							case "rows":
								valueRows = (Integer)paramObject;
								aSearchSiteCountyRows(uri, apiMethod, searchList, valueRows);
								break;
							case "var":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								aSearchSiteCountyVar(uri, apiMethod, searchList, entityVar, valueIndexed);
								break;
						}
					}
					aSearchSiteCountyUri(uri, apiMethod, searchList);
				} catch(Exception e) {
					LOGGER.error(String.format("aSearchSiteCounty failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
			if("*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.addSort("countyName_indexed_string", ORDER.asc);
			}
			searchList.initDeepForClass(siteRequest);
			eventHandler.handle(Future.succeededFuture(searchList));
		} catch(Exception e) {
			LOGGER.error(String.format("aSearchSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void defineSiteCounty(SiteCounty o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			tx.preparedQuery(
					SiteContextEnUS.SQL_define
					, Tuple.of(pk)
					, Collectors.toList()
					, defineAsync
			-> {
				if(defineAsync.succeeded()) {
					try {
						for(Row definition : defineAsync.result().value()) {
							try {
								o.defineForClass(definition.getString(0), definition.getString(1));
							} catch(Exception e) {
								LOGGER.error(String.format("defineSiteCounty failed. ", e));
								LOGGER.error(e);
							}
						}
						eventHandler.handle(Future.succeededFuture());
					} catch(Exception e) {
						LOGGER.error(String.format("defineSiteCounty failed. ", e));
						eventHandler.handle(Future.failedFuture(e));
					}
				} else {
					LOGGER.error(String.format("defineSiteCounty failed. ", defineAsync.cause()));
					eventHandler.handle(Future.failedFuture(defineAsync.cause()));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("defineSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void attributeSiteCounty(SiteCounty o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			Transaction tx = siteRequest.getTx();
			Long pk = o.getPk();
			tx.preparedQuery(
					SiteContextEnUS.SQL_attribute
					, Tuple.of(pk, pk)
					, Collectors.toList()
					, attributeAsync
			-> {
				try {
					if(attributeAsync.succeeded()) {
						if(attributeAsync.result() != null) {
							for(Row definition : attributeAsync.result().value()) {
								if(pk.equals(definition.getLong(0)))
									o.attributeForClass(definition.getString(2), definition.getLong(1));
								else
									o.attributeForClass(definition.getString(3), definition.getLong(0));
							}
						}
						eventHandler.handle(Future.succeededFuture());
					} else {
						LOGGER.error(String.format("attributeSiteCounty failed. ", attributeAsync.cause()));
						eventHandler.handle(Future.failedFuture(attributeAsync.cause()));
					}
				} catch(Exception e) {
					LOGGER.error(String.format("attributeSiteCounty failed. ", e));
					eventHandler.handle(Future.failedFuture(e));
				}
			});
		} catch(Exception e) {
			LOGGER.error(String.format("attributeSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void indexSiteCounty(SiteCounty o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			o.initDeepForClass(siteRequest);
			o.indexForClass();
			eventHandler.handle(Future.succeededFuture());
		} catch(Exception e) {
			LOGGER.error(String.format("indexSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void refreshSiteCounty(SiteCounty o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && BooleanUtils.isFalse(Optional.ofNullable(siteRequest.getApiRequest_()).map(ApiRequest::getEmpty).orElse(true))) {
				SearchList<SiteCounty> searchList = new SearchList<SiteCounty>();
				searchList.setStore(true);
				searchList.setQuery("*:*");
				searchList.setC(SiteCounty.class);
				searchList.addFilterQuery("modified_indexed_date:[" + DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(siteRequest.getApiRequest_().getCreated().toInstant(), ZoneId.of("UTC"))) + " TO *]");
				searchList.add("json.facet", "{stateKey:{terms:{field:stateKey_indexed_longs, limit:1000}}}");
				searchList.add("json.facet", "{reportCardKeys:{terms:{field:reportCardKeys_indexed_longs, limit:1000}}}");
				searchList.setRows(1000);
				searchList.initDeepSearchList(siteRequest);
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);

					if("SiteState".equals(classSimpleName2) && pk2 != null) {
						SearchList<SiteState> searchList2 = new SearchList<SiteState>();
						searchList2.setStore(true);
						searchList2.setQuery("*:*");
						searchList2.setC(SiteState.class);
						searchList2.addFilterQuery("pk_indexed_long:" + pk2);
						searchList2.setRows(1);
						searchList2.initDeepSearchList(siteRequest);
						SiteState o2 = searchList2.getList().stream().findFirst().orElse(null);

						if(o2 != null) {
							SiteStateEnUSGenApiServiceImpl service = new SiteStateEnUSGenApiServiceImpl(siteRequest.getSiteContext_());
							SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), new JsonObject());
							ApiRequest apiRequest2 = new ApiRequest();
							apiRequest2.setRows(1);
							apiRequest2.setNumFound(1l);
							apiRequest2.setNumPATCH(0L);
							apiRequest2.initDeepApiRequest(siteRequest2);
							siteRequest2.setApiRequest_(apiRequest2);
							siteRequest2.getVertx().eventBus().publish("websocketSiteState", JsonObject.mapFrom(apiRequest2).toString());

							o2.setPk(pk2);
							o2.setSiteRequest_(siteRequest2);
							futures.add(
								service.patchSiteStateFuture(o2, false, a -> {
									if(a.succeeded()) {
									} else {
										LOGGER.info(String.format("SiteState %s failed. ", pk2));
										eventHandler.handle(Future.failedFuture(a.cause()));
									}
								})
							);
						}
					}

					if("ReportCard".equals(classSimpleName2) && pk2 != null) {
						SearchList<ReportCard> searchList2 = new SearchList<ReportCard>();
						searchList2.setStore(true);
						searchList2.setQuery("*:*");
						searchList2.setC(ReportCard.class);
						searchList2.addFilterQuery("pk_indexed_long:" + pk2);
						searchList2.setRows(1);
						searchList2.initDeepSearchList(siteRequest);
						ReportCard o2 = searchList2.getList().stream().findFirst().orElse(null);

						if(o2 != null) {
							ReportCardEnUSGenApiServiceImpl service = new ReportCardEnUSGenApiServiceImpl(siteRequest.getSiteContext_());
							SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), new JsonObject());
							ApiRequest apiRequest2 = new ApiRequest();
							apiRequest2.setRows(1);
							apiRequest2.setNumFound(1l);
							apiRequest2.setNumPATCH(0L);
							apiRequest2.initDeepApiRequest(siteRequest2);
							siteRequest2.setApiRequest_(apiRequest2);
							siteRequest2.getVertx().eventBus().publish("websocketReportCard", JsonObject.mapFrom(apiRequest2).toString());

							o2.setPk(pk2);
							o2.setSiteRequest_(siteRequest2);
							futures.add(
								service.patchReportCardFuture(o2, false, a -> {
									if(a.succeeded()) {
									} else {
										LOGGER.info(String.format("ReportCard %s failed. ", pk2));
										eventHandler.handle(Future.failedFuture(a.cause()));
									}
								})
							);
						}
					}
				}

				CompositeFuture.all(futures).setHandler(a -> {
					if(a.succeeded()) {
						SiteCountyEnUSApiServiceImpl service = new SiteCountyEnUSApiServiceImpl(siteRequest.getSiteContext_());
						List<Future> futures2 = new ArrayList<>();
						for(SiteCounty o2 : searchList.getList()) {
							SiteRequestEnUS siteRequest2 = generateSiteRequestEnUSForSiteCounty(siteContext, siteRequest.getOperationRequest(), new JsonObject());
							o2.setSiteRequest_(siteRequest2);
							futures2.add(
								service.patchSiteCountyFuture(o2, false, b -> {
									if(b.succeeded()) {
									} else {
										LOGGER.info(String.format("SiteCounty %s failed. ", o2.getPk()));
										eventHandler.handle(Future.failedFuture(b.cause()));
									}
								})
							);
						}

						CompositeFuture.all(futures2).setHandler(b -> {
							if(b.succeeded()) {
								eventHandler.handle(Future.succeededFuture());
							} else {
								LOGGER.error("Refresh relations failed. ", b.cause());
								errorSiteCounty(siteRequest, eventHandler, b);
							}
						});
					} else {
						LOGGER.error("Refresh relations failed. ", a.cause());
						errorSiteCounty(siteRequest, eventHandler, a);
					}
				});
			} else {
				eventHandler.handle(Future.succeededFuture());
			}
		} catch(Exception e) {
			LOGGER.error(String.format("refreshSiteCounty failed. ", e));
			eventHandler.handle(Future.failedFuture(e));
		}
	}
}
