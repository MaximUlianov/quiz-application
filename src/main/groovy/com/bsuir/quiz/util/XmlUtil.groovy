package com.bsuir.quiz.util

import com.bsuir.quiz.model.Question
import com.bsuir.quiz.model.Quiz
import groovy.xml.XmlSlurper
import org.springframework.core.io.ClassPathResource

class XmlUtil {

    static Quiz readXml() {
        def xml = new XmlSlurper().parse(new ClassPathResource("quiz.xml").inputStream)
        Quiz quiz = new Quiz()
        Set<Question> questions = new HashSet<>();
        quiz.title = xml.title.text()
        xml.questions.question.each{ it ->
            Question question = new Question()
            question.title = it.title.text()
            question.answer[0] = it.answers.answer[0].text()
            question.answer[1] = it.answers.answer[1].text()
            question.answer[] = it.answers.answer[2].text()
            questions << question
        }
        quiz.questions = questions
        quiz
    }
}
