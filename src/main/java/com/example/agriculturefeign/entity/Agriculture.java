package com.example.agriculturefeign.entity;

public class Agriculture {
        Integer id;
        String cropName;
        String fertilizerName;
        Integer income;

    public Agriculture(int id, String cropName, String fertilizerName, int income) {
        this.id = id;
        this.cropName = cropName;
        this.fertilizerName = fertilizerName;
        this.income = income;
    }

    public Integer getIncome() {
            return income;
        }
        public void setIncome(Integer income) {
            this.income = income;
        }
        public String getFertilizerName() {
            return fertilizerName;
        }
        public void setFertilizerName(String fertilizerName) {
            this.fertilizerName = fertilizerName;
        }
        public String getCropName() {
            return cropName;
        }
        public void setCropName(String cropName) {
            this.cropName = cropName;
        }
       //this is getter method
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
    }

