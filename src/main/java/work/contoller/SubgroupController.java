package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import work.model.Subgroup;
import work.service.StudentServiceImp;
import work.service.SubgroupServiceImp;

@Controller
@RequestMapping("/subgroup")
public class SubgroupController {
    @Autowired
    SubgroupServiceImp subgroupServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping("/{id}")
    public String getSubgroupById(@PathVariable("id") int id, Model model) {
        Subgroup subgroup = subgroupServiceImp.getSubgroupById(id);
        model.addAttribute("subgroup", subgroup);
        model.addAttribute("studentList", studentServiceImp.getAllStudentBySubgroupId(id));
        return "subgroup/subgroup";
    }

}
