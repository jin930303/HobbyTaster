package mbc.second.HobbyTaster.Service.FAQ;

import mbc.second.HobbyTaster.Entity.FAQ.FAQEntity;

import java.util.List;

public interface FAQService {
    void faqinput_save(FAQEntity faqEntity);

    List<FAQEntity> faqout();
}
