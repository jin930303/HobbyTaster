package mbc.second.HobbyTaster.service.FAQ;

import mbc.second.HobbyTaster.entity.FAQ.FAQEntity;

import java.util.List;

public interface FAQService {
    void faqinput_save(FAQEntity faqEntity);

    List<FAQEntity> faqout();
}
