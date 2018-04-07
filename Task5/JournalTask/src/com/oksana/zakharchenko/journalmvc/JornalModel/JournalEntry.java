package com.oksana.zakharchenko.journalmvc.JornalModel;

public class JournalEntry {
    private String firstName;
    private String secondName;
    private String birthday;
    private String phoneNum;
    private String address;

    public JournalEntry(String firstName, String secondName, String birthday, String phoneNum, String address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public JournalEntry() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalEntry that = (JournalEntry) o;
        return firstName.equals(that.firstName) &&
                secondName.equals(that.secondName) &&
                birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}' + "\n";
    }
}
