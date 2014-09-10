package com.yahoo.akv.todo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TodoActivity extends Activity {

	private ArrayList<String> todoItems;
	private ArrayAdapter<String> todoAdapter;
	private ListView listViewItems;
	private EditText itemText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        todoItems = new ArrayList<String>();
        todoItems.add("Set Alarm at 9");
        todoItems.add("Have Medicine");
        todoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        listViewItems = (ListView) findViewById(R.id.todoList);
        listViewItems.setAdapter(todoAdapter);
        todoAdapter.add("Buy Grocery");
        setupTodoListViewListener();
    }
    
    private void setupTodoListViewListener() {
	  listViewItems.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View view,
				int position, long id) {
			todoItems.remove(position);
			todoAdapter.notifyDataSetChanged();
			return true;
		}
		  
	  });	
	}

	public void addListItem(View v){
		
		Button b = (Button) v;
		System.out.println(b.getText().toString());
    	itemText = (EditText)findViewById(R.id.todoItem);
    	todoAdapter.add(itemText.getText().toString());
        itemText.setText("");
    }
    
   
   
}
