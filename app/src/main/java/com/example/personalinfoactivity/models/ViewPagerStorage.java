package com.example.personalinfoactivity.models;


public class ViewPagerStorage {
        private SummaryInfo dataList;
        static private ViewPagerStorage instance;

        private ViewPagerStorage()
        {
            dataList = new SummaryInfo();
        }

        public static ViewPagerStorage getInstance()
        {
            if(instance==null)
            {
                instance = new ViewPagerStorage();
            }
            return  instance;
        }

        public void setPersonalInfo(PersonalInfo pi)
        {
            dataList.setPersonalInfo(pi);
        }

        public void SetStudentInfo(StudentInfo si)
        {
            dataList.setStudentInfo(si);
        }

        public PersonalInfo getPerInfo() {
            return dataList.getPersonalInfo();
        }

    public StudentInfo getStuInfo() {
        return dataList.getStudentInfo();
    }

    public void clearData()
    {
        instance = null;
        dataList = null;
    }

}
