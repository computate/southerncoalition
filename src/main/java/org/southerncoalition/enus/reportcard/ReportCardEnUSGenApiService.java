package org.southerncoalition.enus.reportcard;

import org.southerncoalition.enus.context.SiteContextEnUS;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Translate: false
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface ReportCardEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("southerncoalition-enUS-ReportCard").register(ReportCardEnUSGenApiService.class, new ReportCardEnUSApiServiceImpl(siteContext));
	}

	static ReportCardEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new ReportCardEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static ReportCardEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new ReportCardEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void putimportReportCard(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putmergeReportCard(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void putcopyReportCard(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void postReportCard(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchReportCard(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getReportCard(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchReportCard(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void adminsearchReportCard(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageReportCardId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageReportCard(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
