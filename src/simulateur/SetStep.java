package simulateur;

//import turtlekit.kernel.ControlScheduler;

public class SetStep {//implements ControlScheduler{
    private int step = 0;
    private int max;
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public SetStep(int nbStep) {
		max = nbStep;
	}

//@Override
	public boolean isFinish() {
		return  (step >= max);
	}

//	@Override
	public void nextStep() {
		step++;
//		System.out.println(step);
	}

}
