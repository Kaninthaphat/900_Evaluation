package model;

public class model_employee {

	private String PersonID;
	private String PersonCode;
	private String FnameT;
	private String LnameT;
	private String FnameE;
	private String LnameE;
	
	private String PersonName_Th;
	private String PersonName_En;
	private String Department_Id;
	private String Department_Code;
	private String Department_Name;
	
	private String Section_Id;
	private String Section_Code;
	private String Section_Name;
	
	private String Company_Id;
	private String Company_Code;
	private String Company_Name;
	private String PositionID;
	private String PositionCode;
	private String PositionNameT;
	private String EmpTypeID;
	private String EmpTypeCode;
	private String EmpTypeNameT;
	private String BirthDate;
	private String StartDate;
	private String yearold;
	private String WorkYearStart;
	private String WorkYearPass;
	private String numProof;
	private String IdentityID;
	private String SexID;
	private String SexT;
	private String SexE;
	private String ResignStatus;
	private String ChkDeletePerson;
	private String MaritalT;
	private String MaritalE;
	private String Telephone;
	private String email;
	private String Nickname;
	private String InitialT;
	private String InitialE;
	private int row_Number;
	private String Desc;
	private byte[] personpic;
	private String images_path;
	private String WorkMonthStart; 
    private int birthdate_pass;
    private String pws;
    
    private int s1;
    private int s2;
    private String s1_type;
    private String s2_type;
	
	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getPersonID() {
		return PersonID;
	}

	public void setPersonID(String personID) {
		PersonID = personID;
	}

	public String getPersonCode() {
		return PersonCode;
	}

	public void setPersonCode(String personCode) {
		PersonCode = personCode;
	}

	public String getPersonName_Th() {
		return PersonName_Th;
	}

	public void setPersonName_Th(String personName_Th) {
		PersonName_Th = personName_Th;
	}

	public String getPersonName_En() {
		return PersonName_En;
	}

	public void setPersonName_En(String personName_En) {
		PersonName_En = personName_En;
	}

	public String getDepartment_Id() {
		return Department_Id;
	}

	public void setDepartment_Id(String department_Id) {
		Department_Id = department_Id;
	}

	public String getDepartment_Code() {
		return Department_Code;
	}

