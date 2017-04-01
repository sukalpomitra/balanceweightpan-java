# balanceweightpan-java

<p>You have a two-pan balance. On each of the scales you can put either a weight or another two-pan balance. Given such a balance your task is to determine wheter it's possible to steady the main balance or not. Notice that the main balance won't hold still if on one of it's scales is a balance that is unstable.</p>
<h3>Input</h3>
<p>First line of the input contains number of tests <strong>t</strong> (t≤20). Each test consists of one line in format: <strong>[L,R]</strong> where L and R indicate left and right scales of the balance and may contain one of the following:</p>
<ul>
<li>integer from range <strong>1..10<sup>9</sup></strong>&nbsp;representing weight with the given mass</li>
<li>question mark, representing weight with unknown mass (which may be any multiple of&nbsp;1)</li>
<li>another balance in the same format (&nbsp;[L,R]&nbsp;)</li>
</ul>
<h3>Output</h3>
<p>For each test print <em>YES</em> if the balance can be stabilized or&nbsp;<em>NO</em> otherwise.</p>
<h3>Example</h3>
<pre><strong>Input:</strong></pre>
<pre>4
[3,?]
[?,[?,?]]
[[[?,?],5],?]
[[[5,?],10],[?,?]]

<strong>Output:</strong></pre>
<pre>YES
YES
NO
YES</pre>
