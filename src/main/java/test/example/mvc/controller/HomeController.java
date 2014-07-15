package test.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.example.mvc.model.A;
import test.example.mvc.model.B;

import javax.validation.Valid;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/")
public class HomeController {


	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        A a = new A();
        a.setaOne("a1");
        B b = new B();
        b.setbOne("b1");
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		return "home";
	}

    /**
     * This method would be my first choice but I can't figure out why it's NOT called
     * or how to pass the two arguments
     */
    @RequestMapping( value = "add1", method = RequestMethod.POST, params = "a, b")
    public String add1_1 ( @Valid A a, BindingResult resultA,
                         @Valid B b , BindingResult resultB,
                         Model model) {

        model.addAttribute("result", "Method add1_1 called");
        model.addAttribute("a1",a.getaOne());
        model.addAttribute("a2",a.getaTwo());
        model.addAttribute("b1",b.getbOne());
        model.addAttribute("b2",b.getbTwo());
        return "result";
    }

    /**
     * NOT working at all.
     * This is a test if parameters may be added to the
     * URL of a POST request but I do not got it working.
     */
    @RequestMapping( value = "urlparams", method = RequestMethod.POST, params = "c, d")
    public String params ( @ModelAttribute int c, @ModelAttribute int d) {
        return "result";
    }

    /**
     *  This method is working
     *  !! BUT
     *  The the single member of the parameters need to be posted using
     *  application/x-www-form-urlencoded one by one
     *  see $("#add11").click( -function
     *  I have not found a way of passing the two objects as objects
     *  There is one caveat, though!
     *  Passing each member separately means, the member names of all
     *  object passed have to be unique!
     *  If that prerequisite is met Spring seems to be able to sort
     *  out the members and construct the object from it.
     *
     *  It is working when passing only object two A or B.
     *  see the jQuery function for various test on formatting the
     *  data to be posted in various ways.
     */
    @RequestMapping( value = "add1", method = RequestMethod.POST)
    public String add1_2 ( @Valid A a, BindingResult resultA,
                         @Valid B b , BindingResult resultB,
                         Model model) {
        if (resultA.hasErrors() || resultB.hasErrors()) {
            return "home";
        }
        model.addAttribute("result","Method add1_2 called: "+a.getaOne()+b.getbOne());
        // add the parsed attribues to the model to
        // display them below the form for verification
        model.addAttribute("a1",a.getaOne());
        model.addAttribute("a2",a.getaTwo());
        model.addAttribute("b1",b.getbOne());
        model.addAttribute("b2",b.getbTwo());
        return "result";
    }

    /**
     * JSON
     * The first parameter is filled ONLY,
     * be it a class test.example.mvc.model.A or
     * a class java.util.LinkedHashMap
     */
    @RequestMapping( value = "add21", method = RequestMethod.POST)
    public ModelAndView add2_1 ( @RequestBody A a, B b) {
        System.out.println( a.getClass());
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("a1",a.getaOne());
        mv.addObject("a2",a.getaTwo());
        mv.addObject("b1",b.getbOne());
        mv.addObject("b2",b.getbTwo());
        mv.addObject("result", "add2_1 called");
        return mv;
    }

    /**
     * JSON
     * This is working for a SINGLE object only
     */
    @RequestMapping( value = "add22", method = RequestMethod.POST)
    public ModelAndView add2_2 ( @RequestBody A a) {
        System.out.println( a.getClass());
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("a1",a.getaOne());
        mv.addObject("a2",a.getaTwo());
        mv.addObject("result", "add2_2 called");
        return mv;
    }

    /**
     * JSON
     * Using some sort of wrapper object (Object o).
     * The data is send within an java.uitl.LinkedHashMap but
     * validating by annotations is lost
     */
    @RequestMapping( value = "add23", method = RequestMethod.POST)
    public ModelAndView add2_3 ( @RequestBody Object o) {
        System.out.println( o.getClass());
        ModelAndView mv = new ModelAndView("result");
        LinkedHashMap map = (LinkedHashMap) o;
        // How to extract a and b from o  elegantly and safe AND VALIDATE?
//        mv.addObject("a1",a.getaOne());
//        mv.addObject("a2",a.getaTwo());
//        mv.addObject("b1",b.getbOne());
//        mv.addObject("b2",b.getbTwo());
        mv.addObject("result", "add2_3 called");
        return mv;
    }

}
