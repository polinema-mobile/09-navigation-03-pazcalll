package id.ac.polinema.skor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.skor.R;
import id.ac.polinema.skor.databinding.FragmentScoreBinding;
import id.ac.polinema.skor.models.GoalScorer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

	public static final String HOME_REQUEST_KEY = "home";
	public static final String AWAY_REQUEST_KEY = "away";
	public static final String SCORER_KEY = "scorer";

	private List<GoalScorer> homeGoalScorerList;
	private List<GoalScorer> awayGoalScorerList;

	public ScoreFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.homeGoalScorerList = new ArrayList<>();
		this.awayGoalScorerList = new ArrayList<>();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		FragmentScoreBinding binding = DataBindingUtil
				.inflate(inflater, R.layout.fragment_score, container, false);
		binding.setHomeGoalScorerList(homeGoalScorerList);
		binding.setAwayGoalScorerList(awayGoalScorerList);
		return binding.getRoot();
	}

	public void onAddHomeClick(View view) {

	}

	public void onAddAwayClick(View view) {

	}

}