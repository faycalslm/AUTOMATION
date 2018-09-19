package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test case started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test case succssed"+result.getName());
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test case failed"+result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test case skipped"+result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test case pourcentage"+result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}