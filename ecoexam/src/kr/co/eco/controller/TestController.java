package kr.co.eco.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.eco.dao.TestDAO;
import kr.co.eco.service.CorrectAnswerService;
import kr.co.eco.service.ExampleService;
import kr.co.eco.service.QuestionService;
import kr.co.eco.service.TestService;
import kr.co.eco.util.ZipUtils;
import kr.co.eco.vo.CorrectAnswerVO;
import kr.co.eco.vo.ExampleVO;
import kr.co.eco.vo.MemberVO;
import kr.co.eco.vo.QuestionVO;
import kr.co.eco.vo.TestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private CorrectAnswerService correctService;

	@Autowired
	private ExampleService exampleService;

	// 문제제작 index화면
	@RequestMapping("testCreateIndex.eco")
	public ModelAndView testMakeIndex() {
		ModelAndView mv = new ModelAndView("testCreateIndex");

		String key1 = "N";
		List<TestVO> makeList = testService.getTestListByKey(key1); // 제작 문제
																	// list 뽑기
		mv.addObject("makeTest", makeList);

		String key2 = "E";
		List<TestVO> baselist = testService.getTestListByKey(key2); // 기본 문제
																	// list 뽑기
		mv.addObject("baseTest", baselist);
		return mv;
	}

	// 시험 검색
	@RequestMapping("testSearch.eco")
	public ModelAndView testSearch(@RequestParam("searchStr") String searchStr,
			String select, String testKind) {
		System.out.println("testSearch 메소드");
		System.out.println("Search : " + select);

		ModelAndView mv = new ModelAndView("testSearchList");

		List<TestVO> list = null;
		if (select.equals("testName")) {
			if (testKind.equals("baseTest"))
				list = testService.getTestListByTestName(searchStr, "E");
			else if (testKind.equals("makeTest"))
				list = testService.getTestListByTestName(searchStr, "N");
			else
				list = testService.getTestListByTestName(searchStr, "");
		}
		if (select.equals("testMakerID")) {
			if (testKind.equals("baseTest"))
				list = testService.getTestListByMaker(searchStr, "E");
			else if (testKind.equals("makeTest"))
				list = testService.getTestListByMaker(searchStr, "N");
			else
				list = testService.getTestListByMaker(searchStr, "");
		}

		mv.addObject("testSearchList", list);
		return mv;
	}

	// 시험 검색 더보기
	@RequestMapping("testSearchMore.eco")
	public ModelAndView testSearchMore() {
		ModelAndView mv = new ModelAndView("testSearchMore");
		String key = "N";
		List<TestVO> list = testService.getTestListByKey(key);
		System.out.println("testSearchMore() 메소드");
		System.out.println(list);

		mv.addObject("testMakeMore", list);
		return mv;
	}

	// new test 더보기
	@RequestMapping("testNewMore.eco")
	public ModelAndView testNewMore() {
		ModelAndView mv = new ModelAndView("testNewMore");
		String key = "E";
		List<TestVO> list = testService.getTestListByKey(key);
		mv.addObject("testNewMore", list);
		return mv;
	}

	// '문제풀기'를 클릭했을 때
	@RequestMapping("testStart.eco")
	public ModelAndView testStart() {
		ModelAndView mv = new ModelAndView("testStart");
		mv.addObject("object", "object");
		return mv;
	}

	// 시험 시작전 공지
	@RequestMapping("testNotice.eco")
	public ModelAndView testNotice() {
		ModelAndView mv = new ModelAndView("testNotice");
		mv.addObject("object", "object");
		return mv;
	}

	// 시험시작 후 답안지 폼
	@RequestMapping("testAnswerForm.eco")
	public ModelAndView testAnswerForm() {
		ModelAndView mv = new ModelAndView("testAnswerForm");
		mv.addObject("object", "object");
		return mv;
	}

	// 시험시작 후 문제지
	@RequestMapping("testQuestion.eco")
	public ModelAndView testQuestion() {
		ModelAndView mv = new ModelAndView("testQuestion");
		mv.addObject("object", "object");
		return mv;
	}

	// 답안지 미리보기
	@RequestMapping("testAnswerPreview.eco")
	public ModelAndView testAnswerPreview() {
		ModelAndView mv = new ModelAndView("testAnswerPreview");
		mv.addObject("object", "object");
		return mv;
	}

	// 모든 답안 제출
	@RequestMapping("testAnswerAll.eco")
	public ModelAndView testAnswerAll() {
		ModelAndView mv = new ModelAndView("testAnswerAll");
		mv.addObject("object", "object");
		return mv;
	}

	// 시험 종료
	@RequestMapping("testEnd.eco")
	public ModelAndView testEnd() {
		ModelAndView mv = new ModelAndView("testEnd");
		mv.addObject("object", "object");
		return mv;
	}

	// '문제제작'을 클릭했을 때
	// 회원관리 만든 후 적용!(memberID)
	@RequestMapping("testCreateForm.eco")
	public ModelAndView testMakeForm() {
		ModelAndView mv = new ModelAndView("testCreateForm");
		mv.addObject("memberID", "user01");
		return mv;
	}

	// '문제제작 Form'에서 시험제작 클릭
	@RequestMapping("testCreate.eco")
	public ModelAndView testCreate(TestVO test) {
		test.setTestMakerID("user01");
		String testNo = testService.addTest(test);

		ModelAndView mv = new ModelAndView("testCreate");
		if (testNo != null) {
			mv.addObject("test", test);
			mv.addObject("eCount", test.getTestExampleCount());
			mv.addObject("testNo", testNo);
			System.out.println("testNo:" + testNo);
			return mv;
		} else
			return new ModelAndView("error");
	}

	// 각각의 문항 제작 폼
	@RequestMapping("questionMakeForm.eco")
	public ModelAndView questionMakeForm(String testNo,
			@RequestParam(value = "qNo", defaultValue = "1") int questionNo) {
		System.out.println(questionNo);
		if (questionNo < 1) {
			questionNo = 1;
		}
		ModelAndView mv = new ModelAndView("questionMakeForm");
		TestVO testVO = testService.getTestByTestNo(testNo);
		if (questionNo > testVO.getTestTotalQuestion()) {
			questionNo = testVO.getTestTotalQuestion();
		}

		QuestionVO questionVO = questionService.getQuestion(testNo, questionNo);
		CorrectAnswerVO correctVO = correctService.getCorrectAnswer(testNo,
				questionNo);
		List<ExampleVO> examples = exampleService.getExampleList(testNo,
				questionNo);
		int sum = correctService.sumQuestionPoint(testNo);
		String[] correctArr = null;
		if (correctVO != null) {
			correctArr = correctVO.getCorrectAnswer().split(",");
			System.out.println(correctVO.getCorrectAnswer());
			for (int i = 0; i < correctArr.length; i++) {
				System.out.println("ca: " + correctArr[i]);
			}
		}
		mv.addObject("examples", examples);
		mv.addObject("questionNo", questionNo);
		mv.addObject("questionVO", questionVO);
		mv.addObject("testVO", testVO);
		mv.addObject("correctVO", correctVO);
		mv.addObject("correctArr", correctArr);
		mv.addObject("sum", sum);
		System.out.println("Sum : " + sum);
		return mv;
	}

	@RequestMapping("questionMakeSave.eco")
	public ModelAndView questionMakeSave(QuestionVO questionVO,
			CorrectAnswerVO caVO, ExampleVO exampleVO, String isupdate,
			@RequestParam(value = "isdel", defaultValue = "false") String isdel) {
		System.out.println("q: " + questionVO);
		System.out.println("ca: " + caVO);
		System.out.println("Ex: " + exampleVO);
		ModelAndView mv = new ModelAndView();
		if (isdel.equals("true")) {
			exampleService.deleteExample(questionVO.getTestNo(),
					questionVO.getQuestionNo());
		}
		if (isupdate.equals("false")) {
			System.out.println("insert");
			try {
				questionService.addQuestion(questionVO);
				correctService.addCorrectAnswer(caVO);
				if (exampleVO != null) {
					String[] exampleContent = exampleVO.getExampleContent()
							.split(",");
					System.out.println(exampleContent);
					for (int i = 0; i < exampleContent.length; i++) {
						ExampleVO example = new ExampleVO();
						example.setTestNo(questionVO.getTestNo());
						example.setQuestionNo(questionVO.getQuestionNo());
						example.setExampleNo(i + 1);
						example.setExampleContent(exampleContent[i]);
						System.out.println(example);
						exampleService.addExample(example);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (isupdate.equals("true")) {
			System.out.println("update");
			try {
				questionService.updateQuestion(questionVO);
				correctService.updateCorrectAnswer(caVO);
				if (exampleVO != null) {
					String[] exampleContent = exampleVO.getExampleContent()
							.split(",");
					for (int i = 0; i < exampleContent.length; i++) {
						ExampleVO example = new ExampleVO();
						example.setTestNo(questionVO.getTestNo());
						example.setQuestionNo(questionVO.getQuestionNo());
						example.setExampleNo(i + 1);
						example.setExampleContent(exampleContent[i]);
						exampleService.updateExample(example);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("redirect:/questionMakeForm.eco?testNo="
				+ questionVO.getTestNo() + "&qNo="
				+ (questionVO.getQuestionNo()));
		return mv;

	}

	@RequestMapping("questionMakeAll.eco")
	public ModelAndView questionMakeAll(String testNo) {
		ModelAndView mv = new ModelAndView();
		TestVO testVO = testService.getTestByTestNo(testNo);
		int sum = correctService.sumQuestionPoint(testNo);

		if (testVO.getTestTotalScore() == sum) {
			mv.setViewName("questionMakeAll");
			mv.addObject("testVO", testVO);
			mv.addObject("testNo", testNo);
		} else {
			mv.setViewName("redirect:/jsp/questionMakeForm.eco?testNo="
					+ testNo);
		}

		return mv;
	}

	// 문제 미리보기
	@RequestMapping("questionPreview.eco")
	public ModelAndView questionPreview(String testNo,
			@RequestParam(value = "qNo") int questionNo) {

		ModelAndView mv = new ModelAndView("questionPreview");
		TestVO testVO = testService.getTestByTestNo(testNo);

		QuestionVO questionVO = questionService.getQuestion(testNo, questionNo);
		CorrectAnswerVO correctVO = correctService.getCorrectAnswer(testNo,
				questionNo);
		List<ExampleVO> examples = exampleService.getExampleList(testNo,
				questionNo);
		mv.addObject("examples", examples);
		mv.addObject("questionVO", questionVO);
		mv.addObject("correctVO", correctVO);
		mv.addObject("testVO", testVO);
		return mv;
	}

	// 시험지 미리보기
	@RequestMapping("testPreview.eco")
	public ModelAndView testPreview(String testNo,
			@RequestParam(value = "qNo", defaultValue = "1") int questionNo) {
		ModelAndView mv = new ModelAndView("testPreview");
		TestVO testVO = testService.getTestByTestNo(testNo);
		if (questionNo < 1) {
			questionNo = 1;
		}
		if (questionNo > testVO.getTestTotalQuestion()) {
			questionNo = testVO.getTestTotalQuestion();
		}
		QuestionVO questionVO = questionService.getQuestion(testNo, questionNo);
		CorrectAnswerVO correctVO = correctService.getCorrectAnswer(testNo,
				questionNo);
		List<ExampleVO> examples = exampleService.getExampleList(testNo,
				questionNo);
		mv.addObject("examples", examples);
		mv.addObject("questionVO", questionVO);
		mv.addObject("correctVO", correctVO);
		mv.addObject("testVO", testVO);
		return mv;
	}

	// 시험지 작성 종료
	@RequestMapping("testCreateEnd.eco")
	public ModelAndView testCreateEnd(String testNo) {
		System.out.println("END:" + testNo);
		TestVO testVO = testService.getTestByTestNo(testNo);
		ModelAndView mv = new ModelAndView("testCreateEnd");
		mv.addObject("testVO", testVO);
		return mv;
	}

	// 기본문제 form
	// @RequestMapping("testBaseForm.eco")
	// public ModelAndView testBaseForm(HttpSession session) {
	// ModelAndView mv = new ModelAndView("testBaseForm.jsp");
	// MemberVO member = (MemberVO)session.getAttribute("loginInfo");
	// mv.addObject("member", member);
	// System.out.println(member);
	// return mv;
	// }
	
	// 기본문제 Form
	@RequestMapping("testBaseForm.eco")
	public ModelAndView testBaseForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testBaseForm");
		return mv;
	}

	// 관리자 기본문제 등록(파일 업로드)
	@RequestMapping("testBaseCreate.eco")
	public ModelAndView testBaseMake(TestVO test, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		
		test.setTestMakerID(member.getMemberID());
		MultipartFile uploadfile = test.getUpdloadFile();
		
		if (uploadfile != null) {
			String fileName = uploadfile.getOriginalFilename();
			String filePath = uploadfile.getContentType();
			
			test.setTestFileName(fileName);
			try {
				File file = new File(
						"C:/sk/workspace/ecoexam2/WebContent/upload/" + fileName);
				uploadfile.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			} // try - catch
		} // if

		String testNo = testService.addBaseTest(test);
		System.out.println("기본 문제 시험지 번호 : " + testNo);
		if (testNo != null) {
			mv.setViewName("testBaseCreate");
			mv.addObject("test", test);
			mv.addObject("testNo", testNo);
			return mv;
		}
		mv.setViewName("error.jsp");
		return mv;
	}
	
	// CorrectAnswer + question DB 처리
	@RequestMapping("baseCorrectAnswer.eco")
	public ModelAndView baseCorrectAnswer(String testNo, String questionNo, String correctAnswer, String questionPoint) {
		ModelAndView mav = new ModelAndView();
		TestVO testVO = new TestVO();
		
		String[] question = questionNo.split(",");
		String[] correct = correctAnswer.split(",");
		String[] questionScore = questionPoint.split(",");
		
		for(int i=0; i<question.length; i++) {
			CorrectAnswerVO correctAnswerVO = new CorrectAnswerVO();
			correctAnswerVO.setTestNo(testNo);
			correctAnswerVO.setCorrectAnswer(correct[i]);
			correctAnswerVO.setQuestionNo(Integer.parseInt(question[i]));

			correctAnswerVO.setQuestionPoint(Integer.parseInt(questionScore[i]));
			correctService.addCorrectAnswer(correctAnswerVO);
		}
		mav.setViewName("questionBaseMakeForm");
		
		int questionCount = question.length;
		System.out.println("questionCount : " + questionCount);
		
		QuestionVO questionVO = new QuestionVO();
		
		for(int i=1; i<=questionCount; i++) {
			questionVO.setQuestionNo(i);
			questionVO.setQuestion("기본문제");
			questionVO.setQuestionKind("기본문제");
			questionVO.setTestNo(testNo);
			questionService.addQuestion(questionVO);
		}
		
		testVO = testService.getTestByTestNo(testNo);
		mav.addObject("testVO", testVO);
		
		return mav;
	}
	
	// zip 압축 풀기
	@RequestMapping("createBaseQuestion.eco")
	public ModelAndView createBaseQuestion(String testNo, String testName) {
		ModelAndView mav = new ModelAndView();
		TestVO testVO = new TestVO();
		System.out.println("압축 풀기 testNo : "+testNo);
		System.out.println("압축 풀기 testName : "+testName);
		File file = new File("C:/sk/workspace/ecoexam2/WebContent/upload/" + testName +".zip");
		File fileDirectory = new File("C:/sk/workspace/ecoexam2/WebContent/upload/" + testName);
		
		String[] fileList = fileDirectory.list();
		int fileCount = fileList.length;
		System.out.println("Controller fileCount : " + fileCount);
		testVO = testService.getTestByTestNo(testNo);
		mav.addObject("testVO", testVO);
		mav.addObject("fileCount", fileCount);
		
		try {
			ZipUtils.unzip(file, fileDirectory, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mav.setViewName("testBasePreview");
		
		return mav;
	}
}