	public void setDepartment_Code(String department_Code) {
		Department_Code = department_Code;
	}

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}

	public String getCompany_Id() {
		return Company_Id;
	}

	public void setCompany_Id(String company_Id) {
		Company_Id = company_Id;
	}

	public String getCompany_Code() {
		return Company_Code;
	}

	public void setCompany_Code(String company_Code) {
		Company_Code = company_Code;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public String getPositionID() {
		return PositionID;
	}

	public void setPositionID(String positionID) {
		PositionID = positionID;
	}

	public String getPositionCode() {
		return PositionCode;
	}

	public void setPositionCode(String positionCode) {
		PositionCode = positionCode;
	}

	public String getPositionNameT() {
		return PositionNameT;
	}

	public void setPositionNameT(String positionNameT) {
		PositionNameT = positionNameT;
	}

	public String getEmpTypeID() {
		return EmpTypeID;
	}

	public void setEmpTypeID(String empTypeID) {
		EmpTypeID = empTypeID;
	}

	public String getEmpTypeCode() {
		return EmpTypeCode;
	}

	public void setEmpTypeCode(String empTypeCode) {
		EmpTypeCode = empTypeCode;
	}

	public String getEmpTypeNameT() {
		return EmpTypeNameT;
	}

	public void setEmpTypeNameT(String empTypeNameT) {
		EmpTypeNameT = empTypeNameT;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getYearold() {
		return yearold;
	}

	public void setYearold(String yearold) {
		this.yearold = yearold;
	}

	public String getWorkYearStart() {
		return WorkYearStart;
	}

	public void setWorkYearStart(String workYearStart) {
		WorkYearStart = workYearStart;
	}

	public String getWorkYearPass() {
		return WorkYearPass;
	}

	public void setWorkYearPass(String workYearPass) {
		WorkYearPass = workYearPass;
	}

	public String getNumProof() {
		return numProof;
	}

	public void setNumProof(String numProof) {
		this.numProof = numProof;
	}

	public String getIdentityID() {
		return IdentityID;
	}

	public void setIdentityID(String identityID) {
		IdentityID = identityID;
	}

	public String getSexID() {
		return SexID;
	}

	public void setSexID(String sexID) {
		SexID = sexID;
	}

	public String getSexT() {
		return SexT;
	}

	public void setSexT(String sexT) {
		SexT = sexT;
	}

	public String getSexE() {
		return SexE;
	}

	public void setSexE(String sexE) {
		SexE = sexE;
	}

	public String getResignStatus() {
		return ResignStatus;
	}

	public void setResignStatus(String resignStatus) {
		ResignStatus = resignStatus;
	}

	public String getChkDeletePerson() {
		return ChkDeletePerson;
	}

	public void setChkDeletePerson(String chkDeletePerson) {
		ChkDeletePerson = chkDeletePerson;
	}

	public String getMaritalT() {
		return MaritalT;
	}

	public void setMaritalT(String maritalT) {
		MaritalT = maritalT;
	}

	public String getMaritalE() {
		return MaritalE;
	}

	public void setMaritalE(String maritalE) {
		MaritalE = maritalE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public int getRow_Number() {
		return row_Number;
	}

	public void setRow_Number(int row_Number) {
		this.row_Number = row_Number;
	}

	public String getInitialT() {
		return InitialT;
	}

	public void setInitialT(String initialT) {
		InitialT = initialT;
	}

	public String getInitialE() {
		return InitialE;
	}

	public void setInitialE(String initialE) {
		InitialE = initialE;
	}
	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public byte[] getPersonpic() {
		return personpic;
	}

	public void setPersonpic(byte[] personpic) {
		this.personpic = personpic;
	}

	public String getImages_path() {
		return images_path;
	}

	public void setImages_path(String images_path) {
		this.images_path = images_path;
	}
	public String getWorkMonthStart() {
		return WorkMonthStart;
	}
	public void setWorkMonthStart(String workMonthStart) {
		WorkMonthStart = workMonthStart;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getFnameT() {
		return FnameT;
	}

	public void setFnameT(String fnameT) {
		FnameT = fnameT;
	}

	public String getLnameT() {
		return LnameT;
	}

	public void setLnameT(String lnameT) {
		LnameT = lnameT;
	}

	public String getFnameE() {
		return FnameE;
	}

	public void setFnameE(String fnameE) {
		FnameE = fnameE;
	}

	public String getLnameE() {
		return LnameE;
	}

	public void setLnameE(String lnameE) {
		LnameE = lnameE;
	}

	public String getSection_Id() {
		return Section_Id;
	}

	public void setSection_Id(String section_Id) {
		Section_Id = section_Id;
	}

	public String getSection_Code() {
		return Section_Code;
	}

	public void setSection_Code(String section_Code) {
		Section_Code = section_Code;
	}

	public String getSection_Name() {
		return Section_Name;
	}

	public void setSection_Name(String section_Name) {
		Section_Name = section_Name;
	}

	public int getBirthdate_pass() {
		return birthdate_pass;
	}

	public void setBirthdate_pass(int birthdate_pass) {
		this.birthdate_pass = birthdate_pass;
	}

	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	public String getS1_type() {
		return s1_type;
	}

	public void setS1_type(String s1_type) {
		this.s1_type = s1_type;
	}

	public String getS2_type() {
		return s2_type;
	}

	public void setS2_type(String s2_type) {
		this.s2_type = s2_type;
	}

	public String getPws() {
		return pws;
	}

	public void setPws(String pws) {
		this.pws = pws;
	}
	
		      
		      
}
