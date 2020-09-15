package org.southerncoalition.enus.reportcard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.ColumnArrangement;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtils;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.util.UnitType;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.southerncoalition.enus.agency.SiteAgency;
import org.southerncoalition.enus.cluster.Cluster;
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
 * Role.enUS: SiteAdmin
 * PublicRead: true
 * 
 * Sort.desc: reportCardStartYear
 * Sort.asc: stateName
 * Sort.asc: agencyName
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
	 */ 
	protected void _reportCardStartYearStr(Wrap<String> c) {
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
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _reportCardYearsStr(Wrap<String> c) {
		if(reportCardStartYear != null && reportCardEndYear != null)
			c.o(reportCardStartYear + "-" + (reportCardEndYear % 100));
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */ 
	protected void _agencySearch(SearchList<SiteAgency> l) {
		l.setQuery("*:*");
		l.addFilterQuery("reportCardKeys_indexed_longs:" + pk);
		l.setC(SiteAgency.class);
		l.setStore(true);
	}

	protected void _agency_(Wrap<SiteAgency> c) {
		if(agencySearch.size() > 0) {
			c.o(agencySearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Attribute: SiteAgency.reportCardKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: agency
	 */           
	protected void _agencyKey(Wrap<Long> c) {
	}

	////////////////////////////////////////////////////////
	// http://apps.schools.nc.gov/ords/f?p=145:15:::NO::: //
	////////////////////////////////////////////////////////

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 12
	 * HtmlCell: 1
	 * DisplayName.enUS: pupils total
	 */ 
	protected void _pupilsTotal(Wrap<Long> c) {
	}
	@Override
	public String strPupilsTotal() {
		return pupilsTotal == null ? "" : new DecimalFormat("#,##0").format(pupilsTotal);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 3
	 * DisplayName.enUS: First Nation female
	 */ 
	protected void _pupilsIndianFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * DisplayName.enUS: First Nation male
	 */  
	protected void _pupilsIndianMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 5
	 * HtmlCell: 4
	 * DisplayName.enUS: First Nation total
	 */ 
	protected void _pupilsIndianTotal(Wrap<Long> c) {
		if(pupilsIndianFemale != null  && pupilsIndianMale != null)
			c.o(pupilsIndianFemale + pupilsIndianMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 5
	 * HtmlCell: 5
	 * DisplayName.enUS: First Nation percent
	 */ 
	protected void _pupilsIndianPercent(Wrap<BigDecimal> c) {
		if(pupilsIndianFemale != null  && pupilsIndianMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsIndianFemale).add(new BigDecimal(pupilsIndianMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strPupilsIndianPercent() {
		return pupilsIndianPercent == null ? "" : pupilsIndianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * DisplayName.enUS: Asian female
	 */ 
	protected void _pupilsAsianFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: Asian male
	 */ 
	protected void _pupilsAsianMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 6
	 * HtmlCell: 3
	 * DisplayName.enUS: Asians total
	 */ 
	protected void _pupilsAsianTotal(Wrap<Long> c) {
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
	@Override public String strPupilsAsianPercent() {
		return pupilsAsianPercent == null ? "" : pupilsAsianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 7
	 * HtmlCell: 2
	 * DisplayName.enUS: Latinx female
	 */ 
	protected void _pupilsHispanicFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 7
	 * HtmlCell: 1
	 * DisplayName.enUS: Latinx male
	 */ 
	protected void _pupilsHispanicMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 7
	 * HtmlCell: 3
	 * DisplayName.enUS: Latinx total
	 */ 
	protected void _pupilsHispanicTotal(Wrap<Long> c) {
		if(pupilsHispanicFemale != null  && pupilsHispanicMale != null)
			c.o(pupilsHispanicFemale + pupilsHispanicMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 7
	 * HtmlCell: 4
	 * DisplayName.enUS: Latinx percent
	 */ 
	protected void _pupilsHispanicPercent(Wrap<BigDecimal> c) {
		if(pupilsHispanicFemale != null  && pupilsHispanicMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsHispanicFemale).add(new BigDecimal(pupilsHispanicMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strPupilsHispanicPercent() {
		return pupilsHispanicPercent == null ? "" : pupilsHispanicPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 8
	 * HtmlCell: 2
	 * DisplayName.enUS: Black female
	 */ 
	protected void _pupilsBlackFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 8
	 * HtmlCell: 1
	 * DisplayName.enUS: Black male
	 */ 
	protected void _pupilsBlackMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 8
	 * HtmlCell: 3
	 * DisplayName.enUS: Blacks total
	 */ 
	protected void _pupilsBlackTotal(Wrap<Long> c) {
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
	@Override public String strPupilsBlackPercent() {
		return pupilsBlackPercent == null ? "" : pupilsBlackPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 9
	 * HtmlCell: 2
	 * DisplayName.enUS: White female
	 */ 
	protected void _pupilsWhiteFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 9
	 * HtmlCell: 1
	 * DisplayName.enUS: White male
	 */ 
	protected void _pupilsWhiteMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 9
	 * HtmlCell: 3
	 * DisplayName.enUS: Whites total
	 */ 
	protected void _pupilsWhiteTotal(Wrap<Long> c) {
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
	@Override public String strPupilsWhitePercent() {
		return pupilsWhitePercent == null ? "" : pupilsWhitePercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 10
	 * HtmlCell: 2
	 * DisplayName.enUS: Pacific Islander female
	 */ 
	protected void _pupilsPacificIslanderFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 10
	 * HtmlCell: 1
	 * DisplayName.enUS: Pacific Islander male
	 */ 
	protected void _pupilsPacificIslanderMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 10
	 * HtmlCell: 3
	 * DisplayName.enUS: Pacific Islanders total
	 */ 
	protected void _pupilsPacificIslanderTotal(Wrap<Long> c) {
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
	@Override public String strPupilsPacificIslanderPercent() {
		return pupilsPacificIslanderPercent == null ? "" : pupilsPacificIslanderPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 11
	 * HtmlCell: 2
	 * DisplayName.enUS: Multi Racial female
	 */ 
	protected void _pupilsMultiRacialFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 11
	 * HtmlCell: 1
	 * DisplayName.enUS: Multi Racial male
	 */ 
	protected void _pupilsMultiRacialMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 11
	 * HtmlCell: 4
	 * DisplayName.enUS: Multi Racial total
	 */ 
	protected void _pupilsMultiRacialTotal(Wrap<Long> c) {
		if(pupilsMultiRacialFemale != null  && pupilsMultiRacialMale != null)
			c.o(pupilsMultiRacialFemale + pupilsMultiRacialMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 11
	 * HtmlCell: 5
	 * DisplayName.enUS: Multi Racial percent
	 */ 
	protected void _pupilsMultiRacialPercent(Wrap<BigDecimal> c) {
		if(pupilsMultiRacialFemale != null  && pupilsMultiRacialMale != null
				&& pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(pupilsMultiRacialFemale).add(new BigDecimal(pupilsMultiRacialMale)).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strPupilsMultiRacialPercent() {
		return pupilsMultiRacialPercent == null ? "" : pupilsMultiRacialPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _pupilsOtherPercent(Wrap<BigDecimal> c) {
		BigDecimal othersTotal = BigDecimal.ZERO;
		if(pupilsTotal != null && pupilsTotal > 0) {
			if(pupilsMultiRacialFemale != null  && pupilsMultiRacialMale != null)
				othersTotal = othersTotal.add(new BigDecimal(pupilsMultiRacialFemale)).add(new BigDecimal(pupilsMultiRacialMale));
			if(pupilsAsianFemale != null  && pupilsAsianMale != null)
				othersTotal = othersTotal.add(new BigDecimal(pupilsAsianFemale)).add(new BigDecimal(pupilsAsianMale));
			if(pupilsHispanicFemale != null  && pupilsHispanicMale != null)
				othersTotal = othersTotal.add(new BigDecimal(pupilsHispanicFemale)).add(new BigDecimal(pupilsHispanicMale));
			if(pupilsPacificIslanderFemale != null  && pupilsPacificIslanderMale != null)
				othersTotal = othersTotal.add(new BigDecimal(pupilsPacificIslanderFemale)).add(new BigDecimal(pupilsPacificIslanderMale));
			if(pupilsIndianFemale != null  && pupilsIndianMale != null)
				othersTotal = othersTotal.add(new BigDecimal(pupilsIndianFemale)).add(new BigDecimal(pupilsIndianMale));
			c.o(othersTotal.divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
		}
	}
	@Override public String strPupilsOtherPercent() {
		return pupilsOtherPercent == null ? "" : pupilsOtherPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/////////////////////////////////////////////////////////
	// http://apps.schools.nc.gov/ords/f?p=145:109:::NO::: //
	/////////////////////////////////////////////////////////

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 12
	 * HtmlCell: 2
	 * DisplayName.enUS: male teachers total
	 */ 
	protected void _teachersMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 12
	 * HtmlCell: 3
	 * DisplayName.enUS: female teachers total
	 */ 
	protected void _teachersFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 12
	 * HtmlCell: 4
	 * DisplayName.enUS: teachers total
	 */ 
	protected void _teachersTotal(Wrap<Long> c) {
		if(teachersFemale != null  && teachersMale != null)
			c.o(teachersFemale + teachersMale);
	}
	@Override
	public String strTeachersTotal() {
		return teachersTotal == null ? "" : new DecimalFormat("#,##0").format(teachersTotal);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 13
	 * HtmlCell: 2
	 * DisplayName.enUS: White teachers
	 */ 
	protected void _teachersWhiteTotal(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 13
	 * HtmlCell: 3
	 * DisplayName.enUS: White teachers percent
	 */ 
	protected void _teachersWhitePercent(Wrap<BigDecimal> c) {
		if(teachersWhiteTotal != null
				&& teachersTotal != null && teachersTotal > 0)
			c.o(new BigDecimal(teachersWhiteTotal).divide(new BigDecimal(teachersTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strTeachersWhitePercent() {
		return teachersWhitePercent == null ? "" : teachersWhitePercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 13
	 * HtmlCell: 4
	 * DisplayName.enUS: Black teachers
	 */ 
	protected void _teachersBlackTotal(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 13
	 * HtmlCell: 5
	 * DisplayName.enUS: Black teachers percent
	 */ 
	protected void _teachersBlackPercent(Wrap<BigDecimal> c) {
		if(teachersBlackTotal != null
				&& teachersTotal != null && teachersTotal > 0)
			c.o(new BigDecimal(teachersBlackTotal).divide(new BigDecimal(teachersTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strTeachersBlackPercent() {
		return teachersBlackPercent == null ? "" : teachersBlackPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 13
	 * HtmlCell: 6
	 * DisplayName.enUS: Other teachers
	 */ 
	protected void _teachersOtherTotal(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 13
	 * HtmlCell: 7
	 * DisplayName.enUS: Others percent
	 */ 
	protected void _teachersOtherPercent(Wrap<BigDecimal> c) {
		if(teachersOtherTotal != null
				&& teachersTotal != null && teachersTotal > 0)
			c.o(new BigDecimal(teachersOtherTotal).divide(new BigDecimal(teachersTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strTeachersOtherPercent() {
		return teachersOtherPercent == null ? "" : teachersOtherPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	////////////////////////////////////////////////////////////////////////////////
	// https://www.nccourts.gov/programs/school-justice-partnership/sjp-resources //
	////////////////////////////////////////////////////////////////////////////////

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 14
	 * HtmlCell: 1
	 * DisplayName.enUS: delinquent complaints total
	 */ 
	protected void _delinquentComplaintsTotal(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 14
	 * HtmlCell: 2
	 * DisplayName.enUS: delinquent complaints at school
	 */ 
	protected void _delinquentComplaintsAtSchool(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 14
	 * HtmlCell: 3
	 * DisplayName.enUS: delinquent complaints at school percent
	 */ 
	protected void _delinquentComplaintsAtSchoolPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsAtSchool != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsAtSchool).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsAtSchoolPercent() {
		return delinquentComplaintsAtSchoolPercent == null ? "" : delinquentComplaintsAtSchoolPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 15
	 * HtmlCell: 3
	 * DisplayName.enUS: Asian complaints
	 */ 
	protected void _delinquentComplaintsAsian(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 15
	 * HtmlCell: 4
	 * DisplayName.enUS: Asian complaints percent
	 */ 
	protected void _delinquentComplaintsAsianPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsAsian != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsAsian).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsAsianPercent() {
		return delinquentComplaintsAsianPercent == null ? "" : delinquentComplaintsAsianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 15
	 * HtmlCell: 5
	 * DisplayName.enUS: Black complaints
	 */ 
	protected void _delinquentComplaintsBlack(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 15
	 * HtmlCell: 6
	 * DisplayName.enUS: Black complaints percent
	 */ 
	protected void _delinquentComplaintsBlackPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsBlack != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsBlack).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsBlackPercent() {
		return delinquentComplaintsBlackPercent == null ? "" : delinquentComplaintsBlackPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 16
	 * HtmlCell: 1
	 * DisplayName.enUS: Latinx complaints
	 */ 
	protected void _delinquentComplaintsHispanic(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 16
	 * HtmlCell: 2
	 * DisplayName.enUS: Latinx complaints percent
	 */ 
	protected void _delinquentComplaintsHispanicPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsHispanic != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsHispanic).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsHispanicPercent() {
		return delinquentComplaintsHispanicPercent == null ? "" : delinquentComplaintsHispanicPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 16
	 * HtmlCell: 3
	 * DisplayName.enUS: Multi Racial complaints
	 */ 
	protected void _delinquentComplaintsMultiRacial(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 16
	 * HtmlCell: 4
	 * DisplayName.enUS: Multi Racial complaints percent
	 */ 
	protected void _delinquentComplaintsMultiRacialPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsMultiRacial != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsMultiRacial).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsMultiRacialPercent() {
		return delinquentComplaintsMultiRacialPercent == null ? "" : delinquentComplaintsMultiRacialPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 16
	 * HtmlCell: 5
	 * DisplayName.enUS: First Nation complaints
	 */ 
	protected void _delinquentComplaintsIndian(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 16
	 * HtmlCell: 6
	 * DisplayName.enUS: First Nation complaints percent
	 */ 
	protected void _delinquentComplaintsIndianPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsIndian != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsIndian).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsIndianPercent() {
		return delinquentComplaintsIndianPercent == null ? "" : delinquentComplaintsIndianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 17
	 * HtmlCell: 1
	 * DisplayName.enUS: White complaints
	 */ 
	protected void _delinquentComplaintsWhite(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 17
	 * HtmlCell: 2
	 * DisplayName.enUS: White complaints percent
	 */ 
	protected void _delinquentComplaintsWhitePercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsWhite != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsWhite).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsWhitePercent() {
		return delinquentComplaintsWhitePercent == null ? "" : delinquentComplaintsWhitePercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 17
	 * HtmlCell: 3
	 * DisplayName.enUS: Pacific Islander complaints
	 */ 
	protected void _delinquentComplaintsPacificIslander(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 17
	 * HtmlCell: 4
	 * DisplayName.enUS: Pacific Islander complaints percent
	 */ 
	protected void _delinquentComplaintsPacificIslanderPercent(Wrap<BigDecimal> c) {
		if(delinquentComplaintsPacificIslander != null 
				&& delinquentComplaintsTotal != null && delinquentComplaintsTotal > 0)
			c.o(new BigDecimal(delinquentComplaintsPacificIslander).divide(new BigDecimal(delinquentComplaintsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strDelinquentComplaintsPacificIslanderPercent() {
		return delinquentComplaintsPacificIslanderPercent == null ? "" : delinquentComplaintsPacificIslanderPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// https://www.dpi.nc.gov/data-reports/dropout-and-discipline-data/discipline-alp-and-dropout-annual-reports //
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 18
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspension rate
	 */ 
	protected void _shortTermSuspensionRate(Wrap<Long> c) {
	}
	@Override
	public String strShortTermSuspensionRate() {
		return shortTermSuspensionRate == null ? "" : new DecimalFormat("#.00").format(shortTermSuspensionRate);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 18
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions total
	 */ 
	protected void _shortTermSuspensionsTotal(Wrap<Long> c) {
	}
	@Override
	public String strShortTermSuspensionsTotal() {
		return shortTermSuspensionsTotal == null ? "" : new DecimalFormat("#,##0").format(shortTermSuspensionsTotal);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 18
	 * HtmlCell: 3
	 * DisplayName.enUS: long-term suspensions total
	 */ 
	protected void _longTermSuspensionsTotal(Wrap<Long> c) {
	}
	@Override
	public String strLongTermSuspensionsTotal() {
		return longTermSuspensionsTotal == null ? "" : new DecimalFormat("#,##0").format(longTermSuspensionsTotal);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 18
	 * HtmlCell: 4
	 * DisplayName.enUS: expulsions total
	 */ 
	protected void _expulsionsTotal(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 19
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions Asian female
	 */ 
	protected void _shortTermSuspensionsAsianFemale(Wrap<Long> c) {
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 19
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions Asian male
	 */ 
	protected void _shortTermSuspensionsAsianMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 19
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Asians total
	 */ 
	protected void _shortTermSuspensionsAsianTotal(Wrap<Long> c) {
		if(shortTermSuspensionsAsianFemale != null  && shortTermSuspensionsAsianMale != null)
			c.o(shortTermSuspensionsAsianFemale + shortTermSuspensionsAsianMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 19
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Asians percent
	 */ 
	protected void _shortTermSuspensionsAsianPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsAsianFemale != null  && shortTermSuspensionsAsianMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsAsianFemale).add(new BigDecimal(shortTermSuspensionsAsianMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsAsianPercent() {
		return shortTermSuspensionsAsianPercent == null ? "" : shortTermSuspensionsAsianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 19
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Asians rate
	 */ 
	protected void _shortTermSuspensionsAsianRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsAsianTotal != null && pupilsAsianTotal != null && pupilsAsianTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsAsianTotal).divide(new BigDecimal(pupilsAsianTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsAsianRate() {
		return shortTermSuspensionsAsianRate == null ? "" : shortTermSuspensionsAsianRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 20
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions Black female
	 */ 
	protected void _shortTermSuspensionsBlackFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 20
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions Black male
	 */ 
	protected void _shortTermSuspensionsBlackMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 20
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Blacks total
	 */ 
	protected void _shortTermSuspensionsBlackTotal(Wrap<Long> c) {
		if(shortTermSuspensionsBlackFemale != null  && shortTermSuspensionsBlackMale != null)
			c.o(shortTermSuspensionsBlackFemale + shortTermSuspensionsBlackMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 20
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Blacks percent
	 */ 
	protected void _shortTermSuspensionsBlackPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsBlackFemale != null  && shortTermSuspensionsBlackMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsBlackFemale).add(new BigDecimal(shortTermSuspensionsBlackMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsBlackPercent() {
		return shortTermSuspensionsBlackPercent == null ? "" : shortTermSuspensionsBlackPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 20
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Blacks rate
	 */ 
	protected void _shortTermSuspensionsBlackRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsBlackTotal != null && pupilsBlackTotal != null && pupilsBlackTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsBlackTotal).divide(new BigDecimal(pupilsBlackTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsBlackRate() {
		return shortTermSuspensionsBlackRate == null ? "" : shortTermSuspensionsBlackRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 21
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions Latinx female
	 */ 
	protected void _shortTermSuspensionsHispanicFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 21
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions Latinx male
	 */ 
	protected void _shortTermSuspensionsHispanicMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 21
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Latinx total
	 */ 
	protected void _shortTermSuspensionsHispanicTotal(Wrap<Long> c) {
		if(shortTermSuspensionsHispanicFemale != null  && shortTermSuspensionsHispanicMale != null)
			c.o(shortTermSuspensionsHispanicFemale + shortTermSuspensionsHispanicMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 21
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Latinx percent
	 */ 
	protected void _shortTermSuspensionsHispanicPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsHispanicFemale != null  && shortTermSuspensionsHispanicMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsHispanicFemale).add(new BigDecimal(shortTermSuspensionsHispanicMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsHispanicPercent() {
		return shortTermSuspensionsHispanicPercent == null ? "" : shortTermSuspensionsHispanicPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 21
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Latinx rate
	 */ 
	protected void _shortTermSuspensionsHispanicRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsHispanicTotal != null && pupilsHispanicTotal != null && pupilsHispanicTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsHispanicTotal).divide(new BigDecimal(pupilsHispanicTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsHispanicRate() {
		return shortTermSuspensionsHispanicRate == null ? "" : shortTermSuspensionsHispanicRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 22
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions First Nation female
	 */ 
	protected void _shortTermSuspensionsIndianFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 22
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions First Nation male
	 */  
	protected void _shortTermSuspensionsIndianMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 22
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions First Nation total
	 */ 
	protected void _shortTermSuspensionsIndianTotal(Wrap<Long> c) {
		if(shortTermSuspensionsIndianFemale != null  && shortTermSuspensionsIndianMale != null)
			c.o(shortTermSuspensionsIndianFemale + shortTermSuspensionsIndianMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 22
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions First Nation percent
	 */ 
	protected void _shortTermSuspensionsIndianPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsIndianFemale != null  && shortTermSuspensionsIndianMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsIndianFemale).add(new BigDecimal(shortTermSuspensionsIndianMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsIndianPercent() {
		return shortTermSuspensionsIndianPercent == null ? "" : shortTermSuspensionsIndianPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 22
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions First Nation rate
	 */ 
	protected void _shortTermSuspensionsIndianRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsIndianTotal != null && pupilsIndianTotal != null && pupilsIndianTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsIndianTotal).divide(new BigDecimal(pupilsIndianTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsIndianRate() {
		return shortTermSuspensionsIndianRate == null ? "" : shortTermSuspensionsIndianRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 23
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions Multi Racial female
	 */ 
	protected void _shortTermSuspensionsMultiRacialFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 23
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions Multi Racial male
	 */ 
	protected void _shortTermSuspensionsMultiRacialMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 23
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Multi Racial total
	 */ 
	protected void _shortTermSuspensionsMultiRacialTotal(Wrap<Long> c) {
		if(shortTermSuspensionsMultiRacialFemale != null  && shortTermSuspensionsMultiRacialMale != null)
			c.o(shortTermSuspensionsMultiRacialFemale + shortTermSuspensionsMultiRacialMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 23
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Multi Racial percent
	 */ 
	protected void _shortTermSuspensionsMultiRacialPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsMultiRacialFemale != null  && shortTermSuspensionsMultiRacialMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsMultiRacialFemale).add(new BigDecimal(shortTermSuspensionsMultiRacialMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsMultiRacialPercent() {
		return shortTermSuspensionsMultiRacialPercent == null ? "" : shortTermSuspensionsMultiRacialPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 23
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Multi Racial rate
	 */ 
	protected void _shortTermSuspensionsMultiRacialRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsMultiRacialTotal != null && pupilsMultiRacialTotal != null && pupilsMultiRacialTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsMultiRacialTotal).divide(new BigDecimal(pupilsMultiRacialTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsMultiRacialRate() {
		return shortTermSuspensionsMultiRacialRate == null ? "" : shortTermSuspensionsMultiRacialRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 24
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions Pacific Islander female
	 */ 
	protected void _shortTermSuspensionsPacificIslanderFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 24
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions Pacific Islander male
	 */ 
	protected void _shortTermSuspensionsPacificIslanderMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 24
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Pacific Islanders total
	 */ 
	protected void _shortTermSuspensionsPacificIslanderTotal(Wrap<Long> c) {
		if(shortTermSuspensionsPacificIslanderFemale != null  && shortTermSuspensionsPacificIslanderMale != null)
			c.o(shortTermSuspensionsPacificIslanderFemale + shortTermSuspensionsPacificIslanderMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 24
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Pacific Islanders percent
	 */ 
	protected void _shortTermSuspensionsPacificIslanderPercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsPacificIslanderFemale != null  && shortTermSuspensionsPacificIslanderMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsPacificIslanderFemale).add(new BigDecimal(shortTermSuspensionsPacificIslanderMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsPacificIslanderPercent() {
		return shortTermSuspensionsPacificIslanderPercent == null ? "" : shortTermSuspensionsPacificIslanderPercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 24
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Pacific Islanders rate
	 */ 
	protected void _shortTermSuspensionsPacificIslanderRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsPacificIslanderTotal != null && shortTermSuspensionsTotal != null && pupilsPacificIslanderTotal != null && pupilsPacificIslanderTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsPacificIslanderTotal).divide(new BigDecimal(pupilsPacificIslanderTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsPacificIslanderRate() {
		return shortTermSuspensionsPacificIslanderRate == null ? "" : shortTermSuspensionsPacificIslanderRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 25
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions White female
	 */ 
	protected void _shortTermSuspensionsWhiteFemale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 25
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions White male
	 */ 
	protected void _shortTermSuspensionsWhiteMale(Wrap<Long> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 25
	 * HtmlCell: 3
	 * DisplayName.enUS: short-term suspensions Whites total
	 */ 
	protected void _shortTermSuspensionsWhiteTotal(Wrap<Long> c) {
		if(shortTermSuspensionsWhiteFemale != null  && shortTermSuspensionsWhiteMale != null)
			c.o(shortTermSuspensionsWhiteFemale + shortTermSuspensionsWhiteMale);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 25
	 * HtmlCell: 4
	 * DisplayName.enUS: short-term suspensions Whites percent
	 */ 
	protected void _shortTermSuspensionsWhitePercent(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsWhiteFemale != null  && shortTermSuspensionsWhiteMale != null
				&& shortTermSuspensionsTotal != null && shortTermSuspensionsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsWhiteFemale).add(new BigDecimal(shortTermSuspensionsWhiteMale)).divide(new BigDecimal(shortTermSuspensionsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsWhitePercent() {
		return shortTermSuspensionsWhitePercent == null ? "" : shortTermSuspensionsWhitePercent.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 25
	 * HtmlCell: 5
	 * DisplayName.enUS: short-term suspensions Whites rate
	 */ 
	protected void _shortTermSuspensionsWhiteRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsWhiteTotal != null && pupilsWhiteTotal != null && pupilsWhiteTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsWhiteTotal).divide(new BigDecimal(pupilsWhiteTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsWhiteRate() {
		return shortTermSuspensionsWhiteRate == null ? "" : shortTermSuspensionsWhiteRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 26
	 * HtmlCell: 1
	 * DisplayName.enUS: short-term suspensions all rate
	 */ 
	protected void _shortTermSuspensionsAllRate(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsTotal != null && pupilsTotal != null && pupilsTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsTotal).divide(new BigDecimal(pupilsTotal), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsAllRate() {
		return shortTermSuspensionsAllRate == null ? "" : shortTermSuspensionsAllRate.setScale(1, RoundingMode.CEILING).toString();
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * HtmlRow: 26
	 * HtmlCell: 2
	 * DisplayName.enUS: short-term suspensions black vs white
	 */ 
	protected void _shortTermSuspensionsBlackVsWhite(Wrap<BigDecimal> c) {
		if(shortTermSuspensionsBlackTotal != null  && shortTermSuspensionsWhiteTotal != null && shortTermSuspensionsWhiteTotal > 0)
			c.o(new BigDecimal(shortTermSuspensionsBlackTotal).divide(new BigDecimal(shortTermSuspensionsWhiteTotal), 4, RoundingMode.HALF_UP).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strShortTermSuspensionsBlackVsWhite() {
		return shortTermSuspensionsBlackVsWhite == null ? "" : shortTermSuspensionsBlackVsWhite.setScale(1, RoundingMode.CEILING).toString();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// https://www.dpi.nc.gov/districts-schools/testing-and-school-accountability/school-accountability-and-reporting/accountability-data-sets-and-reports#2018%E2%80%9319-reports //
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 27
	 * HtmlCell: 1
	 * DisplayName.enUS: College ready exams grades 3-8 overall
	 */ 
	protected void _examsCollegeReadyGrades38OverallPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 27
	 * HtmlCell: 2
	 * DisplayName.enUS: College ready exams grades 3-8 first nation
	 */ 
	protected void _examsCollegeReadyGrades38IndianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 27
	 * HtmlCell: 3
	 * DisplayName.enUS: College ready exams grades 3-8 asian
	 */ 
	protected void _examsCollegeReadyGrades38AsianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 27
	 * HtmlCell: 4
	 * DisplayName.enUS: College ready exams grades 3-8 black
	 */ 
	protected void _examsCollegeReadyGrades38BlackPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 28
	 * HtmlCell: 1
	 * DisplayName.enUS: College ready exams grades 3-8 hispanic
	 */ 
	protected void _examsCollegeReadyGrades38HispanicPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 28
	 * HtmlCell: 2
	 * DisplayName.enUS: College ready exams grades 3-8 multi-racial
	 */ 
	protected void _examsCollegeReadyGrades38MultiRacialPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 28
	 * HtmlCell: 3
	 * DisplayName.enUS: College ready exams grades 3-8 pacific islander
	 */ 
	protected void _examsCollegeReadyGrades38PacificIslanderPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 28
	 * HtmlCell: 4
	 * DisplayName.enUS: College ready exams grades 3-8 white
	 */ 
	protected void _examsCollegeReadyGrades38WhitePercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 29
	 * HtmlCell: 1
	 * DisplayName.enUS: College ready exams grades 9-12 overall
	 */ 
	protected void _examsCollegeReadyGrades912OverallPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 29
	 * HtmlCell: 2
	 * DisplayName.enUS: College ready exams grades 9-12 first nation
	 */ 
	protected void _examsCollegeReadyGrades912IndianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 29
	 * HtmlCell: 3
	 * DisplayName.enUS: College ready exams grades 9-12 asian
	 */ 
	protected void _examsCollegeReadyGrades912AsianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 29
	 * HtmlCell: 4
	 * DisplayName.enUS: College ready exams grades 9-12 black
	 */ 
	protected void _examsCollegeReadyGrades912BlackPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 30
	 * HtmlCell: 1
	 * DisplayName.enUS: College ready exams grades 9-12 hispanic
	 */ 
	protected void _examsCollegeReadyGrades912HispanicPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 30
	 * HtmlCell: 2
	 * DisplayName.enUS: College ready exams grades 9-12 multi-racial
	 */ 
	protected void _examsCollegeReadyGrades912MultiRacialPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 30
	 * HtmlCell: 3
	 * DisplayName.enUS: College ready exams grades 9-12 pacific islander
	 */ 
	protected void _examsCollegeReadyGrades912PacificIslanderPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 30
	 * HtmlCell: 4
	 * DisplayName.enUS: College ready exams grades 9-12 white
	 */ 
	protected void _examsCollegeReadyGrades912WhitePercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 31
	 * HtmlCell: 1
	 * DisplayName.enUS: Graduate HS within 4 years overall
	 */ 
	protected void _graduateWithin4YearsOverallPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 31
	 * HtmlCell: 2
	 * DisplayName.enUS: Graduate HS within 4 years first nation
	 */ 
	protected void _graduateWithin4YearsIndianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 31
	 * HtmlCell: 3
	 * DisplayName.enUS: Graduate HS within 4 years asian
	 */ 
	protected void _graduateWithin4YearsAsianPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 31
	 * HtmlCell: 4
	 * DisplayName.enUS: Graduate HS within 4 years black
	 */ 
	protected void _graduateWithin4YearsBlackPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 32
	 * HtmlCell: 1
	 * DisplayName.enUS: Graduate HS within 4 years hispanic
	 */ 
	protected void _graduateWithin4YearsHispanicPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 32
	 * HtmlCell: 2
	 * DisplayName.enUS: Graduate HS within 4 years multi-racial
	 */ 
	protected void _graduateWithin4YearsMultiRacialPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 32
	 * HtmlCell: 3
	 * DisplayName.enUS: Graduate HS within 4 years pacific islander
	 */ 
	protected void _graduateWithin4YearsPacificIslanderPercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 32
	 * HtmlCell: 4
	 * DisplayName.enUS: Graduate HS within 4 years white
	 */ 
	protected void _graduateWithin4YearsWhitePercent(Wrap<BigDecimal> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * DisplayName.enUS: short-term suspensions black vs white
	 */ 
	protected void _examsCollegeReadyGrades38BlackVsWhite(Wrap<BigDecimal> c) {
		if(examsCollegeReadyGrades38BlackPercent != null  && examsCollegeReadyGrades38WhitePercent != null)
			c.o(examsCollegeReadyGrades38WhitePercent.divide(examsCollegeReadyGrades38BlackPercent, 4, RoundingMode.HALF_UP).setScale(1, RoundingMode.HALF_UP));
	}
	@Override public String strExamsCollegeReadyGrades38BlackVsWhite() {
		return examsCollegeReadyGrades38BlackVsWhite == null ? "" : examsCollegeReadyGrades38BlackVsWhite.setScale(1, RoundingMode.CEILING).toString();
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateKey(Wrap<Long> c) {
		if(agency_ != null)
			c.o(agency_.getStateKey());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateId(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getStateId());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _agencyId(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getObjectId());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateName(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getStateName());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _stateAbbreviation(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getStateAbbreviation());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _agencyName(Wrap<String> c) {
		if(agency_ != null)
			c.o(agency_.getAgencyName());
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarH2: true
	 * VarTitle: true
	 */ 
	protected void _agencyCompleteName(Wrap<String> c) {
		c.o(reportCardStartYear + "-" + reportCardEndYear + " report card in " + agencyName + " in " + stateName + " (" + stateAbbreviation + ")");
	}

	/**
	 * {@inheritDoc}
	 */ 
	protected void _reportCardNumber_(Wrap<Integer> c) {}

	/**
	 * {@inheritDoc}
	 */ 
	protected void _reportCardStates_(List<ReportCard> l) {}

	/**
	 * {@inheritDoc}
	 */ 
	protected void _reportCardAgencies_(List<ReportCard> l) {}

	/**   
	 * {@inheritDoc}
	 */ 
	protected void _reportCardReportCards_(List<ReportCard> l) {}

	////////////
	// Graphs //
	////////////

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyDemographicsGraph(Wrap<String> w) {
		try {
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue( String.format("%s (%s%%)", "American Indian", pupilsIndianPercent), pupilsIndianPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Asian", pupilsAsianPercent), pupilsAsianPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Black", pupilsBlackPercent), pupilsBlackPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Hispanic", pupilsHispanicPercent), pupilsHispanicPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Multi-Racial", pupilsMultiRacialPercent), pupilsMultiRacialPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Pacific Islander", pupilsPacificIslanderPercent), pupilsPacificIslanderPercent );  
			dataset.setValue( String.format("%s (%s%%)", "White", pupilsWhitePercent), pupilsWhitePercent );  
	
			JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, false, false);
			PiePlot plot = (PiePlot)chart.getPlot();
	
			LegendTitle legendOld = chart.getLegend();
			LegendTitle legendNew = new LegendTitle(plot, new ColumnArrangement(), new ColumnArrangement());
			legendNew.setPosition(legendOld.getPosition());
			legendNew.setBackgroundPaint(legendOld.getBackgroundPaint());
			legendNew.setItemFont(new Font(Font.SANS_SERIF, 0, 24));
			plot.setLegendItemShape(new Rectangle(24, 24));
			chart.removeLegend();
			chart.addLegend(legendNew);
			plot.setBackgroundPaint(null);
			plot.setOutlinePaint(null);
			plot.setShadowPaint(null);
	
			plot.setLabelGenerator(null);
			plot.setSectionPaint(dataset.getKey(0), Color.decode("#8064a2"));
			plot.setSectionPaint(dataset.getKey(1), Color.decode("#308399"));
			plot.setSectionPaint(dataset.getKey(2), Color.decode("#e97000"));
			plot.setSectionPaint(dataset.getKey(3), Color.decode("#77933c"));
			plot.setSectionPaint(dataset.getKey(4), Color.decode("#254061"));
			plot.setSectionPaint(dataset.getKey(5), Color.decode("#edda38"));
			plot.setSectionPaint(dataset.getKey(6), Color.decode("#a84039"));

			ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
			BufferedImage image = chart.createBufferedImage(400, 600, chartRenderingInfo);

			ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
				@Override
				public String generateToolTipFragment(String toolTipText) {
					return super.generateToolTipFragment(toolTipText);
				}
			};
			URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
				@Override
				public String generateURLFragment(String urlText) {
					// TODO Auto-generated method stub
					return super.generateURLFragment(urlText);
				}
			};

			String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));

			StringBuilder b = new StringBuilder();
			b.append("                  ").append(imageMap).append("\n");
			b.append("                  <img usemap=\"#map_").append(w.var).append("\" style=\"width: 200px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
			w.o(b.toString());
		} catch (IOException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyStudentsByRaceGraph(Wrap<String> w) {
		if(pupilsWhitePercent != null && pupilsBlackPercent != null && pupilsOtherPercent != null) {
			try {
				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue( String.format("%s%%", pupilsWhitePercent.setScale(0, RoundingMode.HALF_UP)), pupilsWhitePercent );  
				dataset.setValue( String.format("%s%%", pupilsBlackPercent.setScale(0, RoundingMode.HALF_UP)), pupilsBlackPercent );  
				dataset.setValue( String.format("%s%%", pupilsOtherPercent.setScale(0, RoundingMode.HALF_UP)), pupilsOtherPercent );  
	
				JFreeChart chart = ChartFactory.createRingChart(null, dataset, true, false, false);
				RingPlot plot = (RingPlot)chart.getPlot();
	
				chart.removeLegend();
				plot.setBackgroundPaint(null);
				plot.setOutlinePaint(null);
	
				plot.setLabelGap(0D);
				plot.setSimpleLabels(true);
				plot.setLabelFont(new Font(Font.SANS_SERIF, 0, 24));
				plot.setLabelBackgroundPaint(null);
				plot.setLabelShadowPaint(null);
				plot.setLabelOutlinePaint(null);
				plot.setShadowPaint(null);
				plot.setSectionDepth(0.5);
				plot.setSimpleLabelOffset(new RectangleInsets(UnitType.RELATIVE, 0.12, 0.12, 0.12, 0.12));
				plot.setSectionPaint(dataset.getKey(0), Color.decode("#a84039"));
				plot.setSectionPaint(dataset.getKey(1), Color.decode("#e97000"));
				plot.setSectionPaint(dataset.getKey(2), Color.decode("#00b0f0"));
				plot.setOutlinePaint(Color.WHITE);
				plot.setOutlineStroke(new BasicStroke(4));
				plot.setDefaultSectionOutlinePaint(Color.WHITE);
				plot.setDefaultSectionOutlineStroke(new BasicStroke(4));
				plot.setSeparatorsVisible(false);
	
				ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
				BufferedImage image = chart.createBufferedImage(400, 400, chartRenderingInfo);
	
				ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
					@Override
					public String generateToolTipFragment(String toolTipText) {
						return super.generateToolTipFragment(toolTipText);
					}
				};
				URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
					@Override
					public String generateURLFragment(String urlText) {
						// TODO Auto-generated method stub
						return super.generateURLFragment(urlText);
					}
				};
	
				String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "png", baos);
				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();
	
				String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));
	
				StringBuilder b = new StringBuilder();
				b.append("                  ").append(imageMap).append("\n");
				b.append("                  <img usemap=\"#map_").append(w.var).append("\" style=\"width: 200px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
				w.o(b.toString());
			} catch (NumberFormatException | IOException ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyTeachersByRaceGraph(Wrap<String> w) {
		w.o(new String(Base64.getEncoder().encode(new byte[] {}), Charset.forName("UTF-8")));
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyGrades3To8Graph(Wrap<String> w) {
		try {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.addValue( examsCollegeReadyGrades38IndianPercent, "First Nation", "First Nation" );  
			dataset.addValue( examsCollegeReadyGrades38AsianPercent, "Asian", "Asian" );  
			dataset.addValue( examsCollegeReadyGrades38BlackPercent, "Black", "Black" );  
			dataset.addValue( examsCollegeReadyGrades38HispanicPercent, "Hispanic", "Hispanic" );  
			dataset.addValue( examsCollegeReadyGrades38MultiRacialPercent, "Multi-Racial", "Multi-Racial" );  
			dataset.addValue( examsCollegeReadyGrades38PacificIslanderPercent, "Pacific Islander", "Pacific Islander" );  
			dataset.addValue( examsCollegeReadyGrades38WhitePercent, "White", "White" );  
			dataset.addValue( examsCollegeReadyGrades38OverallPercent, "Overall", "Overall" );  
	
			JFreeChart chart = ChartFactory.createStackedBarChart(null, null, null, dataset, PlotOrientation.VERTICAL, true, true, true);
			CategoryPlot plot = (CategoryPlot)chart.getPlot();
	
			chart.removeLegend();
			plot.setBackgroundPaint(null);
			plot.setOutlinePaint(null);
	
			StackedBarRenderer renderer = (StackedBarRenderer)plot.getRenderer();

			renderer.setSeriesPaint(0, Color.decode("#8064a2"));
			renderer.setSeriesPaint(1, Color.decode("#308399"));
			renderer.setSeriesPaint(2, Color.decode("#e97000"));
			renderer.setSeriesPaint(3, Color.decode("#77933c"));
			renderer.setSeriesPaint(4, Color.decode("#254061"));
			renderer.setSeriesPaint(5, Color.decode("#edda38"));
			renderer.setSeriesPaint(6, Color.decode("#a84039"));
			renderer.setSeriesPaint(7, Color.decode("#7f7f7f"));

			ValueAxis axis = plot.getRangeAxis();
			axis.setUpperMargin(0.2);
			plot.getRangeAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getRangeAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			renderer.setItemLabelAnchorOffset(22);
			renderer.setItemMargin(0.0);
			renderer.setMaximumBarWidth(100.0);
			renderer.setShadowVisible(false);
			renderer.setBarPainter(new StandardBarPainter());

			renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setDefaultItemLabelsVisible(true);
			ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
			renderer.setDefaultPositiveItemLabelPosition(position);
			renderer.setDefaultItemLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
			BufferedImage image = chart.createBufferedImage(1000, 280, chartRenderingInfo);

			ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
				@Override
				public String generateToolTipFragment(String toolTipText) {
					return super.generateToolTipFragment(toolTipText);
				}
			};
			URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
				@Override
				public String generateURLFragment(String urlText) {
					// TODO Auto-generated method stub
					return super.generateURLFragment(urlText);
				}
			};

			String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));

			StringBuilder b = new StringBuilder();
			b.append("                  ").append(imageMap).append("\n");
			b.append("                  <img usemap=\"#map_").append(w.var).append("\" class=\"w3-image \" style=\"width: 500px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
			w.o(b.toString());
		} catch (IOException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyGrades9To12Graph(Wrap<String> w) {
		try {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.addValue( examsCollegeReadyGrades912IndianPercent, "First Nation", "First Nation" );  
			dataset.addValue( examsCollegeReadyGrades912AsianPercent, "Asian", "Asian" );  
			dataset.addValue( examsCollegeReadyGrades912BlackPercent, "Black", "Black" );  
			dataset.addValue( examsCollegeReadyGrades912HispanicPercent, "Hispanic", "Hispanic" );  
			dataset.addValue( examsCollegeReadyGrades912MultiRacialPercent, "Multi-Racial", "Multi-Racial" );  
			dataset.addValue( examsCollegeReadyGrades912PacificIslanderPercent, "Pacific Islander", "Pacific Islander" );  
			dataset.addValue( examsCollegeReadyGrades912WhitePercent, "White", "White" );  
			dataset.addValue( examsCollegeReadyGrades912OverallPercent, "Overall", "Overall" );  
	
			JFreeChart chart = ChartFactory.createStackedBarChart(null, null, null, dataset, PlotOrientation.VERTICAL, true, true, true);
			CategoryPlot plot = (CategoryPlot)chart.getPlot();
	
			chart.removeLegend();
			plot.setBackgroundPaint(null);
			plot.setOutlinePaint(null);
	
			StackedBarRenderer renderer = (StackedBarRenderer)plot.getRenderer();

			renderer.setSeriesPaint(0, Color.decode("#8064a2"));
			renderer.setSeriesPaint(1, Color.decode("#308399"));
			renderer.setSeriesPaint(2, Color.decode("#e97000"));
			renderer.setSeriesPaint(3, Color.decode("#77933c"));
			renderer.setSeriesPaint(4, Color.decode("#254061"));
			renderer.setSeriesPaint(5, Color.decode("#edda38"));
			renderer.setSeriesPaint(6, Color.decode("#a84039"));
			renderer.setSeriesPaint(7, Color.decode("#7f7f7f"));

			ValueAxis axis = plot.getRangeAxis();
			axis.setUpperMargin(0.2);
			plot.getRangeAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getRangeAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			renderer.setItemLabelAnchorOffset(22);
			renderer.setItemMargin(0.0);
			renderer.setMaximumBarWidth(100.0);
			renderer.setShadowVisible(false);
			renderer.setBarPainter(new StandardBarPainter());

			renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setDefaultItemLabelsVisible(true);
			ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
			renderer.setDefaultPositiveItemLabelPosition(position);
			renderer.setDefaultItemLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
			BufferedImage image = chart.createBufferedImage(1000, 280, chartRenderingInfo);

			ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
				@Override
				public String generateToolTipFragment(String toolTipText) {
					return super.generateToolTipFragment(toolTipText);
				}
			};
			URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
				@Override
				public String generateURLFragment(String urlText) {
					// TODO Auto-generated method stub
					return super.generateURLFragment(urlText);
				}
			};

			String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));

			StringBuilder b = new StringBuilder();
			b.append("                  ").append(imageMap).append("\n");
			b.append("                  <img usemap=\"#map_").append(w.var).append("\" class=\"w3-image \" style=\"width: 500px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
			w.o(b.toString());
		} catch (IOException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyGraduatesWithin4YearsGraph(Wrap<String> w) {
		try {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.addValue( graduateWithin4YearsIndianPercent, "First Nation", "First Nation" );  
			dataset.addValue( graduateWithin4YearsAsianPercent, "Asian", "Asian" );  
			dataset.addValue( graduateWithin4YearsBlackPercent, "Black", "Black" );  
			dataset.addValue( graduateWithin4YearsHispanicPercent, "Hispanic", "Hispanic" );  
			dataset.addValue( graduateWithin4YearsMultiRacialPercent, "Multi-Racial", "Multi-Racial" );  
			dataset.addValue( graduateWithin4YearsPacificIslanderPercent, "Pacific Islander", "Pacific Islander" );  
			dataset.addValue( graduateWithin4YearsWhitePercent, "White", "White" );  
			dataset.addValue( graduateWithin4YearsOverallPercent, "Overall", "Overall" );  
	
			JFreeChart chart = ChartFactory.createStackedBarChart(null, null, null, dataset, PlotOrientation.VERTICAL, true, true, true);
			CategoryPlot plot = (CategoryPlot)chart.getPlot();
	
			chart.removeLegend();
			plot.setBackgroundPaint(null);
			plot.setOutlinePaint(null);
	
			StackedBarRenderer renderer = (StackedBarRenderer)plot.getRenderer();

			renderer.setSeriesPaint(0, Color.decode("#8064a2"));
			renderer.setSeriesPaint(1, Color.decode("#308399"));
			renderer.setSeriesPaint(2, Color.decode("#e97000"));
			renderer.setSeriesPaint(3, Color.decode("#77933c"));
			renderer.setSeriesPaint(4, Color.decode("#254061"));
			renderer.setSeriesPaint(5, Color.decode("#edda38"));
			renderer.setSeriesPaint(6, Color.decode("#a84039"));
			renderer.setSeriesPaint(7, Color.decode("#7f7f7f"));

			ValueAxis axis = plot.getRangeAxis();
			axis.setUpperMargin(0.2);
			plot.getRangeAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getRangeAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setLabelFont(new Font(Font.SANS_SERIF, 0, 18));
			plot.getDomainAxis().setTickLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			renderer.setItemLabelAnchorOffset(22);
			renderer.setItemMargin(0.0);
			renderer.setMaximumBarWidth(100.0);
			renderer.setShadowVisible(false);
			renderer.setBarPainter(new StandardBarPainter());

			renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setDefaultItemLabelsVisible(true);
			ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
			renderer.setDefaultPositiveItemLabelPosition(position);
			renderer.setDefaultItemLabelFont(new Font(Font.SANS_SERIF, 0, 18));

			ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
			BufferedImage image = chart.createBufferedImage(1000, 280, chartRenderingInfo);

			ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
				@Override
				public String generateToolTipFragment(String toolTipText) {
					return super.generateToolTipFragment(toolTipText);
				}
			};
			URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
				@Override
				public String generateURLFragment(String urlText) {
					// TODO Auto-generated method stub
					return super.generateURLFragment(urlText);
				}
			};

			String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));

			StringBuilder b = new StringBuilder();
			b.append("                  ").append(imageMap).append("\n");
			b.append("                  <img usemap=\"#map_").append(w.var).append("\" class=\"w3-image \" style=\"width: 500px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
			w.o(b.toString());
		} catch (IOException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _suspensionsByRaceGraph(Wrap<String> w) {
		w.o(new String(Base64.getEncoder().encode(new byte[] {}), Charset.forName("UTF-8")));
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _suspensionRatesByRaceGraph(Wrap<String> w) {
		w.o(new String(Base64.getEncoder().encode(new byte[] {}), Charset.forName("UTF-8")));
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _countySchoolBasedComplaintsGraph(Wrap<String> w) {
		w.o(new String(Base64.getEncoder().encode(new byte[] {}), Charset.forName("UTF-8")));
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _schoolBasedComplaintsGraph(Wrap<String> w) {
		w.o(new String(Base64.getEncoder().encode(new byte[] {}), Charset.forName("UTF-8")));
	}

	/**   
	 * {@inheritDoc}
	 * Stored: true
	 */ 
	protected void _agencyStudentsByRaceGraph2(Wrap<String> w) {
		try {
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue( String.format("%s (%s%%)", "American Indian", pupilsIndianPercent), pupilsIndianPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Asian", pupilsAsianPercent), pupilsAsianPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Black", pupilsBlackPercent), pupilsBlackPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Hispanic", pupilsHispanicPercent), pupilsHispanicPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Multi-Racial", pupilsMultiRacialPercent), pupilsMultiRacialPercent );  
			dataset.setValue( String.format("%s (%s%%)", "Pacific Islander", pupilsPacificIslanderPercent), pupilsPacificIslanderPercent );  
			dataset.setValue( String.format("%s (%s%%)", "White", pupilsWhitePercent), pupilsWhitePercent );  
	
			JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, true);
			PiePlot plot = (PiePlot)chart.getPlot();
	
			LegendTitle legendOld = chart.getLegend();
			LegendTitle legendNew = new LegendTitle(plot, new ColumnArrangement(), new ColumnArrangement());
			legendNew.setPosition(RectangleEdge.RIGHT);
			legendNew.setBackgroundPaint(legendOld.getBackgroundPaint());
			legendNew.setItemFont(new Font(Font.SANS_SERIF, 0, 24));
			plot.setLegendItemShape(new Rectangle(24, 24));
			chart.removeLegend();
			chart.addLegend(legendNew);
			plot.setBackgroundPaint(null);
			plot.setOutlinePaint(null);
			plot.setURLGenerator(new PieURLGenerator() {
				
				@Override
				public String generateURL(PieDataset dataset, Comparable key, int pieIndex) {
					Number value = dataset.getValue(pieIndex);
					return null;
				}
			});
	
			plot.setLabelGenerator(null);
			plot.setSectionPaint(dataset.getKey(0), Color.decode("#8064a2"));
			plot.setSectionPaint(dataset.getKey(1), Color.decode("#308399"));
			plot.setSectionPaint(dataset.getKey(2), Color.decode("#e97000"));
			plot.setSectionPaint(dataset.getKey(3), Color.decode("#77933c"));
			plot.setSectionPaint(dataset.getKey(4), Color.decode("#254061"));
			plot.setSectionPaint(dataset.getKey(5), Color.decode("#edda38"));
			plot.setSectionPaint(dataset.getKey(6), Color.decode("#a84039"));
			ChartRenderingInfo chartRenderingInfo = new ChartRenderingInfo(new StandardEntityCollection());
			BufferedImage image = chart.createBufferedImage(600, 400, chartRenderingInfo);

			ToolTipTagFragmentGenerator toolTipFragmentGenerator = new StandardToolTipTagFragmentGenerator() {
				@Override
				public String generateToolTipFragment(String toolTipText) {
					return super.generateToolTipFragment(toolTipText);
				}
			};
			URLTagFragmentGenerator urlTagFragmentGenerator = new StandardURLTagFragmentGenerator() {
				@Override
				public String generateURLFragment(String urlText) {
					// TODO Auto-generated method stub
					return super.generateURLFragment(urlText);
				}
			};

			String imageMap = ImageMapUtils.getImageMap("map_" + w.var, chartRenderingInfo, toolTipFragmentGenerator, urlTagFragmentGenerator);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			String imageStr = new String(Base64.getEncoder().encode(imageInByte), Charset.forName("UTF-8"));

			StringBuilder b = new StringBuilder();
			b.append("                  ").append(imageMap).append("\n");
			b.append("                  <img usemap=\"#map_").append(w.var).append("\" style=\"width: 300px; \" src=\"data:image/png;base64,").append(imageStr).append("\"/>\n");
			w.o(b.toString());
		} catch (IOException ex) {
			ExceptionUtils.rethrow(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override() protected void  _objectTitle(Wrap<String> c) {
		c.o(reportCardStartYear + "-" + reportCardEndYear + " report card in " + agencyName + " agency in " + stateName + " (" + stateAbbreviation + ")");
	}
}
