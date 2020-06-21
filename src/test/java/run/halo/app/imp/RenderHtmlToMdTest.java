package run.halo.app.imp;

import org.junit.Test;
import run.halo.app.utils.MarkdownUtils;

/**
 * @Desc:
 * @Author: Witt Zhang
 * @Date: 2019-11-17 23:13
 */
public class RenderHtmlToMdTest {

    @Test
    public void test(){

        /*String html = "      <div id=\"wrapper\">\n" +
                "        <div class=\"article\">\n" +
                "          <h1>DMP (Data Management Platform)</h1>\n" +
                "<div id=\"preamble\">\n" +
                "<div class=\"sectionbody\">\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>整个课程的内容大致分为如下两个部分</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>业务介绍</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>技术实现</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>对于业务介绍, 比较困难的是理解广告交易过程中各个参与者是干什么的</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>对于技术实现, 大致就是如下两个步骤</p>\n" +
                "</div>\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>报表</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>标签化</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>报表显而易见, 就是查看数据的组成, 查看数据的图形直观特征</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>标签化是整个项目的目的, 最终其实就要根据标签筛选用户, 但是对于标签化还是有很多东西要做的, 如下</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>商圈库</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>打标签</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>统一用户识别</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>标签合并 &amp; 衰减</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>历史合并</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div id=\"toc\" class=\"toc\">\n" +
                "<div id=\"toctitle\">Table of Contents</div>\n" +
                "<ul class=\"sectlevel1\">\n" +
                "<li><a href=\"#_1_项目介绍\">1. 项目介绍</a>\n" +
                "<ul class=\"sectlevel2\">\n" +
                "<li><a href=\"#_1_1_广告业务背景\">1.1. 广告业务背景</a></li>\n" +
                "<li><a href=\"#_1_2_技术方案\">1.2. 技术方案</a></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li><a href=\"#_2_工程创建和框架搭建\">2. 工程创建和框架搭建</a></li>\n" +
                "<li><a href=\"#_3_将数据集中的_ip_转为地域信息\">3. 将数据集中的 IP 转为地域信息</a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"sect1\">\n" +
                "<h2 id=\"_1_项目介绍\">1. 项目介绍</h2>\n" +
                "<div class=\"sectionbody\">\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>背景介绍</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>DMP</code> 的作用和实现方式</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>技术方案</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"sect2\">\n" +
                "<h3 id=\"_1_1_广告业务背景\">1.1. 广告业务背景</h3>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>互联网管广告发展至今, 产生了很多非常复杂的概念, 其中环环交错, 不容易理清, 这一章节的主要目的就是尽可能的理清楚整体上的流程, 各个环节的作用</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\"><code>Step 1</code>: 广告主, 广告商, 媒体</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613150210.png\" alt=\"20190613150210\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>广告主</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>简单来说就是要发广告的机构和个人</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>广告商</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>广告商是中介, 对接广告主和媒体, 广告主告诉广告商我要发广告, 广告商找到媒体进行谈判</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>媒体</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>比如说微博, 腾讯, 美团这样的应用和网站, 就是媒体, 它们具有广告展示的位置, 用户在使用这些服务的同时会看到各样的广告</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>受众</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>普通的用户, 在享受免费的服务的同时, 被动的接受广告</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>但是受众是有不同类型的, 可以由标签来表示, 比如说白领, 女性, <code>20 - 30</code> 岁等</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 2</code>: 小媒体和广告网络</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>刚才的结构中有一个非常明显的问题</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>小媒体有很多</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>不只有微博腾讯这些媒体, 还有很多其它的垂直小媒体, 比如说一些软件网站, 一些小型的App, 甚至前阵子比较流行的游戏消灭病毒等, 都是小型的媒体</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>广告主倾向于让更多人看到广告</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>广告主就倾向于让更多人看到广告, 而且也为了避免麻烦, 所以会找一些大型的媒体来谈合作</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>但是往往一些小媒体因为更加垂直, 其用户可能更加的精准, 购买意愿也非常好</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>小媒体的议价能力非常有限</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>虽然小媒体有小媒体的好处, 但是小媒体太过零散, 如果只是一个小媒体的话, 很难去洽谈出一个比较好的合作</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>所以小媒体也是要赚钱的, 这个领域其实是一个很大的盘子, 一定会有人为小媒体提供服务, 这种产品, 我们称之为 <code>AdNetwork</code>, 广告网络</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613162139.png\" alt=\"20190613162139\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>AdNetwork</code> 提供如下的服务</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>为广告主提供统一的界面</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>联络多家媒体, 行成为统一的定价从而销售</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 3</code>: <code>AdExchange</code></dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>虽然有 <code>AdNetwork</code> 的引入, 但是很快又会有新的问题</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>AdNetwork</code> 不止一家</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>就如同会有很多小媒体, 广告主不知道如何选择一样, <code>AdNetwork</code> 是一种商业模式, 也会有很多玩家, 广告主依然面临这种选择困难</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>小媒体们会选择不同的 <code>AdNetwork</code></p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>每个 <code>AdNetwork</code> 之间, 定价策略可能不同, 旗下的小媒体也可能不同, 其实最终广告主是要选择一个靠谱的网站来进行广告展示的, 那么这里就存在一些信息不对称, 如何选择靠谱的 <code>AdNetwork</code> 从而选择靠谱的媒体呢</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>AdNetwork</code> 之间可能存在拆借现象</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>某一个 <code>AdNetwork</code> 可能会有一个比较好的资源, 但是一直没卖出去, 而另外一个 <code>AdNetwork</code> 可能恰好需要用到这个资源, 所以 <code>AdNetwork</code> 之间可能会有一些拆借显现, 这就让这个时长愈加混乱</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>媒体可能对 <code>AdNetwork</code> 的定价策略颇有微词</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>AdNetwork</code> 背后有很多媒体, 但是整个定价策略是由 <code>AdNetwork</code> 来制定的, 虽然 <code>AdNetwork</code> 往往是非常精密的计算模型, 但是媒体依然可能会感觉自己没有赚到钱</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>所以滋生了另外一种业务, 叫做 <code>AdExchange</code>, 广告交易平台, 从而试图去从上层再统一一下</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613165151.png\" alt=\"20190613165151\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>所以, <code>AdExchange</code> 虽然看起来和 <code>AdNetwork</code> 非常类似, 但是本质上是不同的, 其有以下特点</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>AdExchange</code> 不仅会联系 <code>AdNetwork</code>, 也会联系一下小媒体</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>甚至有时候 <code>AdNetwork</code> 也会找 <code>AdExchange</code> 发布广告需求</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>AdExchange</code> 会提供实时的交易定价, 弥补了 <code>AdNetwork</code> 独立定价的弊端</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 4</code>: <code>RTB</code> 实时竞价</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>本节并不是针对 <code>AdExchange</code> 的缺陷引入新的话题, 而是针对 <code>AdExchange</code> 中的一个定价特点进行详细的说明</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>AdExchange</code> 和 <code>AdNetwork</code> 最大的不同可能要数 <code>AdExchange</code> 的定价方式了, <code>AdExchange</code> 的定价方式是一种事实的定价方式, 其实非常类似于股票的撮合交易</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613170128.png\" alt=\"20190613170128\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>整个过程的步骤大致如下:</p>\n" +
                "</div>\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>媒体发起广告请求给 <code>RTB</code> 系统, 请求广告进行展示</p>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613171716.png\" alt=\"20190613171716\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>广告主根据自己需求决定是否竞价, 以及自己的出价</p>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613171747.png\" alt=\"20190613171747\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>会有多个广告主同时出价, 价高者得</p>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613171854.png\" alt=\"20190613171854\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>这样, <code>RTB</code> 就能尽可能的让广告的展示价格更透明更公平, <code>AdExchange</code> 得到自己响应的佣金, 媒体得到最大化的广告费, 看起来皆大欢喜, 但是真的是这样吗?</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 5</code>: 广告主如何竞价?</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>一切看起来都很好, 如果你站在媒体角度的话, 但是如果你站在广告主的角度上来看, 广告主可能会有两种抱怨</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>广告主并不是专业从业者</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>广告主可能会觉得, 你跟我闹呢, 我知道不知道怎么出价你心里每一点数?</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>确实, 作为金主, 不能太过为难他们, 每次交易都让广告主出价, 无异于逼迫广告主转投他家</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>广告主的诉求是投放广告给恰好有需求的人, 而不是看起来好像很酷的媒体</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>我们讨论到现在, 所有的假设都是基于广告主知道自己该找什么样的媒体投放什么样的广告, 这种假设明显是不成立的, 如果考虑广告主的诉求, 其非常简单, 在同等价格内, 广告效果要好, 所以广告主更关心的事情是你是否让合适的人看到了这些广告</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>所以, <code>DSP</code> 应运而生, <code>DSP</code> 全称叫做需求方平台, 主要负责和 <code>AdExchange</code> 交互, 辅助广告主进行实时竞价</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613173747.png\" alt=\"20190613173747\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>DSP</code> 帮助广告主进行 <code>RTB</code> 中的出价</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>DSP</code> 不仅只是出价, <code>DSP</code> 帮助广告主全面的进行广告服务, 例如广告主只需要告诉 <code>DSP</code> 自己对什么类型的受众感兴趣, <code>DSP</code> 会帮助广告主进行受众筛选</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 6</code>: <code>DMP</code></dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>DSP</code> 最重要的特性是, 能够帮助广告主筛选客户, 换句话说, <code>DSP</code> 出现之前广告主针对媒体上的广告位进行广告投放, <code>DSP</code> 出现之后, 广告主针对自己想要的目标受众投放广告, 这几乎是一个质的效率提升</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>广告主现在可以针对一些受众的标签来进行广告投放了, 比如说, 一个广告主是卖化妆品的, 他要投放广告给有如下三个标签的用户们, <code>20</code> 岁上下, 女性, 时尚人士, 现在就可以针对这三个标签来告诉 <code>DSP</code> 如何筛选用户了</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>但是 <code>DSP</code> 如何进行用户识别呢? <code>DSP</code> 如何知道谁是 <code>20</code> 岁上下, 女性, 时尚人士? <code>DSP</code> 可以自己做, 也可以依赖于第三方. 这个标签化的数据管理项目, 就叫做 <code>DMP</code>, 全称叫做 <code>Data Management Platform</code>, 即数据管理平台.</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>DMP 所负责的内容非常重要的有两点</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>收集用户数据</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>常见的收集方式主要有两种</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>通过自身的服务和程序进行收集, 例如微博和腾讯有巨大的用户量, 他们自己就可以针对自己的用户进行分析</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>通过合作而来的一些数据, 这部分在合规范围内, 一般大型的网站或者 <code>App</code> 会通过一些不会泄漏用户隐私的 <code>ID</code> 来标识用户, 给第三方 <code>DMP</code> 合作使用</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>通过一些不正当的手段获得, 例如说在某网站上传伪装成图片的脚本, 从而获取本网站的用户 <code>Cookie</code>, 这部分涉及一些黑产, 不再详细说明, <code>315</code> 晚会也曾经报道过</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>为用户打上标签</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>DSP</code> 主要通过标签筛选用户, 所以 <code>DMP</code> 要通过一些大数据的工具来将用户数据打上标签, 这部分其实挺难, 有可能要涉及一些机器学习的算法, 或者图计算</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613180723.png\" alt=\"20190613180723\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Ps.</code> 整个链条中的参与者</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613183606.png\" alt=\"20190613183606\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"sect2\">\n" +
                "<h3 id=\"_1_2_技术方案\">1.2. 技术方案</h3>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p><code>DMP</code> 的主要任务</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>技术方案</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">技术方案</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613192400.png\" alt=\"20190613192400\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">从目的上看, <code>DMP</code> 系统可能会有如下的事情要做</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>通过可视化和笔记工具进行数据分析和测试</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>一般会使用 <code>Zeppelin</code> 等工具进行测试和数据探索</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614014030.png\" alt=\"20190614014030\" width=\"600\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>向 <code>DSP</code> 提供数据服务</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>一般对外提供数据, 是以接口的形式提供的, 例如提供一个 <code>Http GET</code> 接口给 <code>DSP</code>, <code>DSP</code> 可以调用这个接口实现查询</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>接口一般使用 <code>Spring</code> 之类的框架编写 <code>Http</code> 服务实现</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>这种接口在访问数据库的时候, 就是 <code>OLTP</code> 形式了, 要尽快的获取数据, <code>Kudu</code> 和 <code>HBase</code> 较为合适</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>通过可视化内部展示运营数据</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>在运营过程中, 产品方可能需要时刻监控运营的一些指标, 例如注册率, 使用率, 接口调用次数等</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614014138.png\" alt=\"20190614014138\" width=\"600\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">从工程的视角上来看, <code>DMP</code> 的工程分为如下几个部分</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 2%;\">\n" +
                "<col style=\"width: 25%;\">\n" +
                "<col>\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">工程</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">类型</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">作用</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>dmp</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>IDEA Project</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>DMP</code> 项目的主工程, 编写具体的代码</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>dmp_report</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Zeppelin Notebook</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Zeppeline</code> 的一个笔记, 负责展示 <code>DMP</code> 进行数据探索和分析时所产生的报表</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>dmp_analysis</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Zeppelin Notebook</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Zeppeline</code> 的一个笔记, 负责进行 <code>DMP</code> 数据的探索, 从中不断试探发现经验</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">真实开发的时候可能遵循如下步骤</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 8%;\">\n" +
                "<col style=\"width: 8%;\">\n" +
                "<col style=\"width: 15%;\">\n" +
                "<col style=\"width: 20%;\">\n" +
                "<col>\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">序号</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">环境</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">存储</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">对应工程</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">描述</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">测试</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Kudu</code> 测试</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>dmp_analysis</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">先对数据进行探索, 得出规律</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>2</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">测试</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Kudu</code> 测试</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>dmp_report</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">归纳数据特征和规律, 通过报表展示</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>3</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Kudu</code> 生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>IDEA dmp project</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">对数据充分理解后, 编写代码进行 <code>ETL</code> 操作, 并使用 <code>Oozie</code> 等工具进行调度执行, 处理过的数据落地到 <code>Kudu</code> 表中</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>4</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Kudu</code> 生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>IDEA dmp project</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">生产中的数据已经经过清洗, 此时可以编写代码进行标签库等一系列的数据分析和挖掘任务, 并将结果落地到 <code>ElasticSearch</code> 中, 向 <code>DSP</code> 提供服务</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Kudu</code> 生产</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>IDEA dmp project</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">在运营过程中, 会产生一些运营指标, 可以针对运营指标进行数据分析和可视化, 提供给产品部分追踪运营状况. 此步骤应该通过 <code>EChats</code> 等工具在后台系统中进行可视化, 使用 <code>SQL</code> 来分析数据</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "<div class=\"admonitionblock note\">\n" +
                "<table>\n" +
                "<tr>\n" +
                "<td class=\"icon\">\n" +
                "<i class=\"fa icon-note\" title=\"Note\"></i>\n" +
                "</td>\n" +
                "<td class=\"content\">\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>数据会不断的来, 所以数据的清洗和 <code>ETL</code> 过程是不断重复进行的</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>ETL</code> 会不断的产生新的洁净数据, 所以标签库也是不断重复进行的</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>运营不断继续, <code>ETL</code> 也不断继续, 所以报表也要周期性提供</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>根据任务的情况和目的不同, 这个周期有可能是 <code>1</code> 天, <code>12</code> 小时, <code>1</code> 个月等</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>DMP</code> 的主要任务</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/1554645748023.png\" alt=\"1554645748023\" width=\"900\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>在我们这个学习项目中, 大家只需要了解围绕这个 DMP 有什么样的项目, 以及整体的过程和团队需要做的事情, 但是我们还是要把主要目标放在核心业务上, 我们在整个项目中将学习到如下一些内容</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>报表生成</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>标签化以及标签化相关的一系列处理</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">数据集生成</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613210828.png\" alt=\"20190613210828\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>这份数据集生成的步骤有如下</p>\n" +
                "</div>\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>收集数据</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>数据来自于以往的竞价记录和收集到的用户数据</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>竞价记录来自于以往的交易</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>用户数据有可能来自第三方, 也有可能是自己收集(可能性比较小)</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>合并多个数据源的数据</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>因为在进行针对 DMP 的数据分析时, 需要用到用户的数据来判定用户的喜好, 也需要竞价数据来判定价格是否合适, 所以需要将这两部分数据合并起来, 再进行数据处理和分析</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">数据集概况</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>数据集是一个 JSON Line 文件, 其中有三千条数据, 每一条数据都是一个独立的 JSON 字符串, 大概长如下样子</p>\n" +
                "</div>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190613212015.png\" alt=\"20190613212015\" width=\"400\">\n" +
                "</div>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 3%;\">\n" +
                "<col>\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">字段</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">解释</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>IP</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备的真实 <code>IP</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sessionid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>会话标识</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>advertisersid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告主 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adorderid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adcreativeid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告创意 <code>ID</code></p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>&gt;= 200000</code> : <code>DSP</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>&lt;  200000</code> : <code>OSS</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adplatformproviderid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告平台商 <code>ID</code></p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>&gt;= 100000</code> : <code>rtb</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>&lt; 100000</code> : <code>api</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sdkversionnumber</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>SDK</code> 版本号</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adplatformkey</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>平台商 <code>Key</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>putinmodeltype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>针对广告主的投放模式</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 展示量投放</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 点击量投放</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>requestmode</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>数据请求方式</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 请求</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 展示</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>3</code> : 点击</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告价格</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adppprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>平台商价格</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>requestdate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>请求时间, 格式为 <code>yyyy-m-dd hh:mm:ss</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>appid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>应用 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>appname</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>应用名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>uuid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备唯一标识, 比如 <code>IMEI</code> 或者 <code>AndroidID</code> 等</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>device</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备型号, 如 <code>Huawei</code>, <code>iPhone</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>client</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备类型</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : <code>Android</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : <code>iOS</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>3</code> : <code>WP</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>osversion</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备操作系统版本, 如 <code>4.0</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>density</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>备屏幕的密度</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>Android</code> 的取值为 <code>0.75</code>, <code>1</code>, <code>1.5</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>iOS</code> 的取值为 <code>1</code>, <code>2</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>pw</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备屏幕宽度</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ph</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备屏幕高度</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>longitude</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备所在经度</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>lat</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备所在纬度</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>provincename</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备所在省份名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>cityname</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备所在城市名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ispid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>运营商 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ispname</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>运营商名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>networkmannerid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>联网方式 <code>ID</code></p>\n" +
                "</div>\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p><code>4G</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>3G</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2G</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>OperatorOther</code></p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>networkmannername</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>联网方式名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>iseffective</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>是否可以正常计费</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>0</code> : 不行</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>1</code> : 可以</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>isbilling</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>是否收费</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>0</code> : 未收费</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>1</code> : 已收费</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adspacetype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告位类型</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : <code>Banner</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 插屏</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>3</code> : 全屏</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adspacetypename</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告位类型名称, 如 <code>Banner</code>, 插屏, 全屏</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>devicetype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备类型（1：手机 2：平板）</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 手机</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 平板</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>processnode</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>流程节点</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 请求量 <code>KPI</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 有效请求</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>3</code> : 广告请求</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>apptype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>应用类型 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>district</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>设备所在县名称</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>paymode</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>针对平台商的支付模式</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 展示量投放, CPM</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 点击量投放, CPC</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>isbid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>是否是 <code>RTB</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>bidprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 竞价价格</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>winprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 竞价成功价格</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>iswin</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>是否竞价成功</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>cur</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>结算币种, <code>USD</code>, <code>RMB</code> 等</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>rate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>汇率</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>cnywinprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 竞价成功转换成人民币的价格</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>imei</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>手机串码</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>mac</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>手机 <code>MAC</code> 地址</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>idfa</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>手机 <code>APP</code> 的广告码</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>openudid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>苹果设备的识别码</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>androidid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>安卓设备的识别码</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>rtbprovince</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 省</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>rtbcity</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 市</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>rtbdistrict</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 区</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>rtbstreet</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>RTB</code> 街道</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>storeurl</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>APP</code> 的市场下载地址</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>realip</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>真实 <code>IP</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>isqualityapp</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>优选标识</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>bidfloor</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>底价</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>aw</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告位的宽</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ah</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告位的高</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>imeimd5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>IMEI</code> 的 <code>MD5</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>macmd5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>MAC</code> 的 <code>MD5</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>idfamd5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>IDFA</code> 的 <code>MD5</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>openudidmd5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>OpenUDID</code> 的 <code>MD5</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>androididmd5</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>AndroidID</code> 的 <code>MD5</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>imeisha1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>IMEI</code> 的 <code>SHA-1</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>macsha1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>MAC</code> 的 <code>SHA-1</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>idfasha1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>IDFA</code> 的 <code>SHA-1</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>openudidsha1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>OpenUDID</code> 的 <code>SHA-1</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>androididsha1</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>AndroidID</code> 的 <code>SHA-1</code> 值</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>uuidunknow</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p><code>UUID</code> 的密文</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>userid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>平台用户 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>iptype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>表示 <code>IP</code> 库类型</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>1</code> : 为点媒 <code>IP</code> 库</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>2</code> : 为广告协会的 <code>IP</code> 地理信息标准库</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>默认为1</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>initbidprice</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>初始出价</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adpayment</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>转换后的广告消费 (保留小数点后 <code>6</code> 位)</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>agentrate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>代理商利润率</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>lomarkrate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>代理利润率</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>adxrate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>媒介利润率</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>title</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>标题</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>keywords</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>关键字</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tagid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>广告位标识 (当视频流量时值为视频 <code>ID</code> 号)</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>callbackdate</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>回调时间, 格式为 <code>yyyy/MM/dd hh:mm:ss</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>channelid</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>频道 <code>ID</code></p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>mediatype</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>媒体类型</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>email</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>用户邮箱</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tel</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>用户电话号码</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sex</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>用户性别</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>age</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>用户年龄</p>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"sect1\">\n" +
                "<h2 id=\"_2_工程创建和框架搭建\">2. 工程创建和框架搭建</h2>\n" +
                "<div class=\"sectionbody\">\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>创建工程</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>搭建框架</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>建立配置框架</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\"><code>Step 1</code>: 创建工程</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">已经到最后一个阶段了, 不再详细说工程如何创建了, 看一下步骤即可</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>在 <code>IDEA</code> 创建 <code>Maven</code> 工程, 选择存储位置</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>工程命名为 <code>dmp</code>, 注意工程名一般小写, 大家也可以采用自己喜欢的命名方式, 在公司里, 要采用公司的习惯</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>导入 <code>Maven</code> 依赖</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>创建 <code>Scala</code> 代码目录</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>创建对应的包们</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">创建需要的包</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 30%;\">\n" +
                "<col>\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">包名</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">描述</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>com.itheima.dmp.etl</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">放置数据转换任务</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>com.itheima.dmp.report</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">放置报表任务</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>com.itheima.dmp.tags</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">放置标签有关的任务</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>com.itheima.dmp.utils</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">放置一些通用公用的类</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">导入需要的依赖</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>在 <code>DMP</code> 中, 暂时先不提供完整的 <code>Maven POM</code> 文件, 在一开始只导入必备的, 随着项目的进程, 用到什么再导入什么, 以下是必备的</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>Spark</code> 全家桶</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Kudu</code> 一套</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Scala</code> 依赖</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>SLF4J</code> 日志依赖</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Junit</code> 单元测试</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Java</code> 编译插件</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Scala</code> 编译插件</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Uber Jar</code> 编译插件 <code>Shade</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>CDH Repo</code> 仓库, 需要一个 <code>CDH</code> 的 <code>Maven</code> 仓库配置是因为用到 <code>CDH</code> 版本的 <code>Kudu</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-xml hljs\" data-lang=\"xml\">&lt;properties&gt;\n" +
                "    &lt;scala.version&gt;2.11.8&lt;/scala.version&gt;\n" +
                "    &lt;spark.version&gt;2.2.0&lt;/spark.version&gt;\n" +
                "    &lt;hadoopo.version&gt;2.6.1&lt;/hadoopo.version&gt;\n" +
                "    &lt;kudu.version&gt;1.7.0-cdh5.16.0&lt;/kudu.version&gt;\n" +
                "    &lt;maven.version&gt;3.5.1&lt;/maven.version&gt;\n" +
                "    &lt;junit.version&gt;4.12&lt;/junit.version&gt;\n" +
                "&lt;/properties&gt;\n" +
                "\n" +
                "&lt;dependencies&gt;\n" +
                "    &lt;!-- Spark --&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.scala-lang&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;scala-library&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${scala.version}&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.spark&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;spark-core_2.11&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${spark.version}&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.spark&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;spark-sql_2.11&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${spark.version}&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.spark&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;spark-hive_2.11&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${spark.version}&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.hadoop&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;hadoop-client&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${hadoopo.version}&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "\n" +
                "    &lt;!-- Kudu client --&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.kudu&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;kudu-client&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;1.7.0-cdh5.16.1&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "\n" +
                "    &lt;!-- Kudu Spark --&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.apache.kudu&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;kudu-spark2_2.11&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;1.7.0-cdh5.16.1&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "\n" +
                "    &lt;!-- Logging --&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;org.slf4j&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;slf4j-simple&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;1.7.12&lt;/version&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "\n" +
                "    &lt;!-- Unit testing --&gt;\n" +
                "    &lt;dependency&gt;\n" +
                "        &lt;groupId&gt;junit&lt;/groupId&gt;\n" +
                "        &lt;artifactId&gt;junit&lt;/artifactId&gt;\n" +
                "        &lt;version&gt;${junit.version}&lt;/version&gt;\n" +
                "        &lt;scope&gt;provided&lt;/scope&gt;\n" +
                "    &lt;/dependency&gt;\n" +
                "&lt;/dependencies&gt;\n" +
                "\n" +
                "&lt;build&gt;\n" +
                "    &lt;sourceDirectory&gt;src/main/scala&lt;/sourceDirectory&gt;\n" +
                "    &lt;testSourceDirectory&gt;src/test/scala&lt;/testSourceDirectory&gt;\n" +
                "\n" +
                "    &lt;plugins&gt;\n" +
                "        &lt;plugin&gt;\n" +
                "            &lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;\n" +
                "            &lt;artifactId&gt;maven-compiler-plugin&lt;/artifactId&gt;\n" +
                "            &lt;version&gt;${maven.version}&lt;/version&gt;\n" +
                "            &lt;configuration&gt;\n" +
                "                &lt;source&gt;1.8&lt;/source&gt;\n" +
                "                &lt;target&gt;1.8&lt;/target&gt;\n" +
                "            &lt;/configuration&gt;\n" +
                "        &lt;/plugin&gt;\n" +
                "\n" +
                "        &lt;plugin&gt;\n" +
                "            &lt;groupId&gt;net.alchim31.maven&lt;/groupId&gt;\n" +
                "            &lt;artifactId&gt;scala-maven-plugin&lt;/artifactId&gt;\n" +
                "            &lt;version&gt;3.2.0&lt;/version&gt;\n" +
                "            &lt;executions&gt;\n" +
                "                &lt;execution&gt;\n" +
                "                    &lt;goals&gt;\n" +
                "                        &lt;goal&gt;compile&lt;/goal&gt;\n" +
                "                        &lt;goal&gt;testCompile&lt;/goal&gt;\n" +
                "                    &lt;/goals&gt;\n" +
                "                    &lt;configuration&gt;\n" +
                "                        &lt;args&gt;\n" +
                "                            &lt;arg&gt;-dependencyfile&lt;/arg&gt;\n" +
                "                            &lt;arg&gt;${project.build.directory}/.scala_dependencies&lt;/arg&gt;\n" +
                "                        &lt;/args&gt;\n" +
                "                    &lt;/configuration&gt;\n" +
                "                &lt;/execution&gt;\n" +
                "            &lt;/executions&gt;\n" +
                "        &lt;/plugin&gt;\n" +
                "\n" +
                "        &lt;plugin&gt;\n" +
                "            &lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;\n" +
                "            &lt;artifactId&gt;maven-shade-plugin&lt;/artifactId&gt;\n" +
                "            &lt;version&gt;2.4&lt;/version&gt;\n" +
                "            &lt;executions&gt;\n" +
                "                &lt;execution&gt;\n" +
                "                    &lt;phase&gt;package&lt;/phase&gt;\n" +
                "                    &lt;goals&gt;\n" +
                "                        &lt;goal&gt;shade&lt;/goal&gt;\n" +
                "                    &lt;/goals&gt;\n" +
                "                &lt;/execution&gt;\n" +
                "            &lt;/executions&gt;\n" +
                "        &lt;/plugin&gt;\n" +
                "    &lt;/plugins&gt;\n" +
                "&lt;/build&gt;\n" +
                "\n" +
                "&lt;repositories&gt;\n" +
                "    &lt;repository&gt;\n" +
                "        &lt;id&gt;cdh.repo&lt;/id&gt;\n" +
                "        &lt;name&gt;Cloudera Repositories&lt;/name&gt;\n" +
                "        &lt;url&gt;https://repository.cloudera.com/artifactory/cloudera-repos&lt;/url&gt;\n" +
                "        &lt;snapshots&gt;\n" +
                "            &lt;enabled&gt;false&lt;/enabled&gt;\n" +
                "        &lt;/snapshots&gt;\n" +
                "    &lt;/repository&gt;\n" +
                "&lt;/repositories&gt;</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 2</code>: 框架搭建</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>编写 <code>Spark</code> 程序的时候, 往往不需要一个非常复杂的框架, 只是对一些基础内容的抽象和封装即可, 但是也要考虑如下问题</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>有哪些任务是要执行的</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>在做一个项目的时候, 尽量从全局的角度去看, 要考虑到周边的一些环境, 例如说回答自己如下几个问题</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 30%;\">\n" +
                "<col>\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">问题</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">初步分析和解答</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">这个应用有几个入口</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">这个程序的入口数量是不确定的, 随着工作的进展而变化, 但是至少要有两个入口, 一个是生成报表数据, 一个是处理用户的标签数据</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">这个应用会放在什么地方执行</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">分为测试和生产, 测试可以直接使用 IDEA 执行, 生成需要打包并发送到集群执行</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">这个应用如何调度</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">这个应用包含了不止一个任务, 最终会由 <code>Oozie</code>, <code>Azkaban</code>, <code>AirFlow</code> 等工具去调度执行</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>有哪些操作可能会导致重复代码过多</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>其实无论是 <code>Spring</code>, 还是 <code>Vue</code>, 还是 <code>Spark</code>, 这些框架和工具, 最终的目的都是帮助我们消除一些重复的和通用的代码</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>所以既然我们无需在 Spark 的应用中搭建复杂的项目框架, 但是对于重复的代码还是要消除的, 初步来看可能会有如下重复的代码点</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>各个数据库的访问</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>配置的读取</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Step 3</code>: 建立配置读取工具</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>了解配置文件和读取框架</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>数据读取部分, 有一个比较好用的工具, 叫做 <code>lightbend/config</code>, 它可以读取一种叫做 <code>HOCON</code> 的配置文件</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>HOCON</code> 全称叫做 <code>Human-Optimized Config Object Notation</code>, 翻译过来叫做 为人类优化的配置对象表示法</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>HOCON</code> 是一种类似于 <code>Properties</code> 的配置文件格式, 并包含 <code>JSON</code> 的语法格式, 比较易于使用, 其大致格式如下</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">foo: {\n" +
                "  bar: 10,\n" +
                "  baz: 12\n" +
                "}\n" +
                "\n" +
                "foo {\n" +
                "  bar = 10,\n" +
                "  baz = 12\n" +
                "}\n" +
                "\n" +
                "foo.bar=10\n" +
                "foo.baz=10</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>以上三种写法是等价的, 其解析结果都是两个字段, 分别叫做 <code>foo.bar</code> 和 <code>foo.baz</code></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>读取 <code>HOCON</code> 文件格式需要使用 <code>lightbend/config</code>, 它的使用非常的简单</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>当配置文件被命名为 <code>application.conf</code> 并且被放置于 <code>resources</code> 时, 可以使用如下方式直接加载</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-scala hljs\" data-lang=\"scala\">val config: Config = ConfigFactory.load()\n" +
                "val bar = config.getInt(\"foo.bar\")\n" +
                "val baz = config.getInt(\"foo.baz\")</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>创建配置文件</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>创建配置文件 <code>resource/spark.conf</code>, 并引入如下内容</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\"># Worker 心跳超时时间\n" +
                "spark.worker.timeout=\"500\"\n" +
                "\n" +
                "# RPC 请求等待结果的超时时间\n" +
                "spark.rpc.askTimeout=\"600s\"\n" +
                "\n" +
                "# 所有网络操作的等待时间, spark.rpc.askTimeout 默认值等同于这个参数\n" +
                "spark.network.timeoout=\"600s\"\n" +
                "\n" +
                "# 最大使用的 CPU 核心数\n" +
                "spark.cores.max=\"10\"\n" +
                "\n" +
                "# 任务最大允许失败次数\n" +
                "spark.task.maxFailures=\"5\"\n" +
                "\n" +
                "# 如果开启推测执行, 开启会尽可能的增快任务执行效率, 但是会占用额外的运算资源\n" +
                "spark.speculation=\"true\"\n" +
                "\n" +
                "# Driver 是否允许多个 Context\n" +
                "spark.driver.allowMutilpleContext=\"true\"\n" +
                "\n" +
                "# Spark 序列化的方式, 使用 Kryo 能提升序列化和反序列化的性能\n" +
                "spark.serializer=\"org.apache.spark.serializer.KryoSerializer\"\n" +
                "\n" +
                "# 每个页缓存, Page 指的是操作系统的内存分配策略中的 Page, 一个 Page 代表一组连续的内存空间\n" +
                "# Spark 在引入钨丝计划以后, 使用 Java 的 Unsafe API 直接申请内存, 其申请单位就是 Page\n" +
                "# 如果 Page 过大, 有可能因为操作系统的策略无法分配而拒绝这次内存申请, 从而报错\n" +
                "# 简单来说, 这个配置的作用是一次申请的内存大小\n" +
                "spark.buffer.pageSize=\"6m\"</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>以上的配置列成表如下</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 50%;\">\n" +
                "<col style=\"width: 50%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">配置项目</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">描述</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.worker.timeout</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">如果超过了这个配置项指定的时间, <code>Master</code> 认为 <code>Worker</code> 已经跪了</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.network.timeout</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">因为 <code>Spark</code> 管理一整个集群, 任务可能运行在不同的节点上, 后通过网络进行通信, 一次网络通信有可能因为要访问的节点实效而一直等待, 这个配置项所配置的便是这个等待的超时时间</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.cores.max</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Spark</code> 整个应用最大能够申请的 <code>CPU</code> 核心数</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.task.maxFailures</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Spark</code> 本身是支持弹性容错的, 所以不能因为某一个 <code>Task</code> 失败了, 就认定整个 <code>Job</code> 失败, 一般会因为相当一部分 <code>Task</code> 失败了才会认定 <code>Job</code> 失败, 否则会进行重新调度, 这个参数的含义是, 当多少个 <code>Task</code> 失败了, 可以认定 <code>Job</code> 失败</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.speculation</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">类似 <code>Hadoop</code>, <code>Spark</code> 也支持推测执行, 场景是有可能因为某台机器的负载过高, 或者其它原因, 导致这台机器运行能力很差, <code>Spark</code> 会根据一些策略检测较慢的任务, 去启动备用任务执行, 使用执行较快的任务的结果, 但是推测执行有个弊端, 就是有可能一个任务会执行多份, 浪费集群资源</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.driver.allowMutilpleContext</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">很少有机会必须一定要在一个 <code>Spark Application</code> 中启动多个 <code>Context</code>, 所以这个配置项意义不大, 当必须要使用多个 <code>Context</code> 的时候, 开启此配置即可</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.serializer</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Spark</code> 将任务分发到集群中执行, 所以势必涉及序列化, 这个配置项配置的是使用什么序列化器, 默认是 <code>JDK</code> 的序列化器, 可以指定为 <code>Kyro</code> 从而提升性能, 但是如果使用 <code>Kyro</code> 的话需要序列化的类需要被先注册才能使用</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>spark.buffer.pageSize</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">每个页缓存, <code>Page</code> 指的是操作系统的内存分配策略中的 <code>Page</code>, 一个 <code>Page</code> 代表一组连续的内存空间, <code>Spark</code> 在引入钨丝计划以后, 使用 <code>Java</code> 的 <code>Unsafe API</code> 直接申请内存, 其申请单位就是 <code>Page</code>, 如果 <code>Page</code> 过大, 有可能因为操作系统的策略无法分配而拒绝这次内存申请, 从而报错, 简单来说, 这个配置的作用是一次申请的内存大小, 一般在报错的时候修改这个配置, 减少一次申请的内存</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>导入配置读取的工具依赖</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>在 <code>pom.xml</code> 中的 <code>properties</code> 段增加如下内容</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">&lt;config.version&gt;1.3.4&lt;/config.version&gt;</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>在 <code>pom.xml</code> 中的 <code>dependencites</code> 段增加如下内容</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">&lt;!-- Config reader --&gt;\n" +
                "&lt;dependency&gt;\n" +
                "    &lt;groupId&gt;com.typesafe&lt;/groupId&gt;\n" +
                "    &lt;artifactId&gt;config&lt;/artifactId&gt;\n" +
                "    &lt;version&gt;${config.version}&lt;/version&gt;\n" +
                "&lt;/dependency&gt;</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>配置工具的设计思路</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">在设计一个工具的时候, 第一步永远是明确需求, 我们现在为 <code>SparkSession</code> 的创建设置配置加载工具, 其需求如下</dt>\n" +
                "<dd>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>配置在配置文件中编写</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>使用 <code>typesafe/config</code> 加载配置文件</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>在创建 <code>SparkSession</code> 的时候填写这些配置</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">前两点无需多说, 已经自表达, 其难点也就在于如何在 <code>SparkSession</code> 创建的时候填入配置, 大致思考的话, 有如下几种方式</dt>\n" +
                "<dd>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>加载配置文件后, 逐个将配置的项设置给 <code>SparkSession</code></p>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>spark.config(\"spark.worker.timeout\", config.get(\"spark.worker.timeout\"))</code></p>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>加载配置文件后, 通过隐式转换为 <code>SparkSession</code> 设置配置</p>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>spark.loadConfig().getOrCreate()</code></p>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>毫无疑问, 第二种方式更为方便</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>创建配置工具类</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">看代码之前, 先了解一下设计目标</dt>\n" +
                "<dd>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>加载配置文件 <code>spark.conf</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>无论配置文件中有多少配置都全部加载</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>为 <code>SparkSession</code> 提供隐式转换自动装载配置</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">下面是代码, 以及重点解读</dt>\n" +
                "<dd>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">class SparkConfigHelper(builder: SparkSession.Builder) {\n" +
                "\n" +
                "  private val config: Config = ConfigFactory.load(\"spark\")            <i class=\"conum\" data-value=\"1\"></i><b>(1)</b>\n" +
                "\n" +
                "  def loadConfig(): SparkSession.Builder = {\n" +
                "    import scala.collection.JavaConverters._\n" +
                "\n" +
                "    for (entry &lt;- config.entrySet().asScala) {\n" +
                "      val value = entry.getValue\n" +
                "      val valueType = value.valueType()\n" +
                "      val valueFrom = value.origin().filename()                       <i class=\"conum\" data-value=\"2\"></i><b>(2)</b>\n" +
                "      if (valueType == ConfigValueType.STRING &amp;&amp; valueFrom != null) { <i class=\"conum\" data-value=\"3\"></i><b>(3)</b>\n" +
                "        builder.config(entry.getKey, value.unwrapped().asInstanceOf[String]) <i class=\"conum\" data-value=\"4\"></i><b>(4)</b>\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    builder\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "object SparkConfigHelper {                                            <i class=\"conum\" data-value=\"5\"></i><b>(5)</b>\n" +
                "\n" +
                "  def apply(builder: SparkSession.Builder): SparkConfigHelper = {\n" +
                "    new SparkConfigHelper(builder)\n" +
                "  }\n" +
                "\n" +
                "  implicit def setSparkSession(builder: SparkSession.Builder) = {     <i class=\"conum\" data-value=\"6\"></i><b>(6)</b>\n" +
                "    SparkConfigHelper(builder)\n" +
                "  }\n" +
                "}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"colist arabic\">\n" +
                "<table>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"1\"></i><b>1</b></td>\n" +
                "<td>: 加载配置文件</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"2\"></i><b>2</b></td>\n" +
                "<td>: 因为 <code>Config</code> 工具会自动的加载所有的系统变量, 需要通过 <code>Origin</code> 来源判断, 只接收来自于文件的配置</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"3\"></i><b>3</b></td>\n" +
                "<td>: 判断: 1. 是 <code>String</code> 类型, 2. 来自于某个配置文件</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"4\"></i><b>4</b></td>\n" +
                "<td>: 为 <code>SparkSession</code> 设置参数</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"5\"></i><b>5</b></td>\n" +
                "<td>: 提供伴生对象的意义在于两点: 1. 更方便的创建配置类, 2. 提供隐式转换, 3. 以后可能需要获取某个配置项</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"6\"></i><b>6</b></td>\n" +
                "<td>: 提供隐式转换, 将 <code>SparkSession</code> 转为 <code>ConfigHelper</code> 对象, 从而提供配置加载</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"sect1\">\n" +
                "<h2 id=\"_3_将数据集中的_ip_转为地域信息\">3. 将数据集中的 IP 转为地域信息</h2>\n" +
                "<div class=\"sectionbody\">\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"title\">导读</div>\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p><code>IP</code> 转换工具介绍</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>转换</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\"><code>IP</code> 转换工具介绍</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">进行 <code>IP</code> 转换这种操作, 一般有如下一些办法</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 10%;\">\n" +
                "<col>\n" +
                "<col style=\"width: 20%;\">\n" +
                "<col style=\"width: 20%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">方式</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">描述</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">优点</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">缺点</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">自己编写</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>一般如果自己编写查找算法的话, 大致有如下几步</p>\n" +
                "</div>\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>找到一个 <code>IP范围 : 省 : 市 : 区</code> 这样的数据集</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>读取数据集</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>将 <code>IP</code> 转为数字表示法, 本质上 <code>IP</code> 就是二进制的点位表示法, <code>192.168.0.1 &#8594; 1100 0000 1010 1000 0000 0000 0000 0001 &#8594; 3232235521</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>使用 <code>3232235521</code> 这样的数字在 <code>IP</code> 数据集中通过二分法查找对应的省市区</p>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div></div></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">没有第三方库的学习成本</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>没有数据结构上的支持, 效率低</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>没有上层的封装, 使用麻烦</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">第三方库</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"paragraph\">\n" +
                "<p>一般第三方库会有一些数据结构上的优化, 查找速度比二分法会更快一些, 例如 <code>BTree</code> 就特别适合做索引, 常见的方式有</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>GeoLite</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>纯真数据库</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>ip2region</code></p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><div class=\"content\"><div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>速度快</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>不麻烦</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>有上层封装, 用着爽</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>第三方一般会提供数据集, 数据集会定时更新, 更精准</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>有轮子就别自己搞了, 怪麻烦的</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div></div></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">需要学习第三方工具, 有一定的学习成本, 而且不一定和以后工作中用同样一个工具</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">选用 <code>ip2region</code> 这个工具来查找省市名称</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>ip2region</code> 的优点</p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">工具</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">数据结构支持</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">中文支持</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>GeoLite</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">纯真</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ip2region</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>引入 <code>ip2region</code></p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>复制 <code>IP</code> 数据集 <code>ip2region.db</code> 到工程下的 <code>dataset</code> 目录</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>在 <code>Maven</code> 中增加如下代码</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-xml hljs\" data-lang=\"xml\">&lt;dependency&gt;\n" +
                "    &lt;groupId&gt;org.lionsoul&lt;/groupId&gt;\n" +
                "    &lt;artifactId&gt;ip2region&lt;/artifactId&gt;\n" +
                "    &lt;version&gt;1.7.2&lt;/version&gt;\n" +
                "&lt;/dependency&gt;</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>ip2region</code> 的使用</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-scala hljs\" data-lang=\"scala\">val searcher = new DbSearcher(new DbConfig(), \"dataset/ip2region.db\")\n" +
                "val data = searcher.btreeSearch(ip)\n" +
                "println(data.getRegion)</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">选用 <code>GeoLite</code> 确定经纬度</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>后面需要使用经纬度, 只有 <code>GeoLite</code> 可以查找经纬度</p>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 25%;\">\n" +
                "<col style=\"width: 25%;\">\n" +
                "<col style=\"width: 25%;\">\n" +
                "<col style=\"width: 25%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">工具</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">数据结构支持</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">中文支持</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">经纬度支持</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>GeoLite</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">纯真</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>ip2region</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">有</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">无</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>引入 <code>GeoLite</code></p>\n" +
                "<div class=\"openblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>将 <code>GeoLite</code> 的数据集 <code>GeoLiteCity.dat</code> 拷贝到工程中 <code>dataset</code> 目录下</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>在 <code>pom.xml</code> 中添加如下依赖</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-xml hljs\" data-lang=\"xml\">&lt;dependency&gt;\n" +
                "    &lt;groupId&gt;com.maxmind.geoip&lt;/groupId&gt;\n" +
                "    &lt;artifactId&gt;geoip-api&lt;/artifactId&gt;\n" +
                "    &lt;version&gt;1.3.0&lt;/version&gt;\n" +
                "&lt;/dependency&gt;\n" +
                "\n" +
                "&lt;dependency&gt;\n" +
                "    &lt;groupId&gt;com.maxmind.geoip2&lt;/groupId&gt;\n" +
                "    &lt;artifactId&gt;geoip2&lt;/artifactId&gt;\n" +
                "    &lt;version&gt;2.12.0&lt;/version&gt;\n" +
                "&lt;/dependency&gt;</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>GeoLite</code> 的使用方式</p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-scala hljs\" data-lang=\"scala\">val lookupService = new LookupService(\"dataset/GeoLiteCity.dat\", LookupService.GEOIP_MEMORY_CACHE)\n" +
                "val location = lookupService.getLocation(\"121.76.98.134\")\n" +
                "println(location.latitude, location.longitude)</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>IP</code> 转换思路梳理</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p>现在使用不同的视角, 理解一下在这个环节我们需要做的事情</p>\n" +
                "</div>\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">工具视角</dt>\n" +
                "<dd>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614162114.png\" alt=\"20190614162114\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">数据视角</dt>\n" +
                "<dd>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614162634.png\" alt=\"20190614162634\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">要做的事</dt>\n" +
                "<dd>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>读取数据集 <code>pmt.json</code></p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>将 <code>IP</code> 转换为省市</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>设计 <code>Kudu</code> 表结构, 创建 <code>Kudu</code> 表</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>存入 <code>Kudu</code> 表</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">挑战和结构</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>现在的任务本质上是把一个 <code>数据集 A</code> 转为 <code>数据集 B</code>, <code>数据集 A</code> 可能不够好, <code>数据集 B</code> 相对较好, 然后把 <code>数据集 B</code> 落地到 <code>Kudu</code>, 作为 <code>ODS</code> 层, 以供其它功能使用</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>但是如果 <code>数据集 A</code> 转为 <code>数据集 B</code> 的过程中需要多种转换呢?</p>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614165344.png\" alt=\"20190614165344\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>所以, 从面向对象的角度上来说, 需要一套机制, 能够组织不同的功能协同运行</p>\n" +
                "<div class=\"imageblock\">\n" +
                "<div class=\"content\">\n" +
                "<img src=\"https://doc-1256053707.cos.ap-beijing.myqcloud.com/20190614170054.png\" alt=\"20190614170054\">\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>所以我们可以使用一个名为 <code>PmtETLProcessor</code> 的类代表针对 <code>数据集 A</code> 到 <code>数据集 B</code> 的转换, 然后抽象出单位更小的负责具体某一个转换步骤的节点, 集成到 <code>PmtETLProcessor</code> 中, 共同完成任务</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\">参数配置</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>为了让程序行为更可控制, 所以一般会在编写程序之前先大致计划以下程序中可能使用到的一些参数</p>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p><code>Kudu</code> 的表名</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>Kudu</code> 表的复制因子</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p><code>ODS</code> 层的表名</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>规划好以后, 着手创建配置文件 <code>resource/kudu.conf</code></p>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\"># Server properties\n" +
                "kudu.common.master=\"192.168.169.101:7051,192.168.169.102:7051,192.168.169.103:7051\"\n" +
                "kudu.common.factor=1\n" +
                "\n" +
                "# Table name\n" +
                "kudu.name.pmt_ods=\"ODS_\"</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>Kudu</code> 的支持库</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"dlist\">\n" +
                "<dl>\n" +
                "<dt class=\"hdlist1\">为了方便 <code>Kudu</code> 的使用, 所以要创建一个 <code>Kudu</code> 的 <code>Helper</code>, 大致需求如下</dt>\n" +
                "<dd>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">需求</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">原始调用方式</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">理想调用方式</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">创建表</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>KuduContext.createTable()</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>SparkSession.createKuduTable()</code></p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">通过 <code>DataFrame</code> 将数据保存到 <code>Kudu</code> 表</p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>DataFrame.write.options(&#8230;&#8203;).kudu</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>DataFrame.saveAsKuduTable</code></p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>KuduHelper</code> 的设计</dt>\n" +
                "<dd>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>KuduHelper</code> 的设计思路两句话可以总结</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>尽可能的不在处理类中读取配置文件</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>尽可能的提供易于调用的接口</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">class KuduHelper {                                                            <i class=\"conum\" data-value=\"1\"></i><b>(1)</b>\n" +
                "  private var spark: SparkSession = _\n" +
                "  private var dataset: Dataset[Any] = _\n" +
                "\n" +
                "  def this(spark: SparkSession) = {                                           <i class=\"conum\" data-value=\"2\"></i><b>(2)</b>\n" +
                "    this()\n" +
                "    this.spark = spark\n" +
                "  }\n" +
                "\n" +
                "  def this(dataset: Dataset[Any]) = {                                         <i class=\"conum\" data-value=\"3\"></i><b>(3)</b>\n" +
                "    this(dataset.sparkSession)\n" +
                "    this.dataset = dataset\n" +
                "  }\n" +
                "\n" +
                "  private val config = ConfigFactory.load(\"kudu\")\n" +
                "  private val KUDU_MASTERS = config.getString(\"kudu.common.master\")\n" +
                "  private val kuduContext = new KuduContext(KUDU_MASTERS, spark.sparkContext) <i class=\"conum\" data-value=\"4\"></i><b>(4)</b>\n" +
                "\n" +
                "  def createKuduTable(tableName: String, schema: Schema): Unit = {            <i class=\"conum\" data-value=\"5\"></i><b>(5)</b>\n" +
                "    if (kuduContext.tableExists(tableName)) {\n" +
                "      kuduContext.deleteTable(tableName)\n" +
                "    }\n" +
                "\n" +
                "    import scala.collection.JavaConverters._\n" +
                "    val options = new CreateTableOptions()\n" +
                "      .setNumReplicas(config.getInt(\"kudu.common.factor\"))\n" +
                "      .addHashPartitions(List(\"uuid\").asJava, 6)\n" +
                "\n" +
                "    kuduContext.createTable(tableName, schema, options)\n" +
                "  }\n" +
                "\n" +
                "  def saveToKudu(tableName: String): Unit = {                                 <i class=\"conum\" data-value=\"6\"></i><b>(6)</b>\n" +
                "    import org.apache.kudu.spark.kudu._\n" +
                "\n" +
                "    dataset.write\n" +
                "      .option(\"kudu.table\", tableName)\n" +
                "      .option(\"kudu.master\", KUDU_MASTERS)\n" +
                "      .mode(SaveMode.Append)\n" +
                "      .kudu\n" +
                "  }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "object KuduHelper {\n" +
                "\n" +
                "  implicit def sparkToKuduContext(spark: SparkSession): Unit = {              <i class=\"conum\" data-value=\"7\"></i><b>(7)</b>\n" +
                "    new KuduHelper(spark)\n" +
                "  }\n" +
                "\n" +
                "  implicit def datasetToKuduContext(dataset: Dataset[Any]): Unit = {          <i class=\"conum\" data-value=\"8\"></i><b>(8)</b>\n" +
                "    new KuduHelper(dataset)\n" +
                "  }\n" +
                "\n" +
                "  def formattedDate(): String = {                                             <i class=\"conum\" data-value=\"9\"></i><b>(9)</b>\n" +
                "    FastDateFormat.getInstance(\"yyyyMMdd\").format(new Date)\n" +
                "  }\n" +
                "}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"colist arabic\">\n" +
                "<table>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"1\"></i><b>1</b></td>\n" +
                "<td>: 主题设计思路就是将 <code>SparkSession</code> 或者 <code>DataFrame</code> 隐式转换为 <code>KuduHelper</code>, 在 <code>KuduHelper</code> 中提供帮助方法</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"2\"></i><b>2</b></td>\n" +
                "<td>: 将 <code>SparkSession</code> 转为 <code>KuduHelper</code> 时调用</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"3\"></i><b>3</b></td>\n" +
                "<td>: 将 <code>Dataset</code> 转为 <code>KuduHelper</code> 时调用</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"4\"></i><b>4</b></td>\n" +
                "<td>: 在 <code>Helper</code> 内部读取配置文件, 创建 <code>KuduContext</code></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"5\"></i><b>5</b></td>\n" +
                "<td>: 此方法就是设计目标 <code>SparkSession.createKuduTable(tableName)</code> 中被调用的方法</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"6\"></i><b>6</b></td>\n" +
                "<td>: 此方法就是设计目标 <code>DataFrame.saveToKudu(tableName)</code> 中被调用的方法</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"7\"></i><b>7</b></td>\n" +
                "<td>: 将 <code>SparkSession</code> 转为 <code>KuduHelper</code></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"8\"></i><b>8</b></td>\n" +
                "<td>: 将 <code>Dataset</code> 转为 <code>KuduHelper</code></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"9\"></i><b>9</b></td>\n" +
                "<td>: 提供一个统一的生成日期的方法, 给外部使用</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "<dt class=\"hdlist1\"><code>ETL</code> 代码编写</dt>\n" +
                "<dd>\n" +
                "<div class=\"sidebarblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"olist arabic\">\n" +
                "<ol class=\"arabic\">\n" +
                "<li>\n" +
                "<p>创建 <code>PmtETLProcessor</code> 类</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>PmtETLProcessor</code> 类负责整个 <code>ETL</code> 过程, 但是不复杂中间过程中具体的数据处理, 具体数据如何转换, 要做什么事情由具体的某个 <code>Converter</code> 类负责</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">object PmtETLProcessor {\n" +
                "\n" +
                "  def main(args: Array[String]): Unit = {\n" +
                "    import com.itheima.dmp.utils.SparkConfigHelper._\n" +
                "    import com.itheima.dmp.utils.KuduHelper._\n" +
                "\n" +
                "    // 创建 SparkSession\n" +
                "    val spark = SparkSession.builder()\n" +
                "      .master(\"local[6]\")\n" +
                "      .appName(\"pmt_etl\")\n" +
                "      .loadConfig()\n" +
                "      .getOrCreate()\n" +
                "\n" +
                "    import spark.implicits._\n" +
                "\n" +
                "    // 读取数据\n" +
                "    val originDataset = spark.read.json(\"dataset/pmt.json\")\n" +
                "\n" +
                "  }\n" +
                "}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>创建 <code>IPConverter</code> 类处理 <code>IP</code> 转换的问题</p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>IPConverter</code> 主要解决如下问题</p>\n" +
                "</div>\n" +
                "<div class=\"ulist\">\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>原始数据集中有一个 <code>ip</code> 列, 要把 <code>ip</code> 这一列数据转为五列, 分别是 <code>ip</code>, <code>Longitude</code>, <code>latitude</code>, <code>region</code>, <code>city</code>, 从而扩充省市信息和经纬度信息</p>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>将新创建的四列数据添加到原数据集中</p>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-text hljs\" data-lang=\"text\">object IPConverter {\n" +
                "\n" +
                "  def process(dataset: Dataset[Row]): Dataset[Row] = {\n" +
                "    val dataConverted: RDD[Row] = dataset\n" +
                "      .rdd\n" +
                "      .mapPartitions(convertIPtoLocation)                                  <i class=\"conum\" data-value=\"1\"></i><b>(1)</b>\n" +
                "\n" +
                "    val schema = dataset.schema\n" +
                "      .add(\"region\", StringType)\n" +
                "      .add(\"city\", StringType)\n" +
                "      .add(\"longitude\", DoubleType)\n" +
                "      .add(\"latitude\", DoubleType)\n" +
                "\n" +
                "    val completeDataFrame = dataset\n" +
                "      .sparkSession\n" +
                "      .createDataFrame(dataConverted, schema)                              <i class=\"conum\" data-value=\"6\"></i><b>(6)</b>\n" +
                "\n" +
                "    completeDataFrame\n" +
                "  }\n" +
                "\n" +
                "  def convertIPtoLocation(iterator: Iterator[Row]): Iterator[Row] = {      <i class=\"conum\" data-value=\"2\"></i><b>(2)</b>\n" +
                "    val searcher = new DbSearcher(new DbConfig(), \"dataset/ip2region.db\")\n" +
                "\n" +
                "    val lookupService = new LookupService(\n" +
                "      \"dataset/GeoLiteCity.dat\",\n" +
                "      LookupService.GEOIP_MEMORY_CACHE)\n" +
                "\n" +
                "    iterator.map(row =&gt; {\n" +
                "      val ip = row.getAs[String](\"ip\")\n" +
                "\n" +
                "      val regionData = searcher.btreeSearch(ip).getRegion.split(\"\\\\|\")     <i class=\"conum\" data-value=\"3\"></i><b>(3)</b>\n" +
                "      val region = regionData(2)\n" +
                "      val city = regionData(3)\n" +
                "\n" +
                "      val location = lookupService.getLocation(ip)                         <i class=\"conum\" data-value=\"4\"></i><b>(4)</b>\n" +
                "      val longitude = location.longitude.toDouble\n" +
                "      val latitude = location.latitude.toDouble\n" +
                "\n" +
                "      val rowSeq = row.toSeq :+ region :+ city :+ longitude :+ latitude\n" +
                "      Row.fromSeq(rowSeq)                                                  <i class=\"conum\" data-value=\"5\"></i><b>(5)</b>\n" +
                "    })\n" +
                "  }\n" +
                "}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"colist arabic\">\n" +
                "<table>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"1\"></i><b>1</b></td>\n" +
                "<td>: 通过 <code>mapPartitions</code> 算子, 对每一个分区数据调用 <code>convertIPtoLocation</code> 进行转换, 需要注意的是, 这个地方已经被转为 <code>RDD</code> 了, 而不是 <code>DataFrame</code>, 因为 <code>DataFrame</code> 在转换中不能更改 <code>Schema</code></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"2\"></i><b>2</b></td>\n" +
                "<td>: <code>convertIPtoLocation</code> 主要做的事情是扩充原来的 <code>row</code>, 增加四个新的列</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"3\"></i><b>3</b></td>\n" +
                "<td>: 获取省市中文名</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"4\"></i><b>4</b></td>\n" +
                "<td>: 获取经纬度</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"5\"></i><b>5</b></td>\n" +
                "<td>: 根据原始 <code>row</code> 生成新的 <code>row</code>, 新的 <code>row</code> 中包含了省市和经纬度信息</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><i class=\"conum\" data-value=\"6\"></i><b>6</b></td>\n" +
                "<td>: 新的 <code>row</code> 对象的 <code>RDD</code> 结合 被扩充过的 <code>Schema</code>, 合并生成新的 <code>DataFrame</code> 返回给 <code>Processor</code></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>在 <code>PmtETLProcessor</code> 中调用 <code>IPConverter</code></p>\n" +
                "<div class=\"exampleblock\">\n" +
                "<div class=\"content\">\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-scala hljs\" data-lang=\"scala\">object PmtETLProcessor {\n" +
                "\n" +
                "  def main(args: Array[String]): Unit = {\n" +
                "    ...\n" +
                "\n" +
                "    val originDataset = spark.read.json(\"dataset/pmt.json\")\n" +
                "\n" +
                "    // 调用 IPConverter, 传入 originDataset, 生成包含经纬度和省市的 DataFrame\n" +
                "    val ipConvertedResult = IPConverter.process(originDataset)\n" +
                "\n" +
                "    // 要 Select 的列们, 用于组织要包含的结果集中的数据\n" +
                "    // 因为太多, 不再此处展示, 若要查看, 请移步代码工程\n" +
                "    val selectRows: Seq[Column] = Seq(...)\n" +
                "\n" +
                "    // 选中相应的列\n" +
                "    ipConvertedResult.select(selectRows:_*).show()\n" +
                "  }</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>通过以上的代码, 已经在数据集中扩展了地理位置相关的信息, 接下来可以存入 <code>Kudu</code> 了</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</dd>\n" +
                "</dl>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Hello</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "        </div>\n" +
                "      </div>";*/
        String html = "";

        String md = MarkdownUtils.renderMarkdown(html);

        System.out.println(md);

    }

}
