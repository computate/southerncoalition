package org.southerncoalition.enus.writer;

import java.io.IOException;

import org.southerncoalition.enus.request.SiteRequestEnUS;
import org.southerncoalition.enus.wrap.Wrap;

public class ClassWriters extends ClassWritersGen<Object> {  

	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	protected void _wClass(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wFields(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wGettersSetters(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wHashCode(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wToString(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wEquals(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wImports(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wNamedQuery(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wIndex(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _wStore(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "    "));
	}

	protected void _writersApi(Wrap<AllWriters> c) {
		c.o(AllWriters.create(siteRequest_, wFields, wGettersSetters, wHashCode, wToString, wEquals, wImports, wNamedQuery, wIndex, wStore));
	}

	// Class //

	public AllWriter tClass(int nombreTabulations, Object...objets) {
		return wClass.t(nombreTabulations, objets);
	}
	public AllWriter tlClass(int nombreTabulations, Object...objets) {
		return wClass.tl(nombreTabulations, objets);
	}

	public AllWriter lClass(Object...objets) {
		return wClass.l(objets);
	}

	public AllWriter sClass(Object...objets) { 
		return wClass.s(objets);
	}

	// NamedQueries //

	public AllWriter tNamedQuery(int nombreTabulations, Object...objets) {
		return wNamedQuery.t(nombreTabulations, objets);
	}
	public AllWriter tlNamedQuery(int nombreTabulations, Object...objets) {
		return wNamedQuery.tl(nombreTabulations, objets);
	}

	public AllWriter lNamedQuery(Object...objets) {
		return wNamedQuery.l(objets);
	}

	public AllWriter sNamedQuery(Object...objets) { 
		return wNamedQuery.s(objets);
	}

	public void flushClose() throws IOException {
		writersApi.flushClose();
	}
}
