package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Created by lzm on 2017/12/3.
 */
public class JobDesc {

    private int id_;

    private String title;

    private String location;

    private String salary;

    private String salarylo;

    private String salaryhi;

    private String companyName;

    private String companyType;

    private String experience;

    private String degree;

    private String jobNum;

    private String releaseTime;

    private Set<String> tags = new HashSet<>();

    private String jobMsg;

    private String jobType;

    private String jobPosition;

    private String part;

    private String companyMsg;

    private Integer hash1;

    private String hash2;

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getCompanyMsg() {
        return companyMsg;
    }

    public void setCompanyMsg(String companyMsg) {
        this.companyMsg = companyMsg;
    }

    public String getJobMsg() {
        return jobMsg;
    }

    public void setJobMsg(String jobMsg) {
        this.jobMsg = jobMsg;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalarylo() {
        return salarylo;
    }

    public void setSalarylo(String salarylo) {
        this.salarylo = salarylo;
    }

    public String getSalaryhi() {
        return salaryhi;
    }

    public void setSalaryhi(String salaryhi) {
        this.salaryhi = salaryhi;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public int getHash1() {
        return hash1;
    }

    public void setHash1(int hash1) {
        this.hash1 = hash1;
    }

    public String getHash2() {
        return hash2;
    }

    public void setHash2(String hash2) {
        this.hash2 = hash2;
    }

    @Override
    public String toString() {
        return "JobDesc{" +
                "id=" + id_ +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", salary='" + salary + '\'' +
                ", salarylo='" + salarylo + '\'' +
                ", salaryhi='" + salaryhi + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyType='" + companyType + '\'' +
                ", experience='" + experience + '\'' +
                ", degree='" + degree + '\'' +
                ", jobNum='" + jobNum + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", tags=" + tags +
                ", jobMsg='" + jobMsg + '\'' +
                ", jobType='" + jobType + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", part='" + part + '\'' +
                ", companyMsg='" + companyMsg + '\'' +
                ", hash1='" + hash1 + '\'' +
                ", hash2='" + hash2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobDesc jobDesc = (JobDesc) o;

        if (title != null ? !title.equals(jobDesc.title) : jobDesc.title != null) return false;
        if (location != null ? !location.equals(jobDesc.location) : jobDesc.location != null) return false;
        if (salary != null ? !salary.equals(jobDesc.salary) : jobDesc.salary != null) return false;
        if (companyName != null ? !companyName.equals(jobDesc.companyName) : jobDesc.companyName != null) return false;
        if (companyType != null ? !companyType.equals(jobDesc.companyType) : jobDesc.companyType != null) return false;
        if (experience != null ? !experience.equals(jobDesc.experience) : jobDesc.experience != null) return false;
        if (degree != null ? !degree.equals(jobDesc.degree) : jobDesc.degree != null) return false;
        if (jobNum != null ? !jobNum.equals(jobDesc.jobNum) : jobDesc.jobNum != null) return false;
        if (releaseTime != null ? !releaseTime.equals(jobDesc.releaseTime) : jobDesc.releaseTime != null) return false;
        if (jobMsg != null ? !jobMsg.equals(jobDesc.jobMsg) : jobDesc.jobMsg != null) return false;
        if (jobType != null ? !jobType.equals(jobDesc.jobType) : jobDesc.jobType != null) return false;
        if (jobPosition != null ? !jobPosition.equals(jobDesc.jobPosition) : jobDesc.jobPosition != null) return false;
        return companyMsg != null ? companyMsg.equals(jobDesc.companyMsg) : jobDesc.companyMsg == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyType != null ? companyType.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (jobNum != null ? jobNum.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (jobMsg != null ? jobMsg.hashCode() : 0);
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (jobPosition != null ? jobPosition.hashCode() : 0);
        result = 31 * result + (companyMsg != null ? companyMsg.hashCode() : 0);
        return result;
    }
}


