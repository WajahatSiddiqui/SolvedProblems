package com.wajahat.swing;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	ArrayList<String> tabledata;
    String[] header;

    public TableModel( String[] data, String[] header ) {
        this.header = header;
        tabledata = new ArrayList<String>();
        for( int count = 0; count < data.length; count++ ) {
            tabledata.add( data[count] );
        }
    }

    public int getRowCount() {
        int size = 0;
        if( tabledata != null ) {
            size = tabledata.size();
        }
        return size;
    }

    public int getColumnCount() {
        int size = 0;
        if( header != null ) {
            size = header.length;
        }
        return size;
    }

    public Object getValueAt( int rowindex, int colindex) {
        return tabledata.get( rowindex );
    }

    public String getColumnName( int index ) {
        return header[index];
    }

    public void add( String str ) {
        tabledata.add( str );
        fireTableDataChanged();
    }

    public void remove( int rowindex ) {
        tabledata.remove( rowindex );
        fireTableRowsDeleted( rowindex,rowindex );
    }

    public void removeAll() {
        int size = 0;
        if( tabledata != null ) {
            size = tabledata.size();
        }
        tabledata.clear();
        fireTableRowsDeleted( 0,size );
    }
}