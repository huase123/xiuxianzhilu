package huase.xiuxianzhilu.datagens.multiblock;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * - @description:MultiBlockPatternBuilder类
 */
public class MultiBlockPatternBuilder {
    private static final Joiner COMMA_JOINED = Joiner.on(",");
    private final List<String[]> pattern = Lists.newArrayList();
    private final Map<Character, REBlockPredicate> lookup = Maps.newHashMap();

    private REBlockPredicate result;
    private int height;
    private int width;

    private MultiBlockPatternBuilder(REBlockPredicate result) {
        this.result = result;
    }

    /**
     * Adds a single aisle to this pattern, going in the z axis. (so multiple calls to this will increase the z-size by
     * 1)
     */
    public MultiBlockPatternBuilder aisle(String... pAisle) {
        if (!ArrayUtils.isEmpty((Object[])pAisle) && !StringUtils.isEmpty(pAisle[0])) {
            if (this.pattern.isEmpty()) {
                this.height = pAisle.length;
                this.width = pAisle[0].length();
            }

            if (pAisle.length != this.height) {
                throw new IllegalArgumentException("Expected aisle with height of " + this.height + ", but was given one with a height of " + pAisle.length + ")");
            } else {
                for(String s : pAisle) {
                    if (s.length() != this.width) {
                        throw new IllegalArgumentException("Not all rows in the given aisle are the correct width (expected " + this.width + ", found one with " + s.length() + ")");
                    }

                    for(char c0 : s.toCharArray()) {
                        if (!this.lookup.containsKey(c0)) {
                            this.lookup.put(c0, (REBlockPredicate) null);
                        }
                    }
                }

                this.pattern.add(pAisle);
                return this;
            }
        } else {
            throw new IllegalArgumentException("Empty pattern for aisle");
        }
    }

    public static MultiBlockPatternBuilder start(REBlockPredicate pBlockMatcher) {
        return new MultiBlockPatternBuilder(pBlockMatcher);
    }

    public MultiBlockPatternBuilder where(char pSymbol, REBlockPredicate pBlockMatcher) {
        this.lookup.put(pSymbol, pBlockMatcher);
        return this;
    }

    public MultiBlockPatternBuilder whereresult(char x) {
        this.lookup.put( x, result);
        return this;
    }
    public MultiBlockPattern build() {
        return new MultiBlockPattern(this.createPattern());
    }

    private REBlockPredicate[][][] createPattern() {
        REBlockPredicate[][][] predicate = (REBlockPredicate[][][]) Array.newInstance(REBlockPredicate.class, this.pattern.size(), this.height, this.width);

        for(int i = 0; i < this.pattern.size(); ++i) {
            for(int j = 0; j < this.height; ++j) {
                for(int k = 0; k < this.width; ++k) {
                    REBlockPredicate reBlockPredicate = this.lookup.get((this.pattern.get(i))[j].charAt(k));
                    if(reBlockPredicate != null){
                        predicate[i][j][k] = reBlockPredicate;
                    }else {
                        predicate[i][j][k] = REBlockPredicate.ANY;
                    }
                }
            }
        }

        return predicate;
    }


    public List<String[]> getPattern() {
        return pattern;
    }

    public Map<Character, REBlockPredicate> getLookup() {
        return lookup;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public REBlockPredicate getResult() {
        return result;
    }

    public void serializeRecipeData(JsonObject pJson) {


        List<String[]> pattern = this.getPattern();
        JsonArray pattern_jsonarray1 = new JsonArray();
        for (String[] strings : pattern) {

            JsonArray pattern_jsonarray2 = new JsonArray();
            for (String string : strings) {
                pattern_jsonarray2.add(string);
            }
            pattern_jsonarray1.add(pattern_jsonarray2);
        }
        pJson.add("pattern",pattern_jsonarray1);


        Map<Character, REBlockPredicate> key = this.getLookup();
        JsonObject key_jsonobject = new JsonObject();
        for(Map.Entry<Character, REBlockPredicate> entry : key.entrySet()) {
            key_jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().serializeToJson());
        }
        pJson.add("key", key_jsonobject);

        int height = this.getHeight();

        pJson.addProperty("height", height);
        int width = this.getWidth();
        pJson.addProperty("width", width);

        REBlockPredicate result = this.getResult();
        pJson.add("result", result.serializeToJson());

    }

}