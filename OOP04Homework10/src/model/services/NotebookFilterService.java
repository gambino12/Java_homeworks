package model.services;

import computerCls.extenders.NoteBook;
import model.interfaces.Printable;

import java.util.ArrayList;
import java.util.List;

public class NotebookFilterService implements Printable<NoteBook> {
    public NotebookFilterService() {

    }

//    public List<NoteBook> filterById(List<NoteBook> source, String request) {
//        List<NoteBook> filtered = new ArrayList<>();
//        for (NoteBook unit : source) {
//            if (unit.getId().equals(request))
//                filtered.add(unit);
//        }
//        return filtered;
//    }

    String getFiled(NoteBook unit, String field){
        switch (field){
            case "id": return unit.getId();
            case "model": return unit.getModel();
            case "memory": return unit.getMemory();
            case "ssd": return unit.getSsd();
            case "Battery": return unit.getBatteryCapacity().toString();
            default: throw new IllegalStateException("Wrong Field");
        }
    }

    public String commonFilter(List<NoteBook> source, String field,  String request) {
        List<NoteBook> filtered = new ArrayList<>();
        for (NoteBook unit : source) {
            if (getFiled(unit, field).equals(request))
                filtered.add(unit);
        }
        return printedVersion(filtered);
    }

    @Override
    public String printedVersion(List<NoteBook> unitList) {
        StringBuilder sb = new StringBuilder("\n");
        for (NoteBook unit : unitList){
            sb.append(unit).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void print(List<NoteBook> unitList) {
        StringBuilder sb = new StringBuilder("\n");
        for (NoteBook unit : unitList){
            sb.append(unit).append("\n");
        }
        System.out.println(sb);
    }
}
