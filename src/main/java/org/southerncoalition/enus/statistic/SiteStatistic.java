package org.southerncoalition.enus.statistic; 

import org.southerncoalition.enus.cluster.Cluster;
import org.southerncoalition.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Indexed: true
 * Saved: true
 * 
 * ApiTag.enUS: State
 * ApiUri.enUS: /api/statistic
 * 
 * ApiMethod.enUS: PUTImport
 * ApiMethod.enUS: PUTMerge
 * ApiMethod.enUS: PUTCopy

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: StatisticPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /statistic
 * 
 * AName.enUS: a statistic
 * Color: pale-green
 * IconGroup: regular
 * IconName: newspaper
 * NameVar.enUS: statistic
 * 
 * Lines: 100
 * Role.enUS: SiteAdmin
 **/     
public class SiteStatistic extends SiteStatisticGen<Cluster> {

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _reportCardKey(Wrap<Long> c) {
	}

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _num(Wrap<Long> c) {
	}

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _pupilRace(Wrap<String> c) {
	}

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _pupilRaceColor(Wrap<String> c) {
	}

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _pupilRaceReduced(Wrap<String> c) {
	}

	/**
	 * Indexed: true
	 * Stored: true
	 */
	protected void _pupilRaceReducedColor(Wrap<String> c) {
	}
}
