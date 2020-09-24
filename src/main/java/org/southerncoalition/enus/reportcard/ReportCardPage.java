package org.southerncoalition.enus.reportcard;

/**
 * Translate: false
 **/
public class ReportCardPage extends ReportCardPageGen<ReportCardGenPage> {

	@Override public void htmlFormPageReportCard(ReportCard o) {
		{ e("div").a("class", "w3-padding ").f();
			{ e("a").a("href", siteBaseUrl, "/page/report-card-by-agency?var=agencyId:", reportCard_.getAgencyId(), "&var=reportCardStartYear:", reportCard_.getReportCardStartYear()).f();
				sx("View the ", reportCard_.getAgencyName(), " ", reportCard_.getReportCardYearsStr(), " report card");
			} g("a");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmReportCardStartYear("Page");
			o.htmReportCardEndYear("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgencyKey("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("h5").a("class", "w3-cell-row ").f().sx("Pupils in membership by race and sex").g("h5");
			{ e("div").a("class", "w3-cell-row ").f();
				sx("See ");
				e("a").a("href", "http://apps.schools.nc.gov/ords/f?p=145:15:::NO:::").a("target", "_blank").f().sx("http://apps.schools.nc.gov/ords/f?p=145:15:::NO:::").g("a");
			} g("div");
			}
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndianMale("Page");
			o.htmPupilsIndianFemale("Page");
			o.htmPupilsIndianTotal("Page");
			o.htmPupilsIndianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("Page");
			o.htmPupilsAsianFemale("Page");
			o.htmPupilsAsianTotal("Page");
			o.htmPupilsAsianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsHispanicMale("Page");
			o.htmPupilsHispanicFemale("Page");
			o.htmPupilsHispanicTotal("Page");
			o.htmPupilsHispanicPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("Page");
			o.htmPupilsBlackFemale("Page");
			o.htmPupilsBlackTotal("Page");
			o.htmPupilsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("Page");
			o.htmPupilsWhiteFemale("Page");
			o.htmPupilsWhiteTotal("Page");
			o.htmPupilsWhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("Page");
			o.htmPupilsPacificIslanderFemale("Page");
			o.htmPupilsPacificIslanderTotal("Page");
			o.htmPupilsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("Page");
			o.htmPupilsMultiRacialFemale("Page");
			o.htmPupilsMultiRacialTotal("Page");
			o.htmPupilsMultiRacialPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("h5").a("class", "w3-cell-row ").f().sx("Public school personnel summary").g("h5");
			{ e("div").a("class", "w3-cell-row ").f();
				sx("See ");
				e("a").a("href", "http://apps.schools.nc.gov/ords/f?p=145:109:::NO:::").a("target", "_blank").f().sx("http://apps.schools.nc.gov/ords/f?p=145:109:::NO:::").g("a");
			} g("div");
			}
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Page");
			o.htmTeachersMale("Page");
			o.htmTeachersFemale("Page");
			o.htmTeachersTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("Page");
			o.htmTeachersWhitePercent("Page");
			o.htmTeachersBlackTotal("Page");
			o.htmTeachersBlackPercent("Page");
			o.htmTeachersOtherTotal("Page");
			o.htmTeachersOtherPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("h5").a("class", "w3-cell-row ").f().sx("School-based complaints").g("h5");
			{ e("div").a("class", "w3-cell-row ").f();
				sx("See ");
				e("a").a("href", "https://www.nccourts.gov/programs/school-justice-partnership/sjp-resources#data-on-school-based-offenses-5907").a("target", "_blank").f().sx("https://www.nccourts.gov/programs/school-justice-partnership/sjp-resources#data-on-school-based-offenses-5907").g("a");
			} g("div");
			}
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Page");
			o.htmDelinquentComplaintsAtSchool("Page");
			o.htmDelinquentComplaintsAtSchoolPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("Page");
			o.htmDelinquentComplaintsAsianPercent("Page");
			o.htmDelinquentComplaintsBlack("Page");
			o.htmDelinquentComplaintsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsHispanic("Page");
			o.htmDelinquentComplaintsHispanicPercent("Page");
			o.htmDelinquentComplaintsMultiRacial("Page");
			o.htmDelinquentComplaintsMultiRacialPercent("Page");
			o.htmDelinquentComplaintsIndian("Page");
			o.htmDelinquentComplaintsIndianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("Page");
			o.htmDelinquentComplaintsWhitePercent("Page");
			o.htmDelinquentComplaintsPacificIslander("Page");
			o.htmDelinquentComplaintsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("h5").a("class", "w3-cell-row ").f().sx("Suspension table").g("h5");
			{ e("div").a("class", "w3-cell-row ").f();
				sx("See ");
				e("a").a("href", "https://www.dpi.nc.gov/data-reports/dropout-and-discipline-data/discipline-alp-and-dropout-annual-reports").a("target", "_blank").f().sx("https://www.dpi.nc.gov/data-reports/dropout-and-discipline-data/discipline-alp-and-dropout-annual-reports").g("a");
			} g("div");
			}
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsTotal("Page");
			o.htmLongTermSuspensionsTotal("Page");
			o.htmExpulsionsTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("Page");
			o.htmShortTermSuspensionsAsianMale("Page");
			o.htmShortTermSuspensionsAsianTotal("Page");
			o.htmShortTermSuspensionsAsianPercent("Page");
			o.htmShortTermSuspensionsAsianRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("Page");
			o.htmShortTermSuspensionsBlackMale("Page");
			o.htmShortTermSuspensionsBlackTotal("Page");
			o.htmShortTermSuspensionsBlackPercent("Page");
			o.htmShortTermSuspensionsBlackRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsHispanicFemale("Page");
			o.htmShortTermSuspensionsHispanicMale("Page");
			o.htmShortTermSuspensionsHispanicTotal("Page");
			o.htmShortTermSuspensionsHispanicPercent("Page");
			o.htmShortTermSuspensionsHispanicRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndianFemale("Page");
			o.htmShortTermSuspensionsIndianMale("Page");
			o.htmShortTermSuspensionsIndianTotal("Page");
			o.htmShortTermSuspensionsIndianPercent("Page");
			o.htmShortTermSuspensionsIndianRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("Page");
			o.htmShortTermSuspensionsMultiRacialMale("Page");
			o.htmShortTermSuspensionsMultiRacialTotal("Page");
			o.htmShortTermSuspensionsMultiRacialPercent("Page");
			o.htmShortTermSuspensionsMultiRacialRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("Page");
			o.htmShortTermSuspensionsPacificIslanderMale("Page");
			o.htmShortTermSuspensionsPacificIslanderTotal("Page");
			o.htmShortTermSuspensionsPacificIslanderPercent("Page");
			o.htmShortTermSuspensionsPacificIslanderRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("Page");
			o.htmShortTermSuspensionsWhiteMale("Page");
			o.htmShortTermSuspensionsWhiteTotal("Page");
			o.htmShortTermSuspensionsWhitePercent("Page");
			o.htmShortTermSuspensionsWhiteRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAllRate("Page");
			o.htmShortTermSuspensionsBlackVsWhite("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("h5").a("class", "w3-cell-row ").f().sx("Academic Achievement").g("h5");
			{ e("div").a("class", "w3-cell-row ").f();
				sx("See the \"2018-19 School Assessment and Other Indicator Data\" for the ", reportCard_.getReportCardYearsStr(), " school year, \"Combined Test Results\" \"Percent Level 4 and Above (CCR)\" and \"Other High Sch Ind\" tabs. ");
				e("a").a("href", "https://www.dpi.nc.gov/districts-schools/testing-and-school-accountability/school-accountability-and-reporting/accountability-data-sets-and-reports#2018%E2%80%9319-reports").a("target", "_blank").f().sx("https://www.dpi.nc.gov/districts-schools/testing-and-school-accountability/school-accountability-and-reporting/accountability-data-sets-and-reports#2018%E2%80%9319-reports").g("a");
			} g("div");
			}
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("Page");
			o.htmExamsCollegeReadyGrades38IndianPercent("Page");
			o.htmExamsCollegeReadyGrades38AsianPercent("Page");
			o.htmExamsCollegeReadyGrades38BlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38HispanicPercent("Page");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("Page");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("Page");
			o.htmExamsCollegeReadyGrades38WhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("Page");
			o.htmExamsCollegeReadyGrades912IndianPercent("Page");
			o.htmExamsCollegeReadyGrades912AsianPercent("Page");
			o.htmExamsCollegeReadyGrades912BlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912HispanicPercent("Page");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("Page");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("Page");
			o.htmExamsCollegeReadyGrades912WhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("Page");
			o.htmGraduateWithin4YearsIndianPercent("Page");
			o.htmGraduateWithin4YearsAsianPercent("Page");
			o.htmGraduateWithin4YearsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsHispanicPercent("Page");
			o.htmGraduateWithin4YearsMultiRacialPercent("Page");
			o.htmGraduateWithin4YearsPacificIslanderPercent("Page");
			o.htmGraduateWithin4YearsWhitePercent("Page");
		} g("div");
	}
}
