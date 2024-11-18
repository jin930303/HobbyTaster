package mbc.second.HobbyTaster.service.FAQ;

import mbc.second.HobbyTaster.entity.FAQ.FAQEntity;
import mbc.second.HobbyTaster.repository.FAQ.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQServiceImpl implements FAQService{
    @Autowired
    FAQRepository faqRepository;

    @Override
    public void faqinput_save(FAQEntity faqEntity) {
        faqRepository.save(faqEntity);
    }

    @Override
    public List<FAQEntity> faqout() {
        return faqRepository.findAll();
    }
}
