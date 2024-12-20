package com.example.ihateprogrammingavz;

public class RepairRequest {
    private int id;                  // ID заявки
    private String deviceName;       // Наименование техники
    private String workType;         // Вид работы
    private String completionTime;   // Сроки выполнения (в формате строки)

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }
}
