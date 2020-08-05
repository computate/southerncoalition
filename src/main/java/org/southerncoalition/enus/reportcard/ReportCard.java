package org.southerncoalition.enus.reportcard;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.southerncoalition.enus.cluster.Cluster;
import org.southerncoalition.enus.county.SiteCounty;
import org.southerncoalition.enus.search.SearchList;
import org.southerncoalition.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Indexed: true
 * Saved: true
 * 
 * ApiTag.enUS: State
 * ApiUri.enUS: /api/reportcard
 * 
 * ApiMethod.enUS: PUTImport
 * ApiMethod.enUS: PUTMerge
 * ApiMethod.enUS: PUTCopy

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: AdminSearch
 * ApiUriAdminSearch.enUS: /api/admin/reportcard
 * RoleUtilisateurAdminSearch.enUS: true
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: ReportCardPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /reportcard
 * 
 * AName.enUS: a report card
 * Color: pale-green
 * IconGroup: regular
 * IconName: newspaper
 * NameVar.enUS: reportCard
 * 
 * Role.frFR: SiteAdmin
 * Role.enUS: SiteAdmin
 * PublicRead: true
 * 
 * Sort.desc: reportCardStartYear
 * Sort.asc: stateName
 * Sort.asc: countyName
 * 
 * Lines: 100
 **/      
