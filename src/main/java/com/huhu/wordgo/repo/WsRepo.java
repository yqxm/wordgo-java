package com.huhu.wordgo.repo;

import com.huhu.wordgo.model.Origin;
import com.huhu.wordgo.model.Position;
import com.huhu.wordgo.model.Sentence;
import com.huhu.wordgo.model.Word;
import com.huhu.wordgo.repo.dao.*;
import com.huhu.wordgo.repo.po.OriginPO;
import com.huhu.wordgo.repo.po.PositionPO;
import com.huhu.wordgo.repo.po.SentencePO;
import com.huhu.wordgo.repo.po.WordPO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WsRepo {

    Converter converter = new Converter();

    WordDao wordDao;
    SentenceDao sentenceDao;
    OriginDao originDao;
    PositionDao positionDao;

    SentenceWordRe sentenceWordRe;

    @Autowired
    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @Autowired
    public void setSentenceDao(SentenceDao sentenceDao) {
        this.sentenceDao = sentenceDao;
    }

    @Autowired
    public void setOriginDao(OriginDao originDao) {
        this.originDao = originDao;
    }

    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Autowired
    public void setSentenceWordRe(SentenceWordRe sentenceWordRe) {
        this.sentenceWordRe = sentenceWordRe;
    }

    public Word saveWord(Word word) {
        var opo = wordDao.selectByAlphas(word.getAlphas());
        if (opo.isEmpty()) {
            WordPO po = converter.toPO(word);
            wordDao.insertWord(po);
            return converter.toDO(po);
        } else {
            return converter.toDO(opo.get());
        }
    }

    public Position savePosition(Position position) {
        var opo = positionDao.selectPositionByOriginIdAndPoIndexAndPoName(converter.toPO(position));
        if (opo.isPresent()) {
            return converter.toDO(opo.get());
        } else {
            PositionPO po = converter.toPO(position);
            positionDao.insertPosition(po);
            return converter.toDO(po);
        }
    }

    public Sentence saveSentence(Sentence sentence) {
        var opo = sentenceDao.selectSentenceByContentAndPositionId(converter.toPO(sentence));
        if (opo.isPresent()) {
            return converter.toDO(opo.get());
        } else {
            SentencePO po = converter.toPO(sentence);
            sentenceDao.insertSentence(po);
            return converter.toDO(po);
        }
    }

    public void bindSentenceAndWord(Sentence sentence, Word word) {
        sentenceWordRe.insertRelation(sentence.getId(), word.getId());
    }

    private class Converter {
        public  Word toDO(WordPO po) {
            Word word = new Word();
            BeanUtils.copyProperties(po, word);
            return word;
        }

        public WordPO toPO(Word word) {
            WordPO po = new WordPO();
            BeanUtils.copyProperties(word, po);
            return po;
        }

        public PositionPO toPO(Position position) {
            PositionPO po = new PositionPO();
            BeanUtils.copyProperties(position, po);
            po.setOriginId(position.getOrigin().getId());
            return po;
        }

        public Position toDO(PositionPO po) {
            Position position = new Position();
            BeanUtils.copyProperties(po, position);
            position.setOrigin(toDO(originDao.selectOriginById(po.getOriginId())));
            return position;
        }

        public OriginPO toPO(Origin origin) {
            OriginPO po = new OriginPO();
            BeanUtils.copyProperties(origin, po);
            return po;
        }

        public Origin toDO(OriginPO po) {
            Origin origin = new Origin();
            BeanUtils.copyProperties(po, origin);
            return origin;
        }

        public Sentence toDO(SentencePO po) {
            Sentence sentence = new Sentence();
            BeanUtils.copyProperties(po, sentence);
            sentence.setPosition(toDO(positionDao.selectPositionById(po.getPositionId()).get()));
            return sentence;
        }

        public SentencePO toPO(Sentence sentence) {
            SentencePO po = new SentencePO();
            BeanUtils.copyProperties(sentence, po);
            po.setPositionId(sentence.getPosition().getId());
            return po;
        }
    }
}
