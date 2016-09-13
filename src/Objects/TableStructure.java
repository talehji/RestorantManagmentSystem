/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author pallas
 */
public class TableStructure {
    
    public int idTableStructure;
    public String Name;
    public String Status;

    public TableStructure(int idTableStructure, String Name, String Status) {
        this.idTableStructure = idTableStructure;
        this.Name = Name;
        this.Status = Status;
    }

    public TableStructure() {
    }
}
