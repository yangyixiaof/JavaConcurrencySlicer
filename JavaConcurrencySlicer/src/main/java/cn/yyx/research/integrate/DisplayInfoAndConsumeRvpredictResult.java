package cn.yyx.research.integrate;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class DisplayInfoAndConsumeRvpredictResult extends DisplayInfo {
	
	private boolean handle = false;
	private ArrayList<String> race_list = new ArrayList<String>();
	
	public DisplayInfoAndConsumeRvpredictResult(PrintStream out) {
		super(out);
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	@Override
	public void HandleInformation(String oneline) {
		if (oneline.startsWith("Data race "))
		{
			race_list.add("");
			handle = true;
		}
		if (oneline.startsWith("Successfully race-analysis in:"))
		{
			handle = false;
		}
		if (handle)
		{
			race_list.set(race_list.size()-1, race_list.get(race_list.size()-1) + oneline);
		}
		
		// race_list.add(oneline);
	}

	public ArrayList<String> GetRaces() {
		return race_list;
	}
	
}
