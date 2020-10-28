package id.ac.polinema.skor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

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

	GoalScorer score;
	Bundle bundle;
	String home, away;

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
		final FragmentScoreBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false);
		binding.setFragment(this);
		binding.setHomeGoalScorerList(homeGoalScorerList);
		binding.setAwayGoalScorerList(awayGoalScorerList);
		getParentFragmentManager().setFragmentResultListener(HOME_REQUEST_KEY, this, new FragmentResultListener() {
			@Override
			public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
				score=result.getParcelable(SCORER_KEY);
				homeGoalScorerList.add(score);
				for (int i = 0; i < homeGoalScorerList.size(); i++){
					home =binding.textHomeScorer.getText() + homeGoalScorerList.get(i).getName() +" "+homeGoalScorerList.get(i).getMinute()+"";
				}
				binding.textHomeScorer.setText(home);
			}
		});
		getParentFragmentManager().setFragmentResultListener(AWAY_REQUEST_KEY, this, new FragmentResultListener() {
			@Override
			public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
				score=result.getParcelable(SCORER_KEY);
				awayGoalScorerList.add(score);
				for (int i = 0; i<awayGoalScorerList.size(); i++){
					home = binding.textAwayScorer.getText() + awayGoalScorerList.get(i).getName()+ " "+ awayGoalScorerList.get(i).getMinute()+"";
				}
				binding.textAwayScorer.setText(home);
			}
		});
		binding.textAwayScorer.setText(away);
		binding.textHomeScorer.setText(home);
		return binding.getRoot();
	}

	public void onAddHomeClick(View view) {
		ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(HOME_REQUEST_KEY);
		Navigation.findNavController(view).navigate(action);
	}

	public void onAddAwayClick(View view) {
		ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(AWAY_REQUEST_KEY);
		Navigation.findNavController(view).navigate(action);
	}

}