public class ReportCard extends ReportCardGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Description.enUS: The primary key of the report card in the database. 
	 */           
	protected void _reportCardKey(Wrap<Long> c) {
		c.o(pk);
	}

	/**    
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: start year
	 */ 
	protected void _reportCardStartYear(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: end year
	 */ 
	protected void _reportCardEndYear(Wrap<Integer> c) {
		if(reportCardStartYear != null)
			c.o(reportCardStartYear + 1);
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */ 
	protected void _countySearch(SearchList<SiteCounty> l) {
		l.setQuery("*:*");
		l.addFilterQuery("reportCardKeys_indexed_longs:" + pk);
		l.setC(SiteCounty.class);
		l.setStore(true);
	}

	protected void _county_(Wrap<SiteCounty> c) {
		if(countySearch.size() > 0) {
			c.o(countySearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Attribute: SiteCounty.reportCardKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: county
	 */           
	protected void _countyKey(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: pupils total
	 */ 
	protected void _pupilsTotal(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * DisplayName.enUS: Indian female
	 */ 
	protected void _pupilsIndianFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 3
	 * DisplayName.enUS: Indian male
	 */  
	protected void _pupilsIndianMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 5
	 * HtmlCell: 4
	 * DisplayName.enUS: Indians total
	 */ 
	protected void _pupilsIndianTotal(Wrap<Integer> c) {
		if(pupilsIndianFemale != null  && pupilsIndianMale != null)
			c.o(pupilsIndianFemale + pupilsIndianMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 5
	 * HtmlCell: 5
	 * DisplayName.enUS: Indians percent
	 */ 
	protected void _pupilsIndianPercent(Wrap<BigDecimal> c) {
		if(pupilsIndianFemale != null  && pupilsIndianMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsIndianFemale).add(new BigDecimal(pupilsIndianMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: Asian female
	 */ 
	protected void _pupilsAsianFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * DisplayName.enUS: Asian male
	 */ 
	protected void _pupilsAsianMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 6
	 * HtmlCell: 3
	 * DisplayName.enUS: Asians total
	 */ 
	protected void _pupilsAsianTotal(Wrap<Integer> c) {
		if(pupilsAsianFemale != null  && pupilsAsianMale != null)
			c.o(pupilsAsianFemale + pupilsAsianMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 6
	 * HtmlCell: 4
	 * DisplayName.enUS: Asians percent
	 */ 
	protected void _pupilsAsianPercent(Wrap<BigDecimal> c) {
		if(pupilsAsianFemale != null  && pupilsAsianMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsAsianFemale).add(new BigDecimal(pupilsAsianMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 7
	 * HtmlCell: 1
	 * DisplayName.enUS: Hispanic female
	 */ 
	protected void _pupilsHispanicFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 7
	 * HtmlCell: 2
	 * DisplayName.enUS: Hispanic male
	 */ 
	protected void _pupilsHispanicMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 7
	 * HtmlCell: 3
	 * DisplayName.enUS: Hispanics total
	 */ 
	protected void _pupilsHispanicTotal(Wrap<Integer> c) {
		if(pupilsHispanicFemale != null  && pupilsHispanicMale != null)
			c.o(pupilsHispanicFemale + pupilsHispanicMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 7
	 * HtmlCell: 4
	 * DisplayName.enUS: Hispanics percent
	 */ 
	protected void _pupilsHispanicPercent(Wrap<BigDecimal> c) {
		if(pupilsHispanicFemale != null  && pupilsHispanicMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsHispanicFemale).add(new BigDecimal(pupilsHispanicMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 8
	 * HtmlCell: 1
	 * DisplayName.enUS: Black female
	 */ 
	protected void _pupilsBlackFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 8
	 * HtmlCell: 2
	 * DisplayName.enUS: Black male
	 */ 
	protected void _pupilsBlackMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 8
	 * HtmlCell: 3
	 * DisplayName.enUS: Blacks total
	 */ 
	protected void _pupilsBlackTotal(Wrap<Integer> c) {
		if(pupilsBlackFemale != null  && pupilsBlackMale != null)
			c.o(pupilsBlackFemale + pupilsBlackMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 8
	 * HtmlCell: 4
	 * DisplayName.enUS: Blacks percent
	 */ 
	protected void _pupilsBlackPercent(Wrap<BigDecimal> c) {
		if(pupilsBlackFemale != null  && pupilsBlackMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsBlackFemale).add(new BigDecimal(pupilsBlackMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 9
	 * HtmlCell: 1
	 * DisplayName.enUS: White female
	 */ 
	protected void _pupilsWhiteFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 9
	 * HtmlCell: 2
	 * DisplayName.enUS: White male
	 */ 
	protected void _pupilsWhiteMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 9
	 * HtmlCell: 3
	 * DisplayName.enUS: Whites total
	 */ 
	protected void _pupilsWhiteTotal(Wrap<Integer> c) {
		if(pupilsWhiteFemale != null  && pupilsWhiteMale != null)
			c.o(pupilsWhiteFemale + pupilsWhiteMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 9
	 * HtmlCell: 4
	 * DisplayName.enUS: Whites percent
	 */ 
	protected void _pupilsWhitePercent(Wrap<BigDecimal> c) {
		if(pupilsWhiteFemale != null  && pupilsWhiteMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsWhiteFemale).add(new BigDecimal(pupilsWhiteMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 10
	 * HtmlCell: 1
	 * DisplayName.enUS: Pacific Islander female
	 */ 
	protected void _pupilsPacificIslanderFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 10
	 * HtmlCell: 2
	 * DisplayName.enUS: Pacific Islander male
	 */ 
	protected void _pupilsPacificIslanderMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 10
	 * HtmlCell: 3
	 * DisplayName.enUS: Pacific Islanders total
	 */ 
	protected void _pupilsPacificIslanderTotal(Wrap<Integer> c) {
		if(pupilsPacificIslanderFemale != null  && pupilsPacificIslanderMale != null)
			c.o(pupilsPacificIslanderFemale + pupilsPacificIslanderMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 10
	 * HtmlCell: 4
	 * DisplayName.enUS: Pacific Islanders percent
	 */ 
	protected void _pupilsPacificIslanderPercent(Wrap<BigDecimal> c) {
		if(pupilsPacificIslanderFemale != null  && pupilsPacificIslanderMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsPacificIslanderFemale).add(new BigDecimal(pupilsPacificIslanderMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 11
	 * HtmlCell: 1
	 * DisplayName.enUS: Multi Racial female
	 */ 
	protected void _pupilsMultiRacialFemale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 11
	 * HtmlCell: 2
	 * DisplayName.enUS: Multi Racial male
	 */ 
	protected void _pupilsMultiRacialMale(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 11
	 * HtmlCell: 3
	 * DisplayName.enUS: Multi Racials total
	 */ 
	protected void _pupilsMultiRacialTotal(Wrap<Integer> c) {
		if(pupilsMultiRacialFemale != null  && pupilsMultiRacialMale != null)
			c.o(pupilsMultiRacialFemale + pupilsMultiRacialMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 11
	 * HtmlCell: 4
	 * DisplayName.enUS: Multi Racials percent
	 */ 
	protected void _pupilsMultiRacialPercent(Wrap<BigDecimal> c) {
		if(pupilsMultiRacialFemale != null  && pupilsMultiRacialMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsMultiRacialFemale).add(new BigDecimal(pupilsMultiRacialMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 12
	 * HtmlCell: 1
	 * DisplayName.enUS: delinquent complaints total
	 */ 
	protected void _delinquentComplaintsTotal(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 12
	 * HtmlCell: 2
	 * DisplayName.enUS: delinquent complaints at school
	 */ 
	protected void _delinquentComplaintsAtSchool(Wrap<Integer> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 12
	 * HtmlCell: 3
	 * DisplayName.enUS: delinquent complaints at school percent
	 */ 
	protected void _delinquentComplaintsAtSchoolPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsAtSchool != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsAtSchool).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateKey(Wrap<Long> c) {
		if(county_ != null)
			c.o(county_.getStateKey());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateName(Wrap<String> c) {
		if(county_ != null)
			c.o(county_.getStateName());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateAbbreviation(Wrap<String> c) {
		if(county_ != null)
			c.o(county_.getStateAbbreviation());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _countyName(Wrap<String> c) {
		if(county_ != null)
			c.o(county_.getCountyName());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarH2: true
	 * VarTitle: true
	 */ 
	protected void _countyCompleteName(Wrap<String> c) {
		c.o(reportCardStartYear + "-" + reportCardEndYear + " report card in " + countyName + " county in " + stateName + " (" + stateAbbreviation + ")");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override() protected void  _objectTitle(Wrap<String> c) {
		c.o(reportCardStartYear + "-" + reportCardEndYear + " report card in " + countyName + " county in " + stateName + " (" + stateAbbreviation + ")");
	}
}
