package service;

import java.util.Iterator;
import java.util.List;

import hyit.app.factory.DAOFactory;
import hyit.app.model.CheckInfo;
import hyit.app.model.CronInfo;
import hyit.app.model.LessonInfo;
import hyit.app.model.ParentInfo;
import hyit.app.model.SessionInfo;
import hyit.app.model.SubjectInfo;

public class Test {
	public static long getStudentNumber(String openid){
		ParentInfo parent = new ParentInfo();
		Long studentNumber = null;
		try{
			parent = DAOFactory.getIParentInfoDAOInstance().getByOpenid(openid);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(parent == null){
			return -1;
		}else{
			studentNumber = parent.getStudentNumber();
			return studentNumber;
		}
		
	}
	public String getAbsentCount(String openid){
		long studentNumber = getStudentNumber(openid);
		int count = 0;
		String str ="";
		//获得所有学科信息
		SubjectInfo subject = new SubjectInfo();
		
		String subjectName = null;
		Integer subjectNumber = null;
		List<SubjectInfo> list = null;
		try{
			list = DAOFactory.getISubjectInfoDAOInstance().getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Iterator<SubjectInfo> iter = list.iterator();
		while(iter.hasNext()){
			subject = iter.next();
			subjectName = subject.getName();
			subjectNumber = subject.getSubjectNumber();
			//获得课程编号
			SessionInfo session = new SessionInfo();
			Integer sessionNumber = null;
			List<SessionInfo> listSession = null;
			try{
				listSession = DAOFactory.getISessionInfoDAOInstance().getBySubjectNumber(subjectNumber);
			}catch(Exception e){
				e.printStackTrace();
			}
			Iterator<SessionInfo> iterSession = listSession.iterator();
			while(iterSession.hasNext()){
				session = iterSession.next();
				sessionNumber = session.getSessionNumber();
				//获得课时编号
				LessonInfo lesson = new LessonInfo();
				Integer lessonNumber = null;
				List<LessonInfo> listLesson = null;
				try{
					listLesson = DAOFactory.getILessonInfoDAOInstance().getBySessionNumber(sessionNumber);
				}catch(Exception e){
					e.printStackTrace();
				}
				Iterator<LessonInfo> iterLesson = listLesson.iterator();
				while(iterLesson.hasNext()){
					lesson = iterLesson.next();
					lessonNumber = lesson.getLessonNumber();
					//获得计划编号
					CronInfo cron = new CronInfo();
					Integer cronNumber = null;
					List<CronInfo> listCron = null;
					try{
						listCron = DAOFactory.getICronInfoDAOInstance().getByLessonNumber(lessonNumber);
					}catch(Exception e){
						e.printStackTrace();
					}
					Iterator<CronInfo> iterCron = listCron.iterator();
					while(iterCron.hasNext()){
						cron = iterCron.next();
						cronNumber = cron.getCronNumber();
						//统计考勤缺勤
						if(cron.getStatus()==1){//计划标志
							CheckInfo check = new CheckInfo();
							List<CheckInfo> listCheck = null;
							try{
								listCheck = DAOFactory.getICheckInfoDAOInstance().getByCronNumberAndStudentNumber(cronNumber, studentNumber);
							}catch(Exception e){
								e.printStackTrace();
							}
							Iterator<CheckInfo> iterCheck = listCheck.iterator();
							while(iterCheck.hasNext()){
								check = iterCheck.next();
								if(check.getAbsent().equals("旷课")) {
									count++;
								}
							}
						}
					}
				}
			}
			str = str + subjectName + " 缺勤" + count + "次";
		}
		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String openid=null;
		long studentNumber = getStudentNumber(openid);
		int count = 0;
		String str ="";
		//获得所有学科信息
		SubjectInfo subject = new SubjectInfo();
		
		String subjectName = null;
		Integer subjectNumber = null;
		List<SubjectInfo> list = null;
		try{
			list = DAOFactory.getISubjectInfoDAOInstance().getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Iterator<SubjectInfo> iter = list.iterator();
		while(iter.hasNext()){
			subject = iter.next();
			subjectName = subject.getName();
			subjectNumber = subject.getSubjectNumber();
			//获得课程编号
			SessionInfo session = new SessionInfo();
			Integer sessionNumber = null;
			List<SessionInfo> listSession = null;
			try{
				listSession = DAOFactory.getISessionInfoDAOInstance().getBySubjectNumber(subjectNumber);
			}catch(Exception e){
				e.printStackTrace();
			}
			Iterator<SessionInfo> iterSession = listSession.iterator();
			while(iterSession.hasNext()){
				session = iterSession.next();
				sessionNumber = session.getSessionNumber();
				//获得课时编号
				LessonInfo lesson = new LessonInfo();
				Integer lessonNumber = null;
				List<LessonInfo> listLesson = null;
				try{
					listLesson = DAOFactory.getILessonInfoDAOInstance().getBySessionNumber(sessionNumber);
				}catch(Exception e){
					e.printStackTrace();
				}
				Iterator<LessonInfo> iterLesson = listLesson.iterator();
				while(iterLesson.hasNext()){
					lesson = iterLesson.next();
					lessonNumber = lesson.getLessonNumber();
					//获得计划编号
					CronInfo cron = new CronInfo();
					Integer cronNumber = null;
					List<CronInfo> listCron = null;
					try{
						listCron = DAOFactory.getICronInfoDAOInstance().getByLessonNumber(lessonNumber);
					}catch(Exception e){
						e.printStackTrace();
					}
					Iterator<CronInfo> iterCron = listCron.iterator();
					while(iterCron.hasNext()){
						cron = iterCron.next();
						cronNumber = cron.getCronNumber();
						//统计考勤缺勤
						if(cron.getStatus()==1){//计划标志
							CheckInfo check = new CheckInfo();
							List<CheckInfo> listCheck = null;
							try{
								listCheck = DAOFactory.getICheckInfoDAOInstance().getByCronNumberAndStudentNumber(cronNumber, studentNumber);
							}catch(Exception e){
								e.printStackTrace();
							}
							Iterator<CheckInfo> iterCheck = listCheck.iterator();
							while(iterCheck.hasNext()){
								check = iterCheck.next();
								if(check.getAbsent().equals("旷课")) {
									count++;
								}
							}
						}
					}
				}
			}
			str = str + subjectName + " 缺勤" + count + "次";
		}
	}
	
}
