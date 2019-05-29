import sys
sys.path.append("../util")
import util.reader as reader
import math
import operator


def transfer_user_click(user_click):
    """
    get item by user_click
    Args:
        user_click:key userid,value:[itemid1,itemid2]
    Return:
        dict,key itemid value:[userid1,userid2]
    """
    item_click_by_user = {}
    for user in user_click:
        item_list = user_click[user]
        for itemid in item_list:
            item_click_by_user.setdefault(itemid,[])
            item_click_by_user[itemid].append(user)
    return item_click_by_user

def base_contribution_score():
    return 1

def cal_user_sim(item_click_by_user):
    """
    get user sim info
    Args:
        item_click_by_user:dict,key:itemid value:[itemid1,itemid2]
    Return:
        dict,key itemid,value:dict,value_key:itemid_j,value_value:simscore
    """
    co_appear = {}
    user_click_count = {}
    for itemid,user_list in item_click_by_user.items():
        for index_i in range(0,len(user_list)):
            user_i = user_list[index_i]
            user_click_count.setdefault(user_i,0)
            user_click_count[user_i]+=1
            for index_j in range(index_i+1,len(user_list)):
                user_j = user_list[index_j]
                co_appear.setdefault(user_i,{})
                co_appear[user_i].setdefault(user_j,0)
                co_appear[user_i][user_j] += base_contribution_score()
                co_appear.setdefault(user_j, {})
                co_appear[user_j].setdefault(user_i, 0)
                co_appear[user_j][user_i] += base_contribution_score()

    user_sim_info = {}
    user_sim_info_sorted = {}
    for user_i,relate_user in co_appear.items():
        user_sim_info.setdefault(user_i,{})
        for user_j,cotime in relate_user.items():
            user_sim_info[user_i].setdefault(user_j,0)
            user_sim_info[user_i][user_j]=cotime/math.sqrt(user_click_count[user_i]*user_click_count[user_j])
    for user in user_sim_info:
        user_sim_info_sorted[user] = sorted(user_sim_info[user].items(),key=operator.itemgetter(1),reverse=True)
    return user_sim_info_sorted

def cal_recom_result(user_click,user_sim):
    recom_result ={}
    topk_user = 3
    item_num = 5
    for user,item_list in user_click.items():
        tmp_dict = {}
        for itemid in item_list:
            tmp_dict.setdefault(itemid,1)
        recom_result.setdefault(user,{})
        for zuhe in user_sim[user][:topk_user]:
            userid_j,sim_score = zuhe
            if userid_j not in user_click:
                continue
            for itemid_j in user_click[userid_j][:item_num]:
                recom_result[user].setdefault(itemid_j,sim_score)
    return recom_result

def debug_user_sim(user_sim):
    """
    print user sim result
    """
    topk = 5
    fix_user = "1"
    if fix_user not in user_sim:
        print("invalid user")
        return
    for zuhe in user_sim[fix_user][:topk]:
        userid,score= zuhe
        print (fix_user + "\tsim_user" + userid + "\t" + str(score))

def debug_recom_result(item_info,recom_result):
    """
    print recom result for user
    """
    fix_user = "1"
    if fix_user not in recom_result:
        print("invalid user for recoming result")
        return
    for itemid in recom_result["1"]:
        if itemid not in item_info:
            continue
        recom_score = recom_result["1"][itemid]
        print("recom_result:"+",".join(item_info[itemid])+"\t"+str(recom_score))



def main_flow():
    """
    main flow
    """
    user_click,user_click_time = reader.get_user_click("../data/ratings.csv")
    item_info = reader.get_item_info("../data/movies.csv")
    item_click_by_user = transfer_user_click(user_click)
    user_sim = cal_user_sim(item_click_by_user)
    #debug_user_sim(user_sim)
    recom_result = cal_recom_result(user_click,user_sim)
    #print(recom_result['1'])
    debug_recom_result(item_info,recom_result)

if __name__ == '__main__':
    main_flow()